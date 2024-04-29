package co.urtss.core.adapters.outbound

import android.content.Context
import android.util.Log
import co.com.japl.connect.gdrive.drive.GetFilesFromFolderShared
import co.com.japl.connect.gdrive.firebase.realtime.Realtime
import co.urtss.core.BuildConfig
import co.urtss.core.R
import co.urtss.core.enums.RealtimeDBKeys
import co.urtss.core.utils.NetworkUtils
import javax.inject.Inject

class CarouselPort @Inject constructor(private val context: Context, private val imagesSvc: GetFilesFromFolderShared, private val realtimeSvc:Realtime) {

    private val FOLDER_ID = BuildConfig.FOLDER_IMG_ID

    fun getList(): List<Pair<String,Int>> {
        val resources = context.resources
        return R.drawable::class.java.fields
            .map {
                Log.d("CarouselPort","=== GetList::Name: ${it.name}")
                Pair(
                    it.name
                    ,resources.getIdentifier(it.name, "drawable", context.packageName))
            }
    }

    suspend fun getListUrl():List<Pair<String,String>>{
        val list = mutableListOf<Pair<String,String>>()
        if(NetworkUtils.isNetworkAvailable(context)) {
            var folder = FOLDER_ID

            realtimeSvc.connect(RealtimeDBKeys.FOLDER_IMG.toString().lowercase())
                    .collect{ data->
                        data?.let {
                            Log.d("CarouselPort", "==Get Value  $it")
                            folder = it
                        }
                    } ?: FOLDER_ID
                Log.d("CarouselPort","Folder: $folder")
                 imagesSvc.execute(R.raw.torressansebastian_bf1036b1e939, folder = folder)
                    ?.takeIf { it.isNotEmpty() }?.forEach {
                        list.add(Pair(it.name, it.url))
                    }
        }
        return list
    }


}