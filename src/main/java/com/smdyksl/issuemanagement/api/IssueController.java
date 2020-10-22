package com.smdyksl.issuemanagement.api;


import com.smdyksl.issuemanagement.dto.IssueDto;
import com.smdyksl.issuemanagement.dto.ProjectDto;
import com.smdyksl.issuemanagement.entity.IssueStatus;
import com.smdyksl.issuemanagement.service.impl.IssueServiceImpl;
import com.smdyksl.issuemanagement.util.ApiPaths;
import com.smdyksl.issuemanagement.util.TPage;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(ApiPaths.IssueCtrl.CTRL)
@Api(value = ApiPaths.ProjectCtrl.CTRL,description = "Issue APIs")
public class IssueController {

    private final IssueServiceImpl issueServiceImpl;

    public IssueController(IssueServiceImpl issueServiceImpl) {
        this.issueServiceImpl = issueServiceImpl;
    }

    @GetMapping("/pagination")
    @ApiOperation(value = "Get By Pagination Operation", response = IssueDto.class)
    public ResponseEntity<TPage<IssueDto>> getAllByPagination(Pageable pageable) {
        TPage<IssueDto> data = issueServiceImpl.getAllPageable(pageable);
        return ResponseEntity.ok(data);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get By Id Operation",response = IssueDto.class)
    public ResponseEntity<IssueDto> getById(@PathVariable(value = "id") Long id) {
        IssueDto issueDto = issueServiceImpl.getById(id);
        return ResponseEntity.ok(issueDto);
    }

    @PostMapping
    @ApiOperation(value = "Create Operation",response = IssueDto.class)
    public ResponseEntity<IssueDto> createIssue(@Valid @RequestBody IssueDto issue) {

        return ResponseEntity.ok(issueServiceImpl.save(issue));
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Update Operation",response = IssueDto.class)
    public ResponseEntity<IssueDto> updateIssue(@PathVariable(value = "id", required = true) Long id, @Valid @RequestBody IssueDto issue) {
        return ResponseEntity.ok(issueServiceImpl.update(id, issue));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "Delete Operation",response = Boolean.class)
    public ResponseEntity<Boolean> delete(@PathVariable(value = "id", required = true) Long id) {

        return ResponseEntity.ok(issueServiceImpl.delete(id));
    }

    @GetMapping("/statuses")
    @ApiOperation(value = "Get All Issue Statuses Operation", response = String.class, responseContainer = "List")
    public ResponseEntity<List<IssueStatus>> getAll() {
        return ResponseEntity.ok(Arrays.asList(IssueStatus.values()));
    }
}
