package com.darkfantasy.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.darkfantasy.entity.PasswordResetToken;

@Repository
public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetToken, Long> {
    Optional<PasswordResetToken> findByEmailAndOtpAndUsedFalse(
            String email,
            String otp);

    Optional<PasswordResetToken> findTopByEmailAndOtpAndUsedFalseOrderByIdDesc(
            String email,
            String otp);
}
