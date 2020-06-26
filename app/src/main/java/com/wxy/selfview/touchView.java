package com.wxy.selfview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

public class touchView  extends View {
    public float touchX;
    public float touchY;
    public touchView(Context context){
        super(context);
        touchX = 100;
        touchY = 100;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(),R.drawable.pointer_hand_large);  //生成位图
        canvas.drawBitmap(bitmap,touchX,touchY,paint); //绘制图片
        if(bitmap.isRecycled()){
            bitmap.recycle();
        }
    }
}
