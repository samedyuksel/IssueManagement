package com.smdyksl.issuemanagement.repository;

import com.smdyksl.issuemanagement.entity.IssueHistory;
import com.smdyksl.issuemanagement.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IssueHistoryRepository extends JpaRepository<IssueHistory, Long> {

    List<IssueHistory> getByIssueIdOrderById(Long id);
}
