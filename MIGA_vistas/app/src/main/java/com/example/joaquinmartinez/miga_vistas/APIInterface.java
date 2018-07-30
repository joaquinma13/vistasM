package com.example.joaquinmartinez.miga_vistas;



import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface APIInterface {

    /****************************************** GET ***********************************************/


    @GET("api/Sepomex?")
    Call<GetSepomex> getSepomex(@Query("v_cp") String v_cp);


}