package ru.job4j.cars.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.job4j.cars.model.User;
import ru.job4j.cars.service.UserService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Optional;

import static ru.job4j.cars.util.HttpSetSession.setSession;

@RequestMapping("/user")
@Controller
public class UserController {
    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/formAdd")
    public String addUser(Model model, HttpSession httpSession) {
        setSession(model, httpSession);
        return "user/add";
    }

    @GetMapping("/fail")
    public String failUser(Model model, HttpSession httpSession) {
        setSession(model, httpSession);
        return "user/fail";
    }

    @GetMapping("/success")
    public String successUser(Model model, HttpSession httpSession) {
        setSession(model, httpSession);
        return "user/success";
    }

    @PostMapping("/registration")
    public String registration(Model model, @ModelAttribute User user, HttpSession httpSession) {
        User regUser = userService.create(user);
        if (regUser == null) {
            model.addAttribute("message", "A user with such a login already exists");
            return "redirect:/user/fail";
        }
        setSession(model, httpSession);
        return "redirect:/user/success";
    }

    @GetMapping("/loginPage")
    public String loginPage(Model model, @RequestParam(name = "fail", required = false) Boolean fail, HttpSession httpSession) {
        model.addAttribute("fail", fail != null);
        setSession(model, httpSession);
        return "user/login";
    }

  @PostMapping("/login")
    public String login(@ModelAttribute User user, HttpServletRequest req) {
        Optional<User> userDb = userService.findUserByLoginAndPassword(
                user.getLogin(), user.getPassword()
        );
        if (userDb.isEmpty()) {
            return "redirect:/user/loginPage?fail=true";
        }
        HttpSession session = req.getSession();
        session.setAttribute("user", userDb.get());
        return "redirect:/posts/list";
    }
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/user/loginPage";
    }
}
