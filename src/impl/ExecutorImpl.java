package impl;

import art.Executor;
import art.Task;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ExecutorImpl implements Executor {

    private final BlockingQueue<Task> taskQueue = new LinkedBlockingQueue<>();

    @Override
    public void submit(Task task) {
        taskQueue.offer(task);
    }

    @Override
    public void runNext() {
        Task task = taskQueue.poll();
        if (task != null) {
            try {
                task.run();
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
    }

    @Override
    public void runLoop() {
        while (true) runNext();
    }
}
