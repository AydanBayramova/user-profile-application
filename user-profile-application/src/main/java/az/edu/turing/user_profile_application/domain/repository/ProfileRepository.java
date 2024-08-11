package az.edu.turing.user_profile_application.domain.repository;//package com.boot.usermanagementsystem.domain.repository;


import az.edu.turing.user_profile_application.domain.entity.ProfileEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileRepository extends JpaRepository<ProfileEntity, Long> {

    Page<ProfileEntity> findAll(Pageable pageable);
}
