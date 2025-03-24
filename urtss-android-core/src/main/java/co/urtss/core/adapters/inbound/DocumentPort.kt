package co.urtss.core.adapters.inbound

import co.urtss.core.adapters.interfacces.inbound.IDocumentPort
import co.urtss.core.model.Document
import co.urtss.core.usercases.interfaces.IDocument
import java.io.File
import javax.inject.Inject

class DocumentPort @Inject constructor(private val gdriveSvc: IDocument) : IDocumentPort{

   override suspend fun getDocuments(): List<Document> {
        return gdriveSvc.getFiles()
    }

    override fun getFile(idFile: String): File?{
        return gdriveSvc.getFile(idFile)
    }

}