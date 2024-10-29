package org.example.application;

import org.example.domain.port.Message;
import org.example.domain.port.MessagePublisher;

public class MessagePublisherService {
    private final MessagePublisher publisher;

    public MessagePublisherService(MessagePublisher publisher) {
        this.publisher = publisher;
    }

    public void publishMessage(String content) {
        System.out.println("Publishing message");
        Message message = new Message();
        message.setContent(content);
        publisher.publish(message);
    }
}
