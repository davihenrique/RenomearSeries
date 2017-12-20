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
    
    private String[] formatos = new String[5];
    int cont_musica = 0;
    private File novo;
    
    
    
        /*Lista de formatos suportados*/
    private void Listaformatos() {
        formatos[0] = ".mp3";
        formatos[1] = ".wma";
        formatos[2] = ".flac";
        formatos[3] = ".ogg";
        formatos[4] = ".aac";
    }

     /*Pegar Aquivos*/
    private File[] Ligar(String endereco) {
        File diretorio = new File(endereco);
        return diretorio.listFiles();
    }
    

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
        Renomamu(diretorio);
    }
        
    /*Realizar Alteraçoes*/
    public void Renomamu(String endereco) {

        /*Recebe aquivos*/
        File arquivos[] = Ligar(endereco);
        /*carregar listas de formatos*/
        Listaformatos();

        cont_musica = 0;
        int result = 0;
        int format;

        String sistema;

        /*Verifica sistema*/
        if ("Linux".equals(System.getProperty("os.name"))) {
            sistema = "/";
        } else {
            sistema = "\\";
        }

        for (int i = 0; i < arquivos.length; i++) {

            for (int j = 0; j < formatos.length; j++) {
                /*Veria se a estão do arquivo possuir 5 ou 4 caracteres*/
                if (j == 2) {
                    format = 5;
                } else {
                    format = 4;
                }
                try {
                    result = String.valueOf(arquivos[i]).indexOf(formatos[j]);
                    if (result != -1 && result + format == String.valueOf(arquivos[i]).length()) {

                        //System.out.println(String.valueOf(arquivos[i]));
                       //COLOCAR TAGS
                       
                       //RenomearTag(arquivos[i], cont_musica);

                        if(!"<limpo>".equals(subtitle)){
                            RenomearSubtitle(arquivos[i]);
                        }
                        if(!"<limpo>".equals(comentario)){
                            RenomearComentario(arquivos[i]);
                        }
                        if(!"<limpo>".equals(artista)){
                            RenomearArtista(arquivos[i]);
                        }
                        if(!"<limpo>".equals(artista_album)){
                            RenomearAlbumArtist(arquivos[i]);
                        }
                        if(!"<limpo>".equals(album)){
                            RenomearAlbum(arquivos[i]);
                        }
                        if(!"<limpo>".equals(ano)){
                            RenomearAno(arquivos[i]);
                        }
                        
                            RenomearTrack(arquivos[i],cont_musica);
                         
                        if(!"<limpo>".equals(genero)){
                            RenomearGenero(arquivos[i]);
                        }
                        
                        RenomearCapa(arquivos[i], true);

                        /*Contador de aquivos*/
                        cont_musica++;

                    }
                } catch (Exception e) {
                }
            }
        }

    }
    
    
     public void RenomearMusica(File faixa, int x) throws CannotReadException, IOException, TagException, ReadOnlyFileException, InvalidAudioFrameException, CannotWriteException{
        AudioFile f = AudioFileIO.read(faixa);
            Tag tag = f.getTag();
             tag.setField(FieldKey.TITLE, musicas[x]);
              AudioFileIO.write(f);
    }

    public void RenomearSubtitle(File faixa) throws CannotReadException, IOException, TagException, ReadOnlyFileException, InvalidAudioFrameException, CannotWriteException{
        AudioFile f = AudioFileIO.read(faixa);
            Tag tag = f.getTag();
            tag.setField(FieldKey.SUBTITLE, subtitle);
              AudioFileIO.write(f);
    }
    
    public void RenomearComentario(File faixa) throws CannotReadException, IOException, TagException, ReadOnlyFileException, InvalidAudioFrameException, CannotWriteException{
        AudioFile f = AudioFileIO.read(faixa);
            Tag tag = f.getTag();
             tag.setField(FieldKey.COMMENT, comentario);
              AudioFileIO.write(f);
    }
    
    public void RenomearArtista(File faixa) throws CannotReadException, IOException, TagException, ReadOnlyFileException, InvalidAudioFrameException, CannotWriteException{
        AudioFile f = AudioFileIO.read(faixa);
            Tag tag = f.getTag();
            tag.setField(FieldKey.ARTIST, artista);
              AudioFileIO.write(f);
    }
   
    public void RenomearAlbumArtist(File faixa) throws CannotReadException, IOException, TagException, ReadOnlyFileException, InvalidAudioFrameException, CannotWriteException{
        AudioFile f = AudioFileIO.read(faixa);
            Tag tag = f.getTag();
             tag.setField(FieldKey.ALBUM_ARTIST, artista_album);
              AudioFileIO.write(f);
    }
    public void RenomearAlbum(File faixa) throws CannotReadException, IOException, TagException, ReadOnlyFileException, InvalidAudioFrameException, CannotWriteException{
        AudioFile f = AudioFileIO.read(faixa);
            Tag tag = f.getTag();
              tag.setField(FieldKey.ALBUM, album);
              AudioFileIO.write(f);
    }
    
    public void RenomearAno(File faixa) throws CannotReadException, IOException, TagException, ReadOnlyFileException, InvalidAudioFrameException, CannotWriteException{
        AudioFile f = AudioFileIO.read(faixa);
            Tag tag = f.getTag();
             tag.setField(FieldKey.YEAR, ano);
              AudioFileIO.write(f);
    }
    
    public void RenomearTrack(File faixa, int x) throws CannotReadException, IOException, TagException, ReadOnlyFileException, InvalidAudioFrameException, CannotWriteException{
        AudioFile f = AudioFileIO.read(faixa);
            Tag tag = f.getTag();
             tag.setField(FieldKey.TRACK, Integer.toString(x));
              AudioFileIO.write(f);
    }
    
    public void RenomearGenero(File faixa) throws CannotReadException, IOException, TagException, ReadOnlyFileException, InvalidAudioFrameException, CannotWriteException{
        AudioFile f = AudioFileIO.read(faixa);
            Tag tag = f.getTag();
             tag.setField(FieldKey.GENRE, genero);
              AudioFileIO.write(f);
    }
    public void RenomearCapa(File faixa, boolean capa) throws CannotReadException, IOException, TagException, ReadOnlyFileException, InvalidAudioFrameException, CannotWriteException{
       
        
        
        
        AudioFile f = AudioFileIO.read(faixa);
            Tag tag = f.getTag();
            if(capa){
                 tag.setField(ArtworkFactory.createArtworkFromFile(new File(this.capa)));
            }else{
                 tag.deleteArtworkField();
            }
            
              AudioFileIO.write(f);
    }
}
