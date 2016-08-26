package com.example.angad.golfscorecard.UI;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.example.angad.golfscorecard.R;
import com.example.angad.golfscorecard.model.Hole;

public class CustomArrayAdapter extends BaseAdapter{
    Context mContext;
    Hole[]mHoles;

    public CustomArrayAdapter(Context context,Hole[]holes){
        mContext=context;
        mHoles=holes;
    }

    @Override
    public int getCount() {
        return mHoles.length;
    }

    @Override
    public Object getItem(int position) {
        return mHoles[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder=new ViewHolder();
        if(convertView==null){
            convertView= LayoutInflater.from(mContext).inflate(R.layout.list_item_view,null);
            holder.holeNumber=(TextView)convertView.findViewById(R.id.holeLabel);
            holder.count=(TextView)convertView.findViewById(R.id.countLabel);
            holder.DecrementButton=(Button)convertView.findViewById(R.id.decrementButton);
            holder.incrementButton=(Button)convertView.findViewById(R.id.incrementButton);
            convertView.setTag(holder);
        }
        final ViewHolder mHolder=(ViewHolder)convertView.getTag();
        mHolder.holeNumber.setText("Hole "+mHoles[position].getHoleNumber()+":");
        mHolder.count.setText(mHoles[position].getCount()+"");
        mHolder.DecrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int newCount=mHoles[position].getCount()-1;
                if(newCount<0) newCount=0;
                mHoles[position].setCount(newCount);
                mHolder.count.setText(mHoles[position].getCount()+"");
            }
        });
        mHolder.incrementButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int newCount=mHoles[position].getCount()+1;
                mHoles[position].setCount(newCount);
                mHolder.count.setText(mHoles[position].getCount()+"");

            }
        });
        return convertView;
    }

    public  static class ViewHolder{
        TextView holeNumber;
        TextView count;
        Button incrementButton;
        Button DecrementButton;
    }
}
