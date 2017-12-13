/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package musicas;

import java.io.File;

/**
 *
 * @author Davi Henrique
 */
public class Musicas {
    
    private String[] formatos = new String[5];
    
    int cont_musica = 0;
    
    
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

    /*Metodo para volta numero de Epsodios*/
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
                        /*Contador de aquivos*/
                        cont_musica++;
                    }
                } catch (Exception e) {
                }
            }
        }
    }

    
    /*Get para total de musicas*/
    public int getCont_musica() {
        return cont_musica;
    }
    
    
    

    
    
}
