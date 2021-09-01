/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;

/**
 *
 * @author Ferfar Imad Eddine
 */
public class GestionImage {
    
    // Ajuster une image selon des dimensions spécifiées
    public static Image ajusterImage(Image image,  int largeur, int hauteur) {

        BufferedImage imageRedimensionnee = new BufferedImage(largeur, hauteur, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = (Graphics2D) imageRedimensionnee.getGraphics();
        g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g.drawImage(image, 0, 0, largeur, hauteur, null);
        g.dispose();
        return imageRedimensionnee;
    }
    
}
