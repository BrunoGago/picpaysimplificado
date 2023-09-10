package com.picpaysimplificado.picpaysimplificado.services;

import com.picpaysimplificado.picpaysimplificado.domain.user.User;
import com.picpaysimplificado.picpaysimplificado.dtos.NotificationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NotificationService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${picpay.notification.url}")
    private String notificationUrl;

    public void sendNotification(User user, String message) throws Exception{
        String email = user.getEmail();

        NotificationDTO notificationRequest = new NotificationDTO(email, message);

       ResponseEntity<String> notificationResponse = restTemplate
               .postForEntity(notificationUrl, notificationRequest, String.class);

       if(!(notificationResponse.getStatusCode() == HttpStatus.OK)){
           System.out.println("Erro ao enviar a notificação");
           throw new Exception("Notificação está indiponível neste momento, tente mais tarde!");
       }
    }

}
