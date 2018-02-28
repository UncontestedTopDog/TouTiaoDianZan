package com.example.administrator.flexiblesearchbar;

import android.app.Service;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    MyView myView ;
    Vibrator vibrator ;
    MyList recyclerView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        vibrator = (Vibrator) getSystemService(Service.VIBRATOR_SERVICE);
        myView = findViewById(R.id.my_view);
        recyclerView = findViewById(R.id.recycler);
        recyclerView.bindData(myView,vibrator);
    }
}