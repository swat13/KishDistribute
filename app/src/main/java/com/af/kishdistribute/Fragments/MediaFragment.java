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
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.VideoView;

import com.af.kishdistribute.R;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;

public class MediaFragment extends Fragment {


    public static MediaFragment newInstance() {
        MediaFragment fragmentDemo = new MediaFragment();
        return fragmentDemo;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.activity_meida, null);

//        final ImageView imageView = (ImageView) v.findViewById(R.id.im1);
//        final ImageView imageView1 = (ImageView) v.findViewById(R.id.im2);


//        getWindow().setFormat(PixelFormat.UNKNOWN);

        //Displays a video file.
        VideoView mVideoView = (VideoView)v.findViewById(R.id.videoView);


        String uriPath = "android.resource://com.af.kishdistribute/"+R.raw.g;
        Uri uri = Uri.parse(uriPath);
        mVideoView.setVideoURI(uri);
        mVideoView.requestFocus();
        mVideoView.start();

        /*Glide.with(getActivity())
                .load(R.drawable.pic1)
                .asBitmap()
                .centerCrop()
                .into(new BitmapImageViewTarget(imageView) {
                    @Override
                    protected void setResource(Bitmap resource) {
                        RoundedBitmapDrawable circularBitmapDrawable = RoundedBitmapDrawableFactory.create(getActivity().getResources(), resource);
                        circularBitmapDrawable.setCornerRadius(25);
                        imageView.setImageDrawable(circularBitmapDrawable);
                    }
                });

        Glide.with(getActivity())
                .load(R.drawable.pic2)
                .asBitmap()
                .centerCrop()
                .into(new BitmapImageViewTarget(imageView1) {
                    @Override
                    protected void setResource(Bitmap resource) {
                        RoundedBitmapDrawable circularBitmapDrawable = RoundedBitmapDrawableFactory.create(getActivity().getResources(), resource);
                        circularBitmapDrawable.setCornerRadius(25);
                        imageView1.setImageDrawable(circularBitmapDrawable);
                    }
                });*/


        return v;

    }


}
