package parrot.shoppingmall.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import parrot.shoppingmall.dto.UserDto;
import parrot.shoppingmall.entity.User;
import parrot.shoppingmall.repository.UserRepository;

@Service
@Transactional(readOnly = true) // 기본적으로 읽기 전용 트랜잭션 설정
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public Long singUp(UserDto.SignUpRequest request) {
        // 1. 로그인 아이디 중복 확인
        validateDuplicateUser(request.getLoginId());

        // 2. 비밀번호 암호화
        String encodedPassword = passwordEncoder.encode(request.getPassword());

        // 3. DTO를 Entity로 변환하여 DB에 저장
        User user = request.toEntity(encodedPassword);
        User savedUser = userRepository.save(user);

        return savedUser.getId();
    }

    private void validateDuplicateUser(String loginId) {
        userRepository.findByLoginId(loginId)
                .ifPresent(user -> {
                    throw new IllegalStateException("이미 존재하는 아이디입니다.");
                });

    }
}
