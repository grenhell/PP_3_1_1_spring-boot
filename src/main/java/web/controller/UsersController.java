package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.dao.UserDaoImp;
import web.models.User;

@Controller
@RequestMapping("/users")
public class UsersController {
    private final UserDaoImp usersDao;

    public UsersController(UserDaoImp usersDao) {
        this.usersDao = usersDao;
    }

    @GetMapping
    public String index(Model model) {
        java.util.List<User> userList = usersDao.listUsers();
        model.addAttribute("userlist", userList);
        return "/users";
    }
    @GetMapping("/new")
    public String newUser (@ModelAttribute("user") User user) {
        return "/new";
    }

    @GetMapping("/{id}")
    public String read(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", usersDao.read(id));
        return "/read";
    }

    @PostMapping
    public String create (@ModelAttribute("user") User user) {
        usersDao.add(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}/edit")
    public String edit (Model model, @PathVariable("id") int id) {
        model.addAttribute("user", usersDao.read(id));
        return "/edit";
    }
    @PatchMapping("/{id}")
    public String update (@ModelAttribute("user") User user, @PathVariable("id") long id) {
        usersDao.update(id, user);
        return "redirect:/users";
    }
    @DeleteMapping("/{id}")
    public String delete (@PathVariable("id") long id) {
        usersDao.delete(id);

        return "redirect:/users";
    }

}