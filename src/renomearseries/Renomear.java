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
    String nome;
    boolean conveter = false;
    String endereco;
    int temporada;
    int ep = 1;

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
                        //Impressão dos arquivos
                        //System.out.println(arquivos[i]);

                        if (conveter == true) {
                            System.out.println(arquivos[i]);

                            if (ep > 9) {
                                File novo = new File(endereco + "\\S0" + (temporada) + "E" + (ep) + " " + nome + formatos[j]);
                                arquivos[i].renameTo(novo);
                            } else {
                                File novo = new File(endereco + "\\S0" + (temporada) + "E0" + (ep) + " " + nome + formatos[j]);
                                arquivos[i].renameTo(novo);
                            }

                            ep++;
                        }

                        totalep++;
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

    public void RenomearArquivos(String endereco, int temporada, String nome) {

        //System.out.println(endereco);
        //System.out.println(temporada);
        //System.out.println(nome);
        this.endereco = endereco;
        this.temporada = temporada;
        this.nome = nome;

        conveter = true;
        totalep = 0;

        File pasta = new File(endereco);

        pesquisa(pasta);

    }

}
