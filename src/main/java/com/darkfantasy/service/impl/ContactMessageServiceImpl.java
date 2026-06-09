package com.darkfantasy.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.darkfantasy.dto.contact.ContactMessageResponse;
import com.darkfantasy.dto.contact.CreateContactMessageRequest;
import com.darkfantasy.entity.ContactMessage;
import com.darkfantasy.entity.enums.LogAction;
import com.darkfantasy.entity.enums.LogEntityType;
import com.darkfantasy.repository.ContactMessageRepository;
import com.darkfantasy.service.AuditLogService;
import com.darkfantasy.service.ContactMessageService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ContactMessageServiceImpl implements ContactMessageService {
    private final ContactMessageRepository contactMessageRepository;
    private final AuditLogService auditLogService;

    @Transactional
    @Override
    public ContactMessageResponse createMessage(CreateContactMessageRequest request) {
        if (request == null) {
            throw new IllegalArgumentException("Không thể tạo tin nhắn liên hệ với dữ liệu null");
        }

        ContactMessage message = request.toEntity();
        ContactMessage savedMessage = contactMessageRepository.save(message);

        auditLogService.log(
                LogEntityType.CONTACT,
                savedMessage.getId(),
                LogAction.CREATE,
                "Tạo liên hệ: " + savedMessage.getMessage());
        return ContactMessageResponse.fromEntity(savedMessage);
    }

    @Override
    public Page<ContactMessageResponse> getMessages(Pageable pageable) {
        if (pageable == null) {
            throw new IllegalArgumentException("Pageable không được null");
        }

        return contactMessageRepository
                .findAll(pageable)
                .map(ContactMessageResponse::fromEntity);
    }

    @Override
    public ContactMessageResponse getMessageById(Long id) {
        return ContactMessageResponse.fromEntity(findContactMessage(id));
    }

    @Transactional
    @Override
    public void markAsProcessed(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Không thể đánh dấu đã xử lý với ID null");
        }

        ContactMessage message = findContactMessage(id);
        message.setProcessed(true);
        auditLogService.log(
                LogEntityType.CONTACT,
                message.getId(),
                LogAction.PROCESS,
                "Đánh dấu đã xử lý: " + message.getMessage());
    }

    @Transactional
    @Override
    public void markAsUnprocessed(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Không thể đánh dấu chưa xử lý với ID null");
        }

        ContactMessage message = findContactMessage(id);
        message.setProcessed(false);
    }

    private ContactMessage findContactMessage(Long id) {
        return contactMessageRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy tin nhắn liên hệ với ID: " + id));
    }

    @Override
    public long countByProcessedFalse() {
        return contactMessageRepository.countByProcessedFalse();
    }
}
