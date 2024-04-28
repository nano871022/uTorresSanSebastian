package co.urtss.core.adapters.inbound

import co.urtss.core.usercases.interfaces.IPqrs
import javax.inject.Inject

class PqrsPort @Inject constructor(private val pqrsSvc:IPqrs){

     fun getUrlBilling():String?{
    return pqrsSvc.getUrlBilling()
    }

     fun getUrlGeneral():String?{
    return pqrsSvc.getUrlGeneral()
    }

}