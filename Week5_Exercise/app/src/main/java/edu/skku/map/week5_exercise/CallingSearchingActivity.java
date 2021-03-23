package edu.skku.map.week5_exercise;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CallingSearchingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calling_searching);

        final EditText searchKeywordEditText = (EditText) findViewById(R.id.editTextTextSearchKeyword);
        final EditText phoneNumberEditText = (EditText) findViewById(R.id.editTextPhoneNumber);
        final Button searchButton = (Button) findViewById(R.id.buttonSearching);
        final Button callButton = (Button) findViewById(R.id.buttonCalling);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String searchKeyword = searchKeywordEditText.getText().toString();

                Intent webSearchIntent = new Intent(Intent.ACTION_WEB_SEARCH);
                webSearchIntent.putExtra(SearchManager.QUERY, searchKeyword);
                if (webSearchIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(webSearchIntent);
                }
            }
        });

        callButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = phoneNumberEditText.getText().toString();

                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:" + phoneNumber));
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
            }
        });
    }
}