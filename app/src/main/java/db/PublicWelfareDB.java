package db;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import model.Event;
import model.User;

public class PublicWelfareDB {
    public static final String DB_name = "Publicwelfare";
    public static final int VERSION = 1;
    private static PublicWelfareDB welfareDB;
    private static SQLiteDatabase db;


    private PublicWelfareDB(Context context) {
        PublicWelfareOpenHelper createTable = new PublicWelfareOpenHelper(context, DB_name, null, VERSION);
        db = createTable.getWritableDatabase();
    }

    public synchronized static PublicWelfareDB getInstance(Context context) {
        if (welfareDB == null) {
            welfareDB = new PublicWelfareDB(context);
        }
        return welfareDB;
    }

    public void saveUser(User user) {
        if (user != null) {
            ContentValues values = new ContentValues();
            values.put("account", user.getAccount());
            values.put("password", user.getPassword());
            values.put("phonenumber",user.getPhonenumber());
            values.put("integral",user.getIntegral());
            values.put("thelength",user.getThelength());
            values.put("welfareeventId",user.getWelfareid());
            values.put("photoaddress",user.getPhotoaddress());
            db.insert("USER", null, values);
        }
    }

    public static List<User> loadUser() {
        List<User> list = new ArrayList<User>();
        Cursor cursor = db.query("USER", null, null, null, null, null, null);
        if (cursor.moveToFirst())
            do {
                User user = new User();
                user.setId(cursor.getColumnIndex("id"));
                user.setAccount(cursor.getString(cursor.getColumnIndex("account")));
                user.setPassword(cursor.getString(cursor.getColumnIndex("password")));
                list.add(user);
            } while (cursor.moveToNext());
        return list;
    }


    public void saveEvent(Event event)
    {
        if (event != null)
        {
            ContentValues values = new ContentValues();
            values.put("Thing",event.getThing());
            values.put("Address",event.getAddress());
            db.insert("Event",null,values);

        }
    }

    public List<Event> loadEvent() {
        List<Event> list = new ArrayList<Event>();
        Cursor cursor = db
                .query("Event", null, null, null, null, null, null);
        if (cursor.moveToFirst())
            do {
                Event event = new Event();
                event.setThing(cursor.getString(cursor.getColumnIndex("Thing")));
                event.setAddress(cursor.getString(cursor.getColumnIndex("Address")));
                list.add(event);
            } while (cursor.moveToNext());
        return list;
    }
    //读取某条记录
    public List<Event> loadSomeEvent(String thing) {
        List<Event> list = new ArrayList<Event>();
        Cursor cursor = db.query("Event", null, "Thing = ?",
                new String[] { String.valueOf(thing) }, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                Event event = new Event();
                event.setThing(cursor.getString(cursor.getColumnIndex("Thing")));
                event.setAddress(cursor.getString(cursor.getColumnIndex("Address")));

                list.add(event);
            } while (cursor.moveToNext());
        }
        return list;
    }

}
