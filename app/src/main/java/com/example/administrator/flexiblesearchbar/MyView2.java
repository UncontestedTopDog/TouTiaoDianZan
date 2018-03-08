package com.example.administrator.flexiblesearchbar;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Point;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by huangweiliang on 2018/2/24.
 */

public class MyView2 extends ValueAnimator {
    int[] drawables = {
            R.drawable.aea, R.drawable.aeb, R.drawable.aec, R.drawable.aed, R.drawable.aee, R.drawable.aef, R.drawable.aeg, R.drawable.aeh, R.drawable.aei,
            R.drawable.aej, R.drawable.aek, R.drawable.ael, R.drawable.aem, R.drawable.aen, R.drawable.aeo, R.drawable.aep, R.drawable.aeq, R.drawable.aer,
            R.drawable.aes, R.drawable.aet, R.drawable.aeu, R.drawable.aev, R.drawable.aew, R.drawable.aex, R.drawable.adt, R.drawable.adu, R.drawable.adv,
            R.drawable.adw, R.drawable.ady, R.drawable.adz, R.drawable.ae0, R.drawable.ae1, R.drawable.ae2, R.drawable.ae3, R.drawable.ae4, R.drawable.ae5,
            R.drawable.ae6, R.drawable.ae7, R.drawable.ae8, R.drawable.ae9, R.drawable.af0, R.drawable.af1, R.drawable.af2, R.drawable.af4, R.drawable.af5,
            R.drawable.af6, R.drawable.af7, R.drawable.af8, R.drawable.af9, R.drawable.afa, R.drawable.afb, R.drawable.afc, R.drawable.afd, R.drawable.afe,
            R.drawable.aff, R.drawable.afg, R.drawable.afh, R.drawable.afi, R.drawable.afj, R.drawable.afk, R.drawable.afl, R.drawable.afm, R.drawable.afn,
            R.drawable.afo, R.drawable.afp, R.drawable.afq, R.drawable.afr, R.drawable.afs, R.drawable.aft, R.drawable.afu, R.drawable.afv, R.drawable.afw,
            R.drawable.afx, R.drawable.afy, R.drawable.afz, R.drawable.ag0, R.drawable.ag1, R.drawable.ag2, R.drawable.ag3, R.drawable.ag4, R.drawable.ag5,
            R.drawable.ag6, R.drawable.ag7, R.drawable.ag8, R.drawable.ag9, R.drawable.aga, R.drawable.agb, R.drawable.agc, R.drawable.agd, R.drawable.age,
            R.drawable.agf, R.drawable.agg, R.drawable.agh, R.drawable.agi, R.drawable.agj, R.drawable.agk, R.drawable.agl, R.drawable.agm, R.drawable.ago,
            R.drawable.agp, R.drawable.ags, R.drawable.agu, R.drawable.agv, R.drawable.agw, R.drawable.agx, R.drawable.agy, R.drawable.agz, R.drawable.ah0};

    AccelerateInterpolator accelerateInterpolator = new AccelerateInterpolator(5);

    int bitmapSize = DisplayUtil.dp2px(getContext(), 30);

    List<FlyEmoji> flyEmojis = new ArrayList<>();

    private void generateFlyEmojis(double startX , double startY){
        FlyEmoji flyEmoji = new FlyEmoji() ;
        flyEmoji.setmStartX(startX);
        flyEmoji.setmStartY(startY);
        flyEmoji.setmCurrentX(startX);
        flyEmoji.setmCurrentY(startY);
        Random random = new Random();
        flyEmoji.setmAccelerationX(random.nextInt(100)/10d);
        flyEmoji.setmAccelerationY(random.nextInt(100)/10d-5);
        flyEmoji.setmVelocityX(random.nextInt(10)+10);
        flyEmoji.setmVelocityY(random.nextInt(10)+10);
        flyEmoji.setmDrawable(drawables[random.nextInt(12*9)]);
        flyEmojis.add(flyEmoji);
    }
    public boolean draw(Canvas canvas) {
        for (FlyEmoji flyEmoji :flyEmojis)
            canvas.drawBitmap(BitmapFactory.decodeResource(getResources(), flyEmoji.getmDrawable()),(float) flyEmoji.getmCurrentX(),(float)flyEmoji.getmCurrentY(),null);
        return true ;
    }
}
