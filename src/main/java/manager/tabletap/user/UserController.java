package manager.tabletap.user;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/badges")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public List<User> getAll(){
        return userService.getAll();
    }
    @GetMapping("/{id}")
    public User getById(@PathVariable("id") Long id){
        return userService.getById(id);
    }
    @PostMapping("/add")
    public User add(@RequestBody User user){
        return userService.add(user);
    }

    @PutMapping("/update/{id}")
    public User updateBadge(@RequestBody User user, @PathVariable("id") Long id){
        return userService.update(user, id);
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id){
        userService.delete(id);
    }

}
