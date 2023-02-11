package usg.ihealth.ui.tracing

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TracingViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is tracing Fragment"
    }
    val text: LiveData<String> = _text
}