/*
 * Copyright (c) 2017. Gilang Ramadhan (gilangramadhan96.gr@gmail.com)
 */

package id.codinate.aplikasimengenalbuah;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Gilang Ramadhan on 14/05/2017.
 */

public class Adapter extends ArrayAdapter {
    private final Activity activity;
    private final int[] gambar;
    private final String[] nama;
    public Adapter (Activity contex, int[] gambarbuah, String []namabuah){
        super(contex, R.layout.list_item, namabuah);
        this.activity = contex;
        this.gambar = gambarbuah;
        this.nama = namabuah;
    }
    // ketik getView pilih yang View
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = activity.getLayoutInflater();
        View v = layoutInflater.inflate(R.layout.list_item, null, true);
        TextView txtNama = (TextView) v.findViewById(R.id.textView);
        ImageView igGambar = (ImageView) v.findViewById(R.id.imageView);
        txtNama.setText(nama[position]);
        igGambar.setImageResource(gambar[position]);
        return v;
    }
}
