package com.tollpay.newchat;


import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class tabsadapter extends FragmentPagerAdapter {

    public tabsadapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {

        switch (i){
            case 0:
                camFragment cf=new camFragment();
                return cf;
            case 1:
                chatFragment chatf = new chatFragment();
                return chatf;
            case 2:
                StatusFragment statusfrag = new StatusFragment();
                return statusfrag;
            case 3:
                callFragment callfrag = new callFragment();
                return callfrag;
                default:
                return null;
        }


    }

    @Override
    public int getCount() {
        return 4;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        switch(position){
            case 0:
                return "CAM";
            case 1:
                return "CHATS";
            case 2:
                return "MOMENTS";
            case 3:
                return "CALLS";
            default:
                return null;
        }
    }
}
