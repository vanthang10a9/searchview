package com.example.scrollview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.Locale;

public class ItemAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater layoutInflater;
    private List<Person> personList;

    public ItemAdapter(Context mContext, List<Person> personList) {
        this.mContext = mContext;
        this.layoutInflater = LayoutInflater.from(mContext);
        this.personList = personList;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = new ViewHolder();
        if(view == null) {
            view = layoutInflater.inflate(R.layout.layout_item, viewGroup);
            viewHolder.textViewName = view.findViewById(R.id.textViewName);
            viewHolder.textViewAge = view.findViewById(R.id.textViewAge);
            view.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) view.getTag();
        }
        viewHolder.textViewName.setText(personList.get(i).getName());
        viewHolder.textViewAge.setText(personList.get(i).getAge());
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
            personList.addAll(personList);
        } else {
            for (Person wp : personList) {
                if (wp.getName().toLowerCase(Locale.getDefault()).contains(charText)) {
                    personList.add(wp);
                }
            }
        }
        notifyDataSetChanged();
    }

}
