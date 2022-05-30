package com.example.ds2_sql;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DetailProduit extends AppCompatActivity {

    EditText nom,prix;
    Button mod,sup;
    String id;
    Helper h=new Helper(DetailProduit.this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_produit);
        nom=findViewById(R.id.nom);
        prix=findViewById(R.id.prix);
        mod=findViewById(R.id.mod);
        sup=findViewById(R.id.sup);

        id=getIntent().getStringExtra("id");
        Produit p=h.getOneProduct(Integer.parseInt(id));

        nom.setText(p.getNom());
        prix.setText(String.valueOf(p.getPrix()));
        mod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Produit pr = new Produit(Integer.parseInt(id),nom.getText().toString(),Double.parseDouble(prix.getText().toString()));
                h.updateProduct(pr);
                Intent i= new Intent(DetailProduit.this,ListeProduit.class);
                startActivity(i);
            }
        });

        sup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                h.deleteProduct(Integer.parseInt(id));
                Intent i= new Intent(DetailProduit.this,ListeProduit.class);
                startActivity(i);
            }
        });


    }
}