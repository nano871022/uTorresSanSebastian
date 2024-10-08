package co.japl.android.torressansebastian.ui.settings.topbar

import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.TopAppBar
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import co.com.japl.ui.theme.MaterialThemeComposeUI
import co.japl.android.torressansebastian.R
import co.japl.android.torressansebastian.ui.settings.NavigationEnum
import co.japl.android.torressansebastian.ui.settings.menuoptions.MenuOptions
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(navController: NavController,drawerState: DrawerState,expanderRemember: MutableState<Boolean> = remember { mutableStateOf(false) }){
    TopAppBar(
        title = {
            ClickableText(text = buildAnnotatedString {
               append(stringResource(id = R.string.app_name))
            },onClick={
                navController.navigate(NavigationEnum.Home.name)
            }, style = TextStyle( color = MaterialTheme.colorScheme.onSecondary))
        }
        , backgroundColor = MaterialTheme.colorScheme.secondary
        , contentColor = MaterialTheme.colorScheme.onSecondary
        , navigationIcon = {
            MenuDrawable(drawerState = drawerState)
        }
    , actions = {
            Payment(navController)

            ContactUs(navController = navController)

            Schedule(navController)

            IconButton(onClick = {
                expanderRemember.value = expanderRemember.value.not()
            }) {
                Icon(
                    painter = painterResource(id = R.drawable.baseline_more_vert_24)
                    , contentDescription = "more")
            }

            MenuOptions(expanderRemember){
                navController.navigate(it)
            }
        })
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun MenuDrawable(drawerState: DrawerState){
    val coroutineScope = rememberCoroutineScope()
    DefaultIconUp(icon = painterResource(id = R.drawable.baseline_menu_24)
        , description = "Menu") {
            coroutineScope.launch {
                drawerState.open()
            }
    }
}

@Composable
private fun Payment(navController: NavController){
    DefaultIconUp(icon = painterResource(id = R.drawable.ic_baseline_attach_money_24)
        , description = stringResource(id = R.string.administration_pay)) {
        navController.navigate(NavigationEnum.AdministationPayment.name)
    }
}

@Composable
private fun ContactUs(navController: NavController) {
    DefaultIconUp(
        icon = painterResource(id = R.drawable.ic_baseline_complains),
        description = stringResource(id = R.string.title_contact_us)
    ) {
        navController.navigate(NavigationEnum.ContactUs.name)
    }
}

@Composable
private fun Schedule(navController: NavController){
    DefaultIconUp(icon = painterResource(id = R.drawable.ic_baseline_calendar_month_24)
        , description = stringResource(id = R.string.schedule)) {
        navController.navigate(NavigationEnum.Schedule.name)
    }
}

@Composable
private fun DefaultIconUp(icon:Painter,description:String,onClick:()->Unit){
    IconButton(onClick = {
        onClick.invoke()
    }) {
        Icon(
            painter = icon,
            contentDescription = description
        )
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview(showSystemUi = false, showBackground = true)
fun Preview(){
    MaterialThemeComposeUI {
        TopBar(NavController(LocalContext.current), DrawerState(DrawerValue.Closed) {
            false
        }
        )
    }
}