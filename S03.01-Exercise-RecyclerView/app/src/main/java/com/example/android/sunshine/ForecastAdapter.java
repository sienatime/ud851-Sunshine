package com.example.android.sunshine;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by siena on 1/15/18.
 */

public class ForecastAdapter extends RecyclerView.Adapter<ForecastAdapter.ForecastAdapterViewHolder> {
  private String[] mWeatherData;

  public ForecastAdapter() {

  }

  @Override public ForecastAdapterViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
    View view = layoutInflater.inflate(R.layout.forecast_list_item, parent, false);
    return new ForecastAdapterViewHolder(view);
  }

  @Override public void onBindViewHolder(ForecastAdapterViewHolder holder, int position) {
    String weather = mWeatherData[position];
    holder.mWeatherTextView.setText(weather);
  }

  @Override public int getItemCount() {
    if (mWeatherData == null) {
      return 0;
    } else {
      return mWeatherData.length;
    }
  }

  public void setWeatherData(String[] weatherData) {
    mWeatherData = weatherData;
    notifyDataSetChanged();
  }

  public class ForecastAdapterViewHolder extends RecyclerView.ViewHolder {
    public final TextView mWeatherTextView;

    public ForecastAdapterViewHolder(View view) {
      super(view);
      mWeatherTextView = (TextView) view.findViewById(R.id.tv_weather_data);
    }
  }
}
