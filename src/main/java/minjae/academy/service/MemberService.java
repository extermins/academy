package minjae.academy.service;

import lombok.RequiredArgsConstructor;
import minjae.academy.entity.Member;
import minjae.academy.repository.MemberJpaRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberJpaRepository memberJpaRepository;

    public void save(Member member) {
        memberJpaRepository.save(member);
    }
}
