package com.daniel.user.asartaline.activities;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.util.Log;

import com.daniel.user.asartaline.ASarTaLineApp;
import com.daniel.user.asartaline.R;
import com.daniel.user.asartaline.adapters.FoodAdapter;
import com.daniel.user.asartaline.components.EmptyViewPod;
import com.daniel.user.asartaline.components.SmartRecyclerView;
import com.daniel.user.asartaline.components.SmartScrollListener;
import com.daniel.user.asartaline.data.VOs.GetWarDee.WarDeeVO;
import com.daniel.user.asartaline.mvp.presenters.MainPresenter;
import com.daniel.user.asartaline.mvp.views.MainView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainView {

    @BindView(R.id.main_rc)
    SmartRecyclerView rvFood;
    @BindView(R.id.cv_main_search_meal_shop)
    CardView mSearchPanel;
    private SmartScrollListener mSmartScrollListener;
    private FoodAdapter mAdapter;
    private MainPresenter mPresenter;
    @BindView(R.id.vp_empty_news)
    EmptyViewPod emptyViewPod;

    @BindView(R.id.swipe_refresh)
    SwipeRefreshLayout swipeRefreshLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this, this);


        mPresenter = ViewModelProviders.of(this).get(MainPresenter.class);
        mPresenter.initPresenter(this);
        checkConnection();

        rvFood.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new FoodAdapter(this, mPresenter);
        rvFood.setAdapter(mAdapter);
        rvFood.setEmptyView(emptyViewPod);
        mSmartScrollListener = new SmartScrollListener(new SmartScrollListener.OnSmartScrollListener() {
            @Override
            public void onListEndReach() {
                //Snackbar.make(rvNews, "This is all the data for NOW.", Snackbar.LENGTH_LONG).show();
                showSnackBar("This is all the data for now ");
            }
        });
        rvFood.addOnScrollListener(mSmartScrollListener);

        swipeRefreshLayout.setOnRefreshListener(
                new SwipeRefreshLayout.OnRefreshListener() {
                    @Override
                    public void onRefresh() {
                        if (isOnline()) {
                            rvFood.removeAllViews();
                            refreshFeed();
                        } else {
                            showSnackBar("NO NETWORK CONNECTIONS");
                        }
                    }
                }
        );


        if (mSearchPanel.isAttachedToWindow()) {
            mSearchPanel.setCardBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
        }
    }


    private void refreshFeed() {
        swipeRefreshLayout.setRefreshing(false);
        mPresenter.onRefreshScreen();
    }

    private void displayData(List<WarDeeVO> warDeeVOList) {
        mAdapter.appendNewData(warDeeVOList);
    }

    @Override
    public void launchFoodDetailsScreen(String id) {
        Intent intent = new Intent(MainActivity.this, FoodDetailsActivity.class);
        intent.putExtra("Id", id);
        startActivity(intent);
    }

    public boolean isOnline() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnectedOrConnecting();

    }

    public void checkConnection() {
        if (isOnline()) {

            mPresenter.getWarDeeLD().observe(this, new Observer<List<WarDeeVO>>() {
                @Override
                public void onChanged(@Nullable List<WarDeeVO> warDeeVOS) {
                    Log.d(ASarTaLineApp.LOG_TAG, "Livedata reached");

                    displayData(warDeeVOS);
                }
            });

        } else {
            showSnackBar("NO NETWORK CONNECTIONS");
        }
    }


    private void showSnackBar(String s) {
        Snackbar.make(rvFood, s, Snackbar.LENGTH_INDEFINITE).show();
    }
}
