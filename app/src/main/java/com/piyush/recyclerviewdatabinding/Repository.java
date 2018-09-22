package com.piyush.recyclerviewdatabinding;

import android.arch.core.util.Function;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Transformations;

import java.util.ArrayList;
import java.util.List;

public class Repository {

private MutableLiveData<List<User>> _users;
private LiveData<List<User>> users;

    public Repository() {
        _users = new MutableLiveData<>();
        users = Transformations.map(_users, new Function<List<User>, List<User>>() {
            @Override
            public List<User> apply(List<User> input) {
                return input;
            }
        });
    }

    public LiveData<List<User>> provideUsers()
    {
        List<User> users = new ArrayList<>();
        users.add(new User("female","female","https://randomuser.me/api/portraits/med/women/70.jpg"));
        users.add(new User("female","ellie","https://randomuser.me/api/portraits/med/women/29.jpg"));
        users.add(new User("female","chloe","https://randomuser.me/api/portraits/med/women/35.jpg"));
        users.add(new User("male","benjamin","https://randomuser.me/api/portraits/med/men/44.jpg"));
        users.add(new User("male","Ricky","https://randomuser.me/api/portraits/med/men/73.jpg"));
        users.add(new User("male","Stuart","https://randomuser.me/api/portraits/med/men/27.jpg"));
        users.add(new User("female","Veronica","https://randomuser.me/api/portraits/med/women/26.jpg"));
        users.add(new User("male","David","https://randomuser.me/api/portraits/med/men/7.jpg"));
       _users.setValue(users);
        return this.users;
    }
}
