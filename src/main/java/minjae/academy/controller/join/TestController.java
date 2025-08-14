package minjae.academy.controller.join;

import lombok.RequiredArgsConstructor;
import minjae.academy.dto.MemberJoinDTO;
import minjae.academy.entity.Member;
import minjae.academy.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/join")
@SessionAttributes("memberDto")
@RequiredArgsConstructor
public class TestController {
    private final MemberService memberService;

    @ModelAttribute("memberDto")
    public MemberJoinDTO memberJoin() {
        return new MemberJoinDTO();
    }


    @GetMapping("/term")
    public String term(@ModelAttribute("memberDto") MemberJoinDTO dto) {
        return "join/term";
    }

    @PostMapping("/term")
    public String termSubmit(@ModelAttribute("memberDto") MemberJoinDTO dto,BindingResult errors) {
        if (errors.hasErrors()) return "join/term";
        return "redirect:/join/join";
    }

    @GetMapping("/join")
    public String join(@ModelAttribute("memberDto") MemberJoinDTO dto) {
        return "join/join";
    }

    @PostMapping("/join")
    public String joinSubmit(@ModelAttribute("memberDto") MemberJoinDTO dto,BindingResult br) {
        Member member = new Member();
//        member.setName(dto.getName());
//        member.setNickname(dto.getNickname());
//        member.setId(dto.getId());
//        member.setPassword(dto.getPassword()); // 실제로는 반드시 BCrypt 암호화 필요
//        member.setEmail(dto.getEmail());
//        member.setPhone(dto.getPhone());
//        member.setBirthday(java.sql.Date.valueOf(dto.getBirthday()));
//        member.setGender(dto.getGender());
//        member.setAddress(dto.getAddress());
//        member.setAddress_details(dto.getAddress_details());
//
//        member.setEmailSubscribe(dto.getEmailSubscribe());
//        member.setSmsSubscribe(dto.getSmsSubscribe());
        member.setThirdSubscribe(dto.getThirdSubscribe());
        member.setTermPersonal(dto.getTermPersonal());
        member.setTermService(dto.getTermService());

        memberService.save(member);
        return "redirect:/join/success";
    }

    @GetMapping("/success")
    public String success(@ModelAttribute("memberDto") MemberJoinDTO dto) {
        return "/join/success";
    }

}
