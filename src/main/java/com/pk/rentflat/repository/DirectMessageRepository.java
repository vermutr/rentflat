package com.pk.rentflat.repository;


import com.pk.rentflat.model.DirectMessage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DirectMessageRepository extends JpaRepository<DirectMessage, Integer> {

    Optional<DirectMessage> findByEmail(String email);
}
