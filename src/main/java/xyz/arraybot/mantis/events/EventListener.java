package xyz.arraybot.mantis.events;

import discord4j.core.event.domain.Event;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import reactor.core.publisher.Mono;

public interface EventListener<T extends Event> {

    Logger LOGGER = LoggerFactory.getLogger(EventListener.class);

    Class<T> typeOf();

    Mono<Void> execute(T event);

    default Mono<Void> error(Throwable throwable) {
        LOGGER.error("Error processing " + typeOf(), throwable);
        return Mono.empty();
    }
}
