package com.fizz.school.adapter

import android.content.Context
import android.graphics.BitmapFactory
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.fizz.school.R
import com.fizz.school.models.ViewModel
import com.fizz.school.models.entities.Student
import java.io.File

class StudentListAdapter(val context: Context, val viewModel: ViewModel) :
    RecyclerView.Adapter<StudentListAdapter.StudentViewHolder>() {

    private var studentList = emptyList<Student>()

    class StudentViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val name:TextView=view.findViewById(R.id.student_name)
        val school:TextView=view.findViewById(R.id.school_name)
        val studentId:TextView=view.findViewById(R.id.student_id)
        val studentImage:ImageView=view.findViewById(R.id.student_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StudentViewHolder {
        val layout = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.student_card, parent, false)
        Log.d("TAG", "onBindViewHolder: ")
        return StudentViewHolder(layout)
    }

    override fun onBindViewHolder(holder: StudentViewHolder, position: Int) {
        val item = studentList[position]
        holder.name.text=item.studentName
        holder.school.text= item.schoolName
        holder.studentId.text=item.studentId.toString()
        if (item.studentImage.isNotEmpty()){
            val file= File(item.studentImage)
            val path : Uri = Uri.parse(file.absolutePath)
//            holder.studentImage.setImageBitmap(BitmapFactory.decodeFile(file.absolutePath))
            holder.studentImage.setImageBitmap(BitmapFactory.decodeFile(file.path))
        }
    }

    override fun getItemCount(): Int {
        return studentList.size
    }

    fun setData(student: List<Student>) {
        this.studentList = student
        notifyDataSetChanged()
    }
}