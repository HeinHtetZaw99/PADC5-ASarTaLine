package com.daniel.user.asartaline.activities;

import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;

import com.daniel.user.asartaline.R;
import com.daniel.user.asartaline.adapters.FoodAdapter;
import com.daniel.user.asartaline.components.SmartRecyclerView;
import com.daniel.user.asartaline.components.SmartScrollListener;
import com.daniel.user.asartaline.mvp.presenters.MainPresenter;
import com.daniel.user.asartaline.mvp.views.MainView;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this, this);

        mPresenter = ViewModelProviders.of(this).get(MainPresenter.class);
        mPresenter.initPresenter(this);

        rvFood.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new FoodAdapter(this, mPresenter);
        rvFood.setAdapter(mAdapter);
        mSmartScrollListener = new SmartScrollListener(new SmartScrollListener.OnSmartScrollListener() {
            @Override
            public void onListEndReach() {
                //Snackbar.make(rvNews, "This is all the data for NOW.", Snackbar.LENGTH_LONG).show();
                //TODO load more data.
            }
        });
        rvFood.addOnScrollListener(mSmartScrollListener);

        if (mSearchPanel.isAttachedToWindow()) {
            mSearchPanel.setCardBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
        }
    }

    @Override
    public void launchFoodDetailsScreen() {
        Intent intent = new Intent(MainActivity.this, FoodDetailsActivity.class);
        startActivity(intent);
    }
}
