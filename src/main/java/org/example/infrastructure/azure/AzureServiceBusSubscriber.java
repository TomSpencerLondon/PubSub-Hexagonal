package org.example.infrastructure.azure;

import com.azure.messaging.servicebus.ServiceBusClientBuilder;
import com.azure.messaging.servicebus.ServiceBusProcessorClient;
import org.example.domain.port.MessageSubscriber;

public class AzureServiceBusSubscriber implements MessageSubscriber {
    private final ServiceBusProcessorClient processorClient;

    public AzureServiceBusSubscriber(String connectionString, String queueName) {
        this.processorClient = new ServiceBusClientBuilder()
                .connectionString(connectionString)
                .processor()
                .queueName(queueName)
                .processMessage(context -> {
                    String messageBody = context.getMessage().getBody().toString();
                    System.out.println("Azure Service Bus Subscriber received message: " + messageBody);
                })
                .processError(context -> System.err.println("Error occurred: " + context.getException()))
                .buildProcessorClient();
    }

    @Override
    public void subscribe() {
        processorClient.start();
    }
}
