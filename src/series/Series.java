/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package series;

import java.io.File;

/**
 *
 * @author Davi Henrique
 */
public class Series {

    int cont_epsodio = 0;
    private String[] formatos = new String[5];
    private File novo;

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
                        cont_epsodio++;
                    }
                } catch (Exception e) {
                }
            }
        }
    }

    /*Realizar Alteraçoes*/
    public void RenomaEp(String endereco, int temporada, String nome, String[] nomesEP, int pradao) {

        /*Recebe aquivos*/
        File arquivos[] = Ligar(endereco);
        /*carregar listas de formatos*/
        Listaformatos();

        cont_epsodio = 0;
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
                if (j == 1) {
                    format = 5;
                } else {
                    format = 4;
                }
                try {
                    result = String.valueOf(arquivos[i]).indexOf(formatos[j]);
                    if (result != -1 && result + format == String.valueOf(arquivos[i]).length()) {

                        //System.out.println(String.valueOf(arquivos[i]));
                        gravar(endereco, sistema, temporada, nome, nomesEP[cont_epsodio], formatos[j], cont_epsodio + 1, pradao);

                        arquivos[i].renameTo(novo);

                        /*Contador de aquivos*/
                        cont_epsodio++;

                    }
                } catch (Exception e) {
                }
            }
        }

    }

    public void gravar(String endereco, String sistema, int temporada, String nome, String nomesEP, String formato, int cont, int padrao) {

        // String endereco = String.valueOf(arquivo);
        switch (padrao) {

            case 1:
                if (cont > 9) {
                    novo = new File(endereco + sistema + "S" + temporada + "E" + cont + " " + nome + " - " + nomesEP + formato);
                } else {
                    novo = new File(endereco + sistema + "S" + temporada + "E0" + cont + " " + nome + " - " + nomesEP + formato);
                }
                break;

            /*[16:47, 8/12/2017] Lucas: Os Simpsons S2E3 a vida de Bart*/
            case 2:
                if (cont > 9) {
                    novo = new File(endereco + sistema + nome + " S" + temporada + "E" + cont + " " + nomesEP + formato);
                } else {
                    novo = new File(endereco + sistema + nome + " S" + temporada + "E0" + cont + " " + nomesEP + formato);
                }
                break;
            case 3:
                if (cont > 9) {
                    novo = new File(endereco + sistema + "S" + temporada + "E" + cont + " " + nomesEP + formato);
                } else {
                    novo = new File(endereco + sistema + "S" + temporada + "E0" + cont + " " + nomesEP + formato);
                }
                break;

            case 4:
                if (cont > 9) {
                    novo = new File(endereco + sistema + nome + " " + "0" + temporada + "-" + cont + formato);
                } else {
                    novo = new File(endereco + sistema + nome + " " + "0" + temporada + "-" + "0" + cont + formato);
                }
                break;

            default:
                if (cont > 9) {
                    novo = new File(endereco + sistema + "S" + temporada + "E" + cont + " " + nome + " - " + nomesEP + formato);
                } else {
                    novo = new File(endereco + sistema + "S" + temporada + "E0" + cont + " " + nome + " - " + nomesEP + formato);
                }
                break;

        }

    }

    /*Get para episódio*/
    public int getTotal_de_epsodio() {
        return cont_epsodio;
    }

}
