package cn.a10miaomiao.bilimiao.compose.pages.dynamic.content

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import bilibili.app.dynamic.v2.DynThumbReq
import bilibili.app.dynamic.v2.DynamicGRPC
import com.a10miaomiao.bilimiao.comm.network.BiliGRPCHttp
import com.a10miaomiao.bilimiao.comm.store.UserStore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.kodein.di.DI
import org.kodein.di.DIAware
import org.kodein.di.instance

class DynamicViewModel(override val di: DI) :ViewModel(), DIAware {
    val userStore: UserStore by instance()

    fun dynThumb() = viewModelScope.launch(Dispatchers.IO) {
        val req = DynThumbReq(uid=userStore.state.info?.mid ?: 0,

            )
        BiliGRPCHttp.request {
            DynamicGRPC.dynThumb()
        }
    }
}