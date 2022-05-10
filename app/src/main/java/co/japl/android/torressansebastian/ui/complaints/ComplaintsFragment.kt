package co.japl.android.torressansebastian.ui.complaints

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import co.japl.android.torressansebastian.R

class ComplaintsFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_complaints, container, false)
        val webView:WebView = rootView.findViewById(R.id.complaints)
        webView.settings.javaScriptEnabled = true
        webView.isVerticalScrollBarEnabled = true
        webView.loadUrl("https://docs.google.com/forms/d/e/1FAIpQLSdbdAiijYLkC64kxelmPCeYovBos-X-wXy_uycJsWpVj_5oJw/viewform?embedded=true")

        return rootView
    }
}