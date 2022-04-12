package com.casestudy.repository.user;

import com.casestudy.model.user.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoleRepository extends JpaRepository<Role,Long> {
    @Query(value= "select r.role_name from role r where r.role_name = ?1",
            nativeQuery= true)
    Role findByName(String roleName);

}
