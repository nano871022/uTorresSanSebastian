package co.japl.android.torressansebastian.ui.view

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import co.japl.android.torressansebastian.R
import co.japl.android.torressansebastian.impl.MenuService
import co.japl.android.torressansebastian.interfaces.IMenuService
import co.japl.android.torressansebastian.model.MenuItem
import co.japl.android.torressansebastian.ui.settings.NavigationEnum
import co.japl.android.torressansebastian.ui.settings.Navigator
import co.japl.android.torressansebastian.ui.settings.bottombar.BottomBar
import co.japl.android.torressansebastian.ui.settings.drawer.DrawerMain
import co.japl.android.torressansebastian.ui.settings.topbar.TopBar

@RequiresApi(Build.VERSION_CODES.R)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainView(menuSvc: IMenuService){
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val navController = rememberNavController()
    val scope = rememberCoroutineScope()
    val context = LocalContext.current

    ModalNavigationDrawer(
        drawerState =  drawerState,
        drawerContent = {
            DrawerMain(navController = navController
                , menuSvc = menuSvc
            , scope = scope
            , state = drawerState)
    }) {
    Scaffold(
            topBar = { TopBar(navController, drawerState) },
            bottomBar = { BottomBar(navController = navController) },
        ) {
            Navigator(
                navController = navController
                , modifier = Modifier.padding(it)
                , context = context

            )
        }
    }
}
@RequiresApi(Build.VERSION_CODES.R)
@Composable
@Preview(showBackground = true, showSystemUi = true)
fun Preview(){
    val menuSvc = MenuService()
    menuSvc.addMenu(
        MenuItem(1
            ,"Home"
            ,  R.drawable.baseline_home_24
            ,"Home"
            , NavigationEnum.Location.name
        )
    )
    menuSvc.addMenu(
        MenuItem(id=2
        ,name="Pets"
        ,icon= R.drawable.ic_baseline_pets_24
        ,description="Pets"
        ,route= NavigationEnum.PetsOwnerShip.name
    )
    )

    MainView(menuSvc)
}