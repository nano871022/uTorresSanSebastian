package co.japl.android.torressansebastian.ui.view.parking

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.japl.android.torressansebastian.R
import co.japl.android.torressansebastian.ui.settings.common.SimpleHtml
import co.japl.android.torressansebastian.ui.settings.common.Title

@Composable
fun Parking(){
    Title(title = stringResource(id = R.string.parking), icon = painterResource(id = R.drawable.ic_baseline_local_parking_24)) {
        Column(modifier= Modifier.fillMaxWidth()){
            DataInfoParking()

            Text(text= stringResource(id = R.string.note),modifier = Modifier.padding(top=10.dp))

            SimpleHtml(text = stringResource(id = R.string.parking_information))

            Image(painter = painterResource(id = R.drawable.parqueadero1024)
                , contentDescription = stringResource(id = R.string.parking)
            , modifier = Modifier.fillMaxWidth()
            , contentScale = ContentScale.FillWidth)
        }
    }
}

@Composable
private fun DataInfoParking(){
    val list = arrayListOf(
        Pair(stringResource(id = R.string.schedule),stringResource(id = R.string.schedule_parking))
        ,Pair(stringResource(id = R.string.time),stringResource(id = R.string.time_use_parking))
        ,Pair(stringResource(id = R.string.count_parking_moto),stringResource(id = R.string.number_parking_moto))
        ,Pair(stringResource(id = R.string.count_parking_car),stringResource(id = R.string.number_parking_car))
        ,Pair(stringResource(id = R.string.count_ambulance),"1")
        ,Pair(stringResource(id = R.string.speed_parking),stringResource(id = R.string.number_speed_parking))
    )

    list.forEachIndexed { index, pair ->
        Row(modifier = Modifier.fillMaxWidth()) {
            Text(text = pair.first,modifier = Modifier.width(130.dp))
            Text(text = pair.second)
        }
    }

}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun Preview(){
    Parking()
}