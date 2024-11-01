package thi.tai64132083.requestapi.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import thi.tai64132083.requestapi.model.Employee;
import thi.tai64132083.requestapi.model.Knowledge;

public interface ApiService {
    Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-MM-dd HH:mm:ss")
            .create();

    ApiService apiService = new Retrofit.Builder()
            .baseUrl("https://catfact.ninja/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiService.class);

    @GET("fact")
    Call<Knowledge> getKnowledgee();
}
