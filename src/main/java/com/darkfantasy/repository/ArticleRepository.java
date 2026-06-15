package com.darkfantasy.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.darkfantasy.entity.Article;
import com.darkfantasy.entity.enums.ArticleType;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {

        Page<Article> findByDeletedFalseOrderByCreatedAtDesc(
                        Pageable pageable);

        Optional<Article> findFirstByTypeAndDeletedFalseOrderByCreatedAtDesc(
                        ArticleType type);

        Optional<Article> findByIdAndDeletedFalse(Long id);
}
