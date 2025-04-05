package co.japl.android.torressansebastian.module

import co.urtss.core.usercases.impl.CarouselImpl
import co.urtss.core.usercases.impl.DocumentImpl
import co.urtss.core.usercases.impl.Message
import co.urtss.core.usercases.impl.URLLinksImpl
import co.urtss.core.usercases.interfaces.ICarousel
import co.urtss.core.usercases.interfaces.IDocument
import co.urtss.core.usercases.interfaces.IMessage
import co.urtss.core.usercases.interfaces.IURLLinks
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface BindsModule {

    @Binds
    fun bindUserCaseCarousel(carousel: CarouselImpl): ICarousel

    @Binds
    fun bindUserCaseDocument(document: DocumentImpl): IDocument

    @Binds
    fun bindUserCasePqrs(pqrs: URLLinksImpl): IURLLinks

    @Binds
    fun bindInboundMessagePort(svc:Message):IMessage
}