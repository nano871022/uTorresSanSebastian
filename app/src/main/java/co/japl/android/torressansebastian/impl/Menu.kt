package co.japl.android.torressansebastian.impl

import android.content.Context
import co.japl.android.torressansebastian.interfaces.IMenuService
import co.japl.android.torressansebastian.model.MenuItem
import co.japl.android.torressansebastian.ui.settings.NavigationEnum


class MenuService (val context: Context): IMenuService {
    private val items = mutableListOf<MenuItem>()

    init{
        loadMenuDrawer()
    }

    override fun getItems():List<MenuItem>{
        return items
    }

    override fun addMenu(item: MenuItem) {
        items?.add(item)
    }


    private fun loadMenuDrawer(){
        NavigationEnum.values().filter { it.isInDrawer() }.forEach{
            addMenu(
                MenuItem(
                    it.getId()
                    ,context.resources.getString(it.getName())
                    , it.getIcon()
                    ,it.name
                    ,it.getRoute()
                )
            )
        }
    }
}