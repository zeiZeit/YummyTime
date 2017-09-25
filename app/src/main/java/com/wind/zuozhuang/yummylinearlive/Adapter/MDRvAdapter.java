package com.wind.zuozhuang.yummylinearlive.Adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.wind.zuozhuang.yummylinearlive.R;

import java.util.ArrayList;



/**
 * This implementation of {@link RecyclerView.Adapter}
 *
 * Created by KyoWang on 2016/06/30 .
 */
public class MDRvAdapter extends RecyclerView.Adapter<MDRvAdapter.ViewHolder>{

    /**
     * 展示数据
     */
    private ArrayList<int[]> mData;
    private ArrayList<String[]> mInts;

    private int[] images =new int[]{
            R.drawable.empty,
            R.drawable.all,
            R.drawable.down,
            R.drawable.left,
            R.drawable.right,
            R.drawable.up,
            R.drawable.updown,
            R.drawable.upleft,
            R.drawable.upright,
    };
    /**
     * 事件回调监听
     */
    private MDRvAdapter.OnItemClickListener onItemClickListener;

    public MDRvAdapter(ArrayList<int[]> data) {
        this.mData = data;
    }

    public void updateData(ArrayList<int[]> data) {
        this.mData = data;
        notifyDataSetChanged();
    }

    /**
     * 添加新的Item
     */
    public void addNewItem() {
        if(mData == null) {
            mData = new ArrayList<>();
        }
        //mData.add(0, "new Item");
        notifyItemInserted(0);
    }

    /**
     * 删除Item
     */
    public void deleteItem() {
        if(mData == null || mData.isEmpty()) {
            return;
        }
        mData.remove(0);
        notifyItemRemoved(0);
    }

    /**
     * 设置回调监听
     *
     * @param listener
     */
    public void setOnItemClickListener(MDRvAdapter.OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // 实例化展示的view
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_rv_item, parent, false);
        // 实例化viewholder
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        // 绑定数据
    //    holder.mTv.setText(mData.get(position));
        int[] ints = mData.get(position);
        Log.i("zuozhuang", "onBindViewHolder: "+ints.toString());
        holder.mIB0.setImageResource(images[ints[0]]);
        holder.mIB1.setImageResource(images[ints[1]]);
        holder.mIB2.setImageResource(images[ints[2]]);
        holder.mIB3.setImageResource(images[ints[3]]);
        holder.mIB4.setImageResource(images[ints[4]]);
        holder.mIB5.setImageResource(images[ints[5]]);
        holder.mIB6.setImageResource(images[ints[6]]);
        holder.mIB7.setImageResource(images[ints[7]]);
        holder.mIB8.setImageResource(images[ints[8]]);

      //  holder.mIB1.setImageResource(R.drawable.rightdown);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                if(onItemClickListener != null) {
                    int pos = holder.getLayoutPosition();
                    onItemClickListener.onItemClick(holder.itemView, pos);
                }
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if(onItemClickListener != null) {
                    int pos = holder.getLayoutPosition();
                    onItemClickListener.onItemLongClick(holder.itemView, pos);
                }
                //表示此事件已经消费，不会触发单击事件
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
       return mData == null ? 0 : mData.size();

    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        //TextView mTv;
        ImageButton mIB1 ;
        ImageButton mIB2 ;
        ImageButton mIB3 ;
        ImageButton mIB4 ;
        ImageButton mIB0 ;
        ImageButton mIB5 ;
        ImageButton mIB6 ;
        ImageButton mIB7 ;
        ImageButton mIB8 ;

        public ViewHolder(View itemView) {
            super(itemView);
            //mTv = (TextView) itemView.findViewById(R.id.item_tv);
            mIB1 = (ImageButton) itemView.findViewById(R.id.ib1);
            mIB2 = (ImageButton) itemView.findViewById(R.id.ib2);
            mIB3 = (ImageButton) itemView.findViewById(R.id.ib3);
            mIB4 = (ImageButton) itemView.findViewById(R.id.ib4);
            mIB0 = (ImageButton) itemView.findViewById(R.id.ib0);
            mIB5 = (ImageButton) itemView.findViewById(R.id.ib5);
            mIB6 = (ImageButton) itemView.findViewById(R.id.ib6);
            mIB7 = (ImageButton) itemView.findViewById(R.id.ib7);
            mIB8 = (ImageButton) itemView.findViewById(R.id.ib8);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
        void onItemLongClick(View view, int position);
    }
}
