package lt.viko.eif.eulozas.musicplatform;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

import lt.viko.eif.eulozas.musicplatform.model.Album;
import lt.viko.eif.eulozas.musicplatform.model.Artist;
import lt.viko.eif.eulozas.musicplatform.model.Song;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;


public class Main {
    public static void main(String[] args) throws JAXBException, IOException {



        Artist theWeeknd = new Artist(1, "The Weeknd", "Canada", 1990);
        Song allIKnow = new Song(1, "All I Know",2016, "Pop", 312);
        Song sideWalks = new Song(2, "Sidewalks",2016, "Pop", 210);
        Album starBoy = new Album (1, "StarBoy", 2016, theWeeknd , List.of(allIKnow, sideWalks));

        System.out.println(starBoy);

        JAXBContext context = JAXBContext.newInstance(Album.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty("jaxb.formatted.output", Boolean.TRUE);
        OutputStream os = new FileOutputStream("generated.xml");
        marshaller.marshal(starBoy, System.out);
        marshaller.marshal(starBoy, os);

        Unmarshaller unmarshaller = context.createUnmarshaller();

        Path path = Path.of("generated.xml");

        String xmlContent = Files.readString(path);

        System.out.print(xmlContent);

        StringReader reader = new StringReader(xmlContent);
        Album backToPOJO = (Album) unmarshaller.unmarshal(reader);

        System.out.println(backToPOJO);


    }

}