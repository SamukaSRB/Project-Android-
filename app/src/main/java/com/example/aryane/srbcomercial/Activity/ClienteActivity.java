package com.example.aryane.srbcomercial.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.aryane.srbcomercial.Dao.ClienteDao;
import com.example.aryane.srbcomercial.Model.ClienteModel;
import com.example.aryane.srbcomercial.R;
import com.example.aryane.srbcomercial.Uteis.Alertas;


public class ClienteActivity extends AppCompatActivity {


    EditText         editTextNome;
    EditText         editTextEndereco;
    EditText         editTextNumero;
    EditText         editTextBairro;
    EditText         editTextCep;
    EditText         editTextCidade;
    EditText         editTextEstado;
    EditText         editTextCpf;
    EditText         editTextDdd;
    EditText         editTextTelefone;
    EditText         editTextEmail;
    CheckBox         checkBoxRegistroAtivo;
    Button           btnCadastrar;
    Button           btnConsultar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cliente);
        this.criarCompoentes();
        this.criarEventos();

    }

    protected  void  criarCompoentes(){

        editTextNome= (EditText) this.findViewById(R.id.editTextNome);

        editTextEndereco= (EditText) this.findViewById(R.id.editTextEndereco);

        editTextNumero= (EditText)this.findViewById(R.id.editTextNumero);

        editTextBairro = (EditText) this.findViewById(R.id.editTextBairro);

        editTextCep = (EditText) this.findViewById(R.id.editTextCep);

        editTextCidade = (EditText) this.findViewById(R.id.editTextCidade);

        editTextEstado = (EditText) this.findViewById(R.id.editTextEstado);

        editTextCpf  = (EditText) this.findViewById(R.id.editTextCpf);

        editTextDdd = (EditText) this.findViewById(R.id.editTextDdd);

        editTextTelefone = (EditText) this.findViewById(R.id.editTextTelefone);

        editTextEmail = (EditText) this.findViewById(R.id.editTextEmail);

        checkBoxRegistroAtivo  = (CheckBox)this.findViewById(R.id.checkBoxRegistroAtivo);

        btnCadastrar = (Button) this.findViewById(R.id.btnCadastrar);



    }

    protected  void criarEventos(){

        btnCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Salvar_onClick();
            }
        });


    }
    protected  void Salvar_onClick() {

        if (editTextNome.getText().toString().trim().equals("")) {

            Alertas.Alert(this, this.getString(R.string.nome_obrigatorio));
            editTextNome.requestFocus();

        } else if (editTextEndereco.getText().toString().trim().equals("")) {
            Alertas.Alert(this, this.getString(R.string.endereco_obrigatorio));
            editTextEndereco.requestFocus();
        } else if (editTextNumero.getText().toString().trim().equals("")) {
            Alertas.Alert(this, this.getString(R.string.numero_obrigatorio));
            editTextNumero.requestFocus();
        } else if (editTextBairro.getText().toString().trim().equals("")) {
            Alertas.Alert(this, this.getString(R.string.bairro_obrigatorio));
            editTextBairro.requestFocus();
        }else if (editTextCep.getText().toString().trim().equals("")) {
            Alertas.Alert(this, this.getString(R.string.cep_obrigatorio));
            editTextCep.requestFocus();
        }else if (editTextCidade.getText().toString().trim().equals("")) {
            Alertas.Alert(this, this.getString(R.string.cidade_obrigatorio));
            editTextCidade.requestFocus();
        } else if (editTextEstado.getText().toString().trim().equals("")) {
            Alertas.Alert(this, this.getString(R.string.estado_obrigatorio));
            editTextEstado.requestFocus();
        }else if (editTextCpf.getText().toString().trim().equals("")) {
            Alertas.Alert(this, this.getString(R.string.cpf_obrigatorio));
            editTextCpf.requestFocus();
        }  else if (editTextDdd.getText().toString().trim().equals("")) {
            Alertas.Alert(this, this.getString(R.string.ddd_obrigatorio));
            editTextDdd.requestFocus();
        }else if (editTextTelefone.getText().toString().trim().equals("")) {
            Alertas.Alert(this, this.getString(R.string.telefone_obrigatorio));
            editTextTelefone.requestFocus();
        }       else if (editTextEmail.getText().toString().trim().equals("")) {
            Alertas.Alert(this, this.getString(R.string.email_obrigatorio));
            editTextEmail.requestFocus();
        }
        else{

            ClienteModel clienteModel = new ClienteModel();

            //setar os valores

            clienteModel.setNome(editTextNome.getText().toString().trim());
            clienteModel.setEndereco(editTextEndereco.getText().toString().trim());
            clienteModel.setNumero(editTextNumero.getText().toString().trim());
            clienteModel.setBairro(editTextBairro.getText().toString().trim());
            clienteModel.setCep(editTextCep.getText().toString().trim());
            clienteModel.setCidade(editTextCidade.getText().toString().trim());
            clienteModel.setEstado(editTextEstado.getText().toString().trim());
            clienteModel.setDdd(editTextDdd.getText().toString().trim());
            clienteModel.setTelefone(editTextTelefone.getText().toString().trim());
            clienteModel.setEmail(editTextEmail.getText().toString().trim());
            clienteModel.setCpf(editTextCpf.getText().toString().trim());


            clienteModel.setRegistroAtivo((byte)0);

            if(checkBoxRegistroAtivo.isChecked())
                clienteModel.setRegistroAtivo((byte)1);

            new ClienteDao(this).Salvar(clienteModel);
            Alertas.Alert(this,this.getString(R.string.registro_salvo_com_sucesso));

        }


    }



}
