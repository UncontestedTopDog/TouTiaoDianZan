package com.example.administrator.flexiblesearchbar;

import android.content.Context;
import android.graphics.Rect;
import android.os.Vibrator;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by huangweiliang on 2018/2/28.
 */

public class MyList extends RecyclerView {

    private RecyclerView.Adapter mAdapter;

    private MyView myView ;
    private Vibrator vibrator ;

    public MyList(Context context) {
        super(context);
        initView(context);
    }

    public MyList(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public MyList(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initView(context);
    }

    private void initView(Context context) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(VERTICAL);
        setLayoutManager(linearLayoutManager);
    }

    public void bindData(MyView myView , Vibrator vibrator){
        this.myView = myView ;
        this.vibrator = vibrator ;
        mAdapter = new MyAdapter();
        setAdapter(mAdapter);
    }

    private class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = new ItemCard(parent.getContext());
            return new MovieViewHolder(view);
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            ((ItemCard) holder.itemView).bindData(myView,vibrator);
        }

        @Override
        public int getItemCount() {
            return 15;
        }
    }

    private class MovieViewHolder extends RecyclerView.ViewHolder {
        public MovieViewHolder(View view) {
            super(view);
        }
    }
}

