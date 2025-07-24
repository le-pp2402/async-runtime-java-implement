package impl;

import art.Executor;
import art.Task;
import art.Waker;

public class WakerImpl implements Waker {
    private final Executor executor;
    private final Task task;

    public WakerImpl(Executor executor, Task task) {
        this.executor = executor;
        this.task = task;
    }

    @Override
    public void wake() {
        executor.submit(task);
    }
}
