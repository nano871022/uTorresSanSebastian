package co.japl.android.torressansebastian.ui.box_suggestion

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.widget.ProgressBar
import co.japl.android.torressansebastian.R

class BoxSuggestionFragment : Fragment() {
    private lateinit var webView: WebView
    private lateinit var progressBar: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val rootView =  inflater.inflate(R.layout.fragment_box_suggestion, container, false)
        progressBar = rootView.findViewById(R.id.box_suggestion_progressBar)
        webView = rootView.findViewById(R.id.box_suggestion)
        webView.settings.javaScriptEnabled = true
        webView.isVerticalScrollBarEnabled = true
        webView.loadUrl("https://docs.google.com/forms/d/e/1FAIpQLSeCDfxLvB1Tuh-cEzGP6xUvfHFwm6LTepvr1rgu_WrzUDzOEA/viewform?embedded=true")
        return rootView
    }
}