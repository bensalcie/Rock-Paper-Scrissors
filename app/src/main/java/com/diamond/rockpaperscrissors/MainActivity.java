package com.diamond.rockpaperscrissors;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private String selectedSymbol ="";
    private ImageButton btnRock,btnPaper,btnScissors,btn2Rock,btn2Paper,btn2Scissors;
    private TextView tvComputerSelection;
    private Button btnReplay,btnPlayAgain;
    private LinearLayout computerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnRock= findViewById(R.id.btnRock);
        btnPaper= findViewById(R.id.btnPaper);
        btnScissors = findViewById(R.id.btnScissors);

        btn2Rock= findViewById(R.id.btn2Rock);
        btn2Paper= findViewById(R.id.btn2Paper);
        btn2Scissors = findViewById(R.id.btn2Scissors);
        tvComputerSelection = findViewById(R.id.tvComputerSelection);
        btnReplay= findViewById(R.id.btnReplay);
        btnPlayAgain= findViewById(R.id.btnPlayAgain);

        computerLayout = findViewById(R.id.computerLayout);
        initGame();
    }

    private void initGame() {
        int computerSelected = computerPlay();
        if (computerSelected==1){
            selectedSymbol ="Rock";
        }else  if (computerSelected==2){
            selectedSymbol="Paper";
        }else if (computerSelected==3){
            selectedSymbol="Scissors";
        }
        //1==>Rock
        //2==>Paper
        //3==>Scissors.

        btnRock.setOnClickListener(v -> playGame(1,computerSelected,selectedSymbol));
        btnPaper.setOnClickListener(v -> playGame(2,computerSelected,selectedSymbol));
        btnScissors.setOnClickListener(v -> playGame(3,computerSelected,selectedSymbol));



    }

    private void playGame(int userselection, int computerSelection, String selectedSymbol) {
        //1==>Rock
        //2==>Paper
        //3==>Scissors.
        if (userselection==1 && computerSelection==3 || userselection==3 && computerSelection==1){
            if (userselection ==1){

                Toast.makeText(this, "You won", Toast.LENGTH_SHORT).show();

            }else {
                Toast.makeText(this, "Computer won", Toast.LENGTH_SHORT).show();
            }
            tvComputerSelection.setVisibility(View.VISIBLE);
            tvComputerSelection.setText("Computer Selection: "+selectedSymbol);
            btnPlayAgain.setVisibility(View.VISIBLE);
            btnPlayAgain.setOnClickListener(v -> {
                tvComputerSelection.setVisibility(View.GONE);
                btnReplay.setVisibility(View.GONE);
                computerLayout.setVisibility(View.GONE);
                initGame();
                btnPlayAgain.setVisibility(View.GONE);

            });

        }
        if (userselection==3 && computerSelection==2 || userselection==2 && computerSelection==3){
            if (userselection == 3){
                Toast.makeText(this, "You won", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(this, "Computer won", Toast.LENGTH_SHORT).show();
            }
            tvComputerSelection.setVisibility(View.VISIBLE);
            tvComputerSelection.setText("Computer Selection: "+selectedSymbol);
            btnPlayAgain.setVisibility(View.VISIBLE);
            btnPlayAgain.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    tvComputerSelection.setVisibility(View.GONE);
                    btnReplay.setVisibility(View.GONE);
                    computerLayout.setVisibility(View.GONE);
                    initGame();
                    btnPlayAgain.setVisibility(View.GONE);

                }
            });


        }
        if (userselection==2 && computerSelection==1 || userselection==1 && computerSelection==2){
            if (userselection ==2){
                Toast.makeText(this, "You won", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(this, "Computer won", Toast.LENGTH_SHORT).show();
            }
            tvComputerSelection.setVisibility(View.VISIBLE);
            tvComputerSelection.setText("Computer Selection: "+selectedSymbol);
            btnPlayAgain.setVisibility(View.VISIBLE);
            btnPlayAgain.setOnClickListener(v -> {
                tvComputerSelection.setVisibility(View.GONE);
                btnReplay.setVisibility(View.GONE);
                computerLayout.setVisibility(View.GONE);
                initGame();
                btnPlayAgain.setVisibility(View.GONE);

            });


        }

        if (userselection==computerSelection){
            Toast.makeText(this, "Replay GAME", Toast.LENGTH_SHORT).show();
            btnReplay.setVisibility(View.VISIBLE);
            btnReplay.setOnClickListener(v -> {
                tvComputerSelection.setVisibility(View.GONE);
                btnReplay.setVisibility(View.GONE);
                computerLayout.setVisibility(View.GONE);
                initGame();

            });
        }

        //1==>Rock
        //2==>Paper
        //3==>Scissors.
        computerLayout.setVisibility(View.VISIBLE);
        if (computerSelection==1){

            btn2Rock.setVisibility(View.VISIBLE);
            btn2Paper.setVisibility(View.INVISIBLE);
            btn2Scissors.setVisibility(View.INVISIBLE);


        }else  if (computerSelection==2){
            btn2Rock.setVisibility(View.INVISIBLE);
            btn2Paper.setVisibility(View.VISIBLE);
            btn2Scissors.setVisibility(View.INVISIBLE);
        }else if (computerSelection==3){
            btn2Rock.setVisibility(View.INVISIBLE);
            btn2Paper.setVisibility(View.INVISIBLE);
            btn2Scissors.setVisibility(View.VISIBLE);
        }



    }

    private int computerPlay() {
        Random rand = new Random();
        return rand.nextInt(3)+1;
    }
}