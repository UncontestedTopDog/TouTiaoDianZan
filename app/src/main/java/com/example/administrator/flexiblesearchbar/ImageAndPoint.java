package com.example.administrator.flexiblesearchbar;

import android.graphics.Bitmap;
import android.graphics.Point;

/**
 * Created by huangweiliang on 2018/2/27.
 */

public class ImageAndPoint {
    Bitmap bitmap ;
    Point point ;
    int size ;

    public ImageAndPoint(Bitmap bitmap, Point point,int size) {
        this.bitmap = Bitmap.createScaledBitmap(bitmap,size,size,false);
//        this.bitmap = bitmap ;
        this.point = point;
        this.size = size ;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = Bitmap.createScaledBitmap(bitmap,size,size,false);
//        this.bitmap = bitmap ;
    }

    public Point getPoint() {
        return point;
    }

    public void setPoint(Point point) {
        this.point = point;
    }
}
