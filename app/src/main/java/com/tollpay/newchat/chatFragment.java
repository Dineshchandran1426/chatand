package com.tollpay.newchat;



import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
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

//
//        RecyclerView recyclerView = (RecyclerView)v.findViewById(R.id.rview);
//        ListAdapter listAdapter = new ListAdapter();
//        recyclerView.setAdapter(listAdapter);
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
//        recyclerView.setLayoutManager(layoutManager);


        fap = (FloatingActionButton)v.findViewById(R.id.fab);
        fap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity().getApplication(),Main2Activity.class);
                startActivity(i);
            }
        });

        return v;
    }


}
