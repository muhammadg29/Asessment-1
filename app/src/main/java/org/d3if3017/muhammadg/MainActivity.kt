package org.d3if3017.muhammadg

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    private var edtnamapel: EditText? = null
    private var edtnamabar: EditText? = null
    private var edtjumlahbel: EditText? = null
    private var edtharga: EditText? = null
    private var edtuangbay: EditText? = null
    private var btnproses: Button? = null
    private var btnhapus: Button? = null
    private var btnexit: Button? = null
    private var txtnamapel: TextView? = null
    private var txtnamabar: TextView? = null
    private var txtjumlahbel: TextView? = null
    private var txtharga: TextView? = null
    private var txtuangbay: TextView? = null
    private var txtbonus: TextView? = null
    private var txttotalbelanja: TextView? = null
    private var txtuangkembali: TextView? = null
    private var txtketerangan: TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar!!.title = "Badoy Shop"
        edtnamapel = findViewById<View>(R.id.namapelanggan) as EditText
        edtnamabar = findViewById<View>(R.id.namabarang) as EditText
        edtjumlahbel = findViewById<View>(R.id.jumlahbeli) as EditText
        edtharga = findViewById<View>(R.id.harga) as EditText
        edtuangbay = findViewById<View>(R.id.uangbayar) as EditText
        btnproses = findViewById<View>(R.id.tombol1) as Button
        btnhapus = findViewById<View>(R.id.tombol2) as Button
        btnexit = findViewById<View>(R.id.tombol3) as Button
        txtnamapel = findViewById<View>(R.id.namapelanggan) as TextView
        txtnamabar = findViewById<View>(R.id.namabarang) as TextView
        txtjumlahbel = findViewById<View>(R.id.jumlahbeli) as TextView
        txtharga = findViewById<View>(R.id.harga) as TextView
        txtuangbay = findViewById<View>(R.id.uangbayar) as TextView
        txtbonus = findViewById<View>(R.id.bonus) as TextView
        txttotalbelanja = findViewById<View>(R.id.totalbelanja) as TextView
        txtuangkembali = findViewById<View>(R.id.uangkembali) as TextView
        txtketerangan = findViewById<View>(R.id.keterangan) as TextView

        //memberikan action pada tombol proses
        btnproses!!.setOnClickListener {
            val namapelanggan = edtnamapel!!.text.toString().trim { it <= ' ' }
            val namabarang = edtnamabar!!.text.toString().trim { it <= ' ' }
            val jumlahbeli = edtjumlahbel!!.text.toString().trim { it <= ' ' }
            val harga = edtharga!!.text.toString().trim { it <= ' ' }
            val uangbayar = edtuangbay!!.text.toString().trim { it <= ' ' }
            val jb = jumlahbeli.toDouble()
            val h = harga.toDouble()
            val ub = uangbayar.toDouble()
            val total = jb * h
            txttotalbelanja!!.text = "Total Belanja : $total"

            //pemberian if dan else untuk aturan pemberian bonus
            if (total >= 200000) {
                txtbonus!!.text = "Bonus : Mouse"
            } else if (total >= 50000) {
                txtbonus!!.text = "Bonus : Keyboard"
            } else if (total >= 40000) {
                txtbonus!!.text = "Bonus : Harddisk"
            } else {
                txtbonus!!.text = "Bonus : Tidak Ada Bonus"
            }
            val uangkembalian = ub - total
            if (ub < total) {
                txtketerangan!!.text = "Keterangan : uang bayar kurang Rp " + -uangkembalian
                txtuangkembali!!.text = "Uang Kembali : Rp 0"
            } else {
                txtketerangan!!.text = "Keterangan : Tunggu Kembalian"
                txtuangkembali!!.text = "Uang Kembali : $uangkembalian"
            }


            //memberikan action pada tombol reset data
        }
        btnhapus!!.setOnClickListener {
            txtnamapel!!.text = " "
            txtnamabar!!.text = " "
            txttotalbelanja!!.text = " Total Belanja : Rp 0"
            txtharga!!.text = " "
            txtuangbay!!.text = " "
            txtuangkembali!!.text = "Uang Kembali : Rp 0"
            txtbonus!!.text = "Bonus : - "
            txtjumlahbel!!.text = " "
            txtketerangan!!.text = "Keterangan : - "
            Toast.makeText(applicationContext, "Data sudah direset", Toast.LENGTH_LONG).show()

            // memberikan action pada tombol keluar
        }
        btnexit!!.setOnClickListener { moveTaskToBack(true) }
    }
}