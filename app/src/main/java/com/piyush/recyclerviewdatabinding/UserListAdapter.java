package com.piyush.recyclerviewdatabinding;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.piyush.recyclerviewdatabinding.databinding.ItemUserBinding;

public class UserListAdapter extends DataBoundListAdapter<User,ItemUserBinding> {

     UserListAdapter(AppExecutors executors) {

        super(executors, new DiffUtil.ItemCallback<User>() {
            @Override
            public boolean areItemsTheSame(@NonNull User user, @NonNull User t1) {
                return user.getName().equals(t1.getName());
            }

            @Override
            public boolean areContentsTheSame(@NonNull User user, @NonNull User t1) {
                return user.getImageUrl().equals(t1.getImageUrl());
            }
        });
    }

    @Override
    protected ItemUserBinding createBinding(ViewGroup parent) {
        return DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),R.layout.item_user,parent,false);

    }

    @Override
    protected void bind(ItemUserBinding binding, User item) {
        binding.setUser(item);
    }
}
