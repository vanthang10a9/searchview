package com.example.scrollview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ItemAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater layoutInflater;
    private List<Person> personList;
    private ArrayList<Person> arrayList;

    public ItemAdapter(Context mContext, List<Person> personList) {
        this.mContext = mContext;
        this.layoutInflater = LayoutInflater.from(mContext);
        this.personList = personList;
        this.arrayList  = new ArrayList<Person>();
        this.arrayList.addAll(personList);
    }

    @Override
    public int getCount() {
        return personList.size();
    }

    @Override
    public Object getItem(int i) {
        return personList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = new ViewHolder();
        if(view == null) {
            view = layoutInflater.inflate(R.layout.layout_item, viewGroup, false);
            viewHolder.textViewName = view.findViewById(R.id.textViewName);
            viewHolder.textViewAge = view.findViewById(R.id.textViewAge);
            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.textViewName.setText("Name: " + personList.get(i).getName());
        viewHolder.textViewAge.setText("Age: " + personList.get(i).getAge());
        return view;
    }

    static class ViewHolder {
         TextView textViewName;
         TextView textViewAge;
    }
    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        personList.clear();
        if (charText.length() == 0) {
            personList.addAll(arrayList);
        } else {
            for (Person wp : arrayList) {
                if (wp.getName().toLowerCase(Locale.getDefault()).contains(charText)) {
                    personList.add(wp);
                }
            }
        }
        notifyDataSetChanged();
    }

}
