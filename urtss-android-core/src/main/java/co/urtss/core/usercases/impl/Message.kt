package co.urtss.core.usercases.impl

import co.urtss.core.adapters.outbound.MessageLocalPort
import co.urtss.core.model.Message
import co.urtss.core.usercases.interfaces.IMessage
import java.time.LocalDateTime
import javax.inject.Inject

class Message @Inject constructor( private val svc:MessageLocalPort): IMessage {

    override fun getMessages(): List<Message> {
        return svc.getMessages()
    }

    override fun addMessage(message: String, date: LocalDateTime) {
        val message = Message(0, message, date)
        if(!svc.addMessage(message)){
            throw RuntimeException("message not added")
        }
    }
}