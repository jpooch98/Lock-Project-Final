package com.JamesPooch.lockproject.lock;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LockService {
    @Autowired
    private LockRespository lockRespository;

    public Optional<Lock> getLockById(Integer lockNum){
        return lockRespository.findById(lockNum);
    }

    public List<Lock> getAllLocks(){
        return lockRespository.findAll();
    }
}
