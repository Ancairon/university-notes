package com.example.a11_1_lab;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    final int SHOW_PROGRESS_BAR = -1;

    final int HIDE_PROGRESS_BAR = -2;

    Handler workerHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        new Thread(new Runnable() {
            @Override
            public void run() {
                Looper.prepare();

                workerHandler = new Handler(Looper.myLooper()) {
                    @Override
                    public void handleMessage(@NonNull Message msg) {
                        Log.d("BUTTON", String.valueOf(msg.what));
                    }
                };
                Looper.loop();

            }
        }).start();

        EditText txt =
                findViewById(R.id.editText);

        findViewById(R.id.button2).setOnClickListener(v -> {

            String text = txt.getText().toString();
            workerHandler.sendEmptyMessage(Integer.parseInt(text));


        });


        ProgressBar progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.INVISIBLE);
        Button button = findViewById(R.id.button);
        Handler mainHandler = new Handler(getMainLooper()) {
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);
                int progress = msg.what;
                progressBar.setProgress(progress);


                switch (msg.what) {
                    case SHOW_PROGRESS_BAR:
                        progressBar.setVisibility(View.VISIBLE);
                        break;
                    case HIDE_PROGRESS_BAR:
                        progressBar.setVisibility(View.INVISIBLE);
                        break;
                }
            }
        };
        button.setOnClickListener(v -> {
            new Thread(() -> {
                mainHandler.sendEmptyMessage(SHOW_PROGRESS_BAR);
                //int progress = 0;
                for (int i = 0; i < 20; i++) {
                    try {
                        //progressBar.setProgress(i);
                        Thread.sleep(1000);
                        int finalI = i;
                        mainHandler.post(() -> {
                            progressBar.setProgress(finalI);
                        });
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                mainHandler.sendEmptyMessage(HIDE_PROGRESS_BAR);
            }).start();
        });


    }
}