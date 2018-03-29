package MusicPlayerServer.domain

import org.jetbrains.annotations.NotNull
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import javax.print.attribute.IntegerSyntax

@Document(collection = "MusicFile")
data class MusicFile(
    @Id @get: NotNull
    var id: Int = 0,
    @get: NotNull
    var name: String = "",
    @get: NotNull
    var artist: String = ""
)