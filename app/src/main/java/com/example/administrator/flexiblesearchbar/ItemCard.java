package com.example.administrator.flexiblesearchbar;

import android.content.Context;
import android.os.Vibrator;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

/**
 * Created by huangweiliang on 2018/2/28.
 */

public class ItemCard extends RelativeLayout {

    private MyView myView ;
    private Vibrator vibrator ;
    private ImageView imageView ;

    public ItemCard(Context context) {
        super(context);
        initView(context);
    }

    public ItemCard(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public ItemCard(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {
        inflate(context,R.layout.item_card,this);
        imageView = findViewById(R.id.btn);
        imageView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (!myView.isRun()){
                    imageView.setImageResource(R.drawable.acd);
                    myView.startAnimatorPath(imageView.getX()+imageView.getWidth()/2,imageView.getY()+imageView.getHeight()/2);}
                vibrator.vibrate(new long[]{100,10,100,1000}, 0);
                return false;
            }
        });
        imageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP){
                    imageView.setImageResource(R.drawable.acc);
                    myView.stop();
                    vibrator.cancel();
                }
                return false;
            }
        });
    }

    public void bindData(MyView myView , Vibrator vibrator){
        this.myView = myView ;
        this.vibrator = vibrator ;
    }
}
