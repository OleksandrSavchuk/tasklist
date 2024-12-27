package com.example.tasklist.web.dto.task;

import com.example.tasklist.domain.task.Status;
import com.example.tasklist.web.dto.validation.OnCreate;
import com.example.tasklist.web.dto.validation.OnUpdate;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Schema(description = "Task DTO")
public class TaskDto {

    @Schema(
            description = "Task id",
            example = "2"
    )
    @NotNull(message = "Id must be not null.", groups = OnUpdate.class)
    private Long id;

    @Schema(
            description = "Task title",
            example = "Do homework"
    )
    @NotNull(message = "Title must be not null.", groups = {OnCreate.class, OnUpdate.class})
    @Length(max = 255, message = "Title length be less than 255 characters", groups = {OnCreate.class, OnUpdate.class})
    private String title;

    @Schema(
            description = "Task description",
            example = "Math, Physics, Literature"
    )
    @Length(max = 255, message = "Description length be less than 255 characters", groups = {OnCreate.class, OnUpdate.class})
    private String description;

    @Schema(
            description = "Task status",
            example = "IN_PROGRESS"
    )
    private Status status;

    @Schema(
            description = "Task expiration date",
            example = "2024-09-28 15:00:00.000000"
    )
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime expirationDate;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private List<String> images;

}
