package it.axis.mafia.core.bootstrap;

import it.axis.mafia.core.registry.ServiceRegistry;
import java.util.logging.Logger;

public class CoreBootstrapper implements Bootstrapper {
    private final Logger logger;

    public CoreBootstrapper(Logger logger) {
        this.logger = logger;
    }

    @Override
    public void bootstrap() {
        logger.info("Bootstrapping Core Enterprise Systems...");
        // Complex initialization logic here
    }

    @Override
    public void shutdown() {
        logger.info("Shutting down Core...");
    }
}
