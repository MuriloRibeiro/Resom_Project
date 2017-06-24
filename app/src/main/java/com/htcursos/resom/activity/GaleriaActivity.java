package com.htcursos.resom.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;

import com.htcursos.resom.R;
import com.htcursos.resom.adapter.ImageGridAdapter;

import butterknife.Bind;
import butterknife.ButterKnife;

public class GaleriaActivity extends AppCompatActivity{

    @Bind(R.id.fotosGrid)
    GridView grid;
    private Integer[] imageList = {
//            R.drawable.sample_2, R.drawable.sample_3,
//            R.drawable.sample_4, R.drawable.sample_5,
//            R.drawable.sample_6, R.drawable.sample_7,
//            R.drawable.sample_0, R.drawable.sample_1,
//            R.drawable.sample_2, R.drawable.sample_3,
//            R.drawable.sample_4, R.drawable.sample_5,
//            R.drawable.sample_6, R.drawable.sample_7,
//            R.drawable.sample_0, R.drawable.sample_1,
//            R.drawable.sample_2, R.drawable.sample_3,
//            R.drawable.sample_4, R.drawable.sample_5,
//            R.drawable.sample_6, R.drawable.sample_7
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fotos);
        ButterKnife.bind(this);
        ImageGridAdapter adapter = new ImageGridAdapter(this, imageList);
        grid.setAdapter(adapter);
    }
}
