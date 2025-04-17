package com.example.slip5_2_26_1;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ImageSwitcher imageSwitcher;
    private int[] images = {
            R.drawable.img,
            R.drawable.img_1,
            R.drawable.img_2
    };
    private int currentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageSwitcher = findViewById(R.id.imageSwitcher);
        Button btnNext = findViewById(R.id.btnNext);

        // Set the factory for creating ImageViews dynamically
        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(MainActivity.this);
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT));
                return imageView;
            }
        });


        // Set initial image
        imageSwitcher.setImageResource(images[currentIndex]);

        // Button click to switch image
        btnNext.setOnClickListener(v -> {
            currentIndex = (currentIndex + 1) % images.length;
            imageSwitcher.setImageResource(images[currentIndex]);
        });
    }
}

/*

//Construct image switcher using setFactory().
package com.example.imageswicher;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private int[] images = {R.drawable.image_01, R.drawable.image_02, R.drawable.image_03};
    private int currentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        Button btnNext = findViewById(R.id.btnNext);

        // Next Button Click
        btnNext.setOnClickListener(v -> {
            currentIndex = (currentIndex + 1) % images.length;
            imageView.setImageResource(images[currentIndex]);
        });
    }
}

 */