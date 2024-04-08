package co.urtss.core.adapters.outbound

import android.content.Context
import co.urtss.core.R

class CarouselPort(private val context: Context) {
    fun getList(): List<Pair<String,Int>> {
        val resources = context.resources
        return R.drawable::class.java.fields
            .map {
                Pair(
                    it.name
                    ,resources.getIdentifier(it.name, "drawable", context.packageName))
            }
    }
}