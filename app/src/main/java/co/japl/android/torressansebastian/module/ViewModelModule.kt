package co.japl.android.torressansebastian.module

import co.urtss.core.adapters.inbound.DocumentPort
import co.urtss.core.adapters.interfacces.inbound.IDocumentPort
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
internal object ViewModelModule {

    @Provides
    @ViewModelScoped
    fun provideDocumentListModelView(documentImpl:DocumentPort) :IDocumentPort = documentImpl
}