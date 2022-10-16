

package forme; //package forme

import java.awt.*;
import java.io.Serializable;
abstract public class Forme implements Serializable{
    protected  int x1,y1,x2,y2;
    protected Color c;
    protected boolean p;
    protected   float j;
    protected    boolean fill;
      public   Forme(int x1,int y1,int x2,int y2,Color c,boolean p,boolean f,float j){
             this.x1=x1;
             this.y1=y1;
             this.x2=x2;
             this.y2=y2;
             this.c=c;
             this.p=p;
             this.fill=f;
             this.j=j;
            }
  abstract   public int colision(int a,int b); //une methode abstraite pour les colisions qui est redifine dans chaque class fils
  abstract  public void paint(Graphics g);
  public void set_x1(int x){this.x1=x;}
  public void set_x2(int x){this.x2=x;}
  public void set_y1(int x){this.y1=x;}
  public void set_y2(int x){this.y2=x;}
  public int get_x1(){return this.x1;}
  public int get_x2(){return this.x2;}
  public int get_y1(){return this.y1;}
  public int get_y2(){return this.y2;}
  public void set_color(Color c){this.c=c;}
  public Color Get_color(){return this.c;}
   public void set_p(boolean p){this.p=p;}
   public boolean get_p(){return this.p;}
   public void set_fill(boolean f){ this.fill = f ;}
   public boolean get_fill(){return this.fill;}
 
  public float get_j(){return this.j;}
  public void set_j(float ep){this.j=ep;}
  abstract  public int colision_c(int a,int b); //cette fonction elle gere les colision avec coins pour chaque forme
  abstract  public void redimensionner(int x,int y );
  public void move(int a ,int b){ //faire bouger mes formes
                set_x1( get_x1()+a- get_x2());
                 set_x2( get_x2()+a- get_x2());
                 set_y1( get_y1()+b- get_y2());
                 set_y2( get_y2()+b- get_y2());
  }

}