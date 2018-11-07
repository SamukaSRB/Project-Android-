package com.example.aryane.srbcomercial.Dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.example.aryane.srbcomercial.Model.ClienteModel;
import com.example.aryane.srbcomercial.Service.DataBaseUtil;

import java.util.ArrayList;
import java.util.List;


public class ClienteDao {

    DataBaseUtil databaseUtil;

    /***
     * CONSTRUTOR
     * @param context
     */
    public ClienteDao(Context context){

        databaseUtil =  new DataBaseUtil(context);

    }
    public void Salvar(ClienteModel clienteModel){

        ContentValues contentValues =  new ContentValues();
        /*MONTANDO OS PARAMETROS PARA SEREM SALVOS*/
        contentValues.put("ds_nome",       clienteModel.getNome());
        contentValues.put("ds_endereco",   clienteModel.getEndereco());
        contentValues.put("ds_numero",     clienteModel.getNumero());
        contentValues.put("ds_bairro",     clienteModel.getBairro());
        contentValues.put("ds_cep",        clienteModel.getCep());
        contentValues.put("ds_cidade",     clienteModel.getCidade());
        contentValues.put("ds_estado",     clienteModel.getEstado());
        contentValues.put("ds_cpf",        clienteModel.getCpf());
        contentValues.put("ds_ddd",        clienteModel.getDdd());
        contentValues.put("ds_telefone",   clienteModel.getTelefone());
        contentValues.put("ds_email",      clienteModel.getEstado());
        contentValues.put("fl_ativo",      clienteModel.getRegistroAtivo());


        /*EXECUTANDO INSERT DE UM NOVO REGISTRO*/
        databaseUtil.GetConexaoDataBase().insert("tb_pessoa",null,contentValues);

    }



    public ClienteModel GetCliente(int codigo){


        Cursor cursor =  databaseUtil.GetConexaoDataBase().rawQuery("SELECT * FROM tb_pessoa WHERE id_pessoa= "+ codigo,null);

        cursor.moveToFirst();

        ///CRIANDO UMA NOVA PESSOAS
        ClienteModel clienteModel =  new ClienteModel();

        //ADICIONANDO OS DADOS DA PESSOA
        clienteModel.setCodigo(cursor.getInt(cursor.getColumnIndex("id_pessoa")));
        clienteModel.setNome(cursor.getString(cursor.getColumnIndex("ds_nome")));
        clienteModel.setEndereco(cursor.getString(cursor.getColumnIndex("ds_endereco")));
        clienteModel.setNumero(cursor.getString(cursor.getColumnIndex("ds_numero")));
        clienteModel.setBairro(cursor.getString(cursor.getColumnIndex("ds_bairro")));
        clienteModel.setCep(cursor.getString(cursor.getColumnIndex("ds_cep")));
        clienteModel.setCidade(cursor.getString(cursor.getColumnIndex("ds_cidade")));
        clienteModel.setEstado(cursor.getString(cursor.getColumnIndex("ds_estado")));
        clienteModel.setEstado(cursor.getString(cursor.getColumnIndex("ds_cpf")));
        clienteModel.setDdd(cursor.getString(cursor.getColumnIndex("ds_ddd")));
        clienteModel.setTelefone(cursor.getString(cursor.getColumnIndex("ds_telefone")));
        clienteModel.setEmail(cursor.getString(cursor.getColumnIndex("ds_email")));
        clienteModel.setRegistroAtivo((byte)cursor.getShort(cursor.getColumnIndex("fl_ativo")));

        //RETORNANDO A PESSOA
        return clienteModel;

    }
    public List<ClienteModel> SelecionarTodos(){

        List<ClienteModel> cliente = new ArrayList<ClienteModel>();


        //MONTA A QUERY A SER EXECUTADA
        StringBuilder stringBuilderQuery = new StringBuilder();
        stringBuilderQuery.append(" SELECT id_pessoa,      ");
        stringBuilderQuery.append("        ds_nome,        ");
        stringBuilderQuery.append("        ds_endereco,    ");
        stringBuilderQuery.append("        ds_numero,      ");
        stringBuilderQuery.append("        ds_bairro,      ");
        stringBuilderQuery.append("        ds_cidade,      ");
        stringBuilderQuery.append("        ds_estado,      ");
        stringBuilderQuery.append("        ds_cpf,         ");
        stringBuilderQuery.append("        ds_ddd,         ");
        stringBuilderQuery.append("        ds_telefone,     ");
        stringBuilderQuery.append("        ds_email,       ");
        stringBuilderQuery.append("        fl_ativo        ");
        stringBuilderQuery.append("  FROM  tb_pessoa       ");
        stringBuilderQuery.append(" ORDER BY ds_nome       ");


        //CONSULTANDO OS REGISTROS CADASTRADOS
        Cursor cursor = databaseUtil.GetConexaoDataBase().rawQuery(stringBuilderQuery.toString(), null);

        /*POSICIONA O CURSOR NO PRIMEIRO REGISTRO*/
        cursor.moveToFirst();


        ClienteModel clienteModel;

        //REALIZA A LEITURA DOS REGISTROS ENQUANTO NÃO FOR O FIM DO CURSOR
        while (!cursor.isAfterLast()){

            /* CRIANDO UMA NOVA PESSOAS */
            clienteModel =  new ClienteModel();

            clienteModel.setCodigo(cursor.getInt(cursor.getColumnIndex("id_pessoa")));
            clienteModel.setNome(cursor.getString(cursor.getColumnIndex("ds_nome")));
            clienteModel.setEndereco(cursor.getString(cursor.getColumnIndex("ds_endereco")));
            clienteModel.setNumero(cursor.getString(cursor.getColumnIndex("ds_numero")));
            clienteModel.setBairro(cursor.getString(cursor.getColumnIndex("ds_bairro")));
            clienteModel.setCep(cursor.getString(cursor.getColumnIndex("ds_cep")));
            clienteModel.setCidade(cursor.getString(cursor.getColumnIndex("ds_cidade")));
            clienteModel.setEstado(cursor.getString(cursor.getColumnIndex("ds_estado")));
            clienteModel.setEstado(cursor.getString(cursor.getColumnIndex("ds_cpf")));
            clienteModel.setDdd(cursor.getString(cursor.getColumnIndex("ds_ddd")));
            clienteModel.setTelefone(cursor.getString(cursor.getColumnIndex("ds_telefone")));
            clienteModel.setEmail(cursor.getString(cursor.getColumnIndex("ds_email")));
            clienteModel.setRegistroAtivo((byte)cursor.getShort(cursor.getColumnIndex("fl_ativo")));


            //ADICIONANDO UMA PESSOA NA LISTA
            cliente.add(clienteModel);

            //VAI PARA O PRÓXIMO REGISTRO
            cursor.moveToNext();
        }

        //RETORNANDO A LISTA DE PESSOAS
        return cliente;

    }

    public Integer Excluir(int codigo){

        //EXCLUINDO  REGISTRO E RETORNANDO O NÚMERO DE LINHAS AFETADAS
        return databaseUtil.GetConexaoDataBase().delete("tb_pessoa","id_pessoa = ?", new String[]{Integer.toString(codigo)});
    }


}