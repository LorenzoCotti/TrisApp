package it.lorenzocotti.trisapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
        } else {
            button.setText("O");
            button.setBackgroundResource(R.color.giocatore2);
            player2.add(cell);
            onlinePlayer = 1;
        }

        button.setEnabled(false);
    }
}
