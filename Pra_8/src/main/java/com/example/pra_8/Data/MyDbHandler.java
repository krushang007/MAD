package com.example.pra_8.Data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.pra_8.Model.Student;
import com.example.pra_8.Params.Params;

import java.util.ArrayList;
import java.util.List;

public class MyDbHandler extends SQLiteOpenHelper {
    public MyDbHandler(Context context) {
        super(context, Params.DB_NAME, null, Params.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String create="CREATE TABLE "+Params.TABLE_NAME+"("+Params.KEY_ID+" INTEGER PRIMARY KEY,"
                +Params.KEY_NAME+" TEXT,"+Params.KEY_SPI+" TEXT,"+Params.KEY_CPI+" TEXT"+")";
        Log.d("DBMITESH","Query being run is : "+create);
        sqLiteDatabase.execSQL(create);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void addStudent(Student student){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Params.KEY_NAME,student.getName());
        values.put(Params.KEY_SPI,student.getSpi());
        values.put(Params.KEY_CPI,student.getCpi());

        db.insert(Params.TABLE_NAME,null,values);
        Log.d("DBMITESH","Data inserted successfully.");
        db.close();
    }

    public List<Student> getAllStudents(){
        List<Student> studentList = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();

        //generate query to read all records
        String select = "SELECT * FROM "+Params.TABLE_NAME;
        Cursor cursor = db.rawQuery(select,null);

        //loop through now
        if(cursor.moveToFirst()){
            do{
                Student student = new Student();
                student.setId(Integer.parseInt(cursor.getString(0)));
                student.setName(cursor.getString(1));
                student.setSpi(cursor.getString(2));
                student.setCpi(cursor.getString(3));
                studentList.add(student);
            }while (cursor.moveToNext());
        }
        return studentList;
    }

    public int updateStudent(Student student){
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Params.KEY_NAME,student.getName());
        values.put(Params.KEY_SPI,student.getSpi());
        values.put(Params.KEY_CPI,student.getCpi());

        //lets update now
        return db.update(Params.TABLE_NAME,values,Params.KEY_ID+"=?",
                new String[]{String.valueOf(student.getId())});
    }

    public void deleteStudentById(int id){
        SQLiteDatabase db = getWritableDatabase();
        db.delete(Params.TABLE_NAME,Params.KEY_ID+"=?",new String[]{String.valueOf(id)});
        db.close();
    }

    public void deleteStudentByName(Student student){
        SQLiteDatabase db = getWritableDatabase();
        db.delete(Params.TABLE_NAME,Params.KEY_ID+"=?",new String[]{String.valueOf(student.getId())});
        db.close();
    }

    public int getCount(){
        String query = "SELECT * FROM "+Params.TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query,null);
        return cursor.getCount();
    }
}
