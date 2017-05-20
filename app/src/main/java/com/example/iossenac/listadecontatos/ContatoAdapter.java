package com.example.iossenac.listadecontatos;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by iossenac on 13/05/17.
 */

public class ContatoAdapter extends BaseAdapter{
    private List<Contato> listaContatos;
    private Context contexto;

    public ContatoAdapter(List<Contato> listaContatos, Context contexto) {
        this.listaContatos = listaContatos;
        this.contexto = contexto;
    }

    @Override
    public int getCount() {
        return listaContatos.size();
    }

    @Override
    public Object getItem(int position) {
        return listaContatos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Contato contato = listaContatos.get(position);

        LayoutInflater inflater = (LayoutInflater) contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.list_item,null);

        TextView textNome = (TextView) view.findViewById(R.id.textNome);
        textNome.setText(contato.getNome());

        TextView textTel = (TextView) view.findViewById(R.id.textTel);
        textTel.setText(contato.getTelefone());

        return view;
    }
}
