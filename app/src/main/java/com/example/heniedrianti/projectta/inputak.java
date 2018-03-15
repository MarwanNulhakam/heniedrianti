package com.example.heniedrianti.projectta;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class inputak extends AppCompatActivity {
    private ExpandableListView expandableListView;
    //Sub unsur
    String[] parent = new String[]{"Pendidikan", "Pelaksanaan Pendidikan", "Pelaksanaan Penelitian","Pelaksanaan Pengabdian Kepada Masyarakat","Penunjang Kegiatan Akademik Dosen"};
    //Unsur
    String[] q1 = new String[]{"A. Pendidikann formal","B. Diklat Pra Jabatan"};
    String[] q2 = new String[]{"A. Melaksanakan perkuliahan/tutorial dan membimbing, menguji serta menyelenggarakan pendidikan di laboratorium, praktik kegiatan bengkel/studio/kebun pada fakultas/sekolah tinggi/Akademik/Politeknik sendiri pada fakultas lain dalam lingkungan Universitas/institut sendiri, maupun di luar perguruan tinggi sendiri secara melembaga tiap sks (paling banyak 12 sks)per semester", "B. Membimbing Seminar","C. Membimbing kuliah kerha nyata, praktek kerja nyata,praktek kerja lapangan","D. Membimbing dan ikut dalam menghasilkan disertasi, tesis, skripsi dan laporan akhir studi","E. Bertugas sebagai penguji tugas akhir","F. Membina kegiatan mahasiswa","G. Mengembangkan program kuliah","H. Mengembangkan bahan kuliah","I. Menyampaikan orasi ilmiah","J. Menduduki jabatan pimpinan perguruan tertinggi","K. Membimbing Akademik dosen yang lebih rendah jabatannya","L. Melaksanakan kegiatab Datasering dan pencangkokan Akademik Dosen","M. Menlakukan kegiatan pengembangan diri untuk meningkatkan kompetensi"};
    String[] q3 = new String[]{"A. Menghasilkan Karya Ilmiah","B. Menerjemahkan/menyadur buku ilmiah","C. Mengedit/menyunting karya ilmiah","D. Membuat rencana dan karya teknologi yang di patenkan","E. Membuat rancangan dan karya teknologi,rancangan dan karyy seni monumental/seni pertunjukan/karya sastra"};
    String[] q4 = new String[]{"A. Menduduki jabatan pimpinan","B. Melakasanakan pengembangan hasil pendidikan dan penelitian","C. Memberi latihan/penyuluahan/penataran/ceramah pada masyarakat","D. Memberi pelayanan keapada masyarakat atau kegiatan lain yang menunjang pelaksanaan tugas umum pemerintah dan pembangunan","E. Membuat/meulis karya pengabdian"};
    String[] q5 = new String[]{"A. Menjadi anggota dalam suatu panitia/Badan pada lembaga pemerintahan","B. Menjadi anggota panitia/badan pada lembaga pemerintah","C. Menjadi anggota orgabisasi profesi dosen","D. Mewakili pengurusan tinggi/lembaga pemerintah","E. Menjadi anggota deligasi nasional kepertemuan internasional","F. Berperan aktif dalam pertemuan ilmiah","G. Mendapat penghargaan tanda jasa","H. Menulis buku pelajaran SLTA ke bawah yang diterbitkan dan diedarkan secara nasional","I. Mempunyai prestasi dibidang olahraga/humaniora","J. Keanggotaan dalam tim penilai"};

    String[] pend1 = new String[]{"a. Doktor(S3)","b.Magister(S2)"};
    String[] pend2 = new String[]{"Diklat prajabatan golongan III"};
    String[] peng1 = new String[]{"Melaksanakan perkuliahan/tutorial dan membimbing,menguji serta menyelenggarakan pendidikan di laboratorium,praktik kegiatan bengkel/studio/kebun pada fakultas/sekolah tinggi/akademik/politeknik sendiri pada fakultas lain dalam lingkungan universitas/institut sendiri.maupun diluar perguruan tinggi sendiri secara melembaga tiap sks(paling banyak 12 sks)per semester"};
    String[] peng2 = new String[]{"Membimbing Mahasiswa Seminar"};
    String[] peng3 = new String[]{"Membimbing mahasiswa kuliah kerja nyata,praktek kerja nyata,praktek kerja lapangan"};
    String[] peng4 = new String[]{"Membimbing mahasiswa kuliah kerja nyata, praktek kerja nyata,praktek kerja lapangan"};
    String[] parent1 = new String[]{"1. Pembimbing utama"};

    String[] peng5 = new String[]{"1. Ketua Penguji","2. Anggota Penguji"};
    String[] peng6 = new String[]{"Melakukan pembinaan kegiatan mahasiswa di bidang Akademik dan kemahasiswaan"};
    String[] peng7 = new String[]{"Melakukan kegiatan pembangunan program kuliah"};
    String[] peng8 = new String[]{"1. Buka ajar", "2. Diktat,modul,petunjuk praktikum,model,alat bantu,audio visual,naskah tutorial"};
    String[] peng9 = new String[]{"Melakukan kegiatan orasi ilmiah pada perhuruan tinggi tiap tahun"};
    String[] peng10= new String[]{"1. Rektor","2. Pembantu rektor/dekan/direktur program pasca kerja","3. Ketua sekolah tinggi/pembantu dekan/asisten direktur program pasca serjana/direktur politeknik","4. Pembantu ketua sekolah tinggi/pembantu direktur politeknik","5. Direktur Akademi","6. Pembantu direktur akademi/ketua jurusan/bagian pada universitas/institut/sekolah tinggi","7. Ketua jurusan pada politeknik/akademi/sekertaris jurusanbagian pada universitas/institut/sekolah tinggi","8.Sekertaris jurusan pada politeknik/akademi/sekertaris jurusan bagian pada universitas/institut/sekolah tinggi"};
    String[] peng11= new String[]{"1. Menmbimbing pencakokan","2. Reguler"};
    String[] peng12= new String[]{"1. Detasering","2. Pencangkokan" };
    String[] peng13= new String[]{"1. Lamanya lebih dari 960 jam","2. Lamanya 641-960 jam","3. Lamanya 481-640 jam ","4. Lamanyan 161-480 jam ","5. Lamanya 81-160 jam ","6. Lamanya 31-80 jam ","7. Lamanya 10-30 jam "};

    String[] parent2= new String[]{"1. Hasil penelitian atau pemikiran yang dipublikasikan"};
    String[] penelit1 = new String[]{"Diterbitkan dan diedarkan secara nasional"};
    String[] penelit2= new String[]{"Diterbitkan dan diedarkan secara nasional"};
    String[] penelit3= new String[]{"1. Internasional","2. Nasional"};
    String[] penelit4= new String[]{"1. Tingkat Internasional","2. Tingkat nasional","3. Tingkat lokal"};


    String[] pengab1 = new String[]{"Menduduki jabatan pimpinan pada lembaga pemerintahan/pejabat negara yang harus dibebaskan dari jabatan organiknya"};
    String[] pengab2 = new String[]{"Melaksanakan pengembangan hasil pendidikan dan penelitian yang dapat dimanfaatkan oleh masyarakat"};
    String[] parent3 = new String[]{"1. Terjadwal/terprogram"};
    String[] pengab3 = new String[]{"1. Berdasarkan bidang keahlian","2. Berdasarkan penugasan lembaga perguruan tinggi","Berasarkan fungsi/jabatan"};
    String[] pengab4 = new String[]{"Membuat/menulis karya pengabdian pada masyarakat yang tidak di publikasikan"};

    String[] penunj1 = new String[]{"1. Sebagai ketua/wakil ketua merangkap anggota","2. Sebagai anggota"};
    String[] penunj2 = new String[]{"1. Panitia pusat","Panitia daerah"}; //parent
    String[] penunj3 = new String[]{"1. Tingkat internasional","Tingkat nsional"};//parent
    String[] penunj4 = new String[]{"Mewakili perguruan tinggi/lembaga pemerintah duduk dalam panitia antar lembaga"};
    String[] penunj5 = new String[]{"1. Sebagai ketua deligasi","2. Sebagai anggota deligasi"};
    String[] penunj6 = new String[]{"1. Tingkat internasional/nasional/regional sebagi:","2. Memperoleh penghargaan lainnya"};//parent
    String[] penunj7 = new String[]{"1. Penghargaan/tanda jasa Satya Lancana Karya Satya","2. Memperoleh penghargaan lainnya"};
    String[] penunj8 = new String[]{"1. Buku SLTA atau setingkat","2. Buku SLTP atau setingkat","3. Buku SD atau setingkat"};
    String[] penunj9 = new String[]{"1. Tingkat internasional","2. Tingkat nasional","3. Tingkat daerah/lokal"};
    String[] penunj10 = new String[]{"1. Menjadi anggota tim penilai Jabatan Akademik Dosen"};

    LinkedHashMap<String, String[]> thirdLevelq1 = new LinkedHashMap<>();
    LinkedHashMap<String, String[]> thirdLevelq2 = new LinkedHashMap<>();
    LinkedHashMap<String, String[]> thirdLevelq3 = new LinkedHashMap<>();
    LinkedHashMap<String, String[]> thirdLevelq4 = new LinkedHashMap<>();
    LinkedHashMap<String, String[]> thirdLevelq5 = new LinkedHashMap<>();

     /**

     * Second level array list
     */
    List<String[]> secondLevel = new ArrayList<>();
    //List<String[]> four_level=new ArrayList<>();
    /**
     * Inner level data
     */
    List<LinkedHashMap<String, String[]>> data = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inputak);
        setUpAdapter();
    }

    private void setUpAdapter() {
//TABEL sub unsur
       // four_level.add(penunj2);
        secondLevel.add(q1);
        secondLevel.add(q2);
        secondLevel.add(q3);
        secondLevel.add(q4);
        secondLevel.add(q5);
        //TABEL Unsur
//1. pendidikan
        thirdLevelq1.put(q1[0], pend1);
        thirdLevelq1.put(q1[1], pend2);
//2. pengajaran
        thirdLevelq2.put(q2[0], peng1);
        thirdLevelq2.put(q2[1], peng2);
        thirdLevelq2.put(q2[2], peng3);
        thirdLevelq2.put(q2[2], peng4);
        thirdLevelq2.put(q2[3], parent1);

        thirdLevelq2.put(q2[4], peng5);
        thirdLevelq2.put(q2[5], peng6);
        thirdLevelq2.put(q2[6], peng7);
        thirdLevelq2.put(q2[7], peng8);
        thirdLevelq2.put(q2[8], peng9);
        thirdLevelq2.put(q2[9], peng10);
        thirdLevelq2.put(q2[10], peng11);
        thirdLevelq2.put(q2[11], peng12);
        thirdLevelq2.put(q2[12], peng13);
//3. Penelitian
        thirdLevelq3.put(q3[0], parent2);
        thirdLevelq3.put(q3[1], penelit1);
        thirdLevelq3.put(q3[2], penelit2);
        thirdLevelq3.put(q3[3], penelit3);
        thirdLevelq3.put(q3[4], penelit4);
//4. pengabdian
        thirdLevelq4.put(q4[0], pengab1);
        thirdLevelq4.put(q4[1], pengab2);
        thirdLevelq4.put(q4[2], parent3);
        thirdLevelq4.put(q4[3], pengab3);
        thirdLevelq4.put(q4[4], pengab4);
//5. penunjang
        thirdLevelq5.put(q5[0], penunj1);
        thirdLevelq5.put(q5[1], penunj2);
        thirdLevelq5.put(q5[2], penunj3);
        thirdLevelq5.put(q5[3], penunj4);
        thirdLevelq5.put(q5[4], penunj5);
        thirdLevelq5.put(q5[5], penunj6);
        thirdLevelq5.put(q5[6], penunj7);
        thirdLevelq5.put(q5[7], penunj8);
        thirdLevelq5.put(q5[8], penunj9);
        thirdLevelq5.put(q5[9], penunj10);



        data.add(thirdLevelq1);
        data.add(thirdLevelq2);
        data.add(thirdLevelq3);
        data.add(thirdLevelq4);
        data.add(thirdLevelq5);
        expandableListView = (ExpandableListView) findViewById(R.id.expandible_listview);
        //passing three level of information to constructor
        ThreeLevelListAdapter threeLevelListAdapterAdapter = new ThreeLevelListAdapter(this, parent, secondLevel, data);
        expandableListView.setAdapter(threeLevelListAdapterAdapter);
        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
            int previousGroup = -1;

            @Override
            public void onGroupExpand(int groupPosition) {
                if (groupPosition != previousGroup)
                    expandableListView.collapseGroup(previousGroup);
                previousGroup = groupPosition;
            }
        });


    }
}

