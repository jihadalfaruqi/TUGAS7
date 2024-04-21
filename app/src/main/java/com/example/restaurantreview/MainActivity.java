package com.example.restaurantreview;

import android.content.Context;
import android.os.Bundle;
import android.view.inputmethod.InputMethodManager;

import androidx.appcompat.app.AppCompatActivity;

import com.example.restaurantreview.data.retrofit.ApiConfig;
import com.example.restaurantreview.data.response.PostReviewResponse;
import com.example.restaurantreview.databinding.ActivityMainBinding;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String RESTAURANT_ID = "uewq1zg2zlskfw1e867";
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        findRestaurant();

        binding.btnSend.setOnClickListener(view -> {
            postReview(RESTAURANT_ID, "Dicoding", binding.edReview.getText().toString());
            // Sembunyikan keyboard setelah mengirim review
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        });
    }

    private void findRestaurant() {
        // Mendapatkan data restoran dari server
    }

    private void postReview(String id, String name, String review) {
        // Kirim review ke server menggunakan Retrofit
        Call<PostReviewResponse> client = ApiConfig.getApiService().postReview(id, name, review);
        showLoading(true);
        client.enqueue(new Callback<PostReviewResponse>() {
            @Override
            public void onResponse(@NotNull Call<PostReviewResponse> call, @NotNull Response<PostReviewResponse> response) {
                showLoading(false);
                if (response.isSuccessful()) {
                    // Jika berhasil, refresh tampilan dengan menampilkan ulasan terbaru
                    // Misalnya dengan memanggil kembali findRestaurant()
                    findRestaurant();
                } else {
                    // Jika gagal, tampilkan pesan error atau lakukan tindakan sesuai kebutuhan
                }
            }

            @Override
            public void onFailure(@NotNull Call<PostReviewResponse> call, @NotNull Throwable t) {
                showLoading(false);
                // Handle error saat gagal mengirim review
            }
        });
    }

    private void showLoading(boolean isLoading) {
        // Tampilkan atau sembunyikan loading indicator sesuai kebutuhan
    }
}
