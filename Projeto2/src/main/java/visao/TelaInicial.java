/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visao;

import modelo.Usuario;

/**
 *
 * @author glaykiere
 */
public class TelaInicial extends javax.swing.JFrame {
    private Usuario u;
    /**
     * Creates new form TelaInicial
     */
    public TelaInicial() {
        initComponents();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        botaoCadMovimentacao = new javax.swing.JButton();
        botaoGerFinancas = new javax.swing.JButton();
        botaoGerPerfil = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tela Inicial");

        botaoCadMovimentacao.setText("Cadastrar Movimentação");
        botaoCadMovimentacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCadMovimentacaoActionPerformed(evt);
            }
        });

        botaoGerFinancas.setText("Gerenciar Finanças");
        botaoGerFinancas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoGerFinancasActionPerformed(evt);
            }
        });

        botaoGerPerfil.setText("Gerenciar Perfil");
        botaoGerPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoGerPerfilActionPerformed(evt);
            }
        });

        jButton1.setText("Sair");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(botaoCadMovimentacao)
                .addGap(18, 18, 18)
                .addComponent(botaoGerFinancas)
                .addGap(18, 18, 18)
                .addComponent(botaoGerPerfil)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoCadMovimentacao)
                    .addComponent(botaoGerFinancas)
                    .addComponent(botaoGerPerfil))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 218, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoCadMovimentacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCadMovimentacaoActionPerformed
        // TODO add your handling code here:
        TelaCadastrarMovimentacao tela = new TelaCadastrarMovimentacao();
        tela.setVisible(true);
        tela.recebeUsuario(u);
        dispose();
    }//GEN-LAST:event_botaoCadMovimentacaoActionPerformed

    private void botaoGerPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoGerPerfilActionPerformed
        // TODO add your handling code here:
        TelaGerenciarUsuario tela = new TelaGerenciarUsuario();        
        tela.setVisible(true);
        tela.recebeUsuario(u);
        dispose();
    }//GEN-LAST:event_botaoGerPerfilActionPerformed

    private void botaoGerFinancasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoGerFinancasActionPerformed
        // TODO add your handling code here:
        TelaGerenciarFinancas tela = new TelaGerenciarFinancas();
        tela.setVisible(true);
        tela.recebeUsuario(u);
        dispose();
    }//GEN-LAST:event_botaoGerFinancasActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        TelaLogin tela = new TelaLogin();
        tela.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaInicial.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaInicial().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoCadMovimentacao;
    private javax.swing.JButton botaoGerFinancas;
    private javax.swing.JButton botaoGerPerfil;
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables

    public void recebeUsuario(Usuario u) {        
        this.u = u;        
    }
}
