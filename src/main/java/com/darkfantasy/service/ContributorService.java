package com.darkfantasy.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.darkfantasy.dto.contributor.ContributorResponse;
import com.darkfantasy.dto.contributor.CreateContributorRequest;
import com.darkfantasy.dto.contributor.UpdateContributorRequest;

public interface ContributorService {
    ContributorResponse getContributorById(Long id);

    ContributorResponse createContributor(CreateContributorRequest request);

    ContributorResponse updateContributor(UpdateContributorRequest request);

    void deleteContributor(Long contributorId);

    void restoreContributor(Long contributorId);

    Page<ContributorResponse> getContributors(Pageable pageable);

    Page<ContributorResponse> getContributorsDeletedFalse(Pageable pageable);

    long count();
}
