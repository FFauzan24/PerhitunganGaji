package com.dicoding.picodiploma.perhitungangaji

import android.content.Context
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import com.dicoding.picodiploma.perhitungangaji.databinding.ActivityMain2Binding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMain2Binding
    companion object{
        private const val STATE_RESULT = "state result"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnhitung.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        if(v.id == R.id.btnhitung){
            closeKeyboard()
            val nama = binding.inputnama.text.toString().trim()
            var tunjangan : Double? = 0.0
            var gaji : Double?  = 0.0
            var total : Double? =  0.0

            if(TextUtils.isEmpty(nama)){
                binding.inputnama.setError("Nama Harus Diisi!!!")
                total = 0.0
            }else{
                if(binding.centangstatus.isChecked){
                    binding.hasilstatus.setText("Menikah")
                    tunjangan = 0.1
                }
                else{
                    binding.hasilstatus.setText("Belum Menikah")
                    tunjangan = 0.0
                }
                if(binding.radio1.isChecked){
                    binding.hasilgolongan.setText("Golongan 1")
                    gaji = 1000000.0
                }else if(binding.radio2.isChecked){
                    binding.hasilgolongan.setText("Golongan 2")
                    gaji = 2000000.0
                }else{
                    gaji = 0.0
                }
                total = gaji + (gaji*tunjangan)
                binding.hasilnama.setText(nama)
                binding.total.setText("Rp "+total.toString()+",-")
            }

        }
    }
    private fun closeKeyboard(){
        val view: View? = this.currentFocus
        if(view != null){
            val imm: InputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }


}