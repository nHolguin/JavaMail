
package javamail;

import dao.MensajeDAO;
import javax.swing.JOptionPane;

/**
 *
 * @author Nimrod
 * 
 */
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Mensaje;

public class JavaMail extends javax.swing.JFrame {

    private String valorARB;
    private String valorCPH;
    private String valorCPS;
    private String valorDES;
    private String valorCRB;
    private Hashtable<String, String> listaMensaje = new Hashtable<String, String>();
    MensajeDAO mensajeDao = new MensajeDAO();
    Mensaje mensaje = new Mensaje();

    /**
     * Creates new form Mail
     */
    public JavaMail() {

        try {
            mensaje = mensajeDao.obtenerMensaje(1);
        } catch (SQLException ex) {
            Logger.getLogger(JavaMail.class.getName()).log(Level.SEVERE, null, ex);
        }
        valorARB = mensaje.getArbMensaje();
        valorCPH = mensaje.getCphMensaje();
        valorCPS = mensaje.getCpsMensaje();
        valorDES = mensaje.getDesMensaje();
        valorCRB = mensaje.getCrbMensaje();

        initComponents();
    }

    private void initConfiguracionMensaje() {

        arb.setText(valorARB);
        cph.setText(valorCPH);
        cps.setText(valorCPS);
        des.setText(valorDES);
        crb.setText(valorCRB);

    }

    private void copy(String copiar) {

        StringSelection selection = new StringSelection(copiar);

        Clipboard resultado = Toolkit.getDefaultToolkit().getSystemClipboard();

        resultado.setContents(selection, null);

    }

    private String paste() {

        String resultado = "";

        Clipboard valor = Toolkit.getDefaultToolkit().getSystemClipboard();

        Transferable contenido = valor.getContents(null);

        if (contenido.isDataFlavorSupported(DataFlavor.stringFlavor)) {
            try {
                resultado = (String) contenido.getTransferData(DataFlavor.stringFlavor);
            } catch (UnsupportedFlavorException ex) {
                Logger.getLogger(JavaMail.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(JavaMail.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return resultado;

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        recibido = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        enviar = new javax.swing.JTextArea();
        copiar = new javax.swing.JButton();
        checkARB = new javax.swing.JCheckBox();
        checkCPH = new javax.swing.JCheckBox();
        checkCPS = new javax.swing.JCheckBox();
        checkDES = new javax.swing.JCheckBox();
        checkCRB = new javax.swing.JCheckBox();
        pegar = new javax.swing.JButton();
        limpiarTodo = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        limpiarRecibido = new javax.swing.JButton();
        limpiarEnviar = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        arb = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        cph = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        des = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        cps = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        crb = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        recibido.setColumns(20);
        recibido.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        recibido.setLineWrap(true);
        recibido.setRows(5);
        recibido.setWrapStyleWord(true);
        recibido.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane3.setViewportView(recibido);

        enviar.setColumns(20);
        enviar.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        enviar.setLineWrap(true);
        enviar.setRows(5);
        enviar.setWrapStyleWord(true);
        enviar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane4.setViewportView(enviar);

        copiar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        copiar.setText("Copiar");
        copiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                copiarActionPerformed(evt);
            }
        });

        checkARB.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        checkARB.setForeground(new java.awt.Color(0, 0, 102));
        checkARB.setText("ARB");
        checkARB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkARBActionPerformed(evt);
            }
        });

        checkCPH.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        checkCPH.setForeground(new java.awt.Color(0, 0, 102));
        checkCPH.setText("CPH");
        checkCPH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkCPHActionPerformed(evt);
            }
        });

        checkCPS.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        checkCPS.setForeground(new java.awt.Color(0, 0, 102));
        checkCPS.setText("CPS");
        checkCPS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkCPSActionPerformed(evt);
            }
        });

        checkDES.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        checkDES.setForeground(new java.awt.Color(0, 0, 102));
        checkDES.setText("DES");
        checkDES.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkDESActionPerformed(evt);
            }
        });

        checkCRB.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        checkCRB.setForeground(new java.awt.Color(0, 0, 102));
        checkCRB.setText("CRB");
        checkCRB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkCRBActionPerformed(evt);
            }
        });

        pegar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        pegar.setText("Pegar");
        pegar.setToolTipText("");
        pegar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pegarActionPerformed(evt);
            }
        });

        limpiarTodo.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        limpiarTodo.setText("Limpiar Todo");
        limpiarTodo.setToolTipText("Limpiar Todos Los Campos");
        limpiarTodo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarTodoActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 0, 102));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Recibido");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 3, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 102));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Enviar");

        limpiarRecibido.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        limpiarRecibido.setText("Limpiar Recibido");
        limpiarRecibido.setToolTipText("Limpiar Solo Campo Recibido");
        limpiarRecibido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarRecibidoActionPerformed(evt);
            }
        });

        limpiarEnviar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        limpiarEnviar.setText("Limpiar Enviar");
        limpiarEnviar.setToolTipText("Limpiar Solo Campo Enviar");
        limpiarEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarEnviarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(checkARB)
                            .addComponent(checkCPH)
                            .addComponent(checkCPS)
                            .addComponent(checkDES)
                            .addComponent(checkCRB)
                            .addComponent(limpiarTodo)
                            .addComponent(limpiarEnviar)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(limpiarRecibido)))
                .addGap(24, 24, 24))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(88, 88, 88)
                        .addComponent(jLabel6)
                        .addGap(194, 194, 194)
                        .addComponent(jLabel7))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(91, 91, 91)
                        .addComponent(pegar)
                        .addGap(206, 206, 206)
                        .addComponent(copiar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(checkARB)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(checkCPH)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(checkCPS)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(checkDES)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(checkCRB)
                        .addGap(33, 33, 33)
                        .addComponent(limpiarTodo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(limpiarRecibido)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(limpiarEnviar)
                        .addGap(0, 136, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane4)
                            .addComponent(jScrollPane3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(pegar)
                            .addComponent(copiar))))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Respuestas", jPanel1);

        jPanel2.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jPanel2AncestorAdded(evt);
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 102));
        jLabel1.setText("ARB");

        arb.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        arb.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        arb.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                arbFocusLost(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 102));
        jLabel2.setText("CPH");

        cph.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        cph.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cph.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cphFocusLost(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 102));
        jLabel3.setText("DES");

        des.setColumns(20);
        des.setLineWrap(true);
        des.setRows(5);
        des.setWrapStyleWord(true);
        des.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        des.setRows(5);
        des.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        des.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                desFocusLost(evt);
            }
        });
        jScrollPane1.setViewportView(des);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 102));
        jLabel4.setText("CPS");

        cps.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        cps.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        cps.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                cpsFocusLost(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 102));
        jLabel5.setText("CRB");

        crb.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        crb.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        crb.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                crbFocusLost(evt);
            }
        });
        crb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crbActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(arb)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addGap(0, 646, Short.MAX_VALUE))
                    .addComponent(cph)
                    .addComponent(cps)
                    .addComponent(jScrollPane1)
                    .addComponent(crb))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(arb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cph, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cps, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(crb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        jTabbedPane1.addTab("Configuración", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 466, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 10, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void crbActionPerformed(java.awt.event.ActionEvent evt) {                                    
        // TODO add your handling code here:
    }                                   

    private void copiarActionPerformed(java.awt.event.ActionEvent evt) {                                       
        // TODO add your handling code here:
        copy(enviar.getText());
    }                                      

    private void pegarActionPerformed(java.awt.event.ActionEvent evt) {                                      
        // TODO add your handling code here:
        recibido.setText(paste());
    }                                     

    private void limpiarCheck() {
        checkARB.setSelected(false);
        checkCPH.setSelected(false);
        checkCPS.setSelected(false);
        checkDES.setSelected(false);
        checkCRB.setSelected(false);
    }

    private void limpiarTodoActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
        enviar.setText("");
        recibido.setText("");
        limpiarCheck();
        listaMensaje.clear();

    }                                           

    private void limpiarRecibidoActionPerformed(java.awt.event.ActionEvent evt) {                                                
        // TODO add your handling code here:
        recibido.setText("");
    }                                               

    private void limpiarEnviarActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
        enviar.setText("");
        limpiarCheck();
        listaMensaje.clear();
    }                                             

    private void mostrarMensaje() {

        String mensaje = "";
        String[] claves = (String[]) listaMensaje.keySet().toArray(new String[0]);

        java.util.Arrays.sort(claves);

        for (String clave : claves) {
            if (clave == "a") {
                mensaje += listaMensaje.get(clave) + "\n\n";
            } else {
                mensaje += listaMensaje.get(clave) + "\n\n";
            }
        }

        enviar.setText(mensaje);

    }

    private void eventoCheckbox(int flag) {

        boolean check = false;

        //JOptionPane.showMessageDialog(null, mensaje.getArbMensaje());
        switch (flag) {
            case 1:
                if (checkARB.isSelected() == true) {
                    check = true;
                } else if (checkARB.isSelected() == false) {
                    check = false;
                }
                break;
            case 2:
                if (checkCPH.isSelected() == true) {
                    check = true;
                } else if (checkCPH.isSelected() == false) {
                    check = false;
                }
                break;
            case 3:
                if (checkCPS.isSelected() == true) {
                    check = true;
                } else if (checkCPS.isSelected() == false) {
                    check = false;
                }
                break;
            case 4:
                if (checkDES.isSelected() == true) {
                    check = true;
                } else if (checkDES.isSelected() == false) {
                    check = false;
                }
                break;
            case 5:
                if (checkCRB.isSelected() == true) {
                    check = true;
                } else if (checkCRB.isSelected() == false) {
                    check = false;
                }
                break;
        }

        if (flag == 1) {
            if (check == true) {
                listaMensaje.put("a", valorARB);
            } else {
                listaMensaje.remove("a");
            }
        }

        if (flag == 2) {
            if (check == true) {
                listaMensaje.put("b", valorCPH);
            } else {
                listaMensaje.remove("b");
            }
        }

        if (flag == 3) {
            if (check == true) {
                listaMensaje.put("c", valorCPS);
            } else {
                listaMensaje.remove("c");
            }
        }

        if (flag == 4) {
            if (check == true) {
                listaMensaje.put("d", valorDES);
            } else {
                listaMensaje.remove("d");
            }
        }

        if (flag == 5) {
            if (check == true) {
                listaMensaje.put("e", valorCRB);
            } else {
                listaMensaje.remove("e");
            }
        }

        mostrarMensaje();
        //JOptionPane.showMessageDialog(null, listaMensaje);

    }

    private void checkARBActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:

        eventoCheckbox(1);
    }                                        

    private void checkCPHActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        eventoCheckbox(2);
    }                                        

    private void checkCPSActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        eventoCheckbox(3);
    }                                        

    private void checkDESActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        eventoCheckbox(4);
    }                                        

    private void checkCRBActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        eventoCheckbox(5);
    }                                        

    private void jPanel2AncestorAdded(javax.swing.event.AncestorEvent evt) {                                      
        // TODO add your handling code here:
        initConfiguracionMensaje();
    }                                     

    private void actualizarCampos() {
        
        valorARB = arb.getText();
        valorCPH = cph.getText();
        valorCPS = cps.getText();
        valorDES = des.getText();
        valorCRB = crb.getText();
        
        arb.setText(valorARB);
        cph.setText(valorCPH);
        cps.setText(valorCPS);
        des.setText(valorDES);
        crb.setText(valorCRB);
        
        
    }
    
    private void arbFocusLost(java.awt.event.FocusEvent evt) {                              

        // TODO add your handling code here:
        int id = 1;
        MensajeDAO mDao = new MensajeDAO();
        Mensaje m = new Mensaje();

        m.setIdMensaje(id);
        m.setArbMensaje(arb.getText());
        m.setCphMensaje(cph.getText());
        m.setCpsMensaje(cps.getText());
        m.setDesMensaje(des.getText());
        m.setCrbMensaje(crb.getText());

        try {
            mDao.editar(m);
            actualizarCampos();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }                             

    private void cphFocusLost(java.awt.event.FocusEvent evt) {                              
        // TODO add your handling code here:
        int id = 1;
        MensajeDAO mDao = new MensajeDAO();
        Mensaje m = new Mensaje();

        m.setIdMensaje(id);
        m.setArbMensaje(arb.getText());
        m.setCphMensaje(cph.getText());
        m.setCpsMensaje(cps.getText());
        m.setDesMensaje(des.getText());
        m.setCrbMensaje(crb.getText());

        try {
            mDao.editar(m);
            actualizarCampos();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }                             

    private void cpsFocusLost(java.awt.event.FocusEvent evt) {                              
        // TODO add your handling code here:
        int id = 1;
        MensajeDAO mDao = new MensajeDAO();
        Mensaje m = new Mensaje();

        m.setIdMensaje(id);
        m.setArbMensaje(arb.getText());
        m.setCphMensaje(cph.getText());
        m.setCpsMensaje(cps.getText());
        m.setDesMensaje(des.getText());
        m.setCrbMensaje(crb.getText());

        try {
            mDao.editar(m);
            actualizarCampos();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }                             

    private void desFocusLost(java.awt.event.FocusEvent evt) {                              
        // TODO add your handling code here:
        int id = 1;
        MensajeDAO mDao = new MensajeDAO();
        Mensaje m = new Mensaje();

        m.setIdMensaje(id);
        m.setArbMensaje(arb.getText());
        m.setCphMensaje(cph.getText());
        m.setCpsMensaje(cps.getText());
        m.setDesMensaje(des.getText());
        m.setCrbMensaje(crb.getText());

        try {
            mDao.editar(m);
            actualizarCampos();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }                             

    private void crbFocusLost(java.awt.event.FocusEvent evt) {                              
        // TODO add your handling code here:
        int id = 1;
        MensajeDAO mDao = new MensajeDAO();
        Mensaje m = new Mensaje();

        m.setIdMensaje(id);
        m.setArbMensaje(arb.getText());
        m.setCphMensaje(cph.getText());
        m.setCpsMensaje(cps.getText());
        m.setDesMensaje(des.getText());
        m.setCrbMensaje(crb.getText());

        try {
            mDao.editar(m);
            actualizarCampos();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }                             

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
            java.util.logging.Logger.getLogger(JavaMail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JavaMail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JavaMail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JavaMail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                Toolkit pantalla = Toolkit.getDefaultToolkit();
                //Dimension tamanioPantalla = pantalla.getScreenSize();

                //int altoPantalla = tamanioPantalla.height;
                //int anchoPantalla = tamanioPantalla.width;

                //setSize(anchoPantalla / 2, altoPantalla / 2);
                JavaMail mail = new JavaMail();
                mail.setTitle("App Mail");

                Image icono = pantalla.getImage("images/mail.png");
                mail.setIconImage(icono);

                mail.setLocationRelativeTo(null);
                //mail.setLocation(anchoPantalla / 4, altoPantalla / 4);

                mail.setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JTextField arb;
    private javax.swing.JCheckBox checkARB;
    private javax.swing.JCheckBox checkCPH;
    private javax.swing.JCheckBox checkCPS;
    private javax.swing.JCheckBox checkCRB;
    private javax.swing.JCheckBox checkDES;
    private javax.swing.JButton copiar;
    private javax.swing.JTextField cph;
    private javax.swing.JTextField cps;
    private javax.swing.JTextField crb;
    private javax.swing.JTextArea des;
    private javax.swing.JTextArea enviar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton limpiarEnviar;
    private javax.swing.JButton limpiarRecibido;
    private javax.swing.JButton limpiarTodo;
    private javax.swing.JButton pegar;
    private javax.swing.JTextArea recibido;
    // End of variables declaration                   

}