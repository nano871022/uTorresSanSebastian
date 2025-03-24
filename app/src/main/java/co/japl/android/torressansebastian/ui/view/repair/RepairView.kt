package co.japl.android.torressansebastian.ui.view.repair

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import co.japl.android.torressansebastian.R
import co.japl.android.torressansebastian.ui.settings.common.SimpleHtml
import co.japl.android.torressansebastian.ui.settings.common.Title

@Composable
fun Repair(){
    Title(title = stringResource(id = R.string.title_local_repair),
        iconPainter = painterResource(id = R.drawable.ic_baseline_home_repair_service_24)) {
        SimpleHtml(text = stringResource(id = R.string.info_local_repair))
    }
}
@Composable
@Preview(showBackground = true, showSystemUi = true)
fun Preview(){
    Repair()
}