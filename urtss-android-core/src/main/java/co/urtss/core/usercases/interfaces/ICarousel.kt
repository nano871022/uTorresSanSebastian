package co.urtss.core.usercases.interfaces

import co.urtss.core.model.Carousel

interface ICarousel {
    fun getList(): List<Carousel>
}