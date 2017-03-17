package com.bozo.touchsort;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements DragListener {

    RecyclerView rlv;
    private ItemTouchHelper itemTouchHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rlv = (RecyclerView) findViewById(R.id.rlv_sort);

        List<String> strings = new ArrayList<String>();
        for (int i=0;i<30;i++){
            strings.add("Item："+i);
        }

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rlv.setLayoutManager(linearLayoutManager);
        RecyclerViewItemDecoration itemDecoration = new RecyclerViewItemDecoration(this, RecyclerViewItemDecoration.LINEAR_DIVIDER_VERTICAL);
        rlv.addItemDecoration(itemDecoration);
        SortAdapter sortAdapter = new SortAdapter(strings, this);
        rlv.setAdapter(sortAdapter);

        SortTouchCallback sortTouchHelper = new SortTouchCallback(sortAdapter);
        itemTouchHelper = new ItemTouchHelper(sortTouchHelper);
        itemTouchHelper.attachToRecyclerView(rlv);
    }

    @Override
    public void onStartDrag(SortAdapter.ViewHolder viewHolder) {
        itemTouchHelper.startDrag(viewHolder);
    }
}
