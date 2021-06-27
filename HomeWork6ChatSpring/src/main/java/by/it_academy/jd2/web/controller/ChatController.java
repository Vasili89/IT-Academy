package by.it_academy.jd2.web.controller;

import by.it_academy.jd2.core.model.Message;
import by.it_academy.jd2.core.service.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ChatController {

    private final ChatService chatService;

    @Autowired
    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @GetMapping(value = "/signUp")
    public String signUp() {
        return "/signUp.jsp";
    }

    @GetMapping(value = "/signIn")
    public String signIn() {
        return "/signIn.jsp";
    }

    @GetMapping(value = "/message")
    public String writeMessage(HttpSession session) {
        return "/message.jsp";
    }

    @GetMapping(value = "/chats")
    public String chats(Model model, HttpSession session) {
        String user = (String) session.getAttribute("login");
        List<Message> messages = chatService.getUserMessages(user);
        model.addAttribute("messages", messages);
        return "/chats.jsp";
    }

    @PostMapping(value = "/inchat")
    public String inChat(@RequestParam(name = "login") String login,
                         @RequestParam(name = "password") String password,
                         HttpSession session) {
        chatService.checkUser(login, password);
        session.setAttribute("login", login);
        return "redirect:/message";
    }

    @PostMapping(value = "/regchat")
    public String regChat(@RequestParam(name = "FIO") String name,
                          @RequestParam(name = "birthDate") String birthDate,
                          @RequestParam(name = "login") String login,
                          @RequestParam(name = "password") String password) {
        chatService.checkAndSaveUser(name, birthDate, login, password);
        return "redirect:/signIn";
    }

    @GetMapping(value = "/exitChat")
    public String exitChat(HttpSession session) {
        session.removeAttribute("login");
        return "redirect:/signIn";
    }

    @PostMapping(value = "/mess")
    public String doChat(@RequestParam(name = "loginto") String loginTo,
                         @RequestParam(name = "message") String message,
                         HttpSession session) {
        String myLogin = (String) session.getAttribute("login");
        chatService.addMessage(myLogin, loginTo, message);
        return "redirect:/message";
    }

}
