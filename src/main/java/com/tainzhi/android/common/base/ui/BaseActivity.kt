package com.tainzhi.android.common.base.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel

/**
 * @author:       tainzhi
 * @mail:         qfq61@qq.com
 * @date:         2020/1/18 14:57
 * @description:
 **/

abstract class BaseActivity(useBinding: Boolean = false) : AppCompatActivity(), CoroutineScope by MainScope() {
    private val _useBinding = useBinding
    open lateinit var mBinding: ViewDataBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (_useBinding) {
            mBinding = DataBindingUtil.setContentView<ViewDataBinding>(this, getLayoutResId())
            mBinding.lifecycleOwner = this
        } else {
            setContentView(getLayoutResId())
        }
        initView()
        initData()
    }

    abstract fun getLayoutResId(): Int
    open fun initView() {}
    open fun initData() {}

    override fun onDestroy() {
        super.onDestroy()
        cancel()
    }
}