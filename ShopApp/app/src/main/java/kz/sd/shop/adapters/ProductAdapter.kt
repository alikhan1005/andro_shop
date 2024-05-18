package kz.sd.shop.adapters

import kz.sd.shop.models.Product


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.bumptech.glide.Glide
import kz.sd.shop.databinding.ItemProductBinding

class ProductAdapter : ListAdapter<Product, ProductAdapter.ProductViewHolder>(ProductDiffUtils()) {

    var itemClick: ((Product) -> Unit)? = null

    class ProductDiffUtils : DiffUtil.ItemCallback<Product>() {
        override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem.asin == newItem.asin
        }

        override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        return ProductViewHolder(
            ItemProductBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bindView(getItem(position))
    }

    inner class ProductViewHolder(private val binding: ItemProductBinding) :
        androidx.recyclerview.widget.RecyclerView.ViewHolder(binding.root) {

        fun bindView(item: Product) {
            with(binding) {
                Glide.with(itemView.context)
                    .load(item.product_photo)
                    .into(productImage)
                productTitle.text = item.product_title
                productPrice.text = item.product_price
                productRating.text = "Rating: ${item.product_star_rating} (${item.product_num_ratings} Reviews)"
                productDelivery.text = item.delivery

                itemView.setOnClickListener {
                    itemClick?.invoke(item)
                }
            }
        }
    }
}