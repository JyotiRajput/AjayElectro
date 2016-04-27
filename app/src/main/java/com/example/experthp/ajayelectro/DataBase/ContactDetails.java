package com.example.experthp.ajayelectro.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by expert HP on 27/04/2016.
 */
public class ContactDetails {

    public static final String Key_Id="id";
    public static final String Key_Name="Name";
    public static final String Key_Email="Email";
    public static final String Key_PhNo="PhNo";
    public static final String Key_Pass="Password";
    //public static final String Key_PhNo="PhNo";


    private static final String Tag="DBAdapter1";
    private static final String DataBase_Name="App_DataBase.db";
    private static final String table_Name="Registration";
    private static final int DataBase_Version=1;

    private static final String DataBase_Create="CREATE TABLE " + table_Name + "(" + Key_Id
            + " INTEGER PRIMARY KEY AUTOINCREMENT, " + Key_Name + " VARCHAR NOT NULL, " + Key_Email + " VARCHAR,"+Key_PhNo+" VARCHAR,"+Key_Pass+" VARCHAR);";


    private final Context context;
    private DatabaseHelper DBHelper;
    private SQLiteDatabase db;

    public ContactDetails(Context ctx){
        this.context=ctx;
        DBHelper=new DatabaseHelper(context);
    }


    private static class DatabaseHelper extends SQLiteOpenHelper
    {
        DatabaseHelper(Context context){
            super(context,DataBase_Name,null,DataBase_Version);
        }
        @Override
        public void onCreate(SQLiteDatabase db)
        {
            try{
                db.execSQL(DataBase_Create);
                Log.d("hi", "created");
            }
            catch(SQLException e){
                e.printStackTrace();
            }
        }
        public void onUpgrade(SQLiteDatabase db,int oldVersion,int newVersion){
            Log.w(Tag,oldVersion+"was the version.The new version is -"+newVersion);
            db.execSQL("DROP TABLE IF EXISTS " + table_Name);
            onCreate(db);


        }
    }

    public ContactDetails open() throws SQLException{
        db=DBHelper.getWritableDatabase();
        return this;
    }

    public void close(){
        DBHelper.close();
    }

    public void insertRecord(String Name,String Email,String Ph,String pass){
        ContentValues initialValue = new ContentValues();
        initialValue.put(Key_Name,Name);
        initialValue.put(Key_Email,Email);
        initialValue.put(Key_PhNo, Ph);
        initialValue.put(Key_Pass,pass);
        db.insert(table_Name, null, initialValue);
    }

    public boolean deleteRecord(long rowid){
        return  db.delete(table_Name,Key_Id+"="+rowid,null)>0;
    }
    //Retrieve all records
    public Cursor getAllRecord(){
        return db.query(table_Name,new String[]{Key_Id,Key_Name,Key_Email,Key_PhNo},null,null,null,null,null);
    }
    //retrieve particular record
    public Cursor getRecord(String email){
        Cursor myCursor= db.query(table_Name,new String[]{Key_Id,Key_Name,Key_Email,Key_PhNo},Key_Name+"="+"'"+email+"'",null,null,null,null,null);

        if (myCursor!=null)
        {
            myCursor.moveToFirst();
        }
        return myCursor;
    }
    public Cursor matchPassword(String email){
        Cursor myCursor= db.query(table_Name,new String[]{Key_Pass},Key_Email+"="+'?' ,new String[]{String.valueOf(email)},null,null,null,null);
        //Cursor myCursor= db.query(table_Registration1,new String[]{Key_Pass},Key_Name+"="+"'"+email+"'",null,null,null,null,null);

        if (myCursor!=null)
        {
            myCursor.moveToFirst();
        }
        return myCursor;
    }
    public boolean updateRecord(String rowid,String name,String email,String ph){
        ContentValues updateContent= new ContentValues();
        updateContent.put(Key_Name,name);
        updateContent.put(Key_Email,email);
        updateContent.put(Key_PhNo,ph);
        return db.update(table_Name,updateContent,Key_Id+"="+rowid,null)>0;

    }





}

