package com.darkfantasy.service.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.darkfantasy.dto.contributor.ContributorResponse;
import com.darkfantasy.dto.contributor.CreateContributorRequest;
import com.darkfantasy.dto.contributor.UpdateContributorRequest;
import com.darkfantasy.entity.Contributor;
import com.darkfantasy.entity.User;
import com.darkfantasy.entity.enums.LogAction;
import com.darkfantasy.entity.enums.LogEntityType;
import com.darkfantasy.exception.custom.ResourceNotFoundException;
import com.darkfantasy.repository.ContributorRepository;
import com.darkfantasy.repository.UserRepository;
import com.darkfantasy.service.ContributorService;
import com.darkfantasy.service.AuditLogService;
import com.darkfantasy.util.SecurityUtil;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ContributorServiceImpl implements ContributorService {
    private final UserRepository userRepository;
    private final ContributorRepository contributorRepository;
    private final AuditLogService auditLogService;

    @Override
    public ContributorResponse getContributorById(Long id) {
        return ContributorResponse.fromEntity(findContributor(id));
    }

    @Transactional
    @Override
    public ContributorResponse createContributor(CreateContributorRequest request) {
        if (request == null) {
            throw new IllegalArgumentException("Không thể tạo người đóng góp với dữ liệu null");
        }
        User currentUser = getCurrentUser();
        Contributor contributor = request.toEntity();
        contributor.setCreatedBy(currentUser);
        Contributor savedContributor = contributorRepository.save(contributor);
        auditLogService.log(
                LogEntityType.CONTRIBUTOR,
                savedContributor.getId(),
                LogAction.CREATE,
                "Tạo người đóng góp: " + savedContributor.getName());
        return ContributorResponse.fromEntity(savedContributor);
    }

    @Transactional
    @Override
    public ContributorResponse updateContributor(UpdateContributorRequest request) {

        Contributor contributor = findContributor(request.getId());

        String currentUsername = SecurityUtil.getCurrentUserName();

        if (currentUsername == null) {
            throw new IllegalStateException("Không tìm thấy người dùng hiện tại");
        }

        User currentUser = getCurrentUser();

        contributor.setName(request.getName());
        contributor.setPosition(request.getPosition());
        contributor.setPriority(request.getPriority());

        if (request.getAvatar() != null) {
            contributor.setAvatar(request.getAvatar());
        }

        contributor.setUpdatedBy(currentUser);
        auditLogService.log(
                LogEntityType.CONTRIBUTOR,
                contributor.getId(),
                LogAction.UPDATE,
                "Sửa người đóng góp: " + contributor.getName());
        return ContributorResponse.fromEntity(contributor);
    }

    @Transactional
    @Override
    public void deleteContributor(Long contributorId) {
        User currentUser = getCurrentUser();
        if (contributorId == null) {
            throw new IllegalArgumentException("Không thể xóa người đóng góp với ID null");
        }
        Contributor contributor = findContributor(contributorId);
        contributor.setDeleted(true);
        contributor.setUpdatedBy(currentUser);
        auditLogService.log(
                LogEntityType.CONTRIBUTOR,
                contributor.getId(),
                LogAction.DELETE,
                "Xóa người đóng góp: " + contributor.getName());
    }

    @Override
    public Page<ContributorResponse> getContributorsDeletedFalse(Pageable pageable) {
        return contributorRepository.findByDeletedFalseOrderByPriorityDesc(pageable)
                .map(ContributorResponse::fromEntity);
    }

    @Override
    public Page<ContributorResponse> getContributors(Pageable pageable) {
        if (pageable == null) {
            throw new IllegalArgumentException("Pageable không được null");
        }
        return contributorRepository.findAll(pageable).map(ContributorResponse::fromEntity);
    }

    @Transactional
    @Override
    public void restoreContributor(Long contributorId) {
        User currentUser = getCurrentUser();
        if (contributorId == null) {
            throw new IllegalArgumentException("Không thể khôi phục người đóng góp với ID null");
        }
        Contributor contributor = findContributor(contributorId);
        contributor.setDeleted(false);
        contributor.setUpdatedBy(currentUser);
        auditLogService.log(
                LogEntityType.CONTRIBUTOR,
                contributor.getId(),
                LogAction.RESTORE,
                "Khôi phục người đóng góp: " + contributor.getName());
    }

    @Override
    public long count() {
        return contributorRepository.count();
    }

    private Contributor findContributor(Long id) {
        return contributorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy người đóng góp với ID: " + id));
    }

    private User getCurrentUser() {

        String currentUsername = SecurityUtil.getCurrentUserName();

        if (currentUsername == null) {
            throw new IllegalStateException("Không tìm thấy người dùng hiện tại");
        }

        return userRepository.findUserByUsername(currentUsername)
                .orElseThrow(() -> new ResourceNotFoundException("Không tìm thấy người dùng"));
    }
}
