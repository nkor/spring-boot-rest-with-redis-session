package github.nkor.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/protected", produces = "text/plain")
public class ProtectedResourceController {

    @PreAuthorize("hasAuthority('READ')")
    @GetMapping(value = "/read")
    public String readResource() {
        return "read";
    }

    @PreAuthorize("hasAuthority('WRITE')")
    @GetMapping(value = "/write")
    public String writeResource() {
        return "wrote";
    }

    @PreAuthorize("hasAuthority('DELETE')")
    @GetMapping(value = "/delete")
    public String deleteResource() {
        return "deleted";
    }
}
