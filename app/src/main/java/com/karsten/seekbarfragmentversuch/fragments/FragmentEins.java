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

public class FragmentEins extends Fragment {

    //private static final String ARG_SECTION_NUMBER = "section_number";
    private MaterialCardView cv1;
    private MaterialCardView cv2;
    private MaterialCardView cv3;

    //region ** Nicht so wichtig
    // public static FragmentEins newInstance(int index) {
    //     FragmentEins fragment = new FragmentEins();
    //     Bundle bundle = new Bundle();
    //     bundle.putInt(ARG_SECTION_NUMBER, index);
    //     fragment.setArguments(bundle);
    //     return fragment;
    // }
    //endregion ** Nicht so wichtig

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //  pageViewModel = ViewModelProviders.of(this).get(PageViewModel.class);
        //  int index = 1;
        //  if (getArguments() != null) {
        //      index = getArguments().getInt(ARG_SECTION_NUMBER);
        //  }
        //  pageViewModel.setIndex(index);
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_eins, container, false);

        final TextView tv = root.findViewById(R.id.tv);
        ImageView imageView= root.findViewById(R.id.imageView);

        Glide.with(this)
                .load(getResources().getDrawable(R.drawable.car_3))
                .apply(RequestOptions.centerCropTransform())
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

        OpacityViewModel opacityViewModel = ViewModelProviders.of(getActivity()).get(OpacityViewModel.class);
        opacityViewModel.getInt().observe(getViewLifecycleOwner(), new Observer<Integer>() {
            @Override
            public void onChanged(@Nullable Integer mInteger) {
                tv.setText(mInteger + "%");
                float alpha = (float) mInteger / 100;
                cv1.setAlpha(alpha);
                cv2.setAlpha(alpha);
                cv3.setAlpha(alpha);
            }
        });
        return root;
    }
}