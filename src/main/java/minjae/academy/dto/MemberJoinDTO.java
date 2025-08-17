package minjae.academy.dto;

import jakarta.validation.constraints.AssertTrue;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import minjae.academy.enums.Gender;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberJoinDTO {
    private String name;
    private String loginId;
    private String password;
    private String email;
    private String phone;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;
    private Gender gender;

    private String address;
    private String addressDetail;

    private Boolean emailSubscribe;
    private Boolean smsSubscribe;


    @AssertTrue(message = "필수 약관(서비스, 개인정보)에 모두 동의해야 합니다.")
    private Boolean termService;
    @AssertTrue(message = "필수 약관(서비스, 개인정보)에 모두 동의해야 합니다.")
    private Boolean termPersonal;
    private Boolean thirdSubscribe;



}
