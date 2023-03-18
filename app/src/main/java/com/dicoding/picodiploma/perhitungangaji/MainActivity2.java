package com.dicoding.picodiploma.perhitungangaji;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import androidx.appcompat.app.AppCompatActivity;

import com.dicoding.picodiploma.perhitungangaji.databinding.ActivityMain2Binding;
public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {
    private ActivityMain2Binding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.btnhitung.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        if(view.getId() == binding.btnhitung.getId()){
            closeKeyboard();
            double tunjangan;
            double gaji;
            double total;

            String nama = binding.inputnama.getText().toString().trim();

            if(TextUtils.isEmpty(nama)){
                binding.inputnama.setError("Nama Harus Diisi");
            }else{
                if(binding.centangstatus.isChecked()){
                    binding.hasilstatus.setText("Menikah");
                    tunjangan = 0.1;
                }
                else{
                    binding.hasilstatus.setText("Belum Menikah");
                    tunjangan = 0.0;
                }

                if(binding.radio1.isChecked()){
                    binding.hasilgolongan.setText(R.string.gol1);
                    gaji = 1000000.0;
                }else if (binding.radio2.isChecked()){
                    binding.hasilgolongan.setText(R.string.gol3);
                    gaji = 2000000.0;
                }else{
                    gaji = 0.0;
                }
                binding.hasilnama.setText(nama);
                total = gaji + (gaji*tunjangan);
                binding.total.setText("Rp "+ total +",-");
            }
        }
    }
    public void closeKeyboard(){
        View view = this.getCurrentFocus();
        if(view != null){
            InputMethodManager imm = (InputMethodManager)
                    getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}
