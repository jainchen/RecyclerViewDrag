package com.bozo.touchsort;

/**
 * 用于通知ItemTouchHelper拖动排序
 *
 * Created by cj on 2017/3/16 0016.
 */

public interface DragListener {

    void onStartDrag(SortAdapter.ViewHolder viewHolder);
}
