package com.example.tasklist.web.dto.auth;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "JWT response")
public class JwtResponse {

    @Schema(
            description = "User id",
            example = "1"
    )
    private Long id;

    @Schema(
            description = "User username",
            example = "johndoe"
    )
    private String username;

    @Schema(
            description = "Access token",
            example = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJqb2huZG9lIiwiaWQiOjEsInJvbGVzIjpbIlJPTEVfQURNSU4iLCJST0xFX1VTRVIiXSwiZXhwIjoxNDY5NDUyOTMyNn0.2hz3feMD0LTdF7_ABYyRJJufPfaZsvUY84VsO6ypNgFX8doWm1MDeh8CJLayzLQHRu7WgwGBUbRqOMwzjr5zlg"
    )
    private String accessToken;

    @Schema(
            description = "Refresh token",
            example = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJqb2huZG9lIiwiaWQiOjEsImV4cCI6MjIzOTUwNTM0NTI5MzI2fQ.9n9d8EC_rTNEfdKhfRnR3I1F5j5bFtihKHC3Lbl2Xp5AAqdgg72zDs5khQFhKt3eXR7JC623ulsxZIZst3vAjA"
    )
    private String refreshToken;

}
