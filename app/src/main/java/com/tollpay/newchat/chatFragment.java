package com.tollpay.newchat;



import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.SurfaceControl;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;



/**
 * A simple {@link Fragment} subclass.
 */
public class chatFragment extends Fragment {


    FloatingActionButton fap;
     View v;


    public chatFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_chat, container, false);
        fap =(FloatingActionButton)v.findViewById(R.id.fab);



//
//        RecyclerView recyclerView = (RecyclerView)v.findViewById(R.id.rview);
//        ListAdapter listAdapter = new ListAdapter();
//        recyclerView.setAdapter(listAdapter);
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
//        recyclerView.setLayoutManager(layoutManager);

//          Fragment fragment = new Fragment();
//        FragmentTransaction transaction= getChildFragmentManager().beginTransaction();
//        transaction.add(R.id.advertisement,fragment).commit();

        fap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(),"Contacts",Toast.LENGTH_LONG).show();
            }
        });
        return v;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FirestFragment firestFragment= new FirestFragment();
        FragmentManager manager = getFragmentManager();
        manager.beginTransaction().replace(R.id.first_layout,firestFragment,firestFragment.getTag()).commit();


        secondFragment secondFragment = new secondFragment();
        FragmentManager manager1 = getFragmentManager();
        manager1.beginTransaction().replace(R.id.second_laout,secondFragment,secondFragment.getTag()).commit();

    }

    @Override
    public void onResume() {

        FirestFragment firestFragment= new FirestFragment();
        FragmentManager manager = getFragmentManager();
        manager.beginTransaction().replace(R.id.first_layout,firestFragment,firestFragment.getTag()).commit();


        secondFragment secondFragment = new secondFragment();
        FragmentManager manager1 = getFragmentManager();
        manager1.beginTransaction().replace(R.id.second_laout,secondFragment,secondFragment.getTag()).commit();

        super.onResume();
    }
}
