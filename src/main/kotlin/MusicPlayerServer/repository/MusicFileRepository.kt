package MusicPlayerServer.repository

import MusicPlayerServer.domain.MusicFile
import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository

interface MusicFileRepository : MongoRepository<MusicFile, Int>