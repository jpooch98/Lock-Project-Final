package com.JamesPooch.lockproject.lock;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Builder;
import java.time.LocalDate;

@Entity
public class Lock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer lockNum;
    String firstInitials;
    String secondInitials;
    LocalDate dateCreated;

    public Integer getLockNumber(){
        return lockNum;
    }

    public String getFirstInitials() {
        return firstInitials;
    }

    public void setFirstInitials(String firstInitials) {
        this.firstInitials = firstInitials;
    }

    public String getSecondInitials() {
        return secondInitials;
    }

    public void setSecondInitials(String secondInitials) {
        this.secondInitials = secondInitials;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Lock() {}

    @Builder
    public Lock(String firstInitials, String secondInitials) {
        this.firstInitials = firstInitials;
        this.secondInitials = secondInitials;
        this.dateCreated = LocalDate.now();
    }
    
    
}
