package co.japl.android.torressansebastian.ui.settings.bottombar

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import co.japl.android.torressansebastian.R
import co.japl.android.torressansebastian.ui.settings.NavigationEnum


@Composable
fun BottomBar(navController: NavController){
    val currentRoute = navController.currentDestination?.route
    BottomNavigation {
        Home(navController,currentRoute,this)

        Call(currentRoute, rowScope = this)

        WhatSap( currentRoute = currentRoute, rowScope = this)

        Email(currentRoute,this)

        WebSite( currentRoute = currentRoute, rowScope = this)
    }
}

@Composable
private fun WebSite(currentRoute: String?,rowScope: RowScope){
    val context = LocalContext.current
    val url = stringResource(id = R.string.url_website)
    DefaultButton(row = rowScope
        , name = "WebSite"
        , icon = painterResource(id = R.drawable.ic_action_www)
        , currentRoute = currentRoute) {
        Intent(Intent.ACTION_VIEW, Uri.parse(url)).apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
           context.startActivity(this)
        }
    }
}


@Composable
private fun WhatSap(currentRoute: String?,rowScope: RowScope){
    val adminNumber = stringResource(id = R.string.administration_number)
    val urlAdminWhatsap = stringResource(id = R.string.url_whatsap)
    val context = LocalContext.current
    DefaultButton(row = rowScope
        , name = "WhatSap"
        , icon = painterResource(id = R.drawable.whatsap_7272)
        , currentRoute = currentRoute) {
        Intent(Intent.ACTION_VIEW, Uri.parse(urlAdminWhatsap + adminNumber.trim()+"/")).apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(this)
        }
    }
}
@Composable
private fun Call(currentRoute: String?,rowScope: RowScope){
    val number = stringResource(id = R.string.administration_number).trim()
    val context = LocalContext.current
    DefaultButton(row = rowScope
        , name = "Call"
        , icon = painterResource(id = R.drawable.ic_baseline_call_24)
        , currentRoute = currentRoute) {
           Intent(Intent.ACTION_DIAL, Uri.parse("tel:$number")).apply {
               addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
               context.startActivity(this)

           }
        }
}

@Composable
private fun Email(currentRoute: String?,rowScope: RowScope){
    val email = stringResource(id = R.string.administration_email)
    val context = LocalContext.current
    DefaultButton(row = rowScope
        , name = "Email"
        , icon = painterResource(id = R.drawable.ic_baseline_email_24)
        , currentRoute = currentRoute) {
        Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:$email")).apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            putExtra(Intent.EXTRA_EMAIL,"Buenos Dias")
            putExtra(Intent.EXTRA_CC,email)
            putExtra(Intent.EXTRA_SUBJECT,"Asunto")
            val intentEnd = Intent.createChooser(this,"Send Email Using:")
            context.startActivity(intentEnd)
        }
    }
}

@Composable
private fun Home(navController: NavController,currentRoute:String?,rowScope: RowScope){
    DefaultButton(row = rowScope, name = "Home"
        , icon = painterResource(id = R.drawable.baseline_home_24)
        , currentRoute = currentRoute) {
        navController.navigate(NavigationEnum.Home.name)
    }
}

@Composable
private fun DefaultButton(row: RowScope, name:String, icon: Painter, currentRoute:String?, onClick:()->Unit){
    row.BottomNavigationItem(
        label={
            Text(text = name)
        },alwaysShowLabel = false
        ,selected = currentRoute == name
        ,icon = { Icon(painter=icon,contentDescription = name)}
        ,onClick = {
            onClick.invoke()
        }
    )
}


@Composable
@Preview(showBackground = true, showSystemUi = true)
fun Preview(){
    BottomBar(NavController(LocalContext.current))
}