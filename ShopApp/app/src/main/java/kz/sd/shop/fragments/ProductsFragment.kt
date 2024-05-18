package kz.sd.shop.fragments

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import kz.sd.shop.adapters.ProductAdapter
import kz.sd.shop.base.BaseFragment
import kz.sd.shop.databinding.FragmentProductsBinding
import kz.sd.shop.network.AmazonViewModel


@AndroidEntryPoint

class ProductsFragment:BaseFragment<FragmentProductsBinding>(FragmentProductsBinding::inflate) {
    private val viewModel: AmazonViewModel by viewModels()
    override fun onBindView() {
        super.onBindView()
        viewModel.searchProducts("Laptop")

        var adapter1 = ProductAdapter()
        viewModel.amazonLiveDate.observe(viewLifecycleOwner) {
            adapter1.submitList(it?.data?.products)
        }
        binding.recycler1.adapter = adapter1
        binding.recycler1.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        adapter1.itemClick = {
            findNavController().navigate(
                ProductsFragmentDirections.actionProductsFragment2ToProductDetailsFragment(it)
            )
        }
    }
}