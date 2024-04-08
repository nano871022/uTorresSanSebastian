package co.japl.android.torressansebastian.interfaces

import co.japl.android.torressansebastian.model.MenuItem

interface IMenuService {

    fun getItems():List<MenuItem>

    fun addMenu(item: MenuItem)
}