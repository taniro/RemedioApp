package tads.eaj.ufrn.remedioapp.repository

import kotlinx.coroutines.flow.Flow
import tads.eaj.ufrn.remedioapp.dao.RemedioDao
import tads.eaj.ufrn.remedioapp.model.Remedio
import javax.inject.Inject

class RemedioRepository @Inject constructor(private var dao:RemedioDao) : IRemedioRepository {
    override fun listAll(): Flow<List<Remedio>> {
        return dao.listALl()
    }

    override fun create(r: Remedio) {
        dao.create(r)
    }
}