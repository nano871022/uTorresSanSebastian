package co.japl.android.torressansebastian.ui.view.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.viewmodel.compose.viewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeState(
    openDialog : MutableState<Boolean> = remember { mutableStateOf(false) },
    openName: MutableState<String> = remember { mutableStateOf("") },
    openSrc: MutableState<Int> = remember { mutableIntStateOf(0) },
    viewModel:HomeViewModel = viewModel()
     ) :HomeModel{
    val state = rememberPagerState( pageCount = {viewModel.list.size})
    return HomeModel(state,viewModel,openDialog,openName,openSrc)
}