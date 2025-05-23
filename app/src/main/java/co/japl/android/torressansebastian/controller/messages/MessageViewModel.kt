package co.japl.android.torressansebastian.controller.messages

import android.app.Application
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import co.japl.android.torressansebastian.module.EntryPointModule
import co.urtss.core.adapters.inbound.MessagePort
import co.urtss.core.model.Message
import dagger.hilt.EntryPoints
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltViewModel
class MessageViewModel @Inject  constructor(private val application: Application?): AndroidViewModel(application!!)  {
    private val svc:MessagePort ?= EntryPoints.get(application, EntryPointModule::class.java).getMessagePort()
    private val listed = mutableListOf<Message>()
    val list get() = listed
    val loading = mutableStateOf(true)
    val progress = mutableFloatStateOf(0f)

    fun main() = runBlocking {
        execute()
    }

    private suspend fun execute(){
        progress.value = 0.3f
        svc?.getMessage()?.let {
            progress.value = 0.5f
            listed.clear()
            listed.addAll(it)
            progress.value = 0.7f
        }
        loading.value = false
        progress.value = 1f
    }
}