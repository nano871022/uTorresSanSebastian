package co.urtss.core.adapters.outbound

import android.content.Context
import android.util.Log
import co.com.japl.connect.gdrive.firebase.realtime.Realtime
import co.urtss.core.R
import co.urtss.core.enums.RealtimeDBKeys
import javax.inject.Inject

class PQRsPort @Inject constructor(private val context: Context, private val realtimeSvc: Realtime) {

    suspend fun getPqrsGeneral():String{
        var url = context.getString(R.string.url_pqr_general)
        realtimeSvc.connect(RealtimeDBKeys.URL_PQR_GENERAL.toString().lowercase()).collect{
            it?.let {
                Log.d("PQRsPort", "==Get Value  $it")
                url = it
            }
        }
        return url
    }

    suspend fun getPqrsBilling():String{
        var url =  context.getString(R.string.url_pqr_billing)
        realtimeSvc.connect(RealtimeDBKeys.URL_PQR_BILLING.toString().lowercase()).collect{
            it?.let {
                Log.d("PQRsPort", "==Get Value  $it")
                url = it
            }
        }
        return url
    }

}