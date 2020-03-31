package it.lorenzocotti.trisapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        //passo l'int winner alla second activity direttamente da quella principale
        Intent mIntent = getIntent();
        int winner = mIntent.getIntExtra("winner", 0);

        final TextView myTextView = (TextView)findViewById(R.id.vittoria);

        Button buttonReset = (Button)findViewById(R.id.reset);
        buttonReset.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), MainActivity.class);
                view.getContext().startActivity(intent);
            }
        });

        if (winner == 1) {

            myTextView.setText(R.string.vittoriaUno);

        }
        if (winner == 2) {

            myTextView.setText(R.string.vittoriaDue);

        }
    }
}