package online.agatstudio.activemq_demo1;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@RequiredArgsConstructor
@Getter
public class Message implements Serializable {

    private final String text;
}
