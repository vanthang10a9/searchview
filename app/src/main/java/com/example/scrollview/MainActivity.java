package com.example.scrollview;

import androidx.appcompat.widget.SearchView;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {
    private SearchView mSearchView;
    private ListView mListView;
    private TextView mTextView;
//    List<Person> mData;
    ItemAdapter mItemAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSearchView = (SearchView) findViewById(R.id.searchView);
        mListView = (ListView) findViewById(R.id.listView);
        mTextView = (TextView) findViewById(R.id.textViewResult);

        mItemAdapter = new ItemAdapter(this, addData());
        mListView.setAdapter(mItemAdapter);

        mTextView.setText("Danh sách có sẵn: " + mItemAdapter.getCount() + " người");

        mSearchView.setOnQueryTextListener(this);

    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        String text = newText;
        mItemAdapter.filter(text);
        mTextView.setText("Danh sách kết quả: " + mItemAdapter.getCount() + " người");
        return false;
    }

    private List<Person> addData(){
        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person("Sam Smith", "25"));
        personList.add(new Person("Android Studio", "15"));
        personList.add(new Person("Benta John", "33"));
        personList.add(new Person("Carry Harris", "23"));
        personList.add(new Person("Danie Tranmister", "22"));
        personList.add(new Person("Else Samee", "11"));
        personList.add(new Person("Githow Anatini", "22"));
        personList.add(new Person("Hanru Oboxx", "43"));
        personList.add(new Person("Sam Smith", "25"));
        personList.add(new Person("Android Studio", "15"));
        personList.add(new Person("Benta John", "33"));
        personList.add(new Person("Carry Harris", "23"));
        personList.add(new Person("Danie Tranmister", "22"));
        personList.add(new Person("Else Samee", "11"));
        personList.add(new Person("Githow Anatini", "22"));
        personList.add(new Person("Hanru Oboxx", "43"));

        return personList;
    }
}
