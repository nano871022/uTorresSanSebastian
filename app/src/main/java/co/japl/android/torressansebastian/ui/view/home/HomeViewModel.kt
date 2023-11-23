package co.japl.android.torressansebastian.ui.view.home

import android.content.Context
import android.util.Log
import androidx.core.text.isDigitsOnly
import androidx.lifecycle.ViewModel
import co.japl.android.torressansebastian.R

class HomeViewModel(context:Context) : ViewModel() {
    private lateinit var  _listDefaultDrawable : List<Int>
    val list:List<Int> get() = _listDefaultDrawable

    init{
        Log.d("HomeViewModel","init")
        val resources = context.resources
        _listDefaultDrawable = R.drawable::class.java.fields
            .filter { it.name.contains("whatsapp") }
            .sortedBy {
                val lastNmbr = it.name.substring(it.name.length-2)
                if(lastNmbr.isNotBlank() && lastNmbr.isDigitsOnly()){
                    return@sortedBy lastNmbr
                }else{
                    return@sortedBy it.name
                }
            }
            .mapNotNull {
                resources.getIdentifier(it.name, "drawable", context.packageName)
            }
        Log.d("HomeViewModel","ImgSize: ${_listDefaultDrawable.size}")
    }

}