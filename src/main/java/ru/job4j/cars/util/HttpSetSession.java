package ru.job4j.cars.util;

import org.springframework.ui.Model;
import ru.job4j.cars.model.User;

import javax.servlet.http.HttpSession;

public final class HttpSetSession {

    private HttpSetSession() {
    }

    public static void setSession(Model model, HttpSession httpSession) {
        User user = (User) httpSession.getAttribute("user");
        if (user == null) {
            user = new User();
            user.setLogin("Guest");
        }
        model.addAttribute("user", user);
    }
}
