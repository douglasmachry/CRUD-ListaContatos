package com.example.iossenac.listadecontatos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import android.widget.EditText;
import android.widget.Toast;


public class cadastrarContato extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastrar_contato);
    }

    public void cadastrarContato(View view){



        EditText editNome = (EditText) findViewById(R.id.editNome);
        EditText editTel = (EditText) findViewById(R.id.editTel);

        Contato contato = new Contato(editNome.getText().toString(),
                editTel.getText().toString());

        Intent intent = new Intent(this, cadastrarContato.class);
        intent.putExtra("contato",contato);
        setResult(RESULT_OK,intent);
        finish();
    }



    public void limpar(View view){
        EditText editNome = (EditText) findViewById(R.id.editNome);
        EditText editTel = (EditText) findViewById(R.id.editTel);

        editNome.setText("");
        editTel.setText("");
    }

    public void cancelar(View view){
        finish();
    }
}
