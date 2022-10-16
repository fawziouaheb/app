package forme;


import java.awt.Graphics;
import java.awt.Color;
import java.awt.*;
import java.io.Serializable;

  public class Line extends Forme implements Serializable{
    
    private int z=0;
    public Line(int x1,int y1,int x2,int y2,Color c,Boolean p,float j){
     super(x1, y1,x2,y2,c,p,false,j);
    }
    public  void paint(Graphics g1){
      BasicStroke line;
      if(this.p){
        float dash1[] = {5.0f};
         line = new BasicStroke(this.j, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 5.0f, dash1, 0.0f);
        
       }
        else{
          line = new BasicStroke(this.j);}
            Graphics2D g = (Graphics2D) g1;
            g.setColor(c);
            g.setStroke(line);
            g.drawLine(this.x1,this.y1,this.x2,this.y2);
          }
 /*
dans cette fonction de colision on calcule la formule de la droite (la ligne) y=ax+b et on 
calcule la distance entre cette droite et notre point du curseur

 */
        public  int colision(int p,int q){  
          float a,b,c,d;

          a=(float)(this.y2 - this.y1)/(float)(this.x2 - this.x1);
          b=this.y2 - (a*this.x2);
          c= a*a + 1;
          d=(float)(-a*p + q - b)/(float)(Math.sqrt(c));

          if(d>-6 && d<6){ return 1;}
          
          
          
          return 0;}
        public int colision_c(int a,int b){
          int dx= a - this.x2;
          int dy= b - this.y2;
          
          int dx1 = a- this.x1;
          int dy1= b - this.y1;
        if( dx < 3 && dx >-3 && dy > -3 && dy <3){ 
        System.out.printf("la valeur de dx"+dy); this.z =1; return 1 ;}
        if( dx1 <3 && dx1> -3 && dy1 > -3 && dy1 <3){   this.z =2; return 1 ;} 
        return 0;

        }
        public void redimensionner(int x,int y){
          if(this.z==1){
            set_x2(x);
            set_y2(y);
          }
          if(this.z==2){
            set_x1(x);
            set_y1(y);
          }
         }
      }

      
     

