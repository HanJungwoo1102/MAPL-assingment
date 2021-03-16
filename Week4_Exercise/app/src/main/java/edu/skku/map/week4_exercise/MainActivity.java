package edu.skku.map.week4_exercise;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ArrayList<Integer> INTEGERS_ZERO_TO_TEN = new ArrayList(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
        final ArrayList<Integer> TEN_SQUARE_NUMBERS = new ArrayList(Arrays.asList(2, 4, 8, 16, 32, 64, 128, 256, 512, 1024));
        final ArrayList<String> MY_INFO = new ArrayList(Arrays.asList("2016311595", "Jungwoo Han", "Department of Computer Science", "College of Software", "Sungkyunkwan University"));

        final ListView listView = (ListView)findViewById(R.id.listView);
        final Button button1 = (Button)findViewById(R.id.button1);
        final Button button2 = (Button)findViewById(R.id.button2);
        final Button button3 = (Button)findViewById(R.id.button3);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { adapt(listView, INTEGERS_ZERO_TO_TEN);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapt(listView, TEN_SQUARE_NUMBERS);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                adapt(listView, MY_INFO);
            }
        });
    }

    private void adapt(ListView listView, ArrayList arrayList) {
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList);

        listView.setAdapter(arrayAdapter);
    }
}