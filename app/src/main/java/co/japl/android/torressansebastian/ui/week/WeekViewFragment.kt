package co.japl.android.torressansebastian.ui.week

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import co.japl.android.torressansebastian.databinding.WeekViewBinding


class WeekViewFragment : Fragment() {
    private var _binding: WeekViewBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater,
                          container: ViewGroup?,
                          savedInstanceState: Bundle?
    ): View {
        _binding = WeekViewBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}