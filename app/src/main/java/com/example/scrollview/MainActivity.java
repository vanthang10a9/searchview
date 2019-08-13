package com.example.scrollview;

import androidx.appcompat.widget.SearchView;
import android.os.Bundle;
import android.widget.ListView;


import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {
    private SearchView mSearchView;
    private ListView mListView;
//    List<Person> mData;
    ItemAdapter mItemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSearchView = (SearchView) findViewById(R.id.searchView);
        mListView = (ListView) findViewById(R.id.listView);

        mItemAdapter = new ItemAdapter(this, addData());
        mListView.setAdapter(mItemAdapter);

        mSearchView.setOnQueryTextListener(this);

    }
    private List<Person> addData(){
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Sam Smith", "25"));
        personList.add(new Person("Sam Smith", "25"));
        personList.add(new Person("Sam Smith", "25"));
        personList.add(new Person("Sam Smith", "25"));
        personList.add(new Person("Sam Smith", "25"));
        personList.add(new Person("Sam Smith", "25"));
        personList.add(new Person("Sam Smith", "25"));
        personList.add(new Person("Sam Smith", "25"));

        return personList;
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        String text = newText;
        mItemAdapter.filter(text);
        return false;
    }
}
