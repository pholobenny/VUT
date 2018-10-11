/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vut.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * Movie data class runs all the database functionality 
 * @author Pholo Benny (210124385)
 */
public class MovieDA {

    private static ArrayList<Movies> arMovies;
    private static Connection conn;
    private static Statement st;
    private static ResultSet rs;

    /**
     * Connecting to the database
     */
    public static void initialize() throws DataStorageException {
        String url, username, password, sqlLine;
        Movies movie;
        try {
            Class.forName("com.mysql..jdbc.Driver");
            url = "jdbc:mysql://localhost/movie_finderdb";
            username = "vut";
            password = "";
            conn = DriverManager.getConnection(url, username, password);
            sqlLine = "select * from tblmovie";
            st = conn.createStatement();
            rs = st.executeQuery(sqlLine);
            while (rs.next()) {
                movie = new Movies(rs.getString("title"), rs.getString("director"), rs.getInt("release_year"), rs.getDouble("price"));
                arMovies.add(movie);
            }

        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    /**
     * Terminating connection established by initialize
     */
    public static void terminate() throws DataStorageException {
        try {
            if (!conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    /**
     * Get all the movies in the database
     *
     * @return all the movies in the database
     */
    public static ArrayList<Movies> getAll() throws NotFoundException {
        String sqlLine = "select * from tblmovie";
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sqlLine);
            while (rs.next()) {
                Movies movies = new Movies(rs.getString("title"), rs.getString("director"), rs.getInt("release_year"), rs.getDouble("price"));
                arMovies.add(movies);
            }
        } catch (SQLException ex) {
            throw new NotFoundException(ex.getMessage());
        }
        return arMovies;
    }

    /**
     * Get all movies by director
     *
     * @param directorName the name of the director
     * @return list of movies that contains the director name
     */
    public static ArrayList<Movies> returnByDirector(String directorName) throws NotFoundException {
        String sqlLine = "Select * from tblmovie where director LIKE \'%\'" + directorName + "\'%\';";
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sqlLine);

            while (rs.next()) {
                Movies movies = new Movies(rs.getString("title"), rs.getString("director"), rs.getInt("release_year"), rs.getDouble("price"));
                arMovies.add(movies);
            }
        } catch (SQLException ex) {
            throw new NotFoundException(ex.getMessage());
        }
        return arMovies;
    }

    /**
     * Get all movies with by title
     *
     * @param title the title of the movie
     * @return the list of movies that contains the title
     */
    public static ArrayList<Movies> returnByTitle(String title) throws NotFoundException {
        String sqlLine = "Select * from tblmovie where director LIKE \'%\'" + title + "\'%\';";
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sqlLine);

            while (rs.next()) {
                Movies movies = new Movies(rs.getString("title"), rs.getString("director"), rs.getInt("release_year"), rs.getDouble("price"));
                arMovies.add(movies);
            }
        } catch (SQLException ex) {
            throw new NotFoundException(ex.getMessage());
        }
        return arMovies;
    }

    /**
     * Get all the movies that where released after a specific release year
     *
     * @param year the year of the movie release
     * @return list of movie that where release after that year
     */
    public static ArrayList<Movies> producedAfter(int year) throws NotFoundException {
        String sqlLine = "Select * from tblmovie;";
        ArrayList<Movies> list = new ArrayList<>();
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sqlLine);
            while (rs.next()) {
                Movies movies = new Movies(rs.getString("title"), rs.getString("director"), rs.getInt("release_year"), rs.getDouble("price"));
                arMovies.add(movies);
            }
            for (Movies m : arMovies) {
                if (m.getRelease_year() > year) {
                    list.add(m);
                }
            }
        } catch (SQLException ex) {
            throw new NotFoundException(ex.getMessage());
        }
        return list;
    }

    /**
     * Get all the movies that where released before a specific release year
     *
     * @param year the year
     * @return list of movies that where released before that year
     */
    public static ArrayList<Movies> producedBefore(int year) throws NotFoundException {
        String sqlLine = "Select * from tblmovie;";
        ArrayList<Movies> list = new ArrayList<>();
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sqlLine);
            while (rs.next()) {
                Movies movies = new Movies(rs.getString("title"), rs.getString("director"), rs.getInt("release_year"), rs.getDouble("price"));
                arMovies.add(movies);
            }
            for (Movies m : arMovies) {
                if (m.getRelease_year() < year) {
                    list.add(m);
                }
            }
        } catch (SQLException ex) {
            throw new NotFoundException(ex.getMessage());
        }
        return list;
    }

    /**
     * Reduce the prices of all the movies released before 2000 whose prices are
     * more that R120 using specific percentage
     *
     * @param percentage
     */
    public static void updatePrice(int percentage) throws NotFoundException {
        String line = "Select * from tblmovie where realesed_year <2000 AND price >120;";
        try {
            st = conn.createStatement();
            rs = st.executeQuery(line);
            while (rs.next()) {                
               double price = rs.getDouble("price")* (percentage/100);
               double newPrice = rs.getDouble("price") - price;                
                String sqlLine = "UPDATE tblmovie SET price="+newPrice+" WHERE title="+rs.getString("title");
                st.executeUpdate(sqlLine);
            }
        } catch (SQLException ex) {
            throw new NotFoundException(ex.getMessage());
        }
    }

    /**
     * Delete the movie by title
     *
     * @param title the title of the movie
     */
    public static void deleteMovie(String title) throws NotFoundException {
        String sqlLine = "DELETE FROM tblmovie WHERE title=" + title + ";";
        try {
            st = conn.createStatement();
            st.executeUpdate(sqlLine);
        } catch (SQLException ex) {
            throw new NotFoundException(ex.getMessage());
        }

    }

    /**
     * Get all movie title from the database
     *
     * @return list of movie title
     */
    public static ArrayList<String> retrieveTitles() throws NotFoundException {
        String sqlLine = "select title from tblmovie";
        ArrayList<String> list = new ArrayList<>();
        try {
            st = conn.createStatement();
            rs = st.executeQuery(sqlLine);
            while (rs.next()) {
                list.add(rs.getString("title"));
            }
        } catch (SQLException ex) {
            throw new NotFoundException(ex.getMessage());
        }
        return list;
    }

   /**
    * Add a new movie to the database
    * @param movie the new movie
    * @throws DuplicateExeption if the movie exist already
    */
    public static void addMovie(Movies movie) throws DuplicateExeption {
        boolean duplicate = false;
        // Get all the movies and validate if the movie is not stored in the database 
        // adding a new movie
        try {
            getAll(); //this is to get all the movies in the database
            for (int i = 0; i < arMovies.size() && !duplicate; i++) {
                Movies temp = arMovies.get(i);
                if (temp.getTitle().equalsIgnoreCase(movie.getTitle()) && temp.getDirector().equalsIgnoreCase(movie.getDirector())) {
                    duplicate = true;
                }
            }
            // If the movie is not found add the movie
            if (duplicate) {
                throw new DuplicateExeption("Movie exists already");
            } else {
                String line = "INSERT INTO tblmovie VALUES(null,\'" + movie.getTitle() + "\',\'" + movie.getDirector()
                        + "\'," + movie.getRelease_year() + "," + movie.getPrice() + ");";
                st = conn.createStatement();
                st.executeUpdate(line);
            }
        } catch (Exception ex) {
            throw new DuplicateExeption(ex.getMessage());
        }

    }

}
