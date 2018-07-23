package luthfihariz.com.kajian.ui.home

import com.luthfihariz.kajian.ui.base.BaseActivity
import com.luthfihariz.kajian.ui.home.HomeModule
import com.luthfihariz.kajian.ui.home.HomeViewModel

class HomeActivity : BaseActivity(){

    override fun setupActivityComponent() {
        component.plus(HomeModule(this)).inject(this)
    }
}