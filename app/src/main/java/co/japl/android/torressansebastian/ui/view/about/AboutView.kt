package co.japl.android.torressansebastian.ui.view.about

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import co.com.alameda181.unidadresidencialalameda181.about.UI.About
import co.com.jap.ui.theme.MaterialThemeComposeUI
import co.japl.android.torressansebastian.BuildConfig

@Composable
fun AboutView(){
    About(BuildConfig.VERSION_NAME)
}
@Composable
@Preview(showSystemUi = true, showBackground = true)
fun PreviewAboutView(){
    MaterialThemeComposeUI {
        AboutView()
    }
}