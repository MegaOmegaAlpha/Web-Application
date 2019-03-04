package dataAccessing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(path = "demo")
public class MainController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping(path="/add")
    public void addNewUser(@RequestParam String name, @RequestParam String password) {
        User user = new User(name, password);
        userRepository.save(user);
    }

    @GetMapping()
    public String getAll(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "db";
    }

    @PostMapping()
    public String add(@RequestParam String userName, @RequestParam String userPass, Model model) {
        userRepository.save(new User(userName, userPass));
        model.addAttribute("users", userRepository.findAll());
        return "db";
    }

    @PostMapping("find")
    public String find(@RequestParam String idToFind, Model model) {
        if (idToFind != null && isDigital(idToFind)) {
            model.addAttribute("users", userRepository.findUserById(Integer.parseInt(idToFind)));
        } else {
            model.addAttribute("users", userRepository.findAll());
        }
        return "db";
    }

    private boolean isDigital(String number) {
        try {
            Integer.parseInt(number);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
