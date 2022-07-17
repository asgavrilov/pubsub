package pojo;

public class Message {
    public String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String topic;

    public Message(String content, String topic) {
        this.content = content;
        this.topic = topic;
    }
}
