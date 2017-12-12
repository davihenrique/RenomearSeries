/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musicas;

import java.io.File;
import java.io.IOException;
import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.exceptions.CannotReadException;
import org.jaudiotagger.audio.exceptions.CannotWriteException;
import org.jaudiotagger.audio.exceptions.InvalidAudioFrameException;
import org.jaudiotagger.audio.exceptions.ReadOnlyFileException;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;
import org.jaudiotagger.tag.TagException;
import org.jaudiotagger.tag.images.ArtworkFactory;

/**
 *
 * @author Davi Henrique
 */
public class RenomearTags {

    String diretorio;
    String subtitle;
    String comentario;
    String artista;
    String artista_album;
    String album;
    String ano;
    String genero;
    String[] musicas = new String[99];
    String capa;

    public RenomearTags(String diretorio, String subtitle, String comentario, String artista, String artista_album, String album, String ano, String genero, String musicas[], String capa) {
        this.diretorio = diretorio;
        this.subtitle = subtitle;
        this.comentario = comentario;
        this.artista = artista;
        this.artista_album = artista_album;
        this.album = album;
        this.ano = ano;
        this.genero = genero;
        this.musicas = musicas;
        this.capa = capa;
    }

    public void RenomearTag() throws CannotReadException, IOException, TagException, ReadOnlyFileException, InvalidAudioFrameException, CannotWriteException {

        File endereco = new File(this.diretorio);

        File arquivos[] = endereco.listFiles();

        for (int i = 0; i < arquivos.length; i++) {

            System.out.println(arquivos[i]);

            AudioFile f = AudioFileIO.read(arquivos[i]);
            Tag tag = f.getTag();
            tag.setField(FieldKey.TITLE, musicas[i]);
            tag.setField(FieldKey.SUBTITLE, subtitle);
            tag.setField(FieldKey.COMMENT, comentario);
            tag.setField(FieldKey.ARTIST, artista);
            tag.setField(FieldKey.ALBUM_ARTIST, artista_album);
            tag.setField(FieldKey.ALBUM, album);
            tag.setField(FieldKey.YEAR, ano);
            tag.setField(FieldKey.TRACK, Integer.toString(i + 1));
            tag.setField(FieldKey.GENRE, genero);

            if ("N".equals(capa)) {
                tag.deleteArtworkField();
            } else {
                tag.setField(ArtworkFactory.createArtworkFromFile(new File(capa)));
            }

            AudioFileIO.write(f);

        }

    }

}
