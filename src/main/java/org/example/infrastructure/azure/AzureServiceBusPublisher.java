package org.example.infrastructure.azure;

import com.azure.messaging.servicebus.ServiceBusClientBuilder;
import com.azure.messaging.servicebus.ServiceBusSenderClient;
import org.example.domain.port.Message;
import org.example.domain.port.MessagePublisher;

public class AzureServiceBusPublisher implements MessagePublisher {
    private final ServiceBusSenderClient senderClient;

    public AzureServiceBusPublisher(String connectionString, String queueName) {
        this.senderClient = new ServiceBusClientBuilder()
                .connectionString(connectionString)
                .sender()
                .queueName(queueName)
                .buildClient();
    }

    @Override
    public void publish(Message message) {
        senderClient.sendMessage(new com.azure.messaging.servicebus.ServiceBusMessage(message.getContent()));
    }
}
