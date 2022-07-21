package broker;

import consumer.IConsumerCallback;
import pojo.Message;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ConsumerQueue{
    private final Executor consumerExecutor = Executors.newSingleThreadExecutor();
    private final IConsumerCallback callback;

    public ConsumerQueue(IConsumerCallback callback) {
        this.callback = callback;
    }


    public void send(Message message) {
        consumerExecutor.execute(() -> {
            this.callback.run(message);
        });
    }
}
