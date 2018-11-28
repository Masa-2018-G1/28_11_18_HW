package com.sheygam.masa_2018_g1_28_11_18_hw;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EditActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText inputName, inputEmail, inputPhone;
    private Button okBtn;
    private String action = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        inputName = findViewById(R.id.input_name);
        inputEmail = findViewById(R.id.input_email);
        inputPhone = findViewById(R.id.input_phone);
        okBtn = findViewById(R.id.ok_btn);

        Intent intent = getIntent();
        if(intent.getAction() != null){
            action = intent.getAction();
            switch (action){
                case "edit.name":
                    inputName.setVisibility(View.VISIBLE);
                    break;
                case "edit.email":
                    inputEmail.setVisibility(View.VISIBLE);
                    break;
                case "edit.phone":
                    inputPhone.setVisibility(View.VISIBLE);
                    break;
            }
        }

        okBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.ok_btn){
            String data = "";
            Intent intent;
            switch (action){
                case "edit.name":
                    data = inputName.getText().toString();
                    break;
                case  "edit.email":
                    data = inputEmail.getText().toString();
                    break;
                case "edit.phone":
                    data = inputPhone.getText().toString();
                    break;
            }
            intent = new Intent();
            intent.putExtra("DATA",data);
            setResult(RESULT_OK,intent);
            finish();
        }
    }
}
