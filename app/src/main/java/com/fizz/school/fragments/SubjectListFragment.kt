package com.fizz.school.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.fizz.school.R
import com.fizz.school.adapter.SubjectListAdapter
import com.fizz.school.databinding.FragmentSubjectListBinding
import com.fizz.school.models.ViewModel


class SubjectListFragment : Fragment() {

    private var _binding:FragmentSubjectListBinding?=null
    val binding get()=_binding!!
    private lateinit var viewModel:ViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding=FragmentSubjectListBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel=ViewModelProvider(this)[ViewModel::class.java]
        val adapter = SubjectListAdapter(requireContext(),viewModel)
        binding.recyclerViewSubject.adapter=adapter
        binding.recyclerViewSubject.layoutManager=LinearLayoutManager(requireContext())
        viewModel.readAllSubject.observe(viewLifecycleOwner, Observer { adapter.setSubject(it) })
        binding.addSubjectButton.setOnClickListener{findNavController().navigate(R.id.action_subjectListFragment_to_addSubjectFragment)}
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }
}