package com.stardust.proyectokotlin.fragments

import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.squareup.picasso.Picasso
import com.stardust.proyectokotlin.R
import com.stardust.proyectokotlin.model.Contact


class DetailedContactFragment : Fragment() {
    private lateinit var imageView: ImageView
    private lateinit var txtName: TextView
    private lateinit var txtWork: TextView
    private lateinit var txtPhone: TextView
    private lateinit var txtEmail: TextView

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_detailed_contact, container, false)

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        txtName = view!!.findViewById(R.id.itemContactName)
        txtWork = view!!.findViewById(R.id.itemContactWork)
        txtEmail = view!!.findViewById(R.id.itemContactEmail)
        txtPhone = view!!.findViewById(R.id.itemContactPhone)
        imageView = view!!.findViewById(R.id.itemContactPhoto)

        val bundle = arguments
        val contact = bundle!!.getSerializable("contacto") as Contact?


        if (contact != null) {
        txtName.text = contact.name
        txtWork.text = contact.work
        txtPhone.text = contact.phone
        txtEmail.text = contact.email
        if (!contact.photo.isNullOrEmpty())
            Picasso.get().load(contact.photo).into(imageView)
        }

    }

}