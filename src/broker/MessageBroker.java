package broker;

import consumer.ConsumerQueue;
import consumer.IConsumerCallback;
import pojo.Message;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class MessageBroker implements IMessageBroker {
    private final Executor executor = Executors.newCachedThreadPool();
    private final ConcurrentHashMap<String, List<ConsumerQueue>> consumersTopicMap = new ConcurrentHashMap<>();


    @Override
    public void register(String topic, IConsumerCallback consumer) {
        ConsumerQueue consumerQueue = new ConsumerQueue(consumer);
        executor.execute(consumerQueue);
        if (consumersTopicMap.containsKey(topic)) {
            consumersTopicMap.get(topic).add(consumerQueue);
        } else {
            ArrayList<ConsumerQueue> list = new ArrayList<>();
            list.add(consumerQueue);
            consumersTopicMap.put(topic, list);
        }
    }


    @Override
    public void send(Message message) {
        consumersTopicMap.getOrDefault(message.topic, List.of()).
                forEach(consumerQueue -> consumerQueue.send(message));
    }
}
