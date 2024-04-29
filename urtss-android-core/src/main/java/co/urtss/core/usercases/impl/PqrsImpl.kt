package co.urtss.core.usercases.impl

import co.urtss.core.adapters.outbound.PQRsPort
import co.urtss.core.usercases.interfaces.IPqrs
import javax.inject.Inject

class PqrsImpl @Inject constructor(private val pqrsSvc:PQRsPort) : IPqrs{
    override suspend fun getUrlBilling(): String? {
        return pqrsSvc.getPqrsBilling()
    }

    override suspend fun getUrlGeneral(): String? {
        return pqrsSvc.getPqrsGeneral()
    }

}