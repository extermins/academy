package minjae.academy.controller.admin;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AdminController {
    @GetMapping("/admin")
    public String admin(HttpSession session) {
//        if(session.getAttribute("member") == null) {
//            return "redirect:/login";
//        }
        return "admin/admin";
    }
}
