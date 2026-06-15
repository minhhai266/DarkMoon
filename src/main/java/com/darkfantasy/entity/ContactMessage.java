package com.darkfantasy.entity;

import java.time.Instant;

import org.hibernate.annotations.UpdateTimestamp;

import com.darkfantasy.entity.enums.ContactCategory;
import com.darkfantasy.entity.enums.ContactPlatform;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "contact_messages")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ContactMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "visitor_name", nullable = false)
    private String visitorName;
    @Column(name = "visitor_email", nullable = false)
    private String visitorEmail;
    @Column(name = "category", nullable = false)
    private ContactCategory category;
    @Column(name = "platform", nullable = true)
    private ContactPlatform platform;
    @Column(columnDefinition = "LONGTEXT", nullable = false)
    private String message;
    @Builder.Default
    @Column(name = "processed")
    private boolean processed = false;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "processed_by", nullable = true)
    private User processedBy;

    @UpdateTimestamp
    @Column(name = "processed_at", nullable = true)
    private Instant processedAt;
}
