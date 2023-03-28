package lt.viko.eif.eulozas.musicplatform.model;
import jakarta.xml.bind.annotation.*;

import java.util.List;
import javax.persistence.*;

/**
 * Holds Album's data.
 * @author Edvinas
 * @since 1.0
 */

@XmlRootElement(name = "Album")
@XmlType(propOrder = {"id","albumName","releaseYear","artist", "songs" })
@XmlAccessorType(XmlAccessType.FIELD)
@Entity
@Table(name = "Album")
public class Album {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")

    private int id;
    private String albumName;
    private int releaseYear;


    @OneToOne(targetEntity = Artist.class,cascade = CascadeType.ALL)
    private Artist artist;

    @XmlElementWrapper(name = "songs")
    @XmlElement(name = "songs")
    @OneToMany(targetEntity = Song.class,cascade = CascadeType.ALL)
    private List<Song> songs;

    public Artist getArtist() {
        return artist;
    }



    public Album(int id, String albumName, int releaseYear, Artist artist ,List<Song> songs) {

        this.id = id;
        this.albumName = albumName;
        this.releaseYear = releaseYear;
        this.artist = artist;
        this.songs = songs;
    }

    public Album(String albumName, int releaseYear, Artist artist ,List<Song> songs) {


        this.albumName = albumName;
        this.releaseYear = releaseYear;
        this.artist = artist;
        this.songs = songs;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }
    public void setArtist(Artist artist) {this.artist = artist;}

    public List<lt.viko.eif.eulozas.musicplatform.model.Song> getSong() {
        return songs;
    }
    public void setSong(List<lt.viko.eif.eulozas.musicplatform.model.Song> Song) {
        songs = Song;
    }

    public Album(){

    }

    @Override
    public String toString() {
        return String.format("Album:\n\tAlbum Name: %s\n\t" + "Release Year: %s\n\t" + "Artist: %s\n\t" + "Songs: %s\n\t", this.albumName, this.releaseYear, this.artist, constructSubjectString());
    }

    private String constructSubjectString(){
        String result = "";
        for (Song allSongs : this.songs){
            result += songs.toString();
        }
        return result;
    }

}
