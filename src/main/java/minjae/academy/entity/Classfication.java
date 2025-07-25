package minjae.academy.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import minjae.academy.audit.BaseTimeAndAuthorEntity;


@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Entity
public class Classfication extends BaseTimeAndAuthorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(length = 36,updatable = false, nullable = false)
    private String uuid;

    private String name;
    private Integer depth;
    private Integer year;

    @Column(length = 36)
    private String parentUuid;


}
