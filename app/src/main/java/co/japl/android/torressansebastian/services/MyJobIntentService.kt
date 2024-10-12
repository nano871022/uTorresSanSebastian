package co.japl.android.torressansebastian.services

import android.util.Log
import androidx.core.app.JobIntentService
import co.japl.android.torressansebastian.ui.settings.NavigationEnum
import co.urtss.core.adapters.inbound.MessagePort
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MyJobIntentService: JobIntentService() {

    @Inject
    lateinit var svc: MessagePort

    override fun onHandleWork(intent: android.content.Intent) {
        try {
            Log.d(this::class.java.simpleName, "== onHandleWork START")
            val message = intent.getStringExtra("body")
            val title = intent.getStringExtra("title")
            message?.let {
                svc.addMessage(it).also {
                    intent.putExtra("destinationId", NavigationEnum.Messages.getId())
                    sendBroadcast(intent)
                }
            }
        }catch(e:Exception){
            Log.e(this.javaClass.name,"onHandleWork: ",e)
        }
    }
}