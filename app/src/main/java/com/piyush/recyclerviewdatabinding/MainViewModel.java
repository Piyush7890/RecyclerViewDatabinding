package com.piyush.recyclerviewdatabinding;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.view.View;

import java.util.List;

public class MainViewModel extends ViewModel{
    private LiveData<List<User>> users;

    public MainViewModel(Repository repository) {
         users=repository.provideUsers();
    }

    public LiveData<List<User>> getUsers() {
        return users;
    }
}
