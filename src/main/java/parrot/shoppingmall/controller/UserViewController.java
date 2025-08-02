package parrot.shoppingmall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserViewController {

    @GetMapping("/signup-form")
    public String signUpForm() {
        // templates/signup.html 을 찾아서 렌더링
        return "signup";
    }

    @GetMapping("/login-form")
    public String loginForm() {
        // templates/login.html 을 찾아서 렌더링
        return "login";
    }
}
