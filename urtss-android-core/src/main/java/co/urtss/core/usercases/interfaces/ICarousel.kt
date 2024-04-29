package co.urtss.core.usercases.interfaces

import co.urtss.core.model.Carousel

interface ICarousel {
    suspend fun getList(): List<Carousel>

    suspend fun getFromUrl():List<Carousel>
}