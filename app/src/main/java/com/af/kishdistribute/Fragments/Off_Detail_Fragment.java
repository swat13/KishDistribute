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
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.af.kishdistribute.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class Off_Detail_Fragment extends Fragment {

    static int type = 0;
    public static Off_Detail_Fragment newInstance(int _type) {
        Off_Detail_Fragment fragmentDemo = new Off_Detail_Fragment();
        type = _type;
        return fragmentDemo;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.activity_off_detail, null);

        Log.e("%%%%%%", "onCreateView: "+type );

        ImageView imageView = (ImageView) v.findViewById(R.id.im1);
        Bitmap largeIcon = null;
        switch (type) {
            case 1:
                largeIcon = BitmapFactory.decodeResource(getResources(), R.drawable.pic1);
                break;
            case 2:
                largeIcon = BitmapFactory.decodeResource(getResources(), R.drawable.pic2);
                break;
            case 3:
                largeIcon = BitmapFactory.decodeResource(getResources(), R.drawable.pic3);
                break;
            case 4:
                largeIcon = BitmapFactory.decodeResource(getResources(), R.drawable.pic4);
                break;
            default:
                break;
        }
        imageView.setImageBitmap(getRoundedCornerBitmap(largeIcon,70));
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
