package com.example.administrator.flexiblesearchbar;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Point;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by huangweiliang on 2018/2/24.
 */

public class MyView extends RelativeLayout {
    int[] ids = {
            R.id.i0, R.id.i1, R.id.i2, R.id.i3, R.id.i4, R.id.i5, R.id.i6, R.id.i7, R.id.i8, R.id.i9,
            R.id.i10, R.id.i11, R.id.i12, R.id.i13, R.id.i14, R.id.i15, R.id.i16, R.id.i17, R.id.i18, R.id.i19,
            R.id.i20, R.id.i21, R.id.i22, R.id.i23, R.id.i24, R.id.i25, R.id.i26, R.id.i27, R.id.i28, R.id.i29,
            R.id.i30, R.id.i31, R.id.i32, R.id.i33, R.id.i34, R.id.i35, R.id.i36, R.id.i37, R.id.i38, R.id.i39,
            R.id.i40, R.id.i41, R.id.i42, R.id.i43, R.id.i44, R.id.i45, R.id.i46, R.id.i47, R.id.i48, R.id.i49,
            R.id.i50, R.id.i51, R.id.i52, R.id.i53, R.id.i54, R.id.i55, R.id.i56, R.id.i57, R.id.i58, R.id.i59,
            R.id.i60, R.id.i61, R.id.i62, R.id.i63, R.id.i64, R.id.i65, R.id.i66, R.id.i67, R.id.i68, R.id.i69,
            R.id.i70, R.id.i71, R.id.i72, R.id.i73, R.id.i74, R.id.i75, R.id.i76, R.id.i77, R.id.i78, R.id.i79};
    String[] strings = {
            "i0", "i1", "i2", "i3", "i4", "i5", "i6", "i7", "i8", "i9",
            "i10", "i11", "i12", "i13", "i14", "i15", "i16", "i17", "i18", "i19",
            "i20", "i21", "i22", "i23", "i24", "i25", "i26", "i27", "i28", "i29",
            "i30", "i31", "i32", "i33", "i34", "i35", "i36", "i37", "i38", "i39",
            "i40", "i41", "i42", "i43", "i44", "i45", "i46", "i47", "i48", "i49",
            "i50", "i51", "i52", "i53", "i54", "i55", "i56", "i57", "i58", "i59",
            "i60", "i61", "i62", "i63", "i64", "i65", "i66", "i67", "i68", "i69",
            "i70", "i71", "i72", "i73", "i74", "i75", "i76", "i77", "i78", "i79"};
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

    List<ImageView> is = new ArrayList<>();
    List<PointAndEmoji> pointAndEmojis = new ArrayList<>();
    List<AnimatorPath> paths = new ArrayList<>();

    int shotsEachTime = 20;
    int showTime = 900;
    int intervals = 300;

    float startX;
    float startY;

    boolean run = false;
    int currentNum = 0;

    int bitmapSize = DisplayUtil.dp2px(getContext(), 30);

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (currentNum == 0)
                setPath();
            if (currentNum >= 40 && currentNum % is.size() == 0)
                setPath2(0, 20);
            else if (currentNum >= 40 && currentNum % is.size() == 20)
                setPath2(20, 40);
            else if (currentNum >= 40 && currentNum % is.size() == 40)
                setPath2(40, 60);
            else if (currentNum >= 40 && currentNum % is.size() == 60)
                setPath2(60, 80);
            for (int j = 0; j < shotsEachTime; j++) {
                startAnimatorPath(strings[currentNum % is.size()], paths.get(currentNum % is.size()));
                currentNum++;
            }
        }
    };

    public MyView(Context context) {
        super(context);
        initView(context);
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {
        inflate(context, R.layout.my_view, this);
        for (int i = 0; i < ids.length; i++)
            is.add((ImageView) findViewById(ids[i]));
    }

    /*设置动画路径*/
    public void setPath() {
        int sum = 6;
        pointAndEmojis.clear();
        paths.clear();
        int width = getWidth();
        int height = getHeight();
        for (int i = 0; i < ids.length; i++) {
            double random = Math.random();
            int j = (int) (Math.random() * sum);
            if (j % sum < 2) {
                pointAndEmojis.add(new PointAndEmoji(
                        new Point((int) (width / 2 + random * width / 2), (int) ((Math.random() * height) % startY)),
                        new Point((int) (random * width), -bitmapSize),
                        drawables[(int) (Math.random() * drawables.length)]));
            } else if (j % sum < 5) {
                if ((int) (random * height) > startY)
                    pointAndEmojis.add(new PointAndEmoji(
                            new Point((int) (Math.random() * width), (int) (random * height / 2 + startY / 2)),
                            new Point(-bitmapSize, (int) (random * height)),
                            drawables[(int) (Math.random() * drawables.length)]));
                else
                    pointAndEmojis.add(new PointAndEmoji(
                            new Point((int) (Math.random() * width), (int) (random * height * 3 / 2 - startY / 2)),
                            new Point(-bitmapSize, (int) (random * height)),
                            drawables[(int) (Math.random() * drawables.length)]));
            } else {
                pointAndEmojis.add(new PointAndEmoji(
                        new Point((int) (width / 2 + random * width / 20), (int) startY),
                        new Point((int) (random * width / 10), height + bitmapSize),
                        drawables[(int) (Math.random() * drawables.length)]));
            }
            AnimatorPath animatorPath = new AnimatorPath();
            animatorPath.moveTo(startX, startY);
            animatorPath.secondBesselCurveTo(pointAndEmojis.get(i).getStartPoint().x, pointAndEmojis.get(i).getStartPoint().y,
                    pointAndEmojis.get(i).getEndPoint().x, pointAndEmojis.get(i).getEndPoint().y);
            paths.add(animatorPath);
        }
    }

    public void setPath2(int start, int end) {
        int sum = 6;
        int width = getWidth();
        int height = getHeight();
        for (int i = start; i < end; i++) {
            double random = Math.random();
            int j = (int) (Math.random() * sum);
            //上边界
            if (j % sum < 2) {
                pointAndEmojis.get(i).reset(
                        new Point((int) (width / 2 + random * width / 2), (int) ((Math.random() * height) % startY)),
                        new Point((int) (random * width), -bitmapSize),
                        drawables[(int) (Math.random() * drawables.length)]);
            }//左边界
            else if (j % sum < 5) {
                if ((int) (random * height) > startY)
                    pointAndEmojis.get(i).reset(
                            new Point((int) (Math.random() * width), (int) (random * height / 2 + startY / 2)),
                            new Point(-bitmapSize, (int) (random * height)),
                            drawables[(int) (Math.random() * drawables.length)]);
                else
                    pointAndEmojis.get(i).reset(
                            new Point((int) (Math.random() * width), (int) (random * height * 3 / 2 - startY / 2)),
                            new Point(-bitmapSize, (int) (random * height)),
                            drawables[(int) (Math.random() * drawables.length)]);
            }//下边界
            else {
                pointAndEmojis.get(i).reset(
                        new Point((int) (width / 2 + random * width / 20), (int) startY),
                        new Point((int) (random * width / 10), height + bitmapSize),
                        drawables[(int) (Math.random() * drawables.length)]);
            }
            paths.get(i).clearPoints();
            paths.get(i).moveTo(startX, startY);
            paths.get(i).secondBesselCurveTo(pointAndEmojis.get(i).getStartPoint().x, pointAndEmojis.get(i).getStartPoint().y,
                    pointAndEmojis.get(i).getEndPoint().x, pointAndEmojis.get(i).getEndPoint().y);
        }
    }

    /**
     * 设置动画
     *
     * @param propertyName
     * @param path
     */
    private void startAnimatorPath(String propertyName, AnimatorPath path) {
        ObjectAnimator anim = ObjectAnimator.ofObject(this, propertyName, new PathEvaluator(), path.getPoints().toArray());
        anim.setInterpolator(new AccelerateInterpolator());//动画插值器
        anim.setDuration(showTime);
        anim.start();
    }

    public void startAnimatorPath(float x, float y) {
        run = true;
        startX = x - bitmapSize / 2;
        startY = y + bitmapSize / 2;
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (run) {
                    handler.sendEmptyMessage(0x123);
                    try {
                        Thread.sleep(intervals);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    public void stop() {
        run = false;
    }


    /**
     * 设置View的属性通过ObjectAnimator.ofObject()的反射机制来调用
     *
     * @param newLoc
     */
    public void setI0(PathPoint newLoc) {
        setImage(0, newLoc);
    }

    public void setI1(PathPoint newLoc) {
        setImage(1, newLoc);
    }

    public void setI2(PathPoint newLoc) {
        setImage(2, newLoc);
    }

    public void setI3(PathPoint newLoc) {
        setImage(3, newLoc);
    }

    public void setI4(PathPoint newLoc) {
        setImage(4, newLoc);
    }

    public void setI5(PathPoint newLoc) {
        setImage(5, newLoc);
    }

    public void setI6(PathPoint newLoc) {
        setImage(6, newLoc);
    }

    public void setI7(PathPoint newLoc) {
        setImage(7, newLoc);
    }

    public void setI8(PathPoint newLoc) {
        setImage(8, newLoc);
    }

    public void setI9(PathPoint newLoc) {
        setImage(9, newLoc);
    }

    public void setI10(PathPoint newLoc) {
        setImage(10, newLoc);
    }

    public void setI11(PathPoint newLoc) {
        setImage(11, newLoc);
    }

    public void setI12(PathPoint newLoc) {
        setImage(12, newLoc);
    }

    public void setI13(PathPoint newLoc) {
        setImage(13, newLoc);
    }

    public void setI14(PathPoint newLoc) {
        setImage(14, newLoc);
    }

    public void setI15(PathPoint newLoc) {
        setImage(15, newLoc);
    }

    public void setI16(PathPoint newLoc) {
        setImage(16, newLoc);
    }

    public void setI17(PathPoint newLoc) {
        setImage(17, newLoc);
    }

    public void setI18(PathPoint newLoc) {
        setImage(18, newLoc);
    }

    public void setI19(PathPoint newLoc) {
        setImage(19, newLoc);
    }

    public void setI20(PathPoint newLoc) {
        setImage(20, newLoc);
    }

    public void setI21(PathPoint newLoc) {
        setImage(21, newLoc);
    }

    public void setI22(PathPoint newLoc) {
        setImage(22, newLoc);
    }

    public void setI23(PathPoint newLoc) {
        setImage(23, newLoc);
    }

    public void setI24(PathPoint newLoc) {
        setImage(24, newLoc);
    }

    public void setI25(PathPoint newLoc) {
        setImage(25, newLoc);
    }

    public void setI26(PathPoint newLoc) {
        setImage(26, newLoc);
    }

    public void setI27(PathPoint newLoc) {
        setImage(27, newLoc);
    }

    public void setI28(PathPoint newLoc) {
        setImage(28, newLoc);
    }

    public void setI29(PathPoint newLoc) {
        setImage(29, newLoc);
    }

    public void setI30(PathPoint newLoc) {
        setImage(30, newLoc);
    }

    public void setI31(PathPoint newLoc) {
        setImage(31, newLoc);
    }

    public void setI32(PathPoint newLoc) {
        setImage(32, newLoc);
    }

    public void setI33(PathPoint newLoc) {
        setImage(33, newLoc);
    }

    public void setI34(PathPoint newLoc) {
        setImage(34, newLoc);
    }

    public void setI35(PathPoint newLoc) {
        setImage(35, newLoc);
    }

    public void setI36(PathPoint newLoc) {
        setImage(36, newLoc);
    }

    public void setI37(PathPoint newLoc) {
        setImage(37, newLoc);
    }

    public void setI38(PathPoint newLoc) {
        setImage(38, newLoc);
    }

    public void setI39(PathPoint newLoc) {
        setImage(39, newLoc);
    }

    public void setI40(PathPoint newLoc) {
        setImage(40, newLoc);
    }

    public void setI41(PathPoint newLoc) {
        setImage(41, newLoc);
    }

    public void setI42(PathPoint newLoc) {
        setImage(42, newLoc);
    }

    public void setI43(PathPoint newLoc) {
        setImage(43, newLoc);
    }

    public void setI44(PathPoint newLoc) {
        setImage(44, newLoc);
    }

    public void setI45(PathPoint newLoc) {
        setImage(45, newLoc);
    }

    public void setI46(PathPoint newLoc) {
        setImage(46, newLoc);
    }

    public void setI47(PathPoint newLoc) {
        setImage(47, newLoc);
    }

    public void setI48(PathPoint newLoc) {
        setImage(48, newLoc);
    }

    public void setI49(PathPoint newLoc) {
        setImage(49, newLoc);
    }

    public void setI50(PathPoint newLoc) {
        setImage(50, newLoc);
    }

    public void setI51(PathPoint newLoc) {
        setImage(51, newLoc);
    }

    public void setI52(PathPoint newLoc) {
        setImage(52, newLoc);
    }

    public void setI53(PathPoint newLoc) {
        setImage(53, newLoc);
    }

    public void setI54(PathPoint newLoc) {
        setImage(54, newLoc);
    }

    public void setI55(PathPoint newLoc) {
        setImage(55, newLoc);
    }

    public void setI56(PathPoint newLoc) {
        setImage(56, newLoc);
    }

    public void setI57(PathPoint newLoc) {
        setImage(57, newLoc);
    }

    public void setI58(PathPoint newLoc) {
        setImage(58, newLoc);
    }

    public void setI59(PathPoint newLoc) {
        setImage(59, newLoc);
    }

    public void setI60(PathPoint newLoc) {
        setImage(60, newLoc);
    }

    public void setI61(PathPoint newLoc) {
        setImage(61, newLoc);
    }

    public void setI62(PathPoint newLoc) {
        setImage(62, newLoc);
    }

    public void setI63(PathPoint newLoc) {
        setImage(63, newLoc);
    }

    public void setI64(PathPoint newLoc) {
        setImage(64, newLoc);
    }

    public void setI65(PathPoint newLoc) {
        setImage(65, newLoc);
    }

    public void setI66(PathPoint newLoc) {
        setImage(66, newLoc);
    }

    public void setI67(PathPoint newLoc) {
        setImage(67, newLoc);
    }

    public void setI68(PathPoint newLoc) {
        setImage(68, newLoc);
    }

    public void setI69(PathPoint newLoc) {
        setImage(69, newLoc);
    }

    public void setI70(PathPoint newLoc) {
        setImage(70, newLoc);
    }

    public void setI71(PathPoint newLoc) {
        setImage(71, newLoc);
    }

    public void setI72(PathPoint newLoc) {
        setImage(72, newLoc);
    }

    public void setI73(PathPoint newLoc) {
        setImage(73, newLoc);
    }

    public void setI74(PathPoint newLoc) {
        setImage(74, newLoc);
    }

    public void setI75(PathPoint newLoc) {
        setImage(75, newLoc);
    }

    public void setI76(PathPoint newLoc) {
        setImage(76, newLoc);
    }

    public void setI77(PathPoint newLoc) {
        setImage(77, newLoc);
    }

    public void setI78(PathPoint newLoc) {
        setImage(78, newLoc);
    }

    public void setI79(PathPoint newLoc) {
        setImage(79, newLoc);
    }

    public void setImage(int image, PathPoint newLoc) {
        is.get(image).setImageResource(pointAndEmojis.get(image).getEmoji());
        is.get(image).setTranslationX(newLoc.mX);
        is.get(image).setTranslationY(newLoc.mY);
    }

    public boolean isRun() {
        return run;
    }
}
