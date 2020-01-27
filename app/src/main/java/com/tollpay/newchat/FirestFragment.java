package com.tollpay.newchat;


import android.app.Dialog;
import android.os.Build;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.ViewFlipper;


/**
 * A simple {@link Fragment} subclass.
 */
public class FirestFragment extends Fragment {


   public ViewFlipper viewFlipper;
    FragmentManager fragmentManager;

    int img[]={R.drawable.adv1,R.drawable.adv,R.drawable.sos};

    public FirestFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_firest, container, false);

        viewFlipper =(ViewFlipper)view.findViewById(R.id.v_flipper);
        for(int i=0;i<img.length;i++)
        {
            setFlipperImage(img[i]);
        }

        viewFlipper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View popupview = LayoutInflater.from(getActivity()).inflate(R.layout.activity_popup,null);
                final PopupWindow popupWindow= new PopupWindow(popupview, WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.MATCH_PARENT);
                if (Build.VERSION.SDK_INT != 24) {
                    popupWindow.update();
                }

            }
        });


    return view;
    }

    private void setFlipperImage(int res){

        ImageView imageView=new ImageView(getContext());
        imageView.setBackgroundResource(res);
        viewFlipper.addView(imageView);
        viewFlipper.setFlipInterval(1000);
        viewFlipper.setAutoStart(true);


    }



}
