package team3.FinalBuildWeek.auth.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserCTRL {
    @Autowired
    UserSRV userSRV;

    @GetMapping
    public Page<User> getAll(@RequestParam(defaultValue = "0") int pageNumber,
                              @RequestParam(defaultValue = "10") int pageSize,
                              @RequestParam(defaultValue = "name") String orderBy) {
        return userSRV.getAll(pageNumber, pageSize, orderBy);
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable UUID id) {
        return userSRV.findById(id);
    }

    @GetMapping("/me")
    public User getCurrentUser(@AuthenticationPrincipal User authenticatedCustomer) {
        return authenticatedCustomer;
    }


    @PutMapping("me/{id}")
    @PreAuthorize("hasAuthority('USER')")
    public User findByIdAndUpdate(@PathVariable UUID id, @RequestBody UserDTO eventDTO, @AuthenticationPrincipal User currentAuthenticatedUser) {
        return userSRV.findByIdAndUpdate(id, eventDTO, currentAuthenticatedUser);
    }

    @DeleteMapping("me/{id}")
    @PreAuthorize("hasAuthority('USER')")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAuthorById(@PathVariable UUID id, @AuthenticationPrincipal User currentAuthenticatedUser) {
        userSRV.deleteById(id, currentAuthenticatedUser);
    }


}
