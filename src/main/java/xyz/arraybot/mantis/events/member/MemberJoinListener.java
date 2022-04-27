package xyz.arraybot.mantis.events.member;

import discord4j.core.event.domain.guild.MemberJoinEvent;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;
import xyz.arraybot.mantis.events.EventListener;

@Component
public class MemberJoinListener implements EventListener<MemberJoinEvent> {
    @Override
    public Class<MemberJoinEvent> typeOf() {
        return MemberJoinEvent.class;
    }

    @Override
    public Mono<Void> execute(MemberJoinEvent event) {
        // TODO: Send welcome message.
        // TODO: Perform auto role.
        return Mono.empty();
    }
}
