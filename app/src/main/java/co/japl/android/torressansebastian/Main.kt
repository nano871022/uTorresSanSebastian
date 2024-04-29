package co.japl.android.torressansebastian

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import co.com.japl.ui.theme.MaterialThemeComposeUI
import co.japl.android.torressansebastian.impl.MenuService
import co.japl.android.torressansebastian.interfaces.IMenuService
import co.japl.android.torressansebastian.ui.view.MainView
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class Main : ComponentActivity() {

    private lateinit var menuSvc: IMenuService

    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.actionBar?.hide()
        menuSvc = MenuService(context = this)

        setContent{
            MaterialThemeComposeUI {
                MainView(menuSvc)
            }
        }
    }
}