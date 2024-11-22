import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.kotlingabiebruno.database.migration.model.Livro

@Dao
interface LivroDao {
    @Insert
    suspend fun insert(livro: Livro)

    @Query("SELECT * FROM livro")
    suspend fun getAll(): List<Livro> // Retorna a lista de livros

    @Update
    suspend fun update(livro: Livro) // Alterando para usar a entidade Livro diretamente

    @Delete
    suspend fun delete(livro: Livro) // Alterando para usar a entidade Livro diretamente
}
