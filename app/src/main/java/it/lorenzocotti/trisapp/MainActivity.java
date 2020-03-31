package it.lorenzocotti.trisapp;

import androidx.annotation.StringRes;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public Button b1, b2, b3, b4, b5, b6, b7, b8, b9, reset, multi_computer, multi_locale;
    private static int conta = 0;
    private  int choice = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        b1 = findViewById(R.id.b1);
        b2 = findViewById(R.id.b2);
        b3 = findViewById(R.id.b3);
        b4 = findViewById(R.id.b4);
        b5 = findViewById(R.id.b5);
        b6 = findViewById(R.id.b6);
        b7 = findViewById(R.id.b7);
        b8 = findViewById(R.id.b8);
        b9 = findViewById(R.id.b9);

        b1.setEnabled(false);
        b2.setEnabled(false);
        b3.setEnabled(false);
        b4.setEnabled(false);
        b5.setEnabled(false);
        b6.setEnabled(false);
        b7.setEnabled(false);
        b8.setEnabled(false);
        b9.setEnabled(false);

        Button buttonLocalPlay = (Button)findViewById(R.id.multi_locale);
        Button buttonComputerPlay = (Button)findViewById(R.id.multi_computer);
        Button buttonReset = (Button)findViewById(R.id.reset);

        buttonComputerPlay.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                choice = 1;
                b1.setEnabled(true);
                b2.setEnabled(true);
                b3.setEnabled(true);
                b4.setEnabled(true);
                b5.setEnabled(true);
                b6.setEnabled(true);
                b7.setEnabled(true);
                b8.setEnabled(true);
                b9.setEnabled(true);
            }
        });

        buttonLocalPlay.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                choice = 2;
                b1.setEnabled(true);
                b2.setEnabled(true);
                b3.setEnabled(true);
                b4.setEnabled(true);
                b5.setEnabled(true);
                b6.setEnabled(true);
                b7.setEnabled(true);
                b8.setEnabled(true);
                b9.setEnabled(true);
            }
        });

        buttonReset.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = getIntent();
                finish();
                startActivity(intent);
            }
        });



    }


    public void clickOnButton(View view) {
        Button button = (Button) view;
        int id = button.getId();
        int cell = 0;
        conta++;

        switch (id) {

            case R.id.b1:
                cell = 1;
                break;
            case R.id.b2:
                cell = 2;
                break;
            case R.id.b3:
                cell = 3;
                break;
            case R.id.b4:
                cell = 4;
                break;
            case R.id.b5:
                cell = 5;
                break;
            case R.id.b6:
                cell = 6;
                break;
            case R.id.b7:
                cell = 7;
                break;
            case R.id.b8:
                cell = 8;
                break;
            case R.id.b9:
                cell = 9;
                break;

        }

        startGame(cell, button);
    }



    List<Integer> player1 = new ArrayList<>();
    List<Integer> player2 = new ArrayList<>();
    int onlinePlayer = 1;  //turno giocatore 1 o giocatore 2?

    private void startGame(int cell, Button button) {

        if(onlinePlayer == 1) {    //turno gioc.1
            String mystring = button.getResources().getString(R.string.cross_sign);
            button.setText(mystring);
            button.setTextSize(30);
            button.setBackgroundResource(R.color.giocatore1);
            player1.add(cell);   //cell viene occupata da player1
            onlinePlayer = 2;
            if (choice == 1) {
                multiplayer();
            }
        } else {
            String mystring = button.getResources().getString(R.string.square_sign);
            button.setText(mystring);
            button.setTextSize(30);
            button.setBackgroundResource(R.color.giocatore2);
            player2.add(cell);
            onlinePlayer = 1;
        }

        button.setEnabled(false);
        checkWinner();
    }


    private void multiplayer() {
        if (conta<10/2) {
            List<Integer> emptyCell = new ArrayList<>();

            for (int i = 1; i < 10; i++) {     //per 9 caselle
                if (!(player1.contains(i) || player2.contains(i))) {
                    emptyCell.add(i);
                }
            }

            Random random = new Random();
            int rIndex = random.nextInt(emptyCell.size());  //in base a numero celle vuote genera numero casuale all'interno di quel range di valori
            int cellID = emptyCell.get(rIndex);  //prende quel numero

            Button b = null;

            switch (cellID) {

                case 1:
                    b = b1;
                    break;

                case 2:
                    b = b2;
                    break;

                case 3:
                    b = b3;
                    break;

                case 4:
                    b = b4;
                    break;

                case 5:
                    b = b5;
                    break;

                case 6:
                    b = b6;
                    break;

                case 7:
                    b = b7;
                    break;

                case 8:
                    b = b8;
                    break;

                case 9:
                    b = b9;
                    break;
            }

            startGame(cellID, b);
        }
    }

    private void checkWinner() {
        int winner = 0;

        //prima riga gestita
        if (player1.contains(1) && player1.contains(2) && player1.contains(3)) {
            winner = 1;
        } else if (player2.contains(1) && player2.contains(2) && player2.contains(3)) {
            winner = 2;
        }

        //seconda riga gestita
        if (player1.contains(4) && player1.contains(5) && player1.contains(6)) {
            winner = 1;
        } else if (player2.contains(4) && player2.contains(5) && player2.contains(6)) {
            winner = 2;
        }

        //terza riga gestita
        if (player1.contains(7) && player1.contains(8) && player1.contains(9)) {
            winner = 1;
        } else if (player2.contains(7) && player2.contains(8) && player2.contains(9)) {
            winner = 2;
        }

        //prima colonna
        if (player1.contains(1) && player1.contains(4) && player1.contains(7)) {
            winner = 1;
        } else if (player2.contains(1) && player2.contains(4) && player2.contains(7)) {
            winner = 2;
        }

        //seconda colonna
        if (player1.contains(2) && player1.contains(5) && player1.contains(8)) {
            winner = 1;
        } else if (player2.contains(2) && player2.contains(5) && player2.contains(8)) {
            winner = 2;
        }

        //terza colonna
        if (player1.contains(3) && player1.contains(6) && player1.contains(9)) {
            winner = 1;
        } else if (player2.contains(3) && player2.contains(6) && player2.contains(9)) {
            winner = 2;
        }

        //prima diagonale
        if (player1.contains(1) && player1.contains(5) && player1.contains(9)) {
            winner = 1;
        } else if (player2.contains(1) && player2.contains(5) && player2.contains(9)) {
            winner = 2;
        }

        //seconda diagonale
        if (player1.contains(3) && player1.contains(5) && player1.contains(7)) {
            winner = 1;
        } else if (player2.contains(3) && player2.contains(5) && player2.contains(7)) {
            winner = 2;
        }

        if (winner != 0) {      //chiedere a prof come passare winner alla second activity
            if(winner == 1 || winner == 2) {
                showVictoryScreen();
            }

            //blocco dei bottoni
            b1.setEnabled(false);
            b2.setEnabled(false);
            b3.setEnabled(false);
            b4.setEnabled(false);
            b5.setEnabled(false);
            b6.setEnabled(false);
            b7.setEnabled(false);
            b8.setEnabled(false);
            b9.setEnabled(false);
        }
    }

    public void showVictoryScreen () {
        Intent myIntent = new Intent(MainActivity.this, SecondActivity.class);
        MainActivity.this.startActivity(myIntent);
    }

}
