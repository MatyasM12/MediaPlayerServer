package MusicPlayerServer

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class MusicPlayerServerApplication

fun main(args: Array<String>) {
    runApplication<MusicPlayerServerApplication>(*args)
}
