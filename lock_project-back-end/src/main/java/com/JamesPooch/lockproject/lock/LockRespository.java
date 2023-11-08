package com.JamesPooch.lockproject.lock;
import org.springframework.data.jpa.repository.JpaRepository;


public interface LockRespository extends JpaRepository<Lock, Integer> {
    
}
