package ar.edu.unrn.rankingservice.rabbitmq;

import ar.edu.unrn.rankingservice.dto.ClientDTO;
import ar.edu.unrn.rankingservice.service.ClientService;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@EnableRabbit
public class consumer {

    @Autowired
    ClientService clientService;

    private Gson gson = new Gson();

    @RabbitListener(queues = {"${rabbit.queue.name}"})
    public void receive(@Payload String message) {
        ClientDTO clientDTO = gson.fromJson(message, ClientDTO.class);
        log.info("Receive message {}", clientDTO);
        clientService.updateName(clientDTO);
    }
}