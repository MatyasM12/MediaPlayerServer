package MusicPlayerServer.services

import MusicPlayerServer.domain.User
import MusicPlayerServer.repository.UserRepository
import org.springframework.stereotype.Service
import java.util.logging.Logger

@Service
class UserService(private val userRepository: UserRepository) {

    init {
        addMockUsers()
    }
    private var logger: Logger = Logger.getLogger("UserServiceLogger")

    fun findAllUsers() = userRepository.findAll()

    fun addUser(user: User) = userRepository.save(user)

    fun authenticateUser(user: User): Boolean = userRepository.findById(user.id).get().password == user.password

    fun deleteUser(user: User) = userRepository.deleteById(user.id)

    fun updateUser(user: User){
        userRepository.findById(user.id).map { existingUser ->
            val updatedUser: User = existingUser.copy(
                    username = user.username, password = user.password
            )
            userRepository.save(updatedUser)
        }
    }

    private fun addMockUsers(){
        userRepository.save(User(1, "mihai", "asdad"))
        userRepository.save(User(2, "adrian", "123"))
        userRepository.save(User(3, "bogdan", "432"))
        userRepository.save(User(4, "georgiana", "642"))
    }

    fun findUserById(id: Int): User = userRepository.findById(id).get()
}