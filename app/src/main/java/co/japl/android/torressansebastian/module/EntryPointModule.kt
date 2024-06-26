package co.japl.android.torressansebastian.module

import co.urtss.core.adapters.inbound.CarouselPort
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@EntryPoint
@InstallIn(SingletonComponent::class)
interface EntryPointModule{
    fun getCarouselPort(): CarouselPort

}