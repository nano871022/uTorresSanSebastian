package co.japl.android.torressansebastian.ui.settings.menuoptions

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import co.com.japl.ui.theme.MaterialThemeComposeUI
import co.japl.android.torressansebastian.R
import co.japl.android.torressansebastian.ui.settings.NavigationEnum

@JvmOverloads
@Composable
fun MenuOptions(expanderRemember:MutableState<Boolean> ,onClick: (String) -> Unit){
  DropdownMenu(expanded = expanderRemember.value, onDismissRequest = {
      expanderRemember.value = expanderRemember.value.not()
  }) {
      Column(
          modifier = Modifier.fillMaxSize()
          , horizontalAlignment = Alignment.CenterHorizontally
          , verticalArrangement = Arrangement.Center
      ) {
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
        Row(
            modifier = Modifier.fillMaxSize()
        ){
            Icon(painter = painterResource(id = iconDrawer)
                , contentDescription = stringResource(id = menuItem))
            Text(text = stringResource(id = menuItem))
        }
    }
        , onClick = {
            onClick.invoke(route)
            expanderRemember.value = expanderRemember.value.not()
        })
}

@Composable
@Preview(showSystemUi = true, showBackground = true)
fun PreviewMenuOptions(){
    MaterialThemeComposeUI {
        MenuOptions(remember{ mutableStateOf(false) }){

        }
    }
}
