package github.nkor;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(produces = "text/plain")
public class TestController {

    @GetMapping
    @PreAuthorize("hasAuthority('ADMIN1')")
    public String test() {
        return "protected";
    }
}
