package com.daniel.user.asartaline.activities;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import com.bumptech.glide.Glide;
import com.daniel.user.asartaline.R;
import com.daniel.user.asartaline.adapters.FoodAdapter;
import com.daniel.user.asartaline.components.SmartRecyclerView;
import com.daniel.user.asartaline.mvp.presenters.DetailsPresenter;
import com.daniel.user.asartaline.mvp.views.DetailsView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FoodDetailsActivity extends AppCompatActivity implements DetailsView {
    int[] images = {R.drawable.resturant, R.drawable.dummy_food_img, R.drawable.resturant, R.drawable.dummy_food_img};
    @BindView(R.id.foodDetailsImageViewFlipper)
    ViewFlipper vp_imgView;
    ActionBar actionBar;

    @BindView(R.id.rv_suited_Item)
    SmartRecyclerView rvSuitedItem;

    FoodAdapter mAdapter;
    private DetailsPresenter mPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_details);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this, this);
        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setDisplayShowHomeEnabled(true);

        mPresenter = ViewModelProviders.of(this).get(DetailsPresenter.class);
        mPresenter.initPresenter(this);
        rvSuitedItem.setLayoutManager(new LinearLayoutManager(this));
        mAdapter = new FoodAdapter(this, mPresenter);
        rvSuitedItem.setAdapter(mAdapter);


        ButterKnife.bind(this, this);
        for (int image : images) {
            flipperImages(image);
        }
    }

    public void flipperImages(int image) {
        ImageView imageView = new ImageView(this);
        imageView.setScaleType(ImageView.ScaleType.CENTER);
        Glide.with(imageView).load(image).into(imageView);
        vp_imgView.addView(imageView);
        vp_imgView.setFlipInterval(2500);
        vp_imgView.setAutoStart(true);
        vp_imgView.setInAnimation(this, R.anim.slide_left2right);
        vp_imgView.setOutAnimation(this, R.anim.slide_right2left);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
//            Intent intent = MainActivity.newIntent(this);
//            startActivity(intent);
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
