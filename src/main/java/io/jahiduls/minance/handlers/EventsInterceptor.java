package io.jahiduls.minance.handlers;

import lombok.extern.slf4j.Slf4j;
import org.axonframework.eventhandling.ReplayStatus;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class EventsInterceptor {

    // will intercept and print all events in store; uncomment annotation to enable
    // @EventHandler
    public void on(Object event, ReplayStatus status) {
        log.debug("[{}][Event] {}", status, event);
    }
}
