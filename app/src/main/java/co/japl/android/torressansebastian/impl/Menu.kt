package co.japl.android.torressansebastian.impl

import co.japl.android.torressansebastian.interfaces.IMenuService
import co.japl.android.torressansebastian.model.MenuItem


class MenuService : IMenuService {
    private val items = mutableListOf<MenuItem>()

    override fun getItems():List<MenuItem>{
        return items
    }

    override fun addMenu(item: MenuItem) {
        items?.add(item)
    }

}