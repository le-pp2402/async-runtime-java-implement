import art.Task;
import impl.WakerImpl;

public class Main {
    public static void main(String[] args) {
        Runtime runtime = new Runtime();

        Task TaskA = new Task() {
            boolean firstRun = true;

            @Override
            public void run() {
                if (firstRun) {
                    firstRun = false;
                    System.out.println("[Task - A] Waiting 2 ...");
                    runtime.reactor().registerTimeout(
                            2000,
                            new WakerImpl(runtime.executor(), this)
                    );
                } else {
                    System.out.println("[Task - A] Finished after delay!");
                }
            }
        };
        Task TaskB = () -> System.out.println("[Task - B] Hello world!");

        runtime.spawn(TaskA);
        runtime.spawn(TaskB);

        runtime.run();
    }
}
