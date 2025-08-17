package minjae.academy.restController;

import lombok.RequiredArgsConstructor;
import minjae.academy.service.MemberService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/members")
public class MemberJoinRestController {
    public final MemberService memberService;

    @GetMapping("loginId")
    public Map<String, Object> getMemberByLoginId(@RequestParam String loginId) {
        String v = loginId == null ? "" : loginId.trim();
        boolean available = !v.isEmpty() && !memberService.existsByLoginId(v);
        System.out.println(loginId);
        System.out.println(v);
        System.out.println(memberService.existsByLoginId(v));
        return Map.of(
                "available", available,
                "message", available ? "사용 가능한 아이디입니다." : "이미 사용 중인 아이디입니다."
        );
    }
}
