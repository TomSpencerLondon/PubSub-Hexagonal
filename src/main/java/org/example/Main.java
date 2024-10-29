package org.example;

import org.example.application.MessagePublisherService;
import org.example.application.MessageSubscriberService;
import org.example.domain.port.Message;
import org.example.infrastructure.inmemory.InMemoryMessagePublisher;
import org.example.infrastructure.inmemory.InMemoryMessageSubscriber;

import java.util.concurrent.LinkedBlockingQueue;

public class Main {
    public static void main(String[] args) {
        // Switch between in-memory and Azure by changing these lines
        var queue = new LinkedBlockingQueue<Message>();
        var publisher = new InMemoryMessagePublisher(queue);
        var subscriber = new InMemoryMessageSubscriber(queue);

        // Uncomment for Azure Service Bus
        // String connectionString = "<Azure Service Bus connection string>";
        // String queueName = "<queue name>";
        // MessagePublisher publisher = new AzureServiceBusPublisher(connectionString, queueName);
        // MessageSubscriber subscriber = new AzureServiceBusSubscriber(connectionString, queueName);

        MessagePublisherService publisherService = new MessagePublisherService(publisher);
        MessageSubscriberService subscriberService = new MessageSubscriberService(subscriber);

        subscriberService.startSubscription();
        publisherService.publishMessage("Hello, Hexagonal World!");
    }
}