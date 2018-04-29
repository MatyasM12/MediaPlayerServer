package MusicPlayerServer.domain

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "user")
data class User(
        @Id
        var id: Int,
        var username: String,
        var password: String
) {
    constructor() : this(-1, "", "")
}
