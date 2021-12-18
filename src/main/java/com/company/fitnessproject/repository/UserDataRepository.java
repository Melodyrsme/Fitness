package com.company.fitnessproject.repository;

import com.company.fitnessproject.entity.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDataRepository extends JpaRepository<UserData, Long> {
    @Query(nativeQuery = true, value = "select ud.id from user_data ud \n" +
            "join users u on ud.user_id = u.id\n" +
            "where u.login = :login")

    Long getByUserData(String login);
}
