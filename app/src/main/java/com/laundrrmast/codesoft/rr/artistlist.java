package com.laundrrmast.codesoft.rr;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by CodeSoft on 7/4/2017.
 */

public class artistlist extends ArrayAdapter<artest> {
    private Activity context;
    private List<artest> artistList;

    public artistlist (Activity context, List<artest> artistlist){
        super(context,R.layout.listlayout,artistlist);
this.context=context;
        this.artistList=artistlist;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = context.getLayoutInflater();
        View ListViewItem = inflater.inflate(R.layout.listlayout,null,true);
        TextView textViewName = (TextView) ListViewItem.findViewById(R.id.textView200);
        TextView textViewGa = (TextView) ListViewItem.findViewById(R.id.textView00);

        artest artest1 = artistList.get(position);
        textViewName.setText(artest1.getArtestName());
        textViewGa.setText(artest1.getArtestG());
        return ListViewItem;
    }
}
