package com.smdyksl.issuemanagement.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "Project Data Transfer Object")
public class ProjectDto {
    @ApiModelProperty(value = "Project ID")
    private Long id;

    @javax.validation.constraints.NotNull
    @ApiModelProperty(required = true,value = "Name Of Project")
    private String projectName;

    @javax.validation.constraints.NotNull
    @ApiModelProperty(required = true,value = "Code Of Project")
    private String projectCode;

    @NotNull
    @ApiModelProperty(required = true,value = "Project Manager ID")
    private Long managerId;

    @ApiModelProperty(required = true,value = "Project Manager Name")
    private UserDto manager;
}
