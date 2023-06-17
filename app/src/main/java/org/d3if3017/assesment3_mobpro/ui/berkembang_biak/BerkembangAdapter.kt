package org.d3if3017.assesment3_mobpro.ui.berkembang_biak

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import org.d3if3017.assesment3_mobpro.R
import org.d3if3017.assesment3_mobpro.databinding.ListItemBinding
import org.d3if3017.assesment3_mobpro.model.Berkembang
import org.d3if3017.assesment3_mobpro.network.ServiceAPI

class BerkembangAdapter : RecyclerView.Adapter<BerkembangAdapter.ViewHolder>(){

    private val data = mutableListOf<Berkembang>()

    fun updateData(newData: List<Berkembang>){
        data.clear()
        data.addAll(newData)
        notifyDataSetChanged()
    }
    class ViewHolder(private val binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root){

        fun bind(berkembang: Berkembang) = with(binding){
            judulTextView.text = berkembang.judul
            tglTextView.text = berkembang.tgl
            Glide.with(imageView.context)
                .load(ServiceAPI.getBiakUrl(berkembang.imageId))
                .error(R.drawable.baseline_broken_image_24)
                .into(imageView)
            tempatTextView.text = berkembang.tempat
            deskripsiTextView.text = berkembang.deskripsi


            root.setOnClickListener{
                val message = root.context.getString(R.string.message, berkembang.judul)
                Toast.makeText(root.context, message, Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ListItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(data[position])
    }
}