package org.example.infrastructure.inmemory;

import org.example.domain.port.Message;
import org.example.domain.port.MessagePublisher;

import java.util.concurrent.BlockingQueue;

public class InMemoryMessagePublisher implements MessagePublisher {
    private final BlockingQueue<Message> queue;

    public InMemoryMessagePublisher(BlockingQueue<Message> queue) {
        this.queue = queue;
    }

    @Override
    public void publish(Message message) {
        queue.add(message);
    }
}
