package com.example.myapplication;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button MyButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyButton = findViewById(R.id.button);
        MyButton.setOnClickListener(v -> switchActivities());

    }
    private void switchActivities() {
        Intent switchActivityIntent = new Intent(this, second_activity.class);
        startActivity(switchActivityIntent);
    }
}