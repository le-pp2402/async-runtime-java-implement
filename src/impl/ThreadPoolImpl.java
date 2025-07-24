package impl;

import art.ThreadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolImpl implements ThreadPool {
    private final ExecutorService threadPool = Executors.newCachedThreadPool();

    @Override
    public void executeBlocking(Runnable task) {
        threadPool.submit(task);
    }
}

