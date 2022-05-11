package broker;

import consumer.IConsumerCallback;
import pojo.Message;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MessageBroker implements IMessageBroker {
    @Override
    public void register(String topic, IConsumerCallback consumer) {
    }

    @Override
    public void send(Message message) {
    }
}
