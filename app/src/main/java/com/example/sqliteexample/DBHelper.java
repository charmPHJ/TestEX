package com.example.sqliteexample;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    // 안전빵, 해킹방지 가둬두는것. private 호출할려고 해도 변수가 호출안되게함
    private static final int DB_VERSION = 1;
    private static final String DB_NAME = "parkdroid.db";

    public DBHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION); // null:아무것도 아닌, 비워둠
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        // 데이터 베이스가 생성 될 때 호출
        //데이터베이스(부모) > 테이블 > 컬럼 > 값(자식개념)
        // INTEGER:정수INT  // title NOT NULL=여기에 데이터를 비우면 안된다(규약)
        // 목차같은개념?( 제목, 내용, 컨텐츠)
        db.execSQL("CREATE TABLE IF NOT EXISTS TodoList (id INTEGER PRIMARY KEY AUTOINCREMENT, title TEXT NOT NULL, content TEXT NOT NULL, writeDate TEXT NOT NULL )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) //버전 업그레이드를 위한
    {
        onCreate(db);
    }

    // 할일목록을 db에 넣는다
    // INSERT 문 만들자 public void함수로 만들자 왜? 계속 자료올건데 insert나 delete 등 공용으로 쓰기위해
    // INSERT INTO 에 괄호 두번이나 넣는이유 처음엔 목차 그리고 자세한값 넣을려고 / ' "  싱글따옴표, 쌍따옴표 복잡함
    public void InsertTodo(String _title, String _content, String _writeDate) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL ("INSERT INTO TodoList (title, content, writeDate) VALUES('" + _title + "','" + _content + "', '" + _writeDate + "');");
   }

   ///git

    ///git
    ///git
    ///git
}

// dkfjsadklfj
