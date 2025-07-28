package minjae.academy.entity;

import jakarta.persistence.*;
import lombok.*;
import minjae.academy.audit.BaseTimeAndAuthorEntity;
import minjae.academy.enumValue.ApplicantStatus;


import java.util.Date;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Builder
@Entity
public class SubjectApplicant extends BaseTimeAndAuthorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(length = 36,updatable = false, nullable = false)
    private String applicantUuid;

    //신청과정
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subjectUuid")
    private Subject subject;
    //신청인 uuid, name
    private String applicant;
    private String applicantName;
    //신청상태값
    @Enumerated(EnumType.STRING)
    private ApplicantStatus status;

    //과정 반려 정보
    private String rejectPerson;
    private String rejectReason;
    private Date rejectDate;

}
