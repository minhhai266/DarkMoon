package com.darkfantasy.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.darkfantasy.entity.ContactMessage;

@Repository
public interface ContactMessageRepository extends JpaRepository<ContactMessage, Long> {
    Page<ContactMessage> findByProcessedFalse(Pageable pageable);
    Page<ContactMessage> findByProcessedTrue(Pageable pageable);
    Long countByProcessedFalse();
}
