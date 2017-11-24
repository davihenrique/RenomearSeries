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
    int total_de_epsodio = 0;
    String[] formatos = new String[5];

    /*Lista de formatos suportados*/
    private void Listaformatos() {
        formatos[0] = ".mp4";
        formatos[1] = ".rmvb";
        formatos[2] = ".avi";
        formatos[3] = ".mkv";
        formatos[4] = ".mov";
    }

    /*Pegar Aquivos*/
    private File[] Ligar(String endereco) {
        File diretorio = new File(endereco);
        return diretorio.listFiles();
    }

    /*Metodo para volta numero de Epsodios*/
    public void NumeroEp(String endereco) {
        /*Recebe aquivos*/
        File arquivos[] = Ligar(endereco);
        //carregar listas de formatos
        Listaformatos();
        int result = 0;
        int format;
        for (int i = 0; i < arquivos.length; i++) {

            for (int j = 0; j < formatos.length; j++) {
                /*Veria se a estão do arquivo possuir 5 ou 4 caracteres*/
                if (j == 1) {
                    format = 5;
                } else {
                    format = 4;
                }
                try {
                    result = String.valueOf(arquivos[i]).indexOf(formatos[j]);
                    if (result != -1 && result + format == String.valueOf(arquivos[i]).length()) {
                        /*Contador de aquivos*/
                        total_de_epsodio++;
                    }
                } catch (Exception e) {
                }
            }
        }
    }

    /*Realizar Alteraçoes*/
    public void RenomaEp(String endereco, int temporada, String nome, String[] nomesEP) {
        /*Recebe aquivos*/
        File arquivos[] = Ligar(endereco);
        /*carregar listas de formatos*/
        Listaformatos();
        File novo;
        int result = 0;
        int format;
        String sistema;
        
        /*Verifica sistema*/
        if ("Linux".equals(System.getProperty("os.name"))) {
            sistema = "/S";
        } else {
           sistema = "\\S";
        }

        for (int i = 0; i < arquivos.length; i++) {

            for (int j = 0; j < formatos.length; j++) {
                /*Veria se a estão do arquivo possuir 5 ou 4 caracteres*/
                if (j == 1) {
                    format = 5;
                } else {
                    format = 4;
                }
                try {
                    result = String.valueOf(arquivos[i]).indexOf(formatos[j]);
                    if (result != -1 && result + format == String.valueOf(arquivos[i]).length()) {
                        /*Contador de aquivos*/
                        total_de_epsodio++;
                        if (total_de_epsodio > 9) {
                            novo = new File(endereco + sistema + temporada + "E" + (total_de_epsodio) + " " + nome + " - " + nomesEP[total_de_epsodio - 1] + formatos[j]);
                        } else {
                            novo = new File(endereco + sistema + temporada + "E0" + (total_de_epsodio) + " " + nome + " - " + nomesEP[total_de_epsodio - 1] + formatos[j]);
                        }
                        arquivos[i].renameTo(novo);
                    }
                } catch (Exception e) {
                }
            }
        }
    }
    
     /*Get para episódio*/
    public int getTotal_de_epsodio() {
        return total_de_epsodio;
    }

}
