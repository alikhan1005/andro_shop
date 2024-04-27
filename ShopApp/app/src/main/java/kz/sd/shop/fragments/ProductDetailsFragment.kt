package kz.sd.shop.fragments

import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import kz.sd.shop.base.BaseFragment
import kz.sd.shop.databinding.FragmentProductDetailsBinding

class ProductDetailsFragment: BaseFragment<FragmentProductDetailsBinding>(FragmentProductDetailsBinding::inflate) {
    private val args:ProductDetailsFragmentArgs by navArgs()
    override fun onBindView() {
        super.onBindView()
        val product = args.product
        with(binding){
            backBtn.setOnClickListener {
                findNavController().popBackStack()
            }

            title.text = product.title
            product.img?.let { imageView3.setImageResource(it) }
            price.text = product.price.toString()+" KZT"
            val bonusAmount = product.price?.times(0.05)?.toInt()
            bonus.text = "+ "+bonusAmount.toString()+ " бонусов"
            description.text = product.description

        }
    }
}