package minjae.academy.controller.login;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import minjae.academy.service.MemberService;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class LoginController {
    private final MemberService memberService;

    @GetMapping("/login")
    public String login() {
        return "login/login";
    }

    @PostMapping("/login")
    public String login(HttpRequest request, HttpSession session) {

        String a = request.getAttributes().get("id").toString();
        String b = request.getAttributes().get("password").toString();

        HttpSession session1 = session;

        return "redirect:/";
    }
}
