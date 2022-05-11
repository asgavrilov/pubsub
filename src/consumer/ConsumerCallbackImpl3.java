package consumer;

import pojo.Message;

import java.util.concurrent.ThreadLocalRandom;

public class ConsumerCallbackImpl3 implements IConsumerCallback {
    public void run(Message message) {
        try {
            Thread.sleep(2000 + ThreadLocalRandom.current().nextLong(2000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Callback3 " + message.content);
    }
}
