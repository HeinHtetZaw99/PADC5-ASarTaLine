package com.daniel.user.asartaline.mvp.presenters;

import android.arch.lifecycle.LiveData;

import com.daniel.user.asartaline.data.VOs.GetWarDee.WarDeeVO;
import com.daniel.user.asartaline.data.models.ASTLModel;
import com.daniel.user.asartaline.delegate.DetailsDelegate;
import com.daniel.user.asartaline.mvp.views.DetailsView;

public class DetailsPresenter extends BasePresenter<DetailsView> implements DetailsDelegate {

    @Override
    public void initPresenter(DetailsView mView) {

        super.initPresenter(mView);
    }

    public LiveData<WarDeeVO> onUiReady(String id) {
        return ASTLModel.getInstance().getWarDeeByIdLD(id);
    }
}
