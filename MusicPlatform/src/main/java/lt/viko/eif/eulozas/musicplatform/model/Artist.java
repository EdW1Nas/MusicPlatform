package lt.viko.eif.eulozas.musicplatform.model;

import javax.persistence.*;

/**
 * Holds Artist's data.
 * @author Edvinas
 * @since 1.0
 */
@Entity
@Table(name = "Artist")
public class Artist {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")

    private int id;
    private String artistStageName;
    private String origin;
    private int birthYear;

    public Artist(int id, String artistStageName, String origin, int birthYear){

        this.id = id;
        this.artistStageName = artistStageName;
        this.origin = origin;
        this.birthYear = birthYear;

    }

    public Artist(String artistStageName, String origin, int birthYear){

        this.artistStageName = artistStageName;
        this.origin = origin;
        this.birthYear = birthYear;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getArtistStageName() {
        return artistStageName;
    }

    public void setArtistStageName(String artistStageName) {
        this.artistStageName = artistStageName;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public Artist(){

    }

    public String toString() {
        return String.format("\n\tArtist's Stage Name: %s\n\t" + "Artist's Origin: %s\n\t" + "Artist's birth year: %s\n\t", this.artistStageName, this.origin, this.birthYear);
    }
}
