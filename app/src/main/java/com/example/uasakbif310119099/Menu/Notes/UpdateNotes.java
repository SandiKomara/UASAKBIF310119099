package com.example.uasakbif310119099.Menu.Notes;
/*

NIM   : 10119099
Nama  : Sandi Komara
Kelas : IF-3

 */
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.uasakbif310119099.R;

public class UpdateNotes extends AppCompatActivity {

    protected Cursor cursor;
    Database database;
    Button btn_save;
    EditText title,description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_notes);
        database = new Database(this);
        title = findViewById(R.id.title);
        description = findViewById(R.id.description);
        btn_save = findViewById(R.id.btn_simpan);
        SQLiteDatabase db = database.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM notes WHERE title = '" +
                getIntent().getStringExtra("title") + "'", null);
        cursor.moveToFirst();
        if (cursor.getCount() > 0){
            cursor.moveToPosition(0);
            title.setText(cursor.getString(0).toString());
            description.setText(cursor.getString(1).toString());
        }
        btn_save.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                SQLiteDatabase db = database.getWritableDatabase();
                db.execSQL("UPDATE notes SET  title= '"+ title.getText().toString() + "', description= '" +
                        description.getText().toString() + "' where title = '" +
                        getIntent().getStringExtra("title")+"'");
                Toast.makeText(UpdateNotes.this, "Data Berhasil di Update!", Toast.LENGTH_SHORT).show();
                Notes.notes.RefreshList();
                finish();
            }
        });
    }
}