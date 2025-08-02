package parrot.shoppingmall.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import parrot.shoppingmall.entity.User;
import parrot.shoppingmall.entity.UserRole;

public class UserDto {

    @Getter
    @Setter
    public static class SignUpRequest {

        @NotBlank(message = "로그인 아이디는 필수 입력 값입니다.")
        private String loginId;

        @NotBlank(message = "비밀번호는 필수 입력 값입니다.")
        @Size(min = 8, message = "비밀번호는 8자 이상이어야 합니다.")
        private String password;

        @NotBlank(message = "이름은 필수 입력 값입니다.")
        private String name;

        private String address;

        /**
         * DTO를 User 엔티티로 변환하는 메서드
         * @param encodedPassword 암호화된 비밀번호
         * @return User 엔티티
         */
        public User toEntity(String encodedPassword) {
            return User.builder()
                    .loginId(this.loginId)
                    .password(encodedPassword)
                    .name(this.name)
                    .address(this.address)
                    .role(UserRole.USER) // 기본 역할은 USER로 설정
                    .build();
        }

    }
}
