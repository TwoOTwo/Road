package DB;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class WelfareDB {
    public static final String DB_name = "welfare";
    public static final int VERSION = 1;
    private static WelfareDB welfareDB;
    private SQLiteDatabase db;


    private WelfareDB(Context context) {
        CreateTable createTable = new CreateTable(context, DB_name, null, VERSION);
        db = createTable.getWritableDatabase();
    }

    public synchronized static WelfareDB getInstance(Context context) {
        if (welfareDB == null) {
            welfareDB = new WelfareDB(context);
        }
        return welfareDB;
    }

    public void saveUser(User user) {
        if (user != null) {
            ContentValues values = new ContentValues();
            values.put("account", user.getAccount());
            values.put("username", user.getUsername());
            db.insert("User", null, values);
        }
    }

    public List<User> loadUser() {
        List<User> list = new ArrayList<User>();
        Cursor cursor = db
                .query("USER", null, null, null, null, null, null);
        if (cursor.moveToFirst())
            do {
                User user = new User();
                user.setId(cursor.getColumnIndex("id"));
                user.setAccount(cursor.getString(cursor.getColumnIndex("account")));
                user.setUsername(cursor.getString(cursor.getColumnIndex("username")));
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
