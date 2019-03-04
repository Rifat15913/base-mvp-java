package io.diaryofrifat.code.basemvpjava.ui.main

import io.diaryofrifat.code.basemvpjava.data.remote.retrophoto.RetroPhoto
import io.diaryofrifat.code.basemvpjava.ui.base.callback.MvpView

interface MainMvpView : MvpView {
    fun onFetchingData(list: List<RetroPhoto>)
}