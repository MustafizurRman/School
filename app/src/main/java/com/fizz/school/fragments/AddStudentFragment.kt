package com.fizz.school.fragments

import android.app.Activity
import android.app.Activity.RESULT_OK
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.fizz.school.R
import com.fizz.school.databinding.FragmentAddStudentBinding
import com.fizz.school.models.ViewModel
import com.fizz.school.models.entities.Student


class AddStudentFragment : Fragment() {

    private var _binding: FragmentAddStudentBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: ViewModel
    private var imagePath = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddStudentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this)[ViewModel::class.java]

        binding.userImageView.setOnClickListener{
            val intent= Intent(Intent.ACTION_PICK)
            intent.type="./image*"
            intent.data= MediaStore.Images.Media.EXTERNAL_CONTENT_URI
            startActivityForResult(intent,1)
        }
        binding.saveButton.setOnClickListener {
            val id = binding.studentIdEditText.text.toString()
            val name = binding.nameEditText.text.toString()
            val semester = binding.semesterEditText.text.toString()
            val schoolName = binding.schoolNameEditText.text.toString()
            val subjectTaken = binding.subjectNameEditText.text.toString()
            if (!TextUtils.isEmpty(id) && !TextUtils.isEmpty(name) && !TextUtils.isEmpty(semester) && !TextUtils.isEmpty(
                    schoolName
                ) && !TextUtils.isEmpty(subjectTaken)
            ) {
                viewModel.addStudent(
                    Student(
                        Integer.parseInt(id),
                        name,
                        Integer.parseInt(semester),
                        schoolName,
                        subjectTaken,
                        imagePath
                    )
                )
                findNavController().navigate(R.id.action_addStudentFragment_to_studentInfoFragment)
            } else Toast.makeText(context, "Fill up the fields", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode==1 && resultCode==RESULT_OK){
            val imageUri: Uri? = data?.data
            binding.userImageView.setImageURI(imageUri)
//            imagePath = getRealPathFromURI(imageUri!!, requireActivity() )
            imagePath = imageUri.toString()
        }
    }
    private fun getRealPathFromURI(contentUri: Uri, activityContext: Activity): String {
        val proj = arrayOf(MediaStore.Images.Media.DATA)
        val cursor = activityContext.managedQuery(contentUri, proj, null, null, null)
        val columnIndex = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA)
        cursor.moveToFirst()
        return cursor.getString(columnIndex)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}