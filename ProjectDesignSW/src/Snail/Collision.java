package Snail;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class Collision {
    
    Snail snail;
    GameElement elementB;

    public Collision(Snail snail, GameElement element) {
        this.snail = snail;
        this.elementB = element;
    }
    
    public void checkCollisionX() {
        int type = this.elementB.tipo;
        if (type == 1) {
            int posYSnail = this.snail.position.y;
            int posXSnail = this.snail.position.x;
            int heightSnail = this.snail.height;
            int widthSnail = this.snail.width;
            int speedSnailX = this.snail.speedX;

            int posYElement = this.elementB.position.y;
            int posXElement = this.elementB.position.x;
            int heightElement = this.elementB.height;
            int widthElement = this.elementB.width;

            if ((posXSnail + widthSnail + speedSnailX > posXElement)
                    && (posXSnail + speedSnailX < posXElement + widthElement)
                    && (posYSnail + heightSnail > posYElement)
                    && (posYSnail < posYElement + heightElement)) {
                //this.snail.setPosicionX(posXElement - widthSnail );
                this.snail.setSpeedX(speedSnailX *= -1);
            } else {
                this.snail.setSpeedX(2);
            }
        }

    }
    
    
    
    public void checkCollisionY() {
        int type = this.elementB.tipo;
        if (type == 1) {
            int posYSnail = this.snail.position.y;
            int posXSnail = this.snail.position.x;
            int heightSnail = this.snail.height;
            int widthSnail = this.snail.width;
            int speedSnailY = this.snail.speedY;

            int posYElement = this.elementB.position.y;
            int posXElement = this.elementB.position.x;
            int heightElement = this.elementB.height;
            int widthElement = this.elementB.width;

            if ((posXSnail + widthSnail > posXElement)
                    && (posXSnail < posXElement + widthElement)
                    && (posYSnail + heightSnail + speedSnailY > posYElement)
                    && (posYSnail + speedSnailY < posYElement + heightElement)) {
                this.snail.setPosicionY(posYElement - heightSnail);
                this.snail.setSpeedX(speedSnailY = 0);
            } else {
                this.snail.setSpeedY(1);
            }
        }

        
    }
    
    
    public void checkCollision(){
        checkCollisionY();
        checkCollisionX();
    }
    
}
