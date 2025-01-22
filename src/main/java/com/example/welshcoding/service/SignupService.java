package com.example.welshcoding.service;

import com.example.welshcoding.repository.SignupRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.welshcoding.domain.Member;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SignupService {
    private final SignupRepository signupRepository;

    @Transactional
    public void join(Member member) {
        signupRepository.save(member);
    }

    public String dubcheck(String email) {
        return signupRepository.findEmail(email);
    }
}
