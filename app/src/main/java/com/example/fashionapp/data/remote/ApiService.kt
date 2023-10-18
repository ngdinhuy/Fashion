package com.example.shopapp.data.remote

import com.example.fashionapp.data.remote.request.LoginRequest
import com.example.fashionapp.data.remote.request.SignUpRequest
import com.example.fashionapp.data.remote.request.UpdateUserInfoRequest
import com.example.fashionapp.data.remote.response.CartResponse
import com.example.fashionapp.data.remote.response.BaseResponse
import com.example.fashionapp.data.remote.response.CategoryAndProductResponse
import com.example.fashionapp.data.remote.response.UserInfoResponse
import com.example.fashionapp.model.*
import okhttp3.MultipartBody
import retrofit2.http.*
import java.util.*

interface ApiService {
    @GET("product/all")
    suspend fun getAllProducts(): BaseResponse<List<Product>>

    @POST("auth/login")
    suspend fun login(
        @Body loginRequest: LoginRequest
    ): BaseResponse<UserModel>

    @GET("product/category")
    suspend fun getProductByCategory(
        @Query("id") idCategory: Int,
        @Query("filter") filter: Int
    ): BaseResponse<List<Product>>

    @GET("category/all")
    suspend fun getAllCategories(): BaseResponse<List<CategoryModel>>

    @GET("product/category_product")
    suspend fun getCategoryAndProduct(): BaseResponse<List<CategoryAndProductResponse>>

    @POST("product/purchase")
    @FormUrlEncoded
    suspend fun addToCart(
        @Field("idUser") idUser: Int,
        @Field("idProduct") idProduct: Int,
        @Field("quantity") quantity: Int
    ): BaseResponse<CartResponse>

    @GET("cart/all/{id}")
    suspend fun getAllCart(
        @Path("id") id: Int
    ): BaseResponse<List<CartResponse>>

    @POST("cart/update_quantity")
    @FormUrlEncoded
    suspend fun editCartItem(
        @Field("id_cart_item") idCartItem: Int,
        @Field("quantity_change") quantityChange: Int,
        @Field("id_user") idUser: Int
    ): BaseResponse<List<CartResponse>>

    @DELETE("cart")
    suspend fun deleteCartItem(
        @Query("id_cart_item") idCartItem: Int,
        @Query("id_user") idUser: Int
    ): BaseResponse<List<CartResponse>>

    @GET("user/{id}")
    suspend fun getInfoUser(
        @Path("id") idUser: Int
    ): BaseResponse<UserInfoResponse>

    @GET("order/all")
    suspend fun getAllUserOrder(
        @Query("id_user") idUser: Int
    ): BaseResponse<List<OrderModel>>

    @GET("order/detail")
    suspend fun getAllOrderItem(
        @Query("id_order") idOrder: Int
    ): BaseResponse<List<OrderItemDetail>>

    @PUT("user/{id}")
    suspend fun updateInfoUser(
        @Path("id") idUser : Int,
        @Body updateUserInfo: UpdateUserInfoRequest
    ): BaseResponse<UserInfoResponse>

    @POST("auth/change_password")
    @FormUrlEncoded
    suspend fun updatePassword(
        @Field("id_user") idUser: Int,
        @Field("new_password") newPassword: String,
        @Field("old_password") oldPassword: String
    ): BaseResponse<UserInfoResponse>

    @POST("auth/register")
    suspend fun signUp(
        @Body request: SignUpRequest
    ): BaseResponse<UserModel>

    @Multipart
    @POST("user/change_avatar/{id}")
    suspend fun changeAvatar(
        @Path("id") id: Int,
        @Part multipartFile: MultipartBody.Part
    ): BaseResponse<UserModel>

    @GET("product/seller/{id}")
    suspend fun getListProductBySellerId(
        @Path("id")idSeller : Int
    ): BaseResponse<kotlin.collections.List<Product>>
}