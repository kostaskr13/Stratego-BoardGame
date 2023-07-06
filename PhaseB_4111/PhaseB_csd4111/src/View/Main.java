package View;

import Control.Controller;

import javax.swing.*;
import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import Model.Pieces.Color;
import Model.Player.Player;
import Control.Controller;


public class Main {


    public static  void main(String[] args) {

        Controller control=new Controller();
        control.start_Turn();
        View game = new View(control);



    }





}

