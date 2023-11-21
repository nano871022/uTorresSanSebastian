package co.japl.android.torressansebastian

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import co.com.jap.ui.theme.MaterialThemeComposeUI
import co.japl.android.torressansebastian.impl.MenuService
import co.japl.android.torressansebastian.interfaces.IMenuService
import co.japl.android.torressansebastian.ui.view.MainView

class Main : ComponentActivity() {

    private val menuSvc: IMenuService = MenuService()

    @RequiresApi(Build.VERSION_CODES.R)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.actionBar?.hide()
        setContent{
            MaterialThemeComposeUI {
                MainView(menuSvc)
            }
        }
    }



}