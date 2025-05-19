package co.japl.android.torressansebastian.module

import co.urtss.core.adapters.inbound.CarouselPort
import co.urtss.core.adapters.inbound.DocumentPort
import co.urtss.core.adapters.inbound.MessagePort
import co.urtss.core.adapters.inbound.URLLinksPort
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@EntryPoint
@InstallIn(SingletonComponent::class)
interface EntryPointModule{
    fun getCarouselPort(): CarouselPort

    fun getIDocumentPort() : DocumentPort

    fun getMessagePort(): MessagePort

    @Deprecated("use EntryPointModule#getURLLinksPort() instead")
    fun getPQRSPort(): URLLinksPort

    fun getURLLinksPort(): URLLinksPort

}