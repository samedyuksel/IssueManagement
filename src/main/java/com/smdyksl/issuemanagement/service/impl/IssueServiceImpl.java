package com.smdyksl.issuemanagement.service.impl;

import com.smdyksl.issuemanagement.dto.IssueDetailDto;
import com.smdyksl.issuemanagement.dto.IssueDto;
import com.smdyksl.issuemanagement.dto.IssueHistoryDto;
import com.smdyksl.issuemanagement.dto.IssueUpdateDto;
import com.smdyksl.issuemanagement.entity.Issue;
import com.smdyksl.issuemanagement.entity.IssueStatus;
import com.smdyksl.issuemanagement.entity.User;
import com.smdyksl.issuemanagement.repository.IssueRepository;
import com.smdyksl.issuemanagement.repository.ProjectRepository;
import com.smdyksl.issuemanagement.repository.UserRepository;
import com.smdyksl.issuemanagement.service.IssueHistoryService;
import com.smdyksl.issuemanagement.service.IssueService;
import com.smdyksl.issuemanagement.util.TPage;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class IssueServiceImpl implements IssueService {

    private final IssueRepository issueRepository;
    private final UserRepository userRepository;
    private final ProjectRepository projectRepository;
    private final IssueHistoryService issueHistoryService;
    private final ModelMapper modelMapper;

    public IssueServiceImpl(IssueRepository issueRepository, UserRepository userRepository, ProjectRepository projectRepository, IssueHistoryService issueHistoryService, ModelMapper modelMapper){
        this.issueRepository = issueRepository;
        this.userRepository = userRepository;
        this.projectRepository = projectRepository;
        this.issueHistoryService = issueHistoryService;
        this.modelMapper = modelMapper;
    }

    @Transactional
    public IssueDetailDto update(Long id, IssueUpdateDto issue) {
        Issue issueDb = issueRepository.getOne(id);
        User user = userRepository.getOne(issue.getAssignee_id());
        issueHistoryService.addHistory(id,issueDb);

        issueDb.setAssignee(user);
        issueDb.setDate(issue.getDate());
        issueDb.setDescription(issue.getDescription());
        issueDb.setDetails(issue.getDetails());
        issueDb.setIssueStatus(issue.getIssueStatus());
        issueDb.setProject(projectRepository.getOne(issue.getProject_id()));
        issueRepository.save(issueDb);
        return getByIdWithDetails(id);
    }

    @Override
    public IssueDto save(IssueDto issue) {
        issue.setDate(new Date());
        issue.setIssueStatus(IssueStatus.OPEN);


        Issue issueEntity = modelMapper.map(issue, Issue.class);

        issueEntity.setProject(projectRepository.getOne(issue.getProjectId()));
        issueEntity = issueRepository.save(issueEntity);

        issue.setId(issueEntity.getId());
        return issue;
    }

    @Override
    public IssueDto getById(Long id) {

        Issue issue = issueRepository.getOne(id);
        return modelMapper.map(issue, IssueDto.class);
    }

    public IssueDetailDto getByIdWithDetails(Long id) {
        Issue issue = issueRepository.getOne(id);
        IssueDetailDto detailDto = modelMapper.map(issue, IssueDetailDto.class);
        List<IssueHistoryDto> issueHistoryDtos = issueHistoryService.getByIssueId(issue.getId());
        detailDto.setIssueHistories(issueHistoryDtos);
        return detailDto;
    }

    @Override
    public TPage<IssueDto> getAllPageable(Pageable pageable) {
        Page<Issue> data = issueRepository.findAll(pageable);
        TPage<IssueDto> response = new TPage<IssueDto>();
        response.setStat(data, Arrays.asList(modelMapper.map(data.getContent(), IssueDto[].class)));
        return response;
    }

    public List<IssueDto> getAll() {
        List<Issue> data = issueRepository.findAll();
        return Arrays.asList(modelMapper.map(data, IssueDto[].class));
    }

    @Override
    public Boolean delete(Long issueId) {
        issueRepository.deleteById(issueId);
        return true;
    }


    @Override
    public IssueDto update(Long id, IssueDto project) {
        return null;
    }
}
