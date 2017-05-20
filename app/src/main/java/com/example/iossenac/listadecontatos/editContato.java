package com.example.iossenac.listadecontatos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class editContato extends AppCompatActivity {
    public static final int RESULT_EDIT=1;
    public static final int RESULT_DELETE=2;
    EditText editNome, editTel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_contato);
        Intent it = this.getIntent();
         editNome = (EditText) findViewById(R.id.editTextNome);
         editTel = (EditText) findViewById(R.id.editTextTel);
        //Contato contato = new Contato(editNome.getText().toString(),editTel.getText().toString());



        Contato contato = (Contato) it.getSerializableExtra("contato");

        editNome.setText(contato.getNome());
        editTel.setText(contato.getTelefone());
    }

    public void editContato(View v){

        Contato contato = new Contato(editNome.getText().toString(),
                editTel.getText().toString());
        Intent data = new Intent();
        data.putExtra("contato",contato);
        setResult(RESULT_EDIT,data);
        finish();
    }

    public void excluir(View view){
        setResult(RESULT_DELETE);
        finish();


    }

    public void cancelar(View view){
        finish();
    }
}
