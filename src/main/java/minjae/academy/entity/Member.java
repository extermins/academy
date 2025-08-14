package minjae.academy.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import minjae.academy.baseEntity.BaseEntity;
import minjae.academy.enums.Gender;
import minjae.academy.enums.MemberRole;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(length = 36,updatable = false, nullable = false)
    private String userUuid;

    // 개인정보
    private String name;
    private String id;
    private String password;
    private String email;
    private String phone;
    private Date birthday;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Enumerated(EnumType.STRING)
    private MemberRole role;

    private String address;
    private String addressDetail;

    //로그인 카운트 5회 이상이면 로그인 못하도록 하는 컬럼
    private int loginCount;

    //정보수신동의 및 이메일,sms 수신동의
    private Boolean emailSubscribe;
    private Boolean smsSubscribe;

    //약관동의
    private Boolean termService;
    private Boolean termPersonal;
    private Boolean thirdSubscribe;

    private boolean deleted;
    private Date deletedDate;
    private String deletedBy;
}
