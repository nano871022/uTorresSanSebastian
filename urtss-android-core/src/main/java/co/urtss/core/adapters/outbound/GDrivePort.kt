package co.urtss.core.adapters.outbound

import android.util.Log
import co.com.japl.connect.gdrive.drive.GetFilesFromFolderShared
import co.com.japl.connect.gdrive.firebase.realtime.Realtime
import co.urtss.core.BuildConfig
import co.urtss.core.R
import co.urtss.core.enums.RealtimeDBKeys
import co.urtss.core.model.Document
import java.io.File
import javax.inject.Inject

class GDrivePort @Inject constructor(private val getFilesFromFolderShared:GetFilesFromFolderShared, val realtimeSvc:Realtime) {
    private val FOLDER_ID = BuildConfig.FOLDER_ID

    suspend fun getFiles():List<Document>{
        var folder = FOLDER_ID
        realtimeSvc.connect(RealtimeDBKeys.FOLDER_DOCS.toString().lowercase()).collect{
            it?.let {
                folder = it
                Log.d("GDrivePort", "==Get Value  $it")
            }
        }
        val files =  getFilesFromFolderShared.execute(resId = R.raw.torressansebastian_bf1036b1e939, folder)
        return files?.takeIf { it.isNotEmpty() }?.map{
            Document(
                id=it.id,
                name = it.name,
                url = it.url,
                date = it.date,
                version = it.version,
                mimeType = it.mimeType,
                description = it.description
            )
        }?:emptyList()
    }

    fun downloadFile(idFile:String): File?{
        return getFilesFromFolderShared.downloadFile(idFile, R.raw.torressansebastian_bf1036b1e939)

    }

}