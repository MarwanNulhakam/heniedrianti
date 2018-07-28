package com.example.heniedrianti.projectta;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.heniedrianti.projectta.database.DatabaseEngine;

public class identitas extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_identitas);

        initComp();
        DatabaseEngine de = new DatabaseEngine(getApplicationContext());

    }

    private void initComp(){
        txtNip = (TextView)findViewById(R.id.txtnip);
        txtNama = (TextView)findViewById(R.id.txtnama);
        txtPangkat = (TextView)findViewById(R.id.txtpangkat);
        txtKarpeg = (TextView)findViewById(R.id.txtkarpeg);
        txtTempatLahir = (TextView)findViewById(R.id.txtt4);
        txtTanggalLahir = (TextView)findViewById(R.id.txttgl);
        txtJenisKelamin = (TextView)findViewById(R.id.txtgen);
        txtJabatan = (TextView)findViewById(R.id.txtjabatan);
        txtPendidikanTerakhir = (TextView)findViewById(R.id.txtpend);
        txtUnitKerja = (TextView)findViewById(R.id.txtunit);
    }

    private void setValue(String[]data){
        txtNip.setText(data[0]);
        txtNama.setText(data[1]);
        txtPangkat.setText(data[2]);
        txtKarpeg.setText(data[3]);
        txtTempatLahir.setText(data[4]);
        txtTanggalLahir.setText(data[5]);
        txtJenisKelamin.setText(data[6]);
        txtJabatan.setText(data[7]);
        txtPendidikanTerakhir.setText(data[8]);
        txtUnitKerja.setText(data[9]);
    }

    TextView txtNip;
    TextView txtNama;
    TextView txtPangkat;
    TextView txtTempatLahir;
    TextView txtTanggalLahir;
    TextView txtKarpeg;
    TextView txtJenisKelamin;
    TextView txtJabatan;
    TextView txtPendidikanTerakhir;
    TextView txtUnitKerja;

}
