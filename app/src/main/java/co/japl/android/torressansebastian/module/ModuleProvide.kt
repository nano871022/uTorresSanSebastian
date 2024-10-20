package co.japl.android.torressansebastian.module

import android.app.Application
import android.content.Context
import co.com.japl.connect.gdrive.drive.GetFilesFromFolderShared
import co.com.japl.connect.gdrive.firebase.realtime.Realtime
import co.urtss.core.adapters.inbound.MessagePort
import co.urtss.core.adapters.inbound.PqrsPort
import co.urtss.core.adapters.outbound.MessageLocalPort
import co.urtss.core.adapters.outbound.dbHelper.DbHelper
import co.urtss.core.usercases.interfaces.IMessage
import co.urtss.core.usercases.interfaces.IPqrs
import com.google.firebase.database.FirebaseDatabase
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

    @Singleton
    @Provides
    fun provideGDrive(context:Context):GetFilesFromFolderShared{
        return GetFilesFromFolderShared(context)
    }

    @Singleton
    @Provides
    fun provideInboundPqrsPort(svc:IPqrs):PqrsPort{
        return PqrsPort(svc)
    }
    @Provides
    fun provideOutboundCarouselPort(context:Context,gDrive: GetFilesFromFolderShared,realtime:Realtime): co.urtss.core.adapters.outbound.CarouselPort{
        return co.urtss.core.adapters.outbound.CarouselPort(context,gDrive,realtime)
    }

    @Provides
    fun provideRealtimeFirebase(databaseFirebase:FirebaseDatabase):Realtime{
        return Realtime(databaseFirebase)
    }

    @Provides
    fun provideFirebaseRealtime():FirebaseDatabase{
        return FirebaseDatabase.getInstance()
    }

    @Provides
    fun provideMessagePort(svc:IMessage):MessagePort{
        return MessagePort(svc)
    }
    @Provides
    fun provideMessageLocalPort(dbH: DbHelper):MessageLocalPort{
        return MessageLocalPort(dbH)
    }

    @Provides
    fun provideDBHelper(context:Context):DbHelper{
        return DbHelper(context)
    }

}