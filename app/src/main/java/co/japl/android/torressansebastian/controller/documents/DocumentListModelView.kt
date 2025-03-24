package co.japl.android.torressansebastian.controller.documents

import android.app.Application
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.Toast
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import co.japl.android.torressansebastian.R
import co.japl.android.torressansebastian.module.EntryPointModule
import co.urtss.core.adapters.interfacces.inbound.IDocumentPort
import co.urtss.core.model.Document
import dagger.hilt.EntryPoints
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@dagger.hilt.android.lifecycle.HiltViewModel
class DocumentListModelView @Inject constructor(private val application:Application?): AndroidViewModel(application!!) {

    private var documentSvc:IDocumentPort ?= EntryPoints.get(application, EntryPointModule::class.java).getIDocumentPort()

    private val _progress = mutableFloatStateOf(0f)
    private val _loader = mutableStateOf(true)
    private val _list = mutableStateListOf<Document>()
    val list get() = _list
    val loader get() = _loader
    val progress get() = _progress

    fun descargar(doc:Document,context:Context){
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(doc.url))
        context.startActivity(intent).also {
            Toast.makeText(context, context.getString(R.string.download_file_name, doc.name),Toast.LENGTH_SHORT).show()
        }
    }


    fun main() = runBlocking {
        _progress.floatValue = 0.1f
        execution()
        _progress.floatValue = 1f
    }



    suspend fun execution(){
        _progress.floatValue = 0.2f
        documentSvc?.getDocuments()?.let {
            _progress.floatValue = 0.7f
            _list.clear()
            _list.addAll(it)
            _progress.floatValue = 0.8f
            _loader.value = false
        }
        _progress.floatValue = 0.9f
    }
}