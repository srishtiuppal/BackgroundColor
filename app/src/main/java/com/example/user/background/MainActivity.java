package com.example.user.background;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //TextView result;
    ImageView img;
    TextView tv;
    Bitmap bit;

    //View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //   result = (TextView) findViewById(R.id.textView);
        // result.setText(R.string.hello);
        img = (ImageView) findViewById(R.id.imageView);
        tv = (TextView) findViewById(R.id.editText);

        img.setDrawingCacheEnabled(true);
        img.buildDrawingCache(true);

        img.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent motionevent) {
                if (motionevent.getAction() == MotionEvent.ACTION_DOWN || motionevent.getAction() == MotionEvent.ACTION_MOVE) {
                    bit = img.getDrawingCache();
                    int pixel = bit.getPixel((int) motionevent.getX(), (int) motionevent.getY());
                    int r = Color.red(pixel);
                    int g = Color.green(pixel);
                    int b = Color.blue(pixel);

                    tv.setBackgroundColor(Color.rgb(r, g, b));
                    tv.setText(r + g + b + "");
                }
                return true;
            }
        });
    }
}

