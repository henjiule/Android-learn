package com.example.d0201_layout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText input;
    Button btn_0;
    Button btn_1;
    Button btn_2;
    Button btn_3;
    Button btn_4;
    Button btn_5;
    Button btn_6;
    Button btn_7;
    Button btn_8;
    Button btn_9;
    Button btn_add;
    Button btn_minus;
    Button btn_mul;
    Button btn_div;
    Button btn_point;
    Button btn_equal;
    Button btn_del;//组件的定义
    boolean del_flag;   //清空标识
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input=(EditText)findViewById(R.id.input);
        btn_0=(Button)findViewById((R.id.button0));
        btn_1=(Button)findViewById((R.id.button1));
        btn_2=(Button)findViewById((R.id.button2));
        btn_3=(Button)findViewById((R.id.button3));
        btn_4=(Button)findViewById((R.id.button4));
        btn_5=(Button)findViewById((R.id.button5));
        btn_6=(Button)findViewById((R.id.button6));
        btn_7=(Button)findViewById((R.id.button7));
        btn_8=(Button)findViewById((R.id.button8));
        btn_9=(Button)findViewById((R.id.button9));
        btn_add=(Button)findViewById((R.id.button_add));
        btn_minus=(Button)findViewById((R.id.button_minus));
        btn_mul=(Button)findViewById((R.id.button_mul));
        btn_div=(Button)findViewById((R.id.button_div));
        btn_equal=(Button)findViewById((R.id.button_equal));
        btn_point=(Button)findViewById((R.id.button_point));
        btn_del=(Button)findViewById((R.id.button_delete));   //组件的获取
        btn_0.setOnClickListener(this);//设置按钮点击事件
        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);
        btn_3.setOnClickListener(this);
        btn_4.setOnClickListener(this);
        btn_5.setOnClickListener(this);
        btn_6.setOnClickListener(this);
        btn_7.setOnClickListener(this);
        btn_8.setOnClickListener(this);
        btn_9.setOnClickListener(this);
        btn_add.setOnClickListener(this);
        btn_minus.setOnClickListener(this);
        btn_mul.setOnClickListener(this);
        btn_div.setOnClickListener(this);
        btn_equal.setOnClickListener(this);
        btn_point.setOnClickListener(this);
        btn_del.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {  //按钮触发器的设置
        String str =input.getText().toString();
        switch (v.getId()){  //获取view的id,选择按钮
            case R.id.button0 :
            case R.id.button1 :
            case R.id.button2 :
            case R.id.button3 :
            case R.id.button4 :
            case R.id.button5 :
            case R.id.button6 :
            case R.id.button7 :
            case R.id.button8 :
            case R.id.button9 :
            case R.id.button_point :
                if (del_flag) {
                    del_flag = false;
                    str = "";
                    input.setText("");
                }
                input.setText(str+((Button)v).getText());
                break;
            case R.id.button_add :
            case R.id.button_minus:
            case R.id.button_mul:
            case R.id.button_div :
                if(del_flag){
                    del_flag=false;
                    str="";
                    input.setText("");
                }
                input.setText(str+" "+((Button)v).getText()+" ");
                break;

            case R.id.button_delete:
                del_flag=false;
                str="";
                input.setText("");
            case R.id.button_equal :
                getResult();
                break;
        }

    }

    private void getResult() {
        String exp =input.getText().toString();
        if(exp==null||exp.equals("")){  //exp为空
            return;
        }
        if(!exp.contains(" ")){
            return;
        }
        if(del_flag){
            del_flag=false;
            return;
        }
        del_flag=true;
        double result=0;
        String s1=exp.substring(0,exp.indexOf(" ")); // 获取输入的第一个数
        String op=exp.substring(exp.indexOf(" ")+1,exp.indexOf(" ")+2);//获取运算符
        String s2=exp.substring(exp.indexOf(" ")+3);// 获取输入的第二个数
        if(!s1.equals(" ")&&!s2.equals(" ")) { //s1,s2不为空
            double d1 = Double.parseDouble(s1); //把第一个数的字符串转化为数字
            double d2 = Double.parseDouble(s2);//把第二个数的字符串转化为数字
            if (op.equals("+")) {  //op为+，就进行加法运算
                result = d1 + d2;
            } else if (op.equals("-")) {//op为-，就进行减法运算
                result = d1 - d2;
            } else if (op.equals("*")) {//op为*，就进行乘法运算
                result = d1 * d2;
            } else if (op.equals("/")) {//op为/，就进行除法运算
                if (d2 == 0) {
                    result = 0;
                } else
                    result = d1 / d2;
            }
            if (s1.contains(".") && s2.contains(".")) {
                double r =  result;
                input.setText(r + "");
            } else
                input.setText(result + "");}
        else if (s1.equals(" ")&&!s2.equals(" ")){
            double d2=Double.parseDouble(s2);
            if (op.equals("+")) {
                result = 0 + d2;
            } else if (op.equals("-")) {
                result = 0 - d2;
            } else if (op.equals("*")) {
                result = 0;
            } else if (op.equals("/")) {
                result=0;
            }
            if (s2.contains(".")){
                double r= result;
                input.setText(r+"");
            } else {
                input.setText(result+"");
            }
        }else{
            input.setText("");
        }
    }
}

