package minjae.academy.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import minjae.academy.audit.BaseTimeAndAuthorEntity;
import minjae.academy.enumValue.Gender;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User extends BaseTimeAndAuthorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(length = 36,updatable = false, nullable = false)
    private String uuid;

    // 개인정보
    private String name;
    private String id;
    private String password;
    private String email;
    private String phone;
    private Date birthday;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String address;

    //로그인 카운트 5회 이상이면 로그인 못하도록 하는 컬럼
    private int loginCount;

    //정보수신동의 및 이메일,sms 수신동의
    private Boolean emailSubscribe;
    private Boolean smsSubscribe;
    private Boolean thirdSubscribe;

    private boolean deleted;
    private Date deletedDate;
    private String deletedBy;
}
