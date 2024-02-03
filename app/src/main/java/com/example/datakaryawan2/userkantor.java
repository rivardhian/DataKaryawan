package com.example.datakaryawan2;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class userkantor{
    @PrimaryKey
    public int uid;

    @ColumnInfo(name = "name")
    public String Divisi;

    public String Namakaryawan;

    public String Jabatan;

    public String Email;

    public String Cabangkantor;
    @ColumnInfo(name = "timestamp")
    public long timestamp;
}
