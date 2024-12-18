package com.example.tasklist.web.dto.user;

import com.example.tasklist.domain.task.Task;
import com.example.tasklist.domain.user.Role;
import com.example.tasklist.web.dto.validation.OnCreate;
import com.example.tasklist.web.dto.validation.OnUpdate;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import java.util.List;
import java.util.Set;

@Data
@Schema(description = "User DTO")
public class UserDto {

    @Schema(
            description = "User id",
            example = "1"
    )
    @NotNull(message = "Id must be not null.", groups = OnUpdate.class)
    private Long id;

    @Schema(
            description = "User name",
            example = "John Doe"
    )
    @NotNull(message = "Name must be not null.", groups = {OnCreate.class, OnUpdate.class})
    @Length(max = 255, message = "Name length be less than 255 characters", groups = {OnCreate.class, OnUpdate.class})
    private String name;

    @Schema(
            description = "User username",
            example = "johndoe"
    )
    @NotNull(message = "Username must be not null.", groups = {OnCreate.class, OnUpdate.class})
    @Length(max = 255, message = "Username length be less than 255 characters", groups = {OnCreate.class, OnUpdate.class})
    private String username;

    @Schema(
            description = "User crypted password",
            example = "$2a$10$zyCeB0D3qKNT0Zr6dEkYEOocDWseb84CEOMevM3Npx.q2IIzlVSFG"
    )
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotNull(message = "Password must be not null", groups = {OnCreate.class, OnUpdate.class})
    private String password;

    @Schema(
            description = "User password confirmation",
            example = "$2a$10$zyCeB0D3qKNT0Zr6dEkYEOocDWseb84CEOMevM3Npx.q2IIzlVSFG"
    )
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotNull(message = "Password confirmation must be not null", groups = {OnCreate.class})
    private String passwordConfirmation;

}
