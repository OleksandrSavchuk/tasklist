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
            example = "eyJhbGciOiJIUzUxMiJ9.eyJ"
                    + "zdWIiOiJqb2huZG9lIiwiaWQiOjEsInJvbGVzIjpb"
                    + "IlJPTEVfQURNSU4iLCJST0xFX1VTRVIiXSwiZXhw"
                    + "IjoxNDY5NDUyOTMyNn0.2hz3feMD0LTdF7_ABYyR"
                    + "JJufPfaZsvUY84VsO6ypNgFX8doWm1MDeh8CJLay"
                    + "zLQHRu7WgwGBUbRqOMwzjr5zlg"
    )
    private String accessToken;

    @Schema(
            description = "Refresh token",
            example = "eyJhbGciOiJIUzUxMiJ9"
                    + ".eyJzdWIiOiJqb2huZG9lIi"
                    + "wiaWQiOjEsImV4cCI6MjIzO"
                    + "TUwNTM0NTI5MzI2fQ.9n9d8"
                    + "EC_rTNEfdKhfRnR3I1F5j5b"
                    + "FtihKHC3Lbl2Xp5AAqdgg72"
                    + "zDs5khQFhKt3eXR7JC623ul"
                    + "sxZIZst3vAjA"
    )
    private String refreshToken;

}
