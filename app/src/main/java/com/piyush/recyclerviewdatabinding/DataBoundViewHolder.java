package com.piyush.recyclerviewdatabinding;

import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

public class DataBoundViewHolder<T extends ViewDataBinding> extends RecyclerView.ViewHolder {

    public final T binding;

    DataBoundViewHolder(@NonNull T binding) {
        super(binding.getRoot());
        this.binding=binding;

    }
}
