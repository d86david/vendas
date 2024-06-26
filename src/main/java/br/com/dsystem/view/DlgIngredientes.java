/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package br.com.dsystem.view;

import br.com.dsystem.controller.IngredienteController;
import br.com.dsystem.model.Ingrediente;
import br.com.dsystem.util.CamposNumericos;
import javax.swing.JOptionPane;

/**
 *
 * @author david
 */
public class DlgIngredientes extends javax.swing.JDialog {

    private final IngredienteController ingrController = new IngredienteController();
    private boolean eNovo = false;

    /**
     * Creates new form JdlLayoutGrades
     */
    public DlgIngredientes(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        ingrController.carregarTabelaIngrediente(tblIngrediente);
        txtCodigo.setDocument(new CamposNumericos(4));
        btnSalvar.setVisible(false);
        btnCancelar.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField1 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblIngrediente = new javax.swing.JTable();
        lblNome = new javax.swing.JLabel();
        txtDescricao = new javax.swing.JTextField();
        btnPesquisaDesc = new javax.swing.JButton();
        lblCodigo = new javax.swing.JLabel();
        btnPesquisaCodigo = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        btnNovo = new javax.swing.JButton();
        btnEditar = new javax.swing.JButton();
        btnSalvar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        btnExcluir = new javax.swing.JButton();
        txtCodigo = new javax.swing.JTextField();
        btnAtualizaGrade = new javax.swing.JButton();

        jTextField1.setText("jTextField1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Tabela de Ingredientes");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(72, 128, 242));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Ingredientes");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(17, 17, 17))
        );

        tblIngrediente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblIngrediente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblIngredienteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblIngrediente);

        lblNome.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblNome.setText("Ingrediente:");

        txtDescricao.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        btnPesquisaDesc.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnPesquisaDesc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/busca32.png"))); // NOI18N
        btnPesquisaDesc.setToolTipText("Pesquisar descrição");
        btnPesquisaDesc.setMaximumSize(new java.awt.Dimension(32, 32));
        btnPesquisaDesc.setMinimumSize(new java.awt.Dimension(32, 32));
        btnPesquisaDesc.setPreferredSize(new java.awt.Dimension(32, 32));
        btnPesquisaDesc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisaDescActionPerformed(evt);
            }
        });

        lblCodigo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblCodigo.setText("Código:");

        btnPesquisaCodigo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnPesquisaCodigo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/busca32.png"))); // NOI18N
        btnPesquisaCodigo.setToolTipText("Pesquisar código");
        btnPesquisaCodigo.setMaximumSize(new java.awt.Dimension(32, 32));
        btnPesquisaCodigo.setMinimumSize(new java.awt.Dimension(32, 32));
        btnPesquisaCodigo.setPreferredSize(new java.awt.Dimension(32, 32));
        btnPesquisaCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPesquisaCodigoActionPerformed(evt);
            }
        });

        btnNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/novo.png"))); // NOI18N
        btnNovo.setToolTipText("Novo");
        btnNovo.setMaximumSize(new java.awt.Dimension(39, 39));
        btnNovo.setMinimumSize(new java.awt.Dimension(39, 39));
        btnNovo.setName("Novo"); // NOI18N
        btnNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNovoActionPerformed(evt);
            }
        });

        btnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/editar.png"))); // NOI18N
        btnEditar.setToolTipText("Editar");
        btnEditar.setMaximumSize(new java.awt.Dimension(39, 39));
        btnEditar.setMinimumSize(new java.awt.Dimension(39, 39));
        btnEditar.setName("Editar"); // NOI18N
        btnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarActionPerformed(evt);
            }
        });

        btnSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/salvar.png"))); // NOI18N
        btnSalvar.setToolTipText("Salvar");
        btnSalvar.setMaximumSize(new java.awt.Dimension(39, 39));
        btnSalvar.setMinimumSize(new java.awt.Dimension(39, 39));
        btnSalvar.setName("Salvar"); // NOI18N
        btnSalvar.setPreferredSize(new java.awt.Dimension(39, 39));
        btnSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalvarActionPerformed(evt);
            }
        });

        btnCancelar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/voltar.png"))); // NOI18N
        btnCancelar.setToolTipText("Cancelar");
        btnCancelar.setMaximumSize(new java.awt.Dimension(39, 39));
        btnCancelar.setMinimumSize(new java.awt.Dimension(39, 39));
        btnCancelar.setName("Cancelar"); // NOI18N
        btnCancelar.setPreferredSize(new java.awt.Dimension(39, 39));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/excluir.png"))); // NOI18N
        btnExcluir.setToolTipText("Excluir");
        btnExcluir.setMaximumSize(new java.awt.Dimension(39, 39));
        btnExcluir.setMinimumSize(new java.awt.Dimension(39, 39));
        btnExcluir.setName("Excluir"); // NOI18N
        btnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirActionPerformed(evt);
            }
        });

        txtCodigo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        btnAtualizaGrade.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnAtualizaGrade.setText("Atualizar Grade");
        btnAtualizaGrade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAtualizaGradeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addComponent(jSeparator2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 602, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblNome)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtDescricao)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnPesquisaDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(203, 203, 203))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(lblCodigo)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnPesquisaCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btnAtualizaGrade)
                                        .addGap(75, 75, 75)))))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(137, 137, 137)
                        .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblCodigo)
                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btnPesquisaCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAtualizaGrade))
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNome)
                            .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnPesquisaDesc, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNovoActionPerformed
        limpatela();
        habilitaEdicao();
        eNovo = true;
    }//GEN-LAST:event_btnNovoActionPerformed

    private void btnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarActionPerformed
        if (txtCodigo.getText().isEmpty() || txtDescricao.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Selecione um ingrediente!", "Ingredientes", JOptionPane.WARNING_MESSAGE);
        } else {
            Ingrediente ingr = new Ingrediente();
            ingr.setId(Integer.parseInt(txtCodigo.getText()));
            ingr.setIngrediente(txtDescricao.getText());
            if (ingrController.verificaIngrediente(ingr)) {
                txtCodigo.setText(Integer.toString(ingr.getId()));
                habilitaEdicao();
                eNovo = false;
            } else {
                JOptionPane.showMessageDialog(this, "Ingrediente não cadastrado", "Ingredientes", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnEditarActionPerformed

    private void btnSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalvarActionPerformed

        Ingrediente ingr = new Ingrediente();
        ingr.setIngrediente(txtDescricao.getText());

        if (eNovo == true) {
            if (ingrController.verificaIngrediente(ingr)) {
                JOptionPane.showMessageDialog(this, "Ingrediente ja Cadastrado", "Ingredientes", JOptionPane.WARNING_MESSAGE);
            } else {
                ingrController.cadastrarIngrediente(ingr.getIngrediente());
                JOptionPane.showMessageDialog(this, "Ingrediente Cadastrado\nCom Sucesso", "Ingredientes", JOptionPane.INFORMATION_MESSAGE);
                limpatela();
                fechaEdicao();
                ingrController.carregarTabelaIngrediente(tblIngrediente);
            }
        } else {
            if (ingrController.verificaIngrediente(ingr)) {
                JOptionPane.showMessageDialog(this, "Ingrediente ja Cadastrado", "Ingredientes", JOptionPane.WARNING_MESSAGE);
            }else{
                ingr.setId(Integer.parseInt(txtCodigo.getText()));
                ingrController.atualizarIngrediente(ingr);
                JOptionPane.showMessageDialog(this, "Ingrediente Atualizado\nCom Sucesso", "Ingredientes", JOptionPane.INFORMATION_MESSAGE);
                fechaEdicao();
                ingrController.carregarTabelaIngrediente(tblIngrediente);
            }

        }

    }//GEN-LAST:event_btnSalvarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed

        if (txtCodigo.getText().isEmpty()) {
            limpatela();
            fechaEdicao();
        } else {
            Ingrediente i = ingrController.buscarIdIngrediente(Integer.parseInt(txtCodigo.getText()));
            txtCodigo.setText(Integer.toString(i.getId()));
            txtDescricao.setText(i.getIngrediente());
            ingrController.carregarTabelaIngrediente(tblIngrediente);
            fechaEdicao();
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirActionPerformed
        if (txtCodigo.getText().isEmpty() || txtDescricao.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Selecione um ingrediente!");
        } else {
            Ingrediente ingr = new Ingrediente();
            ingr.setId(Integer.parseInt(txtCodigo.getText()));
            ingr.setIngrediente(txtDescricao.getText());

            if (ingrController.verificaIngrediente(ingr)) {
                int resp = JOptionPane.showConfirmDialog(null, "Confirma exlcusão de ingrediente", "Exlcusão", JOptionPane.YES_NO_OPTION);
                if (resp == JOptionPane.YES_OPTION) {
                    ingrController.deletarIngrediente(ingr);
                    JOptionPane.showMessageDialog(this, "Ingrediente Exluído\nCom Sucesso!", "Ingredientes", JOptionPane.INFORMATION_MESSAGE);
                    ingrController.carregarTabelaIngrediente(tblIngrediente);
                } else {
                    JOptionPane.showMessageDialog(this, "Ingrediente ja Cadastrado", "Ingredientes", JOptionPane.WARNING_MESSAGE);
                }
            }
//
        }
    }//GEN-LAST:event_btnExcluirActionPerformed

    private void btnPesquisaCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisaCodigoActionPerformed
        if (txtCodigo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Selecione um Ingrediente!", "Ingredientes", JOptionPane.INFORMATION_MESSAGE);
        } else {
            Ingrediente ingr = new Ingrediente();
            ingr.setId(Integer.parseInt(txtCodigo.getText()));
            ingr.setIngrediente(txtDescricao.getText());

            if (ingrController.verificaIngrediente(ingr)) {
                ingrController.buscarIdIngrediente(tblIngrediente, ingr);
            } else {
                JOptionPane.showMessageDialog(this, "Ingrediente não encontrado", "Ingredientes", JOptionPane.WARNING_MESSAGE);
            }

        }
    }//GEN-LAST:event_btnPesquisaCodigoActionPerformed

    private void btnPesquisaDescActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPesquisaDescActionPerformed
        if (txtDescricao.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Selecione um Ingrediente!", "Ingredientes", JOptionPane.INFORMATION_MESSAGE);
        } else {
            Ingrediente ingr = new Ingrediente();
            ingr.setId(Integer.parseInt(txtCodigo.getText()));
            ingr.setIngrediente(txtDescricao.getText());

            if (ingrController.verificaIngrediente(ingr)) {
                ingrController.buscarIdIngrediente(tblIngrediente, ingr);
            } else {
                JOptionPane.showMessageDialog(this, "Ingrediente ja Cadastrado", "Ingredientes", JOptionPane.WARNING_MESSAGE);
            }

        }
    }//GEN-LAST:event_btnPesquisaDescActionPerformed

    private void tblIngredienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblIngredienteMouseClicked
        if (evt.getClickCount() == 2) {
            txtCodigo.setText(tblIngrediente.getValueAt(tblIngrediente.getSelectedRow(), 0).toString());
            txtDescricao.setText(tblIngrediente.getValueAt(tblIngrediente.getSelectedRow(), 1).toString());
        }
    }//GEN-LAST:event_tblIngredienteMouseClicked

    private void btnAtualizaGradeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAtualizaGradeActionPerformed
        ingrController.carregarTabelaIngrediente(tblIngrediente);
    }//GEN-LAST:event_btnAtualizaGradeActionPerformed

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
            java.util.logging.Logger.getLogger(DlgIngredientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DlgIngredientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DlgIngredientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DlgIngredientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DlgIngredientes dialog = new DlgIngredientes(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAtualizaGrade;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnEditar;
    private javax.swing.JButton btnExcluir;
    private javax.swing.JButton btnNovo;
    private javax.swing.JButton btnPesquisaCodigo;
    private javax.swing.JButton btnPesquisaDesc;
    private javax.swing.JButton btnSalvar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblNome;
    private javax.swing.JTable tblIngrediente;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtDescricao;
    // End of variables declaration//GEN-END:variables

// METODOS 
    private void habilitaEdicao() {
        btnSalvar.setVisible(true);
        btnCancelar.setVisible(true);
        btnNovo.setVisible(false);
        btnEditar.setVisible(false);
        btnExcluir.setVisible(false);
        txtCodigo.setEditable(false);
        btnPesquisaCodigo.setEnabled(false);
        btnPesquisaDesc.setEnabled(false);

    }

    private void fechaEdicao() {
        btnSalvar.setVisible(false);
        btnCancelar.setVisible(false);
        btnNovo.setVisible(true);
        btnEditar.setVisible(true);
        btnExcluir.setVisible(true);
        txtCodigo.setEditable(true);
        btnPesquisaCodigo.setEnabled(true);
        btnPesquisaDesc.setEnabled(true);
    }

    private void limpatela() {
        txtCodigo.setText("");
        txtDescricao.setText("");
    }

}
