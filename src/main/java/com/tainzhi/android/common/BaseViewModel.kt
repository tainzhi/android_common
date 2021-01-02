package com.tainzhi.android.common

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

/**
 * File:     BaseViewModel
 * Author:   tainzhi
 * Created:  2021/1/1 14:02
 * Mail:     QFQ61@qq.com
 * Description:
 */
open class BaseViewModel(private val coroutinesDispatcherProvider: CoroutinesDispatcherProvider) :
        ViewModel() {
    fun launchIO(task: () -> Unit) {
        viewModelScope.launch(coroutinesDispatcherProvider.io) {
            task.invoke()
        }
    }
}