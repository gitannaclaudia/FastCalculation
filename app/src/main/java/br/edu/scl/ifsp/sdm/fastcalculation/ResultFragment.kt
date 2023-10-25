package br.edu.scl.ifsp.sdm.fastcalculation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.edu.scl.ifsp.sdm.fastcalculation.Extras.EXTRA_POINTS
import br.edu.scl.ifsp.sdm.fastcalculation.Extras.EXTRA_SETTINGS
import br.edu.scl.ifsp.sdm.fastcalculation.databinding.FragmentResultBinding


class ResultFragment : Fragment() {
    private lateinit var fragmentResultBinding: FragmentResultBinding

    private lateinit var points: String
    private lateinit var settings: Settings


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            settings = it.getParcelable(EXTRA_SETTINGS) ?: Settings()
            points = it.getString(EXTRA_POINTS) ?: points
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentResultBinding = FragmentResultBinding.inflate(inflater, container, false)
        points.also {
            fragmentResultBinding.scoreTv.text = it
        }
        fragmentResultBinding.restartBt.setOnClickListener {
            (context as OnPlayGame).onPlayGame()
        }
        return fragmentResultBinding.root
    }

    companion object {
        @JvmStatic
        fun newInstance(settings: Settings, points: String) =
            ResultFragment().apply {
                arguments = Bundle().apply {
                    putString(EXTRA_POINTS, points)
                    putParcelable(EXTRA_SETTINGS, settings)
                }
            }
    }
}