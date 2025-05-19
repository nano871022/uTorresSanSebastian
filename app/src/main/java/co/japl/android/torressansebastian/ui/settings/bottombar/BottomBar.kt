package co.japl.android.torressansebastian.ui.settings.bottombar

import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.DropdownMenu
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import co.com.japl.ui.theme.MaterialThemeComposeUI
import co.japl.android.torressansebastian.R
import co.japl.android.torressansebastian.ui.settings.NavigationEnum


@Composable
fun BottomBar(navController: NavController){
    val currentRoute = navController.currentDestination?.route
    BottomNavigation(
         backgroundColor = MaterialTheme.colorScheme.secondary
        , contentColor = MaterialTheme.colorScheme.onSecondary
    ) {
        Home(navController,currentRoute,this)

        Call(currentRoute, rowScope = this)

        WhatSap( currentRoute = currentRoute, rowScope = this)

        Email(currentRoute,this)

        Messages( currentRoute = currentRoute, rowScope = this,navController = navController)
    }
}

@Composable
private fun Messages(currentRoute: String?,rowScope: RowScope,navController: NavController){
    DefaultButton(row = rowScope
        , name = "WebSite"
        , icon = painterResource(id = NavigationEnum.Messages.getIcon())
        , currentRoute = currentRoute) {
            navController.navigate(NavigationEnum.Messages.getRoute())
        }
    }



@Composable
private fun WhatSap(currentRoute: String?,rowScope: RowScope){
    val adminNumber = stringResource(id = R.string.administration_number)
    val urlAdminWhatsap = stringResource(id = R.string.url_whatsap)
    val context = LocalContext.current
    DefaultButton(row = rowScope
        , name = "WhatSap"
        , icon = painterResource(id = R.drawable.ic_action_whatsap)
        , currentRoute = currentRoute) {
        Intent(Intent.ACTION_VIEW, Uri.parse(urlAdminWhatsap + adminNumber.trim()+"/")).apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(this)
        }
    }
}
@Composable
private fun Call(currentRoute: String?,rowScope: RowScope){
    val callOptionsStatus = remember { mutableStateOf(false) }
    DefaultButton(row = rowScope
        , name = "Call"
        , icon = painterResource(id = R.drawable.ic_baseline_call_24)
        , currentRoute = currentRoute) {callOptionsStatus.value = true}

    callDropMenu(state = callOptionsStatus)
}

@Composable
private fun callDropMenu(state: MutableState<Boolean>){
    val context = LocalContext.current
    val administrationNum = stringResource(id = R.string.administration_number)
    val adminNum = stringResource(id = R.string.phone_numbr)
    val entranceNum = stringResource(id = R.string.administration_number)
    DropdownMenu(expanded = state.value, onDismissRequest = { state.value = false }) {
        DropdownMenuItem(text = { Text(text = stringResource(id = R.string.phone_number)) },
            leadingIcon = { Icon(painter = painterResource(id = R.drawable.ic_baseline_call_24),contentDescription = "Call") },
            onClick = { callNumber(adminNum,context) })
        DropdownMenuItem(text = { Text(text = stringResource(id = R.string.admin_number)) },
            leadingIcon = { Icon(painter = painterResource(id = R.drawable.ic_baseline_call_24),contentDescription = "Call") },
            onClick = { callNumber(administrationNum,context) })
        DropdownMenuItem(text = { Text(text = stringResource(id = R.string.entrance_nbr)) },
            leadingIcon = { Icon(painter = painterResource(id = R.drawable.ic_baseline_call_24),contentDescription = "Call") },
            onClick = { callNumber(entranceNum,context) })
        
    }
}

private fun callNumber(number:String,context:Context){
    Intent(Intent.ACTION_DIAL, Uri.parse("tel:$number")).apply {
        addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        context.startActivity(this)
    }
}

@Composable
private fun Email(currentRoute: String?,rowScope: RowScope){
    val emailOptionsStatus = remember { mutableStateOf(false) }
    DefaultButton(row = rowScope
        , name = "Email"
        , icon = painterResource(id = R.drawable.ic_baseline_email_24)
        , currentRoute = currentRoute) {
        emailOptionsStatus.value = true
    }
    emailDropMenu(state = emailOptionsStatus)
}

@Composable
private fun emailDropMenu(state: MutableState<Boolean>){
    val context = LocalContext.current
    val adminEmail = stringResource(id = R.string.administration_email)
    val auxEmail = stringResource(id = R.string.auxiliar_email)
    val counsilEmail = stringResource(id = R.string.consejo_email)

    DropdownMenu(expanded = state.value, onDismissRequest = { state.value = false }) {
        DropdownMenuItem(
            text = { Text(text = stringResource(id = R.string.admin_email)) },
            leadingIcon = {Icon(painter = painterResource(id = R.drawable.ic_baseline_email_24),contentDescription = "Email")},
            onClick = { sentEmail(adminEmail,context) })

        DropdownMenuItem(
            text = { Text(text = stringResource(id = R.string.aux_email)) },
            leadingIcon = {Icon(painter = painterResource(id = R.drawable.ic_baseline_email_24),contentDescription = "Email")},
            onClick = { sentEmail(auxEmail,context) })

        DropdownMenuItem(
            text = { Text(text = stringResource(id = R.string.consejo_email_label)) },
            leadingIcon = {Icon(painter = painterResource(id = R.drawable.ic_baseline_email_24),contentDescription = "Email")},
            onClick = { sentEmail(counsilEmail,context) })

        DropdownMenuItem(
            text = { Text(text = stringResource(id = R.string.presindente_consejo_label)) },
            leadingIcon = {Icon(painter = painterResource(id = R.drawable.ic_baseline_email_24),contentDescription = "Email")},
            onClick = { sentEmail(counsilEmail,context) })

    }
}

private fun sentEmail(email:String,context: Context){
    Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:$email")).apply {
        addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        putExtra(Intent.EXTRA_EMAIL,"Buenos Dias")
        putExtra(Intent.EXTRA_CC,email)
        putExtra(Intent.EXTRA_SUBJECT,context.getString(R.string.subject_email))
        val intentEnd = Intent.createChooser(this,"Send Email Using:")
        context.startActivity(intentEnd)
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
@Preview(showBackground = true, showSystemUi = false)
fun Preview(){
    MaterialThemeComposeUI {
        BottomBar(NavController(LocalContext.current))
    }
}