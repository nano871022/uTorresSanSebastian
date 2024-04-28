package co.urtss.core.adapters.outbound

import android.content.Context

import co.com.japl.connect.gdrive.drive.GetFilesFromFolderShared
import co.com.japl.connect.gdrive.firebase.realtime.Realtime
import co.urtss.core.BuildConfig
import co.urtss.core.R
import co.urtss.core.utils.NetworkUtils
import javax.inject.Inject

class CarouselPort @Inject constructor(private val context: Context, private val imagesSvc: GetFilesFromFolderShared, private val realtimeSvc:Realtime) {

    private val FOLDER_ID = BuildConfig.FOLDER_IMG_ID

    fun getList(): List<Pair<String,Int>> {
        val resources = context.resources
        return R.drawable::class.java.fields
            .map {
                Pair(
                    it.name
                    ,resources.getIdentifier(it.name, "drawable", context.packageName))
            }
    }

    fun getListUrl():List<Pair<String,String>>{
        if(NetworkUtils.isNetworkAvailable(context)) {
            realtimeSvc.connect()
            return imagesSvc.execute(R.raw.torressansebastian_bf1036b1e939, folder = FOLDER_ID)
                ?.takeIf { it.isNotEmpty() }?.map {
                Pair(it.name, it.url)
            } ?: emptyList()
        }
        return emptyList()
    }


}