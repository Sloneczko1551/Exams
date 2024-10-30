package com.example.gra_wkosci;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView[] images = {
                findViewById(R.id.img1),
                findViewById(R.id.img2),
                findViewById(R.id.img3),
                findViewById(R.id.img4),
                findViewById(R.id.img5),
        };

        TextView textViewRound = findViewById(R.id.textViewRound);
        TextView textViewScore = findViewById(R.id.textViewScore);

        Button startButton = findViewById(R.id.startButton);
        Button resetButton = findViewById(R.id.resetButton);

        final int[] score = {0};
        Random random = new Random();
        ArrayList<Integer> diceImages = new ArrayList<>(Arrays.asList(
                R.drawable.k1, R.drawable.k2, R.drawable.k3,
                R.drawable.k4, R.drawable.k5, R.drawable.k6
        ));

        startButton.setOnClickListener(v -> {
            ArrayList<Integer> rolledNumbers = new ArrayList<>();
            for (ImageView img : images) {
                int roll = random.nextInt(6) + 1;
                rolledNumbers.add(roll);
                img.setImageResource(diceImages.get(roll - 1));
            }
            int roundSum = calculateSum(rolledNumbers);
            textViewRound.setText("Suma w rundzie: " + roundSum);
            score[0] += roundSum;
            textViewScore.setText("Wynik gry: " + score[0]);
        });

        resetButton.setOnClickListener(v -> {
            textViewRound.setText("Suma w rundzie: 0");
            score[0] = 0;
            textViewScore.setText("Wynik gry: " + score[0]);
            for (ImageView img : images) {
                img.setImageResource(R.drawable.k6);
            }
        });
    }

    private int calculateSum(ArrayList<Integer> numbers) {
        HashMap<Integer, Integer> counts = new HashMap<>();
        for (int num : numbers) {
            counts.put(num, counts.getOrDefault(num, 0) + 1);
        }

        int sum = 0;
        for (int num : counts.keySet()) {
            if (counts.get(num) >= 2) {
                sum += num * counts.get(num);
            }
        }
        return sum;
    }
}