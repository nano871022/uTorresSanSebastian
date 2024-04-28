package co.urtss.core.usercases.impl

import co.urtss.core.adapters.outbound.CarouselPort
import co.urtss.core.model.Carousel
import co.urtss.core.usercases.interfaces.ICarousel
import javax.inject.Inject

class CarouselImpl @Inject constructor(private val carouselPort:CarouselPort): ICarousel{
    override fun getList(): List<Carousel> {
        val list = mutableListOf<Carousel>()
        carouselPort.getListUrl().map {
            Carousel(
                it.first,
                it.first,
                -1,
                it.second,
                if(it.first.contains(Regex("(\\d{2,})\\.\\w{3}"))){
                    Regex("\\d{2,}\\.\\w{3}").find(it.first)!!.groupValues.takeIf { it.isNotEmpty() && it.size == 2}?.get(1)?.toInt()?:0
                }else{0},
                true
            )
        }.let(list::addAll)
        carouselPort.getList().map {
            Carousel(
                it.first,
                it.first,
                it.second,
                "",
                it.first.substring(it.first.length - 2).toInt(),
                true
            )
        }.let(list::addAll)
        return list
    }

}