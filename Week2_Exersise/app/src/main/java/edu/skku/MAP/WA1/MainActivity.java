package edu.skku.MAP.WA1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btnHi, btnBye;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnHi = findViewById(R.id.button_hi);
        btnBye = findViewById(R.id.button_bye);

        btnHi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Hi, I am Han Jungwoo", Toast.LENGTH_SHORT).show();
            }
        });

        btnBye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Good bye, see you", Toast.LENGTH_SHORT).show();
            }
        });
    }
}