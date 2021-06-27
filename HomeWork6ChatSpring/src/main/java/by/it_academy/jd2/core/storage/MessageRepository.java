package by.it_academy.jd2.core.storage;

import by.it_academy.jd2.core.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {

    List<Message> findByUserTo(String userTo);

}
