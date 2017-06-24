package com.htcursos.resom.adapter;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.htcursos.resom.Model.Client;
import com.htcursos.resom.R;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ListaClienteAdapter extends ArrayAdapter<Client> {

    public ListaClienteAdapter(@NonNull Context context, @NonNull List<Client> objects) {
        super(context, R.layout.item_lista_cliente, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder holder;
       if(convertView == null){
           convertView = View.inflate(getContext(),R.layout.item_lista_cliente,null);
            holder = new ViewHolder();
           ButterKnife.bind(holder, convertView);
           convertView.setTag(holder);
       }else{
        holder = (ViewHolder)convertView.getTag();
    }

        Client cliente = getItem(position);
        holder.nome.setText(cliente.getName());
        holder.email.setText(cliente.getEmail());
        holder.imagem.setImageResource(cliente.getImage());

        return convertView;


    }
    public class ViewHolder{
        @Bind(R.id.imagemItemListaCliente)
        ImageView imagem;
        @Bind(R.id.nomeItemListaCliente)
        TextView nome;
        @Bind(R.id.emailItemListaCiente)
        TextView email;
    }

}


