package co.japl.android.torressansebastian.impl

import co.japl.android.torressansebastian.interfaces.IMenuService
import co.japl.android.torressansebastian.model.MenuItem
import co.japl.android.torressansebastian.ui.settings.NavigationEnum


class MenuService : IMenuService {
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
                    ,it.name
                    , it.getIcon()
                    ,it.name
                    ,it.getRoute()
                )
            )
        }
    }
}