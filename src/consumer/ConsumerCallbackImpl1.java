package consumer;

import pojo.Message;

import java.util.concurrent.ThreadLocalRandom;

public class ConsumerCallbackImpl1 implements IConsumerCallback {
    public void run(Message message) {
        try {
            Thread.sleep(50 + ThreadLocalRandom.current().nextLong(50));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Callback1 " + message.content);
    }
}
