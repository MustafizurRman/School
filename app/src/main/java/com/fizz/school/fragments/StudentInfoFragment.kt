package com.fizz.school.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fizz.school.R
import com.fizz.school.adapter.StudentListAdapter
import com.fizz.school.databinding.FragmentStudentInfoBinding
import com.fizz.school.models.ViewModel


class StudentInfoFragment : Fragment() {

    private var _binding: FragmentStudentInfoBinding? = null
    private val binding get() = _binding!!
    //private lateinit var recyclerView: RecyclerView
    private lateinit var viewModel: ViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentStudentInfoBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[ViewModel::class.java]
        val adapter = StudentListAdapter(requireContext(), viewModel)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        viewModel.readAllStudent.observe(viewLifecycleOwner, Observer {
            adapter.setData(it)
        })
        binding.addStudentButton.setOnClickListener {
            findNavController().navigate(R.id.action_studentInfoFragment_to_addStudentFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}