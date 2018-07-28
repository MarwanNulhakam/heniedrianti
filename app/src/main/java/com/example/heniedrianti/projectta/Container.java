package com.example.heniedrianti.projectta;

import android.util.Log;

public class Container {
    public static String result;
    private static boolean ready=true;
    private static boolean interrupted = false;

    public static void interrupt(){
        Log.d("Container","process interruted");
        interrupted = true;
    }

    public static void allowGetResult(){
        Log.d("Container","Allowed to retrieve result");
        ready = true;
    }

    public static void haltGetResult(){
        Log.d("Container","Halt the result retrieve process");
        ready = false;
    }

    public static String getResult(){
//        while(!ready){
//            if(interrupted){
//                interrupted = false;
//                return "";
//            }
//        }
        Log.d("Container","result retrieve success, retrieve as "+result);
        return result;
    }
}
