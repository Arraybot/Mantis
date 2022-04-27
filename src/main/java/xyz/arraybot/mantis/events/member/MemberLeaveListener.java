package xyz.arraybot.mantis.events.member;

import discord4j.core.event.domain.guild.MemberLeaveEvent;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;
import xyz.arraybot.mantis.events.EventListener;

@Component
public class MemberLeaveListener implements EventListener<MemberLeaveEvent> {
    @Override
    public Class<MemberLeaveEvent> typeOf() {
        return MemberLeaveEvent.class;
    }

    @Override
    public Mono<Void> execute(MemberLeaveEvent event) {
        // TODO: Send leave message.
        // TODO: Check punishments.
        return Mono.empty();
    }
}
