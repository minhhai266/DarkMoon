package com.darkfantasy.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.darkfantasy.entity.Story;

@Repository
public interface StoryRepository extends JpaRepository<Story, Long> {
    Page<Story> findAllByOrderByIdAsc(Pageable pageable);
    List<Story> findByDeletedFalseOrderByPriorityDesc();
    Story findTopByDeletedFalseOrderByPriorityDesc();
}
