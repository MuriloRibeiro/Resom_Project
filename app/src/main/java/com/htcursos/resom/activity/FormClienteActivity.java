package com.htcursos.resom.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.htcursos.resom.Model.Client;
import com.htcursos.resom.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FormClienteActivity extends AppCompatActivity{

    private static final int INTENT_CAMERA = 123;

    @Bind(R.id.inputNome)
    EditText inputNome;
    @Bind(R.id.inputEmail)
    EditText inputEmail;
    @Bind(R.id.inputCel)
    EditText inputCel;
    @Bind(R.id.inputCpf)
    EditText inputCpf;
    @Bind(R.id.imagemCliente)
    ImageView imageViewCliente;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.form_cliente);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnSalvarCliente)
    public void salvarCliente(){

        //Montar o Cliente

        Client cli = new Client();
        cli.setName(inputNome.getText().toString());
        cli.setCelular(inputCel.getText().toString());
        cli.setCPF(inputCpf.getText().toString());
        cli.setEmail(inputEmail.getText().toString());
        //cli.setImage(imageViewCliente.getId());
        // Salvar o cliente no banco
        if(cli.save()){
            Toast.makeText(this,"Cliente Salvo!",Toast.LENGTH_SHORT).show();
        }


        Intent intent = new Intent(FormClienteActivity.this, ConfirmacaoClienteActivity.class);
        intent.putExtra("cliente", cli);
        startActivity(intent);

    }
    @OnClick(R.id.imagemCliente)
    public void abrir_camera() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent,INTENT_CAMERA);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == INTENT_CAMERA){
            if(resultCode == RESULT_OK){
                Bitmap foto = (Bitmap) data.getExtras().get("data");
                imageViewCliente.setImageBitmap(foto);
            }
        }
    }
}



