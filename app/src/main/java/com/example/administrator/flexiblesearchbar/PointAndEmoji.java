package com.example.administrator.flexiblesearchbar;

import android.graphics.Point;
import android.graphics.drawable.Drawable;

/**
 * Created by huangweiliang on 2018/2/26.
 */

public class PointAndEmoji {
    Point startPoint ;
    Point endPoint ;
    int emoji ;

    public PointAndEmoji(Point startPoint, Point endPoint, int emoji) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.emoji = emoji;
    }

    public void reset(Point startPoint, Point endPoint, int emoji) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.emoji = emoji;
    }

    public Point getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(Point startPoint) {
        this.startPoint = startPoint;
    }

    public Point getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(Point endPoint) {
        this.endPoint = endPoint;
    }

    public int getEmoji() {
        return emoji;
    }

    public void setEmoji(int emoji) {
        this.emoji = emoji;
    }
}
