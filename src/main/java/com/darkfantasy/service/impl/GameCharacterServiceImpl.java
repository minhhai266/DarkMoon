package com.darkfantasy.service.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.darkfantasy.dto.gamecharacter.CreateGameCharacterRequest;
import com.darkfantasy.dto.gamecharacter.GameCharacterResponse;
import com.darkfantasy.dto.gamecharacter.UpdateGameCharacterRequest;
import com.darkfantasy.entity.GameCharacter;
import com.darkfantasy.entity.User;
import com.darkfantasy.entity.enums.LogAction;
import com.darkfantasy.entity.enums.LogEntityType;
import com.darkfantasy.repository.GameCharacterRepository;
import com.darkfantasy.repository.UserRepository;
import com.darkfantasy.service.AuditLogService;
import com.darkfantasy.service.GameCharacterService;
import com.darkfantasy.util.SecurityUtil;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GameCharacterServiceImpl implements GameCharacterService {

    private final GameCharacterRepository gameCharacterRepository;
    private final UserRepository userRepository;
    private final AuditLogService auditLogService;

    @Override
    public GameCharacterResponse getGameCharacterById(Long id) {
        return GameCharacterResponse.fromEntity(findGameCharacter(id));
    }

    @Transactional
    @Override
    public GameCharacterResponse createGameCharacter(
            CreateGameCharacterRequest request) {

        if (request == null) {
            throw new IllegalArgumentException(
                    "Không thể tạo nhân vật với dữ liệu null");
        }

        GameCharacter character = request.toEntity();
        character.setCreatedBy(getCurrentUser());

        GameCharacter savedCharacter = gameCharacterRepository.save(character);
        auditLogService.log(
                LogEntityType.CHARACTER,
                savedCharacter.getId(),
                LogAction.CREATE,
                "Thêm nhân vật: " + savedCharacter.getName());
        return GameCharacterResponse.fromEntity(
                savedCharacter);
    }

    @Transactional
    @Override
    public GameCharacterResponse updateGameCharacter(UpdateGameCharacterRequest request) {
        if (request == null) {
            throw new IllegalArgumentException(
                    "Không thể thay đổi nhân vật với dữ liệu null");
        }
        GameCharacter character = findGameCharacter(request.getId());
        character.setName(request.getName());
        character.setRace(request.getRace());
        character.setDescription(request.getDescription());
        character.setQuote(request.getQuote());
        character.setPriority(request.getPriority());
        character.setUpdatedBy(getCurrentUser());
        if (request.getImage() != null) {
            character.setImage(request.getImage());
        }
        auditLogService.log(
                LogEntityType.CHARACTER,
                character.getId(),
                LogAction.UPDATE,
                "Sửa nhân vật: " + character.getName());
        return GameCharacterResponse.fromEntity(character);

    }

    @Transactional
    @Override
    public void deleteCharacter(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Không thể xóa nhân vật với ID null");
        }
        GameCharacter found = findGameCharacter(id);
        found.setDeleted(true);
        found.setUpdatedBy(getCurrentUser());
        auditLogService.log(
                LogEntityType.CHARACTER,
                found.getId(),
                LogAction.DELETE,
                "Xóa nhân vật: " + found.getName());
    }

    @Transactional
    @Override
    public void restoreCharacter(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Không thể khôi phục nhân vật với ID null");
        }
        GameCharacter found = findGameCharacter(id);
        found.setDeleted(false);
        found.setUpdatedBy(getCurrentUser());
                auditLogService.log(
                LogEntityType.CHARACTER,
                found.getId(),
                LogAction.RESTORE,
                "Khôi phục nhân vật: " + found.getName());
    }

    @Override
    public Page<GameCharacterResponse> getCharacters(Pageable pageable) {
        return gameCharacterRepository
                .findAllByOrderByIdAsc(pageable)
                .map(GameCharacterResponse::fromEntity);
    }

    @Override
    public List<GameCharacterResponse> getCharactersLimit(int limit) {
        if (limit <= 0)
            throw new IllegalArgumentException("Limit phải lớn hơn 0");
        return gameCharacterRepository
                .findByDeletedFalseOrderByPriorityDesc(PageRequest.of(0, limit))
                .stream()
                .map(GameCharacterResponse::fromEntity).toList();
    }

    @Override
    public List<GameCharacterResponse> getCharactersDeletedFalse() {
        return gameCharacterRepository
                .findByDeletedFalseOrderByPriorityDesc()
                .stream()
                .map(GameCharacterResponse::fromEntity)
                .toList();
    }

    @Override
    public long count() {
        return gameCharacterRepository.count();
    }

    private GameCharacter findGameCharacter(Long id) {
        return gameCharacterRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy nhân vật với ID: " + id));
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
