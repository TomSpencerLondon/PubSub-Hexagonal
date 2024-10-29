package org.example.application;

import org.example.domain.port.MessageSubscriber;

public class MessageSubscriberService {
    private final MessageSubscriber subscriber;

    public MessageSubscriberService(MessageSubscriber subscriber) {
        this.subscriber = subscriber;
    }

    public void startSubscription() {
        subscriber.subscribe();
    }
}
