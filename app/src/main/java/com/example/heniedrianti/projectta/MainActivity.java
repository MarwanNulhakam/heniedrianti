package com.example.heniedrianti.projectta;

import android.content.Intent;
import android.database.Cursor;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.heniedrianti.projectta.connection.OnlineConnection;
import com.example.heniedrianti.projectta.database.DatabaseEngine;
import com.example.heniedrianti.projectta.variable.AllConstants;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initVariable();
        ipAddress ="192.168.43.64";

        /*
        * memeriksa apakah aplikasi sudah digunakan login
        * */
        de = new DatabaseEngine(this.getApplicationContext());
        Cursor c = de.executeQuery("SELECT nip FROM person");

        /*
        * jika sudah digunakan login, maka user tidak perlu login lagi. app akan mengarahkan tampilan ke menu utama
        * */
        if(c.getCount()!=0){
            startActivity(new Intent(MainActivity.this, menuawal.class));
            finish();
        }
    }
    public void login(View view) {
        AllConstants.SQLiteProperties.nip = nipField.getText().toString();
        initDB();
        Intent blogin = new Intent(MainActivity.this, menuawal.class);
        startActivity(blogin);
        finish();
    }
    public void register(View view){
        Log.d("action","register");
        Intent bregister = new Intent(MainActivity.this, register.class);
//        startActivity(bregister);
    }
    private void initDB(){
        //ambil data dosen
        new OnlineConnection(this,"http://"+ipAddress+"/select.php?nip="+nipField.getText().toString()).request("0","person",de);
        //ambil data mata kuliah
        new OnlineConnection(this,"http://"+ipAddress+"/dynamicQuery.php?query=SELECT%20matakuliah.namamatkul,%20matakuliah.sks,%20matakuliah.semester,%20mengajar.tahunakademik,%20mengajar.kelas,%20mengajar.statusmatakuliah%20FROM%20matakuliah%20LEFT%20JOIN%20mengajar%20ON%20matakuliah.id=mengajar.idmatakuliah%20where%20mengajar.nip%20=%20%27"+nipField.getText().toString()+"%27").request("0","mengajar",de);
        //ambil data skripsi
        new OnlineConnection(this,"http://"+ipAddress+"/dynamicQuery.php?query=SELECT%20all_data_on_table%20FROM%20skripsi%20WHERE%20pembimbingutama="+nipField.getText().toString()+"%20OR%20pembimbingpendamping="+nipField.getText().toString()+"%20OR%20pengujiutama="+nipField.getText().toString()+"%20OR%20penguji2="+nipField.getText().toString()+"%20OR%20penguji3="+nipField.getText().toString()+"").request("0","skripsi",de);
        //ambil data jurnal
        new OnlineConnection(this,"http://"+ipAddress+"/dynamicQuery.php?query=SELECT%20karyailmiah.id,ISN,tingkat,judul,tanggal,jenis,halaman,event,penerbit,volume,karyailmiah.posisi%20FROM%20jurnal%20LEFT%20JOIN%20karyailmiah%20ON%20jurnal.id%20=%20karyailmiah.idjurnal%20WHERE%20karyailmiah.nip%20=%20%27"+nipField.getText().toString()+"%27").request("0","jurnal",de);
        //ambil data kegiatan
        new OnlineConnection(this,"http://"+ipAddress+"/dynamicQuery.php?query=SELECT%20peran.id%20as%20idperan,kegiatan.uraian,kegiatan.tanggal,kegiatan.satuan,kegiatan.volume,kegiatan.statuskegiatan,peran.peran%20FROM%20kegiatan%20LEFT%20JOIN%20peran%20ON%20kegiatan.id%20=%20peran.idkegiatan%20WHERE%20peran.nip%20=%20"+nipField.getText().toString()).request("0","kegiatan",de);
        //ambil data jabatan
        new OnlineConnection(this,"http://"+ipAddress+"/dynamicQuery.php?query=SELECT%20id%20AS%20idjabatan,jabatan,divisi,lembaga,tanggalpelantikan%20FROM%20jabatan%20WHERE%20nip%20=%20"+nipField.getText().toString()).request("0","jabatan",de);
        //ambil data pembinaan
        new OnlineConnection(this,"http://"+ipAddress+"/dynamicQuery.php?query=SELECT%20id%20AS%20idpembinaan,kegiatan,waktu%20FROM%20pembinaan%20WHERE%20nip%20=%20"+nipField.getText().toString()).request("0","pembinaan",de);
        //ambil data karir akademik
        new OnlineConnection(this,"http://"+ipAddress+"/dynamicQuery.php?query=SELECT%20id,jenjang,tanggal,universitas%20FROM%20karirakademik%20WHERE%20nip%20=%20"+nipField.getText().toString()).request("0","karir",de);
    }

    private void initVariable(){
        nipField = (EditText)findViewById(R.id.eusername);
    }
    DatabaseEngine de;
    EditText nipField;
    private String ipAddress;
}

