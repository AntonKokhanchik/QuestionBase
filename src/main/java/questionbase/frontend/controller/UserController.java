package questionbase.frontend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import questionbase.backend.service.UserService;
import questionbase.frontend.dto.User;

@Controller
@RequestMapping(value = {"/user"})
@SessionAttributes("sessionUser")
public class UserController {
    @Autowired
    UserService userService;

    // GET

    @GetMapping(value="/show/{login}")
    public String getShow(@PathVariable("login") String login, Model model) {
        model.addAttribute("user", userService.find(login));
        model.addAttribute("comments", userService.findCommentsByUserLogin(login));
        return  "user/show";
    }

    @GetMapping(value="/new")
    public String getNew(Model model) {
        model.addAttribute("user", new User());
        return "user/new";
    }

    @GetMapping(value="/update/{login}")
    public String getUpdate(@PathVariable("login") String login, Model model) {
        model.addAttribute("user", userService.find(login));
        return "user/update";
    }

    // POST

    @PostMapping(value="/new")
    public String postNew(
            @RequestParam String login,
            @RequestParam String password,
            @RequestParam String fullName) {
        userService.create(new User(login, password, fullName));

        return "redirect:/";
    }

    @PostMapping(value="/update")
    public String postUpdate(
            @RequestParam String login,
            @RequestParam String password,
            @RequestParam String fullName) {
        User user = userService.find(login);
        user.setPassword(password);
        user.setFullName(fullName);
        userService.update(user);

        return "redirect:/";
    }

    @PostMapping(value="/login")
    public String login(
            @RequestParam String login,
            @RequestParam String password,
            Model model) {
        User user = new User(login, password);
        try {
            user = userService.verify(user);
            model.addAttribute("sessionUser", user);
            return "redirect:/";
        } catch (Exception e) {
            // TODO: временно
            return "redirect:/error";
        }
    }

    @PostMapping(value="/logout")
    public String logout(SessionStatus sessionStatus) {
        sessionStatus.setComplete();
        return "redirect:/";
    }

    @PostMapping(value="/delete/{login}")
    String postDelete (@PathVariable("login") String login) {
        userService.delete(login);

        return "redirect:/";
    }
}
