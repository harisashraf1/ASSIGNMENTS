package com.example.fawad.todoapp;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.zip.Inflater;

/**
 * Created by Fawad on 12/10/2017.
 */

public class myAdapter extends RecyclerView.Adapter<myAdapter.ViewHolder> {
    private ArrayList<String> mDataset;

    public myAdapter(ArrayList<String> myDataset) {
        mDataset = myDataset;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v=LayoutInflater.from(parent.getContext()).inflate(R.layout.todo_row,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.Bind(mDataset.get(position));
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public TextView desp;
        public CheckBox check;
        public ViewHolder(View v) {
            super(v);
            title=v.findViewById(R.id.textView);
            desp=v.findViewById(R.id.textView2);
            check=v.findViewById(R.id.checkBox);
            check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    String[] tempData = new String[MainActivity.Data.size()];
                    tempData = MainActivity.Data.toArray(tempData);
                    if(b){
                        title.setTextColor(Color.LTGRAY);
                        desp.setTextColor(Color.LTGRAY);
                        for (int i=0;i<tempData.length;i++) {
                            String[] data=tempData[i].split(",");
                            if(data[0].equals(itemView.getTag())){
                                data[3]="1";
                                MainActivity.Data.set(i,TextUtils.join(",",data));

                            }
                        }
                    }
                    else{
                        title.setTextColor(Color.BLACK);
                        desp.setTextColor(Color.BLACK);
                        for (int i=0;i<tempData.length;i++) {
                            String[] data=tempData[i].split(",");
                            if(data[0].equals(itemView.getTag())){
                                data[3]="0";
                                MainActivity.Data.set(i ,TextUtils.join(",",data));

                            }
                        }
                    }
                }
            });
        }
        public void Bind(String data){
           String[] dataSplited= data.split(",");
           itemView.setTag(dataSplited[0]);
           title.setText(dataSplited[1]);
           desp.setText(dataSplited[2]);
           Boolean checked=dataSplited[3].equals("1")? true:false;
           check.setChecked(checked);
           if(check.isChecked()){
               title.setTextColor(Color.LTGRAY);
               desp.setTextColor(Color.LTGRAY);
           }
           else{
               title.setTextColor(Color.BLACK);
               desp.setTextColor(Color.BLACK);

           }
        }

    }

}
