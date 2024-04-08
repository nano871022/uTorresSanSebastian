package co.japl.android.torressansebastian.module

import co.urtss.core.usercases.impl.CarouselImpl
import co.urtss.core.usercases.interfaces.ICarousel
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface BindsModule {

    @Binds
    fun bindUserCaseCarousel(carousel: CarouselImpl): ICarousel

}