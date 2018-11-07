package com.example.aryane.srbcomercial.Service;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.strictmode.SqliteObjectLeakedViolation;

public class DataBaseUtil extends SQLiteOpenHelper {

    //NOME DA BASE DE DADOS
    private static final String NOME_BASE_DE_DADOS = "SISTEMA.db";

    //VERSÃO DO BANCO DE DADOS
    private static final int VERSAO_BASE_DE_DADOS = 1;

    //CONSTRUTOR
    public DataBaseUtil(Context context) {

        super(context, NOME_BASE_DE_DADOS, null, VERSAO_BASE_DE_DADOS);
    }

    /*NA INICIALIZAÇÃO DA CLASSE VAMOS CRIAR A TABELA QUE VAMOS USAR*/
    @Override
    public void onCreate(SQLiteDatabase db) {

        StringBuilder stringBuilderCreateTable = new StringBuilder();

        stringBuilderCreateTable.append(" CREATE TABLE tb_pessoa (");
        stringBuilderCreateTable.append("        id_pessoa      INTEGER PRIMARY KEY AUTOINCREMENT, ");
        stringBuilderCreateTable.append("        ds_nome        TEXT    NOT NULL,            ");
        stringBuilderCreateTable.append("        ds_endereco    TEXT    NOT NULL,            ");
        stringBuilderCreateTable.append("        ds_numero      TEXT    NOT NULL,            ");
        stringBuilderCreateTable.append("        ds_bairro      TEXT    NOT NULL,            ");
        stringBuilderCreateTable.append("        ds_cep         TEXT   NOT NULL,            ");
        stringBuilderCreateTable.append("        ds_cidade      TEXT    NOT NULL,            ");
        stringBuilderCreateTable.append("        ds_estado      TEXT    NOT NULL,            ");
        stringBuilderCreateTable.append("        ds_cpf         TEXT    NOT NULL,            ");
        stringBuilderCreateTable.append("        ds_ddd         INT     NOT NULL,            ");
        stringBuilderCreateTable.append("        ds_telefone     TEXT    NOT NULL,            ");
        stringBuilderCreateTable.append("        ds_email       TEXT    NOT NULL,            ");
        stringBuilderCreateTable.append("        fl_ativo       INT     NOT NULL )           ");


        db.execSQL(stringBuilderCreateTable.toString());

    }

    public void ondCreate(SQLiteDatabase db) {


        StringBuilder stringBuilderCreateTable = new StringBuilder();

        stringBuilderCreateTable.append(" CREATE TABLE tb_produto (");
        stringBuilderCreateTable.append("        id_produto      INTEGER PRIMARY KEY AUTOINCREMENT,  ");
        stringBuilderCreateTable.append("        pr_codigo          INTEGER                          ");
        stringBuilderCreateTable.append("        pr_ean             TEXT    NOT NULL,                ");
        stringBuilderCreateTable.append("        pr_nome            TEEXT   NOT NULL,                ");
        stringBuilderCreateTable.append("        pr_descricao       TEXT    NOT NULL,                ");
        stringBuilderCreateTable.append("        pr_categoria       TEXT    NOT NULL,                ");
        stringBuilderCreateTable.append("        pr_valor           TEXT    NOT NULL,                ");
        stringBuilderCreateTable.append("        pr_quantidade      TEXT    NOT NULL,                ");
        stringBuilderCreateTable.append("        pr_quantiDispon    TEXT    NOT NULL,                ");

        db.execSQL(stringBuilderCreateTable.toString());


    }

    /*SE TROCAR A VERSÃO DO BANCO DE DADOS VOCÊ PODE EXECUTAR ALGUMA ROTINA
      COMO CRIAR COLUNAS, EXCLUIR ENTRE OUTRAS */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXISTS tb_pessoa");
        db.execSQL("DROP TABLE IF EXISTS tb_produto");
        onCreate(db);

    }

   /*MÉTODO QUE VAMOS USAR NA CLASSE QUE VAI EXECUTAR AS ROTINAS NO
    BANCO DE DADOS*/
    public SQLiteDatabase GetConexaoDataBase(){

        return this.getWritableDatabase();
    }




}