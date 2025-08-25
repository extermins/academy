package minjae.academy.controller.join;

import lombok.RequiredArgsConstructor;
import minjae.academy.dto.MemberJoinDTO;
import minjae.academy.entity.Member;
import minjae.academy.enums.MemberRole;
import minjae.academy.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;


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


    @GetMapping("/step1")
    public String term(@ModelAttribute("memberDto") MemberJoinDTO dto) {
        return "join/term";
    }

    @PostMapping("/step1")
    public String termSubmit(@ModelAttribute("memberDto") MemberJoinDTO dto,BindingResult errors) {
        if (errors.hasErrors()) return "join/term";
        return "redirect:/join/step2";
    }

    @GetMapping("/step2")
    public String join(@ModelAttribute("memberDto") MemberJoinDTO dto) {
        return "join/join";
    }

    @PostMapping("/step2")
    public String joinSubmit(@ModelAttribute("memberDto") MemberJoinDTO dto,BindingResult br) {
        Member member = new Member();
        member.setName(dto.getName());
        member.setLoginId(dto.getLoginId());
        member.setPassword(dto.getPassword()); // 실제로는 반드시 BCrypt 암호화 필요 ---> 나중에 합시다
        member.setEmail(dto.getEmail());
        member.setPhone(dto.getPhone());
        member.setBirthday(java.sql.Date.valueOf(dto.getBirthday()));
        member.setGender(dto.getGender());
        member.setAddress(dto.getAddress());
        member.setAddressDetail(dto.getAddressDetail());
//
        member.setRole(MemberRole.USER);
        member.setEmailSubscribe(dto.getEmailSubscribe());
        member.setSmsSubscribe(dto.getSmsSubscribe());
        member.setThirdSubscribe(dto.getThirdSubscribe());
        member.setTermPersonal(dto.getTermPersonal());
        member.setTermService(dto.getTermService());


        System.out.println(dto.getThirdSubscribe());
        System.out.println(dto.getTermPersonal());
        System.out.println(dto.getTermService());

        memberService.save(member);
        return "redirect:/join/step3";
    }

    @GetMapping("/step3")
    public String success(@ModelAttribute("memberDto") MemberJoinDTO dto, SessionStatus status) {
        status.setComplete();

        return "/join/success";
    }

}
