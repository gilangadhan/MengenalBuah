/*
 * Copyright (c) 2017. Gilang Ramadhan (gilangramadhan96.gr@gmail.com)
 */

package id.codinate.aplikasimengenalbuah;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    String[] nama = {"Alpukat", "Apel", "Ceri",
            "Durian", "Jambu Air", "Manggis",
            "Strawberry"};
    int[] gambar = {
            R.drawable.alpukat, R.drawable.apel, R.drawable.ceri,
            R.drawable.durian, R.drawable.jambuair, R.drawable.manggis,
            R.drawable.strawberry};
    @BindView(R.id.listView)
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Adapter adapter = new Adapter(this, gambar, nama);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent pindah = new Intent(MainActivity.this, DetailActivity.class);
                pindah.putExtra("gambar", String.valueOf(gambar[position]));
                pindah.putExtra("nama", nama[position]);
                pindah.putExtra("posisi", String.valueOf(position));
                startActivity(pindah);
            }
        });
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setTitle("Peringatan")
                .setMessage("Apakah kamu akan keluar?")
                .setPositiveButton("Iya", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                })
                .setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                }).show();
    }
}
