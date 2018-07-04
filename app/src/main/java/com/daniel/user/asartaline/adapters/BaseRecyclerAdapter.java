package com.daniel.user.asartaline.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.daniel.user.asartaline.viewholders.BaseViewHolders;

public abstract class BaseRecyclerAdapter<T extends BaseViewHolders> extends RecyclerView.Adapter<T> {

    protected LayoutInflater mLayoutInflator;

    public BaseRecyclerAdapter(Context context) {
        mLayoutInflator = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public T onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull T holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }
}
