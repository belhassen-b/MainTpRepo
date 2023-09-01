package com.example.tpcalculatrice;

import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        TableLayout tableLayout = findViewById(R.id.main_table);
        for (int i = 0; i < tableLayout.getChildCount(); i++) {
            TableRow tableRow = (TableRow) tableLayout.getChildAt(i);
            for (int j = 0; j <tableRow.getChildCount() ; j++) {
                Button button = (Button) tableRow.getChildAt(j);
                button.setOnClickListener((e)->{
                    alertDialog.setMessage(((Button)e).getText()).create().show();
                });

            }

        }



    }
    }
