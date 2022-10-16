import forme.*;
import java.awt.event.ActionEvent;
import java.awt.*;
import javax.swing.JCheckBox;
import javax.swing.JSlider;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JToolBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem; 
import javax.swing.JMenuBar;
import javax.swing.KeyStroke;
import javax.swing.JColorChooser;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.io.Serializable;

public class Panel  extends JFrame implements Serializable{
    
    JCheckBox fill;
    JCheckBox p;
    Dessin c;

public Panel(){
    
    c = new Dessin();   //creer une instance de type dessin(jpanel)
     this.setLayout(new BorderLayout());
     this.setJMenuBar(Createmenu() );
     this.add(createtoolbar(),BorderLayout.WEST);
     this.add(barforme(),BorderLayout.EAST);
     this.add(barreoutils(),BorderLayout.NORTH);
     this.add(c);
    
this.setSize(800,800);
this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
this.setLocationRelativeTo(null);
this.setVisible(true);
         
}



    public JToolBar createtoolbar(){   //une fonction qui me retourne une toolbar
       
        JToolBar toolbar= new JToolBar(null, JToolBar.VERTICAL);
        toolbar.setFloatable(false);
         
        JButton btNewfile = new JButton(new ImageIcon( "icons/new.png"));
        btNewfile.setToolTipText("New files(Cnrl +N");
        
         
        JButton btSave=new JButton(new ImageIcon( "icons/save.png"));
        btSave.setToolTipText("savefile(Cnrl +s");

        
        JButton btSave_as=new JButton(new ImageIcon( "icons/save_as.png"));
        btSave_as.setToolTipText("Save_AS(Cnrl +l");
        
        JButton btnCopy = new JButton( new ImageIcon( "icons/copy.png") );
        btnCopy.setToolTipText( "Copy (CTRL+C)" );

        JButton undo = new JButton( new ImageIcon( "icons/undo.png") );
        undo.setToolTipText( "undo (CTRL+Z)" );
       

        JButton btnredo = new JButton( new ImageIcon( "icons/redo.png") );
        btnredo.setToolTipText( "redo (CTRL+ U)" );
       

        JButton btnPaste = new JButton( new ImageIcon( "icons/paste.png") );
        btnPaste.setToolTipText( "Paste (CTRL+V)" );
       

        toolbar.addSeparator();

        JButton btnExit = new JButton( new ImageIcon( "icons/exit.png") );
        btnExit.setToolTipText( "Exit (ALT+F4)" );

  
       btNewfile.addActionListener( new ActionListener(){  //a chaque appuie sur un bouton on change l'action(l'evenement)
        public void actionPerformed(ActionEvent e){   
            c.set_action(24);
            c.set_mod(0);
            c.verify();
         
         }});



        btnExit.addActionListener( new ActionListener(){
        public void actionPerformed(ActionEvent e){   
            System.exit(0);   
         
         }});
         

        btSave.addActionListener( new ActionListener(){
            public void actionPerformed(ActionEvent e){   
                c.set_action(27);   
                c.set_mod(0);
                c.verify();
               
             }});


       btSave_as.addActionListener( new ActionListener(){
                public void actionPerformed(ActionEvent e){      
                    c.set_action(25);
                    c.set_mod(0);
                    c.verify();
                 }});


      btnCopy.addActionListener( new ActionListener(){
            public void actionPerformed(ActionEvent e){      
                c.set_action(8);
                c.set_mod(0);
                c.verify();        
                     }}); 

 
    btnredo.addActionListener( new ActionListener(){
       public void actionPerformed(ActionEvent e){      
             c.set_action(21);
             c.set_mod(0);
             c.verify();
                         }});

   btnPaste.addActionListener( new ActionListener(){
      public void actionPerformed(ActionEvent e){      
         c.set_action(22);
         c.set_mod(0);
         c.verify();
                    }});
                

    undo.addActionListener( new ActionListener(){
     public void actionPerformed(ActionEvent e){   
         c.set_action(20);  
         c.set_mod(0);
         c.verify();
                        }});
    




        

        toolbar.add(btNewfile);
        toolbar.add(btSave);
        toolbar.add(btSave_as);
        toolbar.add( btnCopy );
        toolbar.add( btnPaste );
        toolbar.add( btnredo);
        toolbar.add(undo);
        toolbar.add( btnExit ); 
        
        toolbar.addSeparator();
         return toolbar;
    }



    public JMenuBar Createmenu(){
    
        JMenuBar menuBar = new JMenuBar();
    
        JMenu mnuFile = new JMenu( "File" );
        mnuFile.setMnemonic( 'F' );
    
        JMenuItem mnuNewFile = new JMenuItem( "New File" );
        mnuNewFile.setIcon( new ImageIcon( "icons/new.png" ) );
        mnuNewFile.setMnemonic( 'N' );
        mnuNewFile.setAccelerator( KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK) ); //raccourci clavier
        mnuNewFile.addActionListener( new ActionListener(){
        public void actionPerformed(ActionEvent e){   
            c.set_action(24);
            c.set_mod(0);
            c.verify();
         }});
        mnuFile.add(mnuNewFile);
    
        mnuFile.addSeparator();
    
        JMenuItem mnuOpenFile = new JMenuItem( "Open File ..." );
        mnuOpenFile.setIcon( new ImageIcon( "icons/open.png" ) );
        mnuOpenFile.setMnemonic( 'O' );
        mnuOpenFile.setAccelerator( KeyStroke.getKeyStroke(KeyEvent.VK_O, KeyEvent.CTRL_DOWN_MASK) );
        mnuOpenFile.addActionListener( new ActionListener(){
            public void actionPerformed(ActionEvent e){   
                c.set_action(26);
                c.set_mod(0);
                c.verify();
               
             }});
        mnuFile.add(mnuOpenFile);
    
        JMenuItem mnuSaveFile = new JMenuItem( "Save File ..." );
        mnuSaveFile.setIcon( new ImageIcon( "icons/save.png" ) );
        mnuSaveFile.setMnemonic( 'S' );
        mnuSaveFile.setAccelerator( KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK) );
        mnuSaveFile.addActionListener( new ActionListener(){
            public void actionPerformed(ActionEvent e){   
                c.set_action(27);
                c.set_mod(0);
                c.verify();
             
             }});
        mnuFile.add(mnuSaveFile);
    
    
        JMenuItem mnuSaveFileAs = new JMenuItem( "Save File As ..." );
        mnuSaveFileAs.setIcon( new ImageIcon( "icons/save_as.png" ) );
        mnuSaveFileAs.setMnemonic( 'A' );
        mnuSaveFileAs.setAccelerator( KeyStroke.getKeyStroke(KeyEvent.VK_L, KeyEvent.CTRL_DOWN_MASK) );
        mnuSaveFileAs.addActionListener( new ActionListener(){
            public void actionPerformed(ActionEvent e){   
                c.set_action(25);
                c.set_mod(0);
                c.verify(); 
             
             }});
        mnuFile.add(mnuSaveFileAs);
    
        mnuFile.addSeparator();
    
        JMenuItem mnuExit = new JMenuItem( "Exit" );
        mnuExit.setIcon( new ImageIcon( "icons/exit.png" ) );
        mnuExit.setMnemonic( 'x' );
        mnuExit.setAccelerator( KeyStroke.getKeyStroke(KeyEvent.VK_Q, KeyEvent.ALT_DOWN_MASK) );
        mnuExit.addActionListener( new ActionListener(){
            public void actionPerformed(ActionEvent e){      
                System.exit(0);
             
                    }
        });
        
        mnuFile.add(mnuExit);
    
        
        menuBar.add(mnuFile);
        
        // Définition du menu déroulant "Edit" et de son contenu
        JMenu mnuEdit = new JMenu( "Edit" );
        mnuEdit.setMnemonic( 'E' );
        
        JMenuItem mnuUndo = new JMenuItem( "Undo" );
        mnuUndo.setIcon( new ImageIcon( "icons/undo.png" ) );
        mnuUndo.setMnemonic( 'U' );
        mnuUndo.setAccelerator( KeyStroke.getKeyStroke(KeyEvent.VK_Z, KeyEvent.ALT_DOWN_MASK) );
        mnuUndo.addActionListener( new ActionListener(){
        public void actionPerformed(ActionEvent e){   
            c.set_action(20);
            c.set_mod(0);
            c.verify();
            }});
        
        mnuEdit.add(mnuUndo);
        
        JMenuItem mnuRedo = new JMenuItem( "Redo" );
        mnuRedo.setIcon( new ImageIcon( "icons/redo.png" ) );
        mnuRedo.setMnemonic( 'R' );
        mnuRedo.setAccelerator( KeyStroke.getKeyStroke(KeyEvent.VK_U, KeyEvent.CTRL_DOWN_MASK) );
        mnuRedo.addActionListener( new ActionListener(){
            public void actionPerformed(ActionEvent e){   
                c.set_action(21);
                c.set_mod(0);
                c.verify();
                 
             
             }});
        mnuEdit.add(mnuRedo);
        
        mnuEdit.addSeparator();
        
        JMenuItem mnuCopy = new JMenuItem( "Copy" );
        mnuCopy.setIcon( new ImageIcon( "icons/copy.png" ) );
        mnuCopy.setMnemonic( 'C' );
        mnuCopy.setAccelerator( KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_DOWN_MASK) );
        mnuCopy.addActionListener( new ActionListener(){
            public void actionPerformed(ActionEvent e){   
                c.set_action(8);
                c.set_mod(0);
                c.verify();
                 
             
             }});
        mnuEdit.add(mnuCopy);
        
        JMenuItem mnuPaste = new JMenuItem( "Paste" );
        mnuPaste.setIcon( new ImageIcon( "icons/paste.png" ) );
        mnuPaste.setMnemonic( 'P' );
        mnuPaste.setAccelerator( KeyStroke.getKeyStroke(KeyEvent.VK_V, KeyEvent.CTRL_DOWN_MASK) );
        mnuPaste.addActionListener( new ActionListener(){
            public void actionPerformed(ActionEvent e){   
                c.set_action(22);
                c.set_mod(0);
                c.verify();
             }});
        mnuEdit.add(mnuPaste);

    
        menuBar.add(mnuEdit);
    
       
        JMenu mnuHelp = new JMenu( "Help" );
        mnuHelp.setMnemonic( 'H' );
        
        menuBar.add( mnuHelp );
        
        return menuBar;}
    
   
      public JToolBar barforme(){   //la fonction qui me retourne la barre de forme a dessiner
            JToolBar forme= new JToolBar(null, JToolBar.VERTICAL);
            forme.setFloatable(false);
            JButton cercle= new JButton(new ImageIcon("icons/circle.png") );
            JButton triangle= new JButton(new ImageIcon("icons/tria.png")  );
            JButton carrer= new JButton(new ImageIcon("icons/carrer.png") );
            JButton ligne= new JButton(new ImageIcon("icons/line.jpg"));


            carrer.addActionListener( new ActionListener(){
                public void actionPerformed(ActionEvent e){      
                    c.set_mod(3);
                    c.set_action(0);
                 
                        }
            });
            cercle.addActionListener( new ActionListener(){
                public void actionPerformed(ActionEvent e){      
                    c.set_mod(4);
                    c.set_action(0);}
            });
             
            
                  
          
            ligne.addActionListener( new ActionListener(){
                public void actionPerformed(ActionEvent e){
                           c.set_mod(2); 
                           c.set_action(0);
                        }});


            triangle.addActionListener( new ActionListener(){
                public void actionPerformed(ActionEvent e){
                           c.set_mod(1);
                           c.set_action(0); }});


            forme.getOrientation();


            forme.add(cercle);
            forme.add(triangle);
            forme.add(carrer);
            forme.add(ligne);
           
            
            return forme;
            
            
            }






            
      public JToolBar barreoutils(){   //la fonction qui me retourne la barre d'outils à gauche
        JToolBar forme= new JToolBar();
        forme.setFloatable(false);
        
        JSlider slider = new JSlider(0,10,2);
        slider.setPaintTrack(true); 
        slider.setPaintTicks(true); 
        slider.setPaintLabels(true); 
        slider.setMajorTickSpacing(2); 
        slider.setMinorTickSpacing(1); 
        slider.addChangeListener(new ChangeListener(){  //changer l'epaisseur d'une forme
          public   void	stateChanged( ChangeEvent e){
         c.set_mod(0);
         c.set_slider(slider.getValue());
         c.set_action(7);
            } });
         
       
        JButton couleur= new JButton( new ImageIcon( "icons/p.png" ));
        fill= new JCheckBox("fill");
        fill.addActionListener(new ActionListener(){  //remplir la forme
           public void actionPerformed( ActionEvent e ){
            c.set_fill(fill.isSelected());
            c.set_action(6);
            c.set_mod(0);


      }
     });

        p= new JCheckBox("pointille");
        p.addActionListener(new ActionListener(){    //mettre la forme en pointillé
        public void actionPerformed( ActionEvent e){
        c.set_p(p.isSelected());
        c.set_mod(0);
        c.set_action(5);

     } });
       JButton delete=new JButton(new ImageIcon( "icons/delete.png" ));    
       JButton move =new JButton(new ImageIcon( "icons/move.png" ));
       JButton redimensionner =new JButton(new ImageIcon( "icons/d.png" ));
       JButton delete_t =new JButton(new ImageIcon( "icons/delete_t.png" ));

       couleur.addActionListener( new ActionListener(){  //changer la couleur de ma forme
        public void actionPerformed(ActionEvent e){      
             Color init =Color.BLUE;
             
           c.set_color(JColorChooser.showDialog(c,"choisir une color", init));
           c.set_mod(0);
           c.set_action(4);
          
            }
    });
         
        delete.addActionListener( new ActionListener(){   //corbeille gomme
            public void actionPerformed(ActionEvent e){
                       c.set_action(1); 
                        c.set_mod(0);}});
       delete_t.addActionListener( new ActionListener(){  //supprimer tout sans pouvoir les recuperer apres
           public void actionPerformed(ActionEvent e){
            c.set_action(23); 
            c.set_mod(0);
            c.verify(); }}); 
                        

 
        move.addActionListener( new ActionListener(){  //le boutton pour faire bouger mes forme
            public void actionPerformed(ActionEvent e){
                       c.set_action(2); 
                        c.set_mod(0);}});

        redimensionner.addActionListener( new ActionListener(){  //changer la taille et redimensionner mes formes
            public void actionPerformed(ActionEvent e){
                       c.set_action(3); 
                        c.set_mod(0);}});
        
    
        


      
        forme.add(couleur);
        forme.add(delete);
        forme.add(fill);
        forme.add(p);
        forme.add(slider);
        forme.add(delete_t);
        forme.add(delete);
        forme.add(redimensionner);
        forme.add(move);
     
        return forme;
         }

     
}


