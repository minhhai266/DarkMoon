package com.darkfantasy.dto.contributor;

import com.darkfantasy.entity.Contributor;
import com.darkfantasy.util.TimeUtil;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ContributorResponse {
    private Long id;
    private String name;
    private String position;
    private String avatar;
    private Integer priority;
    private boolean deleted;
    private String createdByUserName;
    private String createdAt;
    private String updatedByUserName;
    private String updatedAt;

    public static ContributorResponse fromEntity(Contributor contributor) {
        return ContributorResponse.builder()
                .id(contributor.getId())
                .name(contributor.getName())
                .position(contributor.getPosition())
                .avatar(contributor.getAvatar())
                .priority(contributor.getPriority())
                .deleted(contributor.isDeleted())
                .createdByUserName(contributor.getCreatedBy() != null ? contributor.getCreatedBy().getUsername() : null)
                .createdAt(TimeUtil.formatInstant(contributor.getCreatedAt()))
                .updatedByUserName(contributor.getUpdatedBy() != null ? contributor.getUpdatedBy().getUsername() : null)
                .updatedAt(TimeUtil.formatInstant(contributor.getUpdatedAt()))
                .build();
    }
}
