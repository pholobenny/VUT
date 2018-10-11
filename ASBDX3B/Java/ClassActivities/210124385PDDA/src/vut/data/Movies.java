/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vut.data;

/**
 *
 * @author Pholo Benny (210124385)
 */
public class Movies {
    
    private String title;
    private String director;
    private int release_year;
    private double price;
    
    public Movies(){
        this.title="";
        this.director="";
        this.release_year=0;
        this.price = 0.0;
    }
    
    public Movies(String title,String director, int release_year,double price){
        setTitle(title);
        setDirector(director);
        setReleaseYear(release_year);
        setPrice(price);
    }
    /**
     * Set the movie title
     * @param title the movie title
     */
    public void setTitle(String title){
        if(!title.isEmpty() && !title.equals("")){
            this.title = title;
        }else{
            throw new IllegalArgumentException("Invalid title");
        }
    }
    
    /**
     * Set the movie director name
     * @param director the director name
     */
    public void setDirector(String director){
        if(!director.isEmpty() && !director.equals("")){
            this.director = director;
        }else{
            throw new IllegalArgumentException("Invalid Director name");
        }
    }
    
    /**
     * Set the movie release year
     * @param releaceYear the movie release year
     */
    public void setReleaseYear(int releaceYear){
        this.release_year = releaceYear;
    }
    
    /**
     * Set the movie price
     * @param price the price of the movie
     */
    public void setPrice(double price){
        this.price= price;
    }
    /**
     * Get the movie title
     * @return the movie title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Get the Director's name 
     * @return the Directors name
     */
    public String getDirector() {
        return director;
    }
    /**
     * Get the release year
     * @return the release year
     */
    public int getRelease_year() {
        return release_year;
    }
    /**
     * Get the price
     * @return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Movies details
     * @return the movie details
     */
    @Override
    public String toString() {
        return getClass().getName()+ "[" + "Title:" + title + ", Director's name:" + director + ", Release Year:" + release_year + ",Movie Price:" + price + ']';
    }
    
   // invoking the DA methods 
    
    public void initiallize() throws DataStorageException{
        MovieDA.initialize();
    }
    
    public void terminate() throws DataStorageException{
        MovieDA.terminate();
    }
    
    public void getAll() throws NotFoundException{
        MovieDA.getAll();
    }
    
    public void returnByDirector(String director) throws NotFoundException{
        MovieDA.returnByDirector(director);
    }
    
    public void returnByTitle(String title) throws NotFoundException{
        MovieDA.returnByTitle(title);
    }
    
    public void producedAfter(int year) throws NotFoundException{
        MovieDA.producedAfter(year);
    }
    
    public void producedBefore(int year)throws NotFoundException{
        MovieDA.producedBefore(year);
    }
    
    public void updatePrice(int pecentage) throws NotFoundException{
        MovieDA.updatePrice(pecentage);
    }
    
    public void deleteMovie (String title)throws NotFoundException{
        MovieDA.deleteMovie(title);
    }
    
    public void retrieveTitles() throws NotFoundException {
        MovieDA.retrieveTitles();
    }
    
    public void addMovie(Movies movie) throws DuplicateExeption{
        MovieDA.addMovie(this);
    }    
}
