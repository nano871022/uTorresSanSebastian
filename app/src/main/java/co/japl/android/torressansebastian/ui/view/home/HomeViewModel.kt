package co.japl.android.torressansebastian.ui.view.home

import android.app.Application
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import co.japl.android.torressansebastian.module.EntryPointModule
import co.urtss.core.adapters.inbound.CarouselPort
import co.urtss.core.model.Carousel
import dagger.hilt.EntryPoints
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val application:Application?) : AndroidViewModel(application!!) {
    private val _carousel:CarouselPort ?= EntryPoints.get(application,EntryPointModule::class.java).getCarouselPort()

    private var  _listDefaultDrawable = mutableStateListOf<Carousel>()


    private val _progress = mutableFloatStateOf(0.0f)
    private val _loader = mutableStateOf(true)

    val list get() = _listDefaultDrawable
    val progress get() = _progress
    val loader get() = _loader


    fun main() = runBlocking{
        _progress.floatValue = 0.1f
        execution()

        _progress.floatValue = 1.0f
    }


    suspend fun execution(){
        _progress.floatValue = 0.2f
        _carousel?.getList()?.let{
            _progress.floatValue = 0.3f
            _listDefaultDrawable.clear()
            _carousel?.getFromUrl()?.let {
                _progress.floatValue = 0.5f
                it.forEach(_listDefaultDrawable::add)
                _progress.floatValue = 0.7f
            }
            it.forEach (_listDefaultDrawable::add)
            _progress.floatValue = 0.8f
        }

        _loader.value = false
        _progress.floatValue = 0.9f
    }



}