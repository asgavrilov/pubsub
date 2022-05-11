package broker;

import consumer.IConsumerCallback;
import pojo.Message;

public class MessageBroker implements IMessageBroker {
    @Override
    public void register(String topic, IConsumerCallback consumer) {
    }

    @Override
    public void send(Message message) {
    }
}
