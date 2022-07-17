package broker;

import consumer.IConsumerCallback;
import pojo.Message;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class MessageBroker implements IMessageBroker {
    private final BlockingQueue<Message> messageQueue = new LinkedBlockingQueue<>(10);
    private final Map<String, Set<IConsumerCallback>> consumersTopicMap = new HashMap<>();

    public void addMessageToQueue(Message message) {
        messageQueue.add(message);
    }

    public void removeMessageFromQueue() throws InterruptedException {
        messageQueue.take();
    }


    @Override
    public void register(String topic, IConsumerCallback consumer) {
        Set<IConsumerCallback> consumers;
        if (consumersTopicMap.containsKey(topic)) {
            consumers = consumersTopicMap.get(topic);
        } else {
            consumers = new HashSet<>();
        }
        consumers.add(consumer);
        consumersTopicMap.put(topic, consumers);

    }

    @Override
    public void send(Message message) throws InterruptedException {
        addMessageToQueue(message);
        String topic = message.getTopic();
        Set<IConsumerCallback> consumersByTopic = consumersTopicMap.get(topic);
        for (IConsumerCallback consumer : consumersByTopic) {
            consumer.run(message);
        }
        removeMessageFromQueue();
    }
}
