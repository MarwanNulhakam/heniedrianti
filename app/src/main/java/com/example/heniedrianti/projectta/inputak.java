package com.example.heniedrianti.projectta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class inputak extends AppCompatActivity {
    private ExpandableListView expandableListView;
    //Sub unsur
    String[] parent = new String[]{
            "Pendidikan",
            "Pelaksanaan Pendidikan",
            "Pelaksanaan Penelitian",
            "Pelaksanaan Pengabdian Kepada Masyarakat",
            "Penunjang Kegiatan Akademik Dosen"
    };
    //Unsur
    String[] q1 = new String[]{"A. Pendidikann formal","B. Diklat Pra Jabatan"};
    String[] q2 = new String[]{
            "A. Melaksanakan perkuliahan/tutorial dan membimbing, menguji serta menyelenggarakan pendidikan di laboratorium, praktik kegiatan bengkel/studio/kebun pada fakultas/sekolah tinggi/Akademik/Politeknik sendiri pada fakultas lain dalam lingkungan Universitas/institut sendiri, maupun di luar perguruan tinggi sendiri secara melembaga tiap sks (paling banyak 12 sks)per semester",
            "B. Membimbing Seminar",
            "C. Membimbing kuliah kerja nyata, praktek kerja nyata,praktek kerja lapangan",
            "D. Membimbing dan ikut dalam menghasilkan disertasi, tesis, skripsi dan laporan akhir studi",
            "E. Bertugas sebagai penguji tugas akhir",
            "F. Membina kegiatan mahasiswa",
            "G. Mengembangkan program kuliah",
            "H. Mengembangkan bahan kuliah",
            "I. Menyampaikan orasi ilmiah",
            "J. Menduduki jabatan pimpinan perguruan tertinggi",
            "K. Membimbing Akademik dosen yang lebih rendah jabatannya",
            "L. Melaksanakan kegiatab Datasering dan pencangkokan Akademik Dosen",
            "M. Menlakukan kegiatan pengembangan diri untuk meningkatkan kompetensi"
    };
    String[] q3 = new String[]{
            "A. Menghasilkan Karya Ilmiah",
            "B. Menerjemahkan/menyadur buku ilmiah",
            "C. Mengedit/menyunting karya ilmiah",
            "D. Membuat rencana dan karya teknologi yang di patenkan",
            "E. Membuat rancangan dan karya teknologi,rancangan dan karya seni monumental/seni pertunjukan/karya sastra"
    };
    String[] q4 = new String[]{"" +
            "A. Menduduki jabatan pimpinan",
            "B. Melakasanakan pengembangan hasil pendidikan dan penelitian",
            "C. Memberi latihan/penyuluahan/penataran/ceramah pada masyarakat",
            "D. Memberi pelayanan keapada masyarakat atau kegiatan lain yang menunjang pelaksanaan tugas umum pemerintah dan pembangunan",
            "E. Membuat/meulis karya pengabdian"
    };
    String[] q5 = new String[]{
            "A. Menjadi anggota dalam suatu panitia/Badan pada lembaga pemerintahan",
            "B. Menjadi anggota panitia/badan pada lembaga pemerintah",
            "C. Menjadi anggota orgabisasi profesi dosen",
            "D. Mewakili pengurusan tinggi/lembaga pemerintah",
            "E. Menjadi anggota deligasi nasional kepertemuan internasional",
            "F. Berperan aktif dalam pertemuan ilmiah",
            "G. Mendapat penghargaan tanda jasa",
            "H. Menulis buku pelajaran SLTA ke bawah yang diterbitkan dan diedarkan secara nasional",
            "I. Mempunyai prestasi dibidang olahraga/humaniora",
            "J. Keanggotaan dalam tim penilai"
    };

    String[][] opsiPendidikan =  {
            {"a. Doktor(S3)","b.Magister(S2)"},
            {"Diklat prajabatan golongan III"}
    };
    String[][]opsiPelaksanaanPendidikan = {
            {"Ya/terpenuhi"},
            {"Ya/terpenuhi"},
            {"Ya/terpenuhi"},
            {"Ya/terpenuhi"},
            {"Sebagai Pembimbing Utama"},
            {"Sebagai Ketua Penguji","Sebagai Anggota Penguji"},
            {"Ya/terpenuhi"},
            {"Ya/terpenuhi"},
            {"Buka ajar", "Diktat,modul,petunjuk praktikum, model,alat bantu,audio visual,naskah tutorial"},
            {"Ya/terpenuhi"},
            {"Ya/terpenuhi"},
            {"1. Buka ajar", "2. Diktat,modul,petunjuk praktikum,model,alat bantu,audio visual,naskah tutorial"},
            {"Melakukan kegiatan orasi ilmiah pada perguruan tinggi tiap tahun"},
            {
                "1. Rektor",
                "2. Pembantu rektor/dekan/direktur program pasca kerja",
                "3. Ketua sekolah tinggi/pembantu dekan/asisten direktur program pasca serjana/direktur politeknik",
                "4. Pembantu ketua sekolah tinggi/pembantu direktur politeknik",
                "5. Direktur Akademi",
                "6. Pembantu direktur akademi/ketua jurusan/bagian pada universitas/institut/sekolah tinggi",
                "7. Ketua jurusan pada politeknik/akademi/sekertaris jurusanbagian pada universitas/institut/sekolah tinggi",
                "8.Sekertaris jurusan pada politeknik/akademi/sekertaris jurusan bagian pada universitas/institut/sekolah tinggi"
            },
            {"1. Menmbimbing pencakokan","2. Reguler"},
            {"1. Detasering","2. Pencangkokan" },
            {
                "1. Lamanya lebih dari 960 jam",
                "2. Lamanya 641-960 jam",
                "3. Lamanya 481-640 jam ",
                "4. Lamanyan 161-480 jam ",
                "5. Lamanya 81-160 jam ",
                "6. Lamanya 31-80 jam ",
                "7. Lamanya 10-30 jam "
            }
    };

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

    String[][] opsiPelaksanaanPenelitian = {
            {"Hasil penelitian atau pemikiran yang dipublikasikan"},
            {"Diterbitkan dan diedarkan secara nasional"},
            {"Diterbitkan dan diedarkan secara nasional"},
            {"1. Internasional","2. Nasional"},
            {"1. Tingkat Internasional","2. Tingkat nasional","3. Tingkat lokal"}
    };

    String[] parent2= new String[]{"1. Hasil penelitian atau pemikiran yang dipublikasikan"};
    String[] penelit1 = new String[]{"Diterbitkan dan diedarkan secara nasional"};
    String[] penelit2= new String[]{"Diterbitkan dan diedarkan secara nasional"};
    String[] penelit3= new String[]{"1. Internasional","2. Nasional"};
    String[] penelit4= new String[]{"1. Tingkat Internasional","2. Tingkat nasional","3. Tingkat lokal"};

    String[][] opsiPelaksanaanPKM = {
            {"Menduduki jabatan pimpinan pada lembaga pemerintahan/pejabat negara yang harus dibebaskan dari jabatan organiknya"},
            {"Melaksanakan pengembangan hasil pendidikan dan penelitian yang dapat dimanfaatkan oleh masyarakat"},
            {"1. Terjadwal/terprogram"},
            {"1. Berdasarkan bidang keahlian","2. Berdasarkan penugasan lembaga perguruan tinggi","Berasarkan fungsi/jabatan"},
            {"Membuat/menulis karya pengabdian pada masyarakat yang tidak di publikasikan"}
    };

    String[] pengab1 = new String[]{"Menduduki jabatan pimpinan pada lembaga pemerintahan/pejabat negara yang harus dibebaskan dari jabatan organiknya"};
    String[] pengab2 = new String[]{"Melaksanakan pengembangan hasil pendidikan dan penelitian yang dapat dimanfaatkan oleh masyarakat"};
    String[] parent3 = new String[]{"1. Terjadwal/terprogram"};
    String[] pengab3 = new String[]{"1. Berdasarkan bidang keahlian","2. Berdasarkan penugasan lembaga perguruan tinggi","Berasarkan fungsi/jabatan"};
    String[] pengab4 = new String[]{"Membuat/menulis karya pengabdian pada masyarakat yang tidak di publikasikan"};

    String[][] opsiPenunjangKAD  = {
            {"1. Sebagai ketua/wakil ketua merangkap anggota","2. Sebagai anggota"},
            {"1. Panitia pusat","Panitia daerah"},
            {"1. Tingkat internasional","Tingkat nasional"},
            {"Mewakili perguruan tinggi/lembaga pemerintah duduk dalam panitia antar lembaga"},
            {"1. Sebagai ketua deligasi","2. Sebagai anggota deligasi"},
            {"1. Tingkat internasional/nasional/regional sebagi:","2. Memperoleh penghargaan lainnya"},
            {"1. Penghargaan/tanda jasa Satya Lancana Karya Satya","2. Memperoleh penghargaan lainnya"},
            {"1. Buku SLTA atau setingkat","2. Buku SLTP atau setingkat","3. Buku SD atau setingkat"},
            {"1. Tingkat internasional","2. Tingkat nasional","3. Tingkat daerah/lokal"},
            {"1. Menjadi anggota tim penilai Jabatan Akademik Dosen"}
    };

    String[] penunj1 = new String[]{"1. Sebagai ketua/wakil ketua merangkap anggota","2. Sebagai anggota"};
    String[] penunj2 = new String[]{"1. Panitia pusat","Panitia daerah"}; //parent
    String[] penunj3 = new String[]{"1. Tingkat internasional","Tingkat nasional"};//parent
    String[] penunj4 = new String[]{"Mewakili perguruan tinggi/lembaga pemerintah duduk dalam panitia antar lembaga"};
    String[] penunj5 = new String[]{"1. Sebagai ketua deligasi","2. Sebagai anggota deligasi"};
    String[] penunj6 = new String[]{"1. Tingkat internasional/nasional/regional sebagi:","2. Memperoleh penghargaan lainnya"};//parent
    String[] penunj7 = new String[]{"1. Penghargaan/tanda jasa Satya Lancana Karya Satya","2. Memperoleh penghargaan lainnya"};
    String[] penunj8 = new String[]{"1. Buku SLTA atau setingkat","2. Buku SLTP atau setingkat","3. Buku SD atau setingkat"};
    String[] penunj9 = new String[]{"1. Tingkat internasional","2. Tingkat nasional","3. Tingkat daerah/lokal"};
    String[] penunj10 = new String[]{"1. Menjadi anggota tim penilai Jabatan Akademik Dosen"};

//    LinkedHashMap<String, String[]> thirdLevelq1 = new LinkedHashMap<>();
//    LinkedHashMap<String, String[]> thirdLevelq2 = new LinkedHashMap<>();
//    LinkedHashMap<String, String[]> thirdLevelq3 = new LinkedHashMap<>();
//    LinkedHashMap<String, String[]> thirdLevelq4 = new LinkedHashMap<>();
//    LinkedHashMap<String, String[]> thirdLevelq5 = new LinkedHashMap<>();

     /**

     * Second level array list
     */
    List<String[]> secondLevel = new ArrayList<>();
    //List<String[]> four_level=new ArrayList<>();
    /**
     * Inner level data
     */
    List<LinkedHashMap<String, String[]>> data = new ArrayList<>();

    int[] sidebarCount = {2,13,5,5,10};

    int page=0;
    ImageView backButton,footerPrev,footerNext,sidebarIcon[];
    TextView headerText;
    TextView footerText;
    String[][] questionGroup = {q1,q2,q3,q4,q5};
    String [][][] optionGroup = {
            opsiPendidikan,
            opsiPelaksanaanPendidikan,
            opsiPelaksanaanPenelitian,
            opsiPelaksanaanPKM,
            opsiPenunjangKAD
    };

    TextView question;

//    TextView option1 ;
//    TextView option2;
//    TextView option3;
//    TextView option4;
//    TextView option5;
//    TextView option6;
//    TextView option7;
//    TextView option8;
//    TextView option9;
//    TextView option10;
//    TextView option11;
//    TextView option12;
//    TextView option13;

//    CheckBox    checkBox0,
//                checkBox1,
//                checkBox2,
//                checkBox3,
//                checkBox4,
//                checkBox5,
//                checkBox6,
//                checkBox7;
    
    TextView[] sidebarText = new TextView[13];
    CheckBox[] checkBoxGroup = new CheckBox[8];
    LinearLayout[] sidebarList = new LinearLayout[13];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inputak);
//        setUpAdapter();

        sidebarIcon = new ImageView[13];
        page = 1;

        headerText = findViewById(R.id.headerText);
        footerText = findViewById(R.id.footerStatus);

        sidebarList[0] = findViewById(R.id.optionLayout1);
        sidebarList[1] = findViewById(R.id.optionLayout2);
        sidebarList[2] = findViewById(R.id.optionLayout3);
        sidebarList[3] = findViewById(R.id.optionLayout4);
        sidebarList[4] = findViewById(R.id.optionLayout5);
        sidebarList[5] = findViewById(R.id.optionLayout6);
        sidebarList[6] = findViewById(R.id.optionLayout7);
        sidebarList[7] = findViewById(R.id.optionLayout8);
        sidebarList[8] = findViewById(R.id.optionLayout9);
        sidebarList[9] = findViewById(R.id.optionLayout10);
        sidebarList[10] = findViewById(R.id.optionLayout11);
        sidebarList[11] = findViewById(R.id.optionLayout12);
        sidebarList[12] = findViewById(R.id.optionLayout13);

        sidebarText[0] = findViewById(R.id.option1);
        sidebarText[1] = findViewById(R.id.option2);
        sidebarText[2] = findViewById(R.id.option3);
        sidebarText[3] = findViewById(R.id.option4);
        sidebarText[4] = findViewById(R.id.option5);
        sidebarText[5] = findViewById(R.id.option6);
        sidebarText[6] = findViewById(R.id.option7);
        sidebarText[7] = findViewById(R.id.option8);
        sidebarText[8] = findViewById(R.id.option9);
        sidebarText[9] = findViewById(R.id.option10);
        sidebarText[10] = findViewById(R.id.option11);
        sidebarText[11] = findViewById(R.id.option12);
        sidebarText[12] = findViewById(R.id.option13);

        sidebarIcon[0] = findViewById(R.id.sidebarImg1);
        sidebarIcon[1] = findViewById(R.id.sidebarImg2);
        sidebarIcon[2] = findViewById(R.id.sidebarImg3);
        sidebarIcon[3] = findViewById(R.id.sidebarImg4);
        sidebarIcon[4] = findViewById(R.id.sidebarImg5);
        sidebarIcon[5] = findViewById(R.id.sidebarImg6);
        sidebarIcon[6] = findViewById(R.id.sidebarImg7);
        sidebarIcon[7] = findViewById(R.id.sidebarImg8);
        sidebarIcon[8] = findViewById(R.id.sidebarImg9);
        sidebarIcon[9] = findViewById(R.id.sidebarImg10);
        sidebarIcon[10] = findViewById(R.id.sidebarImg11);
        sidebarIcon[11] = findViewById(R.id.sidebarImg12);
        sidebarIcon[12] = findViewById(R.id.sidebarImg13);

        checkBoxGroup[0] = findViewById(R.id.checkBox0);
        checkBoxGroup[1] = findViewById(R.id.checkBox1);
        checkBoxGroup[2] = findViewById(R.id.checkBox2);
        checkBoxGroup[3] = findViewById(R.id.checkBox3);
        checkBoxGroup[4] = findViewById(R.id.checkBox4);
        checkBoxGroup[5] = findViewById(R.id.checkBox5);
        checkBoxGroup[6] = findViewById(R.id.checkBox6);
        checkBoxGroup[7] = findViewById(R.id.checkBox7);

        question = findViewById(R.id.textCategory);

        backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        try {
                            Intent k = new Intent(inputak.this, menuawal.class);
                            startActivity(k);
                        } catch(Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
        );

        footerPrev = findViewById(R.id.footerPrevButton);
        footerPrev.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        page = page == 0 ? 4 : page-1;
                        System.out.println("page ="+page);
                        settingSidebarForIndex(page);
                        setQuestionGroup(page, optionSelectedEachPage[page]);
                        footerText.setText(numPageOfPage(page+1));
                    }
                }
        );
        footerNext = findViewById(R.id.footerNextButton);
        footerNext.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        page = (page+1)%5;
                        System.out.println("page ="+page);
                        settingSidebarForIndex(page);
                        setQuestionGroup(page, optionSelectedEachPage[page]);
                        footerText.setText(numPageOfPage(page+1));
                    }
                }
        );

        for(int i=0;i<13;i++){
            final int x = i;
            sidebarText[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    System.out.println("page "+page+ "index "+x);
                    setQuestionGroup(page, x);
                    setOptionSelectedEachPage(page,x);
                }
            });
        }

        page = 0;
        settingSidebarForIndex(0);
        setQuestionGroup(page,0);
        footerText.setText(numPageOfPage(page+1));
    }

    private String numPageOfPage(int page){
        return ("Page "+page+" of 5");
    }

    private int []optionSelectedEachPage = {0,0,0,0,0};

    private void setOptionSelectedEachPage(int page, int option){
        optionSelectedEachPage[page] = option;
    }

    private void settingSidebarForIndex(int index){
        setSidebarInvisibility();
        index = index % questionGroup.length;
        int numOfSidebar = sidebarCount[index];
        for(int i=0;i<13;i++){
            if(numOfSidebar<=0)
                break;
            sidebarList[i].setVisibility(View.VISIBLE);
            sidebarText[i].setText(""+((char)(index+65))+"."+(i<9?"0":"")+(i+1));
            numOfSidebar--;
        }
        headerText.setText(parent[index]);
    }

    private void setSidebarInvisibility(){
        for(int i=0;i<13;i++){
            sidebarList[i].setVisibility(View.INVISIBLE);
        }
    }

    private void setQuestionGroup(int index, int option){
        question.setText(questionGroup[index][option]);
        setOptionInvisibility();
        setOptionVisibility(index,option);
    }

    private void setOptionInvisibility(){
        for(int i=0;i<8;i++){
            checkBoxGroup[i].setVisibility(View.INVISIBLE);
            checkBoxGroup[i].setText("TextBox");
        }
    }

    private void setOptionVisibility(int index, int option){
        for(int i=0;i<optionGroup[index][option].length;i++){
            checkBoxGroup[i].setVisibility(View.VISIBLE);
            checkBoxGroup[i].setText(optionGroup[index][option][i]);
        }
    }

//    private void setUpAdapter() {
////TABEL sub unsur
//       // four_level.add(penunj2);
//        secondLevel.add(q1);
//        secondLevel.add(q2);
//        secondLevel.add(q3);
//        secondLevel.add(q4);
//        secondLevel.add(q5);
//        //TABEL Unsur
////1. pendidikan
//        thirdLevelq1.put(q1[0], pend1);
//        thirdLevelq1.put(q1[1], pend2);
////2. pengajaran
//        thirdLevelq2.put(q2[0], peng1);
//        thirdLevelq2.put(q2[1], peng2);
//        thirdLevelq2.put(q2[2], peng3);
//        thirdLevelq2.put(q2[2], peng4);
//        thirdLevelq2.put(q2[3], parent1);
//
//        thirdLevelq2.put(q2[4], peng5);
//        thirdLevelq2.put(q2[5], peng6);
//        thirdLevelq2.put(q2[6], peng7);
//        thirdLevelq2.put(q2[7], peng8);
//        thirdLevelq2.put(q2[8], peng9);
//        thirdLevelq2.put(q2[9], peng10);
//        thirdLevelq2.put(q2[10], peng11);
//        thirdLevelq2.put(q2[11], peng12);
//        thirdLevelq2.put(q2[12], peng13);
////3. Penelitian
//        thirdLevelq3.put(q3[0], parent2);
//        thirdLevelq3.put(q3[1], penelit1);
//        thirdLevelq3.put(q3[2], penelit2);
//        thirdLevelq3.put(q3[3], penelit3);
//        thirdLevelq3.put(q3[4], penelit4);
////4. pengabdian
//        thirdLevelq4.put(q4[0], pengab1);
//        thirdLevelq4.put(q4[1], pengab2);
//        thirdLevelq4.put(q4[2], parent3);
//        thirdLevelq4.put(q4[3], pengab3);
//        thirdLevelq4.put(q4[4], pengab4);
////5. penunjang
//        thirdLevelq5.put(q5[0], penunj1);
//        thirdLevelq5.put(q5[1], penunj2);
//        thirdLevelq5.put(q5[2], penunj3);
//        thirdLevelq5.put(q5[3], penunj4);
//        thirdLevelq5.put(q5[4], penunj5);
//        thirdLevelq5.put(q5[5], penunj6);
//        thirdLevelq5.put(q5[6], penunj7);
//        thirdLevelq5.put(q5[7], penunj8);
//        thirdLevelq5.put(q5[8], penunj9);
//        thirdLevelq5.put(q5[9], penunj10);
//
//
//
//        data.add(thirdLevelq1);
//        data.add(thirdLevelq2);
//        data.add(thirdLevelq3);
//        data.add(thirdLevelq4);
//        data.add(thirdLevelq5);
////        expandableListView = (ExpandableListView) findViewById(R.id.expandible_listview);
////        //passing three level of information to constructor
////        ThreeLevelListAdapter threeLevelListAdapterAdapter = new ThreeLevelListAdapter(this, parent, secondLevel, data);
////        expandableListView.setAdapter(threeLevelListAdapterAdapter);
////        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
////            int previousGroup = -1;
////
////            @Override
////            public void onGroupExpand(int groupPosition) {
////                if (groupPosition != previousGroup)
////                    expandableListView.collapseGroup(previousGroup);
////                previousGroup = groupPosition;
////            }
////        });
//
//
//
//    }
}

