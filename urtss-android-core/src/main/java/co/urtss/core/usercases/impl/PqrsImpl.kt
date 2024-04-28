package co.urtss.core.usercases.impl

import android.content.Context
import co.urtss.core.R
import co.urtss.core.usercases.interfaces.IPqrs
import javax.inject.Inject

class PqrsImpl @Inject constructor(private val context:Context) : IPqrs{
    override fun getUrlBilling(): String? {
        return context.getString(R.string.url_pqr_billing)
    }

    override fun getUrlGeneral(): String? {
        return context.getString(R.string.url_pqr_general)
    }

}