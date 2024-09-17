package co.urtss.core.usercases.impl

import co.urtss.core.adapters.outbound.GDrivePort
import co.urtss.core.model.Document
import co.urtss.core.usercases.interfaces.IDocument
import java.io.File
import javax.inject.Inject

class DocumentImpl @Inject constructor(private val gDrivePort: GDrivePort) : IDocument {
    override suspend fun getFiles(): List<Document> {
        return gDrivePort.getFiles().sortedByDescending { it.date }
    }

    override fun getFile(idFile: String): File? {
        return gDrivePort.downloadFile(idFile)
    }

}