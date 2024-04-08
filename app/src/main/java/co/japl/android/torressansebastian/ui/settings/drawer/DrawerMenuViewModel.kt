package co.japl.android.torressansebastian.ui.settings.drawer

import androidx.lifecycle.ViewModel
import co.japl.android.torressansebastian.interfaces.IMenuService
import co.japl.android.torressansebastian.model.MenuItem

class DrawerMenuViewModel constructor(menuService: IMenuService) : ViewModel(){

    private val _items = menuService.getItems()
    val items : List<MenuItem> get() =  _items


}