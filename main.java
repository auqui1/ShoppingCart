package com.example.gabri.lab7shoppingcart;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.graphics.Color;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handle();
            }

        };

        }

    void handle() {
        EditText qty1 = (EditText) findViewById(R.id.qty1);
        EditText qty2 = (EditText) findViewById(R.id.qty2);
        EditText uc1 = (EditText) findViewById(R.id.uc1);
        EditText uc2 = (EditText) findViewById(R.id.uc2);
        TextView output = (TextView) findViewById(R.id.output);
        ConstraintLayout myLayout = (ConstraintLayout) findViewById(R.id.myLayout);
        String s1="", s2="", s3="", s4="", s5="", s6="";
        Double d1=0.0,d2=0.0,d3=0.0, d4=0.0,subTotal=0.0, total=0.0;

        s1=qty1.getText().toString();
        s2=qty2.getText().toString();
        s3=uc1.getText().toString();
        s4=uc2.getText().toString();

        d1=Double.valueOf(s1);
        d2=Double.valueOf(s2);
        d3=Double.valueOf(s3);
        d4=Double.valueOf(s4);

        subTotal = d1*d3+d2*d4;
        total = subTotal*0.0875+subTotal;
        s5=String.format("%.2f",total);
        s6=String.format("%.2f",subTotal);

        output.setText("Your subtotal is $"+s6+"." +
                "\nYour grand total is $"+s5);

        if (total>1000.0) {
            myLayout.setBackgroundColor(Color.RED);
        } else if (total>500.0) {
            myLayout.setBackgroundColor(Color.BLUE);
        } else if (total>0.0) {
            myLayout.setBackgroundColor(Color.GREEN);
        }


    }

}
