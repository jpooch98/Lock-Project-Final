package com.JamesPooch.lockproject.lock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestLockGeneration {

    @Autowired
    private LockRespository repository;

    public void generateLocks() {
        Lock lock1 = Lock.builder()
                .firstInitials("JP")
                .secondInitials("AH")
                .build();
        repository.save(lock1);

        Lock lock2 = Lock.builder()
                .firstInitials("JL")
                .secondInitials("KR")
                .build();

        repository.save(lock2);
    }
}