package co.urtss.core.usercases.impl

import co.urtss.core.adapters.outbound.URLLinksPort
import co.urtss.core.usercases.interfaces.IURLLinks
import javax.inject.Inject

class URLLinksImpl @Inject constructor(private val urlLinksSvc:URLLinksPort) : IURLLinks{
    override suspend fun getUrlBilling(): String? {
        return urlLinksSvc.getPqrsBilling()
    }

    override suspend fun getUrlGeneral(): String? {
        return urlLinksSvc.getPqrsGeneral()
    }

    override suspend fun getUrlSuggestionBox(): String? {
        return urlLinksSvc.getPqrsSuggestionBox()
    }

    override suspend fun getUrlFAQAI(): String? {
        return urlLinksSvc.getFAQAI()
    }

}