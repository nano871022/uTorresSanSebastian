package co.urtss.core.adapters.inbound

import co.urtss.core.usercases.interfaces.IURLLinks
import javax.inject.Inject

class URLLinksPort @Inject constructor(private val urlLinksSvc:IURLLinks){

     suspend fun getUrlBilling():String?{
        return urlLinksSvc.getUrlBilling()
     }

     suspend fun getUrlGeneral():String?{
        return urlLinksSvc.getUrlGeneral()
     }

    suspend fun getUrlSuggestionBox():String?{
        return urlLinksSvc.getUrlSuggestionBox()
    }

    suspend fun getUrlFAQAI():String?{
        return urlLinksSvc.getUrlFAQAI()
    }
}