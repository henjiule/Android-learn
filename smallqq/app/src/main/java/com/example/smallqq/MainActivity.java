package com.example.smallqq;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText et_qqnum, et_qqpwd;
    private ImageView iv_login, et_delete_num, et_delete_pwd, et_pwd_see;
    private TextView tv_forgetpwd, tv_register;
    private String qq_numtext, qq_pwdtext;
    private boolean pwdCanSee;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findId();
        //qq账号输入状态监听
        et_qqnum.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    private void findId() {
    }
}