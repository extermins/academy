package minjae.academy.entity;

import jakarta.persistence.*;
import lombok.*;
import minjae.academy.audit.BaseTimeAndAuthorEntity;
import minjae.academy.enumValue.SubjectType;

import java.util.Date;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Builder
@Entity
public class Subject extends BaseTimeAndAuthorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(length = 36,updatable = false, nullable = false)
    private String subjectUuid;
    private String name;
    private String description;

    //과정분류(대,중,소)
    private String classification1;
    private String classification2;
    private String classification3;

    //과정시간
    private Integer hour;
    //과정시작기간 및 종료 기간
    private Date startDate;
    private Date endDate;
    //과정오픈여부
    private Boolean opened;
    //과정 유무료 여부
    private Boolean charge;
    //과정 가격
    private Integer price;
    //과정타입
    @Enumerated(EnumType.STRING)
    private SubjectType type;
    //신청인원제한수
    private Integer count;
    //과정 담당자
    private String manager;


}
