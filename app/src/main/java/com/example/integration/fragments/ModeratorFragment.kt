package com.example.integration.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import android.widget.Toast.makeText
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.integration.ModeratorActivity
import com.example.integration.R
import com.example.integration.adapter.ModeratorAdapter
import com.example.integration.model.ModeratorModel
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class ModeratorFragment(private val context: ModeratorActivity ) : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_moderator, container, false)
        val db = Firebase.firestore
        val reportList = arrayListOf<ModeratorModel>()

        db.collection("reports")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    reportList.add(document.toObject(ModeratorModel::class.java))
                }

            }
            .addOnFailureListener { exception ->
                Toast.makeText(context, "erreur requete base de donnée", LENGTH_SHORT).show()
            }

        val modRecyclerView = view.findViewById<RecyclerView>(R.id.mod_recycle_view)
        modRecyclerView.adapter = ModeratorAdapter(context, reportList, R.layout.layout_moderator_report)

        return view
    }

}