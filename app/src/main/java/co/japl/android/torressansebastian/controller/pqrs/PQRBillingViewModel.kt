package co.japl.android.torressansebastian.controller.pqrs

import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import co.urtss.core.adapters.inbound.PqrsPort
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltViewModel
class PQRBillingViewModel @Inject constructor(private val pqrPort: PqrsPort): ViewModel() {

    private val _progress = mutableFloatStateOf(0f)
    val progress get() = _progress.floatValue
    private val _loader = mutableStateOf(false)
    val loader get() = _loader.value

    val url = mutableStateOf("")


    fun main() = runBlocking {
        _progress.floatValue = 0.1f
        execution()
        _progress.floatValue = 1f
    }

    suspend fun execution() {
        _progress.floatValue = 0.2f
        pqrPort.getUrlBilling()?.let {
            url.value = it
            _progress.floatValue = 0.7f
        }
        _loader.value = false
        _progress.floatValue = 0.8f
    }

}