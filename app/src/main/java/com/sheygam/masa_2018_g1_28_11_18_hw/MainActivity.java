package com.sheygam.masa_2018_g1_28_11_18_hw;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView nameTxt, emailTxt, phoneTxt;
    private Button nameBtn, emailBtn, phoneBtn;
    public static final int NAME_MODE = 0x01;
    public static final int EMAIL_MODE = 0x02;
    public static final int PHONE_MODE = 0x03;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nameBtn = findViewById(R.id.name_btn);
        emailBtn = findViewById(R.id.email_btn);
        phoneBtn = findViewById(R.id.phone_btn);

        nameTxt = findViewById(R.id.name_txt);
        emailTxt = findViewById(R.id.email_txt);
        phoneTxt = findViewById(R.id.phone_txt);

        nameBtn.setOnClickListener(this);
        emailBtn.setOnClickListener(this);
        phoneBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        Intent chooser;
        switch (v.getId()){
            case R.id.name_btn:
                intent = new Intent("edit.name");
                chooser = Intent.createChooser(intent,"Choice app");
                startActivityForResult(chooser,NAME_MODE);
                break;
            case R.id.email_btn:
                intent = new Intent("edit.email");
                chooser = Intent.createChooser(intent,"Choice app");
                startActivityForResult(chooser,EMAIL_MODE);
                break;
            case R.id.phone_btn:
                intent = new Intent("edit.phone");
                chooser = Intent.createChooser(intent,"Choice app");
                startActivityForResult(chooser,PHONE_MODE);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode == RESULT_OK){
            switch (requestCode){
                case NAME_MODE:
                    nameTxt.setText(data.getStringExtra("DATA"));
                    break;
                case EMAIL_MODE:
                    emailTxt.setText(data.getStringExtra("DATA"));
                    break;
                case PHONE_MODE:
                    phoneTxt.setText(data.getStringExtra("DATA"));
                    break;
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
