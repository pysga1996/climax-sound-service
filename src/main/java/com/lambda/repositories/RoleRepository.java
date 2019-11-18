package com.lambda.repositories;

import com.lambda.models.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    @Query("SELECT r FROM Role r INNER JOIN FETCH r.privileges WHERE r.id = :id")
    Optional<Role> findById(@Param("id") Integer id);

//    @Query(value = "SELECT * FROM role WHERE BINARY title=:title", nativeQuery = true)
    Role findByName(String name);
}