package com.example.android.builditbigger;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.android.androidlib.JokeActivity;

import static com.example.android.androidlib.JokeActivity.JOKE_INTENT_KEY;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainActivityFragment extends Fragment {


    public MainActivityFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        Button joke = rootView.findViewById(R.id.joke);
        joke.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new EndpointsAsyncTask(new EndpointsAsyncTask.OnResultReady() {
                    @Override
                    public void ResultReady(String result) {
                        Intent intent = new Intent(getActivity(), JokeActivity.class);
                        intent.putExtra(JOKE_INTENT_KEY, result);
                        getActivity().startActivity(intent);
                    }
                }).execute();
            }
        });


        return rootView;
    }

}
