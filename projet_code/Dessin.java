

import forme.*;

import java.awt.event.*;
import javax.sound.sampled.BooleanControl;
import javax.swing.JPanel;
import javax.xml.transform.Templates;
import java.awt.event.MouseEvent;
import java.awt.*;
import java.util.ArrayList; 
import java.io.Serializable;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.InputStream;


public class Dessin extends JPanel implements Serializable{   
 private Color my_color; 
 private Forme tem,copy; //des variable de type forme pour des differents action par exemple copier
 private int mod=0; //il indique le type de la forme a dessiner en fonction de boutton appuie 
 private int action =0; //la variable qui indique l'action a executé
 private boolean fill=false;
 private boolean po=false; // boolean pointillé
 private float slider=2;
 private int test;
 private File  fichier=null;

public ArrayList<Forme> listredo; //ma liste de corbeille de type forme

public ArrayList<Forme> myliste;  //ma liste des formes

public Dessin(){
    myliste= new ArrayList<Forme>();//initialisation des variables ....
    listredo = new ArrayList<Forme>();
    tem = null;
    copy=null;
    
   
this.addMouseListener(new MouseListener(){
    public void mouseClicked( MouseEvent l){ }
      public void	mouseEntered(MouseEvent e){}
      public void	mouseExited(MouseEvent e){}
      public void	mousePressed(MouseEvent e){
          //dessiner les formes en fonctionne de la valeur de mod
        switch(mod)
        {  
            case 1:   //polygone
            tem = new Triangle(e.getX(), e.getY(),0,0,Get_color(),get_fill(),get_p(),get_slider());
            break;

            case 2: // Line
                tem = new Line(e.getX(), e.getY(), 0, 0,Get_color(),get_p(),get_slider());
                break;

            case 4: //oval
                tem = new Circle(e.getX(), e.getY(), 0, 0,Get_color(),get_fill(),get_p(),get_slider());
                break;


           case 3:  //Rect
                tem = new Rect(e.getX(), e.getY(),0,0,Get_color(),get_fill(),get_p(),get_slider());
                break;

        }


        switch(action)
        {
            case 1:   
           
            for(Forme q : myliste){//remove
                if(q.colision(e.getX(),e.getY())==1){
                    listredo.add(q);
                    myliste.remove(q);
                    repaint();
                }}
                 break;

          case 2 :    //move
          for(Forme q : myliste){
            if(q.colision(e.getX(),e.getY())==1){
                tem = q;
                test = 1;
              
            }}
            break;

            case 3 :   //redimensionner
            for(Forme q : myliste){ // parcourir la liste de forme
                if(q.colision_c(e.getX(),e.getY())==1){  // la fonction colision renvoie vrai si ya une colision entre le curseur de la souris et une des formes
                    tem=q;
                    test=2;
                repaint();
                }}
                break;
          

           case 4: //set_color
           for(Forme q : myliste){
            if(q.colision(e.getX(),e.getY())==1){
                q.set_color(Get_color());
                repaint();
            }} 
           break;

           case 5: //set_pointillé
           for(Forme q : myliste){
            if(q.colision(e.getX(),e.getY())==1){
                q.set_p(get_p());
                repaint();
            }} 
           break;


           case 6:  //set_fill
           for(Forme q : myliste){//remove
            if(q.colision(e.getX(),e.getY())==1){
                q.set_fill(get_fill());
                repaint();
            }} 
           break;


           case 7 :  //set_epaisseur
           for(Forme q : myliste){
            if(q.colision(e.getX(),e.getY())==1){
                q.set_j(get_slider());
                repaint();
            }} 
           break;


           case 8:
           for(Forme q : myliste){// copy
            if(q.colision(e.getX(),e.getY())==1){
               if( q instanceof Rect){
                   tem=null;
                tem=new Rect(q.get_x1()+20, q.get_y1()+20,q.get_x2()+20,q.get_y2()+20,q.Get_color(),q.get_fill(),q.get_p(),q.get_j());
               }
               if( q instanceof Circle){
                tem=new Circle(q.get_x1()+20, q.get_y1()+20,q.get_x2()+20,q.get_y2()+20,q.Get_color(),q.get_fill(),q.get_p(),q.get_j());
               }
               if( q instanceof Line){
                tem=new Line(q.get_x1()+20, q.get_y1()+20,q.get_x2()+20,q.get_y2()+20,q.Get_color(),q.get_p(),q.get_j());
               }

               if( q instanceof Triangle){
                tem=new Triangle(q.get_x1()+20, q.get_y1()+20,q.get_x2()+20,q.get_y2()+20,q.Get_color(),q.get_fill(),q.get_p(),q.get_j());            }
               }}
               break;

            }
 }
      public void mouseReleased(MouseEvent e){
          if(get_mod()!=0){
          tem.set_x2(e.getX());
          tem.set_y2(e.getY());
          myliste.add(tem);
          }
          if(test == 1) //move
          {
            tem.move(e.getX(),e.getY());
            test = 0;
          }
          if(test ==2){  //redimensionner
              tem.redimensionner(e.getX(),e.getY());
              test=0;
          }
          repaint();
    }
         
      
    });
    this.addMouseMotionListener(new MouseMotionListener(){
        public  void	mouseDragged(MouseEvent e){
            if(get_mod()!=0){
            tem.set_x2(e.getX());
            tem.set_y2(e.getY());
            dessiner(tem); //la fonction qui fait appelle a paint de chaque objet avant de le ajouter a ma liste
          
            }
            if(test == 1)//move
            {  
              tem.move(e.getX(),e.getY());  //la fonction qui fait bouger mes forme en fonction de la forme a faire bouger
            }
            if(test ==2){//redimensionner
                tem.redimensionner(e.getX(),e.getY()); //redimensionner une forme
            }
         repaint();
        
    }
    public void	mouseMoved(MouseEvent e){}
});

}
public void verify(){
    if(action==20){ //undo
        if(!myliste.isEmpty()){
        this.listredo.add(this.myliste.get(this.myliste.size()-1));
        this.myliste.remove(this.myliste.size()-1);
        }
    }
    if(action==21){ //redo
       if(!listredo.isEmpty()){
       this.myliste.add(this.listredo.get(this.listredo.size()-1));
       this.listredo.remove((this.listredo.size()-1));
       }
    }
   
    if(action==22){ //coller
        this.myliste.add(tem); }
                
      
    if(action==23){ //réinitialiser  tout mon  fichier
      this.myliste.clear();
      this.listredo.clear();
     }
   
     if(action ==24){ //creer a new file
            
             fichier= new File("../projet_save");
             this.myliste.clear();
             this.listredo.clear();
     
         
        }
       if(action==25){   //sauvegarder un fichier(save_as)
           if(fichier==null){
               fichier=new File("../projet_save");
           }
       JFileChooser choose=new JFileChooser();
       choose.setCurrentDirectory(fichier);
        choose.setDialogTitle("Specify a file to save");   
      int userSelection = choose.showSaveDialog(null);
     
       if (userSelection == JFileChooser.APPROVE_OPTION) {
       fichier = new File(choose.getSelectedFile().getAbsolutePath());
       try{

           
           ObjectOutputStream objout = new ObjectOutputStream(new FileOutputStream(fichier));
          objout.writeObject(myliste);
          objout.close();
           System.out.println("la");
           }
          catch(Exception e)
          {
              System.out.println(e);
          }
        System.out.println("Save as file: " + fichier.getAbsolutePath());


       }  
    }

 
    if(action==26){ //ouverture d'un fichier
        JFileChooser choose=new JFileChooser();
        choose.setDialogTitle("Specify a file to save");  
        choose.setCurrentDirectory(fichier); 
      int userSelection = choose.showOpenDialog(null);
      if (userSelection == JFileChooser.APPROVE_OPTION) {
        fichier = new File(choose.getSelectedFile().getAbsolutePath());
        
        try{
            ObjectInputStream objin = new ObjectInputStream(new FileInputStream(fichier));
            this.myliste = (ArrayList<Forme>)objin.readObject();
            
            }
               catch(Exception e)
            {
                System.out.println(e);
            }
        }
    }

    if(action==27){ //sauvegarder les modifications save

        try{
            ObjectOutputStream objout = new ObjectOutputStream(new FileOutputStream(fichier));
        objout.writeObject(myliste);
        objout.close();
            }
               catch(Exception e)
            {
                System.out.println(e);
            }
        }
repaint();
}
   public Color Get_color(){return this.my_color;} // recupere la couleur 
   public void set_color(Color c){this.my_color=c;} //modifier la couleur 
  
   public int get_action(){return this.action;} //recuperer l'action 
   public void set_action(int action){   //modifier l'action 
    this.action=action;}
  
   public void set_mod(int mo){this.mod=mo;} //modifier la forme a dessiner 
   public int get_mod(){return this.mod;} //recuperer la forme a dessiner 
   public void set_fill( boolean f){this.fill=f;} 
   public boolean get_fill(){return this.fill;}

   public void set_p(boolean p){this.po=p;}
   public boolean get_p(){return this.po;}
   public float get_slider(){return this.slider;}
   public void set_slider( float s){this.slider=s;}
   public void dessiner(Forme q){ 
       q.paint(this.getGraphics());
       repaint();
   }
   protected void paintComponent(Graphics g){ 
       super.paintComponent(g);
       for(Forme q : this.myliste ){
        q.paint(g);
    }
   }
}










