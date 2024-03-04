package sample.cafekiosk.spring.api.service.mail;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sample.cafekiosk.spring.client.mail.MailSendClient;
import sample.cafekiosk.spring.domain.history.mail.MailSendHistory;
import sample.cafekiosk.spring.domain.history.mail.MailSendHistoryRepository;

@RequiredArgsConstructor
@Service
public class MailService {
    private final MailSendClient mailSendClient;
    private final MailSendHistoryRepository mailSendHistoryRepository;

    public boolean sendMail(String fromEmail, String toEmail, String title, String content) {
        boolean result = mailSendClient.sendMail(fromEmail, toEmail, title, content);
        if (result) {
            mailSendHistoryRepository.save(MailSendHistory.builder()
                    .fromMail(fromEmail)
                    .toMail(toEmail)
                    .title(title)
                    .content(content)
                    .build());
            return true;
        }
        return false;
    }
}
