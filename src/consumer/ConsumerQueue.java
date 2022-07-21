package consumer;

import consumer.IConsumerCallback;
import pojo.Message;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class ConsumerQueue implements Runnable {
    private final IConsumerCallback callback;

    private final BlockingQueue<Message> queue = new LinkedBlockingQueue<>();

    public ConsumerQueue(IConsumerCallback callback) {
        this.callback = callback;
    }

    public void send(Message message) {
        this.queue.add(message);
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                this.callback.run(queue.take());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}
