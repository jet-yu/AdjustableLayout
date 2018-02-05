package com.felix.adjustablelayout;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by lufan on 2016/11/22.
 */

public class MainTabFragment extends Fragment {

    public static MainTabFragment newInstance(int count) {
        MainTabFragment fragment = new MainTabFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("count", count);

        fragment.setArguments(bundle);
        return fragment;
    }

    private RecyclerView mRvList;

    private View rootView;

    private TestRvAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_main_tab, container, false);
        initWidget((Integer) getArguments().get("count"));
        return rootView;
    }

    public void initWidget(int count) {
        adapter = new TestRvAdapter(getActivity(), count);
        mRvList = (RecyclerView) rootView.findViewById(R.id.rv_list);
        mRvList.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRvList.setAdapter(adapter);
    }

    public RecyclerView getRvList() {
        return mRvList;
    }

}
