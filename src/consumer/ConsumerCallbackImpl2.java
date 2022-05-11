package consumer;

import pojo.Message;

import java.util.concurrent.ThreadLocalRandom;

public class ConsumerCallbackImpl2 implements IConsumerCallback {
    public void run(Message message) {
        try {
            Thread.sleep(1000 + ThreadLocalRandom.current().nextLong(1000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Callback2 " + message.content);
    }
}
