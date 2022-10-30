package api_v1.latte_s.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/latte/user")
public class UserController {

    @GetMapping("/testing")
    public String test_get() {
        return "sample test";
    }
}
