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

import java.text.SimpleDateFormat;
import java.util.Date;

public class CreateNotes extends AppCompatActivity {

    protected Cursor cursor;
    Database database;
    Button btn_save;
    EditText title,description,tgl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_notes);
        database = new Database(this);
        title = findViewById(R.id.title);
        description = findViewById(R.id.description);
        btn_save = findViewById(R.id.btn_simpan);
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pattern = "dd-MM-yyyy";
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
                String date = simpleDateFormat.format(new Date());
                SQLiteDatabase db = database.getWritableDatabase();
                db.execSQL("INSERT INTO notes(title, description, tgl) values('" +
                        title.getText().toString()+ "','" +
                        description.getText().toString() +"','"+ date + "')");
                Toast.makeText(CreateNotes.this, "Data Tersimpan!", Toast.LENGTH_SHORT).show();
                Notes.notes.RefreshList();
                finish();
            }
        });
    }
}