import app.cash.turbine.test
import com.mahshad.home.homebasketfragment.HomeBasketUiEvent
import com.mahshad.home.homebasketfragment.HomeBasketViewModel
import com.mahshad.model.data.Object
import com.mahshad.repository.databaserepository.BasketRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

@ExperimentalCoroutinesApi
class HomeBasketViewModelTest {
    @Mock
    private lateinit var fakeBasketRepository: BasketRepository
    private lateinit var homeBasketViewModel: HomeBasketViewModel

    @Before
    fun setup() {
        MockitoAnnotations.openMocks(this)
        homeBasketViewModel = HomeBasketViewModel(fakeBasketRepository)
    }

    @Test
    fun `updateUiState - when repository returns data - uiState is Loading and Successful`() =
        runTest {
            val mockObjects = listOf(Object.DEFAULT)

            `when`(fakeBasketRepository.selectAll())
                .thenReturn(flow { emit(mockObjects) })

            homeBasketViewModel.uiState.test {
                assertEquals(HomeBasketUiEvent.Loading, awaitItem())
                homeBasketViewModel.updateUiState()
                val finalState = awaitItem()
                assertTrue(finalState is HomeBasketUiEvent.Successful)
                assertEquals(
                    mockObjects,
                    (finalState as HomeBasketUiEvent.Successful).devices
                )
                cancelAndIgnoreRemainingEvents()
            }
        }
}
