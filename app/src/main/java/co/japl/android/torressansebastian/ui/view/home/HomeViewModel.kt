package co.japl.android.torressansebastian.ui.view.home

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import co.japl.android.torressansebastian.module.EntryPointModule
import co.urtss.core.adapters.inbound.CarouselPort
import co.urtss.core.model.Carousel
import dagger.hilt.EntryPoints
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val application:Application) : AndroidViewModel(application) {
    private lateinit var  _listDefaultDrawable : List<Carousel>
    private val _carousel:CarouselPort ?= EntryPoints.get(application,EntryPointModule::class.java).getCarouselPort()
    val list:List<Carousel> get() = _listDefaultDrawable


    init{
        _carousel?.getList()?.let{
             _listDefaultDrawable = it
        }
    }
}