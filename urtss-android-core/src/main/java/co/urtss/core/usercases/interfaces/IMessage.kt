package co.urtss.core.usercases.interfaces

import co.urtss.core.model.Message
import java.time.LocalDateTime

interface IMessage {

    fun getMessages():List<Message>

    fun addMessage(message:String,date:LocalDateTime)
}