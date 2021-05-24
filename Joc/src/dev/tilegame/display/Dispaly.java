package dev.tilegame.display;

import javax.swing.JFrame;
import java.awt.*;

public class Dispaly {

    //campurile private sunt proprietati ale frame-ului

    private JFrame frame; //frame pentru a fi afisat pe ecran (fereastra)
    private Canvas canvas;  //"imaginea" grafica care v-a fi randata in interiorul JFrame-ului (ferestrei);



    private String title; //titlul ferestrei
    private int width, height; //in pixeli ca unitati de masura

    public Dispaly(String title, int width, int height)
    { //in constructor initializam frame-ul
        this.title = title; //folosim .this pentru a diferentia de parametrii constructorului care au acelasi nume
        this.width = width;
        this.height = height;
        createDisplay(); //creeaza fereastra JFrame pe baza campurilor private setate mai sus
    }

    private void createDisplay(){
        frame = new JFrame(title);
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //face bind pentru butonul de x a.i sa se inchida jocul si in background corespunzator
        frame.setResizable(false); //destul de clar
        frame.setLocationRelativeTo(null); //spune unde sa apara prima data fereastra pe ecran, null o pune in mijlocul ecranului
        frame.setVisible(true); //JFrame by default nu esti vizibil, trebuie setat manual pentru a vedea fereastra

        canvas = new Canvas(); //declaram un canvas (foaie pe care se deseneaza)
        canvas.setPreferredSize(new Dimension(width, height)); //creeaza un canvas care are dimensiunea cat toata fereastra
        canvas.setMaximumSize(new Dimension(width, height));    //se asigura ca canvasul se "muleaza" pe fereastra tot timpul
        canvas.setMinimumSize(new Dimension(width, height));    //acelasi lucru ca in linia de mai sus
        canvas.setFocusable(false); //fixeaza un bug //permite ca jframe sa fie singurul lucru care are focus

        frame.add(canvas); //adauga in frame, canvasul creat
        frame.pack(); //face un resize mic la frame a.i sa putem vedea canvasul in intregime| functioneaza si fara, dar il feliaza putin

    }

    //GETTER AND SETTER
    public Canvas getCanvas()
    {
        return canvas;
    }
    public JFrame getFrame(){ //getter pentru frame
        return frame;
    }
}
