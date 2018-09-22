package com.piyush.recyclerviewdatabinding;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView usersList;
    UserListAdapter adapter;
    MainViewModel model;
    ViewModelFactory factory;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        usersList = findViewById(R.id.rview);
        factory=new ViewModelFactory();
        usersList.setLayoutManager(new LinearLayoutManager(this));
        adapter = new UserListAdapter(new AppExecutors());
        usersList.setAdapter(adapter);
        model = ViewModelProviders.of(this,factory).get(MainViewModel.class);
        model.getUsers().observe(this, new Observer<List<User>>() {
            @Override
            public void onChanged(@Nullable List<User> users) {
                usersList.setVisibility(View.VISIBLE);
                adapter.submitList(users);
            }
        });

    }
}
