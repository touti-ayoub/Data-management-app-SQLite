package com.example.ds2_sql;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText nom, prix;
    Button b;
    Helper h=new Helper(MainActivity.this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nom=findViewById(R.id.nom);
        prix=findViewById(R.id.prix);
        b=findViewById(R.id.add);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(nom.getText().toString())) {
                    Toast.makeText(MainActivity.this, "vous devez entrer le nom de produit", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(prix.getText().toString())) {
                    Toast.makeText(MainActivity.this, "vous devez entrer le prix de produit", Toast.LENGTH_SHORT).show();
                } else {
                    Produit p = new Produit(nom.getText().toString(), Double.parseDouble(prix.getText().toString()));
                    h.insertProduct(p);

                    Intent i = new Intent(MainActivity.this, ListeProduit.class);
                    startActivity(i);
                }
            }
        });
    }
}