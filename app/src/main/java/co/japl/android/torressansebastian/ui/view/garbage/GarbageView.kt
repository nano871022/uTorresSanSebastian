package co.japl.android.torressansebastian.ui.view.garbage

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import co.japl.android.torressansebastian.R
import co.japl.android.torressansebastian.ui.settings.common.SimpleHtml
import co.japl.android.torressansebastian.ui.settings.common.Title

@Composable
fun Garbage(){
    Title(title = stringResource(id = R.string.title_garbage), icon = painterResource(id = R.drawable.ic_baseline_restore_from_trash_24)) {
        SimpleHtml(text = stringResource(id = R.string.info_manage_gargage))
    }
}
@Composable
@Preview(showSystemUi = true, showBackground = true)
fun Preview(){
    Garbage()
}