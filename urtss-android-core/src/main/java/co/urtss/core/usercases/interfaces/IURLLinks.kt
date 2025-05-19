package co.urtss.core.usercases.interfaces

interface IURLLinks {

    suspend fun getUrlBilling(): String?

    suspend fun getUrlGeneral(): String?

    suspend fun getUrlSuggestionBox(): String?

    suspend fun getUrlFAQAI(): String?
}