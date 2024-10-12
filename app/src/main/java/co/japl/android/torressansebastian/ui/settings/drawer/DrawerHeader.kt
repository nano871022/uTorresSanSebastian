package co.japl.android.torressansebastian.ui.settings.drawer

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.com.japl.ui.theme.MaterialThemeComposeUI
import co.japl.android.torressansebastian.R

@Composable
fun DrawerHeader(){
    Column(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.secondary)
            .padding(top = 80.dp)
            .width(300.dp)


    ){
        Row (
            horizontalArrangement = Arrangement.Center
            ,modifier = Modifier.fillMaxWidth()
        ){
            Image(painter = painterResource(id = R.drawable.logotorressansebastian)
                , contentDescription = stringResource(id = R.string.app_name)
                , modifier = Modifier.padding(end=10.dp),)
            Column {
                Text(text = stringResource(id = R.string.app_name))
                Text(text = stringResource(id = R.string.direction))
            }
        }
        Row( horizontalArrangement = Arrangement.Center
            , modifier = Modifier
                .padding(top = 5.dp, end = 5.dp, bottom = 5.dp)
                .fillMaxWidth()) {
            Text(text = stringResource(id = R.string.neighborhood))
        }
        Row( horizontalArrangement = Arrangement.End
        , modifier = Modifier
                .padding(top = 50.dp, end = 5.dp, bottom = 5.dp)
                .fillMaxWidth()) {
            Text(text = stringResource(id = R.string.city))
        }
    }
}
@Composable
@Preview(showSystemUi = true, showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_NO)
fun PreviewDrawerHeader(){
    MaterialThemeComposeUI {
        ModalDrawerSheet {
            DrawerHeader()
        }
    }
}

@Composable
@Preview(showSystemUi = true, showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
fun PreviewDrawerHeaderDark(){
    MaterialThemeComposeUI {
        ModalDrawerSheet {
            DrawerHeader()
        }
    }
}