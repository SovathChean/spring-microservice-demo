package com.example.postservice.core.processor;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;

public interface PostProcessor {
    String APPLICATIONS_OUT = "input";
    String APPROVED_OUT = "approved";
    String DECLINED_OUT = "declined";

    @Input(APPLICATIONS_OUT)
    SubscribableChannel sourceOfLoanApplications();

    @Input(APPROVED_OUT)
    MessageChannel approved();

    @Input(DECLINED_OUT)
    MessageChannel declined();
}
