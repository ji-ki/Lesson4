package ru.mirea.feofanovoi.thread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView infoTextView = findViewById(R.id.threadTextMirea);
        Thread mainThread = Thread.currentThread();
        infoTextView.setText("Имя текущего потока: " + mainThread.getName());
// Меняем имя и выводим в текстовом поле
        mainThread.setName("МОЙ НОМЕР ГРУППЫ: XX, НОМЕР ПО СПИСКУ: XX, МОЙ ЛЮБИИМЫЙ ФИЛЬМ: XX");
        infoTextView.append("\n Новое имя потока: " + mainThread.getName());
        Log.d(MainActivity.class.getSimpleName(), "Stack: " + Arrays.toString(mainThread.getStackTrace()));
    }
    public void clickBtn(View view) {
        long endTime = System.currentTimeMillis()+20*1000;

        while (System.currentTimeMillis()<endTime){
            synchronized (this){
                try {
                    wait(endTime-System.currentTimeMillis());
                }catch (Exception e){
                    throw new RuntimeException(e);
                }
            }
        }
    }


}
