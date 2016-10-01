package com.project.mluan.stormy.ui;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.project.mluan.stormy.R;
import com.project.mluan.stormy.adapter.DayAdapter;
import com.project.mluan.stormy.weather.Day;

import java.util.Arrays;

import butterknife.ButterKnife;

public class DailyForecastActivity extends ListActivity { // cach 2 doi thanh Activity thi phai tu them 1 vai method
    private Day[] mDays;
    private TextView mLocationLabel;

   /*
   cach 2
   @BindView(android.R.id.list) ListView mListView;
    @BindView(android.R.id.empty) TextView mEmptyTextView;*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_forecast);
        ButterKnife.bind(this);
        Intent intent = getIntent();
        Parcelable[] parcelables = intent.getParcelableArrayExtra(MainActivity.DAILY_FORECAST);
        mDays = Arrays.copyOf(parcelables, parcelables.length, Day[].class);

        DayAdapter adapter = new DayAdapter(this, mDays);
        setListAdapter(adapter);

        mLocationLabel = (TextView) findViewById(R.id.locationLabel);
        mLocationLabel.setText(mDays[0].getPlace());

        /*
        cach 2
        mListView.setAdapter(adapter);
        mListView.setEmptyView(mEmptyTextView);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });*/

    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
            super.onListItemClick(l, v, position, id);
        String dayOfTheWeek = mDays[position].getDayOfTheWeek();
        String conditions = mDays[position].getSummary();
        String highTemp = mDays[position].getTemperatureMax() + "";
        String message = String.format("On %s the high will be %s and it will be %s", dayOfTheWeek,highTemp, conditions);

        Toast.makeText(this, message,Toast.LENGTH_LONG).show();
    }
}
