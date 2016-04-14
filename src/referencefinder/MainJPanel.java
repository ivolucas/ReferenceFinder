package referencefinder;

import java.io.*;
import java.nio.charset.Charset;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.event.TableModelListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.TableModel;

/*
 * To change this template, choose Tools | Templates and open the template in
 * the editor.
 */
/**
 *
 * @author ilucas
 */
public class MainJPanel extends javax.swing.JPanel {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                javax.swing.JFrame frame = new javax.swing.JFrame("Reference finder");
                frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
                frame.getContentPane().add(new MainJPanel());
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
    JFileChooser fc;
    List<RegexConfig> regexConfigs = new ArrayList<RegexConfig>();
    TableModel tableModel = new TableModel() {
        @Override
        public int getRowCount() {
            return regexConfigs.size();
        }

        @Override
        public int getColumnCount() {
            return 3;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            RegexConfig regexConfig = regexConfigs.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    return regexConfig.getStringRegex();
                case 1:
                    return regexConfig.getGroupExtract();
                case 2:
                    return regexConfig.getDescription();
                default:
                    return "";
            }
        }

        @Override
        public String getColumnName(int columnIndex) {
            switch (columnIndex) {
                case 0:
                    return "Extract Regex";
                case 1:
                    return "Extract Group";
                case 2:
                    return "Description";
                default:
                    return "";
            }
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            switch (columnIndex) {
                case 0:
                    return String.class;
                case 1:
                    return Integer.class;
                case 2:
                    return String.class;
                default:
                    return String.class;
            }
        }

        @Override
        public boolean isCellEditable(int rowIndex, int columnIndex) {
            return true;
        }

        @Override
        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
            RegexConfig regexConfig = regexConfigs.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    regexConfig.setStringRegex((String) aValue);
                    return;
                case 1:
                    regexConfig.setGroupExtract((Integer) aValue);
                    return;
                case 2:
                    regexConfig.setDescription((String) aValue);
                    return;
                default:

            }
        }

        @Override
        public void addTableModelListener(TableModelListener l) {
//            throw new UnsupportedOperationException("Not supported yet.");
        }

        @Override
        public void removeTableModelListener(TableModelListener l) {
//            throw new UnsupportedOperationException("Not supported yet.");
        }
    };

    public List<RegexConfig> getRegexConfigs() {
        return regexConfigs;
    }

    public void setRegexConfigs(List<RegexConfig> regexConfigs) {
        this.regexConfigs = regexConfigs;
    }

    /**
     * Creates new form MainJPanel
     */
    public MainJPanel() {
        initComponents();
        System.setOut(new PrintStream(new OutputStream() {
            @Override
            public void write(int b) throws IOException {
                log(String.valueOf((char) b));
            }
        }));


        System.setErr(new PrintStream(new OutputStream() {
            @Override
            public void write(int b) throws IOException {
                log(String.valueOf((char) b));
            }
        }));



    }
    int i = 0;

    public void log(String s) {
        ++i;
        jTextAreaLog.append(s);
        if (i > 20 || s.equalsIgnoreCase("\n")) {
            i = 0;
            jTextAreaProps.repaint();
            jTextAreaLog.setCaretPosition(jTextAreaLog.getDocument().getLength());
        }
    }

    public List<MatchFound> referenceFinder(File dir, String fileRegex, RegexConfig regexConfig, Charset fileEnconding) {
        StringFinder stringFinder = new StringFinder(fileRegex, regexConfig, fileEnconding);
        stringFinder.process(dir);
        int i = dir.getAbsolutePath().length();
        i++;
        for (MatchFound m : stringFinder.getMatchList()) {
            String relativePath = m.getFile().getAbsolutePath().substring(i);
            System.out.print(relativePath);
            System.out.print("\t");
            System.out.print(m.getMatched());
            System.out.print("\t");
            System.out.print(m.getLine());
            System.out.println();
        }
        return stringFinder.getMatchList();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane4 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jButtonExtract = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jButtonWorkFolder = new javax.swing.JButton();
        jTextFieldWorkFolder = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldFileEnconding = new javax.swing.JTextField();
        jTextFieldFileRegex = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextFieldBundleFile = new javax.swing.JTextField();
        jButtonLoadConfig = new javax.swing.JButton();
        jButtonSaveConfig = new javax.swing.JButton();
        jTabbedPanelNewProperties = new javax.swing.JTabbedPane();
        jPanelProperties = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextAreaProps = new javax.swing.JTextArea();
        jPanelLog = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextAreaLog = new javax.swing.JTextArea();
        jPanelRegexRule = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabelDescription = new javax.swing.JLabel();
        jTextFieldRegex = new javax.swing.JTextField();
        jTextFieldDescription = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextFieldExtractGroup = new javax.swing.JTextField();
        jButtonAddRegex = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTableRegex = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaNewProperties = new javax.swing.JTextArea();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(jTable1);

        jButtonExtract.setText("Extract");
        jButtonExtract.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExtractActionPerformed(evt);
            }
        });

        jLabel3.setText("File Enconding");

        jLabel8.setText("File Regex Filter");

        jButtonWorkFolder.setText("Select Folder");
        jButtonWorkFolder.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonWorkFolderActionPerformed(evt);
            }
        });

        jLabel4.setText("Work Folder");

        jTextFieldFileEnconding.setText("UTF-8");

        jButton3.setText("Select Bundle");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel1.setText("Bundle File");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel8)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jTextFieldFileRegex, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jTextFieldFileEnconding, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 170, Short.MAX_VALUE))
                    .addComponent(jTextFieldWorkFolder, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextFieldBundleFile))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonWorkFolder)
                    .addComponent(jButton3)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldWorkFolder, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonWorkFolder))
                .addGap(3, 3, 3)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldFileRegex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldFileEnconding, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldBundleFile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3)))
        );

        jButtonLoadConfig.setText("Load Config");
        jButtonLoadConfig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLoadConfigActionPerformed(evt);
            }
        });

        jButtonSaveConfig.setText("Save Config");
        jButtonSaveConfig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSaveConfigActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonExtract, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonLoadConfig, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonSaveConfig, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jButtonExtract)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonLoadConfig)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonSaveConfig)
                .addGap(12, 12, 12))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTextAreaProps.setColumns(20);
        jTextAreaProps.setRows(5);
        jScrollPane5.setViewportView(jTextAreaProps);

        javax.swing.GroupLayout jPanelPropertiesLayout = new javax.swing.GroupLayout(jPanelProperties);
        jPanelProperties.setLayout(jPanelPropertiesLayout);
        jPanelPropertiesLayout.setHorizontalGroup(
            jPanelPropertiesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 912, Short.MAX_VALUE)
        );
        jPanelPropertiesLayout.setVerticalGroup(
            jPanelPropertiesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 476, Short.MAX_VALUE)
        );

        jTabbedPanelNewProperties.addTab("Report", jPanelProperties);

        jTextAreaLog.setColumns(20);
        jTextAreaLog.setEditable(false);
        jTextAreaLog.setRows(5);
        jScrollPane3.setViewportView(jTextAreaLog);

        javax.swing.GroupLayout jPanelLogLayout = new javax.swing.GroupLayout(jPanelLog);
        jPanelLog.setLayout(jPanelLogLayout);
        jPanelLogLayout.setHorizontalGroup(
            jPanelLogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 912, Short.MAX_VALUE)
        );
        jPanelLogLayout.setVerticalGroup(
            jPanelLogLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 476, Short.MAX_VALUE)
        );

        jTabbedPanelNewProperties.addTab("Log", jPanelLog);

        jLabel5.setText("Extract Regex ");

        jLabelDescription.setText("Description");

        jLabel7.setText("Exctract Group");

        jButtonAddRegex.setText("Add");
        jButtonAddRegex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddRegexActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldRegex)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldExtractGroup, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelDescription)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextFieldDescription)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonAddRegex, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabelDescription)
                    .addComponent(jTextFieldRegex, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldDescription, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jTextFieldExtractGroup, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAddRegex))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTableRegex.setModel(tableModel);
        jScrollPane6.setViewportView(jTableRegex);

        jButton1.setText("Load From File");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Save To File");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelRegexRuleLayout = new javax.swing.GroupLayout(jPanelRegexRule);
        jPanelRegexRule.setLayout(jPanelRegexRuleLayout);
        jPanelRegexRuleLayout.setHorizontalGroup(
            jPanelRegexRuleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 912, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelRegexRuleLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap())
        );
        jPanelRegexRuleLayout.setVerticalGroup(
            jPanelRegexRuleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRegexRuleLayout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelRegexRuleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1)))
        );

        jTabbedPanelNewProperties.addTab("Regex Replace Rules", jPanelRegexRule);

        jTextAreaNewProperties.setColumns(20);
        jTextAreaNewProperties.setRows(5);
        jScrollPane1.setViewportView(jTextAreaNewProperties);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 912, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 476, Short.MAX_VALUE)
        );

        jTabbedPanelNewProperties.addTab("New Properties", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTabbedPanelNewProperties, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPanelNewProperties, javax.swing.GroupLayout.DEFAULT_SIZE, 504, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        File outputFile = null;
        ObjectOutputStream objectOutputStream = null;
        OutputStream outputStream = null;
        try {
            fc = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Regex Configs", "rfrj");
            fc.setFileFilter(filter);
            int returnResult = fc.showSaveDialog(this);
            if (returnResult == JFileChooser.APPROVE_OPTION) {
                
                 outputFile = fc.getSelectedFile();      
                if(!outputFile.getName().endsWith(".rfrj")){
                    outputFile = new File(outputFile.getParentFile(), outputFile.getName()+".rfrj");
                }
                objectOutputStream = new ObjectOutputStream(new FileOutputStream(outputFile));
                objectOutputStream.writeObject(this.regexConfigs);

            } else {
                log("You have to select a output file!!\n");
                return;
            }
        } catch (Throwable t) {
            Logger.getLogger(MainJPanel.class.getName()).log(Level.INFO, "message", t);
        } finally {
            if (objectOutputStream != null) {
                try {
                    objectOutputStream.close();
                } catch (IOException ex) {
                    Logger.getLogger(MainJPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException ex) {
                    Logger.getLogger(MainJPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        File outputFile = null;
        ObjectInputStream objectInputStream = null;
        InputStream inputStream = null;
        try {
            fc = new JFileChooser();
              FileNameExtensionFilter filter = new FileNameExtensionFilter("Regex Configs", "rfrj");
            fc.setFileFilter(filter);
            int returnResult = fc.showOpenDialog(this);
            if (returnResult == JFileChooser.APPROVE_OPTION) {
                outputFile = fc.getSelectedFile();

                objectInputStream = new ObjectInputStream(new FileInputStream(outputFile));
                this.regexConfigs = (List) objectInputStream.readObject();

                jTableRegex.updateUI();
            } else {
                log("You have to select a input file!!\n");
                return;
            }
        } catch (Throwable t) {
            Logger.getLogger(MainJPanel.class.getName()).log(Level.INFO, "message", t);
        } finally {
            if (objectInputStream != null) {
                try {
                    objectInputStream.close();
                } catch (IOException ex) {
                    Logger.getLogger(MainJPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException ex) {
                    Logger.getLogger(MainJPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButtonAddRegexActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddRegexActionPerformed
        try {
            this.regexConfigs.add(new RegexConfig(jTextFieldRegex.getText(), Integer.parseInt(jTextFieldExtractGroup.getText()), jTextFieldDescription.getText()));
            jTableRegex.updateUI();
        } catch (Throwable t) {
            Logger.getLogger(MainJPanel.class.getName()).log(Level.SEVERE, "Error creating :" + t.getLocalizedMessage(), t);
        }
    }//GEN-LAST:event_jButtonAddRegexActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
        int returnResult = fc.showOpenDialog(this);
        if (returnResult == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            jTextFieldBundleFile.setText(file.getAbsolutePath());
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButtonExtractActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExtractActionPerformed
        try {
            jTextAreaProps.setText("");
            jTextAreaNewProperties.setText("");
            jTabbedPanelNewProperties.setSelectedComponent(jPanelLog);
            File workDir = new File(jTextFieldWorkFolder.getText());
            if (!workDir.exists()) {
                log("Invalid work folder\n");
                return;
            }

            Properties properties = new Properties();
            File bundleFile = new File(jTextFieldBundleFile.getText());
            if (!bundleFile.exists()) {
                log("Invalid bundle File\n");
                return;
            }
            FileReader fileReader = new FileReader(bundleFile);
            properties.load(fileReader);
            fileReader.close();

            Charset charset = Charset.forName(jTextFieldFileEnconding.getText());
            Set<String> resultMatch = new TreeSet<String>();
            List<MatchFound> referenceFinder = new ArrayList<MatchFound>();
            for (RegexConfig regexConfig : getRegexConfigs()) {
                referenceFinder.addAll(referenceFinder(workDir, jTextFieldFileRegex.getText(), regexConfig, charset));

            }
            int i = workDir.getAbsolutePath().length() + 1;

            Collections.sort(referenceFinder);
            jTextAreaProps.setText("Full List\n");
            jTextAreaProps.append("Full Path");
            jTextAreaProps.append("\t");
            jTextAreaProps.append("Relative Path");
            jTextAreaProps.append("\t");
            jTextAreaProps.append("File Name");
            jTextAreaProps.append("\t");
            jTextAreaProps.append("Regex");
            jTextAreaProps.append("\t");
            jTextAreaProps.append("Matched");
            jTextAreaProps.append("\t");
            jTextAreaProps.append("Line");
            jTextAreaProps.append("\n");
            for (MatchFound m : referenceFinder) {
                String relativePath = m.getFile().getAbsolutePath().substring(i);
                resultMatch.add(m.matched);
                jTextAreaProps.append(m.getFile().toString());
                jTextAreaProps.append("\t");
                jTextAreaProps.append(relativePath);
                jTextAreaProps.append("\t");
                jTextAreaProps.append(m.getFile().getName());
                jTextAreaProps.append("\t");
                jTextAreaProps.append(m.regexConfig.getDescription());
                jTextAreaProps.append("\t");
                jTextAreaProps.append(m.getMatched());
                jTextAreaProps.append("\t");
                jTextAreaProps.append(String.valueOf(m.getLine()));
                jTextAreaProps.append("\n");
            }
            jTextAreaProps.append("\n"
                    + "############################# Agreg ############################################\n");
            jTextAreaProps.append("Full Path");
            jTextAreaProps.append("\t");
            jTextAreaProps.append("Relative Path");
            jTextAreaProps.append("\t");
            jTextAreaProps.append("File Name");
            jTextAreaProps.append("\t");
            jTextAreaProps.append("Regex");
            jTextAreaProps.append("\t");
            jTextAreaProps.append("count");
            jTextAreaProps.append("\n");
            File last = null;
            RegexConfig lastRegexConfig = null;
            int count = 0;


            for (MatchFound m : referenceFinder) {
                if (last == null) {
                    last = m.getFile();
                    lastRegexConfig = m.regexConfig;
                    count = 1;
                } else if (last.equals(m.getFile()) && lastRegexConfig.equals(m.regexConfig)) {
                    count++;
                } else {
                    String relativePath = last.getAbsolutePath().substring(i);
                    jTextAreaProps.append(last.toString());
                    jTextAreaProps.append("\t");
                    jTextAreaProps.append(relativePath);
                    jTextAreaProps.append("\t");
                    jTextAreaProps.append(last.getName());
                    jTextAreaProps.append("\t");
                    jTextAreaProps.append(lastRegexConfig.getDescription());
                    jTextAreaProps.append("\t");
                    jTextAreaProps.append(String.valueOf(count));
                    jTextAreaProps.append("\n");
                    last = m.getFile();
                    lastRegexConfig = m.regexConfig;
                    count = 1;
                }
            }
            if (last != null) {
                String relativePath = last.getAbsolutePath().substring(i);
                jTextAreaProps.append(last.toString());
                jTextAreaProps.append("\t");
                jTextAreaProps.append(relativePath);
                jTextAreaProps.append("\t");
                jTextAreaProps.append(last.getName());
                jTextAreaProps.append("\t");
                jTextAreaProps.append(lastRegexConfig.getDescription());
                jTextAreaProps.append("\t");
                jTextAreaProps.append(String.valueOf(count));
                jTextAreaProps.append("\n");
            }

            jTextAreaProps.repaint();
            for (String string : resultMatch) {
                if (!properties.containsKey(string)) {
                    jTextAreaNewProperties.append(string);
                    jTextAreaNewProperties.append("=");
                    int t = string.lastIndexOf("_");
                    if (t > 0) {
                        jTextAreaNewProperties.append(string.substring(t));
                    } else {
                        jTextAreaNewProperties.append(string);
                    }
                    jTextAreaNewProperties.append("\n");
                }
            }
            jTextAreaNewProperties.repaint();

        } catch (Throwable t) {
            Logger.getLogger(MainJPanel.class.getName()).log(Level.SEVERE, "Error opening Initial Properties File", t);
            return;
        }
    }//GEN-LAST:event_jButtonExtractActionPerformed

    private void jButtonWorkFolderActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonWorkFolderActionPerformed
        fc = new JFileChooser();
        fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int returnResult = fc.showOpenDialog(this);
        if (returnResult == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            jTextFieldWorkFolder.setText(file.getAbsolutePath());
        }
    }//GEN-LAST:event_jButtonWorkFolderActionPerformed

    private void jButtonLoadConfigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLoadConfigActionPerformed
        File outputFile = null;
        ObjectInputStream objectInputStream = null;
        InputStream inputStream = null;
        try {
            fc = new JFileChooser();
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Config", "rfconf");
            fc.setFileFilter(filter);
            int returnResult = fc.showOpenDialog(this);
            if (returnResult == JFileChooser.APPROVE_OPTION) {
                outputFile = fc.getSelectedFile();

                objectInputStream = new ObjectInputStream(new FileInputStream(outputFile));
                Configuration configuration = (Configuration) objectInputStream.readObject();
                jTextFieldFileRegex.setText(configuration.getFileRegex());
                jTextFieldWorkFolder.setText(configuration.getWorkFolder());
                jTextFieldBundleFile.setText(configuration.getBundleFile());
                jTextFieldFileEnconding.setText(configuration.getEncoding());
                this.regexConfigs = configuration.getRegexConfigs();

                jTableRegex.updateUI();
            } else {
                log("You have to select a input file!!\n");
                return;
            }
        } catch (Throwable t) {
            Logger.getLogger(MainJPanel.class.getName()).log(Level.INFO, "message", t);
        } finally {
            if (objectInputStream != null) {
                try {
                    objectInputStream.close();
                } catch (IOException ex) {
                    Logger.getLogger(MainJPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException ex) {
                    Logger.getLogger(MainJPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_jButtonLoadConfigActionPerformed

    private void jButtonSaveConfigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSaveConfigActionPerformed
        File outputFile = null;
        ObjectOutputStream objectOutputStream = null;
        OutputStream outputStream = null;
        try {
            fc = new JFileChooser();
            
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Config", "rfconf");
            fc.setFileFilter(filter);
            int returnResult = fc.showSaveDialog(this);
            if (returnResult == JFileChooser.APPROVE_OPTION) {
                outputFile = fc.getSelectedFile();      
                if(!outputFile.getName().endsWith(".rfconf")){
                    outputFile = new File(outputFile.getParentFile(), outputFile.getName()+".rfconf");
                }
                Configuration configuration = new Configuration();
                configuration.setFileRegex(jTextFieldFileRegex.getText());
                configuration.setWorkFolder(jTextFieldWorkFolder.getText());
                configuration.setBundleFile(jTextFieldBundleFile.getText());
                configuration.setEncoding(jTextFieldFileEnconding.getText());
                configuration.setRegexConfigs(this.regexConfigs);
                objectOutputStream = new ObjectOutputStream(new FileOutputStream(outputFile));
                objectOutputStream.writeObject(configuration);

            } else {
                log("You have to select a output file!!\n");
                return;
            }
        } catch (Throwable t) {
            Logger.getLogger(MainJPanel.class.getName()).log(Level.INFO, "message", t);
        } finally {
            if (objectOutputStream != null) {
                try {
                    objectOutputStream.close();
                } catch (IOException ex) {
                    Logger.getLogger(MainJPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException ex) {
                    Logger.getLogger(MainJPanel.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_jButtonSaveConfigActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButtonAddRegex;
    private javax.swing.JButton jButtonExtract;
    private javax.swing.JButton jButtonLoadConfig;
    private javax.swing.JButton jButtonSaveConfig;
    private javax.swing.JButton jButtonWorkFolder;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelDescription;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanelLog;
    private javax.swing.JPanel jPanelProperties;
    private javax.swing.JPanel jPanelRegexRule;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPanelNewProperties;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTableRegex;
    private javax.swing.JTextArea jTextAreaLog;
    private javax.swing.JTextArea jTextAreaNewProperties;
    private javax.swing.JTextArea jTextAreaProps;
    private javax.swing.JTextField jTextFieldBundleFile;
    private javax.swing.JTextField jTextFieldDescription;
    private javax.swing.JTextField jTextFieldExtractGroup;
    private javax.swing.JTextField jTextFieldFileEnconding;
    private javax.swing.JTextField jTextFieldFileRegex;
    private javax.swing.JTextField jTextFieldRegex;
    private javax.swing.JTextField jTextFieldWorkFolder;
    // End of variables declaration//GEN-END:variables
}
