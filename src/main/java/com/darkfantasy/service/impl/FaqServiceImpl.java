package com.darkfantasy.service.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.darkfantasy.dto.faq.CreateFaqRequest;
import com.darkfantasy.dto.faq.UpdateFaqRequest;
import com.darkfantasy.entity.Faq;
import com.darkfantasy.entity.User;
import com.darkfantasy.entity.enums.LogAction;
import com.darkfantasy.entity.enums.LogEntityType;
import com.darkfantasy.dto.faq.FaqResponse;
import com.darkfantasy.repository.FaqRepository;
import com.darkfantasy.repository.UserRepository;
import com.darkfantasy.service.AuditLogService;
import com.darkfantasy.service.FaqService;
import com.darkfantasy.util.SecurityUtil;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FaqServiceImpl implements FaqService {
    private final FaqRepository faqRepository;
    private final UserRepository userRepository;
    private final AuditLogService auditLogService;

    @Override
    public Page<FaqResponse> getFaqs(Pageable pageable) {
        return faqRepository
                .findAllByOrderByIdAsc(pageable)
                .map(FaqResponse::fromEntity);
    }

    @Override
    public FaqResponse getFaqById(Long id) {
        return FaqResponse.fromEntity(findFaq(id));
    }

    @Transactional
    @Override
    public FaqResponse createFaq(CreateFaqRequest request) {
        if (request == null) {
            throw new IllegalArgumentException(
                    "Không thể tạo faq với dữ liệu null");
        }

        Faq faq = request.toEntity();
        faq.setCreatedBy(getCurrentUser());
        Faq savedFaq = faqRepository.save(faq);
        auditLogService.log(
                LogEntityType.FAQ,
                savedFaq.getId(),
                LogAction.CREATE,
                "Tạo FAQ: " + savedFaq.getTitle());
        return FaqResponse.fromEntity(faq);
    }

    @Transactional
    @Override
    public FaqResponse updateFaq(UpdateFaqRequest request) {
        if (request == null) {
            throw new IllegalArgumentException(
                    "Không thể thay đổi faq với dữ liệu null");
        }
        Faq faq = findFaq(request.getId());
        faq.setTitle(request.getTitle());
        faq.setContent(request.getContent());
        faq.setPriority(request.getPriority());
        faq.setUpdatedBy(getCurrentUser());
        auditLogService.log(
                LogEntityType.FAQ,
                faq.getId(),
                LogAction.UPDATE,
                "Sửa FAQ: " + faq.getTitle());
        return FaqResponse.fromEntity(faq);
    }

    @Transactional
    @Override
    public void deleteFaq(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Không thể xóa faq với ID null");
        }
        Faq found = findFaq(id);
        found.setDeleted(true);
        found.setUpdatedBy(getCurrentUser());
        auditLogService.log(
                LogEntityType.FAQ,
                found.getId(),
                LogAction.DELETE,
                "Xóa FAQ: " + found.getTitle());
    }

    @Transactional
    @Override
    public void restoreFaq(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Không thể khôi phục faq với ID null");
        }
        Faq found = findFaq(id);
        found.setDeleted(false);
        found.setUpdatedBy(getCurrentUser());
        auditLogService.log(
                LogEntityType.FAQ,
                found.getId(),
                LogAction.RESTORE,
                "Khôi phục FAQ: " + found.getTitle());
    }

    @Override
    public List<FaqResponse> getFaqsDeletedFalse() {
        return faqRepository
                .findByDeletedFalseOrderByPriorityDesc()
                .stream()
                .map(FaqResponse::fromEntity)
                .toList();
    }

    private Faq findFaq(Long id) {
        return faqRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy faq với ID: " + id));
    }

    @Override
    public long count() {
        return faqRepository.count();
    }

    private User getCurrentUser() {

        String currentUsername = SecurityUtil.getCurrentUserName();

        if (currentUsername == null) {
            throw new IllegalStateException("Không tìm thấy người dùng hiện tại");
        }

        return userRepository
                .findUserByUsername(currentUsername)
                .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy người dùng"));
    }

}
