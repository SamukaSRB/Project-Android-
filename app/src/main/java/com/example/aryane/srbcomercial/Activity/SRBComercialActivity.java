package com.example.aryane.srbcomercial.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.aryane.srbcomercial.R;

public class SRBComercialActivity extends AppCompatActivity {
    Button btnProduto;
    Button btnCliente;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_srbcomercial);
        this.criarComponentes();
        this.criarEventos();
    }
    public void criarComponentes(){
        btnCliente = (Button)this.findViewById(R.id.btnCliente);
        btnProduto = (Button) this.findViewById(R.id.btnProduto);
    }
    public void criarEventos(){
        btnCliente.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent it = new Intent(SRBComercialActivity.this,ClienteActivity.class);
                startActivity(it);
            }
        });
        btnProduto.setOnClickListener(new View.OnClickListener(){


            @Override
            public void onClick(View v) {
                Intent it = new Intent(SRBComercialActivity.this,ProdutoActivity.class);
                startActivity(it);
            }
        });
    }
}