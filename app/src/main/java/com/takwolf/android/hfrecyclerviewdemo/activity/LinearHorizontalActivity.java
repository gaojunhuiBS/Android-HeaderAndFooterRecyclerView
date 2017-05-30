package com.takwolf.android.hfrecyclerviewdemo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;

import com.takwolf.android.hfrecyclerview.HeaderAndFooterRecyclerView;
import com.takwolf.android.hfrecyclerviewdemo.R;
import com.takwolf.android.hfrecyclerviewdemo.adapter.LinearHorizontalAdapter;
import com.takwolf.android.hfrecyclerviewdemo.listener.NavigationFinishClickListener;
import com.takwolf.android.hfrecyclerviewdemo.model.ApiClient;
import com.takwolf.android.hfrecyclerviewdemo.viewholder.HorizontalFooter;
import com.takwolf.android.hfrecyclerviewdemo.viewholder.HorizontalHeader;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LinearHorizontalActivity extends AppCompatActivity {

    @BindView(R.id.toolbar)
    protected Toolbar toolbar;

    @BindView(R.id.recycler_view)
    protected HeaderAndFooterRecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        ButterKnife.bind(this);

        toolbar.setTitle("Linear Horizontal");
        toolbar.setNavigationOnClickListener(new NavigationFinishClickListener(this));

        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        LinearHorizontalAdapter adapter = new LinearHorizontalAdapter(this);
        adapter.getIllustList().addAll(ApiClient.buildIllustList(35));
        recyclerView.setAdapter(adapter);

        new HorizontalHeader(this, recyclerView);
        new HorizontalHeader(this, recyclerView);
        new HorizontalFooter(this, recyclerView);
        new HorizontalFooter(this, recyclerView);
    }

}