package co.japl.android.torressansebastian

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.core.app.JobIntentService.enqueueWork
import co.com.japl.ui.theme.MaterialThemeComposeUI
import co.japl.android.torressansebastian.impl.MenuService
import co.japl.android.torressansebastian.interfaces.IMenuService
import co.japl.android.torressansebastian.services.MyJobIntentService
import co.japl.android.torressansebastian.ui.view.MainView
import com.google.firebase.messaging.FirebaseMessaging
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Main : ComponentActivity() {

    private lateinit var menuSvc: IMenuService
    private val JOB_ID =  1001

    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.actionBar?.hide()
        menuSvc = MenuService(context = this)
        val intent = intent
        handleNotificationIntent(intent)
        setContent{
            FirebaseMessaging.getInstance().subscribeToTopic(BuildConfig.FMC_TOPIC).addOnCompleteListener { task ->
                if (!task.isSuccessful) {
                    Log.d(this.javaClass.name,"subscribeToTopic:failure", task.exception)
                }else{
                    Log.d(this.javaClass.name,"subscribeToTopic:success")
                }
            }
            MaterialThemeComposeUI {
                MainView(menuSvc)
            }
        }
    }

    private fun handleNotificationIntent(intent:Intent) {

        val title = intent.getStringExtra("Title")
        val body = intent.getStringExtra("Body")

        if (!title.isNullOrEmpty() && !body.isNullOrEmpty()) {
            val intent = Intent(this, MyJobIntentService::class.java)
            intent.putExtra("body",body)
                .putExtra("title",title)
            enqueueWork(this,MyJobIntentService::class.java, JOB_ID, intent)
        }else {
            this.getSharedPreferences("Notifications", Context.MODE_PRIVATE)?.let {
                val title = it.getString("title", "")
                val body = it.getString("body", "")
                if(!title.isNullOrEmpty() && !body.isNullOrEmpty()) {
                    val intent = Intent(this, MyJobIntentService::class.java)
                    intent.putExtra("body", body)
                        .putExtra("title", title)
                    enqueueWork(this, MyJobIntentService::class.java, JOB_ID, intent)
                }
            }
        }
    }

    override fun onNewIntent(intent: Intent) {
        super.onNewIntent(intent)
        handleNotificationIntent(intent)
    }


}