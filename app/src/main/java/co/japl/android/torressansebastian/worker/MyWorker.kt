package co.japl.android.torressansebastian.worker

import android.content.Context
import android.util.Log
import androidx.hilt.work.HiltWorker
import androidx.work.Worker
import androidx.work.WorkerParameters
import co.urtss.core.adapters.inbound.MessagePort
import dagger.assisted.AssistedInject


@HiltWorker
class MyWorker @AssistedInject constructor(
    private val appContext: Context,
    workerParams: WorkerParameters,
    private val svc: MessagePort
) : Worker(appContext, workerParams) {

    override fun doWork(): Result {
        Log.d(this::class.java.simpleName,"== onWork START")
        val data = inputData.getString("body")
        val title = inputData.getString("title")
        data?.let {
                svc.addMessage(it)
        }
        Log.d(this.javaClass.name,"doWork: $data")
        return Result.success()
    }
}