package io.diaryofrifat.code.basemvpjava.data.local

import android.content.Context
import io.diaryofrifat.code.basemvpjava.R
import io.diaryofrifat.code.basemvpjava.data.helper.appdatabase.AppDatabase
import io.diaryofrifat.code.basemvpjava.data.local.user.UserDao
import io.diaryofrifat.code.basemvpjava.data.local.user.UserEntity
import io.diaryofrifat.code.utils.helper.DataUtils
import io.reactivex.Completable

class AppLocalDataSource(context: Context) {
    /**
     * Fields
     * */
    private var mUserDao: UserDao? = null

    init {
        AppDatabase.init(context)
        mUserDao = AppDatabase.on()?.userDao()
    }

    fun insertCompletable(entity: UserEntity): Completable {
        return mUserDao?.insert(entity) ?: Completable.error(Throwable(
                DataUtils.getString(R.string.error_dao_is_null)))
    }
}