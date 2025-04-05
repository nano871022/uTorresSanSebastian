package co.urtss.core.adapters.inbound

import co.urtss.core.usercases.interfaces.IURLLinks
import javax.inject.Inject

class URLLinksPort @Inject constructor(private val pqrsSvc:IURLLinks){

     suspend fun getUrlBilling():String?{
        return pqrsSvc.getUrlBilling()
     }

     suspend fun getUrlGeneral():String?{
        return pqrsSvc.getUrlGeneral()
     }

    suspend fun getUrlSuggestionBox():String?{
        return pqrsSvc.getUrlSuggestionBox()
    }
}