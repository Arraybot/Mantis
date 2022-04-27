package xyz.arraybot.mantis.events.message;

import discord4j.core.event.domain.message.MessageCreateEvent;
import discord4j.core.object.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuples;
import xyz.arraybot.mantis.events.EventListener;
import xyz.arraybot.mantis.services.FilterService;

@Component
public class MessageListener implements EventListener<MessageCreateEvent> {

    private final FilterService filterService;

    public MessageListener(@Autowired FilterService filterService) {
        this.filterService = filterService;
    }

    @Override
    public Class<MessageCreateEvent> typeOf() {
        return MessageCreateEvent.class;
    }

    @Override
    public Mono<Void> execute(MessageCreateEvent originalEvent) {
        // TODO: Make sure the bot has permission to delete messages.
        // TODO: Actually delete the message.
        // TODO: Notify the user their message was deleted (if applicable).
        return Mono.just(originalEvent)
                .filter(event -> event.getMessage().getAuthor().map(User::isBot).orElse(false))
                .flatMap(event -> event.getGuild().map(guild -> Tuples.of(guild.getId().asLong(), event)))
                .filter(tuple -> filterService.isFiltered(tuple.getT1(), tuple.getT2()))
                .then();
    }
}
