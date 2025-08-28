package online.agatstudio.activemq_demo1;

import lombok.RequiredArgsConstructor;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MessageProducer {

    private final JmsTemplate jmsTemplate;

    public void sendMessage(Message message) {
        jmsTemplate.convertAndSend("queue.example1", message);
    }
}
