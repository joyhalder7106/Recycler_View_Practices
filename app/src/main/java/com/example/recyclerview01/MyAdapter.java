package com.example.recyclerview01;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    Context context;
    String [] PersonName,dis;
    int [] img;

    public MyAdapter(Context context, String[] personName, String[] dis, int[] img) {
        this.context = context;
        this.PersonName = personName;
        this.dis = dis;
        this.img = img;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater=LayoutInflater.from(context);
       View view= layoutInflater.inflate(R.layout.simple_view,viewGroup,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, final int i) {

        myViewHolder.textView1.setText(PersonName[i]);
        myViewHolder.textView2.setText(dis[i]);
        myViewHolder.imageView.setImageResource(img[i]);
        myViewHolder.sfdj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, PersonName[i], Toast.LENGTH_SHORT).show();
            }
        });
        myViewHolder.imageView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(context, PersonName[i], Toast.LENGTH_SHORT).show();

                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return PersonName.length;
    }
    class MyViewHolder extends RecyclerView.ViewHolder{
        TextView textView1,textView2;
        ImageView imageView;
        LinearLayout sfdj;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView1=itemView.findViewById(R.id.textView1);
            textView2=itemView.findViewById(R.id.textView2);
            imageView=itemView.findViewById(R.id.imageView);
            sfdj=itemView.findViewById(R.id.layoutId);
        }
    }
}
