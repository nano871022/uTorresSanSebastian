package co.japl.android.torressansebastian.ui.view.location

import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.japl.android.torressansebastian.R
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState

@RequiresApi(Build.VERSION_CODES.R)
@Composable
fun Location(){
    val context = LocalContext.current
    val location = LatLng(6.2412581,-75.5692183)
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(location, 15f)
    }
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

        IconButton(onClick={
            Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=${location.latitude},${location.longitude}")).apply {
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                context.startActivity(this)
            }
        }){
            Icon(painter = painterResource(id = R.drawable.ic_baseline_location_on_24)
            , contentDescription = stringResource(id = R.string.app_name)
            ,tint= Color.Red
        , modifier = Modifier.width(48.dp).height(48.dp))
        }

        GoogleMap (
            modifier = Modifier.fillMaxWidth(),
            cameraPositionState = cameraPositionState
        ){
            Marker(
                state = MarkerState(position = location)
                , title = stringResource(id = R.string.app_name)
                , snippet = stringResource(id = R.string.app_name)
            )
        }

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