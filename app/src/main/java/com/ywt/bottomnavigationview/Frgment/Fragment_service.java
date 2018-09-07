package com.ywt.bottomnavigationview.Frgment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ywt.bottomnavigationview.R;

/**
 * Created by ywt on 2018/5/6.
 */

public class Fragment_service extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.service, null);
        return view;
    }
}
