package co.japl.android.torressansebastian.ui.settings.menuoptions

import android.content.Intent
import android.content.res.Configuration
import android.net.Uri
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.TopAppBar
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import co.com.japl.ui.theme.MaterialThemeComposeUI
import co.japl.android.torressansebastian.R
import co.japl.android.torressansebastian.ui.settings.NavigationEnum

@JvmOverloads
@Composable
fun MenuOptions(expanderRemember:MutableState<Boolean> ,onClick: (String) -> Unit){
  DropdownMenu(expanded = expanderRemember.value,
      onDismissRequest = {
      expanderRemember.value = expanderRemember.value.not()
  }) {
      Column(
          modifier = Modifier.fillMaxSize()
          , horizontalAlignment = Alignment.CenterHorizontally
          , verticalArrangement = Arrangement.Center
      ) {

          MenuItem(menuItem = R.string.web_ur
              , iconDrawer = R.drawable.ic_action_www
              , url = stringResource(id = R.string.url_website)
              , expanderRemember = expanderRemember
          )

          MenuItem(menuItem = R.string.web_app
              , iconDrawer = R.drawable.ic_action_www
              , url = stringResource(id = R.string.url_app)
              , expanderRemember = expanderRemember
          )

            MenuItem(menuItem = R.string.about_by
                , iconDrawer = NavigationEnum.AboutBy.getIcon()
                , route = NavigationEnum.AboutBy.getRoute()
                , expanderRemember = expanderRemember
                , onClick =onClick
                )
      }
  }
}

@Composable
private fun MenuItem(@StringRes menuItem:Int, @DrawableRes iconDrawer:Int, route:String, expanderRemember: MutableState<Boolean>, onClick:(String)->Unit){
    DropdownMenuItem(text = {
            Text(text = stringResource(id = menuItem))
    }
        , leadingIcon = {
            Icon(painter = painterResource(id = iconDrawer)
                , contentDescription = stringResource(id = menuItem))
        }
        , onClick = {
            onClick.invoke(route)
            expanderRemember.value = expanderRemember.value.not()
        })
}

@Composable
private fun MenuItem(@StringRes menuItem:Int, @DrawableRes iconDrawer:Int, url:String, expanderRemember: MutableState<Boolean>){
    val context = LocalContext.current
    DropdownMenuItem(text = {
        Row(
            modifier = Modifier.fillMaxSize()
        ){
            Icon(painter = painterResource(id = iconDrawer)
                , contentDescription = stringResource(id = menuItem))
            Text(text = stringResource(id = menuItem))
        }
    }
        , onClick = {
            expanderRemember.value = expanderRemember.value.not()
            Intent(Intent.ACTION_VIEW, Uri.parse(url.trim()+"/")).apply {
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                context.startActivity(this)
            }
        })
}

@Composable
@Preview( uiMode = Configuration.UI_MODE_NIGHT_NO)
fun PreviewMenuOptions(){
    val state = remember{mutableStateOf(true)}
    MaterialThemeComposeUI {
        TopAppBar (
            title = {Text(text = stringResource(id = R.string.app_name))},
            actions = {
                MenuOptions(state) {

                }
            })
    }
}
@Composable
@Preview( uiMode = Configuration.UI_MODE_NIGHT_YES)
fun PreviewMenuOptionsDark(){
    val state = remember{mutableStateOf(true)}
    MaterialThemeComposeUI {
        TopAppBar (
            title = {Text(text = stringResource(id = R.string.app_name))},
            actions = {
                MenuOptions(state){}
            }
        )

    }
}
