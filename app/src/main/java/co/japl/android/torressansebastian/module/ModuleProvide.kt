package co.japl.android.torressansebastian.module

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class ModuleProvide {

    @Singleton
    @Provides
    fun provideContext(application:Application):Context{
        return application as Context
    }

    @Provides
    fun provideInboundCarouselPort(context:Context): co.urtss.core.adapters.outbound.CarouselPort{
        return co.urtss.core.adapters.outbound.CarouselPort(context)
    }

}