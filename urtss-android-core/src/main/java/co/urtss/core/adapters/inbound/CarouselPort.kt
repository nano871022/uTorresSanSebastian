package co.urtss.core.adapters.inbound

import co.urtss.core.model.Carousel
import co.urtss.core.usercases.impl.CarouselImpl
import javax.inject.Inject

class CarouselPort @Inject constructor(private val carousel: CarouselImpl) {

    suspend fun getList(): List<Carousel> {
        return carousel.getList()
    }

    suspend fun getFromUrl():List<Carousel>{
        return carousel.getFromUrl()
    }
}