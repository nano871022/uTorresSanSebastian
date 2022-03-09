package co.japl.android.torressansebastian.ui.location

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.support.v4.app.Fragment
import android.arch.lifecycle.ViewModelProvider
import android.content.Intent
import android.net.Uri
import android.support.v7.widget.AppCompatImageButton
import co.japl.android.torressansebastian.R
import co.japl.android.torressansebastian.databinding.FragmentLocationBinding

class LocationFragment : Fragment(), View.OnClickListener {

    private var _binding: FragmentLocationBinding? = null
    lateinit var btnMap: AppCompatImageButton

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentLocationBinding.inflate(inflater, container, false)
        val root: View = binding.root

        btnMap = root.findViewById(R.id.btnMaps)
        btnMap.setOnClickListener(this)

        return root
    }

    fun location(){
        val gms = Uri.parse("geo:6.2412581,-75.5692183?q=torres san sebastian")
        val intent = Intent(Intent.ACTION_VIEW,gms)
        intent.setPackage("com.google.android.apps.maps")
        startActivity(intent)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btnMaps->location()
        }
    }
}