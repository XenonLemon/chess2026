//PIECE DESCRIPTION: The elephant piece moves diagonally 2 squares.
package com.example;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.imageio.ImageIO;

//you will need to implement two functions in this file.
public class ElephantPiece extends Piece {
    
    
    public ElephantPiece(boolean isWhite, String img_file) {
        
        super(isWhite, img_file);
         
    }

    
    
    public void draw(Graphics g, Square currentSquare) {
        int x = currentSquare.getX();
        int y = currentSquare.getY();
        
        g.drawImage(this.img, x, y, null);
    }
    
    
    // TO BE IMPLEMENTED!
    //return a list of every square that is "controlled" by this piece. A square is controlled
    //if the piece capture into it legally.
    //PRE CONDITION: Board exists and is not null, and starting square is located inside the board.
    //POST CONDITION: Will return the Arraylist "moves", which says which squares the piece controls.
    public ArrayList<Square> getControlledSquares(Square[][] board, Square start) {
        ArrayList<Square> squares = new ArrayList<Square>();
        if(start.getCol()<=5 && start.getRow()<=5){
            Square rightUp = board[start.getRow()+2][start.getCol()+2];
            squares.add(rightUp);
        }
        if(start.getCol()>=2 && start.getRow()<=5){
            Square leftUp =  board[start.getRow()+2][start.getCol()-2];
            squares.add(leftUp);
        }
        if(start.getCol()<=5 && start.getRow()>=2){
            Square rightDown =  board[start.getRow()-2][start.getCol()+2];
            squares.add(rightDown);
        }
         if(start.getCol()>=2 && start.getRow()>=2){
            Square leftDown =  board[start.getRow()-2][start.getCol()-2];
            squares.add(leftDown);
         }

        return squares;
    }
    

    //TO BE IMPLEMENTED!
    //implement the move function here
    //it's up to you how the piece moves, but at the very least the rules should be logical and it should never move off the board!
    //returns an arraylist of squares which are legal to move to
    //please note that your piece must have some sort of logic. Just being able to move to every square on the board is not
    //going to score any points.
    //PRE CONDITION: Board b is not null, and start is inside of the board and is not null.
    //POST CONDITION:Will reurn the ArrayList "moves", which says what squares the piece can legally move to.
    public ArrayList<Square> getLegalMoves(Board b, Square start){
        //start by declaring the arrayList we wish to return at the end
        ArrayList<Square> moves = new ArrayList<Square>();
        if(start.getCol()<=5 && start.getRow()<=5){
            Square rightUp = b.getSquareArray()[start.getRow()+2][start.getCol()+2];
            if(rightUp.isOccupied() && rightUp.getOccupyingPiece().getColor()!= color){
               moves.add(rightUp); 
            }
            else if(rightUp.isOccupied() != true){
                moves.add(rightUp);
            }
        }
        if(start.getCol()>=2 && start.getRow()<=5){
            Square leftUp =  b.getSquareArray()[start.getRow()+2][start.getCol()-2];
            if(leftUp.isOccupied() && leftUp.getOccupyingPiece().getColor()!= color){
               moves.add(leftUp); 
            }
            else if(leftUp.isOccupied() != true){
                moves.add(leftUp);
            }
        }
        if(start.getCol()<=5 && start.getRow()>=2){
            Square rightDown =  b.getSquareArray()[start.getRow()-2][start.getCol()+2];
            if(rightDown.isOccupied() && rightDown.getOccupyingPiece().getColor()!= color){
               moves.add(rightDown); 
            }
            else if(rightDown.isOccupied() != true){
                moves.add(rightDown);
            }
        }
        if(start.getCol()>=2 && start.getRow()>=2){
            Square leftDown =  b.getSquareArray()[start.getRow()-2][start.getCol()-2];
            if(leftDown.isOccupied() && leftDown.getOccupyingPiece().getColor()!= color){
               moves.add(leftDown); 
            }
            else if(leftDown.isOccupied() != true){
                moves.add(leftDown);
            }
        }
        return moves;
    }
    //toString Override
    //PreCondition: Current piece has a boolean for a color that isn't null
    //Post Condition; will return a string that tells if the current piece is white or not. 
    public String toString() {
        if (color)
            return "A white elephant piece";
        else
            return "A black elephant piece";
    }
        
}
