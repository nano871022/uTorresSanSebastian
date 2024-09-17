package co.urtss.core.usercases.interfaces

interface IPqrs {

    suspend fun getUrlBilling(): String?

    suspend fun getUrlGeneral(): String?
}