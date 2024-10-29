package org.example.infrastructure.inmemory;

import org.example.domain.port.Message;
import org.example.domain.port.MessageSubscriber;

import java.util.concurrent.BlockingQueue;

public class InMemoryMessageSubscriber implements MessageSubscriber {
    private final BlockingQueue<Message> queue;

    public InMemoryMessageSubscriber(BlockingQueue<Message> queue) {
        this.queue = queue;
    }

    @Override
    public void subscribe() {
        new Thread(() -> {
            while (true) {
                try {
                    Message message = queue.take();
                    System.out.println("In-memory Subscriber received message: " + message.getContent());
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }).start();
    }
}