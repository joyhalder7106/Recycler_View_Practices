package com.example.recyclerview01;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class MyAdepter extends RecyclerView.Adapter<MyAdepter.MyViewHolder> {
   private static ClickListener clickListener;
    Context context;
    RecyclerView recyclerView;
    String [] PersonName,dis;
    int [] img;

    public MyAdepter(Context context, String[] personName, String[] dis, int[] img) {

        this.context = context;
        PersonName = personName;
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
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

        myViewHolder.textView1.setText(PersonName[i]);
        myViewHolder.textView2.setText(dis[i]);
        myViewHolder.imageView.setImageResource(img[i]);
    }

    @Override
    public int getItemCount() {
        return PersonName.length;
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

        TextView textView1,textView2;
        ImageView imageView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView1=itemView.findViewById(R.id.textView1);
            textView2=itemView.findViewById(R.id.textView2);
            imageView=itemView.findViewById(R.id.imageView);

            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        @Override
        public void onClick(View v) {

            clickListener.onItemClickListener(getAdapterPosition(),v);
        }

        @Override
        public boolean onLongClick(View v) {
            clickListener.onItemLongClickListener(getAdapterPosition(),v);
            return false;
        }
    }
    public interface ClickListener{
        void onItemClickListener(int position,View v);
        void onItemLongClickListener(int position,View v);

    }
    public void setOnItemClickListener(ClickListener clickListener){
       MyAdepter.clickListener=clickListener;
    }
}
