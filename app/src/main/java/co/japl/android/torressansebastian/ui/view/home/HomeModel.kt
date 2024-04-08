package co.japl.android.torressansebastian.ui.view.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.pager.PagerState
import androidx.compose.runtime.MutableState

class HomeModel @OptIn(ExperimentalFoundationApi::class) constructor(val state:PagerState, val viewModel: HomeViewModel,val openState:MutableState<Boolean>, val openStateName:MutableState<String>, val openStateSrc: MutableState<Int>){
}