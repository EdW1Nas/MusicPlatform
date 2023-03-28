package lt.viko.eif.eulozas.musicplatform.util;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import lt.viko.eif.eulozas.musicplatform.model.Album;

import java.io.FileNotFoundException;

public class JaxbUtil {

    public static void convertToXML (Album starBoy){
        try {
            JAXBContext context = JAXBContext.newInstance(Album.class);

            Marshaller marshaller = null;

            marshaller = context.createMarshaller();
            marshaller.setProperty("jaxb.formatted.output",Boolean.TRUE);

            marshaller.marshal(starBoy, System.out);
        }catch (JAXBException e){
            throw new RuntimeException(e);
        }
    }
}