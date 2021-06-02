package sg.edu.np.mad.mad02rev;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class DBHandler extends SQLiteOpenHelper {
    private final int HANDLE = 1;
    private final int LOC = 2;

    public DBHandler(@Nullable Context context) {
        super(context,  /* environment/activity*/
                "MADInstaDB.db", //database filename
                null, //factory can be null
                1); //version to tag the database that is created
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE POSTS (ID INTEGER PRIMARY KEY AUTOINCREMENT, HANDLE TEXT, LOCATION TEXT)");

        for(int i=0; i<20; i++)
        {
            ContentValues v = new ContentValues();
            v.put("HANDLE", "Handle #2" + i);
            v.put("LOCATION", "Loc 2" + i);
            sqLiteDatabase.insert("POSTS", null, v);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS POSTS");
        onCreate(sqLiteDatabase);
    }

    public ArrayList<Post> getAllPosts()
    {
        ArrayList<Post> data = new ArrayList<>();

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cur = db.rawQuery("SELECT * FROM POSTS", null);

        while(cur.moveToNext())
        {
            Post p = new Post();
            p.handle = cur.getString(HANDLE);
            p.location = cur.getString(LOC);

            data.add(p);
        }

        return data;
    }
}
