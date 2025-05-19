package co.urtss.core.adapters.outbound

import android.content.Context
import android.util.Log
import co.com.japl.connect.gdrive.firebase.realtime.Realtime
import co.urtss.core.R
import co.urtss.core.enums.RealtimeDBKeys
import javax.inject.Inject

class URLLinksPort @Inject constructor(private val context: Context, private val realtimeSvc: Realtime) {

    suspend fun getPqrsGeneral():String{
        var url = context.getString(R.string.url_pqr_general)
        realtimeSvc.connect(RealtimeDBKeys.URL_PQR_GENERAL.toString().lowercase()).collect{
            it?.let {
                url = it.also { Log.d("URLLinksPort", "==Get Value  $it") }
            }
        }
        return url
    }

    suspend fun getPqrsBilling():String{
        var url =  context.getString(R.string.url_pqr_billing)
        realtimeSvc.connect(RealtimeDBKeys.URL_PQR_BILLING.toString().lowercase()).collect{
            it?.let {
                url = it.also { Log.d("URLLinksPort", "==Get Value  $it") }
            }
        }
        return url
    }

    suspend fun getPqrsSuggestionBox():String{
        var url =  context.getString(R.string.url_suggestion_box)
        realtimeSvc.connect(RealtimeDBKeys.URL_SUGGESTION_BOX.toString().lowercase()).collect{
            it?.let {
               url = it.also { Log.d("URLLinksPort", "==Get Value  $it") }
            }
        }
        return url
    }

    suspend fun getFAQAI():String{
        var url = context.getString(R.string.url_faq_ai)
        realtimeSvc.connect(RealtimeDBKeys.URL_FAQ_AI.toString().lowercase()).collect{
            it?.let {
                url = it.also{Log.d("URLLinksPort", "==Get Value  $it")}
            }
        }
        return url
    }
}