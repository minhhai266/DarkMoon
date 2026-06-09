package com.darkfantasy.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.darkfantasy.dto.log.AuditLogResponse;
import com.darkfantasy.entity.AuditLog;
import com.darkfantasy.entity.User;
import com.darkfantasy.entity.enums.LogAction;
import com.darkfantasy.entity.enums.LogEntityType;
import com.darkfantasy.repository.AuditLogRepository;
import com.darkfantasy.repository.UserRepository;
import com.darkfantasy.service.AuditLogService;
import com.darkfantasy.util.SecurityUtil;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuditLogServiceImpl implements AuditLogService {

    private final AuditLogRepository auditLogRepository;
    private final UserRepository userRepository;

    @Transactional
    @Override
    public void log(
            LogEntityType entityType,
            Long entityId,
            LogAction action,
            String description) {

        String username = SecurityUtil.getCurrentUserName();

        if (username == null) {
            return;
        }

        User currentUser = userRepository
                .findUserByUsername(username)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Không tìm thấy người dùng"));

        AuditLog log = AuditLog.builder()
                .user(currentUser)
                .entityType(entityType)
                .entityId(entityId)
                .action(action)
                .description(description)
                .build();

        auditLogRepository.save(log);
    }

    @Override
    public Page<AuditLogResponse> getLogs(Pageable pageable) {
        return auditLogRepository
                .findAll(pageable)
                .map(AuditLogResponse::fromEntity);
    }

}
