package minjae.academy.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import minjae.academy.audit.BaseTimeAndAuthorEntity;

@Entity
public class Video extends BaseTimeAndAuthorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String uuid;

    //제목,설명,제작자
    private String title;
    private String description;
    private String author;

    //영상 사이즈
    private Long size;
    //영상 경로,섬네일 경로, 영상길이
    private String videoUrl;
    private String thumbnailUrl;
    private Long duration;


}
