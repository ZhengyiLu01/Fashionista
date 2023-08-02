package cn.edu.sjtu.windlll.fashionista.Products

data class BaseResp<T>(val status: Int, val message: String, val data: T)
