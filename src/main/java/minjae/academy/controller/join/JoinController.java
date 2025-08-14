//package minjae.academy.controller.join;
//
//import jakarta.validation.Valid;
//import lombok.RequiredArgsConstructor;
//import minjae.academy.dto.MemberJoinDTO;
//import minjae.academy.entity.Member;
//import minjae.academy.repository.MemberJpaRepository;
//import minjae.academy.service.MemberService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.*;
//
//@Controller
//@RequestMapping("/join")
//@SessionAttributes("memberJoin")
//public class JoinController {
//
//    @Autowired
//    private MemberService memberService;
//
//    @ModelAttribute("memberJoin")
//    public MemberJoinDTO memberJoinDTO() {
//        return new MemberJoinDTO();
//    }
//
//    @GetMapping("/term")
//    public String term(@ModelAttribute("memberJoin") MemberJoinDTO dto) {
//        return "join/term";
//    }
//
//    @PostMapping("/term")
//    public String join(@Valid @ModelAttribute("memberJoin") MemberJoinDTO dto,BindingResult br) {
//        if (br.hasErrors()) { // isAgreeTerms() 검증 포함
//            return "join/term";
//        }
//        return "redirect:/join/join";
//    }
//
//    @GetMapping("/join")
//    public String joinForm(@ModelAttribute("memberJoin")  MemberJoinDTO dto) {
////        model.addAttribute("memberJoin", new MemberJoinDTO()); // HTML 이름과 일치
//        return "join/join";
//    }
//
//
//
//
//    @GetMapping("/success")
//    public String success(){
//        return "join/success";
//    }
//
//
//
//    @PostMapping("/join")
//    public String join(@ModelAttribute MemberJoinDTO memberJoinDTO) {
//        Member member = new Member();
//        member.setName(memberJoinDTO.getName());
//        member.setNickname(memberJoinDTO.getNickname());
//        member.setId(memberJoinDTO.getId());
//        member.setPassword(memberJoinDTO.getPassword()); // 실제로는 반드시 BCrypt 암호화 필요
//        member.setEmail(memberJoinDTO.getEmail());
//        member.setPhone(memberJoinDTO.getPhone());
//        member.setBirthday(java.sql.Date.valueOf(memberJoinDTO.getBirthday()));
//        member.setGender(memberJoinDTO.getGender());
//        member.setAddress(memberJoinDTO.getAddress());
//        member.setAddress_details(memberJoinDTO.getAddress_details());
//
//        member.setEmailSubscribe(memberJoinDTO.getEmailSubscribe());
//        member.setSmsSubscribe(memberJoinDTO.getSmsSubscribe());
//        member.setThirdSubscribe(memberJoinDTO.getThirdSubscribe());
//        member.setTermPersonal(memberJoinDTO.getTermPersonal());
//        member.setTermService(memberJoinDTO.getTermService());
//
//        memberService.save(member);
//
//        return "redirect:/join/success";
//    }
//}
