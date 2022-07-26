package com.example.kualitasudara.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.kualitasudara.NotificationHelper
import com.example.kualitasudara.R
import com.example.kualitasudara.databinding.FragmentHomeBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.*

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    lateinit var mAuth: FirebaseAuth
    private lateinit var dbRef: DatabaseReference


    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

//        val textView: TextView = binding.textHome
//        homeViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dbRef = FirebaseDatabase.getInstance().getReference("KualitasUdara/debu")
        dbRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val value = snapshot.value.toString()
//                Toast.makeText(context, value, Toast.LENGTH_SHORT).show()
                val debu = view.findViewById<TextView>(R.id.tvDataSensorPm2_5HomeVal)
                debu.text = value
            }
            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context, "Failed To Get Data", Toast.LENGTH_LONG).show()
            }
        })
        dbRef = FirebaseDatabase.getInstance().getReference("KualitasUdara/gas")
        dbRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val value = snapshot.value.toString()
//                Toast.makeText(context, value, Toast.LENGTH_SHORT).show()
                val gas = view.findViewById<TextView>(R.id.tvDataSensorCO2HomeVal)
                gas.text = value
            }
            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context, "Failed To Get Data", Toast.LENGTH_LONG).show()
            }
        })
        dbRef = FirebaseDatabase.getInstance().getReference("KualitasUdara/status")
        dbRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val value = snapshot.value.toString()
//                Toast.makeText(context, value, Toast.LENGTH_SHORT).show()
                val gas = view.findViewById<TextView>(R.id.tvStatusSensorCO2HomeVal)
                val debu = view.findViewById<TextView>(R.id.tvStatusSensorPm2_5HomeVal)
                gas.text = value
                debu.text = value
            }
            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context, "Failed To Get Data", Toast.LENGTH_LONG).show()
            }
        })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}