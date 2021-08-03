package com.ibrajix.branchclone.ui.fragments

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.daimajia.androidanimations.library.Techniques
import com.daimajia.androidanimations.library.YoYo
import com.ibrajix.branchclone.R
import com.ibrajix.branchclone.databinding.FragmentInviteBinding
import com.ibrajix.branchclone.ui.utils.Utility
import com.ibrajix.branchclone.utils.viewBinding
import nl.dionsegijn.konfetti.models.Shape
import nl.dionsegijn.konfetti.models.Size

class InviteFragment : Fragment() {

    private val binding by viewBinding(FragmentInviteBinding::bind)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_invite, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews(){
        handleClicks()
    }

    private fun handleClicks(){

        //on click button copy
        binding.button.setOnClickListener {

            //start konfetti view
            binding.viewKonfetti.build()
                .addColors(Color.YELLOW, Color.GREEN, Color.MAGENTA)
                .setDirection(0.0, 359.0)
                .setSpeed(1f, 0f)
                .setFadeOutEnabled(true)
                .setTimeToLive(500L)
                .addShapes(Shape.Square, Shape.Circle)
                .addSizes(Size(12))
                .setPosition(-50f, binding.viewKonfetti.width + 50f, -50f, -50f)
                .streamFor(300, 5000L)

          //start animation
            YoYo.with(Techniques.RotateInDownLeft)
                .duration(3000)
                .repeat(0)
                .playOn(binding.imageView7)

            //copy text
            Utility.copyText(requireContext(), requireContext().getString(R.string.ibrajix))

            //display toast
            Toast.makeText(requireContext(), "Referral code copied to clipboard.", Toast.LENGTH_LONG).show()

        }

    }

}