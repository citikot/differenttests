package online.agatstudio.activemq_demo1;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumer {

    @JmsListener(destination = "queue.example1")
    public void receiveMessage(Message message) {
        System.out.println("Received message<" + message.getText() + ">");
    }
}
