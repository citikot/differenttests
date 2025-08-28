package online.agatstudio.activemq_demo1;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MessageController {

    private final MessageProducer messageProducer;

    @PostMapping("/publish-message")
    public ResponseEntity<String> publishMessage(@RequestBody String message) {

        Message msg = new Message(message);

        try {
            messageProducer.sendMessage(msg);
            return new ResponseEntity<>("Message published successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error publishing message" + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
