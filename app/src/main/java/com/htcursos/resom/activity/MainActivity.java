package com.htcursos.resom.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import com.htcursos.resom.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.titulo)
    TextView titulo;
    @Bind(R.id.btn_start)
    Button btnStart;
    @Bind(R.id.btn_list)
    Button btnList;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_start)
    public void click() {
        Intent intent = new Intent(MainActivity.this, FormClienteActivity.class);
        startActivity(intent);
        finish();
    }

    @OnClick(R.id.btn_list)
    public void irparalistaCliente() {
        Intent intent = new Intent(MainActivity.this, ListaClienteActivity.class);
        startActivity(intent);
        finish();
    }

}
