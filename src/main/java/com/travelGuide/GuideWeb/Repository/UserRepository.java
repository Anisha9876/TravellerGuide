package com.travelGuide.GuideWeb.Repository;

import com.travelGuide.GuideWeb.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long> {
    UserEntity findByMail(String mail);
}
