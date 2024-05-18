package kz.sd.shop.fragments

import android.os.Bundle
import android.view.View
import com.bumptech.glide.Glide
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import kz.sd.shop.base.BaseFragment
import kz.sd.shop.databinding.FragmentProductDetailsBinding
import kz.sd.shop.models.Product

class ProductDetailsFragment : BaseFragment<FragmentProductDetailsBinding>(FragmentProductDetailsBinding::inflate) {
    private val args: ProductDetailsFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val product = args.product
        with(binding) {
            backButton.setOnClickListener {
                findNavController().popBackStack()
            }

            Glide.with(requireContext())
                .load(product.product_photo)
                .into(productImage)

            productTitle.text = product.product_title
            productPrice.text = "${product.product_price} ${product.currency}"
            productRating.text = "Rating: ${product.product_star_rating} (${product.product_num_ratings} Reviews)"
            productDescription.text = "Description not available"

            addToCartButton.setOnClickListener {
            }
        }
    }
}
