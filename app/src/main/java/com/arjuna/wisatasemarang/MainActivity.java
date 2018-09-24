package com.arjuna.wisatasemarang;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.arjuna.wisatasemarang.Model.Wisata;
import com.arjuna.wisatasemarang.Model.WisataData;

import java.util.ArrayList;

import static com.arjuna.wisatasemarang.DetailActivity.EX_Lat;
import static com.arjuna.wisatasemarang.DetailActivity.EX_Long;

public class MainActivity extends AppCompatActivity {

    RecyclerView view;
    CustomAdapter adapter;
    ArrayList<Wisata> wisatas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // TODO Inlitialize Widget to Variable
        wisatas = new ArrayList<>();
        wisatas.addAll(WisataData.getWisata());

        view = findViewById(R.id.rclist);
        view.setLayoutManager(new LinearLayoutManager(this));
        adapter = new CustomAdapter(wisatas, MainActivity.this);
        view.setAdapter(adapter);



    }


    private class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder>{
        private ArrayList<Wisata> wisatas;
        private Context context;

        public CustomAdapter(ArrayList<Wisata> wisatas, Context context) {
            this.wisatas = wisatas;
            this.context = context;
        }

        @NonNull
        @Override
        public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(context).inflate(R.layout.listku , parent, false);
            return new MyViewHolder(v);
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, final int i) {
            holder.txtnya.setText(wisatas.get(i).getNama());
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(context, DetailActivity.class);
                    intent.putExtra(EX_Lat, wisatas.get(i).isLat());
                    intent.putExtra(EX_Long, wisatas.get(i).isLon());
                    context.startActivity(intent);

                }
            });
        }

        @Override
        public int getItemCount() {
            return wisatas.size();
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {
            TextView txtnya;
            public MyViewHolder(View itemView) {
                super(itemView);
                txtnya = itemView.findViewById(R.id.tempatnya);

            }
        }
    }
}
