package art;

public interface Executor {
    void submit(Task task);
    void runNext();
    void runLoop();
}