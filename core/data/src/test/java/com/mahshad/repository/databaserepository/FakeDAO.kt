import androidx.lifecycle.LiveData
import com.mahshad.database.DAO
import com.mahshad.database.ObjectEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class FakeDAO : DAO {
    private val listOfObjects = mutableListOf<ObjectEntity>()
    private val _flowOfObjects = MutableStateFlow(emptyList<ObjectEntity>())
    val flowOfObjects: StateFlow<List<ObjectEntity>> = _flowOfObjects

    private fun refreshFlow() {
        _flowOfObjects.value = listOfObjects.toList()
    }

    override suspend fun insert(mobileObject: ObjectEntity) {
        listOfObjects.add(mobileObject)
        refreshFlow()
    }

    override suspend fun insertAll(mobileObjects: List<ObjectEntity>) {
        listOfObjects.addAll(mobileObjects)
        refreshFlow()
    }

    override fun getAll(): Flow<List<ObjectEntity>> = flowOfObjects

    override suspend fun searchById(mobileId: Int): ObjectEntity =
        listOfObjects.first { it.id.toInt() == mobileId }

    override suspend fun delete(mobileId: Int) {
        listOfObjects.removeIf { it.id.toInt() == mobileId }
        refreshFlow()
    }

    override suspend fun deleteAll() {
        listOfObjects.clear()
        refreshFlow()
    }

    // if your DAO interface requires this:
    override fun getAllLively(): LiveData<List<ObjectEntity>> {
        throw UnsupportedOperationException("Not needed for repository tests")
    }
}
