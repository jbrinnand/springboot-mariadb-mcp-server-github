package com.ct.springboot_mariadb.model;

import jakarta.persistence.Table;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Table(name = "account")
public interface AccountRepository extends JpaRepository<Account, Long> {
}