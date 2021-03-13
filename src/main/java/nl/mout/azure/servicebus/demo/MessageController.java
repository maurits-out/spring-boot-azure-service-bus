package nl.mout.azure.servicebus.demo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@Slf4j
@RequiredArgsConstructor
final class MessageController {

    private static final String DESTINATION_NAME = "spring-demo-queue";
    private final JmsTemplate jmsTemplate;

    @PostMapping("/messages")
    @ResponseStatus(HttpStatus.OK)
    @SuppressWarnings("unused")
    void postMessage(@RequestParam String content) {
        log.info("Sending message");
        jmsTemplate.convertAndSend(DESTINATION_NAME, new Message(content));
    }
}
