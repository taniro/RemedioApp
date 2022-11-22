package tads.eaj.ufrn.remedioapp.repository

import kotlinx.coroutines.flow.Flow
import tads.eaj.ufrn.remedioapp.model.Remedio

interface IRemedioRepository {
    fun listAll(): Flow<List<Remedio>>
    fun create(r:Remedio)
}