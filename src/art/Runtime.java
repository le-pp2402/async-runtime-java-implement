package art;

public interface Runtime {
    void init();
    void blockOn(Task mainTask);
    void spawn(Task task);
}
