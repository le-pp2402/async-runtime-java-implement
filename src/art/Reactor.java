package art;

public interface Reactor {
    void registerEvent(Object key, Waker waker);
    void eventLoop();
    void registerTimeout(long delayMillis, Waker waker);
}
