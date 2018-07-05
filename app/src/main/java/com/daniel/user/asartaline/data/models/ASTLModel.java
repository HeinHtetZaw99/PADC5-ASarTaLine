package com.daniel.user.asartaline.data.models;

import android.arch.lifecycle.MutableLiveData;
import android.content.Context;

import com.daniel.user.asartaline.data.VOs.WarDeeVO;
import com.daniel.user.asartaline.network.response.WarDeeResponse;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ASTLModel extends BaseModel {
    private static final String ACCESS_TOKEN = "b002c7e1a528b7cb460933fc2875e916";
    private static ASTLModel objInstance;

    protected ASTLModel(Context context) {
        super(context);
    }

    public static void initASTLModel(Context context) {
        objInstance = new ASTLModel(context);
    }

    public static ASTLModel getInstance() {
        if (objInstance == null) {
            throw new RuntimeException("Model is being called before it was initialized ");
        }
        return objInstance;
    }

    public void startLoadingWarDeeList(final MutableLiveData<List<WarDeeVO>> warTeedLD, final MutableLiveData<String> errorLD) {
        theApi.loadWarDees(ACCESS_TOKEN)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<WarDeeResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(WarDeeResponse warDeeResponse) {
                        if (warDeeResponse != null && warDeeResponse.getCode() == 200 && warDeeResponse.getWarDeeVO().size() > 0) {
                            warTeedLD.setValue(warDeeResponse.getWarDeeVO());
                        }
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

}
