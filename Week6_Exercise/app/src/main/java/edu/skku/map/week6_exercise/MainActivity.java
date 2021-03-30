package edu.skku.map.week6_exercise;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    final double PI = 3.14159265;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button startButton = (Button) findViewById(R.id.buttonStart);
        final TextView resultTextView = (TextView) findViewById(R.id.textViewResult);

        final AsyncTask<Integer, Double, String> monteCarloSimulationAsyncTask = new AsyncTask<Integer, Double, String>() {
            @Override
            protected String doInBackground(Integer... integers) {
                MonteCarloEstimator estimator = new MonteCarloEstimator();

                for (int i = 0; i < integers[0]; i++) {
                    estimator.estimate();
                    double result = estimator.getResult();

                    if (Math.abs(result - PI) < 0.000001) break;

                    publishProgress(result);
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                return null;
            }

            @Override
            protected void onProgressUpdate(Double... doubles) {
                super.onProgressUpdate(doubles);

                resultTextView.setText(doubles[0].toString());
            }
        };

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startButton.setEnabled(false);

                monteCarloSimulationAsyncTask.execute(100);
            }
        });

    }
}