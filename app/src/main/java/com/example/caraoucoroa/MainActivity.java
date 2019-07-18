package com.example.caraoucoroa;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {


    // ImageView variable created.
    ImageView btnPlay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();



        // Recovery the reference of button play and attach it to the imageView variable
        btnPlay = findViewById(R.id.btn_play);


        // Build the button action, which is sort number 0 or 1 and passing this result to the ResultActivity
        btnPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Generate a random number
                int randomNumber = generateRandomNumber();

                // Start the result activity passing the random number
                Intent i = new Intent(MainActivity.this, ResultActivity.class);
                i.putExtra("numberSorted", randomNumber);
                startActivity( i );
                finish();
            }
        });
    }


    // This method generates a random number between 0 and 1.
    public int generateRandomNumber(){
        Random r = new Random();
        int randomNumber = r.nextInt(2);
        return randomNumber;
    }
}
