package co.japl.android.torressansebastian.ui.settings.drawer

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
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
import co.com.japl.ui.theme.MaterialThemeComposeUI
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
Column {
    ModalDrawerSheet(
        modifier = Modifier.width(300.dp)
    ) {

        DrawerHeader()

        Spacer(Modifier.height(12.dp))

        DrawerMenu(
            navController = navController, menuSvc = menuSvc, scope = scope, state = state
        )

    }
}
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO, showSystemUi = true, device="id:5.4in FWVGA" )
fun preview(){
    val context = LocalContext.current
    val state = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val menuSvc = MenuService(LocalContext.current)

    val navController = NavController(context)
    MaterialThemeComposeUI {
        DrawerMain(navController, menuSvc, scope, state)
    }
}

@Composable
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES, showSystemUi = true, device="id:5.4in FWVGA" )
fun previewDark(){
    val context = LocalContext.current
    val state = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val menuSvc = MenuService(LocalContext.current)

    val navController = NavController(context)
    MaterialThemeComposeUI {
        DrawerMain(navController, menuSvc, scope, state)
    }
}