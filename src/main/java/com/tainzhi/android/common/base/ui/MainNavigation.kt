package com.tainzhi.android.common.base.ui

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment

/**
 * @author:      tainzhi
 * @mail:        qfq61@qq.com
 * @date:        2020/6/17 22:50
 * @description: copy from google ioshed
 **/

/**
 * To be implemented by components that host top-level navigation destinations.
 */
interface NavigationHost {

    /** Called by MainNavigationFragment to setup it's toolbar with the navigation controller. */
    fun registerToolbarWithNavigation(toolbar: Toolbar)
}

/**
 * To be implemented by main navigation destinations shown by a [NavigationHost].
 */
interface NavigationDestination {

    /** Called by the host when the user interacts with it. */
    fun onUserInteraction() {}
}

/**
 * Fragment representing a main navigation destination. This class handles wiring up the [Toolbar]
 * navigation icon if the fragment is attached to a [NavigationHost].
 */
abstract class MainNavigationFragment: Fragment(), NavigationDestination {

    protected var navigationHost: NavigationHost? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is NavigationHost) {
            navigationHost = context
        }
    }

    override fun onDetach() {
        super.onDetach()
        navigationHost = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // If we have a toolbar and we are attached to a proper navigation host, set up the toolbar
        // navigation icon.
        val host = navigationHost ?: return
        val mainToolbar: Toolbar = getToolBar() ?: return
        mainToolbar.apply {
            host.registerToolbarWithNavigation(this)
        }
    }

    abstract fun getToolBar() : Toolbar?
}
