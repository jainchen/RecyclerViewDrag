package com.bozo.touchsort;

/**
 * 用于通知适配器Item位置改变
 *
 * Created by cj on 2017/3/16 0016.
 */

public interface OnMovedListener {

    void onMoved(int from, int to);
}
