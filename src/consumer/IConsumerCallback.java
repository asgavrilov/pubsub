package consumer;

import pojo.Message;

public interface IConsumerCallback extends Runnable{
    void run(Message message);
}
