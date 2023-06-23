package com.roomdb.listviewnsearch;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    //global variables
    private ListView listView;
    private SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //initializing variables
        listView = findViewById(R.id.listViewid);
        searchView = findViewById(R.id.searchView);
        String[] programming_language = getResources().getStringArray(R.array.programming_language);


        //adapter create and set
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, R.layout.sample_layout, R.id.textViewId, programming_language);
        listView.setAdapter(adapter);
        //setting action
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String value = programming_language[i];
                Toast.makeText(MainActivity.this, value, Toast.LENGTH_SHORT).show();
            }
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {


                adapter.getFilter().filter(s);

                return false;

            }
        });


    }
}