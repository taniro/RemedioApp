package tads.eaj.ufrn.remedioapp.ui.home

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import tads.eaj.ufrn.remedioapp.repository.RemedioRepository
import javax.inject.Inject

@HiltViewModel
class HomeViewModel  @Inject constructor(private var repository: RemedioRepository) : ViewModel() {
}