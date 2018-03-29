package MusicPlayerServer.services

import MusicPlayerServer.domain.MusicFile
import MusicPlayerServer.repository.MusicFileRepository
import org.springframework.stereotype.Service
import java.util.*
import java.util.logging.Logger

@Service
class MusicService(private val musicFileRepository: MusicFileRepository) {
    private var logger: Logger = Logger.getLogger("MusicServiceLogger")
    init{
        createExams()
    }
    fun findAllMusicFiles(): List<MusicFile>{
        return musicFileRepository.findAll()
    }

    fun addNewMusicFile(musicFile: MusicFile){
        musicFileRepository.save(musicFile)
    }

    fun findMusicFileById(id: Int){
        musicFileRepository.findById(id)
    }

    fun updateMusicFile(musicFile: MusicFile){
        musicFileRepository.findById(musicFile.id).map { existingMusicFile ->
            val updatedMusicFile: MusicFile = existingMusicFile.copy(
                    name = musicFile.name, artist = musicFile.artist
            )
            musicFileRepository.save(updatedMusicFile)
        }
    }
    fun deleteMusicFile(id: Int){
        musicFileRepository.deleteById(id)
    }

    private fun createExams() {
        musicFileRepository.save(MusicFile(1,"asdf", "bbb"))
        musicFileRepository.save(MusicFile(2,"aaaa", "bbb"))
    }

}