
package MultiClass;

import ModelClassifier.ModelClassifier;
import ModelClassifier.ModelGenerator;
import MultiClass.Main;

import java.awt.Color;
import java.awt.Image;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.*;
import javax.swing.ImageIcon;

import weka.core.Debug;
import weka.core.Instances;
import weka.core.SelectedTag;
import weka.core.stemmers.LovinsStemmer;
import weka.core.stemmers.Stemmer;
import weka.core.stopwords.WordsFromFile;
import weka.core.tokenizers.NGramTokenizer;
import weka.filters.Filter;
import weka.filters.unsupervised.attribute.StringToWordVector;

/**
 * This is a classifier for wikihow dataset  
 * @author Daria Maggi and Marsha Gomez 
 * Data Mining and Machine Learning University of Pisa
 * Github link: https://github.com/dariamaggi/parser
 */
public class CreateArticle extends javax.swing.JFrame {

    /**
     * Creates new form CreateArticle
     */
    private ImageIcon image1;
    private String DATASETPATH = "D:\\GitHub\\parser\\data\\cleaned\\AllCategories.arff";
    private String STOPWORDSPATH = "D:\\GitHub\\parser\\JavaApp\\MultiClass\\src\\data\\stopwords.txt";
    private String MODELPATH = "D:\\GitHub\\parser\\JavaApp\\MultiClass\\src\\data\\";
    private DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

    
    public CreateArticle() {
        initComponents();
        jPanel1.setBackground(Color.WHITE);
        //jPanel2.setBackground(Color.BLACK);

        
        image1 = new ImageIcon(getClass().getResource("..\\img\\header_logo.png"));
        
        Image image = image1.getImage(); // transform it 
        Image newimg = image.getScaledInstance(150, 70,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        image1 = new ImageIcon(newimg);  // transform it back
        jLabel1.setIcon(image1);
        
        jButton2.setBackground(Color.WHITE);
        jComboBoxCategory2.setBackground(Color.WHITE);
        Back1.setBackground(Color.WHITE);
        

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabelFormTitle1 = new javax.swing.JLabel();
        jLabelTitle1 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabelSummary1 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea4 = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextArea5 = new javax.swing.JTextArea();
        jLabelText1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jComboBoxCategory2 = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();
        jScrollPane6 = new javax.swing.JScrollPane();
        jTextArea6 = new javax.swing.JTextArea();
        Back1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelFormTitle1.setFont(new java.awt.Font("Microsoft JhengHei", 0, 18)); // NOI18N
        jLabelFormTitle1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelFormTitle1.setText("Create Article");

        jLabelTitle1.setFont(new java.awt.Font("Microsoft JhengHei", 0, 14)); // NOI18N
        jLabelTitle1.setText("Title");

        jTextField2.setFont(new java.awt.Font("Microsoft JhengHei", 0, 14)); // NOI18N
        jTextField2.setToolTipText("");
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jLabelSummary1.setFont(new java.awt.Font("Microsoft JhengHei", 0, 14)); // NOI18N
        jLabelSummary1.setText("Summary");

        jTextArea4.setColumns(20);
        jTextArea4.setFont(new java.awt.Font("Microsoft JhengHei", 0, 14)); // NOI18N
        jTextArea4.setRows(5);
        jScrollPane3.setViewportView(jTextArea4);

        jTextArea5.setColumns(20);
        jTextArea5.setFont(new java.awt.Font("Microsoft JhengHei", 0, 14)); // NOI18N
        jTextArea5.setRows(5);
        jScrollPane5.setViewportView(jTextArea5);

        jLabelText1.setFont(new java.awt.Font("Microsoft JhengHei", 0, 14)); // NOI18N
        jLabelText1.setText("Text");

        jLabel2.setFont(new java.awt.Font("Microsoft JhengHei", 0, 14)); // NOI18N
        jLabel2.setText("Classifier");

        jComboBoxCategory2.setFont(new java.awt.Font("Microsoft JhengHei", 0, 14)); // NOI18N
        jComboBoxCategory2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SMO", "RANDOMFOREST", "J48", "NAIVEBAYES" }));
        jComboBoxCategory2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxCategory2ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(120, 153, 71));
        jButton2.setFont(new java.awt.Font("Microsoft JhengHei", 0, 14)); // NOI18N
        jButton2.setLabel("Predict");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTextArea6.setColumns(20);
        jTextArea6.setRows(5);
        jScrollPane6.setViewportView(jTextArea6);

        Back1.setBackground(new java.awt.Color(120, 153, 71));
        Back1.setFont(new java.awt.Font("Microsoft JhengHei", 0, 14)); // NOI18N
        Back1.setText("< Back");
        Back1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Back1ActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Microsoft YaHei", 0, 30)); // NOI18N
        jLabel1.setText("Automatic Classifier");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane6)
                                .addGap(32, 32, 32))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 724, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 36, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabelText1)
                                        .addGap(71, 71, 71)
                                        .addComponent(jScrollPane5))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabelSummary1)
                                            .addComponent(jLabelTitle1))
                                        .addGap(36, 36, 36)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jScrollPane3)
                                            .addComponent(jTextField2)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(40, 40, 40)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jComboBoxCategory2, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jButton2))
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addContainerGap())
                            .addComponent(jLabelFormTitle1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(Back1)
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addComponent(jSeparator1)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jSeparator2, javax.swing.GroupLayout.DEFAULT_SIZE, 760, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(jLabelFormTitle1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTitle1)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jLabelSummary1)))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelText1))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jComboBoxCategory2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addComponent(jButton2)
                .addGap(38, 38, 38)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(Back1)
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(59, 59, 59)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(846, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jComboBoxCategory2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxCategory2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxCategory2ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        int minTermFreq = 2;
        boolean useStemmer = false;

        boolean useIdf = true;
        int maxGrams = 2;
        int minGrams = 2;
        
        ModelGenerator mg = new ModelGenerator();
        String pattern = "\\W";
        String pattern1 = "\\s+";
        String pattern2 = "^\\s+";
        String pattern3 = "\\s+$";
        String message = "";
        
        String TITLE = jTextField2.getText().toLowerCase();
        
        TITLE = TITLE.replaceAll(pattern, " ");
        TITLE = TITLE.replaceAll(pattern1, " ");
        TITLE = TITLE.replaceAll(pattern2, " ");
        TITLE = TITLE.replaceAll(pattern3, " ");
        
        
        String SUMMARY = jTextArea4.getText().toLowerCase();
        
        SUMMARY = SUMMARY.replaceAll(pattern, " ");
        SUMMARY = SUMMARY.replaceAll(pattern1, " ");
        SUMMARY = SUMMARY.replaceAll(pattern2, " ");
        SUMMARY = SUMMARY.replaceAll(pattern3, " ");
        
        String TEXT = jTextArea5.getText().toLowerCase();
        
        TEXT = TEXT.replaceAll(pattern, " ");
        TEXT = TEXT.replaceAll(pattern1, " ");
        TEXT = TEXT.replaceAll(pattern2, " ");
        TEXT = TEXT.replaceAll(pattern3, " ");

        Date date = new Date();
        message = message + "\n -- PROCESS INIT "+ dateFormat.format(date);

        try {
            Instances dataset = mg.loadDataset(DATASETPATH);
        
            // -- Filter filter = new Normalize();
            StringToWordVector filter = new StringToWordVector();
            filter.setWordsToKeep(1000000);

            // divide dataset to train dataset 80% and test dataset 20%
            int trainSize = (int) Math.round(dataset.numInstances() * 0.8);
            int testSize = dataset.numInstances() - trainSize;

            dataset.randomize(new Debug.Random(1));// if you comment this line the accuracy of the model will be droped from 96.6% to 80%

            message = message + "\n ---- SET CONFIGURATION ---- ";

            if(useIdf){
                filter.setIDFTransform(true);
            }
            filter.setTFTransform(true);
            filter.setLowerCaseTokens(true);
            filter.setOutputWordCounts(true);
            filter.setMinTermFreq(minTermFreq);
            filter.setNormalizeDocLength(new SelectedTag(StringToWordVector.FILTER_NORMALIZE_ALL,StringToWordVector.TAGS_FILTER));
            NGramTokenizer t = new NGramTokenizer();
            t.setNGramMaxSize(maxGrams);
            t.setNGramMinSize(minGrams);    
            filter.setTokenizer(t); 

            // Use Stemmer
            if (useStemmer){
                WordsFromFile stopwords = new WordsFromFile();
                stopwords.setStopwords(new File(STOPWORDSPATH));
                filter.setStopwordsHandler(stopwords);
                
                Stemmer s = new /*Iterated*/LovinsStemmer();
                filter.setStemmer(s);
            }
            
            //Normalize dataset
            filter.setInputFormat(dataset);

            Instances datasetnor = Filter.useFilter(dataset, filter);
            // Instances dataFilter = Filter.useFilter(data, filter);

            Instances traindataset = new Instances(datasetnor, 0, trainSize);
            Instances testdataset = new Instances(datasetnor, trainSize, testSize);


            ModelClassifier cls = new ModelClassifier();
            String option = jComboBoxCategory2.getSelectedItem().toString();
            
            String path = "";
            path = MODELPATH+option+".bin";
            
            message = message + "\n ---- CALCULATION RESULT ---- ";

            String classname = cls.classifiy(Filter.useFilter(cls.createInstance(TITLE, SUMMARY, TEXT),filter), path);
            message = message + "\n ------------------------------------------------------------------------ \n";
            message = message + "\n \n \n The class name for the instance WikiHow Classification is: \n \n \n";
            message = message + classname.toUpperCase();
            message = message + "\n ------------------------------------------------------------------------ \n";
            
            date = new Date();
            message = message + "\n -- PROCESS END "+ dateFormat.format(date);

        } catch (Exception e) {
            System.err.println("\n The class name for the instance TEST is: " + e);
            message = message + e;
            date = new Date();
            message = message + "\n -- PROCESS END WITH ERRORS "+ dateFormat.format(date);
        }
        
        jTextArea6.setText(message);
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void Back1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Back1ActionPerformed
        new Main().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_Back1ActionPerformed

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
            java.util.logging.Logger.getLogger(CreateArticle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CreateArticle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CreateArticle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateArticle.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CreateArticle().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox<String> jComboBoxCategory2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelFormTitle1;
    private javax.swing.JLabel jLabelSummary1;
    private javax.swing.JLabel jLabelText1;
    private javax.swing.JLabel jLabelTitle1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextArea jTextArea4;
    private javax.swing.JTextArea jTextArea5;
    private javax.swing.JTextArea jTextArea6;
    private javax.swing.JTextField jTextField2;
    // End of variables declaration//GEN-END:variables
}
