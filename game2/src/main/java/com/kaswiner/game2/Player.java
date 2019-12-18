/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game2;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;

/**
 *
 * @author Franklin
 */
public final class Player implements Renderable {
    
    private int posX;
    private int posY;
    private int velX;
    private int velY;
    private BufferedImage imagePlayerSheet;
    private BufferedImage imagePlayerParadoBaixo;
    private BufferedImage imagePlayerParadoCima;
    private BufferedImage imagePlayerParadoEsquerda;
    private BufferedImage imagePlayerParadoDireita;
    private List<BufferedImage> imagesPlayerAndandoCima;
    private List<BufferedImage> imagesPlayerAndandoBaixo;
    private List<BufferedImage> imagesPlayerAndandoEsquerda;
    private List<BufferedImage> imagesPlayerAndandoDireita;
    private int ultimoSprite = 0;
    
    public Player(int posX, int posY) {
        this.setPosX(posX);
        this.setPosY(posY);
        
        try {
            this.imagePlayerSheet = ImageIO.read(new File("img/npc_woman03_walk.png"));
            int imageWidth = this.imagePlayerSheet.getWidth() / 6;
            int imageHeight = this.imagePlayerSheet.getHeight() / 4;
            
            this.imagePlayerParadoBaixo = this.imagePlayerSheet.getSubimage(0*imageWidth, 0*imageHeight, imageWidth, imageHeight);
            this.imagePlayerParadoCima = this.imagePlayerSheet.getSubimage(0*imageWidth, 1*imageHeight, imageWidth, imageHeight);
            this.imagePlayerParadoEsquerda = this.imagePlayerSheet.getSubimage(0*imageWidth, 2*imageHeight, imageWidth, imageHeight);
            this.imagePlayerParadoDireita = this.imagePlayerSheet.getSubimage(0*imageWidth, 3*imageHeight, imageWidth, imageHeight);

            this.imagesPlayerAndandoCima = new ArrayList<>();
            this.imagesPlayerAndandoBaixo = new ArrayList<>();
            this.imagesPlayerAndandoEsquerda = new ArrayList<>();
            this.imagesPlayerAndandoDireita = new ArrayList<>();
            
            
            this.imagesPlayerAndandoBaixo.add(this.imagePlayerSheet.getSubimage(1*imageWidth, 0*imageHeight, imageWidth, imageHeight));
            this.imagesPlayerAndandoBaixo.add(this.imagePlayerSheet.getSubimage(2*imageWidth, 0*imageHeight, imageWidth, imageHeight));
            this.imagesPlayerAndandoBaixo.add(this.imagePlayerSheet.getSubimage(3*imageWidth, 0*imageHeight, imageWidth, imageHeight));
            this.imagesPlayerAndandoBaixo.add(this.imagePlayerSheet.getSubimage(4*imageWidth, 0*imageHeight, imageWidth, imageHeight));
            this.imagesPlayerAndandoBaixo.add(this.imagePlayerSheet.getSubimage(5*imageWidth, 0*imageHeight, imageWidth, imageHeight));

            this.imagesPlayerAndandoCima.add(this.imagePlayerSheet.getSubimage(1*imageWidth, 1*imageHeight, imageWidth, imageHeight));
            this.imagesPlayerAndandoCima.add(this.imagePlayerSheet.getSubimage(2*imageWidth, 1*imageHeight, imageWidth, imageHeight));
            this.imagesPlayerAndandoCima.add(this.imagePlayerSheet.getSubimage(3*imageWidth, 1*imageHeight, imageWidth, imageHeight));
            this.imagesPlayerAndandoCima.add(this.imagePlayerSheet.getSubimage(4*imageWidth, 1*imageHeight, imageWidth, imageHeight));
            this.imagesPlayerAndandoCima.add(this.imagePlayerSheet.getSubimage(5*imageWidth, 1*imageHeight, imageWidth, imageHeight));

            this.imagesPlayerAndandoEsquerda.add(this.imagePlayerSheet.getSubimage(1*imageWidth, 2*imageHeight, imageWidth, imageHeight));
            this.imagesPlayerAndandoEsquerda.add(this.imagePlayerSheet.getSubimage(2*imageWidth, 2*imageHeight, imageWidth, imageHeight));
            this.imagesPlayerAndandoEsquerda.add(this.imagePlayerSheet.getSubimage(3*imageWidth, 2*imageHeight, imageWidth, imageHeight));
            this.imagesPlayerAndandoEsquerda.add(this.imagePlayerSheet.getSubimage(4*imageWidth, 2*imageHeight, imageWidth, imageHeight));
            this.imagesPlayerAndandoEsquerda.add(this.imagePlayerSheet.getSubimage(5*imageWidth, 2*imageHeight, imageWidth, imageHeight));

            this.imagesPlayerAndandoDireita.add(this.imagePlayerSheet.getSubimage(1*imageWidth, 3*imageHeight, imageWidth, imageHeight));
            this.imagesPlayerAndandoDireita.add(this.imagePlayerSheet.getSubimage(2*imageWidth, 3*imageHeight, imageWidth, imageHeight));
            this.imagesPlayerAndandoDireita.add(this.imagePlayerSheet.getSubimage(3*imageWidth, 3*imageHeight, imageWidth, imageHeight));
            this.imagesPlayerAndandoDireita.add(this.imagePlayerSheet.getSubimage(4*imageWidth, 3*imageHeight, imageWidth, imageHeight));
            this.imagesPlayerAndandoDireita.add(this.imagePlayerSheet.getSubimage(5*imageWidth, 3*imageHeight, imageWidth, imageHeight));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public void tick() {
        this.setPosX(this.getPosX() + this.getVelX());
        this.setPosY(this.getPosY() + this.getVelY());
        
        //x = Game1.clamp(x, 0, Game1.WIDTH - 38);
        //y = Game1.clamp(y, 0, Game1.HEIGHT - 60);
        
        //this.collision();
    }

    //@Override
    public void render2(Graphics g) {
        long now = System.nanoTime();
        
        long c = now % 1000000000;
/*        
        if (c <= 250000000) {
            g.drawImage(imagePlayerParado1, 40, 40, null);
            
        } else if (c <= 500000000) {
            g.drawImage(imagePlayerParado2, 40, 40, null);

        } else if (c <= 750000000) {
            g.drawImage(imagePlayerParado3, 40, 40, null);
            
        } else if (c <= 1000000000) {
            g.drawImage(imagePlayerParado4, 40, 40, null);
            
        }
*/

/*
        
        if (c <= 200000000) {
            if (this.getVelX() > 0) {
                g.drawImage(this.imagePlayerAndandoDireita1, this.getPosX(), this.getPosY(), null);
            } else if (this.getVelX() < 0) {
                g.drawImage(this.imagePlayerAndandoEsquerda1, this.getPosX(), this.getPosY(), null);
            } else if (this.getVelY() > 0) {
                g.drawImage(this.imagePlayerAndandoBaixo1, this.getPosX(), this.getPosY(), null);
            } else if (this.getVelY() < 0) {
                g.drawImage(this.imagePlayerAndandoCima1, this.getPosX(), this.getPosY(), null);
            } else  if (this.getVelX() == 0) {
                g.drawImage(this.imagePlayerParadoBaixo, this.getPosX(), this.getPosY(), null);
            }
            
        } else if (c <= 400000000) {
            if (this.getVelX() > 0) {
                g.drawImage(this.imagePlayerAndandoDireita2, this.getPosX(), this.getPosY(), null);
            } else if (this.getVelX() < 0) {
                g.drawImage(this.imagePlayerAndandoEsquerda2, this.getPosX(), this.getPosY(), null);
            } else if (this.getVelY() > 0) {
                g.drawImage(this.imagePlayerAndandoBaixo2, this.getPosX(), this.getPosY(), null);
            } else if (this.getVelY() < 0) {
                g.drawImage(this.imagePlayerAndandoCima2, this.getPosX(), this.getPosY(), null);
            } else  if (this.getVelX() == 0) {
                g.drawImage(this.imagePlayerParadoBaixo, this.getPosX(), this.getPosY(), null);
            }

        } else if (c <= 600000000) {
            if (this.getVelX() > 0) {
                g.drawImage(this.imagePlayerAndandoDireita3, this.getPosX(), this.getPosY(), null);
            } else if (this.getVelX() < 0) {
                g.drawImage(this.imagePlayerAndandoEsquerda3, this.getPosX(), this.getPosY(), null);
            } else if (this.getVelY() > 0) {
                g.drawImage(this.imagePlayerAndandoBaixo3, this.getPosX(), this.getPosY(), null);
            } else if (this.getVelY() < 0) {
                g.drawImage(this.imagePlayerAndandoCima3, this.getPosX(), this.getPosY(), null);
            } else  if (this.getVelX() == 0) {
                g.drawImage(this.imagePlayerParadoBaixo, this.getPosX(), this.getPosY(), null);
            }
            
        } else if (c <= 800000000) {
            if (this.getVelX() > 0) {
                g.drawImage(this.imagePlayerAndandoDireita4, this.getPosX(), this.getPosY(), null);
            } else if (this.getVelX() < 0) {
                g.drawImage(this.imagePlayerAndandoEsquerda4, this.getPosX(), this.getPosY(), null);
            } else if (this.getVelY() > 0) {
                g.drawImage(this.imagePlayerAndandoBaixo4, this.getPosX(), this.getPosY(), null);
            } else if (this.getVelY() < 0) {
                g.drawImage(this.imagePlayerAndandoCima4, this.getPosX(), this.getPosY(), null);
            } else  if (this.getVelX() == 0) {
                g.drawImage(this.imagePlayerParadoBaixo, this.getPosX(), this.getPosY(), null);
            }
            
        } else if (c <= 1000000000) {
            if (this.getVelX() > 0) {
                g.drawImage(this.imagePlayerAndandoDireita5, this.getPosX(), this.getPosY(), null);
            } else if (this.getVelX() < 0) {
                g.drawImage(this.imagePlayerAndandoEsquerda5, this.getPosX(), this.getPosY(), null);
            } else if (this.getVelY() > 0) {
                g.drawImage(this.imagePlayerAndandoBaixo5, this.getPosX(), this.getPosY(), null);
            } else if (this.getVelY() < 0) {
                g.drawImage(this.imagePlayerAndandoCima5, this.getPosX(), this.getPosY(), null);
            } else  if (this.getVelX() == 0) {
                g.drawImage(this.imagePlayerParadoBaixo, this.getPosX(), this.getPosY(), null);
            }

        }


*/
    }

    public void render(Graphics g) {
        long now = System.nanoTime();
        long billion = 1000000000L;
        long c = now % billion;
        long intervalSprite = billion / 8; //this.imagesPlayerAndandoBaixo.size();
        
        if (c <= intervalSprite * 1) {
            int sprite = 0;
            
            if (this.getVelX() > 0) {
                g.drawImage(this.imagesPlayerAndandoDireita.get(sprite), this.getPosX(), this.getPosY(), null);
            } else if (this.getVelX() < 0) {
                g.drawImage(this.imagesPlayerAndandoEsquerda.get(sprite), this.getPosX(), this.getPosY(), null);
            } else if (this.getVelY() > 0) {
                g.drawImage(this.imagesPlayerAndandoBaixo.get(sprite), this.getPosX(), this.getPosY(), null);
            } else if (this.getVelY() < 0) {
                g.drawImage(this.imagesPlayerAndandoCima.get(sprite), this.getPosX(), this.getPosY(), null);
            } else  if (this.getVelX() == 0) {
                g.drawImage(this.imagePlayerParadoBaixo, this.getPosX(), this.getPosY(), null);
            }
            
        } else if (c <= intervalSprite * 2) {
            int sprite = 1;
            
            if (this.getVelX() > 0) {
                g.drawImage(this.imagesPlayerAndandoDireita.get(sprite), this.getPosX(), this.getPosY(), null);
            } else if (this.getVelX() < 0) {
                g.drawImage(this.imagesPlayerAndandoEsquerda.get(sprite), this.getPosX(), this.getPosY(), null);
            } else if (this.getVelY() > 0) {
                g.drawImage(this.imagesPlayerAndandoBaixo.get(sprite), this.getPosX(), this.getPosY(), null);
            } else if (this.getVelY() < 0) {
                g.drawImage(this.imagesPlayerAndandoCima.get(sprite), this.getPosX(), this.getPosY(), null);
            } else  if (this.getVelX() == 0) {
                g.drawImage(this.imagePlayerParadoBaixo, this.getPosX(), this.getPosY(), null);
            }

        } else if (c <= intervalSprite * 3) {
            int sprite = 2;

            if (this.getVelX() > 0) {
                g.drawImage(this.imagesPlayerAndandoDireita.get(sprite), this.getPosX(), this.getPosY(), null);
            } else if (this.getVelX() < 0) {
                g.drawImage(this.imagesPlayerAndandoEsquerda.get(sprite), this.getPosX(), this.getPosY(), null);
            } else if (this.getVelY() > 0) {
                g.drawImage(this.imagesPlayerAndandoBaixo.get(sprite), this.getPosX(), this.getPosY(), null);
            } else if (this.getVelY() < 0) {
                g.drawImage(this.imagesPlayerAndandoCima.get(sprite), this.getPosX(), this.getPosY(), null);
            } else  if (this.getVelX() == 0) {
                g.drawImage(this.imagePlayerParadoBaixo, this.getPosX(), this.getPosY(), null);
            }
            
        } else if (c <= intervalSprite * 4) {
            int sprite = 3;
            
            if (this.getVelX() > 0) {
                g.drawImage(this.imagesPlayerAndandoDireita.get(sprite), this.getPosX(), this.getPosY(), null);
            } else if (this.getVelX() < 0) {
                g.drawImage(this.imagesPlayerAndandoEsquerda.get(sprite), this.getPosX(), this.getPosY(), null);
            } else if (this.getVelY() > 0) {
                g.drawImage(this.imagesPlayerAndandoBaixo.get(sprite), this.getPosX(), this.getPosY(), null);
            } else if (this.getVelY() < 0) {
                g.drawImage(this.imagesPlayerAndandoCima.get(sprite), this.getPosX(), this.getPosY(), null);
            } else  if (this.getVelX() == 0) {
                g.drawImage(this.imagePlayerParadoBaixo, this.getPosX(), this.getPosY(), null);
            }
            
        } else if (c <= intervalSprite * 5) {
            int sprite = 4;

            if (this.getVelX() > 0) {
                g.drawImage(this.imagesPlayerAndandoDireita.get(sprite), this.getPosX(), this.getPosY(), null);
            } else if (this.getVelX() < 0) {
                g.drawImage(this.imagesPlayerAndandoEsquerda.get(sprite), this.getPosX(), this.getPosY(), null);
            } else if (this.getVelY() > 0) {
                g.drawImage(this.imagesPlayerAndandoBaixo.get(sprite), this.getPosX(), this.getPosY(), null);
            } else if (this.getVelY() < 0) {
                g.drawImage(this.imagesPlayerAndandoCima.get(sprite), this.getPosX(), this.getPosY(), null);
            } else  if (this.getVelX() == 0) {
                g.drawImage(this.imagePlayerParadoBaixo, this.getPosX(), this.getPosY(), null);
            }

        } else if (c <= intervalSprite * 6) {
            int sprite = 3;

            if (this.getVelX() > 0) {
                g.drawImage(this.imagesPlayerAndandoDireita.get(sprite), this.getPosX(), this.getPosY(), null);
            } else if (this.getVelX() < 0) {
                g.drawImage(this.imagesPlayerAndandoEsquerda.get(sprite), this.getPosX(), this.getPosY(), null);
            } else if (this.getVelY() > 0) {
                g.drawImage(this.imagesPlayerAndandoBaixo.get(sprite), this.getPosX(), this.getPosY(), null);
            } else if (this.getVelY() < 0) {
                g.drawImage(this.imagesPlayerAndandoCima.get(sprite), this.getPosX(), this.getPosY(), null);
            } else  if (this.getVelX() == 0) {
                g.drawImage(this.imagePlayerParadoBaixo, this.getPosX(), this.getPosY(), null);
            }

        } else if (c <= intervalSprite * 7) {
            int sprite = 2;

            if (this.getVelX() > 0) {
                g.drawImage(this.imagesPlayerAndandoDireita.get(sprite), this.getPosX(), this.getPosY(), null);
            } else if (this.getVelX() < 0) {
                g.drawImage(this.imagesPlayerAndandoEsquerda.get(sprite), this.getPosX(), this.getPosY(), null);
            } else if (this.getVelY() > 0) {
                g.drawImage(this.imagesPlayerAndandoBaixo.get(sprite), this.getPosX(), this.getPosY(), null);
            } else if (this.getVelY() < 0) {
                g.drawImage(this.imagesPlayerAndandoCima.get(sprite), this.getPosX(), this.getPosY(), null);
            } else  if (this.getVelX() == 0) {
                g.drawImage(this.imagePlayerParadoBaixo, this.getPosX(), this.getPosY(), null);
            }

        } else if (c <= intervalSprite * 8) {
            int sprite = 1;

            if (this.getVelX() > 0) {
                g.drawImage(this.imagesPlayerAndandoDireita.get(sprite), this.getPosX(), this.getPosY(), null);
            } else if (this.getVelX() < 0) {
                g.drawImage(this.imagesPlayerAndandoEsquerda.get(sprite), this.getPosX(), this.getPosY(), null);
            } else if (this.getVelY() > 0) {
                g.drawImage(this.imagesPlayerAndandoBaixo.get(sprite), this.getPosX(), this.getPosY(), null);
            } else if (this.getVelY() < 0) {
                g.drawImage(this.imagesPlayerAndandoCima.get(sprite), this.getPosX(), this.getPosY(), null);
            } else  if (this.getVelX() == 0) {
                g.drawImage(this.imagePlayerParadoBaixo, this.getPosX(), this.getPosY(), null);
            }
        }
        /*else if (c <= 111111111 * 9) {
            if (this.getVelX() > 0) {
                g.drawImage(this.imagesPlayerAndandoDireita.get(1), this.getPosX(), this.getPosY(), null);
            } else if (this.getVelX() < 0) {
                g.drawImage(this.imagesPlayerAndandoEsquerda.get(1), this.getPosX(), this.getPosY(), null);
            } else if (this.getVelY() > 0) {
                g.drawImage(this.imagesPlayerAndandoBaixo.get(1), this.getPosX(), this.getPosY(), null);
            } else if (this.getVelY() < 0) {
                g.drawImage(this.imagesPlayerAndandoCima.get(1), this.getPosX(), this.getPosY(), null);
            } else  if (this.getVelX() == 0) {
                g.drawImage(this.imagePlayerParadoBaixo, this.getPosX(), this.getPosY(), null);
            }

        }
*/

    }



    /**
     * @return the posX
     */
    public int getPosX() {
        return posX;
    }

    /**
     * @param posX the posX to set
     */
    public final void setPosX(int posX) {
        this.posX = posX;
    }

    /**
     * @return the posY
     */
    public int getPosY() {
        return posY;
    }

    /**
     * @param posY the posY to set
     */
    public void setPosY(int posY) {
        this.posY = posY;
    }

    /**
     * @return the velX
     */
    public int getVelX() {
        return velX;
    }

    /**
     * @param velX the velX to set
     */
    public void setVelX(int velX) {
        this.velX = velX;
    }

    /**
     * @return the velY
     */
    public int getVelY() {
        return velY;
    }

    /**
     * @param velY the velY to set
     */
    public void setVelY(int velY) {
        this.velY = velY;
    }

}
