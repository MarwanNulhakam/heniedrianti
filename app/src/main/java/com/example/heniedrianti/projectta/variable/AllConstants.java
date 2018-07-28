package com.example.heniedrianti.projectta.variable;

public class AllConstants {
    public static class SQLiteProperties{
        public static final String DATABASENAME = "creditdb.db";
        public static final String[]TABLENAME = new String[]{"demo","person"};
        public static final String[][]COLUMNNAME = {
                {"id INTEGER PRIMARY KEY AUTOINCREMENT","name TEXT","grade TEXT","address TEXT"},
                {"nip TEXT PRIMARY KEY","nama TEXT","gelardepan TEXT","gelarBelakang TEXT","nomorkarpeg TEXT","pangkat TEXT","tempatlahir TEXT","tanggallahir TEXT","gender TEXT","pendidikanterakhir TEXT","jabatanakademik TEXT","unitkerja TEXT"}
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
    }

    public static class QueryModel{

    }

}
