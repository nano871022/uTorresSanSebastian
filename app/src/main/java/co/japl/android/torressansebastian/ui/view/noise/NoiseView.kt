package co.japl.android.torressansebastian.ui.view.noise

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import co.japl.android.torressansebastian.R
import co.japl.android.torressansebastian.ui.settings.common.SimpleHtml
import co.japl.android.torressansebastian.ui.settings.common.Title

@Composable
fun Noise(){
    val text = stringResource(id = R.string.info_noise)
    Title(title = stringResource(id = R.string.title_noise)
        , iconPainter = painterResource(id = R.drawable.ic_baseline_do_not_disturb_on_total_silence_24)) {
        SimpleHtml(text = text)
    }
}

@Composable
@Preview(showSystemUi = true, showBackground = true)
fun Preview(){
    Noise()
}