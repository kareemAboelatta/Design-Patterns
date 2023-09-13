package _patterns.behavioral.strategy

enum class Genre {
    ACTION, ADVENTURE, SCIFI, DRAMA, CRIME, ROMANCE, THRILLER, COMEDY, HORROR, FANTASY
}

data class Movie(val title: String, val genres: List<Genre>, val releaseYear: Int, val rating: Double)

interface FilterStrategy {
    fun applyFilter(movies: List<Movie>): List<Movie>
}

class GenreFilter(private val selectedGenre: Genre) : FilterStrategy {
    override fun applyFilter(movies: List<Movie>): List<Movie> {
        return movies.filter { movie -> selectedGenre in movie.genres }
    }
}

class YearFilter(private val selectedYear: Int) : FilterStrategy {
    override fun applyFilter(movies: List<Movie>): List<Movie> {
        return movies.filter { movie -> movie.releaseYear == selectedYear }
    }
}

class RateFilter(private val selectedRate: Double) : FilterStrategy {
    override fun applyFilter(movies: List<Movie>): List<Movie> {
        return movies.filter { movie -> movie.rating >= selectedRate }
    }
}

class MovieFilterContext(private var movies: List<Movie>) {

    fun applyFilter(filterStrategy: FilterStrategy, moviesFilteredBefore: List<Movie> = movies): List<Movie> {
        return filterStrategy.applyFilter(moviesFilteredBefore)

    }
}

fun fetchMoviesFromServer(): List<Movie> {
    val movies = mutableListOf<Movie>()

    // Add movies with different genres and details
    val movie1 = Movie("The Avengers", listOf(Genre.ACTION, Genre.ADVENTURE, Genre.SCIFI), 2012, 8.0)
    val movie2 = Movie("Inception", listOf(Genre.ACTION, Genre.ADVENTURE, Genre.SCIFI), 2010, 8.8)
    val movie3 = Movie("The Shawshank Redemption", listOf(Genre.DRAMA, Genre.CRIME), 1994, 9.3)
    val movie4 = Movie("Forrest Gump", listOf(Genre.DRAMA, Genre.ROMANCE), 1994, 8.8)
    val movie5 = Movie("Pulp Fiction", listOf(Genre.CRIME, Genre.DRAMA), 1994, 8.9)
    val movie6 = Movie("The Matrix", listOf(Genre.ACTION, Genre.SCIFI), 1999, 8.7)
    val movie7 = Movie("Titanic", listOf(Genre.DRAMA, Genre.ROMANCE), 1997, 7.8)
    val movie8 = Movie("Jurassic Park", listOf(Genre.ACTION, Genre.ADVENTURE, Genre.SCIFI), 1993, 8.1)
    val movie9 = Movie("The Dark Knight", listOf(Genre.ACTION, Genre.CRIME, Genre.DRAMA), 2008, 9.0)
    val movie10 = Movie("Gladiator", listOf(Genre.ACTION, Genre.ADVENTURE, Genre.DRAMA), 2000, 8.5)

    val movie11 = Movie("The Shining", listOf(Genre.HORROR, Genre.DRAMA), 1980, 8.4)
    val movie12 = Movie("Avatar", listOf(Genre.ACTION, Genre.ADVENTURE, Genre.FANTASY), 2009, 7.8)
    val movie13 = Movie("The Godfather", listOf(Genre.CRIME, Genre.DRAMA), 1972, 9.2)
    val movie14 = Movie("The Lord of the Rings", listOf(Genre.ACTION, Genre.ADVENTURE, Genre.FANTASY), 2001, 8.8)
    val movie15 = Movie("The Silence of the Lambs", listOf(Genre.CRIME, Genre.DRAMA, Genre.THRILLER), 1991, 8.6)

    movies.addAll(listOf(movie1, movie2, movie3, movie4, movie5, movie6, movie7, movie8, movie9, movie10,
        movie11, movie12, movie13, movie14, movie15))

    // Add more movies as needed...

    return movies
}

fun main() {
    val allMovies = fetchMoviesFromServer()
    val filterContext = MovieFilterContext(allMovies)

    // Apply filters based on user selections
    val selectedGenre = Genre.ACTION
    val selectedYear = 1994
    val selectedRate = 8.0

    val genreFilter = GenreFilter(selectedGenre)
    val yearFilter = YearFilter(selectedYear)
    val rateFilter = RateFilter(selectedRate)

    val filteredMoviesByYear = filterContext.applyFilter(yearFilter)
    val filteredMoviesByYearAndRate = filterContext.applyFilter(rateFilter)


    // Display the filtered list of movies
    println("Filtered Movies:")
    filteredMoviesByYearAndRate.forEach { movie ->
        println("${movie.title} (${movie.releaseYear}) - Rating: ${movie.rating} - Genres: ${movie.genres.joinToString()}")
    }
}



















