package MusicPlayerServer.rest

import MusicPlayerServer.domain.User
import MusicPlayerServer.services.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.logging.Logger

@RestController
@RequestMapping("/api")
class UserController(private val userService: UserService) {

    @GetMapping("/users")
    fun getAllUsers(): List<User> = userService.findAllUsers()

    @GetMapping("/users/{id}")
    fun getUserById(@PathVariable(value = "id") id: Int): User = userService.findUserById(id)

    @PostMapping("/addUser")
    fun addUser(@RequestBody user: User) = userService.addUser(user)!!

    @DeleteMapping("/user/{id}")
    fun deleteUser(@PathVariable(value = "user") user: User) = userService.deleteUser(user)

    @PutMapping("/updateUser")
    fun updateUser(@RequestBody user: User) = userService.updateUser(user)

    private val logger = Logger.getLogger("URC")
    @PostMapping("/login")
    fun loginUser(@RequestBody user: User): ResponseEntity<User> {
        logger.info("User " + user)
        return if (userService.loginUser(user)) ResponseEntity.ok().body(userService.findUserByUsername(user.username)) else ResponseEntity.notFound().build()
    }
}
