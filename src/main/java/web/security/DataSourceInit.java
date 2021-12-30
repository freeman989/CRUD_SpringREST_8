package web.security;

import org.springframework.stereotype.Component;
import web.model.Role;
import web.model.User;
import web.service.RoleService;
import web.service.UserService;
import java.util.HashSet;
import java.util.Set;

@Component
public class DataSourceInit {

    private UserService userService;
    private RoleService roleService;

    public DataSourceInit(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;

        Set<Role> allRoles = new HashSet<>();
        allRoles.add(new Role("ADMIN"));
        allRoles.add(new Role("USER"));
        roleService.createRoles(allRoles);
        User admin = new User("admin", "admin", 0, "admin@mail.ru", "admin");
        admin.setRoles("ADMIN, USER");
        userService.createUser(admin);
        User user = new User("Lex", "Luger", 25, "lex@mail.ru", "admin");
        user.setRoles("USER");
        userService.createUser(user);
        User user1 = new User("Joan", "Osborn", 50, "joan@mail.ru", "admin");
        user1.setRoles("USER");
        userService.createUser(user1);
        User user2 = new User("Mark", "Twain", 65, "mark@mail.ru", "admin");
        user2.setRoles("USER");
        userService.createUser(user2);
    }
}
