package xyz.arraybot.mantis.services;

import discord4j.core.event.domain.message.MessageCreateEvent;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class FilterService {

    // TODO: Make cache.

    public boolean isFiltered(long guildId, MessageCreateEvent event) {
        // TODO: Check if message is filtered.
        return false;
    }

    public Mono<Void> filterMessage(long guildId, MessageCreateEvent event) {
        // TODO: Send message if applicable.
        return Mono.empty();
    }

}
