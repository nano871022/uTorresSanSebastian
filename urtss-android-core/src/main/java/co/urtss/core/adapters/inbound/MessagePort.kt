package co.urtss.core.adapters.inbound

import co.urtss.core.usercases.interfaces.IMessage
import java.time.LocalDateTime
import javax.inject.Inject

class MessagePort @Inject constructor(private val svc:IMessage) {

    fun getMessage() = svc.getMessages()

    fun addMessage( message:String){
        require(message.isNotEmpty()){"message cannot be empty"}
        svc.addMessage(message,LocalDateTime.now())
    }
}