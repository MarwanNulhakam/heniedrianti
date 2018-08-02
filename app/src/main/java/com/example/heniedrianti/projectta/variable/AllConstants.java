package com.example.heniedrianti.projectta.variable;

public class AllConstants {
    public static class SQLiteProperties{
        public static final String DATABASENAME = "creditdb.db";
        public static final String[]TABLENAME = new String[]{"demo","person","mengajar","skripsi","kegiatan"};
        public static final String[][]COLUMNNAME = {
                {"id INTEGER PRIMARY KEY AUTOINCREMENT","name TEXT","grade TEXT","address TEXT"},
                {"nip TEXT PRIMARY KEY","nama TEXT","gelardepan TEXT","gelarBelakang TEXT","nomorkarpeg TEXT","pangkat TEXT","tempatlahir TEXT","tanggallahir TEXT","gender TEXT","pendidikanterakhir TEXT","jabatanakademik TEXT","unitkerja TEXT","status TEXT"},
                {"id INTEGER PRIMARY KEY AUTOINCREMENT","namamatkul TEXT","sks INT","semester TEXT","tahunakademik TEXT","kelas TEXT","statusmatakuliah TEXT"},
                {"id INTEGER PRIMARY KEY AUTOINCREMENT","judul TEXT","tahunakademik TEXT","peneliti TEXT","pembimbingutama TEXT","pembimbingpendamping TEXT","pengujiutama TEXT","penguji2 TEXT","penguji3 TEXT","status TEXT"},
                {"id INTEGER PRIMARY KEY AUTOINCREMENT","uraian TEXT","tanggal DATE","satuan TEXT","volume INT","status TEXT"}
        };
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
                "unitkerja"
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
                "uraian",
                "tanggal",
                "satuan",
                "volume",
                "status"
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
                case "skripsi" :   data = skripsiColumn;
                                    break;
            }
            return data;
        }
    }

    public static class QueryModel{

    }

}
