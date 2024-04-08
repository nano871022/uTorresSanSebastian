package co.japl.android.torressansebastian.ui.view.playground

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import co.japl.android.torressansebastian.R
import co.japl.android.torressansebastian.ui.settings.common.SimpleHtml
import co.japl.android.torressansebastian.ui.settings.common.Title

@Composable
fun Playground(){
    Title(title = stringResource(id = R.string.title_playground), icon = painterResource(id = R.drawable.ic_baseline_sports_soccer_24)) {

        SimpleHtml(text = stringResource(id = R.string.info_playground))

    }
}
@Composable
@Preview(showSystemUi = true, showBackground = true)
fun Preview(){
   Playground()
}