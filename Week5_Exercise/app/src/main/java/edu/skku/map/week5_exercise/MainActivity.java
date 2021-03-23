package edu.skku.map.week5_exercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText idEditText = (EditText) findViewById(R.id.editTextTextId);
        final EditText passwordEditText = (EditText) findViewById(R.id.editTextTextPassword);
        final Button loginButton = (Button) findViewById(R.id.buttonLogin);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (idEditText.getText().toString().equals("MAP") && passwordEditText.getText().toString().equals("weloveprofessor")) {
                    Intent intent = new Intent(MainActivity.this, CallingSearchingActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "wrong", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}