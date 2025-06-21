package com.a10miaomiao.bilimiao.comm.apis

import com.a10miaomiao.bilimiao.comm.network.BiliApiService

class DynamicApi {

    /**
     * 动态点赞/取消
     * @param up 1 点赞 2 取消
     *
     */
    fun like(dynamicId:String,
             up: String,
             uid: String){
        BiliApiService.biliApi("x/dynamic/feed/dyn/thumb")
    }
}