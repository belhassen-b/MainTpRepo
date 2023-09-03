package com.example.tp_android;

import android.annotation.SuppressLint;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class Form2Result extends AppCompatActivity {

    private TextView textViewNom;
    private TextView textViewPrenom;
    private TextView textViewTelephone;

    private Button retour;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form2_result);

        TextView textViewName = findViewById(R.id.textViewNom);
        TextView textViewPrenom = findViewById(R.id.textViewPrenom);
        TextView textViewTelephone = findViewById(R.id.textViewTelephone);
        retour = findViewById(R.id.retour);

        if (getIntent().getExtras() != null) {
            String name = getIntent().getExtras().getString("nom");
            String prenom = getIntent().getExtras().getString("prenom");
            String telephone = getIntent().getExtras().getString("telephone");

            textViewName.setText(name);
            textViewPrenom.setText(prenom);
            textViewTelephone.setText(telephone);
        }

        retour.setOnClickListener((e) -> {
            onBackPressed();
        });

    }
}