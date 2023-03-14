package usg.ihealth.ui.fragments.bmi

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.text.SpannableString
import android.text.style.ForegroundColorSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import usg.ihealth.databinding.FragmentResultBinding
import usg.ihealth.ui.utils.Utils
import kotlin.math.roundToInt

class ResultFragment : Fragment() {

    private var _binding: FragmentResultBinding? = null
    private val binding get() = _binding!!
    private val args: ResultFragmentArgs by navArgs()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentResultBinding.inflate(inflater, container, false)

        val bmi = (args.bmi * 100 / 100).roundToInt().toFloat()
        val age = args.age

        // --- This code suggests that there is a variable named "binding" which is of type "ViewBinding".
        // The apply() function is called on this binding object, which allows for the application of changes/modifications
        // to multiple properties of the object. The curly braces inside the apply() function indicate the scope in which
        // these changes/modifications can be made. ---/
        binding.apply {
            yourBmi.text = bmi.toString()
            condition.text = usg.ihealth.ui.utils.Utils.checkAdult(age.toInt(), bmi)

            recalculate.setOnClickListener {
                requireActivity().onBackPressed()
            }
            val spannable = SpannableString("Suggestion: ${Utils.suggestions(bmi)}")
            val fColor = ForegroundColorSpan(Color.parseColor("#FE0049"))
            spannable.setSpan(fColor, 0, 11, SpannableString.SPAN_INCLUSIVE_EXCLUSIVE)

            suggestion.text = spannable
            val spannable1 = SpannableString("$age (${category(age.toInt())})")
            ageTxt.text = spannable1

            share.setOnClickListener {
                shareContent(bmi)
            }
        }
        return binding.root
    }

    private fun category(age: Int): String {
        val category: String = when (age) {
            in 2..19 -> {
                "Teenage"
            }
            else -> {
                "Adult"
            }
        }
        return category
    }

    private fun shareContent(bmi: Float) {
        try {
            val strShareMessage = "Hello!! my BMI is ${bmi}\n\n" +
                    "my current condition: ${binding.condition.text}\n" +
                    "my age is: ${binding.ageTxt.text}\n\n" +
                    "App suggested me that: ${binding.suggestion.text}"

            val i = Intent(Intent.ACTION_SEND)
            i.putExtra(Intent.EXTRA_INTENT, strShareMessage)
            i.type = "text/plain"
            startActivity(
                Intent.createChooser(
                    i,
                    "Select App to share with your friends or doctor"
                )
            )
        } catch (e: Exception) {
            Toast.makeText(requireContext(), e.toString(), Toast.LENGTH_LONG).show()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}