package xyz.arraybot.mantis.config;

import discord4j.core.DiscordClientBuilder;
import discord4j.core.GatewayDiscordClient;
import discord4j.core.event.domain.Event;
import discord4j.core.object.presence.ClientActivity;
import discord4j.core.object.presence.ClientPresence;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import xyz.arraybot.mantis.events.EventListener;

import java.util.List;
import java.util.Objects;

@Configuration
public class BotConfiguration {

    @Value("${BOT_TOKEN}")
    private String token;

    @Bean
    public <T extends Event> GatewayDiscordClient client(List<EventListener<T>> listeners) {
        GatewayDiscordClient client = DiscordClientBuilder.create(token)
                .build()
                .gateway()
                .setInitialPresence((shard) ->
                        ClientPresence.doNotDisturb(ClientActivity.listening("/help"))
                )
                .login()
                .block();
        listeners.forEach(listener -> Objects.requireNonNull(client).on(listener.typeOf())
                .flatMap(listener::execute)
                .onErrorResume(listener::error)
                .subscribe());
        return client;
    }

}
