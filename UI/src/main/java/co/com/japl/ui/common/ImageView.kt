package co.com.jap.ui.common

import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.AlertDialogDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import co.com.japl.ui.R
import co.com.japl.ui.theme.MaterialThemeComposeUI
import coil.compose.AsyncImage
import coil.memory.MemoryCache

@Composable
@ExperimentalMaterial3Api
fun ImageView(name:String,imageSrcInt:Int,openDialog: MutableState<Boolean>){
    if(openDialog.value && imageSrcInt > 0){
        Dialog(name,openDialog,imageSrcInt)
    }
}

@Composable
@ExperimentalMaterial3Api
fun ImageView(name:String,imageUrl:String,openDialog: MutableState<Boolean>){
    if(openDialog.value && imageUrl.isNotBlank()){
        Dialog(name,openDialog, urlImage = imageUrl)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun Dialog(name:String,openDialog: MutableState<Boolean>,imageSrcInt:Int?=null,urlImage:String?=null){
    val rotationState = remember { mutableFloatStateOf(1f) }
    val scale = remember { mutableFloatStateOf(1f) }
    val offset = remember { mutableStateOf(Offset(0f,0f)) }
    var placeholder: MemoryCache.Key? = null


    AlertDialog(
         onDismissRequest = {
            openDialog.value = false
        }, confirmButton = {

        }, title = {
            TitleCard(name,openDialog)
        },modifier = Modifier
            .fillMaxSize()
        , containerColor = Color.Black

        , shape = AlertDialogDefaults.shape
    ,text={
        Column(modifier = Modifier.fillMaxSize()) {
            Column (modifier= Modifier
                .fillMaxSize()
                .pointerInput(Unit) {
                    detectTransformGestures { centroId, pan, zoom, rotation ->
                        scale.floatValue *= zoom
                        rotationState.floatValue += rotation
                        offset.value = Offset(
                            offset.value.x + (pan.x / density * scale.floatValue),
                            offset.value.y + (pan.y / density * scale.floatValue)
                        )
                    }
                },
                horizontalAlignment = Alignment.CenterHorizontally
                , verticalArrangement = Arrangement.Center
            ){
                if(imageSrcInt!=null){

                    Image(painter = painterResource(id = imageSrcInt), contentDescription = name
                        ,modifier = Modifier.graphicsLayer {
                            scaleX = maxOf(.5f, maxOf(1f,scale.floatValue))
                            scaleY = maxOf(.5f, maxOf(1f,scale.floatValue))
                            //rotationZ = rotationState.value
                            translationX = offset.value.x
                            translationY = offset.value.y
                        })
                }else if(urlImage!=null){
                    AsyncImage(
                        modifier = Modifier.graphicsLayer {
                            scaleX = maxOf(.5f, maxOf(1f,scale.value))
                            scaleY = maxOf(.5f, maxOf(1f,scale.value))
                            //  rotationZ = rotationState.value
                            translationX = offset.value.x
                            translationY = offset.value.y
                        },
                        model = urlImage,
                        error = ColorPainter(Color.Red),
                        onSuccess = { placeholder = it.result.memoryCacheKey },
                        contentDescription = name
                    )

                }
            }
        }
    }
    )
}

@Composable
private fun TitleCard(name:String,openDialog: MutableState<Boolean>){
    Row (
        modifier= Modifier
            .fillMaxWidth()
            .zIndex(1f)
    ) {
        Text(text = name, modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth(0.9f))

        ClickableText(
            text = buildAnnotatedString {
                Text("X", modifier = Modifier.padding(10.dp),color=Color.Red)
            },
            onClick = {
                openDialog.value = false
            })
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview(showSystemUi = true, showBackground = true)
fun ImageViewPreview(){
    val openDialog = remember { mutableStateOf(true) }
    MaterialThemeComposeUI {
        ImageView(name = "Test"
            , imageSrcInt = R.drawable.googleplay
            , openDialog = openDialog)
    }
}