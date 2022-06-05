/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle.bittrafego;

import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author Matheus
 */
public class Sons implements Runnable {

    @Override
    public void run() {

        Clip Clip = null; //Cria uma variável Clip.
        AudioInputStream St = null; //Cria uma variável AudioInputStream.

        try { //Executa o som principal em modo loop (repetição).
            Clip = AudioSystem.getClip();
            St = AudioSystem.getAudioInputStream(getClass().getResource("/resources/Som Principal.wav"));
            Clip.open(St);
            Clip.loop(Clip.LOOP_CONTINUOUSLY);
        } catch (LineUnavailableException | UnsupportedAudioFileException | IOException ex) {
            Logger.getLogger(Sons.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void roda() { //Quando é invocada, essa função toca de forma aleatória um dos 3 sons de buzina.
        int rdn;
        Random gerador = new Random();
        rdn = gerador.nextInt(3);
        Clip Clip = null;
        AudioInputStream St = null;
        if (rdn == 0) { //Executa o primeiro som.
            try {
                Clip = AudioSystem.getClip();
                St = AudioSystem.getAudioInputStream(getClass().getResource("/resources/Buzina 1.wav"));
                Clip.open(St);
                Clip.loop(0);
            } catch (LineUnavailableException | UnsupportedAudioFileException | IOException ex) {
                Logger.getLogger(Sons.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (rdn == 1) { //Executa o primeiro som.
            try {
                Clip = AudioSystem.getClip();
                St = AudioSystem.getAudioInputStream(getClass().getResource("/resources/Buzina 2.wav"));
                Clip.open(St);
                Clip.loop(0);
            } catch (LineUnavailableException | UnsupportedAudioFileException | IOException ex) {
                Logger.getLogger(Sons.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (rdn == 2) { //Executa o primeiro som.
            try {
                Clip = AudioSystem.getClip();
                St = AudioSystem.getAudioInputStream(getClass().getResource("/resources/Buzina 3.wav"));
                Clip.open(St);
                Clip.loop(0);
            } catch (LineUnavailableException | UnsupportedAudioFileException | IOException ex) {
                Logger.getLogger(Sons.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            Thread.sleep(500); //Executa um pequeno delay na função.
        } catch (InterruptedException ex) {
            Logger.getLogger(Sons.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
