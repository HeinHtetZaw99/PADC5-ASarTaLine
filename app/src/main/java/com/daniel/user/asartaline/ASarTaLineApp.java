package com.daniel.user.asartaline;

import android.app.Application;

import com.daniel.user.asartaline.data.models.ASTLModel;

public class ASarTaLineApp extends Application {

    public static final String LOG_TAG = "ASTL";

    @Override
    public void onCreate() {
        super.onCreate();
        ASTLModel.initASTLModel(getApplicationContext());
    }


}
