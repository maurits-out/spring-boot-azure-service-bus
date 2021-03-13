package nl.mout.azure.servicebus.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@SuppressWarnings("unused")
final class MessageReceiver {

    private static final String DESTINATION_NAME = "spring-demo-queue";

    @JmsListener(destination = DESTINATION_NAME, containerFactory = "jmsListenerContainerFactory")
    @SuppressWarnings("unused")
    void receiveMessage(Message message) {
        log.info("Received message: {}", message.getContent());
    }
}
