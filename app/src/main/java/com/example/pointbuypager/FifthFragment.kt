package com.example.pointbuypager

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.fragment.app.Fragment
import com.example.pointbuypager.databinding.FragmentFifthBinding


class FifthFragment: Fragment() {
    private lateinit var binding: FragmentFifthBinding
    val stats = intArrayOf(0,1,2,3,4,5,7,9)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentFifthBinding.inflate(inflater, container, false)

        resetFragment()

        binding.spnOnePb.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                (activity as MainActivity).updateStat(1,binding.spnOnePb.selectedItem.toString())
                val holder = stats[binding.spnOnePb.selectedItemPosition] + binding.tvValuePb.text.toString().toInt()
                binding.tvValuePb.text = updatePointBuy().toString()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }

        binding.spnTwoPb.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                (activity as MainActivity).updateStat(2,binding.spnTwoPb.selectedItem.toString())
                val holder = stats[binding.spnTwoPb.selectedItemPosition] + binding.tvValuePb.text.toString().toInt()
                binding.tvValuePb.text = updatePointBuy().toString()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }

        binding.spnThreePb.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                (activity as MainActivity).updateStat(3,binding.spnThreePb.selectedItem.toString())
                val holder = stats[binding.spnThreePb.selectedItemPosition] + binding.tvValuePb.text.toString().toInt()
                binding.tvValuePb.text = updatePointBuy().toString()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }

        binding.spnFourPb.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                (activity as MainActivity).updateStat(4,binding.spnFourPb.selectedItem.toString())
                val holder = stats[binding.spnFourPb.selectedItemPosition] + binding.tvValuePb.text.toString().toInt()
                binding.tvValuePb.text = updatePointBuy().toString()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }

        binding.spnFivePb.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                (activity as MainActivity).updateStat(5,binding.spnFivePb.selectedItem.toString())
                val holder = stats[binding.spnFivePb.selectedItemPosition] + binding.tvValuePb.text.toString().toInt()
                binding.tvValuePb.text = updatePointBuy().toString()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }

        binding.spnSixPb.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                (activity as MainActivity).updateStat(6,binding.spnSixPb.selectedItem.toString())
                binding.tvValuePb.text = updatePointBuy().toString()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }

        return binding.root
    }

    fun updatePointBuy(): Int {
        return stats[binding.spnOnePb.selectedItemPosition] +
                stats[binding.spnTwoPb.selectedItemPosition] +
                stats[binding.spnThreePb.selectedItemPosition] +
                stats[binding.spnFourPb.selectedItemPosition] +
                stats[binding.spnFivePb.selectedItemPosition] +
                stats[binding.spnSixPb.selectedItemPosition]
    }

    private fun resetFragment() {
        binding.spnOnePb.setSelection(0)
        binding.spnTwoPb.setSelection(0)
        binding.spnThreePb.setSelection(0)
        binding.spnFourPb.setSelection(0)
        binding.spnFivePb.setSelection(0)
        binding.spnSixPb.setSelection(0)
        binding.tvValuePb.text = updatePointBuy().toString()
    }
}