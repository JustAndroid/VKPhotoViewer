package com.nikolay.vkphotoviewer.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;

import com.nikolay.vkphotoviewer.R;

/**
 * Created by Николай on 26.04.2016.
 */
public class AlbomsAdapter extends ArrayAdapter {

    public AlbomsAdapter(Context context, int resource) {
        super(context, resource);
    }

    @Override
    public int getPosition(Object item) {
        return super.getPosition(item);
    }

    @Override
    public Object getItem(int position) {
        return super.getItem(position);
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View root = LayoutInflater.from(getContext()).inflate(R.layout.image_list_item,parent,false);




        return root;
    }
}
