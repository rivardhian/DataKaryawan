package com.example.datakaryawan2;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Query;
import java.util.List;

@Dao
public interface NoteDao {
    @Query("SELECT * FROM userkantor")
    List<userkantor> getAll();

    @Query("INSERT INTO userkantor (name, namakaryawan,jabatan,email,cabangkantor,timestamp) VALUES(:name, :Namakaryawan,:Jabatan,:Email,:Cabangkantor,:timestamp)")
    void insertAll(String name, String Namakaryawan, String Jabatan, String Email, String Cabangkantor, long timestamp);

    @Query("UPDATE userkantor SET name=:name, namakaryawan=:Namakaryawan, jabatan=:Jabatan, email=:Email ,cabangkantor=:Cabangkantor, timestamp=:timestamp WHERE uid=:uid")
    void update(int uid, String name, String Namakaryawan, String Jabatan, String Email, String Cabangkantor, long timestamp);

    @Query("SELECT * FROM userkantor WHERE uid=:uid")
    userkantor get(int uid);

    @Delete
    void delete(userkantor userkantor);
}