package co.japl.android.torressansebastian.ui.admin_pay

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import co.japl.android.torressansebastian.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AdministrationPay.newInstance] factory method to
 * create an instance of this fragment.
 */
class AdministrationPay : Fragment(), View.OnClickListener {
    private lateinit var button:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_administration_pay, container, false)
        val btnPay:Button = root.findViewById(R.id.btnGoToPagePay)
        btnPay.setOnClickListener(this)
        return root
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.btnGoToPagePay->{
                val url = Uri.parse(getString(R.string.link_page))
                val intent = Intent(Intent.ACTION_VIEW,url)
                startActivity(intent)
            }
        }
    }


}