package com.example.caraoucoroa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class ResultActivity extends AppCompatActivity {

    ImageView resultCoin, btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        getSupportActionBar().hide();

        resultCoin = findViewById(R.id.iv_result);
        btnBack = findViewById(R.id.btn_back);

        // Recovery the data ( random number ) that came from MainActivity
        Bundle bundle = getIntent().getExtras();
        int randomNumber = bundle.getInt("numberSorted");

        // Check if the number is 0 or 1 and set the image...
        if ( randomNumber == 0 ) {
            resultCoin.setImageResource(R.drawable.moeda_cara);
            Toast.makeText(this, "Cara ganhou!", Toast.LENGTH_SHORT).show();
        } else {
            resultCoin.setImageResource(R.drawable.moeda_coroa);
            Toast.makeText(this, "Coroa ganhou!", Toast.LENGTH_SHORT).show();
        }

        // Action to back to the MainActivity
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playAgain();
            }
        });

    }

    // Method to return to MainActivity
    public void playAgain() {
        Intent i = new Intent(ResultActivity.this, MainActivity.class);
        startActivity( i );
        finish();
    }

}
