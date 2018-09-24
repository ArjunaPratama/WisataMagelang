package com.arjuna.wisatasemarang;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    public static String EX_Nama = "nama";
    public static  String EX_Lat = "Latitude";
    public  static  String EX_Long = "Longitude";
    double lat, longi;



    private static String BASE_URL = "https://maps.googleapis.com/maps/api/staticmap?center=";
    private static String END_URL = "&zoom=15&size=1000x500&maptype=hybrid&markers=color:red%7C";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ImageView mappnya = findViewById(R.id.mapnya);

        lat = getIntent().getDoubleExtra(EX_Lat, 0);
        longi = getIntent().getDoubleExtra(EX_Long, 0);

        Picasso.with(this)
                .load(BASE_URL + lat + "," + longi + END_URL + lat + "," + longi)
                .fit()
                .into(mappnya);




    }
}
