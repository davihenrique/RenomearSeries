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

    String endereco;
    String subtitle;
    String comentario;
    String artista;
    String artista_album;
    String album;
    String ano;
    String genero;
    String[] musicas = new String[99];
    String capa;
    boolean numero;

    private String[] formatos = new String[5];

    int cont_musica = 0;
    private File novo;
    boolean temmusicas=false;

    //Sobrecarga
    public RenomearTags(String diretorio, String[] musicas, String subtitle, String comentario, String artista, String album_artista, String album, String ano, boolean number, String genre, String artwork) {
        this.endereco = diretorio;
        this.musicas = musicas;
        this.subtitle = subtitle;
        this.comentario = comentario;
        this.artista = artista;
        this.album = album;
        this.ano = ano;
        this.numero = number;
        this.genero = genre;
        this.capa = artwork;
        temmusicas = true;
        System.out.println("chegou");
        NumeroMu(diretorio);
    }
    public RenomearTags(String diretorio, String subtitle, String comentario, String artista, String album_artista, String album, String ano, boolean number, String genre, String artwork) {
        this.endereco = diretorio;
        this.subtitle = subtitle;
        this.comentario = comentario;
        this.artista = artista;
        this.album = album;
        this.ano = ano;
        this.numero = number;
        this.genero = genre;
        this.capa = artwork;
        System.out.println("chegou");
        NumeroMu(diretorio);

    }

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

    /*Metodo para volta numero de Musicas*/
    public void NumeroMu(String endereco) {
        /*Recebe aquivos*/
        File arquivos[] = Ligar(endereco);
        //carregar listas de formatos
        Listaformatos();
        int result = 0;
        int format;
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
                        
                        
                        if(temmusicas){
                            
                           // System.out.println(musicas[cont_musica]);
                            RenomearMusica(arquivos[cont_musica],musicas[cont_musica]);
                        }
                        
                        if(subtitle != "<limpo>"){
                            RenomearSubtitle(arquivos[cont_musica]);
                        }
                        if(comentario != "<limpo>"){
                            RenomearComentario(arquivos[cont_musica]);
                        }
                        if(artista != "<limpo>"){
                            RenomearArtista(arquivos[cont_musica]);
                        }
                        if(album != "<limpo>"){
                            RenomearAlbum(arquivos[cont_musica]);
                        }
                        if(ano != "<limpo>"){
                            RenomearAno(arquivos[cont_musica]);
                        }
                        if(numero){
                            RenomearTrack(arquivos[cont_musica], cont_musica+1);
                        }
                        
                        if(genero !="<limpo>"){
                            RenomearGenero(arquivos[cont_musica]);
                        }
                        
                        if(capa != "<limpo>"){
                             if(capa =="<apagar>"){
                                RenomearCapa(arquivos[cont_musica], false);
                            } else{
                                 RenomearCapa(arquivos[cont_musica], true);
                             }
                        }
                           
                        
                        
                        
                        /*Contador de aquivos*/
                       // System.out.println(arquivos[cont_musica]);
                        cont_musica++;
                    }
                } catch (Exception e) {
                }
            }
        }
    }



     public void RenomearMusica(File faixa, String x) throws CannotReadException, IOException, TagException, ReadOnlyFileException, InvalidAudioFrameException, CannotWriteException{
        AudioFile f = AudioFileIO.read(faixa);
            Tag tag = f.getTag();
             tag.setField(FieldKey.TITLE, x);
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
