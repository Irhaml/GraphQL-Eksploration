package com.example.graphqleksploration.repository;

import com.example.graphqleksploration.model.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.UUID;

public interface AccountRepository extends JpaRepository<Account, Integer> {
    @Query(value = "SELECT u FROM Account u WHERE u.id = ?1")
    Account findAccountByIdAndStarsProject(int Id);
}
