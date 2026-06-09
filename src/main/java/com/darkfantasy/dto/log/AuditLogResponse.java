package com.darkfantasy.dto.log;

import java.time.Instant;

import com.darkfantasy.entity.AuditLog;
import com.darkfantasy.entity.enums.LogAction;
import com.darkfantasy.entity.enums.LogEntityType;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuditLogResponse {
    private Long id;

    private String username;

    private LogEntityType entityType;

    private Long entityId;

    private LogAction action;

    private String description;

    private Instant createdAt;

    public static AuditLogResponse fromEntity(
            AuditLog auditLog) {

        return AuditLogResponse.builder()
                .id(auditLog.getId())
                .username(
                        auditLog.getUser().getUsername())
                .entityType(
                        auditLog.getEntityType())
                .entityId(
                        auditLog.getEntityId())
                .action(
                        auditLog.getAction())
                .description(
                        auditLog.getDescription())
                .createdAt(
                        auditLog.getCreatedAt())
                .build();
    }
}
