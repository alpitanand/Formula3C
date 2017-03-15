package com.example.alpit.formula2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class FavoritePage extends AppCompatActivity implements OnItemClickListener {

    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite_page);
        DataBaseHandler db = new DataBaseHandler(this);
        lv = (ListView) findViewById(R.id.listView);
        lv.setOnItemClickListener(this);
        ArrayAdapter<String> arr2 = new ArrayAdapter<String>(getApplicationContext(), R.layout.simple_colum, db.getalllist());
        lv.setAdapter(arr2);
        lv.setDivider(null);

    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String data = (String) parent.getItemAtPosition(position);
       Class<?>c=null;
        if(data!=null)
       {
           try {
c=Class.forName("com.example.alpit.formula2."+data);
           }
           catch (ClassNotFoundException e)
           {
               e.printStackTrace();
           }
       }
Intent intent= new Intent(FavoritePage.this,c);
        startActivity(intent);
    }
}
