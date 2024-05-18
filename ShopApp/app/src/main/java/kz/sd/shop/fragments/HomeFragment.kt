package kz.sd.shop.fragments

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import kz.sd.shop.R
import kz.sd.shop.adapters.ProductAdapter
import kz.sd.shop.base.BaseFragment
import kz.sd.shop.databinding.FragmentHomeBinding
import kz.sd.shop.models.Product
import kz.sd.shop.network.AmazonViewModel


@AndroidEntryPoint
class HomeFragment:BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    private val viewModel: AmazonViewModel by viewModels()
    override fun onBindView() {
        super.onBindView()
        viewModel.searchProducts("Phone")

        var adapter1 = ProductAdapter()
        viewModel.amazonLiveDate.observe(viewLifecycleOwner) {
            adapter1.submitList(it?.data?.products)
        }
        binding.recycler1.adapter = adapter1
        binding.recycler1.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)

        adapter1.itemClick = {
            findNavController().navigate(
                HomeFragmentDirections.actionHomeToProductDetailsFragment(
                    it
                )
            )
        }
    }
}