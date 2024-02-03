package com.example.datakaryawan2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Kantoradapter extends RecyclerView.Adapter<Kantoradapter.ViewAdapter> {
    private List<userkantor> list;
    private Context context;
    private Dialog dialog;

    public interface Dialog {
        void onClick(int position);
    }

    public void setDialog(Dialog dialog) {
        this.dialog = dialog;
    }

    public Kantoradapter(Context context, List<userkantor> list){
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false);
        return new ViewAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewAdapter holder, int position) {
        holder.Divisi.setText(list.get(position).Divisi);
        holder.Namakaryawan.setText(list.get(position).Namakaryawan);
        holder.Jabatan.setText(list.get(position).Jabatan);
        holder.Email.setText(list.get(position).Email);
        holder.Cabangkantor.setText(list.get(position).Cabangkantor);
        holder.setTimestamp(list.get(position).timestamp);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewAdapter extends RecyclerView.ViewHolder{
        TextView Divisi, Namakaryawan, Jabatan, Email, Cabangkantor, waktu;

        public ViewAdapter(@NonNull View itemView) {
            super(itemView);
            Divisi = itemView.findViewById(R.id.tv_Divisi);
            Namakaryawan = itemView.findViewById(R.id.tv_Nama);
            Jabatan = itemView.findViewById(R.id.tv_Jabatan);
            Email = itemView.findViewById(R.id.tv_Email);
            Cabangkantor = itemView.findViewById(R.id.tv_Cabang);
            waktu = itemView.findViewById(R.id.tv_waktu);

            itemView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    if (dialog!=null){
                        dialog.onClick(getLayoutPosition());
                    }
                }
            });
        }
        public void setTimestamp(long timestamp) {
            // Konversi timestamp ke format waktu yang diinginkan (Anda dapat menggunakan SimpleDateFormat)
            // Objek SimpleDateFormat dengan format yang diinginkan
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy || HH:mm");

            // Konversi timestamp ke format waktu yang diinginkan
            String formattedTime = sdf.format(new Date(timestamp));

            // Setel formattedTime pada TextView atau tempat yang sesuai
            waktu.setText(formattedTime);
        }
    }
}