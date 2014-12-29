package com.ali.corp.instagram.adaptors;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.ali.corp.instagram.data.Model;
import com.ali.corp.instagram.fragments.TemplateFragment;

/**
 * Created by ali on 9/9/2014.
 */
public class CustomFragmentAdaptor extends FragmentStatePagerAdapter {

    private Model mModel;

    public CustomFragmentAdaptor(FragmentManager fm, Model model) {
        super(fm);
        mModel = model;
    }

    @Override
    public Fragment getItem(int i) {

        String userName = mModel.data.get(i).user.full_name;
        String userId = mModel.data.get(i).user.username;
        String userPic = mModel.data.get(i).user.profile_picture;
        String hashtag = mModel.data.get(i).tags.toString();
        String imglow = mModel.data.get(i).images.thumbnail.url;
        String imgmed = mModel.data.get(i).images.low_resolution.url;
        String imgstd = mModel.data.get(i).images.standard_resolution.url;

        return TemplateFragment.getInstance(i, userName, userId, userPic, hashtag, imglow, imgmed, imgstd);
    }

    @Override
    public int getCount() {
        return mModel.data.size();
    }
}
    




