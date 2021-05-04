package com.example.application;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.ExecutionException;

public class ActivityMet extends AppCompatActivity {

    private ImageView play4;

    String City = "Paris";

    String Key = "b698988189fc1e7436742aafb74184ab";

    String url = "http://api.openweathermap.org/data/2.5/weather?q=" + City +"&units=metric&appid="+Key;

    public class DownloadJSON extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... strings) {
            URL url;

            HttpURLConnection httpURLConnection;

            InputStream inputStream;

            InputStreamReader inputStreamReader;

            String result = "";

            try {
                url = new URL(strings[0]);

                httpURLConnection = (HttpURLConnection) url.openConnection();

                inputStream = httpURLConnection.getInputStream();

                inputStreamReader = new InputStreamReader(inputStream);

                int data = inputStreamReader.read();

                while (data != -1){

                    result += (char) data;

                    data = inputStreamReader.read();

                }


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return result;
        }
    }

    TextView txtCity,txtTime,txtValueFeeLike,txtValueHumidity,txtTemp;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_met);

        txtCity = findViewById(R.id.txtCity);
        txtTime = findViewById(R.id.txtTime);
        txtValueFeeLike = findViewById(R.id.txtTitleFeelLike);
        txtValueHumidity = findViewById(R.id.txtTitleHumidity);
        txtTemp = findViewById(R.id.txtTitleTemp);

        DownloadJSON downloadJSON = new DownloadJSON();

        try {

            String result = downloadJSON.execute(url).get();

            JSONObject jsonObject = new JSONObject(result);

            String temp = jsonObject.getJSONObject("main").getString("temp");

            String humidity = jsonObject.getJSONObject("main").getString("humidity");

            String feel_Like = jsonObject.getJSONObject("main").getString("feel_Like");

            Long time = jsonObject.getLong("dt");

            String sTime = new SimpleDateFormat("dd-M-yyyy hh:mm:ss", Locale.FRANCE)
                    .format(new Date(time* 1000));

            txtTime.setText(sTime);
            txtCity.setText(City);
            txtValueFeeLike.setText(feel_Like);
            txtValueHumidity.setText(humidity);
            txtTemp.setText(temp);



        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }


        this.play4 = (ImageView) findViewById(R.id.play4);

        play4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent otherActivity = new Intent(getApplicationContext(), Activity1.class );
                startActivity(otherActivity);
                finish();
            }
        });
    }
}