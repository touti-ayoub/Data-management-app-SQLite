package com.example.ds2_sql;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class ListeProduit extends AppCompatActivity {

    ListView ls;
    Helper h= new Helper(ListeProduit.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste_produit);
        ls=findViewById(R.id.lst);

        Cursor c= h.getAllProducts();

        SimpleCursorAdapter adapter= new SimpleCursorAdapter(ListeProduit.this,R.layout.item,c,
                new String[]{c.getColumnName(0),c.getColumnName(1),c.getColumnName(2)},
                new int[]{R.id.id,R.id.nom,R.id.prix},1);
        ls.setAdapter(adapter);
        ls.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView t=view.findViewById(R.id.id);
                Intent x= new Intent(ListeProduit.this,DetailProduit.class);
                x.putExtra("id",t.getText().toString());
                startActivity(x);
            }
        });


    }
}