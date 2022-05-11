package consumer;

import pojo.Message;

public interface IConsumerCallback {
    void run(Message message);
}
