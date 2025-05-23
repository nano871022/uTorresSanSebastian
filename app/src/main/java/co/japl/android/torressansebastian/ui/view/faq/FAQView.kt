package co.japl.android.torressansebastian.ui.view.faq

import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.UploadFile
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.viewinterop.AndroidView
import androidx.hilt.navigation.compose.hiltViewModel
import co.japl.android.torressansebastian.R
import co.japl.android.torressansebastian.controller.faqai.FAQAIViewModel
import co.japl.android.torressansebastian.ui.settings.common.Title
import co.japl.android.torressansebastian.utils.NetworkUtils


@Composable
fun FAQAI(
     viewModel: FAQAIViewModel = hiltViewModel()
    ,webViewClient:WebViewClient = WebViewClient()
){
    val progressState = remember { viewModel.progress }
    val loaderState = remember { viewModel.loader }
    val urlState = remember {viewModel.url}
    if(NetworkUtils.isNetworkAvailable(LocalContext.current)) {
    LaunchedEffect( key1 = Unit) {
            viewModel.main()
    }

    if(loaderState){
        LinearProgressIndicator(
            progress = { progressState },
            modifier = Modifier.fillMaxWidth(),
        )
    }else {
        Column(modifier = Modifier.fillMaxWidth()) {
            Title(
                title = stringResource(id = R.string.faq_ai),
                icon = Icons.Rounded.UploadFile
            ) {

                AndroidView(factory = {
                    WebView(it).apply {
                        settings.javaScriptEnabled = true
                        this.webViewClient = webViewClient
                        settings.loadWithOverviewMode = true
                        settings.useWideViewPort = true
                        settings.setSupportZoom(true)
                    }
                }, update = {
                    it.loadUrl(urlState.value)
                }, modifier = Modifier.fillMaxWidth().fillMaxHeight())

            }
        }
    }
    }else{
        Title(
            title = stringResource(id = R.string.faq_ai),
            icon = Icons.Rounded.UploadFile
        ) {
            Text(
                text = stringResource(id = R.string.no_network_connection),
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center
            )
        }
        }

}


