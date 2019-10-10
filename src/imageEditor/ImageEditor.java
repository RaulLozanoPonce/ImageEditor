package imageEditor;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.highgui.HighGui;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

public class ImageEditor extends javax.swing.JFrame {
    
    static{
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    }
    
    private JFileChooser fc;
    private int threshold;
    private Mat originalImage;
    
    public ImageEditor() {
        initComponents();
        threshold = 100;
        thresholdLabel.setText(Integer.toString(threshold));
        setMnemonic();
        setFileFilter();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        originalImageBoard = new imageEditor.Board();
        titleLabel = new javax.swing.JLabel();
        thresholdImageBoard = new imageEditor.Board();
        currentThresholdLabel = new javax.swing.JLabel();
        thresholdLabel = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        loadImageItem = new javax.swing.JMenuItem();
        saveImageItem = new javax.swing.JMenuItem();
        exitItem = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        setThresholdItem = new javax.swing.JMenuItem();
        helpMenu = new javax.swing.JMenu();
        aboutItem = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        originalImageBoard.setBorder(javax.swing.BorderFactory.createTitledBorder("Imagen Original"));

        javax.swing.GroupLayout originalImageBoardLayout = new javax.swing.GroupLayout(originalImageBoard);
        originalImageBoard.setLayout(originalImageBoardLayout);
        originalImageBoardLayout.setHorizontalGroup(
            originalImageBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 628, Short.MAX_VALUE)
        );
        originalImageBoardLayout.setVerticalGroup(
            originalImageBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 457, Short.MAX_VALUE)
        );

        titleLabel.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("UMBRALIZADO DE IMÁGENES - IMAGE EDITOR");

        thresholdImageBoard.setBorder(javax.swing.BorderFactory.createTitledBorder("Imagen Umbralizada"));

        javax.swing.GroupLayout thresholdImageBoardLayout = new javax.swing.GroupLayout(thresholdImageBoard);
        thresholdImageBoard.setLayout(thresholdImageBoardLayout);
        thresholdImageBoardLayout.setHorizontalGroup(
            thresholdImageBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 628, Short.MAX_VALUE)
        );
        thresholdImageBoardLayout.setVerticalGroup(
            thresholdImageBoardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 457, Short.MAX_VALUE)
        );

        currentThresholdLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        currentThresholdLabel.setText("Umbral actual:");

        thresholdLabel.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        thresholdLabel.setText("umbral");

        fileMenu.setText("Archivo");

        loadImageItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        loadImageItem.setText("Cargar Imagen");
        loadImageItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loadImageItemActionPerformed(evt);
            }
        });
        fileMenu.add(loadImageItem);

        saveImageItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, java.awt.event.InputEvent.CTRL_MASK));
        saveImageItem.setText("Guardar Imagen");
        saveImageItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveImageItemActionPerformed(evt);
            }
        });
        fileMenu.add(saveImageItem);

        exitItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        exitItem.setText("Salir");
        exitItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitItem);

        jMenuBar1.add(fileMenu);

        editMenu.setText("Editar");

        setThresholdItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_U, java.awt.event.InputEvent.CTRL_MASK));
        setThresholdItem.setText("Ajustar Umbral");
        setThresholdItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                setThresholdItemActionPerformed(evt);
            }
        });
        editMenu.add(setThresholdItem);

        jMenuBar1.add(editMenu);

        helpMenu.setText("Ayuda");

        aboutItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, java.awt.event.InputEvent.CTRL_MASK));
        aboutItem.setText("Acerca De");
        aboutItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutItemActionPerformed(evt);
            }
        });
        helpMenu.add(aboutItem);

        jMenuBar1.add(helpMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titleLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(originalImageBoard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(thresholdImageBoard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(currentThresholdLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(thresholdLabel)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titleLabel)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(originalImageBoard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(thresholdImageBoard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(currentThresholdLabel)
                    .addComponent(thresholdLabel))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loadImageItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loadImageItemActionPerformed
        if(fc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
            File file = fc.getSelectedFile();
            if(!originalImageBoard.loadImage(file.getAbsolutePath(), getImageFormat(file.getAbsolutePath()))){
                JOptionPane.showMessageDialog(null, "No se ha podido cargar la imagen.", 
                        "Error al cargar la imagen", JOptionPane.ERROR_MESSAGE);
            }else{
                originalImage = Imgcodecs.imread(file.getAbsolutePath());
                thresholdImageBoard.setImage((BufferedImage) HighGui.toBufferedImage(toThreshold(originalImage, threshold)));
            }
            repaint();
        }
    }//GEN-LAST:event_loadImageItemActionPerformed

    private void exitItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitItemActionPerformed
        if(closeWindow()) System.exit(0);
    }//GEN-LAST:event_exitItemActionPerformed

    private void saveImageItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveImageItemActionPerformed
        if(fc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION){
            File file = fc.getSelectedFile();
            if(!thresholdImageBoard.saveImage(file, getImageFormat(file.getName()))){
                JOptionPane.showMessageDialog(null, "No se ha podido guardar la imagen.", 
                        "Error al guardar la imagen", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_saveImageItemActionPerformed

    private void setThresholdItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_setThresholdItemActionPerformed
        threshold = Math.max(0, Math.min(255,Integer.parseInt(
                JOptionPane.showInputDialog(null, "Introducir Umbral [0-255]"))));
        thresholdLabel.setText(Integer.toString(threshold));
        if(originalImage != null){
            try{
                thresholdImageBoard.setImage((BufferedImage) HighGui.toBufferedImage(toThreshold(originalImage, threshold)));
                repaint();
            }catch(NumberFormatException e){}
        }
    }//GEN-LAST:event_setThresholdItemActionPerformed

    private void aboutItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutItemActionPerformed
        JOptionPane.showMessageDialog(null, "Práctica realizada por:\nRaúl Lozano Ponce\nPablo Perdomo Falcón", "Acerca De", JOptionPane.PLAIN_MESSAGE);
    }//GEN-LAST:event_aboutItemActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if(closeWindow()) System.exit(0);
    }//GEN-LAST:event_formWindowClosing
    
    private Mat toThreshold(Mat originalImage, int threshold){
        Mat grayImage = new Mat(originalImage.rows(),originalImage.cols(),CvType.CV_8U);
        Mat thresholdImage = new Mat(originalImage.rows(),originalImage.cols(),CvType.CV_8U);
        Imgproc.cvtColor(originalImage,grayImage,Imgproc.COLOR_BGR2GRAY);
        Imgproc.threshold(grayImage,thresholdImage,threshold,255,Imgproc.THRESH_BINARY);
        return thresholdImage;
    }
    
    private void setFileFilter() {
        fc = new JFileChooser();
        fc.setAcceptAllFileFilterUsed(false);
        FileNameExtensionFilter filter = null;
        filter = new FileNameExtensionFilter("Todos los formatos (BMP,GIF,JPEG,"
                + "PNG,TIFF)", "bmp", "gif", "jpeg", "jpg", "png", "tiff", "tif");
        fc.addChoosableFileFilter(filter);
        filter = new FileNameExtensionFilter("Imágenes BMP", "bmp");
        fc.addChoosableFileFilter(filter);
        filter = new FileNameExtensionFilter("Imágenes GIF", "gif");
        fc.addChoosableFileFilter(filter);
        filter = new FileNameExtensionFilter("Imágenes JPEG", "jpeg", "jpg");
        fc.addChoosableFileFilter(filter);
        filter = new FileNameExtensionFilter("Imágenes PNG", "png");
        fc.addChoosableFileFilter(filter);
        filter = new FileNameExtensionFilter("Imágenes TIFF", "tiff", "tif");
        fc.addChoosableFileFilter(filter);
    }

    private String getImageFormat(String name) {
        for (int i = 0; i < name.length(); i++) {
            if(name.charAt(i) == '.') return name.substring(i+1);
        }
        return "";
    }
    
    private boolean closeWindow(){
        return (JOptionPane.showConfirmDialog(null, "¿Desea salir de Image Editor?", 
                "Salir", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION);
    }
    
    private void setMnemonic() {
        fileMenu.setMnemonic('F');
        editMenu.setMnemonic('E');
        helpMenu.setMnemonic('H');
        loadImageItem.setMnemonic('L');
        saveImageItem.setMnemonic('S');
        exitItem.setMnemonic('X');
        setThresholdItem.setMnemonic('T');
        aboutItem.setMnemonic('A');
    }
    
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ImageEditor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(() -> { new ImageEditor().setVisible(true); });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutItem;
    private javax.swing.JLabel currentThresholdLabel;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenuItem exitItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem loadImageItem;
    private imageEditor.Board originalImageBoard;
    private javax.swing.JMenuItem saveImageItem;
    private javax.swing.JMenuItem setThresholdItem;
    private imageEditor.Board thresholdImageBoard;
    private javax.swing.JLabel thresholdLabel;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
