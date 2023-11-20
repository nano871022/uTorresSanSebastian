package co.japl.android.torressansebastian.ui.view.admin_pay

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import co.japl.android.torressansebastian.R
import co.japl.android.torressansebastian.ui.settings.common.Title

@Composable
fun AdministrationPayView(){
    Title(title = stringResource(id = R.string.administration_pay), icon = painterResource(id = R.drawable.ic_baseline_attach_money_24)) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Datafono()

            Account()
        }
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun Datafono(){

    Card(stringResource(id = R.string.dataphone_pay),painterResource(id = R.drawable.cal_pago_4),stringResource(id = R.string.num_service_code)){}
}

@Composable
private fun Account(){
    val link = stringResource(R.string.link_page)
    val context = LocalContext.current
    Card(stringResource(id = R.string.webpage_pay),painterResource(id = R.drawable.avvillas), stringResource(id = R.string.num_account_number),true){
        val url = Uri.parse(link)
        val intent = Intent(Intent.ACTION_VIEW,url)
        context.startActivity(intent)
    }
}

@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun Card(title:String,painter:Painter,number:String,lookLikeLink:Boolean = false,onClick:()->Unit){
    Card (modifier=Modifier.padding(10.dp)
        , elevation = 5.dp
    ,onClick = {
        onClick.invoke()
        }) {

        Column(horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(5.dp)) {

            Text(text = title, textAlign = TextAlign.Center)

            Image(
                painter = painter,
                contentDescription = title,
                modifier = Modifier.height(100.dp)
            )
            if(lookLikeLink){
                Text(text = "# $number",fontStyle= FontStyle.Italic, textDecoration = TextDecoration.Underline,color= Color.Blue)
            }else {
                Text(text = "# $number", fontStyle = FontStyle.Italic)
            }
        }
    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun Preview(){
    AdministrationPayView()
}