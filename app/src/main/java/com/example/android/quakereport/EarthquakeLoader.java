package com.example.android.quakereport;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;

import java.util.List;



public class EarthquakeLoader extends AsyncTaskLoader<List<Earthquake>> {

    private String mUrl;
    private static final String LOG_TAG = EarthquakeActivity.class.getName();


    public EarthquakeLoader(Context context, String Url) {
        super(context);
        mUrl = Url;

    }

    @Override
    protected void onStartLoading() {
        Log.v(LOG_TAG, "started loading");

        forceLoad();
    }

    @Override
    public List<Earthquake> loadInBackground() {

        Log.v(LOG_TAG, "loading in background");
        // Don't perform the request if there are no URLs, or the first URL is null
        if (mUrl == null) {
            return null;
        }

        List<Earthquake> result = QueryUtils.fetchEarthquakeData(mUrl);
        return result;
    }

}