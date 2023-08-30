package com.example.myapplication;

import android.view.View;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private EditText nom;
    private EditText email;

    private Button validation;

    private RadioButton homme;

    private CheckBox option1;
    private CheckBox option2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_frame);

        validation = findViewById(R.id.valider);
        homme = findViewById(R.id.homme);

        validation.setOnClickListener(view -> {

            nom= findViewById(R.id.nom);
            email= findViewById(R.id.email);
            homme = findViewById(R.id.homme);
            option1 = findViewById(R.id.option1);
            option2 = findViewById(R.id.option2);

            String nomText = nom.getText().toString();
            String emailText = email.getText().toString();
            String genre = homme.isChecked() ? "Homme" : "Femme";
            String option = option1.isChecked() ? "Option 1" : "Option 2";


            String message = "Bonjour " + nomText + " vous êtes un(e) " + genre + " et votre email est " + emailText + " et vous avez choisi l'option " + option;

            // Toast permet d 'envoyer une information à l'utilisateur
            Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();


        });



    }
}