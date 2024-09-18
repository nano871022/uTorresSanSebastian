package co.urtss.core.usercases.impl

import android.util.Log
import co.urtss.core.adapters.outbound.CarouselPort
import co.urtss.core.model.Carousel
import co.urtss.core.usercases.interfaces.ICarousel
import javax.inject.Inject

class CarouselImpl @Inject constructor(private val carouselPort:CarouselPort): ICarousel{
    override suspend fun getList(): List<Carousel> {
        val list = mutableListOf<Carousel>()
        carouselPort.getList().map {
            Carousel(
                it.first,
                it.first,
                it.second,
                "",
                0,
                true
            )
        }.let(list::addAll)
    //    getFromUrl(list::addAll)
        return list
    }

    override suspend fun getFromUrl():List<Carousel>{
        try {
            return carouselPort.getListUrl().map {
                Carousel(
                    it.first,
                    it.first,
                    -1,
                    it.second,
                    if (it.first.contains(Regex("(\\d{2,})\\.\\w{3}"))) {
                        Regex("\\d{2,}\\.\\w{3}").find(it.first)!!.groupValues.takeIf { it.isNotEmpty() && it.size == 2 }
                            ?.get(1)?.toInt() ?: 0
                    } else {
                        0
                    },
                    true
                )
            }.takeIf { it.isNotEmpty() }?.let { it }?: emptyList<Carousel>()
        }catch(e:Exception){
            Log.e("CarouselImpl",e.message.toString())
            return emptyList()
        }
    }
}