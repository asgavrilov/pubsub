package broker;

import consumer.IConsumerCallback;
import pojo.Message;

public interface IMessageBroker {
    void register(String topic, IConsumerCallback consumer);

    void send(Message message) throws InterruptedException;
}
