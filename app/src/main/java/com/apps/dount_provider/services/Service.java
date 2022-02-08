package com.apps.dount_provider.services;


import com.apps.dount_provider.model.NotificationDataModel;
import com.apps.dount_provider.model.OrderDataModel;
import com.apps.dount_provider.model.PlaceGeocodeData;
import com.apps.dount_provider.model.PreviousOrderDataModel;
import com.apps.dount_provider.model.SingleOrderDataModel;
import com.apps.dount_provider.model.StatusResponse;
import com.apps.dount_provider.model.UserModel;
import com.apps.dount_provider.model.VehicleDataModel;

import io.reactivex.Observable;
import io.reactivex.Single;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;

public interface Service {

    @GET("geocode/json")
    Single<Response<PlaceGeocodeData>> getGeoData(@Query(value = "latlng") String latlng,
                                                  @Query(value = "language") String language,
                                                  @Query(value = "key") String key);


    @FormUrlEncoded
    @POST("delivery/auth/login")
    Single<Response<UserModel>> login(@Field("name") String name,
                                      @Field("password") String password);

    @Multipart
    @POST("delivery/representative/register")
    Observable<Response<UserModel>> signUp(@Part("name") RequestBody name,
                                           @Part("phone_code") RequestBody phone_code,
                                           @Part("phone") RequestBody phone,
                                           @Part("password") RequestBody password,
                                           @Part("vehicle_id") RequestBody vehicle_id,
                                           @Part("identification") RequestBody identification,
                                           @Part MultipartBody.Part logo


    );

    @Multipart
    @POST("delivery/representative/edit_profile")
    Observable<Response<UserModel>> updateProfile(@Header("auth-token") String token,
                                                  @Part("name") RequestBody name,
                                                  @Part("vehicle_id") RequestBody vehicle_id,
                                                  @Part("identification") RequestBody identification,
                                                  @Part MultipartBody.Part logo


    );


    @FormUrlEncoded
    @POST("delivery/auth/logout")
    Single<Response<StatusResponse>> logout(@Header("auth-token") String token,
                                            @Field("token") String phone_token


    );

    @FormUrlEncoded
    @POST("delivery/auth/insert_token")
    Single<Response<StatusResponse>> updateFirebaseToken(@Header("auth-token") String token,
                                                         @Field("rev id") String rev_id,
                                                         @Field("token") String phone_token,
                                                         @Field("type") String software_type


    );

    @FormUrlEncoded
    @POST("api/contact/contact")
    Single<Response<StatusResponse>> contactUs(@Field("name") String name,
                                               @Field("email") String email,
                                               @Field("subject") String subject,
                                               @Field("message") String message);


    @GET("delivery/representative/vehicles")
    Single<Response<VehicleDataModel>> getVehicles(@Header("lang") String lang);

    @GET("delivery/notifications")
    Single<Response<NotificationDataModel>> getNotifications(@Header("AUTHORIZATION") String token,
                                                             @Query(value = "user_id") String user_id
    );

    @GET("delivery/orders/current_orders")
    Single<Response<OrderDataModel>> getCurrentOrders(@Query(value = "user_id") String user_id);

    @GET("delivery/orders/previous_orders")
    Single<Response<OrderDataModel>> getPreviousOrders(@Header("auth-token") String auth_token,
                                                               @Query(value = "time") String time
    );

    @GET("delivery/orders/order_details")
    Single<Response<SingleOrderDataModel>> getOrderDetails(@Header("auth-token") String auth_token,
                                                           @Query(value = "order_id") String order_id
    );

    @FormUrlEncoded
    @POST("delivery/orders/accept_order")
    Single<Response<StatusResponse>> acceptOrder(@Header("auth-token") String auth_token,
                                                 @Field("order_id") String order_id
    );
    @FormUrlEncoded
    @POST("delivery/orders/on_way_order")
    Single<Response<StatusResponse>> orderOnWay(@Header("auth-token") String auth_token,
                                                 @Field("order_id") String order_id
    );
    @FormUrlEncoded
    @POST("delivery/orders/cancel_order")
    Single<Response<StatusResponse>> cancelOrder(@Header("auth-token") String auth_token,
                                                 @Field("order_id") String order_id
    );

    @FormUrlEncoded
    @POST("delivery/orders/end_order")
    Single<Response<StatusResponse>> endOrder(@Header("auth-token") String auth_token,
                                              @Field("order_id") String order_id
    );


}