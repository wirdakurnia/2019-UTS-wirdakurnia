package com.wirda61.wirdakurnia.sticker.activities.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.wirda61.wirdakurnia.sticker.R;
import com.wirda61.wirdakurnia.sticker.activities.helper.BottomNavigationViewHelper;

import java.util.ArrayList;

import static com.wirda61.wirdakurnia.sticker.activities.activities.ActivityAdd.sqLiteHelper;

public class ActivityDetail extends AppCompatActivity{
    TextView txtName, txtPrice;
    ImageView image;
    Button btnopen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        txtName = findViewById(R.id.txtName);
        txtPrice = findViewById(R.id.txtPrice);
        image = findViewById(R.id.imageFood);
        btnopen = findViewById(R.id.open_website_button);

        Intent intent = getIntent();
        String receivedName =  intent.getStringExtra("name");
        String receivedPrice =  intent.getStringExtra("price");
        Bundle extras = getIntent().getExtras();
        byte[] b = extras.getByteArray("image");
        Bitmap bmp = BitmapFactory.decodeByteArray(b, 0, b.length);

        txtName.setText(receivedName);
        txtPrice.setText(receivedPrice);
        image.setImageBitmap(bmp);

        btnopen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://id.pinterest.com/";
                Uri webpage = Uri.parse(url);
                Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
                if(intent.resolveActivity(getPackageManager()) != null){
                    startActivity(intent);
                }else {
                    Log.d("ImplicitIntents", "Can't handle this intent!");
                }
            }
        });

    }
}
