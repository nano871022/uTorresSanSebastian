package co.urtss.core.adapters.inbound

import co.urtss.core.usercases.interfaces.IPqrs
import javax.inject.Inject

class PqrsPort @Inject constructor(private val pqrsSvc:IPqrs){

     suspend fun getUrlBilling():String?{
    return pqrsSvc.getUrlBilling()
    }

     suspend fun getUrlGeneral():String?{
    return pqrsSvc.getUrlGeneral()
    }

}