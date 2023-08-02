package cn.edu.sjtu.windlll.fashionista.Api

import android.database.Observable
import cn.edu.sjtu.windlll.fashionista.Products.Items
import cn.edu.sjtu.windlll.fashionista.Products.BaseResp
import cn.edu.sjtu.windlll.fashionista.Products.GetGoodsDetailReq
import retrofit2.http.Body
import retrofit2.http.POST

interface ItemsApi {
    @POST("goods/getGoodsDetail")
    fun getGoodsDetail(@Body req: GetGoodsDetailReq): Observable<BaseResp<Items>>
}