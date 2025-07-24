package impl;

import art.Reactor;
import art.Waker;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

public class ReactorImpl implements Reactor {
    private final Timer timer = new Timer();
    private final Map<Object, Waker> fakeEvents = new HashMap<>();
    private final Queue<Object> readyEvents = new LinkedList<>();
    // TODO: stop after finish all task
    private final AtomicInteger taskCounter = new AtomicInteger(0);
    private volatile boolean running = true;

    @Override
    public void registerTimeout(long delayMillis, Waker waker) {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                waker.wake();
            }
        }, delayMillis);
    }

    @Override
    public void registerEvent(Object key, Waker waker) {
        fakeEvents.put(key, waker);
    }

    public void simulateEvent(Object key) {
        readyEvents.add(key);
    }

    @Override
    public void eventLoop() {
        while (true) {
            while (!readyEvents.isEmpty()) {
                Object key = readyEvents.poll();
                Waker waker = fakeEvents.get(key);
                if (waker != null) {
                    waker.wake();
                }
            }

            try {
                Thread.sleep(10); // sleep nhẹ để không chiếm CPU
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
