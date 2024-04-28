package co.japl.android.torressansebastian.ui.settings.common

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import co.com.japl.ui.theme.MaterialThemeComposeUI
import co.japl.android.torressansebastian.R

@Composable
fun Title(title:String,icon:Painter,into:@Composable() (() -> Unit)){
    Column(modifier= Modifier
        .fillMaxSize()
        .padding(top = 15.dp, start = 10.dp, end = 10.dp, bottom = 10.dp)){
        Row(modifier= Modifier.fillMaxWidth()
        , verticalAlignment = Alignment.CenterVertically) {

            Icon(painter = icon , title
                , tint = MaterialTheme.colorScheme.tertiary)

            Text(text= title
                , fontSize = 20.sp
                , color = MaterialTheme.colorScheme.onPrimary
            , modifier= Modifier.padding(start = 10.dp))
        }

        Divider(modifier=Modifier.padding(bottom = 15.dp))

        into.invoke()
    }
}

@Composable
fun Title(title:String,icon:ImageVector,into:@Composable() (() -> Unit)){
    Column(modifier= Modifier
        .fillMaxSize()
        .padding(top = 15.dp, start = 10.dp, end = 10.dp, bottom = 10.dp)){
        Row(modifier= Modifier.fillMaxWidth()
            , verticalAlignment = Alignment.CenterVertically) {

            Icon(imageVector = icon , title
                , tint = MaterialTheme.colorScheme.tertiary)

            Text(text= title
                , fontSize = 20.sp
                , color = MaterialTheme.colorScheme.onPrimary
                , modifier= Modifier.padding(start = 10.dp))
        }

        Divider(modifier=Modifier.padding(bottom = 15.dp))

        into.invoke()
    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun Preview(){
    MaterialThemeComposeUI {
        Title("Texto Prueba", painterResource(id = R.drawable.ic_baseline_attach_money_24)) {
            Text("Inside")
        }
    }
}