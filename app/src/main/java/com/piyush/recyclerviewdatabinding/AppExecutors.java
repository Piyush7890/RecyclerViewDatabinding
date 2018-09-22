package com.piyush.recyclerviewdatabinding;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class AppExecutors {
    private Executor diskExecutor;
    private Executor networkIO;
    private Executor mainThread;


    public AppExecutors() {
        diskExecutor = Executors.newSingleThreadExecutor();
        networkIO = Executors.newFixedThreadPool(3);
        mainThread = new MainThreadExecutor();
    }

    Executor diskIO()
    {
        return diskExecutor;
    }

    Executor getNetworkIO()
    {
        return networkIO;
    }
    Executor getMainThread()
    {

        return mainThread;
    }

    private class MainThreadExecutor implements Executor {
    private Handler mainThreadHandler = new Handler(Looper.getMainLooper());
        @Override
        public void execute(@NonNull Runnable command) {
            mainThreadHandler.post(command);
        }
    }
}
