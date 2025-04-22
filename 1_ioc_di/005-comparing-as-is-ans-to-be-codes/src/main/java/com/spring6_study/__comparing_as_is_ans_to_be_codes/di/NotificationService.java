package com.spring6_study.__comparing_as_is_ans_to_be_codes.di;

import org.springframework.stereotype.Service;

@Service
public class NotificationService {
    public void sendNotification(String message) {
        System.out.println("알림 발송 : " + message);
    }
}
