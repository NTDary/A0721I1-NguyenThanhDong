package com.casestudy.repository.user;

import com.casestudy.model.service.Service;
import com.casestudy.model.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
    @Query(value="SELECT * FROM user u WHERE u.username = ?1",
            nativeQuery=true)
    User findByName(String username);

    @Query(value="SELECT * FROM user u WHERE u.username = ?1 and u.password = ?2",
            nativeQuery=true)
    User findByNameEmployee(String username,String password);
//    @Query(value="SELECT u.id FROM user u WHERE u.username = ?1",
//            nativeQuery=true)
//    Integer getUserIdByName(String username);
//
////    Boolean existsUsersByName(String username);
}
