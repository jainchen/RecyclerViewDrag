package com.bozo.touchsort;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Collections;
import java.util.List;

/**
 * Created by cj on 2017/3/16 0016.
 */

public class SortAdapter extends RecyclerView.Adapter<SortAdapter.ViewHolder> implements OnMovedListener{

    private List<String> data;

    private DragListener dragListener;

    public SortAdapter(List<String> data, DragListener dragListener){
        this.data = data;
        this.dragListener = dragListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sort, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.textView.setText(data.get(holder.getAdapterPosition()));

        holder.textView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                dragListener.onStartDrag(holder);
                return false;
            }
        });

        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(holder.itemView.getContext(), data.get(holder.getAdapterPosition()), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    @Override
    public void onMoved(int from, int to) {
        Collections.swap(data, from, to);
        notifyItemMoved(from, to);
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        TextView textView;

        public ViewHolder(View itemView) {
            super(itemView);

            textView = (TextView) itemView.findViewById(R.id.tv);
        }
    }
}
