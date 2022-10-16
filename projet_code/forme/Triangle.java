
package forme;


import java.awt.Graphics;
import java.awt.Color;
import java.awt.*;
import java.io.Serializable;
public class Triangle extends Forme implements Serializable{
  private int z=0;
  int x3,y3;
 
     public Triangle(int x1,int y1,int x2,int y2,Color n,boolean f,boolean p,float j){
    super(x1,y1,x2,y2,n,p,f,j);

    }

    public void paint(Graphics g1) {
       this.x3=this.x2 -2*(this.x2- this.x1);
       this.y3=this.y2;
        int [] x = {this.x3,this.x1,this.x2};
        int [] y = {this.y2,this.y1,this.y2};
       

        BasicStroke line;
        if(this.p){
        float dash1[] = {5.0f};
       line = new BasicStroke(this.j, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 5.0f, dash1, 0.0f);
        
       }
        else{
          line = new BasicStroke(this.j);}
           Graphics2D g = (Graphics2D) g1;
           if(fill){
      
            g .setColor(this.c);
            g.setStroke(line);
            g.fillPolygon(x, y, 3);
           }
           else{

            g.setColor(this.c);
            g.setStroke(line);
            g.drawPolygon(x, y, 3);}
        }
    public  void set_x3( int x){x3=x;}
    public void set_y3(int y){y3=y;}
    public int get_x3(){return x3;}

    public int colision(int a,int b){
     
        if(b > this.y1 && b<this.y2 && a<this.x2 && a> this.x3){return 1;}
     
     
     
     
     
        else{return 0;}






    }
    public int colision_c(int a,int b){
  int dx = a - this.x1;
  int dy = b -this.y1;

  int dx1= a - this.x2;
  int dy1= b - this.y2;

  int dx2 = a- this.x3;
  int dy2 = b- this.y3;


  if( dx>-3 && dx<3 && dy>-3 && dy<3){this.z=1 ;return 1;}
  if(dx1> -3 && dx1 < 3 && dy1< 3 && dy1>-3){ this.z=2 ;return 1;}
  if( dx2> -3 && dx2 < 3 && dy2>-3 && dy2<3 ){this.z=3 ; return 1;}


return 0;
    }
  public void redimensionner(int x,int y){
  if(z==2){
      set_x2(x);
      set_y2(y);
  }
  if(z==1){
    set_x1(x);
    set_y1(y);}
    if(z==3){
        
        set_y2(y);
        this.y3=this.y2;
      }
  }
  

}


