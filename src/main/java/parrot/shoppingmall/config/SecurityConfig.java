package parrot.shoppingmall.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // CSRF, CORS 등 기본 보안 설정 (우선 간단히 비활성화)
        http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        // 아래 경로들은 인증 없이 접근 허용
                        .requestMatchers("/users/**", "/api/users/signup", "/css/**").permitAll()
                        // 그 외 모든 요청은 인증 필요
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        // 커스텀 로그인 페이지 경로 지정
                        .loginPage("/users/login-form")
                        // 로그인 처리 URL (Spring Security가 이 URL로 오는 요청을 처리)
                        .loginProcessingUrl("/api/users/login")
                        // 로그인 성공 시 리다이렉트 될 기본 URL
                        .defaultSuccessUrl("/", true)
                        // 로그인 필드 이름 설정 (User 엔티티의 loginId와 맞춤)
                        .usernameParameter("loginId")
                        // 인증 실패 시 이동할 URL
                        .failureUrl("/users/login-form?error=true")
                );

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        // 비밀번호 암호화에 BCrypt 알고리즘 사용
        return new BCryptPasswordEncoder();
    }
}
