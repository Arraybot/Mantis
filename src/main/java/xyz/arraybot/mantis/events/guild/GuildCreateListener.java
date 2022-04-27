package xyz.arraybot.mantis.events.guild;

import discord4j.core.event.domain.guild.GuildCreateEvent;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;
import xyz.arraybot.mantis.events.EventListener;

@Component
public class GuildCreateListener implements EventListener<GuildCreateEvent> {
    @Override
    public Class<GuildCreateEvent> typeOf() {
        return GuildCreateEvent.class;
    }

    @Override
    public Mono<Void> execute(GuildCreateEvent event) {
        // TODO: Insert into the database if it does not exist.
        return Mono.empty();
    }
}
