package mgit.tabactivityimpl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by bachu_000 on 24-05-2016.
 */
public class DatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Mgitapp";
    public static final String TABLE_NAME = "Timetable";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "DAY";
    public static final String COL_3 = "SUBJ";
    public static final String COL_4 = "HOUR";



    public DatabaseHelper(Context context){
        super(context,DATABASE_NAME,null,1);
        SQLiteDatabase db = this.getWritableDatabase();
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table " + TABLE_NAME + " (ID INTEGER PRIMARY KEY AUTOINCREMENT,DAY TEXT,SUBJ TEXT,HOUR INTEGER)");


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String day,String subj,String hour){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(COL_2,day);
        cv.put(COL_3, subj);
        cv.put(COL_4, hour);
        long result=db.insert(TABLE_NAME,null,cv);
        if(result==-1){
            return false;
        }
        else
        {
            return true;
        }
    }
    public Cursor getAllData(String day){
        SQLiteDatabase db=this.getWritableDatabase();
        Cursor res=db.rawQuery("select * from Timetable where DAY=?", new String[] {day});
        return res;
    }

    /*public boolean updateData(String id,String present,String absent,String total){
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(COL_21,id);
        cv.put(COL_22,present);
        cv.put(COL_23,absent);
        cv.put(COL_24, total);
        db.update(TABLE_NAME,cv,"ID = ?",new String[] {id});
        return true;
    }*/
}
