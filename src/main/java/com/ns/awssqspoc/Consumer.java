package com.ns.awssqspoc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.aws.messaging.listener.SqsMessageDeletionPolicy;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class Consumer {

    @SqsListener(value = "${cloud.aws.end-point.uri}",deletionPolicy = SqsMessageDeletionPolicy.ON_SUCCESS)
    public void processMessage(Pojo message) {
        log.info("Message from SQS {}", message);
    }
}
