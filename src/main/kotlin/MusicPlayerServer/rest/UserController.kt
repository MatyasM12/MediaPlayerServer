package MusicPlayerServer.rest

import MusicPlayerServer.domain.User
import MusicPlayerServer.repository.UserRepository
import MusicPlayerServer.services.UserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class UserController(private val userService: UserService) {

    @GetMapping("/users")
    fun getAllUsers(): List<User> = userService.findAllUsers()

    @GetMapping("/users/{id}")
    fun getUserById(@PathVariable(value = "id") id:Int): User = userService.findUserById(id)
    @PostMapping("/addUser")
    fun addUser(@PathVariable(value = "user") user: User) = userService.addUser(user)

    @DeleteMapping("/user/{id}")
    fun deleteUser(@PathVariable(value = "user") user: User) = userService.deleteUser(user)

    @PutMapping("/updateUser")
    fun updateUser(@PathVariable(value = "user") user: User) = userService.updateUser(user)

    @PostMapping("/login")
    fun loginUser(@PathVariable user: User): ResponseEntity<User>{
           return if(userService.authenticateUser(user)) ResponseEntity.ok().body(user) else ResponseEntity.notFound().build()
    }
}