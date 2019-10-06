package com.karsten.seekbarfragmentversuch.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.material.card.MaterialCardView;
import com.karsten.seekbarfragmentversuch.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class FragmentZwei extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    private PageViewModel pageViewModel;
    private  SharedViewModel viewModel;

    private MaterialCardView cv1;
    private MaterialCardView cv2;
    private MaterialCardView cv3;

    public static FragmentZwei newInstance(int index) {
        FragmentZwei fragment = new FragmentZwei();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        pageViewModel = ViewModelProviders.of(this).get(PageViewModel.class);
        viewModel = ViewModelProviders.of(this).get(SharedViewModel.class);


        int index = 1;
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_SECTION_NUMBER);
        }
        pageViewModel.setIndex(index);
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_zwei, container, false);


        final TextView textView = root.findViewById(R.id.section_label);
        final TextView tv = root.findViewById(R.id.tv);

        ImageView imageView= root.findViewById(R.id.imageView);




        Glide.with(this)
                .load(getResources().getDrawable(R.drawable.car_4))
                .apply(RequestOptions.centerCropTransform())
               // .apply(RequestOptions.overrideOf(1920))
                //.apply(RequestOptions.fitCenterTransform())
                .into(imageView);





        cv1 = root.findViewById(R.id.cv1);
        cv2 = root.findViewById(R.id.cv2);
        cv3 = root.findViewById(R.id.cv3);

        cv1.setCardBackgroundColor(getResources().getColor(R.color.cv1B));
        cv1.setAlpha(0);

        cv2.setCardBackgroundColor(getResources().getColor(R.color.cv2B));
        cv2.setAlpha(0);

        cv3.setCardBackgroundColor(getResources().getColor(R.color.cv3B));
        cv3.setAlpha(0);

        viewModel = ViewModelProviders.of(getActivity()).get(SharedViewModel.class);
        viewModel.getText().observe(getViewLifecycleOwner(), new Observer<CharSequence>() {
            @Override
            public void onChanged(@Nullable CharSequence charSequence) {
                tv.setText(charSequence+"%");

                String alphaString = String.valueOf(charSequence);

                float alpha = Float.parseFloat(alphaString) / 100;

                cv1.setAlpha(alpha);
                cv2.setAlpha(alpha);
                cv3.setAlpha(alpha);
                // Toast.makeText(getActivity(), charSequence, Toast.LENGTH_SHORT).show();
            }
        });


        pageViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
      // viewModel = ViewModelProviders.of(getActivity()).get(SharedViewModel.class);
      // viewModel.getText().observe(getViewLifecycleOwner(), new Observer<CharSequence>() {
      //     @Override
      //     public void onChanged(@Nullable CharSequence charSequence) {
      //         Toast.makeText(getActivity(), charSequence, Toast.LENGTH_SHORT).show();
      //         //editText.setText(charSequence);
      //     }
      // });
    }


}