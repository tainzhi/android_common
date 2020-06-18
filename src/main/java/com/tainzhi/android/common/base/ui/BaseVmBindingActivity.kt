package com.tainzhi.android.common.base.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

/**
 * @author:       tainzhi
 * @mail:         qfq61@qq.com
 * @date:         2020/1/18 15:26
 * @description:
 **/

abstract class BaseVmBindingActivity<VM : BaseViewModel, BD:ViewDataBinding>: AppCompatActivity
() {
    protected lateinit var mBinding: BD
    lateinit var mViewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mBinding = DataBindingUtil.setContentView(this, getLayoutResId())
        mBinding.lifecycleOwner = this

        mViewModel = initVM()
        initView()
        initData()
        startObserve()
    }

    open fun getLayoutResId(): Int = 0
    abstract fun initVM(): VM
    abstract fun initView()
    abstract fun initData()
    abstract fun startObserve()
}