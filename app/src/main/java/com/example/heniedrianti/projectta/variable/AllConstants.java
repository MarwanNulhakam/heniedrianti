package com.example.heniedrianti.projectta.variable;

public class AllConstants {
    public static class StatusLibrary{
        public static final String UNCHECKED_STATUS="";
    }

    public static class SQLiteProperties{
        public static final String DATABASENAME = "creditdb.db";

        /*Tabel dan struktur tabel yang dibuat oleh aplikasi saat login pertama*/
        public static final String[]TABLENAME = new String[]{"person","mengajar","skripsi","kegiatan","jurnal","jabatan","pembinaan","karir"};
        public static final String[][]COLUMNNAME = {
                {"nip TEXT PRIMARY KEY","nama TEXT","gelardepan TEXT","gelarBelakang TEXT","nomorkarpeg TEXT","pangkat TEXT","tempatlahir TEXT","tanggallahir TEXT","gender TEXT","pendidikanterakhir TEXT","jabatanakademik TEXT","unitkerja TEXT","tanggalprajabatan TEXT","status TEXT"},
                {"id INTEGER PRIMARY KEY AUTOINCREMENT","namamatkul TEXT","sks INT","semester TEXT","tahunakademik TEXT","kelas TEXT","statusmatakuliah TEXT","status TEXT"},
                {"id INTEGER PRIMARY KEY AUTOINCREMENT","judul TEXT","tahunakademik TEXT","peneliti TEXT","pembimbingutama TEXT","pembimbingpendamping TEXT","pengujiutama TEXT","penguji2 TEXT","penguji3 TEXT","status TEXT"},
                {"id INTEGER PRIMARY KEY AUTOINCREMENT","idperan INTEGER","uraian TEXT","tanggal DATE","satuan TEXT","volume INT","statuskegiatan TEXT","peran TEXT","status TEXT"},
                {"id INTEGER PRIMARY KEY AUTOINCREMENT","ISN TEXT","tingkat TEXT","judul TEXT","tanggal TEXT","jenis TEXT","halaman TEXT","event TEXT","penerbit TEXT","volume TEXT","posisi TEXT","status TEXT"},
                {"id INTEGER PRIMARY KEY AUTOINCREMENT","idjabatan TEXT","jabatan TEXT","divisi TEXT","lembaga TEXT","tanggalpelantikan TEXT","status TEXT"},
                {"id INTEGER PRIMARY KEY AUTOINCREMENT","idpembinaan TEXT","kegiatan TEXT","waktu TEXT","status TEXT"},
                {"id INTEGER","jenjang TEXT","tanggal TEXT","universitas TEXT","status TEXT"}
        };

        /*
        * list kolom dari JSON yang dikirimkan oleh server.
        * */
        public static final String[]dosenColumn={
                "nip",
                "nama",
                "gelardepan",
                "gelarbelakang",
                "nomorkarpeg",
                "pangkat",
                "tempatlahir",
                "tanggallahir",
                "gender",
                "pendidikanterakhir",
                "jabatanakademik",
                "unitkerja",
                "tanggalprajabatan"
        };
        public static final String[]mengajarColumn={
                "namamatkul",
                "sks",
                "semester",
                "tahunakademik",
                "kelas",
                "statusmatakuliah"
        };
        public static final String[]skripsiColumn={
                "judul",
                "tahunakademik",
                "peneliti",
                "pembimbingutama",
                "pembimbingpendamping",
                "pengujiutama",
                "penguji2",
                "penguji3"
        };
        public static final String[]kegiatanColumn={
                "idperan",
                "uraian",
                "tanggal",
                "satuan",
                "volume",
                "statuskegiatan",
                "peran"
        };
        public static final String[]jurnalColumn={
                "id",
                "ISN",
                "tingkat",
                "judul",
                "tanggal",
                "jenis",
                "halaman",
                "event",
                "penerbit",
                "volume",
                "posisi"
        };
        public static final String []jabatanColumn={
                "idjabatan",
                "jabatan",
                "divisi",
                "lembaga",
                "tanggalpelantikan"
        };
        public static final String[]pembinaanColumn={
                "idpembinaan",
                "kegiatan",
                "waktu"
        };
        public static final String[]karirColumn={
                "id",
                "jenjang",
                "tanggal",
                "universitas"
        };
        public static String[]getTableColumn(String tableName){
            String[]data=null;
            switch(tableName){
                case "person"   :   data = dosenColumn;
                                    break;
                case "kegiatan" :   data = kegiatanColumn;
                                    break;
                case "mengajar" :   data = mengajarColumn;
                                    break;
                case "skripsi"  :   data = skripsiColumn;
                                    break;
                case "jurnal"   :   data = jurnalColumn;
                                    break;
                case "jabatan"  :   data = jabatanColumn;
                                    break;
                case "pembinaan":   data = pembinaanColumn;
                                    break;
                case "karir"    :   data = karirColumn;
                                    break;
            }
            return data;
        }
    }

    public static class DataStructure{
        public static String[] concatOptionList(String tableName, String[]value){
            String[]result = new String[2];
            switch (tableName){
                case "person"   :   result[0] = "Diklat Prajabatan Golongan III";
                                    result[1] = value[12];
                                    return result;
                case "jabatan"  :   result[0] = String.format("%s %s %s",value[2],value[3],value[4]);
                                    result[1] = value[5];
                                    return result;
                case "jurnal"   :   result[0] = String.format("%s %s %s; Berjudul:\"%s\"; hal %s; %s; %s; %s; %s",
                                                (value[5].equals("jurnal")?"Jurnal":"Seminar"),
                                                value[2], value[1], value[3],value[6],value[10],value[7],value[8],value[9]
                                    );
                                    result[1] = value[4];
                                    return result;
                case "kegiatan" :   result[0] = String.format("%s %s",value[7],value[2]);
                                    result[1] = value[3];
                                    return result;
                case "mengajar" :   result[0] = String.format("%s (%s SKS) Kelas %s",value[1],value[2],value[5]);
                                    result[1] = String.format("%s %s",value[3],value[4]);
                                    return result;
                case "pembinaan":   result[0] = String.format("Membimbing %s",value[2]);
                                    result[1] = value[3];
                                    return result;
                case "skripsi"  :   result[0] = String.format("Bertugas sebagai %s Mahasiswa dengan NIM ",value[2]);
                                    result[1] = value[2];
                                    return result;
                case "karir"    :   result[0] = String.format("Jenjang %s dari %s",value[1],value[3]);
                                    result[1] = value[2];
                                    return result;
            }
            return null;
        }


    }

}
