package by.it_academy.jd2.core.service;

import by.it_academy.jd2.core.model.ChatUser;
import by.it_academy.jd2.core.model.Message;
import by.it_academy.jd2.core.storage.ChatRepository;
import by.it_academy.jd2.core.storage.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatService {

    private final ChatRepository chatRepository;
    private final MessageRepository messageRepository;

    @Autowired
    public ChatService(ChatRepository chatRepository, MessageRepository messageRepository) {
        this.chatRepository = chatRepository;
        this.messageRepository = messageRepository;
    }

    public void checkUser(String login, String password) {
        if (login.isEmpty() || password.isEmpty()) throw
                new IllegalArgumentException("Login or Password is incorrect!");

        ChatUser checkedUser = chatRepository.findByLoginAndPassword(login, password).orElseThrow(
                () -> new IllegalArgumentException("Login or password is incorrect!"));
    }

    public void checkField(String param) {
        if (param.isEmpty()) {
            throw new IllegalArgumentException("Any field is empty!");
        }
    }

    public void checkAndSaveUser(String name, String birthDate, String login, String password) {
        checkField(name);
        checkField(birthDate);
        checkField(login);
        checkField(password);
        if (chatRepository.findById(login).isPresent()) throw
                new IllegalArgumentException("User with login " + login + " is exists.");
        ChatUser newUser = new ChatUser(name, birthDate, login, password);
        chatRepository.save(newUser);
    }

    public void addMessage(String loginFrom, String loginTo, String message) {
        Message newMessage = new Message(loginTo, loginFrom, message);
        chatRepository.findById(loginTo).orElseThrow(
                () -> new IllegalArgumentException("User " + loginTo + " not founf."));
        messageRepository.save(newMessage);
    }

    public List<Message> getUserMessages(String userTo) {
        List<Message> messages = messageRepository.findByUserTo(userTo);
        return messages;
    }
}
