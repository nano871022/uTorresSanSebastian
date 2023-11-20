package co.japl.android.torressansebastian.ui.settings.drawer

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import co.japl.android.torressansebastian.impl.MenuService
import co.japl.android.torressansebastian.interfaces.IMenuService
import kotlinx.coroutines.CoroutineScope

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DrawerMain(navController: NavController
               ,menuSvc:IMenuService
                , scope: CoroutineScope
                , state: DrawerState
){
    ModalDrawerSheet(
        modifier = Modifier.width(300.dp)
    ) {

        DrawerHeader()

        Spacer(Modifier.height(12.dp))

        DrawerMenu(navController = navController
            , menuSvc = menuSvc
            , scope = scope
            , state = state
        )

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun Preview(){
    val context = LocalContext.current
    val state = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val menuSvc = MenuService()

    val navController = NavController(context)
    DrawerMain(navController,menuSvc,scope,state)
}