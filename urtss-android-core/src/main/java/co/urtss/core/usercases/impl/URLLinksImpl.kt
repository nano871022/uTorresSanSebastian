package co.urtss.core.usercases.impl

import co.urtss.core.adapters.outbound.URLLinksPort
import co.urtss.core.usercases.interfaces.IURLLinks
import javax.inject.Inject

class URLLinksImpl @Inject constructor(private val pqrsSvc:URLLinksPort) : IURLLinks{
    override suspend fun getUrlBilling(): String? {
        return pqrsSvc.getPqrsBilling()
    }

    override suspend fun getUrlGeneral(): String? {
        return pqrsSvc.getPqrsGeneral()
    }

    override suspend fun getUrlSuggestionBox(): String? {
        return pqrsSvc.getPqrsSuggestionBox()
    }

}