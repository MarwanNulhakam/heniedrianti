package com.example.heniedrianti.projectta.variable;

public class AllConstants {
    public static class SQLiteProperties{
        public static final String DATABASENAME = "creditdb.db";
        public static final String[]TABLENAME = new String[]{"demo","person","kegiatan"};
        public static final String[][]COLUMNNAME = {
                {"id INTEGER PRIMARY KEY AUTOINCREMENT","name TEXT","grade TEXT","address TEXT"},
                {"nip TEXT PRIMARY KEY","nama TEXT","gelardepan TEXT","gelarBelakang TEXT","nomorkarpeg TEXT","pangkat TEXT","tempatlahir TEXT","tanggallahir TEXT","gender TEXT","pendidikanterakhir TEXT","jabatanakademik TEXT","unitkerja TEXT"},
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
        public static final String[]kegiatanColumn={
                "id",
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
            }
            return data;
        }
    }

    public static class QueryModel{

    }

}
