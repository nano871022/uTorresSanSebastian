package co.japl.android.torressansebastian.ui.settings.common

import android.text.method.LinkMovementMethod
import android.widget.TextView
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.text.HtmlCompat

@Composable
fun SimpleHtml(text:String){
    val html = remember {
        HtmlCompat.fromHtml(text, HtmlCompat.FROM_HTML_MODE_COMPACT)
    }
    AndroidView(factory = {
        TextView(it).apply{
            movementMethod = LinkMovementMethod.getInstance()
        }
    }, update = {
        it.text = html
    })
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun PreviewSimpleHtml(){
    SimpleHtml("<p>Texto <b>Prueba</b></p>")
}