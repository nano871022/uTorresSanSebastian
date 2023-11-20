package co.japl.android.torressansebastian.ui.settings.drawer

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.japl.android.torressansebastian.R

@Composable
fun DrawerHeader(){
    Column(
        modifier = Modifier.padding(20.dp).fillMaxWidth(),

    ){
        Row (
            horizontalArrangement = Arrangement.Center
            ,modifier = Modifier.fillMaxWidth()
        ){
            Image(painter = painterResource(id = R.drawable.logotorressansebastian)
                , contentDescription = stringResource(id = R.string.app_name))
            Column {
                Text(text = stringResource(id = R.string.app_name))
                Text(text = stringResource(id = R.string.direction))
            }
        }
        Row( horizontalArrangement = Arrangement.End
        , modifier = Modifier.fillMaxWidth()) {
            Text(text = stringResource(id = R.string.city))
        }
    }
}
@Composable
@Preview(showSystemUi = true, showBackground = true)
fun PreviewDrawerHeader(){
    DrawerHeader()
}