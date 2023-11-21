package co.japl.android.torressansebastian.ui.view.location

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.japl.android.torressansebastian.R

@RequiresApi(Build.VERSION_CODES.R)
@Composable
fun Location(){
    Column(modifier= Modifier.fillMaxSize()
        , horizontalAlignment = Alignment.CenterHorizontally) {
        Image(painter = painterResource(id = R.drawable.torres_san_sebastian2)
            , contentDescription = stringResource(id = R.string.app_name)
        , contentScale = ContentScale.FillHeight
            , modifier = Modifier.height(220.dp)
        , alignment = Alignment.Center)

        Text(text = stringResource(id = R.string.app_name))
        Text(text = stringResource(id = R.string.city))
        Text(text = stringResource(id = R.string.direction))
        Text(text = stringResource(id = R.string.neighborhood))
        Image(painter = painterResource(id = R.drawable.ic_baseline_location_on_24)
            , contentDescription = stringResource(id = R.string.app_name)
        , alignment = Alignment.Center
        , modifier = Modifier.fillMaxWidth())
        Image(painter = painterResource(id = R.drawable.location)
            , contentDescription = stringResource(id = R.string.app_name))
    }
}
@RequiresApi(Build.VERSION_CODES.R)
@Composable
@Preview(showSystemUi = true, showBackground = true)
fun Preview(){
    Location()
}