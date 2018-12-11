package com.cn.chenji.adapter;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;
import com.cn.chenji.R;
import java.util.List;

/**
 * author by chenji on 2018/12/10
 */
public class ViewAdapter extends RecyclerView.Adapter<ViewAdapter.MyViewHolder>{
    private List<String>  contentList;
    private Context  myContext;
    public  onItemClickListener  onItemClickListener;

public  ViewAdapter(List<String> contentList,Context context)
{
    this.contentList=contentList;
    this.myContext=context;
}


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, final int i) {
        View view=LayoutInflater.from(myContext).inflate(R.layout.item_recycler,viewGroup,false);
        MyViewHolder  myViewHolder=new MyViewHolder(view);
        return myViewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, final int i) {
          myViewHolder.textView.setText(contentList.get(i));
          myViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickListener.onItemClickListener(view,i);
            }
        });
    }


    @Override
    public int getItemCount() {
        return contentList.size();
    }


    public void onItemClickListener(onItemClickListener onItemClickListener) {
        this.onItemClickListener=onItemClickListener;
    }


    class MyViewHolder extends  RecyclerView.ViewHolder{
        TextView textView;
        public MyViewHolder(View view)
        {
            super(view);
            textView = (TextView) view.findViewById(R.id.tv_item);
        }
    }

    public  interface  onItemClickListener{
        void onItemClickListener(View view,int position);
    }
}

