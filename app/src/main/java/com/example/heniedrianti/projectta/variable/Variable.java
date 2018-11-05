package com.example.heniedrianti.projectta.variable;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Heni Edrianti on 10/03/2018.
 */

public class Variable {
    private String resultString=null;
    public String [][] KONDISI_TAMBAHAN = {

            {
                    "", ""
            },

            {
                    "",
                    " AND kegiatan LIKE '%seminar%'",
                    " AND kegiatan LIKE '%kerja%'",
                    " AND (pembimbingutama = '"+AllConstants.SQLiteProperties.nip+"' OR pembimbingpendamping = '"+AllConstants.SQLiteProperties.nip+"')",
                    " AND (pembimbingutama != '"+AllConstants.SQLiteProperties.nip+"' AND pembimbingpendamping != '"+AllConstants.SQLiteProperties.nip+"')",
                    " AND kegiatan LIKE '%dosen wali%'",
                    " AND uraian LIKE '%program kuliah%'",
                    " AND uraian LIKE '%bahan kuliah%'",
                    " AND uraian LIKE '%orasi%'",
                    " AND jabatan LIKE '%rektor%'",
                    " AND kegiatan LIKE '%akademik%'",
                    " AND uraian LIKE '%detasering%'",
                    " AND uraian LIKE '%kompetensi%'"

            },

            {
                    " AND jenis = 'jurnal'",
                    " AND jenis = 'prosiding'",
                    " AND jenis = 'artikel'",
                    " AND jenis = 'buku'",
                    "",
                    " AND jenis = 'paten'",
                    " AND jenis = 'rancangan'",
                    "",
            },

            {
                    "",
                    "",
                    " AND statuskegiatan LIKE '%insidental%'",
                    "",
                    ""
            },

            {
                    " AND peran NOT LIKE '%peserta%' AND peran NOT LIKE '%panitia%'",
                    "",
                    "",
                    "",
                    "",
                    "",
                    " AND peran LIKE '%peserta%'",
                    "",
                    "",
                    "",
                    ""
            }

    };



    public void setResultString(String str){
        this.resultString=str;
    }

    public String getResultString(){
        return this.resultString;
    }
}
