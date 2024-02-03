package com.example.datakaryawan2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText Divisi, Namakaryawan, Jabatan, Email , Cabangkantor;
    private Kantordatabase database;
    private Button btnSave;
    private int uid = 0;
    private boolean isEdit = false;
    long timestamp = System.currentTimeMillis();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Divisi = findViewById(R.id.edt_divisi);
        Namakaryawan = findViewById(R.id.edt_nama);
        Jabatan = findViewById(R.id.edt_Jabatan);
        Email = findViewById(R.id.edt_email);
        Cabangkantor = findViewById(R.id.edt_cabang);
        btnSave = findViewById(R.id.btn_save);

        database = Kantordatabase.getInstance(getApplicationContext());

        Intent intent = getIntent();
        uid = intent.getIntExtra("uid", 0);
        if (uid>0){
            isEdit = true;
            userkantor userkantor = database.NoteDao().get(uid);
            Divisi.setText(userkantor.Divisi);
            Namakaryawan.setText(userkantor.Namakaryawan);
            Jabatan.setText(userkantor.Jabatan);
            Email.setText(userkantor.Email);
            Cabangkantor.setText(userkantor.Cabangkantor);
            Toast.makeText(getApplicationContext(),"Berhasil Diubah!!",Toast.LENGTH_SHORT).show();
        }else{
            isEdit = false;
        }

        btnSave.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (isEdit){
                    database.NoteDao().update(uid, Divisi.getText().toString(), Namakaryawan.getText().toString(), Jabatan.getText().toString(), String.valueOf(Email.getText()), Cabangkantor.getText().toString(),timestamp);
                }else{
                    database.NoteDao().insertAll(Divisi.getText().toString(), Namakaryawan.getText().toString(), Jabatan.getText().toString(), String.valueOf(Email.getText()), Cabangkantor.getText().toString(), timestamp);
                }
                finish();
                Toast.makeText(getApplicationContext(),"Berhasil Disimpan!!",Toast.LENGTH_SHORT).show();
            }
        });
    }
}