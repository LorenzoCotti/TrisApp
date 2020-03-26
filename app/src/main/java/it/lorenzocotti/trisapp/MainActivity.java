package it.lorenzocotti.trisapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickOnButton(View view) {
        int id = view.getId();
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
    }
}
