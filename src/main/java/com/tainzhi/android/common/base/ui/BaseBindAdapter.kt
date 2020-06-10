// package com.tainzhi.android.common.base.ui
//
// import android.view.View
// import android.view.ViewGroup
// import androidx.databinding.DataBindingUtil
// import androidx.databinding.ViewDataBinding
// import com.chad.library.adapter.base.BaseQuickAdapter
// import com.chad.library.adapter.base.BaseViewHolder
// import com.tainzhi.android.wanandroid.R
//
// /**
//  * @author:       tainzhi
//  * @mail:         qfq61@qq.com
//  * @date:         2020/1/25 上午11:25
//  * @description:
//  **/
//
// open class BaseBindAdapter<T>(layoutResId: Int, br: Int) : BaseQuickAdapter<T, BaseBindAdapter.BindViewHolder>(layoutResId) {
//
//     private val _br = br
//
//
//     override fun convert(helper: BindViewHolder, item: T) {
//         helper.binding.run {
//             setVariable(_br, item)
//             executePendingBindings()
//         }
//     }
//
//     override fun getItemView(layoutResId: Int, parent: ViewGroup?): View {
//         val binding = DataBindingUtil.inflate<ViewDataBinding>(mLayoutInflater,layoutResId,
//                 parent, false) ?: return super.getItemView(layoutResId, parent)
//         return binding.root.apply {
//             setTag(R.id.BaseQuickAdapter_databinding_support, binding)
//         }
//
//     }
//
//     class BindViewHolder(view: View) : BaseViewHolder(view) {
//         val binding : ViewDataBinding
//             get() = itemView.getTag(R.id.BaseQuickAdapter_databinding_support) as ViewDataBinding
//     }
// }