package co.urtss.core.usercases.impl

import co.urtss.core.adapters.outbound.CarouselPort
import co.urtss.core.model.Carousel
import co.urtss.core.usercases.interfaces.ICarousel
import javax.inject.Inject

class CarouselImpl @Inject constructor(private val carouselPort:CarouselPort): ICarousel{
    override fun getList(): List<Carousel> {
        return carouselPort.getList().map {
            Carousel(
                it.first,
                it.first,
                it.second,
                "",
                it.first.substring(it.first.length - 2).toInt(),
                true
            )
        }
    }

}