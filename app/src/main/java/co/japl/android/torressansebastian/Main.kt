package co.japl.android.torressansebastian

import android.os.Build
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import co.japl.android.torressansebastian.impl.MenuService
import co.japl.android.torressansebastian.interfaces.IMenuService
import co.japl.android.torressansebastian.model.MenuItem
import co.japl.android.torressansebastian.ui.settings.NavigationEnum
import co.japl.android.torressansebastian.ui.view.MainView

class Main : AppCompatActivity() {

    private val menuSvc: IMenuService = MenuService()

    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.actionBar?.hide()
        loadMenuDrawer()
        setContent{
            MainView(menuSvc)
        }
    }

    private fun loadMenuDrawer(){
        NavigationEnum.values().filter { it.isInDrawer() }.forEach{
            menuSvc.addMenu(
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