package co.urtss.core.adapters.outbound

import co.com.japl.connect.gdrive.drive.GetFilesFromFolderShared
import co.urtss.core.R
import co.urtss.core.model.Document
import java.io.File
import javax.inject.Inject

class GDrivePort @Inject constructor(private val getFilesFromFolderShared:GetFilesFromFolderShared) {

    fun getFiles():List<Document>{
        val files =  getFilesFromFolderShared.execute(resId = R.raw.torressansebastian_bf1036b1e939)
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