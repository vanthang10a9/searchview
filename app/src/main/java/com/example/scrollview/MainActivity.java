package com.example.scrollview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
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
}
