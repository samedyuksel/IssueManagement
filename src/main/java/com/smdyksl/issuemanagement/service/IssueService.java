package com.smdyksl.issuemanagement.service;

import com.smdyksl.issuemanagement.dto.IssueDto;
import com.smdyksl.issuemanagement.entity.Issue;
import com.smdyksl.issuemanagement.util.TPage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IssueService {

    IssueDto save(IssueDto issue);

    IssueDto getById(Long id);

    TPage<IssueDto> getAllPageable(Pageable pageable);

    Boolean delete(Long issue);

    IssueDto update(Long id, IssueDto project);
}
