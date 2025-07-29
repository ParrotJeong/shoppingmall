package parrot.shoppingmall.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

public class UserDto {

    @Getter
    @Setter
    public static class SignUpRequest {

        @NotBlank(message = "로그인 아이디는 필수 입력 값입니다.")
        private String loginId;

    }
}
