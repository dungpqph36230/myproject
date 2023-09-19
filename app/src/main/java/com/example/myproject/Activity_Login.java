package com.example.myproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Activity_Login extends AppCompatActivity {

    private DaoKhachHang daoKhachHang;

    private boolean chec_show = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText edt_email = findViewById(R.id.edt_email);
        EditText edt_pass = findViewById(R.id.edt_pass);
        Button btn_login = findViewById(R.id.btn_login);
        TextView txt_show = findViewById(R.id.txt_show);
        TextView txt_forgot = findViewById(R.id.txt_forgot);

        daoKhachHang = new DaoKhachHang(this);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = edt_email.getText().toString();
                String pass = edt_pass.getText().toString();

                boolean check = daoKhachHang.CheckLogin(email, pass);

                if (check || email.equals("1") && pass.equals("1")) {
                    Toast.makeText(Activity_Login.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Activity_Login.this, MainActivity.class));
                } else {
                    Toast.makeText(Activity_Login.this, "Đăng nhập thất bại", Toast.LENGTH_SHORT).show();
                }
            }
        });
//        txt_show.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//               chec_show =!chec_show;
//                if (edt_pass.getInputType() == InputType.TYPE_TEXT_VARIATION_PASSWORD) {
//                    edt_pass.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
//                    edt_pass.setTransformationMethod(null);
//                    txt_show.setText("show");
//                } else {
//                    edt_pass.setInputType(InputType.TYPE_CLASS_TEXT);
//                    edt_pass.setTransformationMethod(new PasswordTransformationMethod());
//                    txt_show.setText("hide");
//                }
//                // Di chuyển con trỏ về cuối EditText
//                edt_pass.setSelection(edt_pass.getText().length());
//            }
//        });
        txt_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chec_show = !chec_show;//tao 1 bien boolean để check khi clik vào nút show trên màn hình
                //Click lần 1 chec_show = false - thay đổi inputtupe của edittext thành hiển thị - text thành show
                //Click lần 2 chec_show = true - khác với click lần 1 thay đổi inputtipe thành password - text thành Hide
                   if (chec_show) {
                    txt_show.setText("Show");
                    edt_pass.setInputType(InputType.TYPE_CLASS_TEXT);
                } else {
                    edt_pass.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    txt_show.setText("Hide");
                }
            }
        });
    }
}