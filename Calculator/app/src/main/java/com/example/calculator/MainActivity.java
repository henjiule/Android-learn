package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn_clean,btn_del,btn_divide,btn_0,btn_1,btn_2,btn_3,btn_4,btn_5,btn_6,btn_7,btn_8,btn_9,
            btn_multiply,btn_add,btn_minus,btn_point,btn_equal;
    TextView textView;
    boolean clear_flag;  //清空标识
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);
        btn_0 = findViewById(R.id.btn0); //初始化
        btn_1 = findViewById(R.id.btn1);
        btn_2 = findViewById(R.id.btn2);
        btn_3 = findViewById(R.id.btn3);
        btn_4 = findViewById(R.id.btn4);
        btn_5 = findViewById(R.id.btn5);
        btn_6 = findViewById(R.id.btn6);
        btn_7 = findViewById(R.id.btn7);
        btn_8 = findViewById(R.id.btn8);
        btn_9 = findViewById(R.id.btn9);
        btn_multiply = findViewById(R.id.btn_multiply);
        btn_divide = findViewById(R.id.btn_divide);
        btn_add = findViewById(R.id.btn_add);
        btn_minus = findViewById(R.id.btn_minus);
        btn_point = findViewById(R.id.btn_point);
        btn_del =findViewById(R.id.btn_del);
        btn_equal = findViewById(R.id.btn_equal);
        btn_clean = findViewById(R.id.btn_clean);

        textView = findViewById(R.id.textView);

        btn_0.setOnClickListener(this); //设置按钮的点击事件
        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);
        btn_3.setOnClickListener(this);
        btn_4.setOnClickListener(this);
        btn_5.setOnClickListener(this);
        btn_6.setOnClickListener(this);
        btn_7.setOnClickListener(this);
        btn_8.setOnClickListener(this);
        btn_9.setOnClickListener(this);
        btn_minus.setOnClickListener(this);
        btn_multiply.setOnClickListener(this);
        btn_del.setOnClickListener(this);
        btn_divide.setOnClickListener(this);
        btn_point.setOnClickListener(this);
        btn_add.setOnClickListener(this);
        btn_equal.setOnClickListener(this);
        btn_clean.setOnClickListener(this);
    }

    public void onClick(View v) {
        String str = textView.getText().toString();
        switch(v.getId ()){
            case R.id.btn0:
            case R.id.btn1:
            case R.id.btn2:
            case R.id.btn3:
            case R.id.btn4:
            case R.id.btn5:
            case R.id.btn6:
            case R.id.btn7:
            case R.id.btn8:
            case R.id.btn9:
            case R.id.btnpoint:
                if(clear_flag){
                    clear_flag=false;
                    str="";
                    textView.setText ("");
                }
                textView.setText(str+((Button)v).getText ());
                break;

            case R.id.btn_add:
            case R.id.btn_minus:
            case R.id.btn_multiply:
            case R.id.btn_divide:
                if(clear_flag){
                    clear_flag=false;
                    textView.setText("");
                }
                textView.setText(str+" "+((Button)v).getText()+" ");
                break;
            case R.id.btn_del:
                if(clear_flag){
                    clear_flag=false;
                    textView.setText ("");
                }else if (str != null && !str.equals ("")){
                    textView.setText(str.substring(0,str.length()-1)); //删除一个字符
                }
                break;
            case R.id.btn_clean:
                clear_flag=false;
                str = "";
                textView.setText(""); //清空文本内容
                break;
            case R.id.btn_equal:
                getResult(); //获取结果
                break;
        }
    }

    private void getResult() {  //算法
        String s = textView.getText().toString();
        if(s == null || s.equals ("")){
            return;
        }
        if (!s.contains ("")){
            return;
        }
        if (clear_flag){
            clear_flag=false;
            return;
        }
        clear_flag=true;

        String str1 = s.substring(0,s.indexOf(" "));  // 获取到运算符前面的字符
        String str_y = s.substring(s.indexOf(" ")+1,s.indexOf(" ")+2); //获取到运算符
        String str2 = s.substring(s.indexOf(" ")+ 3);  //获取到运算符后面的字符

        double result = 0;
        if (!str1.equals ("") && !str2.equals ("")){
            double num1 = Double.parseDouble(str1); //将str1、str2强制转化为double类型
            double num2 = Double.parseDouble(str2);

            if (str_y.equals ("+")){
                result = num1 + num2;
            }else if (str_y.equals ("-")){
                result = num1 - num2;
            }else if (str_y.equals ("÷")){
                if (num2 == 0){
                    result = 0;
                }else {
                    result = num1/num2;
                }
            }else if (str_y.equals ("*")){
                result = num1*num2;
            }
            if (!str1.contains (".") && !str2.contains (".") && !s.equals ("÷")){
                int k = (int) result; //强制转换
                textView.setText (k);
            }else{
                textView.setText (result+"");
            }
        }else if (!str1.equals ("") && str2.equals ("")){
            textView.setText (s);
        }else if (str1.equals ("") && !str2.equals ("")){
            double num2 = Double.parseDouble(str2);
            if (s.equals ("+")){
                result = 0 + num2;
            }else if (s.equals("-")){
                result = 0 - num2;
            }else if (s.equals("×")){
                result = 0;
            }else if (s.equals("÷")){
                result = 0;
            }
            if (!str2.contains (".")) {
                int r = (int) result;
                textView.setText (r + "");
            } else {
                textView.setText (result + "");
            }
        } else {
            textView.setText ("");
        }
    }
}