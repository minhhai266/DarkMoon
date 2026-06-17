package com.darkfantasy.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.darkfantasy.entity.World;

@Repository
public interface WorldRepository extends JpaRepository<World, Long> {
    Page<World> findAllByOrderByIdAsc(Pageable pageable);
    List<World> findByDeletedFalseOrderByPriorityDesc();
    World findTopByDeletedFalseOrderByPriorityDesc();
}
