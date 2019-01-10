package musicas;

import java.io.File;

/**
 *
 * @author Davi Henrique
 */
public class Musicas {
    
    private final String[] formatos = new String[5];
    private int contMusicas = 0;
    private File novo;
        
    /*Lista de formatos suportados*/
    private void listaFormatos() {
        formatos[0] = ".mp3";
        formatos[1] = ".wma";
        formatos[2] = ".flac";
        formatos[3] = ".ogg";
        formatos[4] = ".aac";
    }   
    
    /*Pegar Aquivos*/
    private File[] ligar(String endereco) {
        File diretorio = new File(endereco);
        return diretorio.listFiles();
    }

    /*Metodo para volta numero de Musicas*/
    public void numeroDeMusicas(String endereco) {
        /*Recebe aquivos*/
        File arquivos[] = ligar(endereco);
        //carregar listas de formatos
        listaFormatos();
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
                        contMusicas++;
                    }
                } catch (Exception e) {
                }
            }
        }
    }
    
    /*Realizar Alteraçoes*/
    public void renomeiaMusicas(String endereco, String banda, String[] nomesMu, int padrao) {

        /*Recebe aquivos*/
        File arquivos[] = ligar(endereco);
        /*carregar listas de formatos*/
        listaFormatos();

        contMusicas = 0;
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
                        gravar(endereco, sistema, banda, nomesMu[contMusicas], formatos[j], contMusicas + 1, padrao);

                        arquivos[i].renameTo(novo);

                        /*Contador de aquivos*/
                        contMusicas++;

                    }
                } catch (Exception e) {
                }
            }
        }

    }

    public void gravar(String endereco, String sistema, String banda, String nomesMu, String formato, int cont, int padrao) {

        // Padrão de gravação
        switch (padrao) {

            case 1:
                if (cont > 9) {
                    novo = new File(endereco + sistema+ cont + " - " + nomesMu + formato);
                } else {
                    novo = new File(endereco + sistema + "0" + cont + " - " + nomesMu + formato);
                    
                }
                break;
                
            case 2:
                if (cont > 9) {
                    novo = new File(endereco + sistema+ cont + " " + banda + " - " + nomesMu + formato);
                } else {
                    novo = new File(endereco + sistema + "0" + cont + " " + banda + " - " + nomesMu + formato);
                    
                }
                break;
        }
    }
    
    /*Get para total de musicas*/
    public int getContMusicas() {
        return contMusicas;
    }
}
