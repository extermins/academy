package minjae.academy.repository;

import minjae.academy.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberJpaRepository extends JpaRepository<Member, String> {

}
