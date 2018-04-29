package MusicPlayerServer.rest

import MusicPlayerServer.domain.MusicFile
import MusicPlayerServer.services.MusicService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api")
class MusicFileController(private val musicService: MusicService) {

    @GetMapping("/musicfiles")
    fun getAllMusicFiles(): List<MusicFile> =
            musicService.findAllMusicFiles()

    @GetMapping("/musicfiles/{id}")
    fun getMusicFileById(@PathVariable id: Int) =
            musicService.findMusicFileById(id)

    @PutMapping("/updateMusicFile")
    fun updateMusicFile(@PathVariable(value = "musicFile") musicFile: MusicFile): ResponseEntity<MusicFile> {
        musicService.updateMusicFile(musicFile)
        return ResponseEntity.ok().body(musicFile)
    }

    @PostMapping("/addMusicFile")
    fun addNewMusicFile(@PathVariable(value = "musicFile") musicFile: MusicFile): ResponseEntity<MusicFile> {
        musicService.addNewMusicFile(musicFile)
        return ResponseEntity.ok().body(musicFile)
    }
}
