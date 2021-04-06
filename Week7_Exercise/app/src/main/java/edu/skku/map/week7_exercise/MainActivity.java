package edu.skku.map.week7_exercise;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText inputEditText = (EditText) findViewById(R.id.editTextInput);
        final Button searchButton = (Button) findViewById(R.id.buttonSearch);
        final TextView resultTextView = (TextView) findViewById(R.id.textViewResult);

        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputEditText.setEnabled(false);
                searchButton.setEnabled(false);
                String input = inputEditText.getText().toString();

                HttpUrl.Builder urlBuilder = HttpUrl.parse("http://www.omdbapi.com").newBuilder();
                urlBuilder.addQueryParameter("t", input);
                urlBuilder.addQueryParameter("apikey", "4c98502f");

                String url = urlBuilder.build().toString();
                Log.e("han", url);
                Request req = new Request.Builder()
                        .url(url)
                        .build();

                OkHttpClient client = new OkHttpClient();

                client.newCall(req).enqueue(new Callback() {
                    @Override
                    public void onFailure(@NotNull Call call, @NotNull IOException e) {
                        e.printStackTrace();
                        inputEditText.setEnabled(false);
                    }

                    @Override
                    public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                        final String resBodyString = response.body().string();
                        Gson gson = new GsonBuilder().create();
                        final Movie movie = gson.fromJson(resBodyString, Movie.class);

                        final String result = buildResultText(movie);

                        MainActivity.this.runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                resultTextView.setText(result);
                                inputEditText.setEnabled(true);
                                searchButton.setEnabled(true);
                            }
                        });
                    }
                });
            }
        });
    }

    private String buildResultText(Movie movie) {
        return "Title: " + movie.getTitle()
                + "\nYear: " + movie.getYear()
                + "\nReleased Date: " + movie.getReleased()
                + "\nRuntime: " + movie.getRuntime()
                + "\nGenre: " + movie.getGenre()
                + "\nIMDB Rating: " + movie.getImdbRating()
                + "\nMetascore: " + movie.getMetascore();
    }
}