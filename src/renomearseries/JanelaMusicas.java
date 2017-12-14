/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package renomearseries;

import java.awt.Color;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;
import musicas.Musicas;
/**
 *
 * @author Davi Henrique
 */
public class JanelaMusicas extends javax.swing.JFrame {

    /**
     * Creates new form JanelaMusicas
     */
    public JanelaMusicas() {
        initComponents();
    }
    
    String diretorio;
    int numerodemusicas = 0;
    String[] arquivos = new String[99];

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelDiretorio = new javax.swing.JLabel();
        jTextFieldEndereco = new javax.swing.JTextField();
        jButtonSelecionar = new javax.swing.JButton();
        jButtonMusicas = new javax.swing.JButton();
        jButtonRenomear = new javax.swing.JButton();
        jButtonVoltar = new javax.swing.JButton();
        jLabelNomeMusicas = new javax.swing.JLabel();
        jLabelSubtitle = new javax.swing.JLabel();
        jLabelComentarios = new javax.swing.JLabel();
        jLabelArtista = new javax.swing.JLabel();
        jLabelArtistaDoAlbum = new javax.swing.JLabel();
        jLabelAlbum = new javax.swing.JLabel();
        jLabelAno = new javax.swing.JLabel();
        jLabelGenero = new javax.swing.JLabel();
        jButtonTags = new javax.swing.JButton();
        jRadioButtonOrdemNumerica = new javax.swing.JRadioButton();
        jRadioButtonConfirma = new javax.swing.JRadioButton();
        jTextFieldComentarios = new javax.swing.JTextField();
        jTextFieldSubtitle = new javax.swing.JTextField();
        jTextFieldArtista = new javax.swing.JTextField();
        jTextFieldAlbum = new javax.swing.JTextField();
        jTextFieldAristaDoAlbum = new javax.swing.JTextField();
        jTextFieldGenero = new javax.swing.JTextField();
        jTextFieldAno = new javax.swing.JTextField();
        jLabelOrdemNumerica = new javax.swing.JLabel();
        jLabelConfirma = new javax.swing.JLabel();
        jButtonConcluirTag = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTabela = new javax.swing.JTable();
        jButtonConcluirTabela = new javax.swing.JButton();
        jLabelMsg = new javax.swing.JLabel();
        jComboBoxPadrao = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Renomear Músicas");

        jLabelDiretorio.setText("Diretorio");

        jTextFieldEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldEnderecoActionPerformed(evt);
            }
        });

        jButtonSelecionar.setText("Selecionar");
        jButtonSelecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSelecionarActionPerformed(evt);
            }
        });

        jButtonMusicas.setText("Musicas");
        jButtonMusicas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonMusicasActionPerformed(evt);
            }
        });

        jButtonRenomear.setText("Renomear");

        jButtonVoltar.setText("Voltar");
        jButtonVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVoltarActionPerformed(evt);
            }
        });

        jLabelNomeMusicas.setText("Nome Musicas:");

        jLabelSubtitle.setText("Subtitle:");

        jLabelComentarios.setText("Comentarios:");

        jLabelArtista.setText("Artista:");

        jLabelArtistaDoAlbum.setText("Artista do album:");

        jLabelAlbum.setText("Album:");

        jLabelAno.setText("Ano:");

        jLabelGenero.setText("Genero:");

        jButtonTags.setText("Tags");

        jRadioButtonOrdemNumerica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonOrdemNumericaActionPerformed(evt);
            }
        });

        jRadioButtonConfirma.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonConfirmaActionPerformed(evt);
            }
        });

        jTextFieldAristaDoAlbum.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldAristaDoAlbumActionPerformed(evt);
            }
        });

        jTextFieldGenero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldGeneroActionPerformed(evt);
            }
        });

        jTextFieldAno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldAnoActionPerformed(evt);
            }
        });

        jLabelOrdemNumerica.setText("Ordem Numerica:");

        jLabelConfirma.setText("Eu confirm que desejo colocar tags");

        jButtonConcluirTag.setText("Concluir");

        jTabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Musica", "Nome"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTabela);
        if (jTabela.getColumnModel().getColumnCount() > 0) {
            jTabela.getColumnModel().getColumn(0).setMaxWidth(60);
        }

        jButtonConcluirTabela.setText("Concluir");
        jButtonConcluirTabela.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonConcluirTabelaActionPerformed(evt);
            }
        });

        jComboBoxPadrao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "n - NomeMusica", "n NomeBanda - NomeMusica" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jButtonVoltar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonRenomear)
                        .addGap(117, 117, 117))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelDiretorio)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabelNomeMusicas)
                                        .addComponent(jButtonMusicas))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButtonTags))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jTextFieldEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(29, 29, 29)
                                    .addComponent(jButtonSelecionar)))
                            .addComponent(jLabelMsg, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboBoxPadrao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(106, 106, 106)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jRadioButtonConfirma)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelConfirma)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                        .addComponent(jButtonConcluirTag))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelArtistaDoAlbum)
                            .addComponent(jLabelOrdemNumerica)
                            .addComponent(jLabelGenero)
                            .addComponent(jLabelAno)
                            .addComponent(jLabelAlbum)
                            .addComponent(jLabelArtista)
                            .addComponent(jLabelComentarios)
                            .addComponent(jLabelSubtitle))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButtonOrdemNumerica)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldAlbum)
                                    .addComponent(jTextFieldSubtitle)
                                    .addComponent(jTextFieldComentarios)
                                    .addComponent(jTextFieldAristaDoAlbum)
                                    .addComponent(jTextFieldArtista, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jTextFieldGenero)
                                    .addComponent(jTextFieldAno, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addGap(45, 45, 45)))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 414, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonConcluirTabela)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelSubtitle)
                            .addComponent(jTextFieldSubtitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelComentarios)
                            .addComponent(jTextFieldComentarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelArtista)
                            .addComponent(jTextFieldArtista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelArtistaDoAlbum)
                            .addComponent(jTextFieldAristaDoAlbum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelAlbum)
                            .addComponent(jTextFieldAlbum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelAno)
                            .addComponent(jTextFieldAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jButtonTags)
                                .addComponent(jLabelGenero, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jTextFieldGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jRadioButtonOrdemNumerica)
                            .addComponent(jLabelOrdemNumerica))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jRadioButtonConfirma)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabelConfirma)
                                .addComponent(jButtonConcluirTag))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelDiretorio)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonSelecionar))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelMsg, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jComboBoxPadrao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(jLabelNomeMusicas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonMusicas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButtonRenomear)
                            .addComponent(jButtonVoltar))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jButtonConcluirTabela)
                .addGap(21, 21, 21))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonSelecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSelecionarActionPerformed
        // TODO add your handling code here:
        diretorio = "";
        jTextFieldEndereco.setText("");
        jLabelMsg.setText("");

        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);
        chooser.setDialogTitle("Pasta");
        chooser.showOpenDialog(null);

        try {
            File f = chooser.getSelectedFile();
            diretorio = f.getAbsolutePath();
            jTextFieldEndereco.setText(diretorio);

            Musicas x = new Musicas();
            x.NumeroMu(diretorio);
            numerodemusicas = x.getCont_musica();
            if (numerodemusicas > 1) {
                jLabelMsg.setForeground(Color.black);
                jLabelMsg.setText(numerodemusicas + " Mússica Encontradas");
            } else if (numerodemusicas == 1) {
                jLabelMsg.setForeground(Color.black);
                jLabelMsg.setText("Apenas " + numerodemusicas + " Encontrada");
            } else {
                jLabelMsg.setForeground(Color.red);
                jLabelMsg.setText("Nenhum Mússica Encontrada");
            }

        } catch (NullPointerException e) {
            jLabelMsg.setForeground(Color.red);
            jLabelMsg.setText("Diretorio vazio");
        }
        
        
    }//GEN-LAST:event_jButtonSelecionarActionPerformed

    private void jTextFieldEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldEnderecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldEnderecoActionPerformed

    private void jRadioButtonOrdemNumericaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonOrdemNumericaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonOrdemNumericaActionPerformed

    private void jRadioButtonConfirmaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonConfirmaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jRadioButtonConfirmaActionPerformed

    private void jTextFieldAristaDoAlbumActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldAristaDoAlbumActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldAristaDoAlbumActionPerformed

    private void jTextFieldGeneroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldGeneroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldGeneroActionPerformed

    private void jTextFieldAnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldAnoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldAnoActionPerformed

    private void jButtonVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVoltarActionPerformed
        // TODO add your handling code here:
        
        new JanelaInicial().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButtonVoltarActionPerformed

    private void jButtonMusicasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonMusicasActionPerformed
        // TODO add your handling code here:
        
        diretorio = "";
        jLabelMsg.setText("");

        diretorio = jTextFieldEndereco.getText();

        while (jTabela.getModel().getRowCount() > 0) {
            DefaultTableModel val = (DefaultTableModel) jTabela.getModel();
            val.removeRow(0);
        }
        try {

            Musicas x = new Musicas();

            x.NumeroMu(diretorio);
            numerodemusicas = x.getCont_musica();
            if (numerodemusicas > 1) {
                jLabelMsg.setForeground(Color.black);
                jLabelMsg.setText(numerodemusicas + " Musicas Encontradas");
            } else {
                jLabelMsg.setForeground(Color.black);
                jLabelMsg.setText("Apenas " + numerodemusicas + " Encontrada");
            }

        } catch (NullPointerException e) {
            jLabelMsg.setForeground(Color.red);
            jLabelMsg.setText("Diretorio vazio");
        }

        DefaultTableModel val = (DefaultTableModel) jTabela.getModel();
        for (int i = 1; i <= numerodemusicas; i++) {

            if (i < 10) {
                val.addRow(new String[]{"0" + i, ""});
            } else {
                val.addRow(new String[]{Integer.toString(i), ""});

            }
        }
    }//GEN-LAST:event_jButtonMusicasActionPerformed

    private void jButtonConcluirTabelaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonConcluirTabelaActionPerformed
        // TODO add your handling code here:
         for (int i = 0; i < numerodemusicas; i++) {
            Object value = jTabela.getValueAt(i, 1);
            arquivos[i] = (String) value;
             System.out.println(arquivos[i]);
        }
        
    }//GEN-LAST:event_jButtonConcluirTabelaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JanelaMusicas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JanelaMusicas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JanelaMusicas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JanelaMusicas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JanelaMusicas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonConcluirTabela;
    private javax.swing.JButton jButtonConcluirTag;
    private javax.swing.JButton jButtonMusicas;
    private javax.swing.JButton jButtonRenomear;
    private javax.swing.JButton jButtonSelecionar;
    private javax.swing.JButton jButtonTags;
    private javax.swing.JButton jButtonVoltar;
    private javax.swing.JComboBox<String> jComboBoxPadrao;
    private javax.swing.JLabel jLabelAlbum;
    private javax.swing.JLabel jLabelAno;
    private javax.swing.JLabel jLabelArtista;
    private javax.swing.JLabel jLabelArtistaDoAlbum;
    private javax.swing.JLabel jLabelComentarios;
    private javax.swing.JLabel jLabelConfirma;
    private javax.swing.JLabel jLabelDiretorio;
    private javax.swing.JLabel jLabelGenero;
    private javax.swing.JLabel jLabelMsg;
    private javax.swing.JLabel jLabelNomeMusicas;
    private javax.swing.JLabel jLabelOrdemNumerica;
    private javax.swing.JLabel jLabelSubtitle;
    private javax.swing.JRadioButton jRadioButtonConfirma;
    private javax.swing.JRadioButton jRadioButtonOrdemNumerica;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTabela;
    private javax.swing.JTextField jTextFieldAlbum;
    private javax.swing.JTextField jTextFieldAno;
    private javax.swing.JTextField jTextFieldAristaDoAlbum;
    private javax.swing.JTextField jTextFieldArtista;
    private javax.swing.JTextField jTextFieldComentarios;
    private javax.swing.JTextField jTextFieldEndereco;
    private javax.swing.JTextField jTextFieldGenero;
    private javax.swing.JTextField jTextFieldSubtitle;
    // End of variables declaration//GEN-END:variables
}
