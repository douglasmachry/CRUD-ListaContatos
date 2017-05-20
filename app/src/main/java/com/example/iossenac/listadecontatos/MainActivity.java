package com.example.iossenac.listadecontatos;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private static final int REQ_CADASTRO=1;
    private static final int REQ_EDIT=2;

    List<Contato> listaC = new ArrayList<>();
    ContatoAdapter adaptador;
    int posicaoAlterar=-1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView) findViewById(R.id.listaContatos);

        listaC.add(new Contato("Douglas","12345678"));
        adaptador =  new ContatoAdapter(listaC,this);

        ListView lista = (ListView) findViewById(R.id.listaContatos);


        lista.setAdapter(adaptador);


        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Contato contato = listaC.get(position);
                        String nome = listaC.get(position).getNome();
                        String tel = listaC.get(position).getTelefone();
                        MainActivity.this.posicaoAlterar = position;

                        Intent it = new Intent(MainActivity.this, editContato.class);
                        it.putExtra("contato",contato);
                        startActivityForResult(it, 2);
                    }
                }
        );
    }

    public void novoContato(View view){
        Intent intent = new Intent(this, cadastrarContato.class);
        startActivityForResult(intent,1);
    };


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == REQ_CADASTRO){
            if(resultCode == RESULT_OK){
                Contato contato = (Contato) data.getSerializableExtra("contato");
                listaC.add(contato);
                adaptador.notifyDataSetChanged();
                Toast.makeText(this,"Cadastro realizada com sucesso!",Toast.LENGTH_SHORT)
                        .show();


            }

        }else if(requestCode == REQ_EDIT){
            if(resultCode == editContato.RESULT_EDIT){
                Contato contato = (Contato) data.getSerializableExtra("contato");
                listaC.set(this.posicaoAlterar,
                        contato);
                adaptador.notifyDataSetChanged();
                Toast.makeText(this,"Edicao realizada com sucesso!",Toast.LENGTH_SHORT)
                        .show();




            }else if(resultCode == editContato.RESULT_DELETE){
                listaC.remove(this.posicaoAlterar);
                adaptador.notifyDataSetChanged();
                Toast.makeText(this,"Exclusão realizada com sucesso!",Toast.LENGTH_SHORT)
                        .show();
            }
        }
    }
}


