package co.urtss.core.adapters.interfacces.inbound

import co.urtss.core.model.Document
import java.io.File

interface IDocumentPort {
    suspend fun getDocuments(): List<Document>
    fun getFile(idFile: String): File?
}