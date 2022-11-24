package tads.eaj.ufrn.remedioapp.ui.dashboard


import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import tads.eaj.ufrn.remedioapp.model.Remedio
import tads.eaj.ufrn.remedioapp.repository.RemedioRepository
import javax.inject.Inject


@HiltViewModel
class DashboardViewModel @Inject constructor(var repository: RemedioRepository) : ViewModel() {

    var remedio = MutableLiveData<Remedio>()

    init {
        remedio.value = Remedio("", 0f)
    }

    fun cadastrarButtonEvent(){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                remedio.value?.let { repository.create(it) }
            }
        }
    }
}