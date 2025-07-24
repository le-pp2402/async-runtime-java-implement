import art.Executor;
import art.Reactor;
import art.Task;
import impl.ExecutorImpl;
import impl.ReactorImpl;

public class Runtime {
    private final Executor executor = new ExecutorImpl();
    private final Reactor reactor = new ReactorImpl();

    public void spawn(Task task) {
        executor.submit(task);
    }

    public Executor executor() {
        return executor;
    }

    public Reactor reactor() {
        return reactor;
    }

    public void run() {
        executor.runLoop();
    }
}
