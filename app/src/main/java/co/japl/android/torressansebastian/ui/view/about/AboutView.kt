package co.japl.android.torressansebastian.ui.view.about

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import co.com.japl.homeconnect.about.ui.About
import co.com.japl.ui.theme.MaterialThemeComposeUI
import co.japl.android.torressansebastian.BuildConfig

@Composable
fun AboutView(){
    About(BuildConfig.VERSION_NAME,BuildConfig.APPLICATION_ID)
}
@Composable
@Preview(showSystemUi = true, showBackground = true)
fun PreviewAboutView(){
    MaterialThemeComposeUI {
        AboutView()
    }
}