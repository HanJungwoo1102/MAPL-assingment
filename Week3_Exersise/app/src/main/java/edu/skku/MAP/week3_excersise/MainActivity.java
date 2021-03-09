package edu.skku.MAP.week3_excersise;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class MainActivity extends AppCompatActivity {
    private final String STUDENT_ID = "2016311595";
    private final String STUDENT_NAME = "Jungwoo Han";
    private final ArrayList<Integer> IMAGE_RESOURCE_ID_LIST = new ArrayList(Arrays.asList(R.drawable.img_island_1, R.drawable.img_island_2, R.drawable.img_island_3));

    private TextView textView;
    private Button buttonTop, buttonBottom;
    private ImageView imageView;
    private Boolean isShownStudentId;
    private Iterator<Integer> imageResourceIdIterator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView)findViewById(R.id.textView);
        buttonTop = (Button)findViewById((R.id.button_student));
        buttonBottom = (Button)findViewById((R.id.button_image));
        imageView = (ImageView)findViewById(R.id.imageView);

        isShownStudentId = true;
        imageResourceIdIterator = IMAGE_RESOURCE_ID_LIST.iterator();

        changeStudentIdNameState(isShownStudentId);
        changeImageState();

        buttonTop.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Boolean newIsShownStudentId = !isShownStudentId;

                changeStudentIdNameState(newIsShownStudentId);
            }
        });

        buttonBottom.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeImageState();
            }
        });
    }

    private void changeStudentIdNameState(Boolean newIsShownStudentId) {
        if (newIsShownStudentId) {
            textView.setText(STUDENT_ID);
        } else {
            textView.setText(STUDENT_NAME);
        }

        isShownStudentId = newIsShownStudentId;
    }

    private void changeImageState() {
        if (!imageResourceIdIterator.hasNext()) {
            imageResourceIdIterator = IMAGE_RESOURCE_ID_LIST.iterator();
        }
        imageView.setImageResource(imageResourceIdIterator.next());
    }
}