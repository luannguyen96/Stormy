package com.project.mluan.stormy.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.project.mluan.stormy.R;
import com.project.mluan.stormy.adapter.HourAdapter;
import com.project.mluan.stormy.weather.Hour;

import java.util.Arrays;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HourlyForecastActivity extends AppCompatActivity {
    private Hour[] mHours;
    @BindView(R.id.recyclerView) RecyclerView mRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hourly_forecast);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        Parcelable[] parcelables = intent.getParcelableArrayExtra(MainActivity.HOURLY_FORECAST);
        mHours = Arrays.copyOf(parcelables, parcelables.length, Hour[].class);

        HourAdapter adapter = new HourAdapter(this, mHours);
        mRecyclerView.setAdapter(adapter);


        //layout manager can phai co trong recyclerView vi giup reuse lai View hoac tranh su dung lang phi recyclerView
        //layoutmanager co nhieu loai tuong ung voi cac man hinh, xem API
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(layoutManager);
        //tang performance cua list neu dung data voi fix size
        mRecyclerView.setHasFixedSize(true);

    }

}
