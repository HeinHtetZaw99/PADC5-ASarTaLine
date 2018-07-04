package com.daniel.user.asartaline.mvp.presenters;

import android.arch.lifecycle.ViewModel;

import com.daniel.user.asartaline.mvp.views.BaseView;

public abstract class BasePresenter<T extends BaseView> extends ViewModel {
    protected T mView;

    public void initPresenter(final T mView) {
        this.mView = mView;
    }
}
