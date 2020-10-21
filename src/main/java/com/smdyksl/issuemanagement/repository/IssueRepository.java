package com.smdyksl.issuemanagement.repository;

import com.smdyksl.issuemanagement.entity.Issue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IssueRepository extends JpaRepository<Issue,Long> {


}
