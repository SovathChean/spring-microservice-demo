package com.example.postservice.core.event;

import com.example.postservice.core.dto.PostDTO;
import com.example.postservice.core.dto.UserDTO;
import com.example.postservice.core.processor.PostProcessor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@EnableBinding(PostProcessor.class)
@Slf4j
public class KafkaEvent {
    private PostProcessor postProcessor;
    @StreamListener(PostProcessor.APPROVED_OUT)
    public void consumeMessage(UserDTO userDTO) {
        log.info("Consume payload : " + userDTO);
    }
    @StreamListener(PostProcessor.DECLINED_OUT)
    public void postMessage(PostDTO postDTO) {
        log.info("PostDTO payload : " + postDTO);
    }
}
