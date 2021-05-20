/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pizzeriadechela.componentes;

import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.ImageIcon;
import java.awt.Image;
import java.net.URL;
import javax.imageio.ImageIO;

/**
 *
 * @author Anaiza
 */
public class Imagen extends javax.swing.JPanel {
    
    private String _imageUrl;

    public String getImageUrl() {
        return _imageUrl;
    }

    public void setImageUrl(String _imageUrl) {
        this._imageUrl = _imageUrl;
    }
    
    public Imagen(int width, int height) {
        this.setSize(width, height); //se selecciona el tamaño del panel
    }
    
    public Image loadImage(){
        try{
            URL url = new URL(this.getImageUrl());
            Image image = ImageIO.read(url);
            return image;
        }catch (Exception e){
            return null;
        }
    }
    
    public void paint(Graphics grap){
        Dimension height = getSize();
        
        ImageIcon Img = new ImageIcon(loadImage());
        grap.drawImage(Img.getImage(), 0, 0, height.width, height.height, null);
        
        setOpaque(false);
        super.paintComponent(grap);
    }
}
