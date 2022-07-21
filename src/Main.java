import broker.MessageBroker;
import consumer.ConsumerCallbackImpl1;
import consumer.ConsumerCallbackImpl2;
import consumer.ConsumerCallbackImpl3;
import pojo.Message;

public class Main {

    public static void main(String[] args) {
        MessageBroker broker = new MessageBroker();
        broker.register("A", new ConsumerCallbackImpl1());
        broker.register("A", new ConsumerCallbackImpl2());
        broker.register("A", new ConsumerCallbackImpl3());
        broker.register("B", new ConsumerCallbackImpl1());
        broker.register("B", new ConsumerCallbackImpl2());
        broker.register("C", new ConsumerCallbackImpl2());

        Message message1 = new Message("Message from A", "A");
        Message message2 = new Message("Message from B", "B");
        Message message3 = new Message("Message from C", "C");

        for (int i = 0; i < 50000; i++) {
            broker.send(message1);
            broker.send(message2);
            broker.send(message3);
        }
    }
}
