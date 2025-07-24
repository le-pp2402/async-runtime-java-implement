package art;

public interface ThreadPool {
    void executeBlocking(Runnable task);
}
