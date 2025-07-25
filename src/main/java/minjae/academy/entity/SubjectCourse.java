package minjae.academy.entity;

import jakarta.persistence.*;
import lombok.*;
import minjae.academy.audit.BaseTimeAndAuthorEntity;

import java.util.Date;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Builder
@Entity
public class SubjectCourse extends BaseTimeAndAuthorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(length = 36,updatable = false, nullable = false)
    private String uuid;

    //과정 uuid
    private String subject;

    //커리큘럼 이름,설명,영상주소
    private String name;
    @Column(nullable = false)
    private String description;
    private String location;

    //영상 링크
    private String video;


}
