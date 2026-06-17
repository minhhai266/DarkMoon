package com.darkfantasy.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.darkfantasy.entity.PasswordResetToken;

@Repository
public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetToken, Long> {
        Optional<PasswordResetToken> findByEmailAndOtpAndUsedFalse(String email,String otp);

        Optional<PasswordResetToken> findTopByEmailAndOtpAndUsedFalseOrderByIdDesc(String email, String otp);

        @Modifying
        @Query("""
                update PasswordResetToken t
                set t.used = true
                where t.email = :email and t.used = false
                        """)
        void invalidateAllUnusedByEmail(@Param("email") String email);
}
