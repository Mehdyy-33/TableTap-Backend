package manager.tabletap.user;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/email/{email}")
    public ResponseEntity<User> getUserByEmail(@PathVariable String email) throws AccessDeniedException {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        String role = SecurityContextHolder.getContext().getAuthentication().getAuthorities().toString();

        if (username.equals(email) || role.equals("[ROLE_ADMIN]")) {
            Optional<User> user = userService.getUserByEmail(email);
            return user.map(ResponseEntity::ok).orElseThrow(() -> new RuntimeException("email " + email + " not found"));
        } else {
            throw new AccessDeniedException("User does not have the correct rights to access this resource");
        }
    }

    @GetMapping("/all")
    public List<User> getAll() throws AccessDeniedException {
        String role = SecurityContextHolder.getContext().getAuthentication().getAuthorities().toString();
        if (role.equals("[ROLE_ADMIN]")) {
            return userService.getAll();
        } else {
            throw new AccessDeniedException("User does not have the correct rights to access this resource");
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable Long id) throws AccessDeniedException {
        String role = SecurityContextHolder.getContext().getAuthentication().getAuthorities().toString();
        if (role.equals("[ROLE_ADMIN]")) {
            User updatedUser = userService.update(user, id);
            return ResponseEntity.ok(updatedUser);
        } else {
            throw new AccessDeniedException("User does not have the correct rights to access this resource");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) throws AccessDeniedException {
        String role = SecurityContextHolder.getContext().getAuthentication().getAuthorities().toString();
        if (role.equals("[ROLE_ADMIN]")) {
            userService.delete(id);
            return ResponseEntity.noContent().build();
        } else {
            throw new AccessDeniedException("User does not have the correct rights to access this resource");
        }
    }
}
