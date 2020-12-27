package com.tainzhi.android.common.base.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding

/**
 * @author:       tainzhi
 * @mail:         qfq61@qq.com
 * @date:         2020/1/18 15:00
 * @description:
 **/

abstract class BaseBindingFragment<BD : ViewDataBinding> : BaseFragment() {

    protected lateinit var mBinding: BD

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        mBinding = DataBindingUtil.inflate(inflater, getLayoutResId(), container, false)
        mBinding.lifecycleOwner = viewLifecycleOwner
        return mBinding.root
    }
}

