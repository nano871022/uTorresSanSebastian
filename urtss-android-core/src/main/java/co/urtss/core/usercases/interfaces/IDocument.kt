package co.urtss.core.usercases.interfaces

import co.urtss.core.model.Document
import java.io.File

interface IDocument {

    fun getFiles():List<Document>

    fun getFile(idFile:String):File?
}