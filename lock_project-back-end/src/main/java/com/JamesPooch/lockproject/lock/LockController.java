package com.JamesPooch.lockproject.lock;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "https://master--sunny-torte-c78952.netlify.app/")
public class LockController {

    private final TestLockGeneration lockGen;

    private final LockService lockService;
    private final LockRespository respository;

    public LockController(LockService lockService, TestLockGeneration lockgen, LockRespository respository) {
        this.lockService = lockService;
        this.lockGen = lockgen;
        this.respository = respository;
        generateLocks();
    }

    public void generateLocks() {
        lockGen.generateLocks();
    }

    @GetMapping("/")
    public String test() {
        return ("This is a test");
    }

    @CrossOrigin(origins = "https://master--sunny-torte-c78952.netlify.app/")
    @GetMapping("/getlock/{lockNo}")
    public Optional<Lock> getAccountById(@PathVariable("lockNo") Integer lockNum) {
        Optional<Lock> lock = lockService.getLockById(lockNum);
        return lock;
    }

    @CrossOrigin(origins = "https://master--sunny-torte-c78952.netlify.app/")
    @GetMapping("/locks/allLocks")
    public List<Lock> getAllLocks() {
        List<Lock> allLocks = lockService.getAllLocks();
        return allLocks;
    }

    @CrossOrigin(origins = "https://master--sunny-torte-c78952.netlify.app/")
    @PostMapping("/lock/create")
    @ResponseStatus(value = HttpStatus.OK)
    public Lock createLock(@RequestBody Lock lock) {
        Lock lock1 = Lock.builder()
                .firstInitials(lock.firstInitials)
                .secondInitials(lock.secondInitials)
                .build();
        return respository.save(lock1);
    }

    @CrossOrigin(origins = "https://master--sunny-torte-c78952.netlify.app/")
    @GetMapping("/lock/numLocks")
    public Integer numLocks() {
        List<Lock> allLocks = lockService.getAllLocks();
        Integer totalLocks = allLocks.size();
        return totalLocks;
    }
}