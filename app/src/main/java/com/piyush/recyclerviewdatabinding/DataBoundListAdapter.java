package com.piyush.recyclerviewdatabinding;


import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.recyclerview.extensions.AsyncDifferConfig;
import android.support.v7.recyclerview.extensions.ListAdapter;
import android.support.v7.util.DiffUtil;
import android.view.ViewGroup;

//generic listadapter for diffutil as well as data binding

public abstract class DataBoundListAdapter<T, V extends ViewDataBinding> extends ListAdapter<T, DataBoundViewHolder<V>> {


     DataBoundListAdapter(AppExecutors executors, DiffUtil.ItemCallback<T> diffCallback) {

        super( new AsyncDifferConfig
                .Builder<>(diffCallback)
                .setBackgroundThreadExecutor(executors.diskIO())
                .build()
        );
    }

    @NonNull
    @Override
    public DataBoundViewHolder<V> onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        V binding = createBinding(viewGroup);
        return new DataBoundViewHolder<>(binding);
    }

    protected abstract V createBinding(ViewGroup parent);

    @Override
    public void onBindViewHolder(@NonNull DataBoundViewHolder<V> vDataBoundViewHolder, int i) {
        bind(vDataBoundViewHolder.binding,getItem(i));
        vDataBoundViewHolder.binding.executePendingBindings();
    }

    protected abstract void bind(V binding, T item);
}
