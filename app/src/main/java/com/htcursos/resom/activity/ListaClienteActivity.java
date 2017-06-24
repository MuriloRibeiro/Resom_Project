package com.htcursos.resom.activity;

import android.app.DownloadManager;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.htcursos.resom.Model.Client;
import com.htcursos.resom.R;
import com.htcursos.resom.adapter.ListaClienteAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import se.emilsjolander.sprinkles.Query;

/**
 * Created by Murilo Ribeiro on 17/06/2017.
 */

public class ListaClienteActivity extends AppCompatActivity {

    @Bind(R.id.listaCliente)
    ListView ListaCliente;

    List<Client> clientes = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_cliente);
        ButterKnife.bind(this);

        Client jao = new Client();
        jao.setName("jao da silva");
        jao.setEmail("jao@gmail.com");
        jao.setImage(R.mipmap.ic_launcher);

        Client maria = new Client();
        maria.setName("maria");
        maria.setEmail("maria@gmail.com");
        maria.setImage(R.mipmap.ic_launcher);

        Client zé = new Client();
        zé.setName("zé");
        zé.setEmail("zé@gmail.com");
        zé.setImage(R.mipmap.ic_launcher);

        clientes.add(jao);
        clientes.add(maria);
        clientes.add(zé);


        final ListaClienteAdapter adapter = new ListaClienteAdapter(this, clientes);
        ListaCliente.setAdapter(adapter);

        ListaCliente.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view,
                                           final int position, long id) {
                AlertDialog alert = new AlertDialog.Builder(ListaClienteActivity.this)
                        .setTitle("Deletar usuário")
                        .setMessage("Deseja deletar este usuário?")
                        .setNegativeButton("Não", null)
                        .setPositiveButton("Sim", new
                                DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface,
                                                        int i) {
                                        adapter.getItem(position).delete();
                                        adapter.remove(adapter.getItem(position));
                                        adapter.notifyDataSetChanged();
                                    }
                                }).show();
                return true;
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        ListaClienteAdapter adapter = new ListaClienteAdapter(this, Query.all(Client.class).get().asList());
    }


}
