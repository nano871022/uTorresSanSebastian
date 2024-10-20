package co.japl.android.torressansebastian.ui.settings.drawer

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import co.com.japl.ui.theme.MaterialThemeComposeUI
import co.japl.android.torressansebastian.impl.MenuService
import co.japl.android.torressansebastian.interfaces.IMenuService
import co.japl.android.torressansebastian.ui.settings.NavigationEnum
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DrawerMenu(navController: NavController
               ,menuSvc:IMenuService
               ,scope:CoroutineScope
                ,state:DrawerState
, drawerMenu: DrawerMenuViewModel = DrawerMenuViewModel(menuSvc)
){
    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = currentBackStackEntry?.destination?.route ?: NavigationEnum.Home.getRoute()
    Column(modifier= Modifier
        .padding(top = 20.dp)
        .verticalScroll(rememberScrollState())) {
        drawerMenu.items.sortedBy { it.id }.forEach { item->
            DefaultItemMenu(painter = painterResource(id = item.icon)
                , description = item.description
                , name = item.name
                , route = item.route
                , currentRoute = currentRoute
                , state = state
                , navController = navController
                , scope = scope)
        }
    }
}


@Composable
private fun DefaultItemMenu(painter: Painter,name:String, description:String,route: String ,currentRoute:String,state:DrawerState,scope:CoroutineScope,navController: NavController){
        NavigationDrawerItem(label = {
            Text(text = name,
                modifier = Modifier.fillMaxWidth())
        },
            icon = {
                Icon(painter = painter
                    , contentDescription = description
                    , modifier = Modifier.padding(end = 15.dp))
            },
            selected = route == currentRoute,
            onClick = {
                scope.launch {
                    state.close()
                }
                navController.navigate(route){
                    popUpTo(route)
                    launchSingleTop = true
                    restoreState = true
                }            })
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview( showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
fun PreviewDrawer(){
    val menuSvc = MenuService(LocalContext.current)
    val state = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    MaterialThemeComposeUI {
        ModalDrawerSheet {
            DrawerMenu(
                NavController(LocalContext.current), menuSvc, scope, state
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview(  showSystemUi = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
fun PreviewDrawerDark(){
    val menuSvc = MenuService(LocalContext.current)
    val state = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    MaterialThemeComposeUI {
        ModalDrawerSheet {
            DrawerMenu(
                NavController(LocalContext.current), menuSvc, scope, state
            )
        }
    }
}