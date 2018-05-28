package com.example.will.tipcalcdb;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

/**
 * Created by Will on 5/24/2018.
 */

public class TipListAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Tip> tips;

    public void TipListAdapter(Context context, ArrayList<Tip> tips){
        this.context = context;
        this.tips = tips;
    }//end constructor

    @Override
    public int getCount() {
        return tips.size();
    }

    @Override
    public Object getItem(int position) {
        return tips.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TipLayout tipLayout = null;
        Tip tip = tips.get(position);

        if(convertView == null){
            tipLayout = new TipLayout(context,tip);
        } else {
            tipLayout = (TipLayout) convertView;
            tipLayout.setTip(tip);
        }

        return tipLayout;
    }
}
