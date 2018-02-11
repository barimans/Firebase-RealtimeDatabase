package com.example.brizz.budayabandung.DescriptionActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.brizz.budayabandung.Model.Budaya;
import com.example.brizz.budayabandung.R;

import java.io.InputStream;

public class DescriptionActivity extends AppCompatActivity {

    private TextView tvTitleDesc, tvDesc;
    private ImageView imageDesc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);

        tvTitleDesc = findViewById(R.id.get_title);
        tvDesc = findViewById(R.id.get_desc);
        imageDesc = findViewById(R.id.get_image);

        String getTitleData = getIntent().getStringExtra("send_title");
        tvTitleDesc.setText(getTitleData);
        String getDescData = getIntent().getStringExtra("send_desc");
        tvDesc.setText(getDescData);


        new DownloadImageTask((ImageView) findViewById(R.id.get_image))
                .execute(getIntent().getExtras().getString("send_image"));

    }

    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }
    }
}
