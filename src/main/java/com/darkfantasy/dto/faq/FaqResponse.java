package com.darkfantasy.dto.faq;

import com.darkfantasy.entity.Faq;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FaqResponse {
    private Long id;
    private String title;
    private String content;
    private Integer priority;
    private boolean deleted;

    public static FaqResponse fromEntity(Faq faq) {
        return FaqResponse.builder()
                .id(faq.getId())
                .title(faq.getTitle())
                .content(faq.getContent())
                .priority(faq.getPriority())
                .deleted(faq.isDeleted())
                .build();
    }
}
