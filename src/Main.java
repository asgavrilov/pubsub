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
        for (int i = 0; i < 50000; i++) {
            broker.send(new Message("Message from A", "A"));
            broker.send(new Message("Message from B", "B"));
            broker.send(new Message("Message from C", "C"));
        }
    }
}
