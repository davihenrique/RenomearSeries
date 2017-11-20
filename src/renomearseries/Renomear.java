/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package renomearseries;

import java.io.File;
import java.util.Arrays;

/**
 *
 * @author Davi Henrique
 */
public class Renomear {

    String[] arquivos = new String[99];
    String[] nomedoseps = new String[99];
    String nome;
    boolean conveter = false;
    String endereco;
    String temporada;

    int totalep = 0;

    String[] formatos = new String[5];

    public void listaformatos() {

        formatos[0] = ".mp4";
        formatos[1] = ".rmvb";
        formatos[2] = ".avi";
        formatos[3] = ".mkv";
        formatos[4] = ".mov";

    }

    public void pesquisa(File pasta) {
        int result = 0;
        int format;
        File arquivos[] = pasta.listFiles();

        Arrays.sort(arquivos);

        listaformatos();
        for (int i = 0; i < arquivos.length; i++) {

            for (int j = 0; j < formatos.length; j++) {

                if (j == 1) {
                    format = 5;
                } else {
                    format = 4;
                }

                try {
                    result = String.valueOf(arquivos[i]).indexOf(formatos[j]);
                    if (result != -1 && result + format == String.valueOf(arquivos[i]).length()) {
                        totalep++;
                        if (conveter == true) {
                            /*Nomes Dos aquivos
                            System.out.println(arquivos[i]);*/
                            if (totalep > 9) {
                                File novo = new File(endereco + "\\S" + temporada + "E" + (totalep) + " " + nome +" - "+nomedoseps[totalep-1]+ formatos[j]);
                                arquivos[i].renameTo(novo);
                            } else {
                                File novo = new File(endereco + "\\S" + temporada + "E0" + (totalep) + " " + nome +" - "+nomedoseps[totalep-1]+ formatos[j]);
                                arquivos[i].renameTo(novo);
                            }
                            
                            
                         //  System.out.println(nomedoseps[totalep]);

                        }
                    }
                } catch (Exception e) {
                    // System.out.println(e);
                }
            }
        }
    }

    public int info(String endereco) {

        File pasta = new File(endereco);

        pesquisa(pasta);

        return (totalep);
    }

    public boolean RenomearArquivos(String endereco, int temporada, String nome, String[] arquivos) {
       
        this.nomedoseps = arquivos;
        
        this.endereco = endereco;
        this.nome = nome;
        if(temporada >9){
            this.temporada = ""+temporada;
        }else{
            this.temporada = "0"+temporada;
        }
        conveter = true;
        File pasta = new File(endereco);
        
        try{
        pesquisa(pasta);
        return true;
        }catch(NullPointerException e){
           // System.out.println(e);
           return false;
        }

    }


}
