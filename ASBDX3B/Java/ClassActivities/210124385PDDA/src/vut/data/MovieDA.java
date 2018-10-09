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
 *
 * @author benny
 */
public class MovieDA {

    private static ArrayList<Movie> arMovie;
    private static Connection conn;

    /**
     * Connecting to the database
     */
    public void initialize() throws DataStorageException {
        String url, username, password, sqlLine;
        Movie movie;
        try {
            Class.forName("com.mysql..jdbc.Driver");
            url = "jdbc:mysql://localhost/movie_finderdb";
            username = "vut";
            password = "";
            conn = DriverManager.getConnection(url, username, password);
            sqlLine = "select * from tblmovie";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sqlLine);
            while (rs.next()) {
                movie = new Movie(rs.getString("title"), rs.getString("director"), rs.getInt("release_year"), rs.getDouble("price"));
                arMovie.add(movie);
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
    public void terminate() throws DataStorageException {

        try {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("select * from tblmovie");
            for (int i = 0; i < arMovie.size(); i++) {
                while (rs.next()) {
                    if (rs.getString("title").equalsIgnoreCase(arMovie.get(i).getTitle())) {
                        //CHECK IF ALL THE VALUS ARE THE SAME IF NOT UPDATE
                        
                        
                        st.executeQuery("UPDATE FROM tblmovie SET where title = " + arMovie.get(0).getTitle() + "");
                    }
                }
            }

            conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
    }

    /**
     * Get all the movies in the database
     *
     * @return all the movies in the database
     */
    public ArrayList<Movie> getAll() {
        return arMovie;  // just returning the shallow copy of the data
    }

    /**
     * Get all movies by director
     *
     * @param directorName the name of the director
     * @return list of movies that contains the director name
     */
    public ArrayList<Movie> returnByDirector(String directorName) {
        ArrayList<Movie> list = new ArrayList<>();
        for (Movie m : arMovie) {
            if (m.getDirector().matches("(?i)(" + directorName + ").*")) {
                list.add(m);
            }
        }
        return list;
    }

    /**
     * Get all movies with by title
     *
     * @param title the title of the movie
     * @return the list of movies that contains the title
     */
    public ArrayList<Movie> returnByTitle(String title) {
        ArrayList<Movie> list = new ArrayList<>();
        for (Movie m : arMovie) {
            if (m.getTitle().matches("(?i)(" + title + ").*")) {
                list.add(m);
            }
        }
        return list;
    }

    /**
     * Get all the movies that where released after a specific release year
     *
     * @param year the year of the movie release
     * @return list of movie that where release after that year
     */
    public ArrayList<Movie> producedAfter(int year) {
        ArrayList<Movie> list = new ArrayList<>();
        for (Movie m : arMovie) {
            if (m.getRelease_year() > year) {
                list.add(m);
            }
        }
        return list;
    }

    /**
     * Get all the movies that where released before a specific release year
     *
     * @param year the year
     * @return list of movies that where released before that year
     */
    public ArrayList<Movie> producedBefore(int year) {
        ArrayList<Movie> list = new ArrayList<>();
        for (Movie m : arMovie) {
            if (m.getRelease_year() < year) {
                list.add(m);
            }
        }
        return list;
    }

    /**
     * Reduce the prices of all the movies released before 2000 whose prices are
     * more that R120 using specific percentage
     *
     * @param percentage
     */
    public void updatePrice(int percentage) {
        for (int i = 0; i < arMovie.size(); i++) {
            Movie temp = arMovie.get(i);
            if (temp.getRelease_year() < 2000 && temp.getPrice() > 120.00) {
                double prc, newPrice;
                prc = arMovie.get(i).getPrice() * (percentage / 100);
                newPrice = arMovie.get(i).getPrice() - prc;
                arMovie.get(i).setPrice(newPrice);
            }
        }

    }

    /**
     * Delete the movie by title
     *
     * @param title the title of the movie
     */
    public void deleteMovie(String title) {
        for (Movie t : arMovie) {
            if (t.getTitle().equalsIgnoreCase(title)) {
                arMovie.remove(t);
            }
        }
    }

    /**
     * Get all movie title from the database
     *
     * @return list of movie title
     */
    public ArrayList<String> retrieveTitles() {
        ArrayList<String> list = new ArrayList<>();
        for (Movie t : arMovie) {
            list.add(t.getTitle());
        }
        return list;
    }

    /**
     * Add the new movie
     *
     * @param title the title of the movie
     * @param directorName the director name for the movie
     * @param release_year the release year of the movie
     * @param price the price of the movie
     */
    public void addMovie(Movie movie) throws DuplicateExeption {
        boolean duplicate = false;
        for (int i = 0; i < arMovie.size() && !duplicate; i++) {
            Movie temp = arMovie.get(i);
            if (temp.getTitle().equalsIgnoreCase(movie.getTitle())) {
                duplicate = true;
            }
        }

        if (duplicate) {
            throw new DuplicateExeption("Movie exists already");
        } else {
            arMovie.add(movie);
        }
    }

}
