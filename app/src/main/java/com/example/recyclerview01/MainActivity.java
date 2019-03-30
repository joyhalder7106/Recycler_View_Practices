package com.example.recyclerview01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    MyAdepter myAdepter;
    RecyclerView recyclerView;
    String [] PersonName,dis;
    int [] img={R.drawable.ripon,R.drawable.ripon,R.drawable.ripon,R.drawable.ripon,
            R.drawable.ripon,R.drawable.ripon};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerView);
        PersonName=getResources().getStringArray(R.array.pName);
        dis=getResources().getStringArray(R.array.disc);

        myAdepter=new MyAdepter(this,PersonName,dis,img);
        recyclerView.setAdapter(myAdepter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        myAdepter.setOnItemClickListener(new MyAdepter.ClickListener() {
            @Override
            public void onItemClickListener(int position, View v) {

                Toast.makeText(getApplicationContext(),"onItemClickListener is Clicked",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onItemLongClickListener(int position, View v) {
                Toast.makeText(getApplicationContext(),"onItemLongClickListener is Clicked",Toast.LENGTH_SHORT).show();

            }
        });


    }
}
