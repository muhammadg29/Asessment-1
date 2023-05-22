package org.d3if3017.assesment2_mobpro.model

import org.d3if3017.assesment2_mobpro.db.AmoebaEntity

fun AmoebaEntity.hitungAmoeba(): HasilAmoeba {
    val jumlahWaktuPembelahan = jangkaWaktu.toDouble() /  rentangWaktu.toDouble()
    val hasil = awalAmoeba.toDouble() * (Math.pow(pembelahanAmoeba.toDouble(), jumlahWaktuPembelahan))
    return HasilAmoeba(hasil.toFloat(), awalAmoeba, pembelahanAmoeba, rentangWaktu, jangkaWaktu)
}