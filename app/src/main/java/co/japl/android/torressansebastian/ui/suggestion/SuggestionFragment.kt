package co.japl.android.torressansebastian.ui.suggestion

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.widget.ProgressBar
import co.japl.android.torressansebastian.R

class SuggestionFragment : Fragment() {
    private lateinit var webView:WebView
    private lateinit var progressBar:ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val rootView =  inflater.inflate(R.layout.fragment_suggestion, container, false)
        progressBar = rootView.findViewById(R.id.progressBar)
        webView = rootView.findViewById(R.id.suggestion)
        webView.settings.javaScriptEnabled = true
        webView.isVerticalScrollBarEnabled = true
        webView.loadUrl("https://docs.google.com/forms/d/e/1FAIpQLSepG68YyR52sJT-rT8zPDLvmmYubIybkOGtLv-yekDRWbw3Ig/viewform?embedded=true")

        return rootView
    }
}

