package co.japl.android.torressansebastian.ui.ContactUs

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
import android.widget.Button
import co.japl.android.torressansebastian.R
import co.japl.android.torressansebastian.databinding.FragmentContactUsBinding

class ContactUsFragment : Fragment() , View.OnClickListener{

    lateinit var btnAdminNumber : AppCompatImageButton
    lateinit var btnAdminEmail: AppCompatImageButton
    lateinit var btnAuxiliarEmail: AppCompatImageButton
    lateinit var btnConsejoEmail: AppCompatImageButton
    lateinit var btnEntranceNumber : AppCompatImageButton
    private var _binding: FragmentContactUsBinding? = null
    lateinit var btnMessageAdmin: AppCompatImageButton

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val slideshowViewModel =
            ViewModelProvider(
                this,
                ViewModelProvider.NewInstanceFactory()
            ).get(ContactUsViewModel::class.java)

        _binding = FragmentContactUsBinding.inflate(inflater, container, false)
        val root: View = binding.root
        configButtons()
        return root
    }

    private fun configButtons(){
        btnAdminNumber = binding.root.findViewById(R.id.btnCallAdmin)
        btnAdminNumber.setOnClickListener(this)

        btnEntranceNumber = binding.root.findViewById(R.id.btnCallEntrance)
        btnEntranceNumber.setOnClickListener(this)

        btnAdminEmail = binding.root.findViewById(R.id.btnSendEmailAdmin)
        btnAdminEmail.setOnClickListener(this)

        btnAuxiliarEmail = binding.root.findViewById(R.id.btnSendEmailAux)
        btnAuxiliarEmail.setOnClickListener(this)

        btnConsejoEmail = binding.root.findViewById(R.id.btnSendEmailConsejo)
        btnConsejoEmail.setOnClickListener(this)

        btnMessageAdmin = binding.root.findViewById(R.id.btnMessageAdmin)
        btnMessageAdmin.setOnClickListener(this)

    }

    fun call(number:String){
        val uri:Uri = Uri.parse("tel:$number")
        val intent:Intent = Intent(Intent.ACTION_DIAL,uri)
        startActivity(intent)
    }

    fun email(email:String){
        val sent:Intent = Intent(Intent.ACTION_SEND)
            sent.type ="text/plain"
            sent.putExtra(Intent.EXTRA_EMAIL,arrayOf(email))
            sent.data = Uri.parse("mailto:")
            sent.putExtra(Intent.EXTRA_SUBJECT,"Administracion")

        startActivity(Intent.createChooser(sent,"Send email"))
    }

    fun whatsapp(whatsapp:String){
        val country = getString(R.string.country_whatsapp)
        val url = "https://api.whatsapp.com/send?phone=$country$whatsapp";
        val instant = Intent(Intent.ACTION_VIEW);
        instant.setData(Uri.parse(url));
        startActivity(instant);
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btnCallAdmin->call(getString(R.string.administration_number).replace(" ",""))
            R.id.btnCallEntrance->call(getString(R.string.entrance_number).replace(" ",""))
            R.id.btnSendEmailAdmin->email(getString(R.string.administration_email))
            R.id.btnSendEmailAux->email(getString(R.string.auxiliar_email))
            R.id.btnSendEmailConsejo->email(getString(R.string.consejo_email))
            R.id.btnMessageAdmin->whatsapp(getString(R.string.administration_number).replace(" ",""))
        }
    }
}