/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package renomearseries;

import java.io.File;

/**
 *
 * @author Davi Henrique
 */
public class Renomear {

    String[] arquivos = new String[99];

    String endereco;

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

}
