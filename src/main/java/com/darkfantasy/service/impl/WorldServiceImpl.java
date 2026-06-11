package com.darkfantasy.service.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.darkfantasy.dto.world.CreateWorldRequest;
import com.darkfantasy.dto.world.UpdateWorldRequest;
import com.darkfantasy.dto.world.WorldResponse;
import com.darkfantasy.entity.User;
import com.darkfantasy.entity.World;
import com.darkfantasy.entity.enums.LogAction;
import com.darkfantasy.entity.enums.LogEntityType;
import com.darkfantasy.repository.UserRepository;
import com.darkfantasy.repository.WorldRepository;
import com.darkfantasy.service.AuditLogService;
import com.darkfantasy.service.WorldService;
import com.darkfantasy.util.SecurityUtil;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class WorldServiceImpl implements WorldService {

    private final WorldRepository worldRepository;
    private final UserRepository userRepository;
    private final AuditLogService auditLogService;

    @Override
    public Page<WorldResponse> getWorlds(Pageable pageable) {
        return worldRepository
                .findAllByOrderByIdAsc(pageable)
                .map(WorldResponse::fromEntity);
    }

    @Override
    public WorldResponse getWorldById(Long id) {
        return WorldResponse.fromEntity(findWorld(id));
    }

    @Transactional
    @Override
    public WorldResponse createWorld(CreateWorldRequest request) {
        if (request == null) {
            throw new IllegalArgumentException(
                    "Không thể tạo thế giới với dữ liệu null");
        }

        World world = request.toEntity();
        world.setCreatedBy(getCurrentUser());
        World savedWorld = worldRepository.save(world);
        auditLogService.log(
                LogEntityType.WORLD,
                savedWorld.getId(),
                LogAction.CREATE,
                "Thêm thế giới: " + savedWorld.getTitle());
        return WorldResponse.fromEntity(world);
    }

    @Transactional
    @Override
    public WorldResponse updateWorld(UpdateWorldRequest request) {
        if (request == null) {
            throw new IllegalArgumentException(
                    "Không thể thay đổi thế giới với dữ liệu null");
        }
        World world = findWorld(request.getId());
        world.setTag(request.getTag());
        world.setTitle(request.getTitle());
        world.setContent(request.getContent());
        world.setPriority(request.getPriority());
        if (request.getImage() != null) {
            world.setImage(request.getImage());
        }
        world.setUpdatedBy(getCurrentUser());
        auditLogService.log(
                LogEntityType.WORLD,
                world.getId(),
                LogAction.UPDATE,
                "Sửa thế giới: " + world.getTitle());
        return WorldResponse.fromEntity(world);
    }

    @Transactional
    @Override
    public void deleteWorld(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Không thể xóa thế giới với ID null");
        }
        World found = findWorld(id);
        found.setDeleted(true);
        found.setCreatedBy(getCurrentUser());
        auditLogService.log(
                LogEntityType.WORLD,
                found.getId(),
                LogAction.DELETE,
                "Xóa thế giới: " + found.getTitle());
    }

    @Transactional
    @Override
    public void restoreWorld(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Không thể khôi phục thế giới với ID null");
        }
        World found = findWorld(id);
        found.setDeleted(false);
        found.setUpdatedBy(getCurrentUser());
        auditLogService.log(
                LogEntityType.WORLD,
                found.getId(),
                LogAction.RESTORE,
                "Khôi phục thế giới: " + found.getTitle());
    }

    @Override
    public WorldResponse getWorldDeletedFalseHighestPriority() {
        World world = worldRepository
                .findTopByDeletedFalseOrderByPriorityDesc();

        if (world == null) {
            return null;
        }

        return WorldResponse.fromEntity(world);
    }

    @Override
    public List<WorldResponse> getWorldsDeletedFalse() {
        return worldRepository
                .findByDeletedFalseOrderByPriorityDesc()
                .stream()
                .map(WorldResponse::fromEntity)
                .toList();
    }

    private World findWorld(Long id) {
        return worldRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy thế giới với ID: " + id));
    }

    @Override
    public long count() {
        return worldRepository.count();
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
