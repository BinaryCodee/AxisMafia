package it.axis.mafia.api.usecase.user;

import it.axis.mafia.api.domain.user.User;
import java.util.concurrent.CompletableFuture;

public interface CreateUserUseCase {
    CompletableFuture<User> execute(CreateUserRequest request);

    class CreateUserRequest {
        public final String name;
        public final String uuid;

        public CreateUserRequest(String name, String uuid) {
            this.name = name;
            this.uuid = uuid;
        }
    }
}
