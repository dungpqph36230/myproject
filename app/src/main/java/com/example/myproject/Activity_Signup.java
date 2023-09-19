package com.example.myproject;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.text.method.PasswordTransformationMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Activity_Signup extends AppCompatActivity {

    private DaoKhachHang daoKhachHang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        ImageView ic_cancle = findViewById(R.id.ic_cancle);
        EditText edt_name = findViewById(R.id.edt_name);
        EditText edt_email = findViewById(R.id.edt_email);
        EditText edt_pass = findViewById(R.id.edt_pass);
        CheckBox cb_check = findViewById(R.id.cb_check);
        Button btn_signup = findViewById(R.id.btn_signup);
        TextView txt_forgot = findViewById(R.id.txt_forgot);
        TextView txt_login = findViewById(R.id.txt_login);
        TextView txt_show = findViewById(R.id.txt_show);

        daoKhachHang = new DaoKhachHang(this);

        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = edt_name.getText().toString();
                String email = edt_email.getText().toString();
                String pass = edt_pass.getText().toString();

                boolean check = daoKhachHang.Register(name, email, pass);
                if (check){
                    Toast.makeText(Activity_Signup.this, "Đăng ký thành công", Toast.LENGTH_SHORT).show();
                    finish();
                }else {
                    Toast.makeText(Activity_Signup.this, "Đăng ký thất bại", Toast.LENGTH_SHORT).show();
                }
            }
        });

        txt_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Activity_Signup.this, Activity_Login.class));
            }
        });

        ic_cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        txt_forgot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialogForgot();
            }
        });

        txt_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edt_pass.getInputType() == InputType.TYPE_TEXT_VARIATION_PASSWORD) {
                    edt_pass.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    txt_show.setText("hide");
                } else {
                    edt_pass.setInputType(InputType.TYPE_CLASS_TEXT);
                    txt_show.setText("show");
                }
                // Di chuyển con trỏ về cuối EditText
                edt_pass.setSelection(edt_pass.getText().length());
            }
        });
    }

    private  void showDialogForgot(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_forgot, null);
        builder.setView(view);

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}