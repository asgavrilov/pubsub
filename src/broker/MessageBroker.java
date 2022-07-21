package broker;

import consumer.ConsumerQueue;
import consumer.IConsumerCallback;
import pojo.Message;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class MessageBroker implements IMessageBroker {
    private final Map<String, List<ConsumerQueue>> consumersTopicMap = new ConcurrentHashMap<>();


    @Override
    public void register(String topic, IConsumerCallback consumer) {
        ConsumerQueue consumerQueue = new ConsumerQueue(consumer);
        consumersTopicMap.compute(topic, (s, t) -> {
            if (t == null) {
                List<ConsumerQueue> list = new ArrayList<>();
                list.add(consumerQueue);
                return list;
            } else {
                t.add(consumerQueue);
                return t;
            }
        });
    }

    @Override
    public void send(Message message) {
        consumersTopicMap.getOrDefault(message.getTopic(),List.of()).
                forEach(consumerQueue -> consumerQueue.send(message));
    }
}
