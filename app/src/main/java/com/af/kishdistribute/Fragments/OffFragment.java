package com.af.kishdistribute.Fragments;

import android.app.Fragment;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.af.kishdistribute.R;

public class OffFragment extends Fragment {


    public static OffFragment newInstance() {
        OffFragment fragmentDemo = new OffFragment();
        return fragmentDemo;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.activity_off, null);

        ImageView imageView = (ImageView) v.findViewById(R.id.im1);
        ImageView imageView1 = (ImageView) v.findViewById(R.id.im2);
        ImageView imageView2 = (ImageView) v.findViewById(R.id.im3);
        ImageView imageView3 = (ImageView) v.findViewById(R.id.im4);

        Bitmap largeIcon = BitmapFactory.decodeResource(getResources(), R.drawable.pic1);
        Bitmap largeIcon2 = BitmapFactory.decodeResource(getResources(), R.drawable.pic2);
        Bitmap largeIcon3 = BitmapFactory.decodeResource(getResources(), R.drawable.pic3);
        Bitmap largeIcon4 = BitmapFactory.decodeResource(getResources(), R.drawable.pic4);
        imageView.setImageBitmap(getRoundedCornerBitmap(largeIcon,70));
        imageView1.setImageBitmap(getRoundedCornerBitmap(largeIcon2,70));
        imageView2.setImageBitmap(getRoundedCornerBitmap(largeIcon3,70));
        imageView3.setImageBitmap(getRoundedCornerBitmap(largeIcon4,70));


        return v;

    }


    public static Bitmap getRoundedCornerBitmap(Bitmap bitmap, int pixels) {
        Bitmap output = Bitmap.createBitmap(bitmap.getWidth(), bitmap
                .getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);

        final int color = 0xff424242;
        final Paint paint = new Paint();
        final Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        final RectF rectF = new RectF(rect);
        final float roundPx = pixels;

        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(color);
        canvas.drawRoundRect(rectF, roundPx, roundPx, paint);

        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);

        return output;
    }


}
