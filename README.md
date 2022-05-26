# message-broker-boilerplate

Software Development Skills - Message Broker Exercise
A message broker is a component that routes messages.
The creator of a message is called producer​ and the reader of a message is called consumer.​ Messages are routed using a ​topic​ - this is a string value that categorizes a message.
When multiple consumers register for a single topic, messages should be consumed by all of them. Some topics may not have any consumers registered to them at all.
The message broker should be designed in such a way so that consuming messages in one consumer will not “starve” other consumers. Also - do not allow starvation between topics.
We need you to code a message broker that implements the following interface:

public interface ​IMessageBroker {
​void ​register(String topic, ConsumerCallback consumer);
​void ​send(Message message);
}

 A. Design - please describe the design for a multi-threaded message broker that complies with the above requirements
 B. Implementation - please try to complete sections 1 and 2
1. Implement the message broker
2. Test your code:
a. Register 3 consumers: 
i. Consumer 1 registers for topic A
ii. Consumer 2 registers to topics B and C
iii. Consumer 3 registers to topics A, B, and C
b. To simulate message consumption add 1 millisec sleep to each topic callback.
c. Send 50,000 messages per topic.

Feel free to use the boilerplate code in this project, or start from scratch.
