package com.darkfantasy.service.impl;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.darkfantasy.dto.story.CreateStoryRequest;
import com.darkfantasy.dto.story.UpdateStoryRequest;
import com.darkfantasy.entity.Story;
import com.darkfantasy.entity.User;
import com.darkfantasy.entity.enums.LogAction;
import com.darkfantasy.entity.enums.LogEntityType;
import com.darkfantasy.dto.story.StoryResponse;
import com.darkfantasy.repository.StoryRepository;
import com.darkfantasy.repository.UserRepository;
import com.darkfantasy.service.AuditLogService;
import com.darkfantasy.service.StoryService;
import com.darkfantasy.util.SecurityUtil;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StoryServiceImpl implements StoryService {
    private final StoryRepository storyRepository;
    private final UserRepository userRepository;
    private final AuditLogService auditLogService;

    @Override
    public Page<StoryResponse> getStories(Pageable pageable) {
        return storyRepository
                .findAllByOrderByIdAsc(pageable)
                .map(StoryResponse::fromEntity);
    }

    @Override
    public StoryResponse getStoryById(Long id) {
        return StoryResponse.fromEntity(findStory(id));
    }

    @Transactional
    @Override
    public StoryResponse createStory(CreateStoryRequest request) {
        if (request == null) {
            throw new IllegalArgumentException(
                    "Không thể tạo câu chuyện với dữ liệu null");
        }

        Story story = request.toEntity();

        story.setCreatedBy(getCurrentUser());

        Story savedStory = storyRepository.save(story);
        auditLogService.log(
                LogEntityType.STORY,
                savedStory.getId(),
                LogAction.CREATE,
                "Thêm câu chuyện: " + savedStory.getTitle());
        return StoryResponse.fromEntity(savedStory);
    }

    @Transactional
    @Override
    public StoryResponse updateStory(UpdateStoryRequest request) {
        if (request == null) {
            throw new IllegalArgumentException(
                    "Không thể thay đổi câu chuyện với dữ liệu null");
        }
        Story story = findStory(request.getId());
        story.setTag(request.getTag());
        story.setTitle(request.getTitle());
        story.setContent(request.getContent());
        if (request.getImage() != null) {
            story.setImage(request.getImage());
        }
        story.setQuoteContent(request.getQuoteContent());
        story.setQuoteAuthor(request.getQuoteAuthor());
        story.setPriority(request.getPriority());
        story.setUpdatedBy(getCurrentUser());
        auditLogService.log(
                LogEntityType.STORY,
                story.getId(),
                LogAction.UPDATE,
                "Sửa câu chuyện: " + story.getTitle());
        return StoryResponse.fromEntity(story);
    }

    @Transactional
    @Override
    public void deleteStory(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Không thể xóa câu chuyện với ID null");
        }
        Story found = findStory(id);
        found.setDeleted(true);
        found.setUpdatedBy(getCurrentUser());
        auditLogService.log(
                LogEntityType.STORY,
                found.getId(),
                LogAction.DELETE,
                "Xóa câu chuyện: " + found.getTitle());
    }

    @Transactional
    @Override
    public void restoreStory(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Không thể khôi phục câu chuyện với ID null");
        }
        Story found = findStory(id);
        found.setDeleted(false);
        found.setUpdatedBy(getCurrentUser());
        auditLogService.log(
                LogEntityType.STORY,
                found.getId(),
                LogAction.RESTORE,
                "Khôi phục câu chuyện: " + found.getTitle());
    }

    @Override
    public StoryResponse getStoryDeletedFalseHighestPriority() {
        Story story = storyRepository.findTopByDeletedFalseOrderByPriorityDesc();
        if(story == null){
            return null;
        }
        return StoryResponse.fromEntity(story);
    }

    @Override
    public List<StoryResponse> getStoriesDeletedFalse() {
        return storyRepository
                .findByDeletedFalseOrderByPriorityDesc()
                .stream()
                .map(StoryResponse::fromEntity)
                .toList();
    }

    @Override
    public long count() {
        return storyRepository.count();
    }

    private Story findStory(Long id) {
        return storyRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Không tìm thấy câu chuyện với ID: " + id));
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
