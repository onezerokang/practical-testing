package sample.cafekiosk.spring.client.mail;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MailSendClient {
    public boolean sendMail(String fromMail, String toMail, String title, String content) {
        log.info("메일 전송");
        throw new IllegalArgumentException("메일 오류");
    }
}
