package co.japl.android.torressansebastian.ui.view.contactus
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.annotation.DrawableRes
import androidx.annotation.RequiresApi
import androidx.annotation.StringRes
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import co.com.jap.ui.theme.MaterialThemeComposeUI
import co.japl.android.torressansebastian.R
import co.japl.android.torressansebastian.ui.settings.common.Title

@Composable
fun ContactUs(){
    val context = LocalContext.current
    val greeting = stringResource(id = R.string.email_greeting)
    val urlWatsap = stringResource(id = R.string.url_whatsap)
    Title(title = stringResource(id = R.string.title_contact_us)
        , painterResource(id = R.drawable.ic_baseline_complains)){

        TitleSection(icon = R.drawable.ic_baseline_call_24, name = R.string.contact_phones, description = R.string.contact_phones)

        RowLabelValue(label = R.string.admin_number
            , text = R.string.administration_number
            , icon = R.drawable.ic_baseline_call_24){
            Intent(Intent.ACTION_DIAL, Uri.parse("tel:$it"))
                .apply {
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                context.startActivity(this)
            }
        }

        RowLabelValue(label = R.string.entrance_nbr
            , text = R.string.entrance_number
            , icon = R.drawable.ic_baseline_call_24){
            Intent(Intent.ACTION_DIAL, Uri.parse("tel:$it"))
                .apply {
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                context.startActivity(this)
                }
        }

        RowLabelValue(label = R.string.phone_number
            , text = R.string.phone_numbr
            , icon = R.drawable.ic_baseline_call_24){
            Intent(Intent.ACTION_DIAL, Uri.parse("tel:$it"))
                .apply {
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                context.startActivity(this)
                }
        }

        RowLabelValue(label = R.string.whatsap, text = R.string.administration_number, icon = R.drawable.whatsap_7272){
            Intent(Intent.ACTION_VIEW, Uri.parse("$urlWatsap$it"))
                .apply {
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                context.startActivity(this)
                }
        }

        TitleSection(icon = R.drawable.ic_baseline_email_24
            , name = R.string.emails
            , description = R.string.emails)

        RowLabelValue(label = R.string.admin_email
            , text = R.string.administration_email
            , icon = R.drawable.ic_baseline_email_24){
            choseAppSentEmail(it,greeting,"Asunto",context)
        }

        RowLabelValue(label = R.string.consejo_email_label
            , text = R.string.consejo_email
            , icon = R.drawable.ic_baseline_email_24){
            choseAppSentEmail(it,greeting,"Asunto",context)
        }

        RowLabelValue(label = R.string.aux_email
            , text = R.string.auxiliar_email
            , icon = R.drawable.ic_baseline_email_24){
            choseAppSentEmail(it,greeting,"Asunto",context)
        }

        RowLabelValue(label = R.string.website, text = R.string.url_website, icon = R.drawable.ic_action_www){
            Intent(Intent.ACTION_VIEW, Uri.parse(it))
                .apply {
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                context.startActivity(this)
                }
        }
    }
}



@Composable
private fun TitleSection(@DrawableRes icon: Int,@StringRes name:Int,@StringRes description:Int){
    Column (modifier = Modifier.padding(top=20.dp, bottom = 15.dp)) {
        Row() {
            Icon(
                painterResource(id = icon),
                contentDescription = stringResource(id = description)
                ,modifier=Modifier.padding(end=15.dp)
            )

            Text(text = stringResource(id = name))
        }

        Divider()
    }
}

@Composable
private fun RowLabelValue(@StringRes label:Int, @StringRes text:Int, @DrawableRes icon:Int, onClick:(String)->Unit = {}){
    val settings = LocalConfiguration.current
    val widthWindow = settings.screenWidthDp
    val text = stringResource(id = text)
    Row(modifier= Modifier
        .fillMaxWidth()
        .padding(2.dp)
    , verticalAlignment = Alignment.CenterVertically) {
        Text(text = stringResource(id = label)
            ,modifier = Modifier
                .width(getDpByPercent(0.48, widthWindow))
                .padding(end = 10.dp))

        Text(text =  text
        ,modifier = Modifier.width(getDpByPercent(0.40, widthWindow)))

        IconButton(onClick = {onClick.invoke(text)}
        ,modifier = Modifier.border(1.dp, MaterialTheme.colorScheme.primary, shape = MaterialTheme.shapes.medium)) {
            Icon(painterResource(id = icon)
            ,contentDescription =  text)
        }
    }
    /**
     * 30 + 190 + 150 = 370 -> 100%
     * 190 -> 51.35
     * 150 -> 40.54
     * 30 ->  8.11
     */
}

private fun getDpByPercent(percentage: Double, maxSize: Int):Dp{
    return (percentage * maxSize).toInt().dp
    }

private fun choseAppSentEmail(email:String,title:String,subject:String,context: Context) {
    Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:$email")).apply {
        addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
        putExtra(Intent.EXTRA_EMAIL, title)
        putExtra(Intent.EXTRA_CC, email)
        putExtra(Intent.EXTRA_SUBJECT, subject)
        val intentEnd = Intent.createChooser(this, "Send Email Using:")
        context.startActivity(intentEnd)
    }
}

@RequiresApi(34)
@Composable
@Preview(showSystemUi = true, showBackground = true)
fun PreviewContactUs(){
    MaterialThemeComposeUI {
        ContactUs()
    }
}