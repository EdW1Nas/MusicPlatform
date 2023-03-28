package lt.viko.eif.eulozas.musicplatform.model;

import javax.persistence.*;

/**
 * Holds Song's data.
 * @author Edvinas
 * @since 1.0
 */
@Entity
@Table(name = "Song")

public class Song {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")

    private int id;
    private String songName;
    private int releaseYear;
    private String genre;
    private int durationSeconds;


    public Song(int id, String songName, int releaseYear, String genre, int durationSeconds){

        this.id = id;
        this.songName = songName;
        this.releaseYear = releaseYear;
        this.genre = genre;
        this.durationSeconds = durationSeconds;

    }

    public Song(String songName, int releaseYear, String genre, int durationSeconds){

        this.songName = songName;
        this.releaseYear = releaseYear;
        this.genre = genre;
        this.durationSeconds = durationSeconds;


    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getDurationSeconds() {
        return durationSeconds;
    }

    public void setDurationSeconds(int durationSeconds) {
        this.durationSeconds = durationSeconds;
    }

    public Song(){

    }

    public String toString() {
        return String.format("\n\tSong Name: %s\n\t" + "Release Year: %s\n\t" + "Genre: %s\n\t" + "Duration (In Seconds): %s\n\t", this.songName, this.releaseYear, this.genre, this.durationSeconds);
    }
}
