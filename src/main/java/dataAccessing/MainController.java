package dataAccessing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path = "demon")
public class MainController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping(path="/add")
    public @ResponseBody String addNewUser(@RequestParam String name, @RequestParam String password) {
        User user = new User(name, password);
        userRepository.save(user);
        return "saved";
    }

    @GetMapping(path = "/all")
    public @ResponseBody Iterable<User> getAll() {
        return userRepository.findAll();
    }

}
