package MusicPlayerServer.repository

import MusicPlayerServer.domain.User
import org.springframework.data.mongodb.repository.MongoRepository

interface UserRepository: MongoRepository<User,Int>