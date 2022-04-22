package xyz.arraybot.mantis.events;

import discord4j.core.event.domain.message.MessageCreateEvent;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Mono;

@Controller
public class MessageListener implements EventListener<MessageCreateEvent> {
    @Override
    public Class<MessageCreateEvent> typeOf() {
        return MessageCreateEvent.class;
    }

    @Override
    public Mono<Void> execute(MessageCreateEvent event) {
        System.out.println("Message received " + event.getMessage().getContent());
        return Mono.empty();
    }
}
