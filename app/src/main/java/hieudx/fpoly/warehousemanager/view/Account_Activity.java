package hieudx.fpoly.warehousemanager.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Toast;

import hieudx.fpoly.warehousemanager.R;
import hieudx.fpoly.warehousemanager.databinding.ActivityAccountBinding;

public class Account_Activity extends AppCompatActivity {
    private boolean nightMode;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private ActivityAccountBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        binding = ActivityAccountBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());



        sharedPreferences = getSharedPreferences("MODE", MODE_PRIVATE);
        nightMode = sharedPreferences.getBoolean("night", false);

        if (nightMode) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            binding.swMode.setChecked(true);
        }
        binding.swMode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nightMode) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    editor = sharedPreferences.edit();
                    editor.putBoolean("night", false);
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    editor = sharedPreferences.edit();
                    editor.putBoolean("night", true);
                }
                editor.apply();
            }
        });
        binding.swNotifi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(Account_Activity.this, "Bật thông báo: Bật", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(Account_Activity.this, "Bật thông báo: Tắt", Toast.LENGTH_SHORT).show();

                }
            }
        });
        binding.swAutoApdate.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(Account_Activity.this, "Tự động cập nhật: Bật", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(Account_Activity.this, "Tự động cập nhật: Tắt", Toast.LENGTH_SHORT).show();
                }
            }
        });

        binding.rlEditInf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Account_Activity.this, "Chỉnh sửa thông tin", Toast.LENGTH_SHORT).show();
            }
        });
        binding.rlChangePass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Account_Activity.this, "Thay đổi mật khẩu", Toast.LENGTH_SHORT).show();
            }
        });

        binding.rlAboutMe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Account_Activity.this, "Về chúng tôi", Toast.LENGTH_SHORT).show();
            }
        });
        binding.rlPrivacyPolicy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Account_Activity.this, "Chính sách bảo mật", Toast.LENGTH_SHORT).show();
            }
        });
        binding.rlError.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Account_Activity.this, "Báo lỗi", Toast.LENGTH_SHORT).show();
            }
        });
        binding.rlHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Account_Activity.this, "Trợ giúp và phản hồi", Toast.LENGTH_SHORT).show();
            }
        });
        binding.rlShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Account_Activity.this, "Chia sẻ", Toast.LENGTH_SHORT).show();
            }
        });
        binding.rlLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Account_Activity.this);
                builder.setTitle("Xác nhận đăng xuất");
                builder.setMessage("Bạn có chắc chắn muốn đăng xuất không ?");
                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(Account_Activity.this, Login_SignUp_Activity.class);
                        startActivity(intent);
                    }
                });
                builder.setNegativeButton("Không", null);
                builder.show();
            }
        });
    }
    public void onBackButtonClicked(View view) {
        onBackPressed();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed(); // Quay lại trang trước đó
//        finish(); // Kết thúc Activity hiện tại
    }
}