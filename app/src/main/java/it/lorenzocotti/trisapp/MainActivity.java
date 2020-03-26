package it.lorenzocotti.trisapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button b1, b2, b3, b4, b5, b6, b7, b8, b9;

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

    }

    public void clickOnButton(View view) {
        Button button = (Button) view;
        int id = button.getId();
        int cell = 0;

        switch (id) {

            case R.id.b1:
                Toast.makeText(getApplicationContext(), "b1", Toast.LENGTH_SHORT).show();
                cell = 1;
                break;
            case R.id.b2:
                Toast.makeText(getApplicationContext(), "b2", Toast.LENGTH_SHORT).show();
                cell = 2;
                break;
            case R.id.b3:
                Toast.makeText(getApplicationContext(), "b3", Toast.LENGTH_SHORT).show();
                cell = 3;
                break;
            case R.id.b4:
                Toast.makeText(getApplicationContext(), "b4", Toast.LENGTH_SHORT).show();
                cell = 4;
                break;
            case R.id.b5:
                Toast.makeText(getApplicationContext(), "b5", Toast.LENGTH_SHORT).show();
                cell = 5;
                break;
            case R.id.b6:
                Toast.makeText(getApplicationContext(), "b6", Toast.LENGTH_SHORT).show();
                cell = 6;
                break;
            case R.id.b7:
                Toast.makeText(getApplicationContext(), "b7", Toast.LENGTH_SHORT).show();
                cell = 7;
                break;
            case R.id.b8:
                Toast.makeText(getApplicationContext(), "b8", Toast.LENGTH_SHORT).show();
                cell = 8;
                break;
            case R.id.b9:
                Toast.makeText(getApplicationContext(), "b9", Toast.LENGTH_SHORT).show();
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
            button.setText("X");
            button.setBackgroundResource(R.color.giocatore1);
            player1.add(cell);   //cell viene occupata da player1
            onlinePlayer = 2;
            multiplayer();
        } else {
            button.setText("O");
            button.setBackgroundResource(R.color.giocatore2);
            player2.add(cell);
            onlinePlayer = 1;
        }

        button.setEnabled(false);
    }

    private void multiplayer() {
        List<Integer> emptyCell = new ArrayList<>();

        for (int i=1; i<10; i++) {     //per 9 caselle
            if(!(player1.contains(i) || player2.contains(i))) {
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
