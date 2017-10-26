/*
 * Copyright (c) 2017. Gilang Ramadhan (gilangramadhan96.gr@gmail.com)
 */

package id.codinate.aplikasimengenalbuah;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DetailActivity extends AppCompatActivity {
    String posisi, nama, gambar;
    ImageView img;
    TextView txt;
    int[] suara = {R.raw.alpukat, R.raw.apel, R.raw.ceri,
            R.raw.durian, R.raw.jambuair, R.raw.manggis,
            R.raw.strawberry};
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.imgDetail)
    ImageView imgDetail;
    @BindView(R.id.txtDetail)
    TextView txtDetail;
    @BindView(R.id.fab)
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        nama = getIntent().getStringExtra("nama");
        gambar = getIntent().getStringExtra("gambar");
        posisi = getIntent().getStringExtra("posisi");
// pindah.putExtra("gambar", String.valueOf(gambar[position]));
        txt.setText(nama);
        img.setImageResource(Integer.parseInt(gambar));
        img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PlayMusik(posisi);
            }
        });
    }

    //    int[] suara ={R.raw.alpukat, R.raw.apel, R.raw.ceri,
//            R.raw.durian, R.raw.jambuair, R.raw.manggis,
//            R.raw.strawberry};
    private void PlayMusik(String posisi) {
        int i = Integer.parseInt(posisi);
        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + suara[i]);
        MediaPlayer Player = new MediaPlayer();
        Player.setAudioStreamType(AudioManager.STREAM_MUSIC);
        try {
            Player.setDataSource(getApplicationContext(), uri);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Player.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Player.start();
    }

    @OnClick({R.id.imgDetail, R.id.txtDetail, R.id.fab})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.imgDetail:
                break;
            case R.id.txtDetail:
                break;
            case R.id.fab:
                break;
        }
    }
}
