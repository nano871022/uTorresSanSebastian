package co.urtss.core.adapters.inbound

import co.urtss.core.model.Document
import co.urtss.core.usercases.interfaces.IDocument
import java.io.File
import javax.inject.Inject

class DocumentPort @Inject constructor(private val gdriveSvc: IDocument) {

    fun getDocuments(): List<Document> {
        return gdriveSvc.getFiles()
    }

    fun getFile(idFile: String): File?{
        return gdriveSvc.getFile(idFile)
    }

}