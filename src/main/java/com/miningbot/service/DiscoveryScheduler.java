package com.miningbot.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class DiscoveryScheduler {
    private static final Logger log = LoggerFactory.getLogger(DiscoveryScheduler.class);

    @Scheduled(fixedDelayString = "${app.discovery.interval-ms:3600000}", initialDelay = 10000)
    public void discoveryDeals() {
        log.info("Garimpo Bot: ciclo de pesquisa iniciado.");

        log.info("Price Hunter: ciclo de descoberta finalizado.");
    }
}
