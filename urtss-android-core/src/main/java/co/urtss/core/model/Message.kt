package co.urtss.core.model

import java.time.LocalDateTime

data class Message(
    var id: Int? = null,
    var message: String? = null,
    var date: LocalDateTime? = null
)
