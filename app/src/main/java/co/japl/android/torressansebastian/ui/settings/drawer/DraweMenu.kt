package co.japl.android.torressansebastian.ui.settings.drawer

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import co.japl.android.torressansebastian.impl.MenuService
import co.japl.android.torressansebastian.interfaces.IMenuService
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
    Column(modifier=Modifier.padding(top=20.dp)){
        drawerMenu.items.sortedBy { it.id }.forEach { item->
            DefaultItemMenu(painter = painterResource(id = item.icon)
                , description = item.description
                , name = item.name){
                scope.launch {
                    state.close()
                }
                navController.navigate(item.route){
                    popUpTo(item.route)
                    launchSingleTop = true
                    restoreState = true
                }
            }
        }
    }
}


@Composable
private fun DefaultItemMenu(painter: Painter,name:String, description:String,onClick:()->Unit){
    Row(
        modifier= Modifier
            .padding(15.dp)
            .clickable { onClick.invoke() }
        , verticalAlignment = Alignment.CenterVertically
    ){

        Icon(painter = painter
            , contentDescription = description
            , modifier = Modifier.padding(end = 15.dp))

        Text(text = name)
    }

    Divider()

}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview(showBackground = true, showSystemUi = false)
fun PreviewDrawer(){
    val menuSvc = MenuService()
    val state = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    DrawerMenu(NavController(LocalContext.current)
        , menuSvc
        ,scope
        ,state
        )
}