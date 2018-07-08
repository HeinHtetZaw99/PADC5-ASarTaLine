package com.daniel.user.asartaline.viewholders;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import butterknife.ButterKnife;

public abstract class BaseViewHolders<W> extends RecyclerView.ViewHolder implements View.OnClickListener {
    public BaseViewHolders(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
        itemView.setOnClickListener(this);
    }

    public abstract void setData(W data);

}
