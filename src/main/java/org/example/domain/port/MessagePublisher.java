package org.example.domain.port;


public interface MessagePublisher {
    void publish(Message message);
}

