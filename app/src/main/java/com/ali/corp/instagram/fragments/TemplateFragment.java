package com.ali.corp.instagram.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.ali.corp.instagram.activities.Viewer;
import com.ali.corp.viewpager.R;
import com.squareup.picasso.Picasso;

import java.util.Random;


public class TemplateFragment extends Fragment implements View.OnClickListener{


    Random mRandom = new Random();
    int mFragmentLayout;

    public static Fragment getInstance(int i,String userName,String userId,
                                       String userPic,String hashtag,String imglow,
                                       String imgmed,String imgstd) {

        //passing the love
        Fragment templateFragment = new TemplateFragment();
        Bundle bundle = new Bundle();
        bundle.putString("userName", userName);
        bundle.putString("userId", userId);
        bundle.putString("userPic", userPic);

        bundle.putString("hashtag", hashtag);

        bundle.putString("imglow", imglow);
        bundle.putString("imgmed", imgmed);
        bundle.putString("imgstd", imgstd);

        bundle.putInt("page", i);

        templateFragment.setArguments(bundle);

        return templateFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        //styling the actionBar
        getActivity().getActionBar().setDisplayShowHomeEnabled(false);
        getActivity().getActionBar().setTitle(getString(R.string.actionbar_welcome));
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //dynamic change of the layout organization
        switch (mRandom.nextInt(2)) {
            case 0:
                mFragmentLayout=(R.layout.fragment1);
                break;
            case 1:
                mFragmentLayout=(R.layout.fragment2);
                break;
            default:
                mFragmentLayout=(R.layout.fragment2);
        }

        View v = inflater.inflate(mFragmentLayout, container, false);

        //dynamic change of the background
        switch (mRandom.nextInt(3)) {
            case 0:
                v.findViewById(R.id.layout).setBackgroundResource(R.drawable.bg4);
                break;
            case 1:
                v.findViewById(R.id.layout).setBackgroundResource(R.drawable.bg2);
                break;
            case 2:
                v.findViewById(R.id.layout).setBackgroundResource(R.drawable.bg1);
                break;
            default:
                v.findViewById(R.id.layout).setBackgroundResource(R.drawable.bg2);
        }

        Bundle bundle=getArguments();

        // referencing and setting UI
        TextView userName= (TextView) v.findViewById(R.id.username);
        TextView userId= (TextView) v.findViewById(R.id.userid);
        TextView hashTag= (TextView) v.findViewById(R.id.hashtag);

        ImageView userPic=(ImageView) v.findViewById(R.id.userPic);

        ImageView imgLow=(ImageView) v.findViewById(R.id.imagelow);
        imgLow.setTag(bundle.getString("imglow", "loading"));
        imgLow.setOnClickListener(this);
        ImageView imgMed=(ImageView) v.findViewById(R.id.imagemid);
        imgMed.setTag(bundle.getString("imgmed", "imgmed"));
        imgMed.setOnClickListener(this);
        ImageView imgStd=(ImageView) v.findViewById(R.id.imagestd);
        imgStd.setTag(bundle.getString("imgstd", "imgstd"));
        imgStd.setOnClickListener(this);

        userName.setText(bundle.getString("userName", "as"));
        userId.setText(bundle.getString("userId", "userId"));
        hashTag.setText(bundle.getString("hashtag", "hashtag"));

        Picasso.with(getActivity()).load(bundle.getString("userPic","as")).into(userPic);

        Log.i("dddd", bundle.getString("imglow", "loading"));
        Picasso.with(getActivity()).load(bundle.getString("imglow", "loading")).into(imgLow);
        Picasso.with(getActivity()).load(bundle.getString("imgmed", "imgmed")).into(imgMed);
        Picasso.with(getActivity()).load(bundle.getString("imgstd", "imgstd")).into(imgStd);

        setHasOptionsMenu(true);
        return v;
    }


    @Override
    public void onClick(View v) {
        Intent intent=new Intent(getActivity(),Viewer.class);
        intent.setData(Uri.parse(v.getTag().toString()));
        startActivity(intent);

    }
}
