package com.example.tp_android;

import android.content.Intent;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class Form2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form2);
        EditText editTextNom = findViewById(R.id.editTextNom);
        EditText editTextPrenom = findViewById(R.id.editTextPrenom);
        EditText editTextTelephone = findViewById(R.id.telephone);
        Button button = findViewById(R.id.Envoyer);


        button.setOnClickListener(view -> {
            String nom = editTextNom.getText().toString();
            String prenom = editTextPrenom.getText().toString();
            String tel = editTextTelephone.getText().toString();

            Intent intent = new Intent(Form2.this, Form2Result.class);
            intent.putExtra("nom", nom);
            intent.putExtra("prenom", prenom);
            intent.putExtra("telephone", tel);
            startActivity(intent);
        });
    }
}
