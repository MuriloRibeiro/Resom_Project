package com.htcursos.resom.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.htcursos.resom.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ImageGridAdapter extends ArrayAdapter<Integer> {
    public ImageGridAdapter(Context context, Integer[] imageList) {
        super(context, R.layout.item_grid_fotos, imageList);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder holder;
        if (convertView == null) {
            convertView = View.inflate(getContext(), R.layout.item_grid_fotos, null);
            convertView.setLayoutParams(new GridView.LayoutParams(200, 200));
            holder = new ViewHolder();
            ButterKnife.bind(holder, convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        final Integer image = getItem(position);
        if(image != null){
            holder.image.setImageResource(image);
        }
        return convertView;
    }
    public class ViewHolder{
        @Bind(R.id.imagemItemGridFoto)
        ImageView image;
    }
}