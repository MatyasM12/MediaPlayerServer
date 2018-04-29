package MusicPlayerServer.repository

import MusicPlayerServer.domain.User
import org.springframework.data.mongodb.repository.MongoRepository
import java.util.*

interface UserRepository : MongoRepository<User, Int> {
    fun findByUsername(username: String): Optional<User>
}
