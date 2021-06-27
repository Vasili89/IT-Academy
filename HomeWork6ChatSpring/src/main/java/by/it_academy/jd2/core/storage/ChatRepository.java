package by.it_academy.jd2.core.storage;

import by.it_academy.jd2.core.model.ChatUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface ChatRepository extends JpaRepository<ChatUser, String> {

    Optional<ChatUser> findByLoginAndPassword(String login, String password);

}
