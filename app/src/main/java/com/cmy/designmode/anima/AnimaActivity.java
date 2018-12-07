package com.cmy.designmode.anima;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.cmy.designmode.R;

public class AnimaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anima);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_animator,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_anima_alpha:
                break;
            case R.id.menu_anima_translation:
                break;
            case R.id.menu_anima_rotate:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
