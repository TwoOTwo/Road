package db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Hua on 2015/10/13.
 */
public class PublicWelfareOpenHelper extends SQLiteOpenHelper
{
    public static final String Create_USER ="create table USER("+"id integer primary key autoincrement,"
            +"account text,"
            +"password text,"
            +"phonenumber text,"
            +"integral integer,"
            +"thelength integer,"
            +"welfareeventId integer)";
    public static final String Create_Welfare ="create table Event("+"id integer primary key autoincrement,"
            +"publicevent text,"
            +"Address text)";
    public static final  String Create_Goods="create table Goods("+"id integer primary key autoincrement,"
            +"goodsname text,"
            +"price integer)";

    public PublicWelfareOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL(Create_USER);
//        db.execSQL(Create_Welfare);
//        db.execSQL(Create_Goods);
    }


    public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion)
    {

    }
}
