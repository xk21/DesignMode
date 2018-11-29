package com.cmy.designmode;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.cmy.designmode.builder.method01.Builder;
import com.cmy.designmode.builder.method01.Director;
import com.cmy.designmode.builder.method02.HaiWeiBookBuilder;
import com.cmy.designmode.builder.method01.MacBookBuilder;

import java.util.Observable;
import java.util.Observer;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Observer
        Observable;

        setContentView(R.layout.activity_main);
        TextView text = findViewById(R.id.text);
        Builder builder = new MacBookBuilder();
        Director director = new Director(builder);
        director.construct("因特尔4核","100g内存");
        text.setText(builder.create().toString()+" \n"+
        new HaiWeiBookBuilder().buildBoard("激灵主机").buildDisplay("超级内存").buildOS().create().toString());

//        text.setText(new Ha().buildBoard("因特尔").buildDisplay("四核").buildOS().create().toString());
    }
}
