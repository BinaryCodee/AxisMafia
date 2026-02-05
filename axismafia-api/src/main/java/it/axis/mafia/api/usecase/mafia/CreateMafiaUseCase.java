package it.axis.mafia.api.usecase.mafia;

import it.axis.mafia.api.domain.mafia.Mafia;
import java.util.concurrent.CompletableFuture;

public interface CreateMafiaUseCase {
    CompletableFuture<Mafia> execute(CreateMafiaRequest request);

    class CreateMafiaRequest {
        public final String name;
        public final String color;
        public final String leaderId;

        public CreateMafiaRequest(String name, String color, String leaderId) {
            this.name = name;
            this.color = color;
            this.leaderId = leaderId;
        }
    }
}
