package com.darkfantasy.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.darkfantasy.dto.log.AuditLogResponse;
import com.darkfantasy.entity.User;
import com.darkfantasy.entity.enums.LogAction;
import com.darkfantasy.entity.enums.LogEntityType;

public interface AuditLogService {
    void log(
            LogEntityType entityType,
            Long entityId,
            LogAction action,
            String description);

    void logAuthenticated(
        User user,
        LogEntityType entityType,
        Long entityId,
        LogAction action,
        String description);

    Page<AuditLogResponse> getLogs(Pageable pageable);
}
