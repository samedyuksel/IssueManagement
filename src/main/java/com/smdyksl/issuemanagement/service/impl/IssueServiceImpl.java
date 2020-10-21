package com.smdyksl.issuemanagement.service.impl;

import com.smdyksl.issuemanagement.dto.IssueDto;
import com.smdyksl.issuemanagement.entity.Issue;
import com.smdyksl.issuemanagement.repository.IssueRepository;
import com.smdyksl.issuemanagement.service.IssueService;
import com.smdyksl.issuemanagement.util.TPage;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class IssueServiceImpl implements IssueService {

    private final IssueRepository issueRepository;
    private final ModelMapper modelMapper;

    public IssueServiceImpl(IssueRepository issueRepository,ModelMapper modelMapper){
        this.issueRepository = issueRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public IssueDto save(IssueDto issue) {
        if(issue.getDate()==null){
            throw new IllegalArgumentException("Issue Date cannot be null!");
        }
        Issue issueDb = modelMapper.map(issue,Issue.class);

        issueDb = issueRepository.save(issueDb);
        return modelMapper.map(issueDb,IssueDto.class);
    }

    @Override
    public IssueDto getById(Long id) {

        Issue issue = issueRepository.getOne(id);
        return modelMapper.map(issue, IssueDto.class);
    }

    @Override
    public TPage<IssueDto> getAllPageable(Pageable pageable) {
        Page<Issue> data = issueRepository.findAll(pageable);
        TPage<IssueDto> response = new TPage<IssueDto>();
        response.setStat(data, Arrays.asList(modelMapper.map(data.getContent(), IssueDto[].class)));
        return response;
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
