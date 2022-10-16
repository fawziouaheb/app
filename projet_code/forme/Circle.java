package forme;


import java.awt.Graphics;
import java.awt.Color;
import java.awt.*;
import java.io.Serializable;
public class Circle extends Forme implements Serializable{
   
    private int z=0;  
  
     public Circle(int x1,int y1,int x2,int y2,Color n,Boolean f,boolean p,float j){
    super(x1,y1,x2,y2,n,p,f,j);
    }
  public  void paint(Graphics g1){ 
    BasicStroke line;
  
   if(this.p){ // forme en pointillé
   float dash1[] = {5.0f};
   line = new BasicStroke(this.j, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 5.0f, dash1, 0.0f);
   }
   else{
     line = new BasicStroke(this.j);}
     Graphics2D g = (Graphics2D) g1;
    if(fill){ //forme remplie
      g .setColor(this.c);
      g.setStroke(line);
      if((this.x2 > this.x1) && (this.y2 > this.y1)) {g.fillOval(this.x1,this.y1,this.x2-this.x1,this.y2-this.y1); 
       // g.fillOval(this.x2,this.y2, 4, 4);
        //g.fillOval(this.x2, this.y1, 4, 4);
        //g.fillOval(this.x1, this.y1, 4, 4);
        //g.fillOval(this.x1, this.y2, 4, 4);
      }
      if(this.x1 > this.x2 && this.y2 > this.y1)  {g.fillOval(this.x2,this.y1,this.x1-this.x2,this.y2-this.y1); 
        //g.fillOval(this.x2,this.y2, 4, 4);
        //g.fillOval(this.x2, this.y1, 4, 4);
        //g.fillOval(this.x1, this.y1, 4, 4);
        //g.fillOval(this.x1, this.y2, 4, 4);
      }
      if(this.x2 >  this.x1 && this.y1 > this.y2 ){g.fillOval(this.x1,this.y2,this.x2-this.x1,this.y1-this.y2); 
        //g.fillOval(this.x2, this.y2, 4, 4);
        //g.fillOval(this.x2, this.y1, 4, 4);
        //g.fillOval(this.x1, this.y1, 4, 4);
        //g.fillOval(this.x1, this.y2, 4, 4);
      }
      if(this.x1> this.x2 && this.y1 >this.y2){g.fillOval(this.x2,this.y2,this.x1-this.x2,this.y1-this.y2);
         //g.fillOval(this.x2, this.y2, 4, 4);
        //g.fillOval(this.x2, this.y1, 4, 4);
        //g.fillOval(this.x1, this.y1, 4, 4);
        //g.fillOval(this.x1, this.y2, 4, 4);
      }
    }else{
      
      g.setColor(this.c);
     g.setStroke(line);
     if((this.x2 > this.x1) && (this.y2 > this.y1)) {g.drawOval(this.x1,this.y1,this.x2-this.x1,this.y2-this.y1); //g.fillOval(this.x2, this.y2, 4, 4);
      //g.fillOval(this.x2, this.y1, 4, 4);
     // g.fillOval(this.x1, this.y1, 4, 4);
      //g.fillOval(this.x1, this.y2, 4, 4);
    }
     if(this.x1 > this.x2 && this.y2 > this.y1)  {g.drawOval(this.x2,this.y1,this.x1-this.x2,this.y2-this.y1);
      // g.fillOval(this.x2, this.y2, 4, 4);
      //g.fillOval(this.x2, this.y1, 4, 4);
     // g.fillOval(this.x1, this.y1, 4, 4);
      //g.fillOval(this.x1, this.y2, 4, 4);
    }
     if(this.x2 >  this.x1 && this.y1 > this.y2 ){g.drawOval(this.x1,this.y2,this.x2-this.x1,this.y1-this.y2); 
      //g.fillOval(this.x2, this.y2, 4, 4);
      //g.fillOval(this.x2, this.y1, 4, 4);
      //g.fillOval(this.x1, this.y1, 4, 4);
      //g.fillOval(this.x1, this.y2, 4, 4);
    }
     if(this.x1> this.x2 && this.y1 >this.y2){g.drawOval(this.x2,this.y2,this.x1-this.x2,this.y1-this.y2);
      // g.fillOval(this.x2,this.y2, 4, 4);
      //g.fillOval(this.x2, this.y1, 4, 4);
      //g.fillOval(this.x1, this.y1, 4, 4);
      //g.fillOval(this.x1, this.y2, 4, 4);
    }
        }}


     
       public  int colision(int a,int b){  //la fonction qui gere la colision entre le curseur et le cercle
     if( ((a>=this.x1 && a<= this.x2) && (b>=this.y1 && b<= this.y2)) 
     ||  (a>this.x2 && a < this.x1 && b>this.y2 && b<this.y1 )  
     || (a>this.x1  && a<this.x2 && b>this.y2 && b<this.y1 )
     || (a>this.x2 && a<this.x1 && b>this.y1 && b<this.y2)
     ){return 1;}
     else {return 0;}
       }
    
      
       public  int colision_c(int a,int b){ //la fonction qui gere la colision du curseur avec les 4 coins du circle pour la redimensionner
              
         int dx= a - this.x2;
         int dy= b - this.y2;
    
         int dx2= a-  this.x2 ;
         int dy2= b- this.y1 ;
    
         int dx3= a-this.x1;
         int dy3= b-this.y1;
    
         int dx4= a- this.x1;
         int dy4= b-this.y2;
    
    
        if( (dx > -3 && dx < 3 && dy >-3 && dy < 3) ){ this.z=1;return 1;}
        if( (dx2 > -3 && dx2 < 3 && dy2 >-3 && dy2 < 3 )  ){ this.z=2;return 1;}
        if( (dx3 > -3 && dx3 < 3 && dy3 >-3 && dy3 < 3) ){ this.z=3;return 1;}
        if( (dx4> -3 && dx4 < 3 && dy4 >-3 && dy4 < 3) ){ this.z=4;return 1;}
       
    
      return 0;} 
      public void redimensionner(int a,int b){ //la fonction qui change les positions  des x,y pour redimensionner
        if(z== 1){ //z represente le coins a redimensionner
        set_x2(a);  set_y2(b);}
      
      if(z==2){
        set_x2(a);  set_y1(b);
    
      }
      if(z==3){
        set_x1(a);
        set_y1(b);
      }
      if(z==4){
        set_x1(a);
        set_y2(b);
      }
    }
    }
  
   


       

    




