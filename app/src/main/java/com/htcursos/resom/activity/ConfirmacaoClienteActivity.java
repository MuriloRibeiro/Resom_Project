package com.htcursos.resom.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.htcursos.resom.Model.Client;
import com.htcursos.resom.R;

import java.io.Serializable;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ConfirmacaoClienteActivity extends AppCompatActivity{

    @Bind(R.id.textViewNome)
    TextView txtViewNome;
    @Bind(R.id.textViewEmail)
    TextView txtViewEmail;
    @Bind(R.id.textViewCpf)
    TextView txtViewCpf;
    @Bind(R.id.textViewCel)
    TextView txtViewCel;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.confirmacao_cliente);
        ButterKnife.bind(this );

        Client cliente = (Client) getIntent().getSerializableExtra("cliente");
        txtViewNome.setText("Nome: " + cliente.getName());
        txtViewEmail.setText("Email: " + cliente.getEmail());
        txtViewCpf.setText("CPF " + cliente.getCPF());
        txtViewCel.setText("Celular" + cliente.getCelular());
    }

    @OnClick(R.id.btnConfirmar)
    public void confirmar(){

        Intent intent = new Intent(ConfirmacaoClienteActivity.this, MainActivity.class);
        startActivity(intent);
        finish();

    }

    }


