package parrot.shoppingmall.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import parrot.shoppingmall.dto.UserDto;
import parrot.shoppingmall.service.UserService;

import java.net.URI;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    /**
     * 회원가입 API 엔드포인트
     * @param request 회원가입 요청 데이터
     * @return 생성된 리소소의 URI와 함께 201 Created 응답
     */
    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@Valid @RequestBody UserDto.SignUpRequest request) {
        Long userId = userService.signUp(request);

        // 생성된 리소스의 위치를 URI로 만들어 응답 헤더에 담아줍니다. (RESTful API 설계 원칙)
        URI location = URI.create("/api/users/" + userId);

        return ResponseEntity.created(location).body("회원가입이 성공적으로 완료되었습니다. 사용자 ID: " + userId);
    }
}
