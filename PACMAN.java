//in collabaration with benjamin levesky;
// made by Samuel Shokodko
import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;
import javax.swing.*;

public class PACMAN extends Applet implements ActionListener,KeyListener, MouseListener
{
    private int pacx,pacy; //starting value of pacman
    private Timer timer;
    private int counter=2;
    private int level=1; // the different levels
    private int whichway;
    private int blueghostx,blueghosty; //starting value of blue ghost
    private int pinkghostx,pinkghosty; // starting value of pink ghost
    private int orangeghostx, orangeghosty; // starting value of orange ghost
    private int redghostx, redghosty; // starting value of red ghost
    private int whiteghostx, whiteghosty; // starting value of white ghost
    private int yellowghostx, yellowghosty; // starting value of yellow ghost
    private int greenghostx, greenghosty; // starting value of green ghost
    private int purpleghostx, purpleghosty; // starting value of purple ghost
    private int pinkyInc,pinkxInc,bluexInc,blueyInc,orangexInc,orangeyInc,redxInc,redyInc,whitexInc,whiteyInc,yellowxInc,yellowyInc,greenyInc,greenxInc,purplexInc,purpleyInc; // increments of ghosts
    private int gowhere; //where the ghosts move randomly

    private Image image, image1, image2, image3;
    private double time, time1, time2, starttime;// time for level one,for lwvel two,level three,too start next level
    int x=-200;
    int y=-200;
    int pacman;
    public void init()
    { 

        pacx=225;  //original position of the x
        pacy=250; //original position of the y
        blueghostx=480;
        blueghosty=0;
        pinkghostx=20;
        time=0;
        time1=0;
        time2=0;
        starttime=0;
        pinkghosty=0;
        orangeghostx=20;
        orangeghosty=460;
        redghostx=480;
        redghosty=460;
        whiteghostx=20;
        whiteghosty=240;
        yellowghostx=480;
        yellowghosty=240; // starting value of yellow ghost
        greenghosty=0; 
        greenghostx=240; // starting value of green ghost
        purpleghostx=240;
        purpleghosty=460; // starting value of purple ghost
        timer=new Timer(10,this);
        timer.start();
        //timer1=new Timer(10,this);
        //timer.start();
        addKeyListener(this);
        addMouseListener(this);
        requestFocus();
        setBackground(Color.BLACK);
        image=getImage(getDocumentBase(),"1360124243.png");
        image1=getImage(getDocumentBase(),"ghost1.png");
        image2=getImage(getDocumentBase(),"Pinkyyghost.png");
        image3=getImage(getDocumentBase(),"gameover.png");
    }

    public void mouseExited(MouseEvent me)
    {

    }

    public void mouseEntered(MouseEvent me)
    {

    }

    public void mouseReleased(MouseEvent me)
    {

    }

    public void mousePressed(MouseEvent me)
    {

    }

    public void mouseClicked(MouseEvent me)
    {
        x=me.getX();
        y=me.getY();
        repaint();
    }

    public void keyReleased(KeyEvent evt)
    {

    }

    public void keyPressed(KeyEvent evt)
    {
        pacman=evt.getKeyCode();
        switch(pacman){

            case(KeyEvent.VK_RIGHT):
            counter=0;
            pacx+=5;
            whichway=1;
            break;
            case(KeyEvent.VK_LEFT):
            pacx-=5;
            whichway=2;
            counter=0;
            break;
            case(KeyEvent.VK_UP):
            pacy-=5;
            whichway=3;
            counter=0;
            break;
            case(KeyEvent.VK_DOWN):
            pacy+=5;
            whichway=4;
            counter=0;
            break;
            case(KeyEvent.VK_ESCAPE):
            level=3;
            pacx=225;
            pacy=250;
            blueghostx=480;
            blueghosty=0;
            pinkghostx=20;
            pinkghosty=0;
            orangeghostx=20;
            orangeghosty=460;
            redghostx=480;
            redghosty=460;
            time=0;
            break;
        }

    }

    public void keyTyped(KeyEvent evt)
    {

    }

    public void actionPerformed(ActionEvent ae){
        repaint();
    } 

    public void paint(Graphics g)
    {

        if(level==1){
            setBackground(Color.WHITE);
            g.drawImage(image,80,220,200,180,this);
            g.drawImage(image1,320,60,80,80,this);
            g.drawImage(image2,400,140,80,80,this);
            g.setFont(new Font("default",Font.BOLD,30));
            g.setColor(Color.CYAN);
            g.drawString("Welcome to Pacman",20,30);
            g.drawString("Click anywhere to go to",20,60);
            g.drawString("the next page",40,90);
            if(x>=0 && x<=500 && y>=0 && y<=500){
                level=2;
            }
        }
        if(level==2){
            setBackground(Color.BLACK);
            g.setFont(new Font("default",Font.BOLD,30));
            g.setColor(Color.WHITE);
            g.drawString("Welcome to Pacman",75,50);
            g.setFont(new Font("default",Font.BOLD,15));
            g.setColor(Color.RED);
            g.drawString("1. Use arrow keys Up, Down, Right, Left to move the Pacman",20,100);
            g.drawString("2. Avoid the ghosts to win",20,125);
            g.drawString("3. First level, survive for ten seconds",20,150);
            g.drawString("4. Second level, survive for a twenty seconds",20,175);
            g.drawString("5. Third level, survive for thirty seconds",20,200);
            g.drawString("P.S. The level changes are quick, be ready",50,225);
            g.setFont(new Font("default",Font.BOLD,20));
            g.setColor(Color.MAGENTA);
            g.drawString("CLICK ESCAPE TO PLAY THE GAME",65,300);
        }

        if(level==3){
            if(counter==0){     //alternating pacman
                if(whichway==1){//face right
                    g.setColor(Color.YELLOW);       
                    g.fillArc(pacx,pacy,30,30,20,320);   //pacman facing right
                    g.setColor(Color.BLACK);      //color of eye
                    g.fillOval(pacx+15,pacy+6,2,2);     // eyeball
                }
                else if(whichway==2){// face left
                    g.setColor(Color.YELLOW);
                    g.fillArc(pacx,pacy,30,30,200,320);  //pacman facing left
                    g.setColor(Color.BLACK);      //color of the eye
                    g.fillOval(pacx+15,pacy+6,2,2);    //eyeball
                }
                else if(whichway==3){// face up
                    g.setColor(Color.YELLOW);
                    g.fillArc(pacx,pacy,30,30,110,310);  //pacman facing left
                    g.setColor(Color.BLACK);      //color of the eye
                    g.fillOval(pacx+22,pacy+20,2,2);    //eyeball
                }
                else if(whichway==4){// face down
                    g.setColor(Color.YELLOW);
                    g.fillArc(pacx,pacy,30,30,310,290);  //pacman facing left
                    g.setColor(Color.BLACK);      //color of the eye
                    g.fillOval(pacx+22,pacy+8,2,2);    //eyeball
                }
            }   
            else{
                g.setColor(Color.YELLOW);
                g.fillOval(pacx,pacy,30,30);    //closed mouth
                g.setColor(Color.BLACK);       //color of eye
                g.fillOval(pacx+19,pacy+8,2,2);   //eyeball
            }
            setBackground(Color.BLACK);
            g.setColor(Color.WHITE);
            g.fillRect(200,200,20,80);
            g.fillRect(260,200,20,80);
            g.fillRect(40,160,60,160);
            g.fillRect(140,160,80,40);
            g.fillRect(140,200,60,80);
            g.fillRect(140,280,80,40);
            g.fillRect(380,160,80,160);
            g.fillRect(260,160,80,40);
            g.fillRect(280,200,60,80);
            g.fillRect(260,280,80,40);
            g.fillRect(40,360,60,100);
            g.fillRect(140,360,80,100);
            g.fillRect(260,360,80,100);
            g.fillRect(380,360,80,100);
            g.fillRect(40,40,60,80);
            g.fillRect(140,40,80,80);
            g.fillRect(260,40,80,80);
            g.fillRect(380,40,80,80);
            g.setColor(Color.BLUE);
            Polygon blueGhost=new Polygon();
            blueGhost.addPoint(blueghostx,blueghosty);
            blueGhost.addPoint(blueghostx+20,blueghosty+10);
            blueGhost.addPoint(blueghostx+10,blueghosty+40);
            blueGhost.addPoint(blueghostx,blueghosty+20);
            blueGhost.addPoint(blueghostx-10,blueghosty+40);
            blueGhost.addPoint(blueghostx-20,blueghosty+10);
            g.fillPolygon(blueGhost);
            g.setColor(Color.PINK);
            Polygon pinkGhost=new Polygon();
            pinkGhost.addPoint(pinkghostx,pinkghosty);
            pinkGhost.addPoint(pinkghostx+20,pinkghosty+10);
            pinkGhost.addPoint(pinkghostx+10,pinkghosty+40);
            pinkGhost.addPoint(pinkghostx,pinkghosty+20);
            pinkGhost.addPoint(pinkghostx-10,pinkghosty+40);
            pinkGhost.addPoint(pinkghostx-20,pinkghosty+10);
            g.fillPolygon(pinkGhost);
            g.setColor(Color.ORANGE);
            Polygon orangeGhost=new Polygon();
            orangeGhost.addPoint(orangeghostx,orangeghosty);
            orangeGhost.addPoint(orangeghostx+20,orangeghosty+10);
            orangeGhost.addPoint(orangeghostx+10,orangeghosty+40);
            orangeGhost.addPoint(orangeghostx,orangeghosty+20);
            orangeGhost.addPoint(orangeghostx-10,orangeghosty+40);
            orangeGhost.addPoint(orangeghostx-20,orangeghosty+10);
            g.fillPolygon(orangeGhost);
            g.setColor(Color.RED);
            Polygon redGhost=new Polygon();
            redGhost.addPoint(redghostx,redghosty);
            redGhost.addPoint(redghostx+20,redghosty+10);
            redGhost.addPoint(redghostx+10,redghosty+40);
            redGhost.addPoint(redghostx,redghosty+20);
            redGhost.addPoint(redghostx-10,redghosty+40);
            redGhost.addPoint(redghostx-20,redghosty+10);
            g.fillPolygon(redGhost);
            g.setColor(Color.BLACK);
            g.fillOval(pinkghostx-10,pinkghosty+10,5,5);// left eye of pink ghost
            g.fillOval(pinkghostx+5,pinkghosty+10,5,5);// right eye of pink ghost
            g.fillOval(blueghostx-10,blueghosty+10,5,5);// left eye of blue ghost
            g.fillOval(blueghostx+5,blueghosty+10,5,5);// right eye of blue ghost
            g.fillOval(orangeghostx-10,orangeghosty+10,5,5);// left eye of orange ghost
            g.fillOval(orangeghostx+5,orangeghosty+10,5,5);// right eye of orange ghost
            g.fillOval(redghostx-10,redghosty+10,5,5);// left eye of red ghost
            g.fillOval(redghostx+5,redghosty+10,5,5);// right eye of red ghost
            g.setFont(new Font("default",Font.BOLD,10));        
            g.drawString("timer="+time,150,180);        
            time+=.01;
            time=(int)(time*100+.5)/100.0;
            g.drawString("Pacx="+pacx,400,420);
            g.drawString("Pacy="+pacy,400,440);
            if(level==3 && time>11){
                pacx=225;
                pacy=225;
                level=5;
                blueghostx=480;
                blueghosty=0;
                pinkghostx=20;
                pinkghosty=0;
                orangeghostx=20;
                orangeghosty=460;
                redghostx=480;
                redghosty=460;
                starttime=0;
            }
            //ghost collisons
            if(Math.abs(pacx-(blueghostx))<=35 && Math.abs(pacy-blueghosty)<35){
                level=4;

            }
            if(Math.abs(pacx-(pinkghostx))<=35 && Math.abs(pacy-pinkghosty)<35){
                level=4;
            }
            if(Math.abs(pacx-(orangeghostx))<=35 && Math.abs(pacy-orangeghosty)<35){
                level=4;
            }
            if(Math.abs(pacx-(redghostx))<=35 && Math.abs(pacy-redghosty)<35){
                level=4;
            }

            //paramters for walls
            if(pacy>470){
                pacy-=5;
            }
            if(pacy<0){
                pacy+=5;
            }
            if(pacx<0){
                pacx+=5;
            }
            if(pacx>470){
                pacx-=5;
            }
            if(pacx>15 && pacx<95 && pacy==15){
                pacy-=5;
            }
            if(pacx>15 && pacx<95 && pacy==315){
                pacy+=5;
            }
            if(pacy>15 && pacy<115 && pacx==15){
                pacx-=5;
            }
            if(pacx>15 && pacx<95 && pacy==115){
                pacy+=5;
            }
            if(pacy>15 && pacy<115 && pacx==95){
                pacx+=5;
            }
            if(pacx>115 && pacx<215 && pacy==15){
                pacy-=5;
            }
            if(pacy>15 && pacy<115 && pacx==115){
                pacx-=5;
            }
            if(pacy>15 && pacy<115 && pacx==215){
                pacx+=5;
            }
            if(pacx>115 && pacx<215 && pacy==115){
                pacy+=5;
            }
            if(pacx>235 && pacx<335 && pacy==115){
                pacy+=5;
            }
            if(pacx>355 && pacx<455 && pacy==115){
                pacy+=5;
            }
            if(pacy>15 && pacy<115 && pacx==235){
                pacx-=5;
            }
            if(pacy>15 && pacy<115 && pacx==355){
                pacx-=5;
            }
            if(pacx>235 && pacx<335 && pacy==15){
                pacy-=5;
            }
            if(pacx>355 && pacx<455 && pacy==15){
                pacy-=5;
            }
            if(pacy>15 && pacy<115 && pacx==335){
                pacx+=5;
            }
            if(pacy>15 && pacy<115 && pacx==455){
                pacx+=5;
            }
            if(pacy>135 && pacy<315 && pacx==15){
                pacx-=5;
            }
            if(pacy>135 && pacy<315 && pacx==115){
                pacx-=5;
            }
            if(pacy>135 && pacy<315 && pacx==235){
                pacx-=5;
            }
            if(pacy>135 && pacy<315 && pacx==355){
                pacx-=5;
            }
            if(pacx>15 && pacx<95 && pacy==135){
                pacy-=5;
            }
            if(pacx>115 && pacx<215 && pacy==135){
                pacy-=5;
            }
            if(pacx>235 && pacx<335 && pacy==135){
                pacy-=5;
            }
            if(pacx>355 && pacx<455 && pacy==135){
                pacy-=5;
            }
            if(pacy>135 && pacy<315 && pacx==95){
                pacx+=5;
            }
            if(pacy>135 && pacy<315 && pacx==215){
                pacx+=5;
            }
            if(pacy>135 && pacy<315 && pacx==335){
                pacx+=5;
            }
            if(pacy>135 && pacy<315 && pacx==455){
                pacx+=5;
            }
            if(pacx>115 && pacx<215 && pacy==315){
                pacy+=5;
            }
            if(pacx>235 && pacx<335 && pacy==315){
                pacy+=5;
            }
            if(pacx>355 && pacx<455 && pacy==315){
                pacy+=5;
            }
            if(pacy>335 && pacy<455 && pacx==15){
                pacx-=5;
            }
            if(pacy>335 && pacy<455 && pacx==115){
                pacx-=5;
            }
            if(pacy>335 && pacy<455 && pacx==235){
                pacx-=5;
            }
            if(pacy>335 && pacy<455 && pacx==355){
                pacx-=5;
            }
            if(pacy>335 && pacy<455 && pacx==95){
                pacx+=5;
            }
            if(pacy>335 && pacy<455 && pacx==215){
                pacx+=5;
            }
            if(pacy>335 && pacy<455 && pacx==455){
                pacx+=5;
            }
            if(pacx>15 && pacx<95 && pacy==335){
                pacy-=5;
            }
            if(pacx>115 && pacx<215 && pacy==335){
                pacy-=5;
            }
            if(pacx>235 && pacx<340 && pacy==335){
                pacy-=5;
            }
            if(pacx>355 && pacx<455 && pacy==335){
                pacy-=5;
            }
            if(pacx>15 && pacx<95 && pacy==455){
                pacy+=5;
            }
            if(pacx>115 && pacx<215 && pacy==455){
                pacy+=5;
            }
            if(pacx>235 && pacx<335 && pacy==455){
                pacy+=5;
            }
            if(pacy>335 && pacy<455 && pacx==335){
                pacx+=5;
            }
            if(pacx>355 && pacx<455 && pacy==455){
                pacy+=5;
            }
            starttime+=.01;
            if(starttime>=1){

                //random movement for pink ghost at every intersection
                if(pinkghostx==20 && pinkghostx+20<=40 && pinkghosty==0 && pinkghosty+40<=40){
                    gowhere=(int)(Math.random()*2+1);
                    if(gowhere==1){
                        pinkxInc=2;
                        pinkyInc=0;

                    }
                    else if(gowhere==2){
                        pinkxInc=0;
                        pinkyInc=2;

                    }

                }
                if(pinkghostx-20==100 && pinkghostx+20<=140 && pinkghosty==0 && pinkghosty+40<=40){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        pinkxInc=2;
                        pinkyInc=0;

                    }
                    else if(gowhere==2){
                        pinkxInc=0;
                        pinkyInc=2;

                    }
                    else if(gowhere==3){
                        pinkxInc=-2;
                        pinkyInc=0;

                    }

                }
                if(pinkghostx-20==220 && pinkghostx+20<=260 && pinkghosty==0 && pinkghosty+40<=40){
                    gowhere=(int)(Math.random()*3+1);

                    if(gowhere==1){
                        pinkxInc=2;
                        pinkyInc=0;

                    }
                    else if(gowhere==2){
                        pinkxInc=0;
                        pinkyInc=2;

                    }
                    else if(gowhere==3){
                        pinkxInc=-2;
                        pinkyInc=0;

                    }

                }
                if(pinkghostx-20==340 && pinkghostx+20<=380 && pinkghosty==0 && pinkghosty+40<=40){
                    gowhere=(int)(Math.random()*3+1);

                    if(gowhere==1){
                        pinkxInc=2;
                        pinkyInc=0;

                    }
                    else if(gowhere==2){
                        pinkxInc=0;
                        pinkyInc=2;

                    }
                    else if(gowhere==3){
                        pinkxInc=-2;
                        pinkyInc=0;

                    }

                }
                if(pinkghostx==480 && pinkghostx+20<=500 && pinkghosty==0 && pinkghosty+40<=40){
                    gowhere=(int)(Math.random()*2+1);
                    if(gowhere==1){
                        pinkxInc=-2;
                        pinkyInc=0;

                    }
                    else if(gowhere==2){
                        pinkxInc=0;
                        pinkyInc=2;

                    }

                }
                if(pinkghostx-20==0 && pinkghostx+20<=40 && pinkghosty==120 && pinkghosty+40<=160){
                    gowhere=(int)(Math.random()*3+1);

                    if(gowhere==1){
                        pinkxInc=2;
                        pinkyInc=0;

                    }
                    else if(gowhere==2){
                        pinkxInc=0;
                        pinkyInc=2;

                    }
                    else if(gowhere==3){
                        pinkxInc=0;
                        pinkyInc=2;

                    }

                }
                if(pinkghostx-20==100 && pinkghostx+20<=140 && pinkghosty==120 && pinkghosty+40<=160){
                    gowhere=(int)(Math.random()*4+1);

                    if(gowhere==1){
                        pinkxInc=2;
                        pinkyInc=0;

                    }
                    else if(gowhere==2){
                        pinkxInc=0;
                        pinkyInc=2;

                    }
                    else if(gowhere==3){
                        pinkxInc=-2;
                        pinkyInc=0;

                    }
                    else if(gowhere==4){
                        pinkxInc=0;
                        pinkyInc=-2;

                    }

                }
                if(pinkghostx-20==220 && pinkghostx+20<=260 && pinkghosty==120 && pinkghosty+40<=160){
                    gowhere=(int)(Math.random()*4+1);

                    if(gowhere==1){
                        pinkxInc=2;
                        pinkyInc=0;

                    }
                    else if(gowhere==2){
                        pinkxInc=0;
                        pinkyInc=2;

                    }
                    else if(gowhere==3){
                        pinkxInc=-2;
                        pinkyInc=0;

                    }
                    else if(gowhere==4){
                        pinkxInc=0;
                        pinkyInc=-2;

                    }

                }
                if(pinkghostx-20==340 && pinkghostx+20<=380 && pinkghosty==120 && pinkghosty+40<=160){
                    gowhere=(int)(Math.random()*4+1);

                    if(gowhere==1){
                        pinkxInc=2;
                        pinkyInc=0;

                    }
                    else if(gowhere==2){
                        pinkxInc=0;
                        pinkyInc=2;

                    }
                    else if(gowhere==3){
                        pinkxInc=-2;
                        pinkyInc=0;

                    }
                    else if(gowhere==4){
                        pinkxInc=0;
                        pinkyInc=-2;

                    }

                }
                if(pinkghostx==480 && pinkghostx+20<=500 && pinkghosty==120 && pinkghosty+40<=160){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        pinkxInc=-2;
                        pinkyInc=0;

                    }
                    else if(gowhere==2){
                        pinkxInc=0;
                        pinkyInc=2;

                    }
                    else if(gowhere==3){
                        pinkxInc=0;
                        pinkyInc=2;

                    }

                }
                if(pinkghostx-20==0 && pinkghostx+20<=40 && pinkghosty==320 && pinkghosty+40<=360){
                    gowhere=(int)(Math.random()*3+1);

                    if(gowhere==1){
                        pinkxInc=2;
                        pinkyInc=0;

                    }
                    else if(gowhere==2){
                        pinkxInc=0;
                        pinkyInc=2;

                    }
                    else if(gowhere==3){
                        pinkxInc=0;
                        pinkyInc=2;

                    }

                }
                if(pinkghostx-20==100 && pinkghostx+20<=140 && pinkghosty==320 && pinkghosty+40<=360){
                    gowhere=(int)(Math.random()*4+1);

                    if(gowhere==1){
                        pinkxInc=2;
                        pinkyInc=0;

                    }
                    else if(gowhere==2){
                        pinkxInc=0;
                        pinkyInc=2;

                    }
                    else if(gowhere==3){
                        pinkxInc=-2;
                        pinkyInc=0;

                    }
                    else if(gowhere==4){
                        pinkxInc=0;
                        pinkyInc=-2;

                    }

                }
                if(pinkghostx-20==220 && pinkghostx+20<=260 && pinkghosty==320 && pinkghosty+40<=360){
                    gowhere=(int)(Math.random()*4+1);

                    if(gowhere==1){
                        pinkxInc=2;
                        pinkyInc=0;

                    }
                    else if(gowhere==2){
                        pinkxInc=0;
                        pinkyInc=2;

                    }
                    else if(gowhere==3){
                        pinkxInc=-2;
                        pinkyInc=0;

                    }
                    else if(gowhere==4){
                        pinkxInc=0;
                        pinkyInc=-2;

                    }

                }
                if(pinkghostx-20==340 && pinkghostx+20<=380 && pinkghosty==320 && pinkghosty+40<=360){
                    gowhere=(int)(Math.random()*4+1);

                    if(gowhere==1){
                        pinkxInc=2;
                        pinkyInc=0;

                    }
                    else if(gowhere==2){
                        pinkxInc=0;
                        pinkyInc=2;

                    }
                    else if(gowhere==3){
                        pinkxInc=-2;
                        pinkyInc=0;

                    }
                    else if(gowhere==4){
                        pinkxInc=0;
                        pinkyInc=-2;

                    }

                }
                if(pinkghostx==480 && pinkghostx+20<=500 && pinkghosty==320 && pinkghosty+40<=360){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        pinkxInc=-2;
                        pinkyInc=0;

                    }
                    else if(gowhere==2){
                        pinkxInc=0;
                        pinkyInc=2;

                    }
                    else if(gowhere==3){
                        pinkxInc=0;
                        pinkyInc=2;

                    }

                }
                if(pinkghostx==20 && pinkghostx+20<=40 && pinkghosty==460 && pinkghosty+40<=500){
                    gowhere=(int)(Math.random()*2+1);
                    if(gowhere==1){
                        pinkxInc=2;
                        pinkyInc=0;

                    }
                    else if(gowhere==2){
                        pinkxInc=0;
                        pinkyInc=-2;

                    }

                }
                if(pinkghostx-20==100 && pinkghostx+20<=140 && pinkghosty==460 && pinkghosty+40<=500){
                    gowhere=(int)(Math.random()*3+1);

                    if(gowhere==1){
                        pinkxInc=2;
                        pinkyInc=0;

                    }
                    else if(gowhere==2){
                        pinkxInc=0;
                        pinkyInc=-2;

                    }
                    else if(gowhere==3){
                        pinkxInc=-2;
                        pinkyInc=0;

                    }

                }
                if(pinkghostx-20==220 && pinkghostx+20<=260 && pinkghosty==460 && pinkghosty+40<=500){
                    gowhere=(int)(Math.random()*3+1);

                    if(gowhere==1){
                        pinkxInc=2;
                        pinkyInc=0;

                    }
                    else if(gowhere==2){
                        pinkxInc=0;
                        pinkyInc=-2;

                    }
                    else if(gowhere==3){
                        pinkxInc=-2;
                        pinkyInc=0;

                    }

                }
                if(pinkghostx-20==340 && pinkghostx+20<=380 && pinkghosty==460 && pinkghosty+40<=500){
                    gowhere=(int)(Math.random()*3+1);

                    if(gowhere==1){
                        pinkxInc=2;
                        pinkyInc=0;

                    }
                    else if(gowhere==2){
                        pinkxInc=0;
                        pinkyInc=-2;

                    }
                    else if(gowhere==3){
                        pinkxInc=-2;
                        pinkyInc=0;

                    }

                }
                if(pinkghostx==480 && pinkghostx+20<=500 && pinkghosty==460 && pinkghosty+40<=500){
                    gowhere=(int)(Math.random()*2+1);
                    if(gowhere==1){
                        pinkxInc=-2;
                        pinkyInc=0;

                    }
                    else if(gowhere==2){
                        pinkxInc=0;
                        pinkyInc=-2;

                    }

                }
                if(blueghostx==20 && blueghostx+20<=40 && blueghosty==0 && blueghosty+40<=40){
                    gowhere=(int)(Math.random()*2+1);
                    if(gowhere==1){
                        bluexInc=2;
                        blueyInc=0;

                    }
                    else if(gowhere==2){
                        bluexInc=0;
                        blueyInc=2;

                    }

                }
                if(blueghostx-20==100 && blueghostx+20<=140 && blueghosty==0 && blueghosty+40<=40){
                    gowhere=(int)(Math.random()*3+1);

                    if(gowhere==1){
                        bluexInc=2;
                        blueyInc=0;

                    }
                    else if(gowhere==2){
                        bluexInc=0;
                        blueyInc=2;

                    }
                    else if(gowhere==3){
                        bluexInc=-2;
                        blueyInc=0;

                    }

                }
                if(blueghostx-20==220 && blueghostx+20<=260 && blueghosty==0 && blueghosty+40<=40){
                    gowhere=(int)(Math.random()*3+1);

                    if(gowhere==1){
                        bluexInc=2;
                        blueyInc=0;

                    }
                    else if(gowhere==2){
                        bluexInc=0;
                        blueyInc=2;

                    }
                    else if(gowhere==3){
                        bluexInc=-2;
                        blueyInc=0;

                    }

                }
                if(blueghostx-20==340 && blueghostx+20<=380 && blueghosty==0 && blueghosty+40<=40){
                    gowhere=(int)(Math.random()*3+1);

                    if(gowhere==1){
                        bluexInc=2;
                        blueyInc=0;

                    }
                    else if(gowhere==2){
                        bluexInc=0;
                        blueyInc=2;

                    }
                    else if(gowhere==3){
                        bluexInc=-2;
                        blueyInc=0;

                    }

                }
                if(blueghostx==480 && blueghostx+20<=500 && blueghosty==0 && blueghosty+40<=40){
                    gowhere=(int)(Math.random()*2+1);
                    if(gowhere==1){
                        bluexInc=-2;
                        blueyInc=0;

                    }
                    else if(gowhere==2){
                        bluexInc=0;
                        blueyInc=2;

                    }

                }
                if(blueghostx-20==0 && blueghostx+20<=40 && blueghosty==120 && blueghosty+40<=160){
                    gowhere=(int)(Math.random()*3+1);

                    if(gowhere==1){
                        bluexInc=2;
                        blueyInc=0;

                    }
                    else if(gowhere==2){
                        bluexInc=0;
                        blueyInc=2;

                    }
                    else if(gowhere==3){
                        bluexInc=0;
                        blueyInc=2;

                    }

                }
                if(blueghostx-20==100 && blueghostx+20<=140 && blueghosty==120 && blueghosty+40<=160){
                    gowhere=(int)(Math.random()*4+1);

                    if(gowhere==1){
                        bluexInc=2;
                        blueyInc=0;

                    }
                    else if(gowhere==2){
                        bluexInc=0;
                        blueyInc=2;

                    }
                    else if(gowhere==3){
                        bluexInc=-2;
                        blueyInc=0;

                    }
                    else if(gowhere==4){
                        bluexInc=0;
                        blueyInc=-2;

                    }

                }
                if(blueghostx-20==220 && blueghostx+20<=260 && blueghosty==120 && blueghosty+40<=160){
                    gowhere=(int)(Math.random()*4+1);

                    if(gowhere==1){
                        bluexInc=2;
                        blueyInc=0;

                    }
                    else if(gowhere==2){
                        bluexInc=0;
                        blueyInc=2;

                    }
                    else if(gowhere==3){
                        bluexInc=-2;
                        blueyInc=0;

                    }
                    else if(gowhere==4){
                        bluexInc=0;
                        blueyInc=-2;

                    }

                }
                if(blueghostx-20==340 && blueghostx+20<=380 && blueghosty==120 && blueghosty+40<=160){
                    gowhere=(int)(Math.random()*4+1);

                    if(gowhere==1){
                        bluexInc=2;
                        blueyInc=0;

                    }
                    else if(gowhere==2){
                        bluexInc=0;
                        blueyInc=2;

                    }
                    else if(gowhere==3){
                        bluexInc=-2;
                        blueyInc=0;

                    }
                    else if(gowhere==4){
                        bluexInc=0;
                        blueyInc=-2;

                    }

                }
                if(blueghostx==480 && blueghostx+20<=500 && blueghosty==120 && blueghosty+40<=160){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        bluexInc=-2;
                        blueyInc=0;

                    }
                    else if(gowhere==2){
                        bluexInc=0;
                        blueyInc=2;

                    }
                    else if(gowhere==3){
                        bluexInc=0;
                        blueyInc=2;

                    }

                }
                if(blueghostx-20==0 && blueghostx+20<=40 && blueghosty==320 && blueghosty+40<=360){
                    gowhere=(int)(Math.random()*3+1);

                    if(gowhere==1){
                        bluexInc=2;
                        blueyInc=0;

                    }
                    else if(gowhere==2){
                        bluexInc=0;
                        blueyInc=2;

                    }
                    else if(gowhere==3){
                        bluexInc=0;
                        blueyInc=2;

                    }

                }
                if(blueghostx-20==100 && blueghostx+20<=140 && blueghosty==320 && blueghosty+40<=360){
                    gowhere=(int)(Math.random()*4+1);

                    if(gowhere==1){
                        bluexInc=2;
                        blueyInc=0;

                    }
                    else if(gowhere==2){
                        bluexInc=0;
                        blueyInc=2;

                    }
                    else if(gowhere==3){
                        bluexInc=-2;
                        blueyInc=0;

                    }
                    else if(gowhere==4){
                        bluexInc=0;
                        blueyInc=-2;

                    }

                }
                if(blueghostx-20==220 && blueghostx+20<=260 && blueghosty==320 && blueghosty+40<=360){
                    gowhere=(int)(Math.random()*4+1);

                    if(gowhere==1){
                        bluexInc=2;
                        blueyInc=0;

                    }
                    else if(gowhere==2){
                        bluexInc=0;
                        blueyInc=2;

                    }
                    else if(gowhere==3){
                        bluexInc=-2;
                        blueyInc=0;

                    }
                    else if(gowhere==4){
                        bluexInc=0;
                        blueyInc=-2;

                    }

                }
                if(blueghostx-20==340 && blueghostx+20<=380 && blueghosty==320 && blueghosty+40<=360){
                    gowhere=(int)(Math.random()*4+1);

                    if(gowhere==1){
                        bluexInc=2;
                        blueyInc=0;

                    }
                    else if(gowhere==2){
                        bluexInc=0;
                        blueyInc=2;

                    }
                    else if(gowhere==3){
                        bluexInc=-2;
                        blueyInc=0;

                    }
                    else if(gowhere==4){
                        bluexInc=0;
                        blueyInc=-2;

                    }

                }
                if(blueghostx==480 && blueghostx+20<=500 && blueghosty==320 && blueghosty+40<=360){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        bluexInc=-2;
                        blueyInc=0;

                    }
                    else if(gowhere==2){
                        bluexInc=0;
                        blueyInc=2;

                    }
                    else if(gowhere==3){
                        bluexInc=0;
                        blueyInc=2;

                    }

                }
                if(blueghostx==20 && blueghostx+20<=40 && blueghosty==460 && blueghosty+40<=500){
                    gowhere=(int)(Math.random()*2+1);
                    if(gowhere==1){
                        bluexInc=2;
                        blueyInc=0;

                    }
                    else if(gowhere==2){
                        bluexInc=0;
                        blueyInc=-2;

                    }

                }
                if(blueghostx-20==100 && blueghostx+20<=140 && blueghosty==460 && blueghosty+40<=500){
                    gowhere=(int)(Math.random()*3+1);

                    if(gowhere==1){
                        bluexInc=2;
                        blueyInc=0;

                    }
                    else if(gowhere==2){
                        bluexInc=0;
                        blueyInc=-2;

                    }
                    else if(gowhere==3){
                        bluexInc=-2;
                        blueyInc=0;

                    }

                }
                if(blueghostx-20==220 && blueghostx+20<=260 && blueghosty==460 && blueghosty+40<=500){
                    gowhere=(int)(Math.random()*3+1);

                    if(gowhere==1){
                        bluexInc=2;
                        blueyInc=0;

                    }
                    else if(gowhere==2){
                        bluexInc=0;
                        blueyInc=-2;

                    }
                    else if(gowhere==3){
                        bluexInc=-2;
                        blueyInc=0;

                    }

                }
                if(blueghostx-20==340 && blueghostx+20<=380 && blueghosty==460 && blueghosty+40<=500){
                    gowhere=(int)(Math.random()*3+1);

                    if(gowhere==1){
                        bluexInc=2;
                        blueyInc=0;

                    }
                    else if(gowhere==2){
                        bluexInc=0;
                        blueyInc=-2;

                    }
                    else if(gowhere==3){
                        bluexInc=-2;
                        blueyInc=0;

                    }

                }
                if(blueghostx==480 && blueghostx+20<=500 && blueghosty==460 && blueghosty+40<=500){
                    gowhere=(int)(Math.random()*2+1);
                    if(gowhere==1){
                        bluexInc=-2;
                        blueyInc=0;

                    }
                    else if(gowhere==2){
                        bluexInc=0;
                        blueyInc=-2;

                    }

                }if(orangeghostx==20 && orangeghostx+20<=40 && orangeghosty==0 && orangeghosty+40<=40){
                    gowhere=(int)(Math.random()*2+1);
                    if(gowhere==1){
                        orangexInc=2;
                        orangeyInc=0;

                    }
                    else if(gowhere==2){
                        orangexInc=0;
                        orangeyInc=2;

                    }

                }
                if(orangeghostx-20==100 && orangeghostx+20<=140 && orangeghosty==0 && orangeghosty+40<=40){
                    gowhere=(int)(Math.random()*3+1);

                    if(gowhere==1){
                        orangexInc=2;
                        orangeyInc=0;

                    }
                    else if(gowhere==2){
                        orangexInc=0;
                        orangeyInc=2;

                    }
                    else if(gowhere==3){
                        orangexInc=-2;
                        orangeyInc=0;

                    }

                }
                if(orangeghostx-20==220 && orangeghostx+20<=260 && orangeghosty==0 && orangeghosty+40<=40){
                    gowhere=(int)(Math.random()*3+1);

                    if(gowhere==1){
                        orangexInc=2;
                        orangeyInc=0;

                    }
                    else if(gowhere==2){
                        orangexInc=0;
                        orangeyInc=2;

                    }
                    else if(gowhere==3){
                        orangexInc=-2;
                        orangeyInc=0;

                    }

                }
                if(orangeghostx-20==340 && orangeghostx+20<=380 && orangeghosty==0 && orangeghosty+40<=40){
                    gowhere=(int)(Math.random()*3+1);

                    if(gowhere==1){
                        orangexInc=2;
                        orangeyInc=0;

                    }
                    else if(gowhere==2){
                        orangexInc=0;
                        orangeyInc=2;

                    }
                    else if(gowhere==3){
                        orangexInc=-2;
                        orangeyInc=0;

                    }

                }
                if(orangeghostx==480 && orangeghostx+20<=500 && orangeghosty==0 && orangeghosty+40<=40){
                    gowhere=(int)(Math.random()*2+1);
                    if(gowhere==1){
                        orangexInc=-2;
                        orangeyInc=0;

                    }
                    else if(gowhere==2){
                        orangexInc=0;
                        orangeyInc=2;

                    }

                }
                if(orangeghostx-20==0 && orangeghostx+20<=40 && orangeghosty==120 && orangeghosty+40<=160){
                    gowhere=(int)(Math.random()*3+1);

                    if(gowhere==1){
                        orangexInc=2;
                        orangeyInc=0;

                    }
                    else if(gowhere==2){
                        orangexInc=0;
                        orangeyInc=2;

                    }
                    else if(gowhere==3){
                        orangexInc=0;
                        orangeyInc=2;

                    }

                }
                if(orangeghostx-20==100 && orangeghostx+20<=140 && orangeghosty==120 && orangeghosty+40<=160){
                    gowhere=(int)(Math.random()*4+1);

                    if(gowhere==1){
                        orangexInc=2;
                        orangeyInc=0;

                    }
                    else if(gowhere==2){
                        orangexInc=0;
                        orangeyInc=2;

                    }
                    else if(gowhere==3){
                        orangexInc=-2;
                        orangeyInc=0;

                    }
                    else if(gowhere==4){
                        orangexInc=0;
                        orangeyInc=-2;

                    }

                }
                if(orangeghostx-20==220 && orangeghostx+20<=260 && orangeghosty==120 && orangeghosty+40<=160){
                    gowhere=(int)(Math.random()*4+1);

                    if(gowhere==1){
                        orangexInc=2;
                        orangeyInc=0;

                    }
                    else if(gowhere==2){
                        orangexInc=0;
                        orangeyInc=2;

                    }
                    else if(gowhere==3){
                        orangexInc=-2;
                        orangeyInc=0;

                    }
                    else if(gowhere==4){
                        orangexInc=0;
                        orangeyInc=-2;

                    }

                }
                if(orangeghostx-20==340 && orangeghostx+20<=380 && orangeghosty==120 && orangeghosty+40<=160){
                    gowhere=(int)(Math.random()*4+1);

                    if(gowhere==1){
                        orangexInc=2;
                        orangeyInc=0;

                    }
                    else if(gowhere==2){
                        orangexInc=0;
                        orangeyInc=2;

                    }
                    else if(gowhere==3){
                        orangexInc=-2;
                        orangeyInc=0;

                    }
                    else if(gowhere==4){
                        orangexInc=0;
                        orangeyInc=-2;

                    }

                }
                if(orangeghostx==480 && orangeghostx+20<=500 && orangeghosty==120 && orangeghosty+40<=160){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        orangexInc=-2;
                        orangeyInc=0;

                    }
                    else if(gowhere==2){
                        orangexInc=0;
                        orangeyInc=2;

                    }
                    else if(gowhere==3){
                        orangexInc=0;
                        orangeyInc=2;

                    }

                }
                if(orangeghostx-20==0 && orangeghostx+20<=40 && orangeghosty==320 && orangeghosty+40<=360){
                    gowhere=(int)(Math.random()*3+1);

                    if(gowhere==1){
                        orangexInc=2;
                        orangeyInc=0;

                    }
                    else if(gowhere==2){
                        orangexInc=0;
                        orangeyInc=2;

                    }
                    else if(gowhere==3){
                        orangexInc=0;
                        orangeyInc=2;

                    }

                }
                if(orangeghostx-20==100 && orangeghostx+20<=140 && orangeghosty==320 && orangeghosty+40<=360){
                    gowhere=(int)(Math.random()*4+1);

                    if(gowhere==1){
                        orangexInc=2;
                        orangeyInc=0;

                    }
                    else if(gowhere==2){
                        orangexInc=0;
                        orangeyInc=2;

                    }
                    else if(gowhere==3){
                        orangexInc=-2;
                        orangeyInc=0;

                    }
                    else if(gowhere==4){
                        orangexInc=0;
                        orangeyInc=-2;

                    }

                }
                if(orangeghostx-20==220 && orangeghostx+20<=260 && orangeghosty==320 && orangeghosty+40<=360){
                    gowhere=(int)(Math.random()*4+1);

                    if(gowhere==1){
                        orangexInc=2;
                        orangeyInc=0;

                    }
                    else if(gowhere==2){
                        orangexInc=0;
                        orangeyInc=2;

                    }
                    else if(gowhere==3){
                        orangexInc=-2;
                        orangeyInc=0;

                    }
                    else if(gowhere==4){
                        orangexInc=0;
                        orangeyInc=-2;

                    }

                }
                if(orangeghostx-20==340 && orangeghostx+20<=380 && orangeghosty==320 && orangeghosty+40<=360){
                    gowhere=(int)(Math.random()*4+1);

                    if(gowhere==1){
                        orangexInc=2;
                        orangeyInc=0;

                    }
                    else if(gowhere==2){
                        orangexInc=0;
                        orangeyInc=2;

                    }
                    else if(gowhere==3){
                        orangexInc=-2;
                        orangeyInc=0;

                    }
                    else if(gowhere==4){
                        orangexInc=0;
                        orangeyInc=-2;

                    }

                }
                if(orangeghostx==480 && orangeghostx+20<=500 && orangeghosty==320 && orangeghosty+40<=360){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        orangexInc=-2;
                        orangeyInc=0;

                    }
                    else if(gowhere==2){
                        orangexInc=0;
                        orangeyInc=2;

                    }
                    else if(gowhere==3){
                        orangexInc=0;
                        orangeyInc=2;

                    }

                }
                if(orangeghostx==20 && orangeghostx+20<=40 && orangeghosty==460 && orangeghosty+40<=500){
                    gowhere=(int)(Math.random()*2+1);
                    if(gowhere==1){
                        orangexInc=2;
                        orangeyInc=0;

                    }
                    else if(gowhere==2){
                        orangexInc=0;
                        orangeyInc=-2;

                    }

                }
                if(orangeghostx-20==100 && orangeghostx+20<=140 && orangeghosty==460 && orangeghosty+40<=500){
                    gowhere=(int)(Math.random()*3+1);

                    if(gowhere==1){
                        orangexInc=2;
                        orangeyInc=0;

                    }
                    else if(gowhere==2){
                        orangexInc=0;
                        orangeyInc=-2;

                    }
                    else if(gowhere==3){
                        orangexInc=-2;
                        orangeyInc=0;

                    }

                }
                if(orangeghostx-20==220 && orangeghostx+20<=260 && orangeghosty==460 && orangeghosty+40<=500){
                    gowhere=(int)(Math.random()*3+1);

                    if(gowhere==1){
                        orangexInc=2;
                        orangeyInc=0;

                    }
                    else if(gowhere==2){
                        orangexInc=0;
                        orangeyInc=-2;

                    }
                    else if(gowhere==3){
                        orangexInc=-2;
                        orangeyInc=0;

                    }

                }
                if(orangeghostx-20==340 && orangeghostx+20<=380 && orangeghosty==460 && orangeghosty+40<=500){
                    gowhere=(int)(Math.random()*3+1);

                    if(gowhere==1){
                        orangexInc=2;
                        orangeyInc=0;

                    }
                    else if(gowhere==2){
                        orangexInc=0;
                        orangeyInc=-2;

                    }
                    else if(gowhere==3){
                        orangexInc=-2;
                        orangeyInc=0;

                    }

                }
                if(orangeghostx==480 && orangeghostx+20<=500 && orangeghosty==460 && orangeghosty+40<=500){
                    gowhere=(int)(Math.random()*2+1);
                    if(gowhere==1){
                        orangexInc=-2;
                        orangeyInc=0;

                    }
                    else if(gowhere==2){
                        orangexInc=0;
                        orangeyInc=-2;

                    }

                }
                if(redghostx==20 && redghostx+20<=40 && redghosty==0 && redghosty+40<=40){
                    gowhere=(int)(Math.random()*2+1);
                    if(gowhere==1){
                        redxInc=2;
                        redyInc=0;

                    }
                    else if(gowhere==2){
                        redxInc=0;
                        redyInc=2;

                    }

                }
                if(redghostx-20==100 && redghostx+20<=140 && redghosty==0 && redghosty+40<=40){
                    gowhere=(int)(Math.random()*3+1);

                    if(gowhere==1){
                        redxInc=2;
                        redyInc=0;

                    }
                    else if(gowhere==2){
                        redxInc=0;
                        redyInc=2;

                    }
                    else if(gowhere==3){
                        redxInc=-2;
                        redyInc=0;

                    }

                }
                if(redghostx-20==220 && redghostx+20<=260 && redghosty==0 && redghosty+40<=40){
                    gowhere=(int)(Math.random()*3+1);

                    if(gowhere==1){
                        redxInc=2;
                        redyInc=0;

                    }
                    else if(gowhere==2){
                        redxInc=0;
                        redyInc=2;

                    }
                    else if(gowhere==3){
                        redxInc=-2;
                        redyInc=0;

                    }

                }
                if(redghostx-20==340 && redghostx+20<=380 && redghosty==0 && redghosty+40<=40){
                    gowhere=(int)(Math.random()*3+1);

                    if(gowhere==1){
                        redxInc=2;
                        redyInc=0;

                    }
                    else if(gowhere==2){
                        redxInc=0;
                        redyInc=2;

                    }
                    else if(gowhere==3){
                        redxInc=-2;
                        redyInc=0;

                    }

                }
                if(redghostx==480 && redghostx+20<=500 && redghosty==0 && redghosty+40<=40){
                    gowhere=(int)(Math.random()*2+1);
                    if(gowhere==1){
                        redxInc=-2;
                        redyInc=0;

                    }
                    else if(gowhere==2){
                        redxInc=0;
                        redyInc=2;

                    }

                }
                if(redghostx-20==0 && redghostx+20<=40 && redghosty==120 && redghosty+40<=160){
                    gowhere=(int)(Math.random()*3+1);

                    if(gowhere==1){
                        redxInc=2;
                        redyInc=0;

                    }
                    else if(gowhere==2){
                        redxInc=0;
                        redyInc=2;

                    }
                    else if(gowhere==3){
                        redxInc=0;
                        redyInc=2;

                    }

                }
                if(redghostx-20==100 && redghostx+20<=140 && redghosty==120 && redghosty+40<=160){
                    gowhere=(int)(Math.random()*4+1);

                    if(gowhere==1){
                        redxInc=2;
                        redyInc=0;

                    }
                    else if(gowhere==2){
                        redxInc=0;
                        redyInc=2;

                    }
                    else if(gowhere==3){
                        redxInc=-2;
                        redyInc=0;

                    }
                    else if(gowhere==4){
                        redxInc=0;
                        redyInc=-2;

                    }

                }
                if(redghostx-20==220 && redghostx+20<=260 && redghosty==120 && redghosty+40<=160){
                    gowhere=(int)(Math.random()*4+1);

                    if(gowhere==1){
                        redxInc=2;
                        redyInc=0;

                    }
                    else if(gowhere==2){
                        redxInc=0;
                        redyInc=2;

                    }
                    else if(gowhere==3){
                        redxInc=-2;
                        redyInc=0;

                    }
                    else if(gowhere==4){
                        redxInc=0;
                        redyInc=-2;

                    }

                }
                if(redghostx-20==340 && redghostx+20<=380 && redghosty==120 && redghosty+40<=160){
                    gowhere=(int)(Math.random()*4+1);

                    if(gowhere==1){
                        redxInc=2;
                        redyInc=0;

                    }
                    else if(gowhere==2){
                        redxInc=0;
                        redyInc=2;

                    }
                    else if(gowhere==3){
                        redxInc=-2;
                        redyInc=0;

                    }
                    else if(gowhere==4){
                        redxInc=0;
                        redyInc=-2;

                    }

                }
                if(redghostx==480 && redghostx+20<=500 && redghosty==120 && redghosty+40<=160){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        redxInc=-2;
                        redyInc=0;

                    }
                    else if(gowhere==2){
                        redxInc=0;
                        redyInc=2;

                    }
                    else if(gowhere==3){
                        redxInc=0;
                        redyInc=2;

                    }

                }
                if(redghostx-20==0 && redghostx+20<=40 && redghosty==320 && redghosty+40<=360){
                    gowhere=(int)(Math.random()*3+1);

                    if(gowhere==1){
                        redxInc=2;
                        redyInc=0;

                    }
                    else if(gowhere==2){
                        redxInc=0;
                        redyInc=2;

                    }
                    else if(gowhere==3){
                        redxInc=0;
                        redyInc=2;

                    }

                }
                if(redghostx-20==100 && redghostx+20<=140 && redghosty==320 && redghosty+40<=360){
                    gowhere=(int)(Math.random()*4+1);

                    if(gowhere==1){
                        redxInc=2;
                        redyInc=0;

                    }
                    else if(gowhere==2){
                        redxInc=0;
                        redyInc=2;

                    }
                    else if(gowhere==3){
                        redxInc=-2;
                        redyInc=0;

                    }
                    else if(gowhere==4){
                        redxInc=0;
                        redyInc=-2;

                    }

                }
                if(redghostx-20==220 && redghostx+20<=260 && redghosty==320 && redghosty+40<=360){
                    gowhere=(int)(Math.random()*4+1);

                    if(gowhere==1){
                        redxInc=2;
                        redyInc=0;

                    }
                    else if(gowhere==2){
                        redxInc=0;
                        redyInc=2;

                    }
                    else if(gowhere==3){
                        redxInc=-2;
                        redyInc=0;

                    }
                    else if(gowhere==4){
                        redxInc=0;
                        redyInc=-2;

                    }

                }
                if(redghostx-20==340 && redghostx+20<=380 && redghosty==320 && redghosty+40<=360){
                    gowhere=(int)(Math.random()*4+1);

                    if(gowhere==1){
                        redxInc=2;
                        redyInc=0;

                    }
                    else if(gowhere==2){
                        redxInc=0;
                        redyInc=2;

                    }
                    else if(gowhere==3){
                        redxInc=-2;
                        redyInc=0;

                    }
                    else if(gowhere==4){
                        redxInc=0;
                        redyInc=-2;

                    }

                }
                if(redghostx==480 && redghostx+20<=500 && redghosty==320 && redghosty+40<=360){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        redxInc=-2;
                        redyInc=0;

                    }
                    else if(gowhere==2){
                        redxInc=0;
                        redyInc=2;

                    }
                    else if(gowhere==3){
                        redxInc=0;
                        redyInc=2;

                    }

                }
                if(redghostx==20 && redghostx+20<=40 && redghosty==460 && redghosty+40<=500){
                    gowhere=(int)(Math.random()*2+1);
                    if(gowhere==1){
                        redxInc=2;
                        redyInc=0;

                    }
                    else if(gowhere==2){
                        redxInc=0;
                        redyInc=-2;

                    }

                }
                if(redghostx-20==100 && redghostx+20<=140 && redghosty==460 && redghosty+40<=500){
                    gowhere=(int)(Math.random()*3+1);

                    if(gowhere==1){
                        redxInc=2;
                        redyInc=0;

                    }
                    else if(gowhere==2){
                        redxInc=0;
                        redyInc=-2;

                    }
                    else if(gowhere==3){
                        redxInc=-2;
                        redyInc=0;

                    }

                }
                if(redghostx-20==220 && redghostx+20<=260 && redghosty==460 && redghosty+40<=500){
                    gowhere=(int)(Math.random()*3+1);

                    if(gowhere==1){
                        redxInc=2;
                        redyInc=0;

                    }
                    else if(gowhere==2){
                        redxInc=0;
                        redyInc=-2;

                    }
                    else if(gowhere==3){
                        redxInc=-2;
                        redyInc=0;

                    }

                }
                if(redghostx-20==340 && redghostx+20<=380 && redghosty==460 && redghosty+40<=500){
                    gowhere=(int)(Math.random()*3+1);

                    if(gowhere==1){
                        redxInc=2;
                        redyInc=0;

                    }
                    else if(gowhere==2){
                        redxInc=0;
                        redyInc=-2;

                    }
                    else if(gowhere==3){
                        redxInc=-2;
                        redyInc=0;

                    }

                }
                if(redghostx==480 && redghostx+20<=500 && redghosty==460 && redghosty+40<=500){
                    gowhere=(int)(Math.random()*2+1);
                    if(gowhere==1){
                        redxInc=-2;
                        redyInc=0;

                    }
                    else if(gowhere==2){
                        redxInc=0;
                        redyInc=-2;

                    }
                }

                pinkghostx+=pinkxInc;
                pinkghosty+=pinkyInc;
                blueghostx+=bluexInc;
                blueghosty+=blueyInc;
                orangeghostx+=orangexInc;
                orangeghosty+=orangeyInc;
                redghostx+=redxInc;
                redghosty+=redyInc;
            }
        }

        if(level==4){
            time=0;
            time1=0;
            time2=0;
            starttime=0;

            g.drawImage(image3,0,0,500,500,this); 
            g.setColor(Color.RED);
            g.drawRect(30,50,50,30); 
            g.drawString("END",40,70);
            if(x>=30 && x<=80 && y>=50 && y<=80){
                level=8;
            }
        }
        if(level==5){
            if(counter==0){     //alternating pacman
                if(whichway==1){//face right
                    g.setColor(Color.YELLOW);       
                    g.fillArc(pacx,pacy,30,30,20,320);   //pacman facing right
                    g.setColor(Color.BLACK);      //color of eye
                    g.fillOval(pacx+15,pacy+6,2,2);     // eyeball
                }
                else if(whichway==2){// face left
                    g.setColor(Color.YELLOW);
                    g.fillArc(pacx,pacy,30,30,200,320);  //pacman facing left
                    g.setColor(Color.BLACK);      //color of the eye
                    g.fillOval(pacx+15,pacy+6,2,2);    //eyeball
                }
                else if(whichway==3){// face up
                    g.setColor(Color.YELLOW);
                    g.fillArc(pacx,pacy,30,30,110,310);  //pacman facing left
                    g.setColor(Color.BLACK);      //color of the eye
                    g.fillOval(pacx+22,pacy+20,2,2);    //eyeball
                }
                else if(whichway==4){// face down
                    g.setColor(Color.YELLOW);
                    g.fillArc(pacx,pacy,30,30,310,290);  //pacman facing left
                    g.setColor(Color.BLACK);      //color of the eye
                    g.fillOval(pacx+22,pacy+8,2,2);    //eyeball
                }
            }   
            else{
                g.setColor(Color.YELLOW);
                g.fillOval(pacx,pacy,30,30);    //closed mouth
                g.setColor(Color.BLACK);       //color of eye
                g.fillOval(pacx+19,pacy+8,2,2);   //eyeball
            }
            setBackground(Color.BLACK);
            g.setColor(Color.WHITE);
            g.fillRect(100,120,120,120);
            g.fillRect(260,120,120,120);
            g.fillRect(100,280,120,80);
            g.fillRect(260,280,120,80);
            g.fillRect(40,40,20,200);
            g.fillRect(40,40,180,40);
            g.fillRect(40,280,20,120);
            g.fillRect(40,400,180,60);
            g.fillRect(260,400,200,60);
            g.fillRect(420,280,40,120);
            g.fillRect(260,40,200,40);
            g.fillRect(420,80,40,160);
            g.setColor(Color.BLUE);
            Polygon blueGhost=new Polygon();
            blueGhost.addPoint(blueghostx,blueghosty);
            blueGhost.addPoint(blueghostx+20,blueghosty+10);
            blueGhost.addPoint(blueghostx+10,blueghosty+40);
            blueGhost.addPoint(blueghostx,blueghosty+20);
            blueGhost.addPoint(blueghostx-10,blueghosty+40);
            blueGhost.addPoint(blueghostx-20,blueghosty+10);
            g.fillPolygon(blueGhost);
            g.setColor(Color.PINK);
            Polygon pinkGhost=new Polygon();
            pinkGhost.addPoint(pinkghostx,pinkghosty);
            pinkGhost.addPoint(pinkghostx+20,pinkghosty+10);
            pinkGhost.addPoint(pinkghostx+10,pinkghosty+40);
            pinkGhost.addPoint(pinkghostx,pinkghosty+20);
            pinkGhost.addPoint(pinkghostx-10,pinkghosty+40);
            pinkGhost.addPoint(pinkghostx-20,pinkghosty+10);
            g.fillPolygon(pinkGhost);
            g.setColor(Color.ORANGE);
            Polygon orangeGhost=new Polygon();
            orangeGhost.addPoint(orangeghostx,orangeghosty);
            orangeGhost.addPoint(orangeghostx+20,orangeghosty+10);
            orangeGhost.addPoint(orangeghostx+10,orangeghosty+40);
            orangeGhost.addPoint(orangeghostx,orangeghosty+20);
            orangeGhost.addPoint(orangeghostx-10,orangeghosty+40);
            orangeGhost.addPoint(orangeghostx-20,orangeghosty+10);
            g.fillPolygon(orangeGhost);
            g.setColor(Color.RED);
            Polygon redGhost=new Polygon();
            redGhost.addPoint(redghostx,redghosty);
            redGhost.addPoint(redghostx+20,redghosty+10);
            redGhost.addPoint(redghostx+10,redghosty+40);
            redGhost.addPoint(redghostx,redghosty+20);
            redGhost.addPoint(redghostx-10,redghosty+40);
            redGhost.addPoint(redghostx-20,redghosty+10);
            g.fillPolygon(redGhost);
            g.setColor(Color.YELLOW);
            Polygon yellowGhost=new Polygon();
            yellowGhost.addPoint( yellowghostx, yellowghosty);
            yellowGhost.addPoint( yellowghostx+20, yellowghosty+10);
            yellowGhost.addPoint( yellowghostx+10, yellowghosty+40);
            yellowGhost.addPoint( yellowghostx, yellowghosty+20);
            yellowGhost.addPoint( yellowghostx-10, yellowghosty+40);
            yellowGhost.addPoint( yellowghostx-20, yellowghosty+10);
            g.fillPolygon(yellowGhost);
            g.setColor(Color.WHITE);
            Polygon whiteghost=new Polygon();
            whiteghost.addPoint( whiteghostx, whiteghosty);
            whiteghost.addPoint( whiteghostx+20, whiteghosty+10);
            whiteghost.addPoint( whiteghostx+10, whiteghosty+40);
            whiteghost.addPoint( whiteghostx, whiteghosty+20);
            whiteghost.addPoint( whiteghostx-10, whiteghosty+40);
            whiteghost.addPoint( whiteghostx-20, whiteghosty+10);
            g.fillPolygon(whiteghost);

            g.setColor(Color.BLACK);
            g.fillOval(pinkghostx-10,pinkghosty+10,5,5);// left eye of pink ghost
            g.fillOval(pinkghostx+5,pinkghosty+10,5,5);// right eye of pink ghost
            g.fillOval(blueghostx-10,blueghosty+10,5,5);// left eye of blue ghost
            g.fillOval(blueghostx+5,blueghosty+10,5,5);// right eye of blue ghost
            g.fillOval(orangeghostx-10,orangeghosty+10,5,5);// left eye of orange ghost
            g.fillOval(orangeghostx+5,orangeghosty+10,5,5);// right eye of orange ghost
            g.fillOval(redghostx-10,redghosty+10,5,5);// left eye of red ghost
            g.fillOval(redghostx+5,redghosty+10,5,5);// right eye of red ghost

            g.fillOval(yellowghostx-10,yellowghosty+10,5,5);// left eye of yellow ghost
            g.fillOval(yellowghostx+5,yellowghosty+10,5,5);// right eye of yellow ghost
            g.fillOval(whiteghostx-10,whiteghosty+10,5,5);// left eye of white ghost
            g.fillOval(whiteghostx+5,whiteghosty+10,5,5);// right eye of white ghost
            g.setFont(new Font("default",Font.BOLD,10));        
            g.drawString("timer="+time1,150,180);        
            time1+=.01; 
            time1=(int)(time1*100+.5)/100.0;
            g.drawString("Pacx="+pacx,400,420);
            g.drawString("Pacy="+pacy,400,440);
            if(level==5 && time1>16){
                starttime=0;
                level=6;
                pacx=225;
                pacy=225;
                blueghostx=480;
                blueghosty=0;
                pinkghostx=20;
                pinkghosty=0;
                orangeghostx=20;
                orangeghosty=460;
                redghostx=480;
                redghosty=460;
                whiteghostx=20;
                whiteghosty=200;
                yellowghostx=480;
                yellowghosty=200;
            }
            if(Math.abs(pacx-(blueghostx))<=35 && Math.abs(pacy-blueghosty)<35){
                level=4;
            }
            if(Math.abs(pacx-(pinkghostx))<=35 && Math.abs(pacy-pinkghosty)<35){
                level=4;
            }
            if(Math.abs(pacx-(orangeghostx))<=35 && Math.abs(pacy-orangeghosty)<35){
                level=4;
            }
            if(Math.abs(pacx-(redghostx))<=35 && Math.abs(pacy-redghosty)<35){
                level=4;
            }
            if(Math.abs(pacx-(whiteghostx))<=35 && Math.abs(pacy-whiteghosty)<35){
                level=4;
            }
            if(Math.abs(pacx-(yellowghostx))<=35 && Math.abs(pacy-yellowghosty)<35){
                level=4;
            }
            if(pacy>15 && pacy<75 && pacx==215){
                pacx+=5;
            }
            if(pacy>15 && pacy<75 && pacx==235){
                pacx-=5;
            }
            if(pacx>235 && pacx<460 && pacy==15){
                pacy-=5;
            }
            if(pacx>235 && pacx<420 && pacy==75){
                pacy+=5;
            }
            if(pacy>75 && pacy<235 && pacx==395){
                pacx-=5;
            }
            if(pacx>235 && pacx<375 && pacy==95){
                pacy-=5;
            }
            if(pacy>95 && pacy<235 && pacx==375){
                pacx+=5;
            }
            if(pacx>235 && pacx<375 && pacy==235){
                pacy+=5;
            }
            if(pacy>95 && pacy<235 && pacx==235){
                pacx-=5;
            }
            if(pacx>395 && pacx<460 && pacy==235){
                pacy+=5;
            }
            if(pacy>20 && pacy<235 && pacx==455){
                pacx+=5;
            }
            if(pacx>395 && pacx<455 && pacy==255){
                pacy-=5;
            }
            if(pacy>255 && pacy<455 && pacx==455){
                pacx+=5;
            }
            if(pacx>235 && pacx<455 && pacy==455){
                pacy+=5;
            }
            if(pacx>235 && pacx<420 && pacy==375){
                pacy-=5;
            }
            if(pacy>255 && pacy<400 && pacx==395){
                pacx-=5;
            }
            if(pacx>235 && pacx<375 && pacy==355){
                pacy+=5;
            }
            if(pacy>255 && pacy<355 && pacx==375){
                pacx+=5;
            }
            if(pacx>235 && pacx<375 && pacy==255){
                pacy-=5;
            }
            if(pacy>375 && pacy<455 && pacx==215){
                pacx+=5;
            }
            if(pacx>15 && pacx<215 && pacy==455){
                pacy+=5;
            }
            if(pacy>255 && pacy<455 && pacx==15){
                pacx-=5;
            }
            if(pacx>15 && pacx<55 && pacy==255){
                pacy-=5;
            }
            if(pacy>255 && pacy<395 && pacx==55){
                pacx+=5;
            }
            if(pacx>35 && pacx<215 && pacy==375){
                pacy-=5;
            }
            if(pacy>255 && pacy<355 && pacx==235){
                pacx-=5;
            }
            if(pacx>75 && pacx<215 && pacy==255){
                pacy-=5;
            }
            if(pacy>255 && pacy<355 && pacx==75){
                pacx-=5;
            }
            if(pacy>375 && pacy<455 && pacx==235){
                pacx-=5;
            }
            if(pacx>75 && pacx<215 && pacy==355){
                pacy+=5;
            }
            if(pacy>255 && pacy<355 && pacx==215){
                pacx+=5;
            }
            if(pacx>80 && pacx<215 && pacy==235){
                pacy+=5;
            }
            if(pacx>80 && pacx<215 && pacy==95){
                pacy-=5;
            }
            if(pacy>95 && pacy<235 && pacx==75){
                pacx-=5;
            }
            if(pacy>95 && pacy<235 && pacx==215){
                pacx+=5;
            }
            if(pacx>35 && pacx<215 && pacy==75){
                pacy+=5;
            }
            if(pacy>55 && pacy<235 && pacx==55){
                pacx+=5;
            }
            if(pacx>15 && pacx<55 && pacy==235){
                pacy+=5;
            }
            if(pacy>15 && pacy<235 && pacx==15){
                pacx-=5;
            }
            if(pacx>15 && pacx<215 && pacy==15){
                pacy-=5;
            }
            if(pacy>470){
                pacy-=5;
            }
            if(pacy<0){
                pacy+=5;
            }
            if(pacx<0){
                pacx+=5;
            }
            if(pacx>470){
                pacx-=5;
            }
            starttime+=.01;
            if(starttime>=1){
                if(pinkghostx==20 && pinkghostx+20<=40 && pinkghosty==0 && pinkghosty+40<=40){
                    gowhere=(int)(Math.random()*2+1);
                    if(gowhere==1){
                        pinkxInc=2;
                        pinkyInc=0;

                    }
                    else if(gowhere==2){
                        pinkxInc=0;
                        pinkyInc=2;

                    }

                }
                if(pinkghostx==20 && pinkghostx+20<=40 && pinkghosty==460 && pinkghosty+40<=500){
                    gowhere=(int)(Math.random()*2+1);
                    if(gowhere==1){
                        pinkxInc=2;
                        pinkyInc=0;

                    }
                    else if(gowhere==2){
                        pinkxInc=0;
                        pinkyInc=-2;

                    }

                }

                if(pinkghostx==480 && pinkghostx+20<=500 && pinkghosty==0 && pinkghosty+40<=40){
                    gowhere=(int)(Math.random()*2+1);
                    if(gowhere==1){
                        pinkxInc=-2;
                        pinkyInc=0;

                    }
                    else if(gowhere==2){
                        pinkxInc=0;
                        pinkyInc=2;

                    }

                }
                if(pinkghostx==480 && pinkghostx+20<=500 && pinkghosty==460 && pinkghosty+40<=500){
                    gowhere=(int)(Math.random()*2+1);
                    if(gowhere==1){
                        pinkxInc=-2;
                        pinkyInc=0;

                    }
                    else if(gowhere==2){
                        pinkxInc=0;
                        pinkyInc=-2;

                    }

                }
                if(pinkghostx==240 && pinkghosty==0 ){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        pinkxInc=2;
                        pinkyInc=0;

                    }
                    else if(gowhere==2){
                        pinkxInc=0;
                        pinkyInc=2;

                    }
                    else if(gowhere==3){
                        pinkxInc=-2;
                        pinkyInc=0;

                    }

                }
                if(pinkghostx==240 && pinkghosty==80 ){
                    gowhere=(int)(Math.random()*4+1);
                    if(gowhere==1){
                        pinkxInc=2;
                        pinkyInc=0;

                    }
                    else if(gowhere==2){
                        pinkxInc=0;
                        pinkyInc=-2;

                    }
                    else if(gowhere==3){
                        pinkxInc=-2;
                        pinkyInc=0;

                    }
                    else if(gowhere==4){
                        pinkxInc=0;
                        pinkyInc=2;

                    }
                }
                if(pinkghostx==240 && pinkghosty==240 ){
                    gowhere=(int)(Math.random()*4+1);
                    if(gowhere==1){
                        pinkxInc=2;
                        pinkyInc=0;

                    }
                    else if(gowhere==2){
                        pinkxInc=0;
                        pinkyInc=-2;

                    }
                    else if(gowhere==3){
                        pinkxInc=-2;
                        pinkyInc=0;

                    }
                    else if(gowhere==4){
                        pinkxInc=0;
                        pinkyInc=2;

                    }
                }
                if(pinkghostx==240 && pinkghosty==360 ){
                    gowhere=(int)(Math.random()*4+1);
                    if(gowhere==1){
                        pinkxInc=2;
                        pinkyInc=0;

                    }
                    else if(gowhere==2){
                        pinkxInc=0;
                        pinkyInc=-2;

                    }
                    else if(gowhere==3){
                        pinkxInc=-2;
                        pinkyInc=0;

                    }
                    else if(gowhere==4){
                        pinkxInc=0;
                        pinkyInc=2;

                    }
                }
                if(pinkghostx==240 && pinkghosty==460 ){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        pinkxInc=2;
                        pinkyInc=0;

                    }
                    else if(gowhere==2){
                        pinkxInc=0;
                        pinkyInc=-2;

                    }
                    else if(gowhere==3){
                        pinkxInc=2;
                        pinkyInc=0;

                    }
                }
                if(pinkghostx==20 && pinkghosty==240 ){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        pinkxInc=2;
                        pinkyInc=0;

                    }

                    else if(gowhere==2){
                        pinkxInc=0;
                        pinkyInc=-2;

                    }
                    else if(gowhere==3){
                        pinkxInc=0;
                        pinkyInc=2;

                    }

                }
                if(pinkghostx==480 && pinkghosty==240 ){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        pinkxInc=-2;
                        pinkyInc=0;

                    }

                    else if(gowhere==2){
                        pinkxInc=0;
                        pinkyInc=-2;

                    }
                    else if(gowhere==3){
                        pinkxInc=0;
                        pinkyInc=2;

                    }

                }
                if(pinkghostx==80 && pinkghosty==80 ){
                    gowhere=(int)(Math.random()*2+1);
                    if(gowhere==1){
                        pinkxInc=2;
                        pinkyInc=0;

                    }
                    else if(gowhere==2){
                        pinkxInc=0;
                        pinkyInc=2;

                    }

                }
                if(pinkghostx==400 && pinkghosty==80 ){
                    gowhere=(int)(Math.random()*2+1);
                    if(gowhere==1){
                        pinkxInc=-2;
                        pinkyInc=0;

                    }
                    else if(gowhere==2){
                        pinkxInc=0;
                        pinkyInc=2;

                    }

                }
                if(pinkghostx==80 && pinkghosty==360 ){
                    gowhere=(int)(Math.random()*2+1);
                    if(gowhere==1){
                        pinkxInc=2;
                        pinkyInc=0;

                    }
                    else if(gowhere==2){
                        pinkxInc=0;
                        pinkyInc=-2;

                    }

                }
                if(pinkghostx==400 && pinkghosty==360 ){
                    gowhere=(int)(Math.random()*2+1);
                    if(gowhere==1){
                        pinkxInc=-2;
                        pinkyInc=0;

                    }
                    else if(gowhere==2){
                        pinkxInc=0;
                        pinkyInc=-2;

                    }

                }
                if(pinkghostx==80 && pinkghosty==240 ){
                    gowhere=(int)(Math.random()*4+1);
                    if(gowhere==1){
                        pinkxInc=2;
                        pinkyInc=0;

                    }
                    else if(gowhere==2){
                        pinkxInc=0;
                        pinkyInc=-2;

                    }
                    else if(gowhere==3){
                        pinkxInc=-2;
                        pinkyInc=0;

                    }
                    else if(gowhere==4){
                        pinkxInc=0;
                        pinkyInc=2;

                    }
                }
                if(pinkghostx==400 && pinkghosty==240 ){
                    gowhere=(int)(Math.random()*4+1);
                    if(gowhere==1){
                        pinkxInc=2;
                        pinkyInc=0;

                    }
                    else if(gowhere==2){
                        pinkxInc=0;
                        pinkyInc=-2;

                    }
                    else if(gowhere==3){
                        pinkxInc=-2;
                        pinkyInc=0;

                    }
                    else if(gowhere==4){
                        pinkxInc=0;
                        pinkyInc=2;

                    }
                }
                if(blueghostx==20 && blueghostx+20<=40 && blueghosty==0 && blueghosty+40<=40){
                    gowhere=(int)(Math.random()*2+1);
                    if(gowhere==1){
                        bluexInc=2;
                        blueyInc=0;

                    }
                    else if(gowhere==2){
                        bluexInc=0;
                        blueyInc=2;

                    }

                }
                if(blueghostx==20 && blueghostx+20<=40 && blueghosty==460 && blueghosty+40<=500){
                    gowhere=(int)(Math.random()*2+1);
                    if(gowhere==1){
                        bluexInc=2;
                        blueyInc=0;

                    }
                    else if(gowhere==2){
                        bluexInc=0;
                        blueyInc=-2;

                    }

                }

                if(blueghostx==480 && blueghostx+20<=500 && blueghosty==0 && blueghosty+40<=40){
                    gowhere=(int)(Math.random()*2+1);
                    if(gowhere==1){
                        bluexInc=-2;
                        blueyInc=0;

                    }
                    else if(gowhere==2){
                        bluexInc=0;
                        blueyInc=2;

                    }

                }
                if(blueghostx==480 && blueghostx+20<=500 && blueghosty==460 && blueghosty+40<=500){
                    gowhere=(int)(Math.random()*2+1);
                    if(gowhere==1){
                        bluexInc=-2;
                        blueyInc=0;

                    }
                    else if(gowhere==2){
                        bluexInc=0;
                        blueyInc=-2;

                    }

                }
                if(blueghostx==240 && blueghosty==0 ){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        bluexInc=2;
                        blueyInc=0;

                    }
                    else if(gowhere==2){
                        bluexInc=0;
                        blueyInc=2;

                    }
                    else if(gowhere==3){
                        bluexInc=-2;
                        blueyInc=0;

                    }

                }
                if(blueghostx==240 && blueghosty==80 ){
                    gowhere=(int)(Math.random()*4+1);
                    if(gowhere==1){
                        bluexInc=2;
                        blueyInc=0;

                    }
                    else if(gowhere==2){
                        bluexInc=0;
                        blueyInc=-2;

                    }
                    else if(gowhere==3){
                        bluexInc=-2;
                        blueyInc=0;

                    }
                    else if(gowhere==4){
                        bluexInc=0;
                        blueyInc=2;

                    }
                }
                if(blueghostx==240 && blueghosty==240 ){
                    gowhere=(int)(Math.random()*4+1);
                    if(gowhere==1){
                        bluexInc=2;
                        blueyInc=0;

                    }
                    else if(gowhere==2){
                        bluexInc=0;
                        blueyInc=-2;

                    }
                    else if(gowhere==3){
                        bluexInc=-2;
                        blueyInc=0;

                    }
                    else if(gowhere==4){
                        bluexInc=0;
                        blueyInc=2;

                    }
                }
                if(blueghostx==240 && blueghosty==360 ){
                    gowhere=(int)(Math.random()*4+1);
                    if(gowhere==1){
                        bluexInc=2;
                        blueyInc=0;

                    }
                    else if(gowhere==2){
                        bluexInc=0;
                        blueyInc=-2;

                    }
                    else if(gowhere==3){
                        bluexInc=-2;
                        blueyInc=0;

                    }
                    else if(gowhere==4){
                        bluexInc=0;
                        blueyInc=2;

                    }
                }
                if(blueghostx==240 && blueghosty==460 ){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        bluexInc=2;
                        blueyInc=0;

                    }
                    else if(gowhere==2){
                        bluexInc=0;
                        blueyInc=-2;

                    }
                    else if(gowhere==3){
                        bluexInc=2;
                        blueyInc=0;

                    }
                }
                if(blueghostx==20 && blueghosty==240 ){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        bluexInc=2;
                        blueyInc=0;

                    }

                    else if(gowhere==2){
                        bluexInc=0;
                        blueyInc=-2;

                    }
                    else if(gowhere==3){
                        bluexInc=0;
                        blueyInc=2;

                    }

                }
                if(blueghostx==480 && blueghosty==240 ){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        bluexInc=-2;
                        blueyInc=0;

                    }

                    else if(gowhere==2){
                        bluexInc=0;
                        blueyInc=-2;

                    }
                    else if(gowhere==3){
                        bluexInc=0;
                        blueyInc=2;

                    }

                }
                if(blueghostx==80 && blueghosty==80 ){
                    gowhere=(int)(Math.random()*2+1);
                    if(gowhere==1){
                        bluexInc=2;
                        blueyInc=0;

                    }
                    else if(gowhere==2){
                        bluexInc=0;
                        blueyInc=2;

                    }

                }
                if(blueghostx==400 && blueghosty==80 ){
                    gowhere=(int)(Math.random()*2+1);
                    if(gowhere==1){
                        bluexInc=-2;
                        blueyInc=0;

                    }
                    else if(gowhere==2){
                        bluexInc=0;
                        blueyInc=2;

                    }

                }
                if(blueghostx==80 && blueghosty==360 ){
                    gowhere=(int)(Math.random()*2+1);
                    if(gowhere==1){
                        bluexInc=2;
                        blueyInc=0;

                    }
                    else if(gowhere==2){
                        bluexInc=0;
                        blueyInc=-2;

                    }

                }
                if(blueghostx==400 && blueghosty==360 ){
                    gowhere=(int)(Math.random()*2+1);
                    if(gowhere==1){
                        bluexInc=-2;
                        blueyInc=0;

                    }
                    else if(gowhere==2){
                        bluexInc=0;
                        blueyInc=-2;

                    }

                }
                if(blueghostx==80 && blueghosty==240 ){
                    gowhere=(int)(Math.random()*4+1);
                    if(gowhere==1){
                        bluexInc=2;
                        blueyInc=0;

                    }
                    else if(gowhere==2){
                        bluexInc=0;
                        blueyInc=-2;

                    }
                    else if(gowhere==3){
                        bluexInc=-2;
                        blueyInc=0;

                    }
                    else if(gowhere==4){
                        bluexInc=0;
                        blueyInc=2;

                    }
                }
                if(blueghostx==400 && blueghosty==240 ){
                    gowhere=(int)(Math.random()*4+1);
                    if(gowhere==1){
                        bluexInc=2;
                        blueyInc=0;

                    }
                    else if(gowhere==2){
                        bluexInc=0;
                        blueyInc=-2;

                    }
                    else if(gowhere==3){
                        bluexInc=-2;
                        blueyInc=0;

                    }
                    else if(gowhere==4){
                        bluexInc=0;
                        blueyInc=2;

                    }
                }
                if(orangeghostx==20 && orangeghostx+20<=40 && orangeghosty==0 && orangeghosty+40<=40){
                    gowhere=(int)(Math.random()*2+1);
                    if(gowhere==1){
                        orangexInc=2;
                        orangeyInc=0;

                    }
                    else if(gowhere==2){
                        orangexInc=0;
                        orangeyInc=2;

                    }

                }
                if(orangeghostx==20 && orangeghostx+20<=40 && orangeghosty==460 && orangeghosty+40<=500){
                    gowhere=(int)(Math.random()*2+1);
                    if(gowhere==1){
                        orangexInc=2;
                        orangeyInc=0;

                    }
                    else if(gowhere==2){
                        orangexInc=0;
                        orangeyInc=-2;

                    }

                }

                if(orangeghostx==480 && orangeghostx+20<=500 && orangeghosty==0 && orangeghosty+40<=40){
                    gowhere=(int)(Math.random()*2+1);
                    if(gowhere==1){
                        orangexInc=-2;
                        orangeyInc=0;

                    }
                    else if(gowhere==2){
                        orangexInc=0;
                        orangeyInc=2;

                    }

                }
                if(orangeghostx==480 && orangeghostx+20<=500 && orangeghosty==460 && orangeghosty+40<=500){
                    gowhere=(int)(Math.random()*2+1);
                    if(gowhere==1){
                        orangexInc=-2;
                        orangeyInc=0;

                    }
                    else if(gowhere==2){
                        orangexInc=0;
                        orangeyInc=-2;

                    }

                }
                if(orangeghostx==240 && orangeghosty==0 ){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        orangexInc=2;
                        orangeyInc=0;

                    }
                    else if(gowhere==2){
                        orangexInc=0;
                        orangeyInc=2;

                    }
                    else if(gowhere==3){
                        orangexInc=-2;
                        orangeyInc=0;

                    }

                }
                if(orangeghostx==240 && orangeghosty==80 ){
                    gowhere=(int)(Math.random()*4+1);
                    if(gowhere==1){
                        orangexInc=2;
                        orangeyInc=0;

                    }
                    else if(gowhere==2){
                        orangexInc=0;
                        orangeyInc=-2;

                    }
                    else if(gowhere==3){
                        orangexInc=-2;
                        orangeyInc=0;

                    }
                    else if(gowhere==4){
                        orangexInc=0;
                        orangeyInc=2;

                    }
                }
                if(orangeghostx==240 && orangeghosty==240 ){
                    gowhere=(int)(Math.random()*4+1);
                    if(gowhere==1){
                        orangexInc=2;
                        orangeyInc=0;

                    }
                    else if(gowhere==2){
                        orangexInc=0;
                        orangeyInc=-2;

                    }
                    else if(gowhere==3){
                        orangexInc=-2;
                        orangeyInc=0;

                    }
                    else if(gowhere==4){
                        orangexInc=0;
                        orangeyInc=2;

                    }
                }
                if(orangeghostx==240 && orangeghosty==360 ){
                    gowhere=(int)(Math.random()*4+1);
                    if(gowhere==1){
                        orangexInc=2;
                        orangeyInc=0;

                    }
                    else if(gowhere==2){
                        orangexInc=0;
                        orangeyInc=-2;

                    }
                    else if(gowhere==3){
                        orangexInc=-2;
                        orangeyInc=0;

                    }
                    else if(gowhere==4){
                        orangexInc=0;
                        orangeyInc=2;

                    }
                }
                if(orangeghostx==240 && orangeghosty==460 ){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        orangexInc=2;
                        orangeyInc=0;

                    }
                    else if(gowhere==2){
                        orangexInc=0;
                        orangeyInc=-2;

                    }
                    else if(gowhere==3){
                        orangexInc=2;
                        orangeyInc=0;

                    }
                }
                if(orangeghostx==20 && orangeghosty==240 ){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        orangexInc=2;
                        orangeyInc=0;

                    }

                    else if(gowhere==2){
                        orangexInc=0;
                        orangeyInc=-2;

                    }
                    else if(gowhere==3){
                        orangexInc=0;
                        orangeyInc=2;

                    }

                }
                if(orangeghostx==480 && orangeghosty==240 ){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        orangexInc=-2;
                        orangeyInc=0;

                    }

                    else if(gowhere==2){
                        orangexInc=0;
                        orangeyInc=-2;

                    }
                    else if(gowhere==3){
                        orangexInc=0;
                        orangeyInc=2;

                    }

                }
                if(orangeghostx==80 && orangeghosty==80 ){
                    gowhere=(int)(Math.random()*2+1);
                    if(gowhere==1){
                        orangexInc=2;
                        orangeyInc=0;

                    }
                    else if(gowhere==2){
                        orangexInc=0;
                        orangeyInc=2;

                    }

                }
                if(orangeghostx==400 && orangeghosty==80 ){
                    gowhere=(int)(Math.random()*2+1);
                    if(gowhere==1){
                        orangexInc=-2;
                        orangeyInc=0;

                    }
                    else if(gowhere==2){
                        orangexInc=0;
                        orangeyInc=2;

                    }

                }
                if(orangeghostx==80 && orangeghosty==360 ){
                    gowhere=(int)(Math.random()*2+1);
                    if(gowhere==1){
                        orangexInc=2;
                        orangeyInc=0;

                    }
                    else if(gowhere==2){
                        orangexInc=0;
                        orangeyInc=-2;

                    }

                }
                if(orangeghostx==400 && orangeghosty==360 ){
                    gowhere=(int)(Math.random()*2+1);
                    if(gowhere==1){
                        orangexInc=-2;
                        orangeyInc=0;

                    }
                    else if(gowhere==2){
                        orangexInc=0;
                        orangeyInc=-2;

                    }

                }
                if(orangeghostx==80 && orangeghosty==240 ){
                    gowhere=(int)(Math.random()*4+1);
                    if(gowhere==1){
                        orangexInc=2;
                        orangeyInc=0;

                    }
                    else if(gowhere==2){
                        orangexInc=0;
                        orangeyInc=-2;

                    }
                    else if(gowhere==3){
                        orangexInc=-2;
                        orangeyInc=0;

                    }
                    else if(gowhere==4){
                        orangexInc=0;
                        orangeyInc=2;

                    }
                }
                if(orangeghostx==400 && orangeghosty==240 ){
                    gowhere=(int)(Math.random()*4+1);
                    if(gowhere==1){
                        orangexInc=2;
                        orangeyInc=0;

                    }
                    else if(gowhere==2){
                        orangexInc=0;
                        orangeyInc=-2;

                    }
                    else if(gowhere==3){
                        orangexInc=-2;
                        orangeyInc=0;

                    }
                    else if(gowhere==4){
                        orangexInc=0;
                        orangeyInc=2;

                    }
                }
                if(redghostx==20 && redghostx+20<=40 && redghosty==0 && redghosty+40<=40){
                    gowhere=(int)(Math.random()*2+1);
                    if(gowhere==1){
                        redxInc=2;
                        redyInc=0;

                    }
                    else if(gowhere==2){
                        redxInc=0;
                        redyInc=2;

                    }

                }
                if(redghostx==20 && redghostx+20<=40 && redghosty==460 && redghosty+40<=500){
                    gowhere=(int)(Math.random()*2+1);
                    if(gowhere==1){
                        redxInc=2;
                        redyInc=0;

                    }
                    else if(gowhere==2){
                        redxInc=0;
                        redyInc=-2;

                    }

                }

                if(redghostx==480 && redghostx+20<=500 && redghosty==0 && redghosty+40<=40){
                    gowhere=(int)(Math.random()*2+1);
                    if(gowhere==1){
                        redxInc=-2;
                        redyInc=0;

                    }
                    else if(gowhere==2){
                        redxInc=0;
                        redyInc=2;

                    }

                }
                if(redghostx==480 && redghostx+20<=500 && redghosty==460 && redghosty+40<=500){
                    gowhere=(int)(Math.random()*2+1);
                    if(gowhere==1){
                        redxInc=-2;
                        redyInc=0;

                    }
                    else if(gowhere==2){
                        redxInc=0;
                        redyInc=-2;

                    }

                }
                if(redghostx==240 && redghosty==0 ){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        redxInc=2;
                        redyInc=0;

                    }
                    else if(gowhere==2){
                        redxInc=0;
                        redyInc=2;

                    }
                    else if(gowhere==3){
                        redxInc=-2;
                        redyInc=0;

                    }

                }
                if(redghostx==240 && redghosty==80 ){
                    gowhere=(int)(Math.random()*4+1);
                    if(gowhere==1){
                        redxInc=2;
                        redyInc=0;

                    }
                    else if(gowhere==2){
                        redxInc=0;
                        redyInc=-2;

                    }
                    else if(gowhere==3){
                        redxInc=-2;
                        redyInc=0;

                    }
                    else if(gowhere==4){
                        redxInc=0;
                        redyInc=2;

                    }
                }
                if(redghostx==240 && redghosty==240 ){
                    gowhere=(int)(Math.random()*4+1);
                    if(gowhere==1){
                        redxInc=2;
                        redyInc=0;

                    }
                    else if(gowhere==2){
                        redxInc=0;
                        redyInc=-2;

                    }
                    else if(gowhere==3){
                        redxInc=-2;
                        redyInc=0;

                    }
                    else if(gowhere==4){
                        redxInc=0;
                        redyInc=2;

                    }
                }
                if(redghostx==240 && redghosty==360 ){
                    gowhere=(int)(Math.random()*4+1);
                    if(gowhere==1){
                        redxInc=2;
                        redyInc=0;

                    }
                    else if(gowhere==2){
                        redxInc=0;
                        redyInc=-2;

                    }
                    else if(gowhere==3){
                        redxInc=-2;
                        redyInc=0;

                    }
                    else if(gowhere==4){
                        redxInc=0;
                        redyInc=2;

                    }
                }
                if(redghostx==240 && redghosty==460 ){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        redxInc=2;
                        redyInc=0;

                    }
                    else if(gowhere==2){
                        redxInc=0;
                        redyInc=-2;

                    }
                    else if(gowhere==3){
                        redxInc=2;
                        redyInc=0;

                    }
                }
                if(redghostx==20 && redghosty==240 ){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        redxInc=2;
                        redyInc=0;

                    }

                    else if(gowhere==2){
                        redxInc=0;
                        redyInc=-2;

                    }
                    else if(gowhere==3){
                        redxInc=0;
                        redyInc=2;

                    }

                }
                if(redghostx==480 && redghosty==240 ){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        redxInc=-2;
                        redyInc=0;

                    }

                    else if(gowhere==2){
                        redxInc=0;
                        redyInc=-2;

                    }
                    else if(gowhere==3){
                        redxInc=0;
                        redyInc=2;

                    }

                }
                if(redghostx==80 && redghosty==80 ){
                    gowhere=(int)(Math.random()*2+1);
                    if(gowhere==1){
                        redxInc=2;
                        redyInc=0;

                    }
                    else if(gowhere==2){
                        redxInc=0;
                        redyInc=2;

                    }

                }
                if(redghostx==400 && redghosty==80 ){
                    gowhere=(int)(Math.random()*2+1);
                    if(gowhere==1){
                        redxInc=-2;
                        redyInc=0;

                    }
                    else if(gowhere==2){
                        redxInc=0;
                        redyInc=2;

                    }

                }
                if(redghostx==80 && redghosty==360 ){
                    gowhere=(int)(Math.random()*2+1);
                    if(gowhere==1){
                        redxInc=2;
                        redyInc=0;

                    }
                    else if(gowhere==2){
                        redxInc=0;
                        redyInc=-2;

                    }

                }
                if(redghostx==400 && redghosty==360 ){
                    gowhere=(int)(Math.random()*2+1);
                    if(gowhere==1){
                        redxInc=-2;
                        redyInc=0;

                    }
                    else if(gowhere==2){
                        redxInc=0;
                        redyInc=-2;

                    }

                }
                if(redghostx==80 && redghosty==240 ){
                    gowhere=(int)(Math.random()*4+1);
                    if(gowhere==1){
                        redxInc=2;
                        redyInc=0;

                    }
                    else if(gowhere==2){
                        redxInc=0;
                        redyInc=-2;

                    }
                    else if(gowhere==3){
                        redxInc=-2;
                        redyInc=0;

                    }
                    else if(gowhere==4){
                        redxInc=0;
                        redyInc=2;

                    }
                }
                if(redghostx==400 && redghosty==240 ){
                    gowhere=(int)(Math.random()*4+1);
                    if(gowhere==1){
                        redxInc=2;
                        redyInc=0;

                    }
                    else if(gowhere==2){
                        redxInc=0;
                        redyInc=-2;

                    }
                    else if(gowhere==3){
                        redxInc=-2;
                        redyInc=0;

                    }
                    else if(gowhere==4){
                        redxInc=0;
                        redyInc=2;

                    }
                }
                if(whiteghostx==20 && whiteghostx+20<=40 && whiteghosty==0 && whiteghosty+40<=40){
                    gowhere=(int)(Math.random()*2+1);
                    if(gowhere==1){
                        whitexInc=2;
                        whiteyInc=0;

                    }
                    else if(gowhere==2){
                        whitexInc=0;
                        whiteyInc=2;

                    }

                }
                if(whiteghostx==20 && whiteghostx+20<=40 && whiteghosty==460 && whiteghosty+40<=500){
                    gowhere=(int)(Math.random()*2+1);
                    if(gowhere==1){
                        whitexInc=2;
                        whiteyInc=0;

                    }
                    else if(gowhere==2){
                        whitexInc=0;
                        whiteyInc=-2;

                    }

                }

                if(whiteghostx==480 && whiteghostx+20<=500 && whiteghosty==0 && whiteghosty+40<=40){
                    gowhere=(int)(Math.random()*2+1);
                    if(gowhere==1){
                        whitexInc=-2;
                        whiteyInc=0;

                    }
                    else if(gowhere==2){
                        whitexInc=0;
                        whiteyInc=2;

                    }

                }
                if(whiteghostx==480 && whiteghostx+20<=500 && whiteghosty==460 && whiteghosty+40<=500){
                    gowhere=(int)(Math.random()*2+1);
                    if(gowhere==1){
                        whitexInc=-2;
                        whiteyInc=0;

                    }
                    else if(gowhere==2){
                        whitexInc=0;
                        whiteyInc=-2;

                    }

                }
                if(whiteghostx==240 && whiteghosty==0 ){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        whitexInc=2;
                        whiteyInc=0;

                    }
                    else if(gowhere==2){
                        whitexInc=0;
                        whiteyInc=2;

                    }
                    else if(gowhere==3){
                        whitexInc=-2;
                        whiteyInc=0;

                    }

                }
                if(whiteghostx==240 && whiteghosty==80 ){
                    gowhere=(int)(Math.random()*4+1);
                    if(gowhere==1){
                        whitexInc=2;
                        whiteyInc=0;

                    }
                    else if(gowhere==2){
                        whitexInc=0;
                        whiteyInc=-2;

                    }
                    else if(gowhere==3){
                        whitexInc=-2;
                        whiteyInc=0;

                    }
                    else if(gowhere==4){
                        whitexInc=0;
                        whiteyInc=2;

                    }
                }
                if(whiteghostx==240 && whiteghosty==240 ){
                    gowhere=(int)(Math.random()*4+1);
                    if(gowhere==1){
                        whitexInc=2;
                        whiteyInc=0;

                    }
                    else if(gowhere==2){
                        whitexInc=0;
                        whiteyInc=-2;

                    }
                    else if(gowhere==3){
                        whitexInc=-2;
                        whiteyInc=0;

                    }
                    else if(gowhere==4){
                        whitexInc=0;
                        whiteyInc=2;

                    }
                }
                if(whiteghostx==240 && whiteghosty==360 ){
                    gowhere=(int)(Math.random()*4+1);
                    if(gowhere==1){
                        whitexInc=2;
                        whiteyInc=0;

                    }
                    else if(gowhere==2){
                        whitexInc=0;
                        whiteyInc=-2;

                    }
                    else if(gowhere==3){
                        whitexInc=-2;
                        whiteyInc=0;

                    }
                    else if(gowhere==4){
                        whitexInc=0;
                        whiteyInc=2;

                    }
                }
                if(whiteghostx==240 && whiteghosty==460 ){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        whitexInc=2;
                        whiteyInc=0;

                    }
                    else if(gowhere==2){
                        whitexInc=0;
                        whiteyInc=-2;

                    }
                    else if(gowhere==3){
                        whitexInc=2;
                        whiteyInc=0;

                    }
                }
                if(whiteghostx==20 && whiteghosty==240 ){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        whitexInc=2;
                        whiteyInc=0;

                    }

                    else if(gowhere==2){
                        whitexInc=0;
                        whiteyInc=-2;

                    }
                    else if(gowhere==3){
                        whitexInc=0;
                        whiteyInc=2;

                    }

                }
                if(whiteghostx==480 && whiteghosty==240 ){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        whitexInc=-2;
                        whiteyInc=0;

                    }

                    else if(gowhere==2){
                        whitexInc=0;
                        whiteyInc=-2;

                    }
                    else if(gowhere==3){
                        whitexInc=0;
                        whiteyInc=2;

                    }

                }
                if(whiteghostx==80 && whiteghosty==80 ){
                    gowhere=(int)(Math.random()*2+1);
                    if(gowhere==1){
                        whitexInc=2;
                        whiteyInc=0;

                    }
                    else if(gowhere==2){
                        whitexInc=0;
                        whiteyInc=2;

                    }

                }
                if(whiteghostx==400 && whiteghosty==80 ){
                    gowhere=(int)(Math.random()*2+1);
                    if(gowhere==1){
                        whitexInc=-2;
                        whiteyInc=0;

                    }
                    else if(gowhere==2){
                        whitexInc=0;
                        whiteyInc=2;

                    }

                }
                if(whiteghostx==80 && whiteghosty==360 ){
                    gowhere=(int)(Math.random()*2+1);
                    if(gowhere==1){
                        whitexInc=2;
                        whiteyInc=0;

                    }
                    else if(gowhere==2){
                        whitexInc=0;
                        whiteyInc=-2;

                    }

                }
                if(whiteghostx==400 && whiteghosty==360 ){
                    gowhere=(int)(Math.random()*2+1);
                    if(gowhere==1){
                        whitexInc=-2;
                        whiteyInc=0;

                    }
                    else if(gowhere==2){
                        whitexInc=0;
                        whiteyInc=-2;

                    }

                }
                if(whiteghostx==80 && whiteghosty==240 ){
                    gowhere=(int)(Math.random()*4+1);
                    if(gowhere==1){
                        whitexInc=2;
                        whiteyInc=0;

                    }
                    else if(gowhere==2){
                        whitexInc=0;
                        whiteyInc=-2;

                    }
                    else if(gowhere==3){
                        whitexInc=-2;
                        whiteyInc=0;

                    }
                    else if(gowhere==4){
                        whitexInc=0;
                        whiteyInc=2;

                    }
                }
                if(whiteghostx==400 && whiteghosty==240 ){
                    gowhere=(int)(Math.random()*4+1);
                    if(gowhere==1){
                        whitexInc=2;
                        whiteyInc=0;

                    }
                    else if(gowhere==2){
                        whitexInc=0;
                        whiteyInc=-2;

                    }
                    else if(gowhere==3){
                        whitexInc=-2;
                        whiteyInc=0;

                    }
                    else if(gowhere==4){
                        whitexInc=0;
                        whiteyInc=2;

                    }
                }
                if(yellowghostx==20 && yellowghostx+20<=40 && yellowghosty==0 && yellowghosty+40<=40){
                    gowhere=(int)(Math.random()*2+1);
                    if(gowhere==1){
                        yellowxInc=2;
                        yellowyInc=0;

                    }
                    else if(gowhere==2){
                        yellowxInc=0;
                        yellowyInc=2;

                    }

                }
                if(yellowghostx==20 && yellowghostx+20<=40 && yellowghosty==460 && yellowghosty+40<=500){
                    gowhere=(int)(Math.random()*2+1);
                    if(gowhere==1){
                        yellowxInc=2;
                        yellowyInc=0;

                    }
                    else if(gowhere==2){
                        yellowxInc=0;
                        yellowyInc=-2;

                    }

                }

                if(yellowghostx==480 && yellowghostx+20<=500 && yellowghosty==0 && yellowghosty+40<=40){
                    gowhere=(int)(Math.random()*2+1);
                    if(gowhere==1){
                        yellowxInc=-2;
                        yellowyInc=0;

                    }
                    else if(gowhere==2){
                        yellowxInc=0;
                        yellowyInc=2;

                    }

                }
                if(yellowghostx==480 && yellowghostx+20<=500 && yellowghosty==460 && yellowghosty+40<=500){
                    gowhere=(int)(Math.random()*2+1);
                    if(gowhere==1){
                        yellowxInc=-2;
                        yellowyInc=0;

                    }
                    else if(gowhere==2){
                        yellowxInc=0;
                        yellowyInc=-2;

                    }

                }
                if(yellowghostx==240 && yellowghosty==0 ){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        yellowxInc=2;
                        yellowyInc=0;

                    }
                    else if(gowhere==2){
                        yellowxInc=0;
                        yellowyInc=2;

                    }
                    else if(gowhere==3){
                        yellowxInc=-2;
                        yellowyInc=0;

                    }

                }
                if(yellowghostx==240 && yellowghosty==80 ){
                    gowhere=(int)(Math.random()*4+1);
                    if(gowhere==1){
                        yellowxInc=2;
                        yellowyInc=0;

                    }
                    else if(gowhere==2){
                        yellowxInc=0;
                        yellowyInc=-2;

                    }
                    else if(gowhere==3){
                        yellowxInc=-2;
                        yellowyInc=0;

                    }
                    else if(gowhere==4){
                        yellowxInc=0;
                        yellowyInc=2;

                    }
                }
                if(yellowghostx==240 && yellowghosty==240 ){
                    gowhere=(int)(Math.random()*4+1);
                    if(gowhere==1){
                        yellowxInc=2;
                        yellowyInc=0;

                    }
                    else if(gowhere==2){
                        yellowxInc=0;
                        yellowyInc=-2;

                    }
                    else if(gowhere==3){
                        yellowxInc=-2;
                        yellowyInc=0;

                    }
                    else if(gowhere==4){
                        yellowxInc=0;
                        yellowyInc=2;

                    }
                }
                if(yellowghostx==240 && yellowghosty==360 ){
                    gowhere=(int)(Math.random()*4+1);
                    if(gowhere==1){
                        yellowxInc=2;
                        yellowyInc=0;

                    }
                    else if(gowhere==2){
                        yellowxInc=0;
                        yellowyInc=-2;

                    }
                    else if(gowhere==3){
                        yellowxInc=-2;
                        yellowyInc=0;

                    }
                    else if(gowhere==4){
                        yellowxInc=0;
                        yellowyInc=2;

                    }
                }
                if(yellowghostx==240 && yellowghosty==460 ){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        yellowxInc=2;
                        yellowyInc=0;

                    }
                    else if(gowhere==2){
                        yellowxInc=0;
                        yellowyInc=-2;

                    }
                    else if(gowhere==3){
                        yellowxInc=2;
                        yellowyInc=0;

                    }
                }
                if(yellowghostx==20 && yellowghosty==240 ){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        yellowxInc=2;
                        yellowyInc=0;

                    }

                    else if(gowhere==2){
                        yellowxInc=0;
                        yellowyInc=-2;

                    }
                    else if(gowhere==3){
                        yellowxInc=0;
                        yellowyInc=2;

                    }

                }
                if(yellowghostx==480 && yellowghosty==240 ){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        yellowxInc=-2;
                        yellowyInc=0;

                    }

                    else if(gowhere==2){
                        yellowxInc=0;
                        yellowyInc=-2;

                    }
                    else if(gowhere==3){
                        yellowxInc=0;
                        yellowyInc=2;

                    }

                }
                if(yellowghostx==80 && yellowghosty==80 ){
                    gowhere=(int)(Math.random()*2+1);
                    if(gowhere==1){
                        yellowxInc=2;
                        yellowyInc=0;

                    }
                    else if(gowhere==2){
                        yellowxInc=0;
                        yellowyInc=2;

                    }

                }
                if(yellowghostx==400 && yellowghosty==80 ){
                    gowhere=(int)(Math.random()*2+1);
                    if(gowhere==1){
                        yellowxInc=-2;
                        yellowyInc=0;

                    }
                    else if(gowhere==2){
                        yellowxInc=0;
                        yellowyInc=2;

                    }

                }
                if(yellowghostx==80 && yellowghosty==360 ){
                    gowhere=(int)(Math.random()*2+1);
                    if(gowhere==1){
                        yellowxInc=2;
                        yellowyInc=0;

                    }
                    else if(gowhere==2){
                        yellowxInc=0;
                        yellowyInc=-2;

                    }

                }
                if(yellowghostx==400 && yellowghosty==360 ){
                    gowhere=(int)(Math.random()*2+1);
                    if(gowhere==1){
                        yellowxInc=-2;
                        yellowyInc=0;

                    }
                    else if(gowhere==2){
                        yellowxInc=0;
                        yellowyInc=-2;

                    }

                }
                if(yellowghostx==80 && yellowghosty==240 ){
                    gowhere=(int)(Math.random()*4+1);
                    if(gowhere==1){
                        yellowxInc=2;
                        yellowyInc=0;

                    }
                    else if(gowhere==2){
                        yellowxInc=0;
                        yellowyInc=-2;

                    }
                    else if(gowhere==3){
                        yellowxInc=-2;
                        yellowyInc=0;

                    }
                    else if(gowhere==4){
                        yellowxInc=0;
                        yellowyInc=2;

                    }
                }
                if(yellowghostx==400 && yellowghosty==240 ){
                    gowhere=(int)(Math.random()*4+1);
                    if(gowhere==1){
                        yellowxInc=2;
                        yellowyInc=0;

                    }
                    else if(gowhere==2){
                        yellowxInc=0;
                        yellowyInc=-2;

                    }
                    else if(gowhere==3){
                        yellowxInc=-2;
                        yellowyInc=0;

                    }
                    else if(gowhere==4){
                        yellowxInc=0;
                        yellowyInc=2;

                    }
                }

                pinkghostx+=pinkxInc;
                pinkghosty+=pinkyInc;
                blueghostx+=bluexInc;
                blueghosty+=blueyInc;
                orangeghostx+=orangexInc;
                orangeghosty+=orangeyInc;
                redghostx+=redxInc;
                redghosty+=redyInc;
                whiteghostx+=whitexInc;
                whiteghosty+=whiteyInc;
                yellowghostx+=yellowxInc;
                yellowghosty+=yellowyInc;

            }
        }
        if(level==6){
            g.setColor(Color.WHITE);
            g.fillRect(40,40,60,60);
            g.fillRect(140,40,80,60);
            g.fillRect(260,40,80,60);
            g.fillRect(380,40,80,60);
            g.fillRect(40,140,60,60);
            g.fillRect(140,140,80,60);
            g.fillRect(260,140,80,60);
            g.fillRect(380,140,80,60);
            g.fillRect(40,240,180,80);
            g.fillRect(260,240,200,80);
            g.fillRect(100,360,120,40);
            g.fillRect(260,360,120,40);
            g.fillRect(40,360,20,100);
            g.fillRect(40,440,180,20);
            g.fillRect(260,440,200,20);
            g.fillRect(420,360,40,100);
            g.drawLine(100,40,140,40);
            g.drawLine(220,200,260,200);
            g.drawLine(340,40,380,40);
            if(counter==0){     //alternating pacman
                if(whichway==1){//face right
                    g.setColor(Color.YELLOW);       
                    g.fillArc(pacx,pacy,30,30,20,320);   //pacman facing right
                    g.setColor(Color.BLACK);      //color of eye
                    g.fillOval(pacx+15,pacy+6,2,2);     // eyeball
                }
                else if(whichway==2){// face left
                    g.setColor(Color.YELLOW);
                    g.fillArc(pacx,pacy,30,30,200,320);  //pacman facing left
                    g.setColor(Color.BLACK);      //color of the eye
                    g.fillOval(pacx+15,pacy+6,2,2);    //eyeball
                }
                else if(whichway==3){// face up
                    g.setColor(Color.YELLOW);
                    g.fillArc(pacx,pacy,30,30,110,310);  //pacman facing left
                    g.setColor(Color.BLACK);      //color of the eye
                    g.fillOval(pacx+22,pacy+20,2,2);    //eyeball
                }
                else if(whichway==4){// face down
                    g.setColor(Color.YELLOW);
                    g.fillArc(pacx,pacy,30,30,310,290);  //pacman facing left
                    g.setColor(Color.BLACK);      //color of the eye
                    g.fillOval(pacx+22,pacy+8,2,2);    //eyeball
                }
                else{
                    g.setColor(Color.YELLOW);
                    g.fillOval(pacx,pacy,30,30);    //closed mouth
                    g.setColor(Color.BLACK);       //color of eye
                    g.fillOval(pacx+19,pacy+8,2,2);   //eyeball
                }
            }
            g.setColor(Color.RED);
            g.drawString("Pacx="+pacx,400,260);
            g.drawString("Pacy="+pacy,400,270);
            g.setColor(Color.BLUE);
            Polygon blueGhost=new Polygon();
            blueGhost.addPoint(blueghostx,blueghosty);
            blueGhost.addPoint(blueghostx+20,blueghosty+10);
            blueGhost.addPoint(blueghostx+10,blueghosty+40);
            blueGhost.addPoint(blueghostx,blueghosty+20);
            blueGhost.addPoint(blueghostx-10,blueghosty+40);
            blueGhost.addPoint(blueghostx-20,blueghosty+10);
            g.fillPolygon(blueGhost);
            g.setColor(Color.PINK);
            Polygon pinkGhost=new Polygon();
            pinkGhost.addPoint(pinkghostx,pinkghosty);
            pinkGhost.addPoint(pinkghostx+20,pinkghosty+10);
            pinkGhost.addPoint(pinkghostx+10,pinkghosty+40);
            pinkGhost.addPoint(pinkghostx,pinkghosty+20);
            pinkGhost.addPoint(pinkghostx-10,pinkghosty+40);
            pinkGhost.addPoint(pinkghostx-20,pinkghosty+10);
            g.fillPolygon(pinkGhost);
            g.setColor(Color.ORANGE);
            Polygon orangeGhost=new Polygon();
            orangeGhost.addPoint(orangeghostx,orangeghosty);
            orangeGhost.addPoint(orangeghostx+20,orangeghosty+10);
            orangeGhost.addPoint(orangeghostx+10,orangeghosty+40);
            orangeGhost.addPoint(orangeghostx,orangeghosty+20);
            orangeGhost.addPoint(orangeghostx-10,orangeghosty+40);
            orangeGhost.addPoint(orangeghostx-20,orangeghosty+10);
            g.fillPolygon(orangeGhost);
            g.setColor(Color.RED);
            Polygon redGhost=new Polygon();
            redGhost.addPoint(redghostx,redghosty);
            redGhost.addPoint(redghostx+20,redghosty+10);
            redGhost.addPoint(redghostx+10,redghosty+40);
            redGhost.addPoint(redghostx,redghosty+20);
            redGhost.addPoint(redghostx-10,redghosty+40);
            redGhost.addPoint(redghostx-20,redghosty+10);
            g.fillPolygon(redGhost);
            g.setColor(Color.YELLOW);
            Polygon yellowGhost=new Polygon();
            yellowGhost.addPoint( yellowghostx, yellowghosty);
            yellowGhost.addPoint( yellowghostx+20, yellowghosty+10);
            yellowGhost.addPoint( yellowghostx+10, yellowghosty+40);
            yellowGhost.addPoint( yellowghostx, yellowghosty+20);
            yellowGhost.addPoint( yellowghostx-10, yellowghosty+40);
            yellowGhost.addPoint( yellowghostx-20, yellowghosty+10);
            g.fillPolygon(yellowGhost);
            g.setColor(Color.WHITE);
            Polygon whiteghost=new Polygon();
            whiteghost.addPoint( whiteghostx, whiteghosty);
            whiteghost.addPoint( whiteghostx+20, whiteghosty+10);
            whiteghost.addPoint( whiteghostx+10, whiteghosty+40);
            whiteghost.addPoint( whiteghostx, whiteghosty+20);
            whiteghost.addPoint( whiteghostx-10, whiteghosty+40);
            whiteghost.addPoint( whiteghostx-20, whiteghosty+10);
            g.fillPolygon(whiteghost);
            g.setColor(Color.GREEN);
            Polygon greenGhost=new Polygon();
            greenGhost.addPoint( greenghostx, greenghosty);
            greenGhost.addPoint( greenghostx+20, greenghosty+10);
            greenGhost.addPoint( greenghostx+10, greenghosty+40);
            greenGhost.addPoint( greenghostx, greenghosty+20);
            greenGhost.addPoint( greenghostx-10, greenghosty+40);
            greenGhost.addPoint( greenghostx-20, greenghosty+10);
            g.fillPolygon(greenGhost);
            g.setColor(Color.MAGENTA);
            Polygon purpleGhost=new Polygon();
            purpleGhost.addPoint( purpleghostx, purpleghosty);
            purpleGhost.addPoint( purpleghostx+20, purpleghosty+10);
            purpleGhost.addPoint( purpleghostx+10, purpleghosty+40);
            purpleGhost.addPoint( purpleghostx, purpleghosty+20);
            purpleGhost.addPoint( purpleghostx-10, purpleghosty+40);
            purpleGhost.addPoint( purpleghostx-20, purpleghosty+10);
            g.fillPolygon(purpleGhost);

            g.setColor(Color.BLACK);
            g.fillOval(pinkghostx-10,pinkghosty+10,5,5);// left eye of pink ghost
            g.fillOval(pinkghostx+5,pinkghosty+10,5,5);// right eye of pink ghost
            g.fillOval(blueghostx-10,blueghosty+10,5,5);// left eye of blue ghost
            g.fillOval(blueghostx+5,blueghosty+10,5,5);// right eye of blue ghost
            g.fillOval(orangeghostx-10,orangeghosty+10,5,5);// left eye of orange ghost
            g.fillOval(orangeghostx+5,orangeghosty+10,5,5);// right eye of orange ghost
            g.fillOval(redghostx-10,redghosty+10,5,5);// left eye of red ghost
            g.fillOval(redghostx+5,redghosty+10,5,5);// right eye of red ghost

            g.fillOval(yellowghostx-10,yellowghosty+10,5,5);// left eye of yellow ghost
            g.fillOval(yellowghostx+5,yellowghosty+10,5,5);// right eye of yellow ghost
            g.fillOval(whiteghostx-10,whiteghosty+10,5,5);// left eye of white ghost
            g.fillOval(whiteghostx+5,whiteghosty+10,5,5);// right eye of white ghost
            g.fillOval(greenghostx-10,greenghosty+10,5,5);// left eye of green ghost
            g.fillOval(greenghostx+5,greenghosty+10,5,5);// right eye of green ghost
            g.fillOval(purpleghostx-10,purpleghosty+10,5,5);// left eye of purple ghost
            g.fillOval(purpleghostx+5,purpleghosty+10,5,5);// right eye of purple ghost
            //ghost collisons
            if(Math.abs(pacx-(blueghostx))<=35 && Math.abs(pacy-blueghosty)<35){
                level=4;
            }
            if(Math.abs(pacx-(pinkghostx))<=35 && Math.abs(pacy-pinkghosty)<35){
                level=4;
            }
            if(Math.abs(pacx-(orangeghostx))<=35 && Math.abs(pacy-orangeghosty)<35){
                level=4;
            }
            if(Math.abs(pacx-(redghostx))<=35 && Math.abs(pacy-redghosty)<35){
                level=4;
            }
            if(Math.abs(pacx-(whiteghostx))<=35 && Math.abs(pacy-whiteghosty)<35){
                level=4;
            }
            if(Math.abs(pacx-(yellowghostx))<=35 && Math.abs(pacy-yellowghosty)<35){
                level=4;
            }
            if(Math.abs(pacx-(greenghostx))<=35 && Math.abs(pacy-greenghosty)<35){
                level=4;
            }
            if(Math.abs(pacx-(purpleghostx))<=35 && Math.abs(pacy-purpleghosty)<35){
                level=4;
            }
            g.setFont(new Font("default",Font.BOLD,10));        
            g.drawString("timer="+time2,150,180);        
            time2+=.01;
            time2=(int)(time2*100+.5)/100.0;
            if(level==6 && time2>21){
                level=7;
                pacx=225;
                pacy=225;
                blueghostx=480;
                blueghosty=0;
                pinkghostx=20;
                pinkghosty=0;
                orangeghostx=20;
                orangeghosty=460;
                redghostx=480;
                redghosty=460;
                whiteghostx=20;
                whiteghosty=240;
                yellowghostx=480;
                yellowghosty=240; 
                greenghosty=0; 
                greenghostx=240; 
                purpleghostx=240;
                purpleghosty=460; 
            }
            if(pacx>15 && pacx<215 && pacy==15){
                pacy-=5;
            }
            if(pacx>235 && pacx<455 && pacy==15){
                pacy-=5;
            }
            if(pacy>15 && pacy<95 && pacx==455){
                pacx+=5;
            }
            if(pacx>355 && pacx<455 && pacy==95){
                pacy+=5;
            }
            if(pacy>15 && pacy<95 && pacx==35){
                pacx-=5;
            }
            if(pacy>15 && pacy<95 && pacx==435){
                pacx+=5;
            }
            if(pacx>235 && pacx<335 && pacy==95){
                pacy+=5;
            }
            if(pacy>15 && pacy<95 && pacx==235){
                pacx-=5;
            }
            if(pacy>15 && pacy<95 && pacx==215){
                pacx+=5;
            }
            if(pacy>15 && pacy<95 && pacx==115){
                pacx-=5;
            }
            if(pacx>115 && pacx<215 && pacy==95){
                pacy+=5;
            }
            if(pacy>470){
                pacy-=5;
            }
            if(pacy<0){
                pacy+=5;
            }
            if(pacx<0){
                pacx+=5;
            }
            if(pacx>470){
                pacx-=5;
            }
            if(pacy>15 && pacy<95 && pacx==335){
                pacx+=5;
            }
            if(pacy>15 && pacy<95 && pacx==95){
                pacx+=5;
            }
            if(pacx>15 && pacx<95 && pacy==95){
                pacy+=5;
            }
            if(pacy>15 && pacy<95 && pacx==15){
                pacx-=5;
            }
            if(pacx>70 && pacx<140 && pacy==40){
                pacy+=5;
            }
            if(pacx>310 && pacx<380 && pacy==40){
                pacy+=5;
            }
            if(pacx>355 && pacx<455 && pacy==195){
                pacy+=5;
            }
            if(pacy>115 && pacy<195 && pacx==455){
                pacx+=5;
            }
            if(pacy>115 && pacy<195 && pacx==355){
                pacx-=5;
            }
            if(pacx>355 && pacx<455 && pacy==115){
                pacy-=5;
            }
            if(pacy>115 && pacy<195 && pacx==335){
                pacx+=5;
            }
            if(pacx>235 && pacx<335 && pacy==115){
                pacy-=5;
            }
            if(pacy>115 && pacy<195 && pacx==235){
                pacx-=5;
            }
            if(pacx>115 && pacx<335 && pacy==195){
                pacy+=5;
            }
            if(pacy>115 && pacy<195 && pacx==215){
                pacx+=5;
            }
            if(pacx>115 && pacx<215 && pacy==115){
                pacy-=5;
            }
            if(pacy>115 && pacy<195 && pacx==115){
                pacx-=5;
            }
            if(pacy>115 && pacy<195 && pacx==95){
                pacx+=5;
            }
            if(pacy>115 && pacy<195 && pacx==15){
                pacx-=5;
            }
            if(pacx>15 && pacx<95 && pacy==195){
                pacy+=5;
            }
            if(pacx>15 && pacx<95 && pacy==115){
                pacy-=5;
            }
            if(pacx>190 && pacx<260 && pacy==175){
                pacy-=5;
            }
            if(pacy>215 && pacy<315 && pacx==455){
                pacx+=5;
            }
            if(pacy>215 && pacy<315 && pacx==235){
                pacx-=5;
            }
            if(pacy>215 && pacy<315 && pacx==215){
                pacx+=5;
            }
            if(pacy>215 && pacy<315 && pacx==15){
                pacx-=5;
            }
            if(pacx>15 && pacx<215 && pacy==215){
                pacy-=5;
            }
            if(pacx>15 && pacx<215 && pacy==315){
                pacy+=5;
            }
            if(pacx>75 && pacx<215 && pacy==335){
                pacy-=5;
            }
            if(pacx>75 && pacx<215 && pacy==395){
                pacy+=5;
            }
            if(pacy>335 && pacy<395 && pacx==75){
                pacx-=5;
            }
            if(pacy>335 && pacy<395 && pacx==215){
                pacx+=5;
            }
            if(pacy>335 && pacy<395 && pacx==235){
                pacx-=5;
            }
            if(pacy>335 && pacy<395 && pacx==375){
                pacx+=5;
            }
            if(pacx>235 && pacx<375 && pacy==335){
                pacy-=5;
            }
            if(pacx>235 && pacx<375 && pacy==395){
                pacy+=5;
            }
            if(pacy>415 && pacy<455 && pacx==215){
                pacx+=5;
            }
            if(pacy>415 && pacy<455 && pacx==235){
                pacx-=5;
            }
            if(pacx>30 && pacx<215 && pacy==415){
                pacy-=5;
            }
            if(pacy>335 && pacy<435 && pacx==55){
                pacx+=5;
            }
            if(pacy>335 && pacy<435 && pacx==395){
                pacx-=5;
            }
            if(pacx>235 && pacx<415 && pacy==415){
                pacx-=5;
            }
            if(pacx>235 && pacx<455 && pacy==455){
                pacy+=5;
            }
            if(pacy>335 && pacy<455 && pacx==455){
                pacx+=5;
            }
            if(pacx>15 && pacx<55 && pacy==355){
                pacy-=5;
            }
            if(pacy>335 && pacy<445 && pacx==15){
                pacx-=5;
            }
            if(pacx>235 && pacx<455 && pacy==315){
                pacy+=5;
            }
            if(pacx>235 && pacx<455 && pacy==215){
                pacy-=5;
            }
            starttime+=.01;
            if(starttime>=1){

                if(pinkghostx==240 && pinkghosty==460){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        pinkxInc=2;
                        pinkyInc=0;

                    }
                    else if(gowhere==2){
                        pinkxInc=0;
                        pinkyInc=-2;

                    }
                    else if(gowhere==3){
                        pinkxInc=-2;
                        pinkyInc=0;

                    }
                }
                if(pinkghostx==240 && pinkghosty==0){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        pinkxInc=2;
                        pinkyInc=0;

                    }
                    else if(gowhere==2){
                        pinkxInc=0;
                        pinkyInc=2;

                    }
                    else if(gowhere==3){
                        pinkxInc=-2;
                        pinkyInc=0;

                    }
                }
                if(pinkghostx==480 && pinkghosty==100){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        pinkxInc=0;
                        pinkyInc=2;

                    }
                    else if(gowhere==2){
                        pinkxInc=0;
                        pinkyInc=-2;

                    }
                    else if(gowhere==3){
                        pinkxInc=-2;
                        pinkyInc=0;

                    }
                }
                if(pinkghostx==480 && pinkghosty==200){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        pinkxInc=0;
                        pinkyInc=2;

                    }
                    else if(gowhere==2){
                        pinkxInc=0;
                        pinkyInc=-2;

                    }
                    else if(gowhere==3){
                        pinkxInc=-2;
                        pinkyInc=0;

                    }
                }
                if(pinkghostx==480 && pinkghosty==320){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        pinkxInc=0;
                        pinkyInc=2;

                    }
                    else if(gowhere==2){
                        pinkxInc=0;
                        pinkyInc=-2;

                    }
                    else if(gowhere==3){
                        pinkxInc=-2;
                        pinkyInc=0;

                    }
                }
                if(pinkghostx==20 && pinkghosty==100){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        pinkxInc=0;
                        pinkyInc=2;

                    }
                    else if(gowhere==2){
                        pinkxInc=0;
                        pinkyInc=-2;

                    }
                    else if(gowhere==3){
                        pinkxInc=2;
                        pinkyInc=0;

                    }
                }
                if(pinkghostx==20 && pinkghosty==200){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        pinkxInc=0;
                        pinkyInc=2;

                    }
                    else if(gowhere==2){
                        pinkxInc=0;
                        pinkyInc=-2;

                    }
                    else if(gowhere==3){
                        pinkxInc=2;
                        pinkyInc=0;

                    }
                }
                if(pinkghostx==20 && pinkghosty==320){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        pinkxInc=0;
                        pinkyInc=2;

                    }
                    else if(gowhere==2){
                        pinkxInc=0;
                        pinkyInc=-2;

                    }
                    else if(gowhere==3){
                        pinkxInc=2;
                        pinkyInc=0;

                    }
                }
                if(pinkghostx==240 && pinkghosty==200){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        pinkxInc=2;
                        pinkyInc=0;

                    }
                    else if(gowhere==2){
                        pinkxInc=0;
                        pinkyInc=2;

                    }
                    else if(gowhere==3){
                        pinkxInc=-2;
                        pinkyInc=0;

                    }
                }
                if(pinkghostx==120 && pinkghosty==200){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        pinkxInc=2;
                        pinkyInc=0;

                    }
                    else if(gowhere==2){
                        pinkxInc=0;
                        pinkyInc=-2;

                    }
                    else if(gowhere==3){
                        pinkxInc=-2;
                        pinkyInc=0;

                    }
                }
                if(pinkghostx==360 && pinkghosty==200){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        pinkxInc=2;
                        pinkyInc=0;

                    }
                    else if(gowhere==2){
                        pinkxInc=0;
                        pinkyInc=-2;

                    }
                    else if(gowhere==3){
                        pinkxInc=-2;
                        pinkyInc=0;

                    }
                }
                if(pinkghostx==80 && pinkghosty==320){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        pinkxInc=2;
                        pinkyInc=0;

                    }
                    else if(gowhere==2){
                        pinkxInc=0;
                        pinkyInc=2;

                    }
                    else if(gowhere==3){
                        pinkxInc=-2;
                        pinkyInc=0;

                    }
                }
                if(pinkghostx==400 && pinkghosty==320){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        pinkxInc=2;
                        pinkyInc=0;

                    }
                    else if(gowhere==2){
                        pinkxInc=0;
                        pinkyInc=2;

                    }
                    else if(gowhere==3){
                        pinkxInc=-2;
                        pinkyInc=0;

                    }
                }
                if(pinkghostx==360 && pinkghosty==40){
                    gowhere=1;

                    pinkxInc=0;
                    pinkyInc=2;

                }
                if(pinkghostx==120 && pinkghosty==40){
                    gowhere=1;

                    pinkxInc=0;
                    pinkyInc=2;

                }
                if(pinkghostx==240 && pinkghosty==160){
                    gowhere=1;

                    pinkxInc=0;
                    pinkyInc=-2;

                }
                if(pinkghostx==20 && pinkghosty==0){
                    gowhere=(int)(Math.random()*2+1);
                    if(gowhere==1){
                        pinkxInc=2;
                        pinkyInc=0;

                    }
                    else if(gowhere==2){
                        pinkxInc=0;
                        pinkyInc=2;

                    }

                }
                if(pinkghostx==20 && pinkghosty==460){
                    gowhere=(int)(Math.random()*2+1);
                    if(gowhere==1){
                        pinkxInc=2;
                        pinkyInc=0;

                    }
                    else if(gowhere==2){
                        pinkxInc=0;
                        pinkyInc=-2;

                    }

                }
                if(pinkghostx==480 && pinkghosty==460){
                    gowhere=(int)(Math.random()*2+1);
                    if(gowhere==1){
                        pinkxInc=-2;
                        pinkyInc=0;

                    }
                    else if(gowhere==2){
                        pinkxInc=0;
                        pinkyInc=-2;

                    }

                }
                if(pinkghostx==480 && pinkghosty==0){
                    gowhere=(int)(Math.random()*2+1);
                    if(gowhere==1){
                        pinkxInc=-2;
                        pinkyInc=0;

                    }
                    else if(gowhere==2){
                        pinkxInc=0;
                        pinkyInc=2;

                    }

                }
                if(pinkghostx==400 && pinkghosty==400){
                    gowhere=(int)(Math.random()*2+1);
                    if(gowhere==1){
                        pinkxInc=-2;
                        pinkyInc=0;

                    }
                    else if(gowhere==2){
                        pinkxInc=0;
                        pinkyInc=-2;

                    }

                }
                if(pinkghostx==80 && pinkghosty==400){
                    gowhere=(int)(Math.random()*2+1);
                    if(gowhere==1){
                        pinkxInc=2;
                        pinkyInc=0;

                    }
                    else if(gowhere==2){
                        pinkxInc=0;
                        pinkyInc=-2;

                    }

                }
                if(pinkghostx==240 && pinkghosty==100){
                    gowhere=(int)(Math.random()*4+1);
                    if(gowhere==1){
                        pinkxInc=-2;
                        pinkyInc=0;

                    }
                    else if(gowhere==2){
                        pinkxInc=0;
                        pinkyInc=-2;

                    }
                    else if(gowhere==3){
                        pinkxInc=2;
                        pinkyInc=0;

                    }
                    else if(gowhere==4){
                        pinkxInc=0;
                        pinkyInc=2;

                    }
                }
                if(pinkghostx==240 && pinkghosty==320){
                    gowhere=(int)(Math.random()*4+1);
                    if(gowhere==1){
                        pinkxInc=-2;
                        pinkyInc=0;

                    }
                    else if(gowhere==2){
                        pinkxInc=0;
                        pinkyInc=-2;

                    }
                    else if(gowhere==3){
                        pinkxInc=2;
                        pinkyInc=0;

                    }
                    else if(gowhere==4){
                        pinkxInc=0;
                        pinkyInc=2;

                    }
                }
                if(pinkghostx==240 && pinkghosty==400){
                    gowhere=(int)(Math.random()*4+1);
                    if(gowhere==1){
                        pinkxInc=-2;
                        pinkyInc=0;

                    }
                    else if(gowhere==2){
                        pinkxInc=0;
                        pinkyInc=-2;

                    }
                    else if(gowhere==3){
                        pinkxInc=2;
                        pinkyInc=0;

                    }
                    else if(gowhere==4){
                        pinkxInc=0;
                        pinkyInc=2;

                    }
                }
                if(pinkghostx==360 && pinkghosty==100){
                    gowhere=(int)(Math.random()*4+1);
                    if(gowhere==1){
                        pinkxInc=-2;
                        pinkyInc=0;

                    }
                    else if(gowhere==2){
                        pinkxInc=0;
                        pinkyInc=-2;

                    }
                    else if(gowhere==3){
                        pinkxInc=2;
                        pinkyInc=0;

                    }
                    else if(gowhere==4){
                        pinkxInc=0;
                        pinkyInc=2;

                    }
                }
                if(pinkghostx==120 && pinkghosty==100){
                    gowhere=(int)(Math.random()*4+1);
                    if(gowhere==1){
                        pinkxInc=-2;
                        pinkyInc=0;

                    }
                    else if(gowhere==2){
                        pinkxInc=0;
                        pinkyInc=-2;

                    }
                    else if(gowhere==3){
                        pinkxInc=2;
                        pinkyInc=0;

                    }
                    else if(gowhere==4){
                        pinkxInc=0;
                        pinkyInc=2;

                    }

                }
                if(blueghostx==240 && blueghosty==460){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        bluexInc=2;
                        blueyInc=0;

                    }
                    else if(gowhere==2){
                        bluexInc=0;
                        blueyInc=-2;

                    }
                    else if(gowhere==3){
                        bluexInc=-2;
                        blueyInc=0;

                    }
                }
                if(blueghostx==240 && blueghosty==0){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        bluexInc=2;
                        blueyInc=0;

                    }
                    else if(gowhere==2){
                        bluexInc=0;
                        blueyInc=2;

                    }
                    else if(gowhere==3){
                        bluexInc=-2;
                        blueyInc=0;

                    }
                }
                if(blueghostx==480 && blueghosty==100){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        bluexInc=0;
                        blueyInc=2;

                    }
                    else if(gowhere==2){
                        bluexInc=0;
                        blueyInc=-2;

                    }
                    else if(gowhere==3){
                        bluexInc=-2;
                        blueyInc=0;

                    }
                }
                if(blueghostx==480 && blueghosty==200){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        bluexInc=0;
                        blueyInc=2;

                    }
                    else if(gowhere==2){
                        bluexInc=0;
                        blueyInc=-2;

                    }
                    else if(gowhere==3){
                        bluexInc=-2;
                        blueyInc=0;

                    }
                }
                if(blueghostx==480 && blueghosty==320){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        bluexInc=0;
                        blueyInc=2;

                    }
                    else if(gowhere==2){
                        bluexInc=0;
                        blueyInc=-2;

                    }
                    else if(gowhere==3){
                        bluexInc=-2;
                        blueyInc=0;

                    }
                }
                if(blueghostx==20 && blueghosty==100){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        bluexInc=0;
                        blueyInc=2;

                    }
                    else if(gowhere==2){
                        bluexInc=0;
                        blueyInc=-2;

                    }
                    else if(gowhere==3){
                        bluexInc=2;
                        blueyInc=0;

                    }
                }
                if(blueghostx==20 && blueghosty==200){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        bluexInc=0;
                        blueyInc=2;

                    }
                    else if(gowhere==2){
                        bluexInc=0;
                        blueyInc=-2;

                    }
                    else if(gowhere==3){
                        bluexInc=2;
                        blueyInc=0;

                    }
                }
                if(blueghostx==20 && blueghosty==320){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        bluexInc=0;
                        blueyInc=2;

                    }
                    else if(gowhere==2){
                        bluexInc=0;
                        blueyInc=-2;

                    }
                    else if(gowhere==3){
                        bluexInc=2;
                        blueyInc=0;

                    }
                }
                if(blueghostx==240 && blueghosty==200){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        bluexInc=2;
                        blueyInc=0;

                    }
                    else if(gowhere==2){
                        bluexInc=0;
                        blueyInc=2;

                    }
                    else if(gowhere==3){
                        bluexInc=-2;
                        blueyInc=0;

                    }
                }
                if(blueghostx==120 && blueghosty==200){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        bluexInc=2;
                        blueyInc=0;

                    }
                    else if(gowhere==2){
                        bluexInc=0;
                        blueyInc=-2;

                    }
                    else if(gowhere==3){
                        bluexInc=-2;
                        blueyInc=0;

                    }
                }
                if(blueghostx==360 && blueghosty==200){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        bluexInc=2;
                        blueyInc=0;

                    }
                    else if(gowhere==2){
                        bluexInc=0;
                        blueyInc=-2;

                    }
                    else if(gowhere==3){
                        bluexInc=-2;
                        blueyInc=0;

                    }
                }
                if(blueghostx==80 && blueghosty==320){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        bluexInc=2;
                        blueyInc=0;

                    }
                    else if(gowhere==2){
                        bluexInc=0;
                        blueyInc=2;

                    }
                    else if(gowhere==3){
                        bluexInc=-2;
                        blueyInc=0;

                    }
                }
                if(blueghostx==400 && blueghosty==320){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        bluexInc=2;
                        blueyInc=0;

                    }
                    else if(gowhere==2){
                        bluexInc=0;
                        blueyInc=2;

                    }
                    else if(gowhere==3){
                        bluexInc=-2;
                        blueyInc=0;

                    }
                }
                if(blueghostx==360 && blueghosty==40){
                    gowhere=1;

                    bluexInc=0;
                    blueyInc=2;

                }
                if(blueghostx==120 && blueghosty==40){
                    gowhere=1;

                    bluexInc=0;
                    blueyInc=2;

                }
                if(blueghostx==240 && blueghosty==160){
                    gowhere=1;

                    bluexInc=0;
                    blueyInc=-2;

                }
                if(blueghostx==20 && blueghosty==0){
                    gowhere=(int)(Math.random()*2+1);
                    if(gowhere==1){
                        bluexInc=2;
                        blueyInc=0;

                    }
                    else if(gowhere==2){
                        bluexInc=0;
                        blueyInc=2;

                    }

                }
                if(blueghostx==20 && blueghosty==460){
                    gowhere=(int)(Math.random()*2+1);
                    if(gowhere==1){
                        bluexInc=2;
                        blueyInc=0;

                    }
                    else if(gowhere==2){
                        bluexInc=0;
                        blueyInc=-2;

                    }

                }
                if(blueghostx==480 && blueghosty==460){
                    gowhere=(int)(Math.random()*2+1);
                    if(gowhere==1){
                        bluexInc=-2;
                        blueyInc=0;

                    }
                    else if(gowhere==2){
                        bluexInc=0;
                        blueyInc=-2;

                    }

                }
                if(blueghostx==480 && blueghosty==0){
                    gowhere=(int)(Math.random()*2+1);
                    if(gowhere==1){
                        bluexInc=-2;
                        blueyInc=0;

                    }
                    else if(gowhere==2){
                        bluexInc=0;
                        blueyInc=2;

                    }

                }
                if(blueghostx==400 && blueghosty==400){
                    gowhere=(int)(Math.random()*2+1);
                    if(gowhere==1){
                        bluexInc=-2;
                        blueyInc=0;

                    }
                    else if(gowhere==2){
                        bluexInc=0;
                        blueyInc=-2;

                    }

                }
                if(blueghostx==80 && blueghosty==400){
                    gowhere=(int)(Math.random()*2+1);
                    if(gowhere==1){
                        bluexInc=2;
                        blueyInc=0;

                    }
                    else if(gowhere==2){
                        bluexInc=0;
                        blueyInc=-2;

                    }

                }
                if(blueghostx==240 && blueghosty==100){
                    gowhere=(int)(Math.random()*4+1);
                    if(gowhere==1){
                        bluexInc=-2;
                        blueyInc=0;

                    }
                    else if(gowhere==2){
                        bluexInc=0;
                        blueyInc=-2;

                    }
                    else if(gowhere==3){
                        bluexInc=2;
                        blueyInc=0;

                    }
                    else if(gowhere==4){
                        bluexInc=0;
                        blueyInc=2;

                    }
                }
                if(blueghostx==240 && blueghosty==320){
                    gowhere=(int)(Math.random()*4+1);
                    if(gowhere==1){
                        bluexInc=-2;
                        blueyInc=0;

                    }
                    else if(gowhere==2){
                        bluexInc=0;
                        blueyInc=-2;

                    }
                    else if(gowhere==3){
                        bluexInc=2;
                        blueyInc=0;

                    }
                    else if(gowhere==4){
                        bluexInc=0;
                        blueyInc=2;

                    }
                }
                if(blueghostx==240 && blueghosty==400){
                    gowhere=(int)(Math.random()*4+1);
                    if(gowhere==1){
                        bluexInc=-2;
                        blueyInc=0;

                    }
                    else if(gowhere==2){
                        bluexInc=0;
                        blueyInc=-2;

                    }
                    else if(gowhere==3){
                        bluexInc=2;
                        blueyInc=0;

                    }
                    else if(gowhere==4){
                        bluexInc=0;
                        blueyInc=2;

                    }
                }
                if(blueghostx==360 && blueghosty==100){
                    gowhere=(int)(Math.random()*4+1);
                    if(gowhere==1){
                        bluexInc=-2;
                        blueyInc=0;

                    }
                    else if(gowhere==2){
                        bluexInc=0;
                        blueyInc=-2;

                    }
                    else if(gowhere==3){
                        bluexInc=2;
                        blueyInc=0;

                    }
                    else if(gowhere==4){
                        bluexInc=0;
                        blueyInc=2;

                    }
                }
                if(blueghostx==120 && blueghosty==100){
                    gowhere=(int)(Math.random()*4+1);
                    if(gowhere==1){
                        bluexInc=-2;
                        blueyInc=0;

                    }
                    else if(gowhere==2){
                        bluexInc=0;
                        blueyInc=-2;

                    }
                    else if(gowhere==3){
                        bluexInc=2;
                        blueyInc=0;

                    }
                    else if(gowhere==4){
                        bluexInc=0;
                        blueyInc=2;

                    }

                }
                if(orangeghostx==240 && orangeghosty==460){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        orangexInc=2;
                        orangeyInc=0;

                    }
                    else if(gowhere==2){
                        orangexInc=0;
                        orangeyInc=-2;

                    }
                    else if(gowhere==3){
                        orangexInc=-2;
                        orangeyInc=0;

                    }
                }
                if(orangeghostx==240 && orangeghosty==0){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        orangexInc=2;
                        orangeyInc=0;

                    }
                    else if(gowhere==2){
                        orangexInc=0;
                        orangeyInc=2;

                    }
                    else if(gowhere==3){
                        orangexInc=-2;
                        orangeyInc=0;

                    }
                }
                if(orangeghostx==480 && orangeghosty==100){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        orangexInc=0;
                        orangeyInc=2;

                    }
                    else if(gowhere==2){
                        orangexInc=0;
                        orangeyInc=-2;

                    }
                    else if(gowhere==3){
                        orangexInc=-2;
                        orangeyInc=0;

                    }
                }
                if(orangeghostx==480 && orangeghosty==200){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        orangexInc=0;
                        orangeyInc=2;

                    }
                    else if(gowhere==2){
                        orangexInc=0;
                        orangeyInc=-2;

                    }
                    else if(gowhere==3){
                        orangexInc=-2;
                        orangeyInc=0;

                    }
                }
                if(orangeghostx==480 && orangeghosty==320){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        orangexInc=0;
                        orangeyInc=2;

                    }
                    else if(gowhere==2){
                        orangexInc=0;
                        orangeyInc=-2;

                    }
                    else if(gowhere==3){
                        orangexInc=-2;
                        orangeyInc=0;

                    }
                }
                if(orangeghostx==20 && orangeghosty==100){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        orangexInc=0;
                        orangeyInc=2;

                    }
                    else if(gowhere==2){
                        orangexInc=0;
                        orangeyInc=-2;

                    }
                    else if(gowhere==3){
                        orangexInc=2;
                        orangeyInc=0;

                    }
                }
                if(orangeghostx==20 && orangeghosty==200){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        orangexInc=0;
                        orangeyInc=2;

                    }
                    else if(gowhere==2){
                        orangexInc=0;
                        orangeyInc=-2;

                    }
                    else if(gowhere==3){
                        orangexInc=2;
                        orangeyInc=0;

                    }
                }
                if(orangeghostx==20 && orangeghosty==320){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        orangexInc=0;
                        orangeyInc=2;

                    }
                    else if(gowhere==2){
                        orangexInc=0;
                        orangeyInc=-2;

                    }
                    else if(gowhere==3){
                        orangexInc=2;
                        orangeyInc=0;

                    }
                }
                if(orangeghostx==240 && orangeghosty==200){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        orangexInc=2;
                        orangeyInc=0;

                    }
                    else if(gowhere==2){
                        orangexInc=0;
                        orangeyInc=2;

                    }
                    else if(gowhere==3){
                        orangexInc=-2;
                        orangeyInc=0;

                    }
                }
                if(orangeghostx==120 && orangeghosty==200){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        orangexInc=2;
                        orangeyInc=0;

                    }
                    else if(gowhere==2){
                        orangexInc=0;
                        orangeyInc=-2;

                    }
                    else if(gowhere==3){
                        orangexInc=-2;
                        orangeyInc=0;

                    }
                }
                if(orangeghostx==360 && orangeghosty==200){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        orangexInc=2;
                        orangeyInc=0;

                    }
                    else if(gowhere==2){
                        orangexInc=0;
                        orangeyInc=-2;

                    }
                    else if(gowhere==3){
                        orangexInc=-2;
                        orangeyInc=0;

                    }
                }
                if(orangeghostx==80 && orangeghosty==320){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        orangexInc=2;
                        orangeyInc=0;

                    }
                    else if(gowhere==2){
                        orangexInc=0;
                        orangeyInc=2;

                    }
                    else if(gowhere==3){
                        orangexInc=-2;
                        orangeyInc=0;

                    }
                }
                if(orangeghostx==400 && orangeghosty==320){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        orangexInc=2;
                        orangeyInc=0;

                    }
                    else if(gowhere==2){
                        orangexInc=0;
                        orangeyInc=2;

                    }
                    else if(gowhere==3){
                        orangexInc=-2;
                        orangeyInc=0;

                    }
                }
                if(orangeghostx==360 && orangeghosty==40){
                    gowhere=1;

                    orangexInc=0;
                    orangeyInc=2;

                }
                if(orangeghostx==120 && orangeghosty==40){
                    gowhere=1;

                    orangexInc=0;
                    orangeyInc=2;

                }
                if(orangeghostx==240 && orangeghosty==160){
                    gowhere=1;

                    orangexInc=0;
                    orangeyInc=-2;

                }
                if(orangeghostx==20 && orangeghosty==0){
                    gowhere=(int)(Math.random()*2+1);
                    if(gowhere==1){
                        orangexInc=2;
                        orangeyInc=0;

                    }
                    else if(gowhere==2){
                        orangexInc=0;
                        orangeyInc=2;

                    }

                }
                if(orangeghostx==20 && orangeghosty==460){
                    gowhere=(int)(Math.random()*2+1);
                    if(gowhere==1){
                        orangexInc=2;
                        orangeyInc=0;

                    }
                    else if(gowhere==2){
                        orangexInc=0;
                        orangeyInc=-2;

                    }

                }
                if(orangeghostx==480 && orangeghosty==460){
                    gowhere=(int)(Math.random()*2+1);
                    if(gowhere==1){
                        orangexInc=-2;
                        orangeyInc=0;

                    }
                    else if(gowhere==2){
                        orangexInc=0;
                        orangeyInc=-2;

                    }

                }
                if(orangeghostx==480 && orangeghosty==0){
                    gowhere=(int)(Math.random()*2+1);
                    if(gowhere==1){
                        orangexInc=-2;
                        orangeyInc=0;

                    }
                    else if(gowhere==2){
                        orangexInc=0;
                        orangeyInc=2;

                    }

                }
                if(orangeghostx==400 && orangeghosty==400){
                    gowhere=(int)(Math.random()*2+1);
                    if(gowhere==1){
                        orangexInc=-2;
                        orangeyInc=0;

                    }
                    else if(gowhere==2){
                        orangexInc=0;
                        orangeyInc=-2;

                    }

                }
                if(orangeghostx==80 && orangeghosty==400){
                    gowhere=(int)(Math.random()*2+1);
                    if(gowhere==1){
                        orangexInc=2;
                        orangeyInc=0;

                    }
                    else if(gowhere==2){
                        orangexInc=0;
                        orangeyInc=-2;

                    }

                }
                if(orangeghostx==240 && orangeghosty==100){
                    gowhere=(int)(Math.random()*4+1);
                    if(gowhere==1){
                        orangexInc=-2;
                        orangeyInc=0;

                    }
                    else if(gowhere==2){
                        orangexInc=0;
                        orangeyInc=-2;

                    }
                    else if(gowhere==3){
                        orangexInc=2;
                        orangeyInc=0;

                    }
                    else if(gowhere==4){
                        orangexInc=0;
                        orangeyInc=2;

                    }
                }
                if(orangeghostx==240 && orangeghosty==320){
                    gowhere=(int)(Math.random()*4+1);
                    if(gowhere==1){
                        orangexInc=-2;
                        orangeyInc=0;

                    }
                    else if(gowhere==2){
                        orangexInc=0;
                        orangeyInc=-2;

                    }
                    else if(gowhere==3){
                        orangexInc=2;
                        orangeyInc=0;

                    }
                    else if(gowhere==4){
                        orangexInc=0;
                        orangeyInc=2;

                    }
                }
                if(orangeghostx==240 && orangeghosty==400){
                    gowhere=(int)(Math.random()*4+1);
                    if(gowhere==1){
                        orangexInc=-2;
                        orangeyInc=0;

                    }
                    else if(gowhere==2){
                        orangexInc=0;
                        orangeyInc=-2;

                    }
                    else if(gowhere==3){
                        orangexInc=2;
                        orangeyInc=0;

                    }
                    else if(gowhere==4){
                        orangexInc=0;
                        orangeyInc=2;

                    }
                }
                if(orangeghostx==360 && orangeghosty==100){
                    gowhere=(int)(Math.random()*4+1);
                    if(gowhere==1){
                        orangexInc=-2;
                        orangeyInc=0;

                    }
                    else if(gowhere==2){
                        orangexInc=0;
                        orangeyInc=-2;

                    }
                    else if(gowhere==3){
                        orangexInc=2;
                        orangeyInc=0;

                    }
                    else if(gowhere==4){
                        orangexInc=0;
                        orangeyInc=2;

                    }
                }
                if(orangeghostx==120 && orangeghosty==100){
                    gowhere=(int)(Math.random()*4+1);
                    if(gowhere==1){
                        orangexInc=-2;
                        orangeyInc=0;

                    }
                    else if(gowhere==2){
                        orangexInc=0;
                        orangeyInc=-2;

                    }
                    else if(gowhere==3){
                        orangexInc=2;
                        orangeyInc=0;

                    }
                    else if(gowhere==4){
                        orangexInc=0;
                        orangeyInc=2;

                    }

                }
                if(redghostx==240 && redghosty==460){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        redxInc=2;
                        redyInc=0;

                    }
                    else if(gowhere==2){
                        redxInc=0;
                        redyInc=-2;

                    }
                    else if(gowhere==3){
                        redxInc=-2;
                        redyInc=0;

                    }
                }
                if(redghostx==240 && redghosty==0){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        redxInc=2;
                        redyInc=0;

                    }
                    else if(gowhere==2){
                        redxInc=0;
                        redyInc=2;

                    }
                    else if(gowhere==3){
                        redxInc=-2;
                        redyInc=0;

                    }
                }
                if(redghostx==480 && redghosty==100){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        redxInc=0;
                        redyInc=2;

                    }
                    else if(gowhere==2){
                        redxInc=0;
                        redyInc=-2;

                    }
                    else if(gowhere==3){
                        redxInc=-2;
                        redyInc=0;

                    }
                }
                if(redghostx==480 && redghosty==200){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        redxInc=0;
                        redyInc=2;

                    }
                    else if(gowhere==2){
                        redxInc=0;
                        redyInc=-2;

                    }
                    else if(gowhere==3){
                        redxInc=-2;
                        redyInc=0;

                    }
                }
                if(redghostx==480 && redghosty==320){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        redxInc=0;
                        redyInc=2;

                    }
                    else if(gowhere==2){
                        redxInc=0;
                        redyInc=-2;

                    }
                    else if(gowhere==3){
                        redxInc=-2;
                        redyInc=0;

                    }
                }
                if(redghostx==20 && redghosty==100){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        redxInc=0;
                        redyInc=2;

                    }
                    else if(gowhere==2){
                        redxInc=0;
                        redyInc=-2;

                    }
                    else if(gowhere==3){
                        redxInc=2;
                        redyInc=0;

                    }
                }
                if(redghostx==20 && redghosty==200){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        redxInc=0;
                        redyInc=2;

                    }
                    else if(gowhere==2){
                        redxInc=0;
                        redyInc=-2;

                    }
                    else if(gowhere==3){
                        redxInc=2;
                        redyInc=0;

                    }
                }
                if(redghostx==20 && redghosty==320){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        redxInc=0;
                        redyInc=2;

                    }
                    else if(gowhere==2){
                        redxInc=0;
                        redyInc=-2;

                    }
                    else if(gowhere==3){
                        redxInc=2;
                        redyInc=0;

                    }
                }
                if(redghostx==240 && redghosty==200){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        redxInc=2;
                        redyInc=0;

                    }
                    else if(gowhere==2){
                        redxInc=0;
                        redyInc=2;

                    }
                    else if(gowhere==3){
                        redxInc=-2;
                        redyInc=0;

                    }
                }
                if(redghostx==120 && redghosty==200){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        redxInc=2;
                        redyInc=0;

                    }
                    else if(gowhere==2){
                        redxInc=0;
                        redyInc=-2;

                    }
                    else if(gowhere==3){
                        redxInc=-2;
                        redyInc=0;

                    }
                }
                if(redghostx==360 && redghosty==200){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        redxInc=2;
                        redyInc=0;

                    }
                    else if(gowhere==2){
                        redxInc=0;
                        redyInc=-2;

                    }
                    else if(gowhere==3){
                        redxInc=-2;
                        redyInc=0;

                    }
                }
                if(redghostx==80 && redghosty==320){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        redxInc=2;
                        redyInc=0;

                    }
                    else if(gowhere==2){
                        redxInc=0;
                        redyInc=2;

                    }
                    else if(gowhere==3){
                        redxInc=-2;
                        redyInc=0;

                    }
                }
                if(redghostx==400 && redghosty==320){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        redxInc=2;
                        redyInc=0;

                    }
                    else if(gowhere==2){
                        redxInc=0;
                        redyInc=2;

                    }
                    else if(gowhere==3){
                        redxInc=-2;
                        redyInc=0;

                    }
                }
                if(redghostx==360 && redghosty==40){
                    gowhere=1;

                    redxInc=0;
                    redyInc=2;

                }
                if(redghostx==120 && redghosty==40){
                    gowhere=1;

                    redxInc=0;
                    redyInc=2;

                }
                if(redghostx==240 && redghosty==160){
                    gowhere=1;

                    redxInc=0;
                    redyInc=-2;

                }
                if(redghostx==20 && redghosty==0){
                    gowhere=(int)(Math.random()*2+1);
                    if(gowhere==1){
                        redxInc=2;
                        redyInc=0;

                    }
                    else if(gowhere==2){
                        redxInc=0;
                        redyInc=2;

                    }

                }
                if(redghostx==20 && redghosty==460){
                    gowhere=(int)(Math.random()*2+1);
                    if(gowhere==1){
                        redxInc=2;
                        redyInc=0;

                    }
                    else if(gowhere==2){
                        redxInc=0;
                        redyInc=-2;

                    }

                }
                if(redghostx==480 && redghosty==460){
                    gowhere=(int)(Math.random()*2+1);
                    if(gowhere==1){
                        redxInc=-2;
                        redyInc=0;

                    }
                    else if(gowhere==2){
                        redxInc=0;
                        redyInc=-2;

                    }

                }
                if(redghostx==480 && redghosty==0){
                    gowhere=(int)(Math.random()*2+1);
                    if(gowhere==1){
                        redxInc=-2;
                        redyInc=0;

                    }
                    else if(gowhere==2){
                        redxInc=0;
                        redyInc=2;

                    }

                }
                if(redghostx==400 && redghosty==400){
                    gowhere=(int)(Math.random()*2+1);
                    if(gowhere==1){
                        redxInc=-2;
                        redyInc=0;

                    }
                    else if(gowhere==2){
                        redxInc=0;
                        redyInc=-2;

                    }

                }
                if(redghostx==80 && redghosty==400){
                    gowhere=(int)(Math.random()*2+1);
                    if(gowhere==1){
                        redxInc=2;
                        redyInc=0;

                    }
                    else if(gowhere==2){
                        redxInc=0;
                        redyInc=-2;

                    }

                }
                if(redghostx==240 && redghosty==100){
                    gowhere=(int)(Math.random()*4+1);
                    if(gowhere==1){
                        redxInc=-2;
                        redyInc=0;

                    }
                    else if(gowhere==2){
                        redxInc=0;
                        redyInc=-2;

                    }
                    else if(gowhere==3){
                        redxInc=2;
                        redyInc=0;

                    }
                    else if(gowhere==4){
                        redxInc=0;
                        redyInc=2;

                    }
                }
                if(redghostx==240 && redghosty==320){
                    gowhere=(int)(Math.random()*4+1);
                    if(gowhere==1){
                        redxInc=-2;
                        redyInc=0;

                    }
                    else if(gowhere==2){
                        redxInc=0;
                        redyInc=-2;

                    }
                    else if(gowhere==3){
                        redxInc=2;
                        redyInc=0;

                    }
                    else if(gowhere==4){
                        redxInc=0;
                        redyInc=2;

                    }
                }
                if(redghostx==240 && redghosty==400){
                    gowhere=(int)(Math.random()*4+1);
                    if(gowhere==1){
                        redxInc=-2;
                        redyInc=0;

                    }
                    else if(gowhere==2){
                        redxInc=0;
                        redyInc=-2;

                    }
                    else if(gowhere==3){
                        redxInc=2;
                        redyInc=0;

                    }
                    else if(gowhere==4){
                        redxInc=0;
                        redyInc=2;

                    }
                }
                if(redghostx==360 && redghosty==100){
                    gowhere=(int)(Math.random()*4+1);
                    if(gowhere==1){
                        redxInc=-2;
                        redyInc=0;

                    }
                    else if(gowhere==2){
                        redxInc=0;
                        redyInc=-2;

                    }
                    else if(gowhere==3){
                        redxInc=2;
                        redyInc=0;

                    }
                    else if(gowhere==4){
                        redxInc=0;
                        redyInc=2;

                    }
                }
                if(redghostx==120 && redghosty==100){
                    gowhere=(int)(Math.random()*4+1);
                    if(gowhere==1){
                        redxInc=-2;
                        redyInc=0;

                    }
                    else if(gowhere==2){
                        redxInc=0;
                        redyInc=-2;

                    }
                    else if(gowhere==3){
                        redxInc=2;
                        redyInc=0;

                    }
                    else if(gowhere==4){
                        redxInc=0;
                        redyInc=2;

                    }

                }
                if(whiteghostx==240 && whiteghosty==460){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        whitexInc=2;
                        whiteyInc=0;

                    }
                    else if(gowhere==2){
                        whitexInc=0;
                        whiteyInc=-2;

                    }
                    else if(gowhere==3){
                        whitexInc=-2;
                        whiteyInc=0;

                    }
                }
                if(whiteghostx==240 && whiteghosty==0){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        whitexInc=2;
                        whiteyInc=0;

                    }
                    else if(gowhere==2){
                        whitexInc=0;
                        whiteyInc=2;

                    }
                    else if(gowhere==3){
                        whitexInc=-2;
                        whiteyInc=0;

                    }
                }
                if(whiteghostx==480 && whiteghosty==100){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        whitexInc=0;
                        whiteyInc=2;

                    }
                    else if(gowhere==2){
                        whitexInc=0;
                        whiteyInc=-2;

                    }
                    else if(gowhere==3){
                        whitexInc=-2;
                        whiteyInc=0;

                    }
                }
                if(whiteghostx==480 && whiteghosty==200){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        whitexInc=0;
                        whiteyInc=2;

                    }
                    else if(gowhere==2){
                        whitexInc=0;
                        whiteyInc=-2;

                    }
                    else if(gowhere==3){
                        whitexInc=-2;
                        whiteyInc=0;

                    }
                }
                if(whiteghostx==480 && whiteghosty==320){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        whitexInc=0;
                        whiteyInc=2;

                    }
                    else if(gowhere==2){
                        whitexInc=0;
                        whiteyInc=-2;

                    }
                    else if(gowhere==3){
                        whitexInc=-2;
                        whiteyInc=0;

                    }
                }
                if(whiteghostx==20 && whiteghosty==100){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        whitexInc=0;
                        whiteyInc=2;

                    }
                    else if(gowhere==2){
                        whitexInc=0;
                        whiteyInc=-2;

                    }
                    else if(gowhere==3){
                        whitexInc=2;
                        whiteyInc=0;

                    }
                }
                if(whiteghostx==20 && whiteghosty==200){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        whitexInc=0;
                        whiteyInc=2;

                    }
                    else if(gowhere==2){
                        whitexInc=0;
                        whiteyInc=-2;

                    }
                    else if(gowhere==3){
                        whitexInc=2;
                        whiteyInc=0;

                    }
                }
                if(whiteghostx==20 && whiteghosty==320){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        whitexInc=0;
                        whiteyInc=2;

                    }
                    else if(gowhere==2){
                        whitexInc=0;
                        whiteyInc=-2;

                    }
                    else if(gowhere==3){
                        whitexInc=2;
                        whiteyInc=0;

                    }
                }
                if(whiteghostx==240 && whiteghosty==200){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        whitexInc=2;
                        whiteyInc=0;

                    }
                    else if(gowhere==2){
                        whitexInc=0;
                        whiteyInc=2;

                    }
                    else if(gowhere==3){
                        whitexInc=-2;
                        whiteyInc=0;

                    }
                }
                if(whiteghostx==120 && whiteghosty==200){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        whitexInc=2;
                        whiteyInc=0;

                    }
                    else if(gowhere==2){
                        whitexInc=0;
                        whiteyInc=-2;

                    }
                    else if(gowhere==3){
                        whitexInc=-2;
                        whiteyInc=0;

                    }
                }
                if(whiteghostx==360 && whiteghosty==200){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        whitexInc=2;
                        whiteyInc=0;

                    }
                    else if(gowhere==2){
                        whitexInc=0;
                        whiteyInc=-2;

                    }
                    else if(gowhere==3){
                        whitexInc=-2;
                        whiteyInc=0;

                    }
                }
                if(whiteghostx==80 && whiteghosty==320){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        whitexInc=2;
                        whiteyInc=0;

                    }
                    else if(gowhere==2){
                        whitexInc=0;
                        whiteyInc=2;

                    }
                    else if(gowhere==3){
                        whitexInc=-2;
                        whiteyInc=0;

                    }
                }
                if(whiteghostx==400 && whiteghosty==320){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        whitexInc=2;
                        whiteyInc=0;

                    }
                    else if(gowhere==2){
                        whitexInc=0;
                        whiteyInc=2;

                    }
                    else if(gowhere==3){
                        whitexInc=-2;
                        whiteyInc=0;

                    }
                }
                if(whiteghostx==360 && whiteghosty==40){
                    gowhere=1;

                    whitexInc=0;
                    whiteyInc=2;

                }
                if(whiteghostx==120 && whiteghosty==40){
                    gowhere=1;

                    whitexInc=0;
                    whiteyInc=2;

                }
                if(whiteghostx==240 && whiteghosty==160){
                    gowhere=1;

                    whitexInc=0;
                    whiteyInc=-2;

                }
                if(whiteghostx==20 && whiteghosty==0){
                    gowhere=(int)(Math.random()*2+1);
                    if(gowhere==1){
                        whitexInc=2;
                        whiteyInc=0;

                    }
                    else if(gowhere==2){
                        whitexInc=0;
                        whiteyInc=2;

                    }

                }
                if(whiteghostx==20 && whiteghosty==460){
                    gowhere=(int)(Math.random()*2+1);
                    if(gowhere==1){
                        whitexInc=2;
                        whiteyInc=0;

                    }
                    else if(gowhere==2){
                        whitexInc=0;
                        whiteyInc=-2;

                    }

                }
                if(whiteghostx==480 && whiteghosty==460){
                    gowhere=(int)(Math.random()*2+1);
                    if(gowhere==1){
                        whitexInc=-2;
                        whiteyInc=0;

                    }
                    else if(gowhere==2){
                        whitexInc=0;
                        whiteyInc=-2;

                    }

                }
                if(whiteghostx==480 && whiteghosty==0){
                    gowhere=(int)(Math.random()*2+1);
                    if(gowhere==1){
                        whitexInc=-2;
                        whiteyInc=0;

                    }
                    else if(gowhere==2){
                        whitexInc=0;
                        whiteyInc=2;

                    }

                }
                if(whiteghostx==400 && whiteghosty==400){
                    gowhere=(int)(Math.random()*2+1);
                    if(gowhere==1){
                        whitexInc=-2;
                        whiteyInc=0;

                    }
                    else if(gowhere==2){
                        whitexInc=0;
                        whiteyInc=-2;

                    }

                }
                if(whiteghostx==80 && whiteghosty==400){
                    gowhere=(int)(Math.random()*2+1);
                    if(gowhere==1){
                        whitexInc=2;
                        whiteyInc=0;

                    }
                    else if(gowhere==2){
                        whitexInc=0;
                        whiteyInc=-2;

                    }

                }
                if(whiteghostx==240 && whiteghosty==100){
                    gowhere=(int)(Math.random()*4+1);
                    if(gowhere==1){
                        whitexInc=-2;
                        whiteyInc=0;

                    }
                    else if(gowhere==2){
                        whitexInc=0;
                        whiteyInc=-2;

                    }
                    else if(gowhere==3){
                        whitexInc=2;
                        whiteyInc=0;

                    }
                    else if(gowhere==4){
                        whitexInc=0;
                        whiteyInc=2;

                    }
                }
                if(whiteghostx==240 && whiteghosty==320){
                    gowhere=(int)(Math.random()*4+1);
                    if(gowhere==1){
                        whitexInc=-2;
                        whiteyInc=0;

                    }
                    else if(gowhere==2){
                        whitexInc=0;
                        whiteyInc=-2;

                    }
                    else if(gowhere==3){
                        whitexInc=2;
                        whiteyInc=0;

                    }
                    else if(gowhere==4){
                        whitexInc=0;
                        whiteyInc=2;

                    }
                }
                if(whiteghostx==240 && whiteghosty==400){
                    gowhere=(int)(Math.random()*4+1);
                    if(gowhere==1){
                        whitexInc=-2;
                        whiteyInc=0;

                    }
                    else if(gowhere==2){
                        whitexInc=0;
                        whiteyInc=-2;

                    }
                    else if(gowhere==3){
                        whitexInc=2;
                        whiteyInc=0;

                    }
                    else if(gowhere==4){
                        whitexInc=0;
                        whiteyInc=2;

                    }
                }
                if(whiteghostx==360 && whiteghosty==100){
                    gowhere=(int)(Math.random()*4+1);
                    if(gowhere==1){
                        whitexInc=-2;
                        whiteyInc=0;

                    }
                    else if(gowhere==2){
                        whitexInc=0;
                        whiteyInc=-2;

                    }
                    else if(gowhere==3){
                        whitexInc=2;
                        whiteyInc=0;

                    }
                    else if(gowhere==4){
                        whitexInc=0;
                        whiteyInc=2;

                    }
                }
                if(whiteghostx==120 && whiteghosty==100){
                    gowhere=(int)(Math.random()*4+1);
                    if(gowhere==1){
                        whitexInc=-2;
                        whiteyInc=0;

                    }
                    else if(gowhere==2){
                        whitexInc=0;
                        whiteyInc=-2;

                    }
                    else if(gowhere==3){
                        whitexInc=2;
                        whiteyInc=0;

                    }
                    else if(gowhere==4){
                        whitexInc=0;
                        whiteyInc=2;

                    }

                }
                if(yellowghostx==240 && yellowghosty==460){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        yellowxInc=2;
                        yellowyInc=0;

                    }
                    else if(gowhere==2){
                        yellowxInc=0;
                        yellowyInc=-2;

                    }
                    else if(gowhere==3){
                        yellowxInc=-2;
                        yellowyInc=0;

                    }
                }
                if(yellowghostx==240 && yellowghosty==0){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        yellowxInc=2;
                        yellowyInc=0;

                    }
                    else if(gowhere==2){
                        yellowxInc=0;
                        yellowyInc=2;

                    }
                    else if(gowhere==3){
                        yellowxInc=-2;
                        yellowyInc=0;

                    }
                }
                if(yellowghostx==480 && yellowghosty==100){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        yellowxInc=0;
                        yellowyInc=2;

                    }
                    else if(gowhere==2){
                        yellowxInc=0;
                        yellowyInc=-2;

                    }
                    else if(gowhere==3){
                        yellowxInc=-2;
                        yellowyInc=0;

                    }
                }
                if(yellowghostx==480 && yellowghosty==200){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        yellowxInc=0;
                        yellowyInc=2;

                    }
                    else if(gowhere==2){
                        yellowxInc=0;
                        yellowyInc=-2;

                    }
                    else if(gowhere==3){
                        yellowxInc=-2;
                        yellowyInc=0;

                    }
                }
                if(yellowghostx==480 && yellowghosty==320){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        yellowxInc=0;
                        yellowyInc=2;

                    }
                    else if(gowhere==2){
                        yellowxInc=0;
                        yellowyInc=-2;

                    }
                    else if(gowhere==3){
                        yellowxInc=-2;
                        yellowyInc=0;

                    }
                }
                if(yellowghostx==20 && yellowghosty==100){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        yellowxInc=0;
                        yellowyInc=2;

                    }
                    else if(gowhere==2){
                        yellowxInc=0;
                        yellowyInc=-2;

                    }
                    else if(gowhere==3){
                        yellowxInc=2;
                        yellowyInc=0;

                    }
                }
                if(yellowghostx==20 && yellowghosty==200){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        yellowxInc=0;
                        yellowyInc=2;

                    }
                    else if(gowhere==2){
                        yellowxInc=0;
                        yellowyInc=-2;

                    }
                    else if(gowhere==3){
                        yellowxInc=2;
                        yellowyInc=0;

                    }
                }
                if(yellowghostx==20 && yellowghosty==320){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        yellowxInc=0;
                        yellowyInc=2;

                    }
                    else if(gowhere==2){
                        yellowxInc=0;
                        yellowyInc=-2;

                    }
                    else if(gowhere==3){
                        yellowxInc=2;
                        yellowyInc=0;

                    }
                }
                if(yellowghostx==240 && yellowghosty==200){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        yellowxInc=2;
                        yellowyInc=0;

                    }
                    else if(gowhere==2){
                        yellowxInc=0;
                        yellowyInc=2;

                    }
                    else if(gowhere==3){
                        yellowxInc=-2;
                        yellowyInc=0;

                    }
                }
                if(yellowghostx==120 && yellowghosty==200){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        yellowxInc=2;
                        yellowyInc=0;

                    }
                    else if(gowhere==2){
                        yellowxInc=0;
                        yellowyInc=-2;

                    }
                    else if(gowhere==3){
                        yellowxInc=-2;
                        yellowyInc=0;

                    }
                }
                if(yellowghostx==360 && yellowghosty==200){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        yellowxInc=2;
                        yellowyInc=0;

                    }
                    else if(gowhere==2){
                        yellowxInc=0;
                        yellowyInc=-2;

                    }
                    else if(gowhere==3){
                        yellowxInc=-2;
                        yellowyInc=0;

                    }
                }
                if(yellowghostx==80 && yellowghosty==320){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        yellowxInc=2;
                        yellowyInc=0;

                    }
                    else if(gowhere==2){
                        yellowxInc=0;
                        yellowyInc=2;

                    }
                    else if(gowhere==3){
                        yellowxInc=-2;
                        yellowyInc=0;

                    }
                }
                if(yellowghostx==400 && yellowghosty==320){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        yellowxInc=2;
                        yellowyInc=0;

                    }
                    else if(gowhere==2){
                        yellowxInc=0;
                        yellowyInc=2;

                    }
                    else if(gowhere==3){
                        yellowxInc=-2;
                        yellowyInc=0;

                    }
                }
                if(yellowghostx==360 && yellowghosty==40){
                    gowhere=1;

                    yellowxInc=0;
                    yellowyInc=2;

                }
                if(yellowghostx==120 && yellowghosty==40){
                    gowhere=1;

                    yellowxInc=0;
                    yellowyInc=2;

                }
                if(yellowghostx==240 && yellowghosty==160){
                    gowhere=1;

                    yellowxInc=0;
                    yellowyInc=-2;

                }
                if(yellowghostx==20 && yellowghosty==0){
                    gowhere=(int)(Math.random()*2+1);
                    if(gowhere==1){
                        yellowxInc=2;
                        yellowyInc=0;

                    }
                    else if(gowhere==2){
                        yellowxInc=0;
                        yellowyInc=2;

                    }

                }
                if(yellowghostx==20 && yellowghosty==460){
                    gowhere=(int)(Math.random()*2+1);
                    if(gowhere==1){
                        yellowxInc=2;
                        yellowyInc=0;

                    }
                    else if(gowhere==2){
                        yellowxInc=0;
                        yellowyInc=-2;

                    }

                }
                if(yellowghostx==480 && yellowghosty==460){
                    gowhere=(int)(Math.random()*2+1);
                    if(gowhere==1){
                        yellowxInc=-2;
                        yellowyInc=0;

                    }
                    else if(gowhere==2){
                        yellowxInc=0;
                        yellowyInc=-2;

                    }

                }
                if(yellowghostx==480 && yellowghosty==0){
                    gowhere=(int)(Math.random()*2+1);
                    if(gowhere==1){
                        yellowxInc=-2;
                        yellowyInc=0;

                    }
                    else if(gowhere==2){
                        yellowxInc=0;
                        yellowyInc=2;

                    }

                }
                if(yellowghostx==400 && yellowghosty==400){
                    gowhere=(int)(Math.random()*2+1);
                    if(gowhere==1){
                        yellowxInc=-2;
                        yellowyInc=0;

                    }
                    else if(gowhere==2){
                        yellowxInc=0;
                        yellowyInc=-2;

                    }

                }
                if(yellowghostx==80 && yellowghosty==400){
                    gowhere=(int)(Math.random()*2+1);
                    if(gowhere==1){
                        yellowxInc=2;
                        yellowyInc=0;

                    }
                    else if(gowhere==2){
                        yellowxInc=0;
                        yellowyInc=-2;

                    }

                }
                if(yellowghostx==240 && yellowghosty==100){
                    gowhere=(int)(Math.random()*4+1);
                    if(gowhere==1){
                        yellowxInc=-2;
                        yellowyInc=0;

                    }
                    else if(gowhere==2){
                        yellowxInc=0;
                        yellowyInc=-2;

                    }
                    else if(gowhere==3){
                        yellowxInc=2;
                        yellowyInc=0;

                    }
                    else if(gowhere==4){
                        yellowxInc=0;
                        yellowyInc=2;

                    }
                }
                if(yellowghostx==240 && yellowghosty==320){
                    gowhere=(int)(Math.random()*4+1);
                    if(gowhere==1){
                        yellowxInc=-2;
                        yellowyInc=0;

                    }
                    else if(gowhere==2){
                        yellowxInc=0;
                        yellowyInc=-2;

                    }
                    else if(gowhere==3){
                        yellowxInc=2;
                        yellowyInc=0;

                    }
                    else if(gowhere==4){
                        yellowxInc=0;
                        yellowyInc=2;

                    }
                }
                if(yellowghostx==240 && yellowghosty==400){
                    gowhere=(int)(Math.random()*4+1);
                    if(gowhere==1){
                        yellowxInc=-2;
                        yellowyInc=0;

                    }
                    else if(gowhere==2){
                        yellowxInc=0;
                        yellowyInc=-2;

                    }
                    else if(gowhere==3){
                        yellowxInc=2;
                        yellowyInc=0;

                    }
                    else if(gowhere==4){
                        yellowxInc=0;
                        yellowyInc=2;

                    }
                }
                if(yellowghostx==360 && yellowghosty==100){
                    gowhere=(int)(Math.random()*4+1);
                    if(gowhere==1){
                        yellowxInc=-2;
                        yellowyInc=0;

                    }
                    else if(gowhere==2){
                        yellowxInc=0;
                        yellowyInc=-2;

                    }
                    else if(gowhere==3){
                        yellowxInc=2;
                        yellowyInc=0;

                    }
                    else if(gowhere==4){
                        yellowxInc=0;
                        yellowyInc=2;

                    }
                }
                if(yellowghostx==120 && yellowghosty==100){
                    gowhere=(int)(Math.random()*4+1);
                    if(gowhere==1){
                        yellowxInc=-2;
                        yellowyInc=0;

                    }
                    else if(gowhere==2){
                        yellowxInc=0;
                        yellowyInc=-2;

                    }
                    else if(gowhere==3){
                        yellowxInc=2;
                        yellowyInc=0;

                    }
                    else if(gowhere==4){
                        yellowxInc=0;
                        yellowyInc=2;

                    }

                }
                if(greenghostx==240 && greenghosty==460){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        greenxInc=2;
                        greenyInc=0;

                    }
                    else if(gowhere==2){
                        greenxInc=0;
                        greenyInc=-2;

                    }
                    else if(gowhere==3){
                        greenxInc=-2;
                        greenyInc=0;

                    }
                }
                if(greenghostx==240 && greenghosty==0){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        greenxInc=2;
                        greenyInc=0;

                    }
                    else if(gowhere==2){
                        greenxInc=0;
                        greenyInc=2;

                    }
                    else if(gowhere==3){
                        greenxInc=-2;
                        greenyInc=0;

                    }
                }
                if(greenghostx==480 && greenghosty==100){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        greenxInc=0;
                        greenyInc=2;

                    }
                    else if(gowhere==2){
                        greenxInc=0;
                        greenyInc=-2;

                    }
                    else if(gowhere==3){
                        greenxInc=-2;
                        greenyInc=0;

                    }
                }
                if(greenghostx==480 && greenghosty==200){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        greenxInc=0;
                        greenyInc=2;

                    }
                    else if(gowhere==2){
                        greenxInc=0;
                        greenyInc=-2;

                    }
                    else if(gowhere==3){
                        greenxInc=-2;
                        greenyInc=0;

                    }
                }
                if(greenghostx==480 && greenghosty==320){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        greenxInc=0;
                        greenyInc=2;

                    }
                    else if(gowhere==2){
                        greenxInc=0;
                        greenyInc=-2;

                    }
                    else if(gowhere==3){
                        greenxInc=-2;
                        greenyInc=0;

                    }
                }
                if(greenghostx==20 && greenghosty==100){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        greenxInc=0;
                        greenyInc=2;

                    }
                    else if(gowhere==2){
                        greenxInc=0;
                        greenyInc=-2;

                    }
                    else if(gowhere==3){
                        greenxInc=2;
                        greenyInc=0;

                    }
                }
                if(greenghostx==20 && greenghosty==200){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        greenxInc=0;
                        greenyInc=2;

                    }
                    else if(gowhere==2){
                        greenxInc=0;
                        greenyInc=-2;

                    }
                    else if(gowhere==3){
                        greenxInc=2;
                        greenyInc=0;

                    }
                }
                if(greenghostx==20 && greenghosty==320){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        greenxInc=0;
                        greenyInc=2;

                    }
                    else if(gowhere==2){
                        greenxInc=0;
                        greenyInc=-2;

                    }
                    else if(gowhere==3){
                        greenxInc=2;
                        greenyInc=0;

                    }
                }
                if(greenghostx==240 && greenghosty==200){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        greenxInc=2;
                        greenyInc=0;

                    }
                    else if(gowhere==2){
                        greenxInc=0;
                        greenyInc=2;

                    }
                    else if(gowhere==3){
                        greenxInc=-2;
                        greenyInc=0;

                    }
                }
                if(greenghostx==120 && greenghosty==200){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        greenxInc=2;
                        greenyInc=0;

                    }
                    else if(gowhere==2){
                        greenxInc=0;
                        greenyInc=-2;

                    }
                    else if(gowhere==3){
                        greenxInc=-2;
                        greenyInc=0;

                    }
                }
                if(greenghostx==360 && greenghosty==200){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        greenxInc=2;
                        greenyInc=0;

                    }
                    else if(gowhere==2){
                        greenxInc=0;
                        greenyInc=-2;

                    }
                    else if(gowhere==3){
                        greenxInc=-2;
                        greenyInc=0;

                    }
                }
                if(greenghostx==80 && greenghosty==320){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        greenxInc=2;
                        greenyInc=0;

                    }
                    else if(gowhere==2){
                        greenxInc=0;
                        greenyInc=2;

                    }
                    else if(gowhere==3){
                        greenxInc=-2;
                        greenyInc=0;

                    }
                }
                if(greenghostx==400 && greenghosty==320){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        greenxInc=2;
                        greenyInc=0;

                    }
                    else if(gowhere==2){
                        greenxInc=0;
                        greenyInc=2;

                    }
                    else if(gowhere==3){
                        greenxInc=-2;
                        greenyInc=0;

                    }
                }
                if(greenghostx==360 && greenghosty==40){
                    gowhere=1;

                    greenxInc=0;
                    greenyInc=2;

                }
                if(greenghostx==120 && greenghosty==40){
                    gowhere=1;

                    greenxInc=0;
                    greenyInc=2;

                }
                if(greenghostx==240 && greenghosty==160){
                    gowhere=1;

                    greenxInc=0;
                    greenyInc=-2;

                }
                if(greenghostx==20 && greenghosty==0){
                    gowhere=(int)(Math.random()*2+1);
                    if(gowhere==1){
                        greenxInc=2;
                        greenyInc=0;

                    }
                    else if(gowhere==2){
                        greenxInc=0;
                        greenyInc=2;

                    }

                }
                if(greenghostx==20 && greenghosty==460){
                    gowhere=(int)(Math.random()*2+1);
                    if(gowhere==1){
                        greenxInc=2;
                        greenyInc=0;

                    }
                    else if(gowhere==2){
                        greenxInc=0;
                        greenyInc=-2;

                    }

                }
                if(greenghostx==480 && greenghosty==460){
                    gowhere=(int)(Math.random()*2+1);
                    if(gowhere==1){
                        greenxInc=-2;
                        greenyInc=0;

                    }
                    else if(gowhere==2){
                        greenxInc=0;
                        greenyInc=-2;

                    }

                }
                if(greenghostx==480 && greenghosty==0){
                    gowhere=(int)(Math.random()*2+1);
                    if(gowhere==1){
                        greenxInc=-2;
                        greenyInc=0;

                    }
                    else if(gowhere==2){
                        greenxInc=0;
                        greenyInc=2;

                    }

                }
                if(greenghostx==400 && greenghosty==400){
                    gowhere=(int)(Math.random()*2+1);
                    if(gowhere==1){
                        greenxInc=-2;
                        greenyInc=0;

                    }
                    else if(gowhere==2){
                        greenxInc=0;
                        greenyInc=-2;

                    }

                }
                if(greenghostx==80 && greenghosty==400){
                    gowhere=(int)(Math.random()*2+1);
                    if(gowhere==1){
                        greenxInc=2;
                        greenyInc=0;

                    }
                    else if(gowhere==2){
                        greenxInc=0;
                        greenyInc=-2;

                    }

                }
                if(greenghostx==240 && greenghosty==100){
                    gowhere=(int)(Math.random()*4+1);
                    if(gowhere==1){
                        greenxInc=-2;
                        greenyInc=0;

                    }
                    else if(gowhere==2){
                        greenxInc=0;
                        greenyInc=-2;

                    }
                    else if(gowhere==3){
                        greenxInc=2;
                        greenyInc=0;

                    }
                    else if(gowhere==4){
                        greenxInc=0;
                        greenyInc=2;

                    }
                }
                if(greenghostx==240 && greenghosty==320){
                    gowhere=(int)(Math.random()*4+1);
                    if(gowhere==1){
                        greenxInc=-2;
                        greenyInc=0;

                    }
                    else if(gowhere==2){
                        greenxInc=0;
                        greenyInc=-2;

                    }
                    else if(gowhere==3){
                        greenxInc=2;
                        greenyInc=0;

                    }
                    else if(gowhere==4){
                        greenxInc=0;
                        greenyInc=2;

                    }
                }
                if(greenghostx==240 && greenghosty==400){
                    gowhere=(int)(Math.random()*4+1);
                    if(gowhere==1){
                        greenxInc=-2;
                        greenyInc=0;

                    }
                    else if(gowhere==2){
                        greenxInc=0;
                        greenyInc=-2;

                    }
                    else if(gowhere==3){
                        greenxInc=2;
                        greenyInc=0;

                    }
                    else if(gowhere==4){
                        greenxInc=0;
                        greenyInc=2;

                    }
                }
                if(greenghostx==360 && greenghosty==100){
                    gowhere=(int)(Math.random()*4+1);
                    if(gowhere==1){
                        greenxInc=-2;
                        greenyInc=0;

                    }
                    else if(gowhere==2){
                        greenxInc=0;
                        greenyInc=-2;

                    }
                    else if(gowhere==3){
                        greenxInc=2;
                        greenyInc=0;

                    }
                    else if(gowhere==4){
                        greenxInc=0;
                        greenyInc=2;

                    }
                }
                if(greenghostx==120 && greenghosty==100){
                    gowhere=(int)(Math.random()*4+1);
                    if(gowhere==1){
                        greenxInc=-2;
                        greenyInc=0;

                    }
                    else if(gowhere==2){
                        greenxInc=0;
                        greenyInc=-2;

                    }
                    else if(gowhere==3){
                        greenxInc=2;
                        greenyInc=0;

                    }
                    else if(gowhere==4){
                        greenxInc=0;
                        greenyInc=2;

                    }

                }
                if(purpleghostx==240 && purpleghosty==460){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        purplexInc=2;
                        purpleyInc=0;

                    }
                    else if(gowhere==2){
                        purplexInc=0;
                        purpleyInc=-2;

                    }
                    else if(gowhere==3){
                        purplexInc=-2;
                        purpleyInc=0;

                    }
                }
                if(purpleghostx==240 && purpleghosty==0){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        purplexInc=2;
                        purpleyInc=0;

                    }
                    else if(gowhere==2){
                        purplexInc=0;
                        purpleyInc=2;

                    }
                    else if(gowhere==3){
                        purplexInc=-2;
                        purpleyInc=0;

                    }
                }
                if(purpleghostx==480 && purpleghosty==100){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        purplexInc=0;
                        purpleyInc=2;

                    }
                    else if(gowhere==2){
                        purplexInc=0;
                        purpleyInc=-2;

                    }
                    else if(gowhere==3){
                        purplexInc=-2;
                        purpleyInc=0;

                    }
                }
                if(purpleghostx==480 && purpleghosty==200){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        purplexInc=0;
                        purpleyInc=2;

                    }
                    else if(gowhere==2){
                        purplexInc=0;
                        purpleyInc=-2;

                    }
                    else if(gowhere==3){
                        purplexInc=-2;
                        purpleyInc=0;

                    }
                }
                if(purpleghostx==480 && purpleghosty==320){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        purplexInc=0;
                        purpleyInc=2;

                    }
                    else if(gowhere==2){
                        purplexInc=0;
                        purpleyInc=-2;

                    }
                    else if(gowhere==3){
                        purplexInc=-2;
                        purpleyInc=0;

                    }
                }
                if(purpleghostx==20 && purpleghosty==100){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        purplexInc=0;
                        purpleyInc=2;

                    }
                    else if(gowhere==2){
                        purplexInc=0;
                        purpleyInc=-2;

                    }
                    else if(gowhere==3){
                        purplexInc=2;
                        purpleyInc=0;

                    }
                }
                if(purpleghostx==20 && purpleghosty==200){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        purplexInc=0;
                        purpleyInc=2;

                    }
                    else if(gowhere==2){
                        purplexInc=0;
                        purpleyInc=-2;

                    }
                    else if(gowhere==3){
                        purplexInc=2;
                        purpleyInc=0;

                    }
                }
                if(purpleghostx==20 && purpleghosty==320){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        purplexInc=0;
                        purpleyInc=2;

                    }
                    else if(gowhere==2){
                        purplexInc=0;
                        purpleyInc=-2;

                    }
                    else if(gowhere==3){
                        purplexInc=2;
                        purpleyInc=0;

                    }
                }
                if(purpleghostx==240 && purpleghosty==200){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        purplexInc=2;
                        purpleyInc=0;

                    }
                    else if(gowhere==2){
                        purplexInc=0;
                        purpleyInc=2;

                    }
                    else if(gowhere==3){
                        purplexInc=-2;
                        purpleyInc=0;

                    }
                }
                if(purpleghostx==120 && purpleghosty==200){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        purplexInc=2;
                        purpleyInc=0;

                    }
                    else if(gowhere==2){
                        purplexInc=0;
                        purpleyInc=-2;

                    }
                    else if(gowhere==3){
                        purplexInc=-2;
                        purpleyInc=0;

                    }
                }
                if(purpleghostx==360 && purpleghosty==200){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        purplexInc=2;
                        purpleyInc=0;

                    }
                    else if(gowhere==2){
                        purplexInc=0;
                        purpleyInc=-2;

                    }
                    else if(gowhere==3){
                        purplexInc=-2;
                        purpleyInc=0;

                    }
                }
                if(purpleghostx==80 && purpleghosty==320){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        purplexInc=2;
                        purpleyInc=0;

                    }
                    else if(gowhere==2){
                        purplexInc=0;
                        purpleyInc=2;

                    }
                    else if(gowhere==3){
                        purplexInc=-2;
                        purpleyInc=0;

                    }
                }
                if(purpleghostx==400 && purpleghosty==320){
                    gowhere=(int)(Math.random()*3+1);
                    if(gowhere==1){
                        purplexInc=2;
                        purpleyInc=0;

                    }
                    else if(gowhere==2){
                        purplexInc=0;
                        purpleyInc=2;

                    }
                    else if(gowhere==3){
                        purplexInc=-2;
                        purpleyInc=0;

                    }
                }
                if(purpleghostx==360 && purpleghosty==40){
                    gowhere=1;

                    purplexInc=0;
                    purpleyInc=2;

                }
                if(purpleghostx==120 && purpleghosty==40){
                    gowhere=1;

                    purplexInc=0;
                    purpleyInc=2;

                }
                if(purpleghostx==240 && purpleghosty==160){
                    gowhere=1;

                    purplexInc=0;
                    purpleyInc=-2;

                }
                if(purpleghostx==20 && purpleghosty==0){
                    gowhere=(int)(Math.random()*2+1);
                    if(gowhere==1){
                        purplexInc=2;
                        purpleyInc=0;

                    }
                    else if(gowhere==2){
                        purplexInc=0;
                        purpleyInc=2;

                    }

                }
                if(purpleghostx==20 && purpleghosty==460){
                    gowhere=(int)(Math.random()*2+1);
                    if(gowhere==1){
                        purplexInc=2;
                        purpleyInc=0;

                    }
                    else if(gowhere==2){
                        purplexInc=0;
                        purpleyInc=-2;

                    }

                }
                if(purpleghostx==480 && purpleghosty==460){
                    gowhere=(int)(Math.random()*2+1);
                    if(gowhere==1){
                        purplexInc=-2;
                        purpleyInc=0;

                    }
                    else if(gowhere==2){
                        purplexInc=0;
                        purpleyInc=-2;

                    }

                }
                if(purpleghostx==480 && purpleghosty==0){
                    gowhere=(int)(Math.random()*2+1);
                    if(gowhere==1){
                        purplexInc=-2;
                        purpleyInc=0;

                    }
                    else if(gowhere==2){
                        purplexInc=0;
                        purpleyInc=2;

                    }

                }
                if(purpleghostx==400 && purpleghosty==400){
                    gowhere=(int)(Math.random()*2+1);
                    if(gowhere==1){
                        purplexInc=-2;
                        purpleyInc=0;

                    }
                    else if(gowhere==2){
                        purplexInc=0;
                        purpleyInc=-2;

                    }

                }
                if(purpleghostx==80 && purpleghosty==400){
                    gowhere=(int)(Math.random()*2+1);
                    if(gowhere==1){
                        purplexInc=2;
                        purpleyInc=0;

                    }
                    else if(gowhere==2){
                        purplexInc=0;
                        purpleyInc=-2;

                    }

                }
                if(purpleghostx==240 && purpleghosty==100){
                    gowhere=(int)(Math.random()*4+1);
                    if(gowhere==1){
                        purplexInc=-2;
                        purpleyInc=0;

                    }
                    else if(gowhere==2){
                        purplexInc=0;
                        purpleyInc=-2;

                    }
                    else if(gowhere==3){
                        purplexInc=2;
                        purpleyInc=0;

                    }
                    else if(gowhere==4){
                        purplexInc=0;
                        purpleyInc=2;

                    }
                }
                if(purpleghostx==240 && purpleghosty==320){
                    gowhere=(int)(Math.random()*4+1);
                    if(gowhere==1){
                        purplexInc=-2;
                        purpleyInc=0;

                    }
                    else if(gowhere==2){
                        purplexInc=0;
                        purpleyInc=-2;

                    }
                    else if(gowhere==3){
                        purplexInc=2;
                        purpleyInc=0;

                    }
                    else if(gowhere==4){
                        purplexInc=0;
                        purpleyInc=2;

                    }
                }
                if(purpleghostx==240 && purpleghosty==400){
                    gowhere=(int)(Math.random()*4+1);
                    if(gowhere==1){
                        purplexInc=-2;
                        purpleyInc=0;

                    }
                    else if(gowhere==2){
                        purplexInc=0;
                        purpleyInc=-2;

                    }
                    else if(gowhere==3){
                        purplexInc=2;
                        purpleyInc=0;

                    }
                    else if(gowhere==4){
                        purplexInc=0;
                        purpleyInc=2;

                    }
                }
                if(purpleghostx==360 && purpleghosty==100){
                    gowhere=(int)(Math.random()*4+1);
                    if(gowhere==1){
                        purplexInc=-2;
                        purpleyInc=0;

                    }
                    else if(gowhere==2){
                        purplexInc=0;
                        purpleyInc=-2;

                    }
                    else if(gowhere==3){
                        purplexInc=2;
                        purpleyInc=0;

                    }
                    else if(gowhere==4){
                        purplexInc=0;
                        purpleyInc=2;

                    }
                }
                if(purpleghostx==120 && purpleghosty==100){
                    gowhere=(int)(Math.random()*4+1);
                    if(gowhere==1){
                        purplexInc=-2;
                        purpleyInc=0;

                    }
                    else if(gowhere==2){
                        purplexInc=0;
                        purpleyInc=-2;

                    }
                    else if(gowhere==3){
                        purplexInc=2;
                        purpleyInc=0;

                    }
                    else if(gowhere==4){
                        purplexInc=0;
                        purpleyInc=2;

                    }

                }

                pinkghostx+=pinkxInc;
                pinkghosty+=pinkyInc;
                blueghostx+=bluexInc;
                blueghosty+=blueyInc;
                orangeghostx+=orangexInc;
                orangeghosty+=orangeyInc;
                redghostx+=redxInc;
                redghosty+=redyInc;
                whiteghostx+=whitexInc;
                whiteghosty+=whiteyInc;
                yellowghostx+=yellowxInc;
                yellowghosty+=yellowyInc;
                greenghostx+=greenxInc;
                greenghosty+=greenyInc;
                purpleghostx+=purplexInc;
                purpleghosty+=purpleyInc;

            }
        }
        if(level==7){
            g.setFont(new Font("default",Font.BOLD,100));
            g.setColor(Color.YELLOW);
            g.drawRect(30,150,450,110);
            g.drawString("You Win!",40,250);
            g.setFont(new Font("default",Font.BOLD,15));
            g.setColor(Color.RED);
            g.drawRect(290,450,105,30);

            g.drawString("PLAY AGAIN",300,470);
            if(x>=290 && x<=395 && y>=450 && y<=480){
                level=3;

            }
            g.drawRect(30,450,50,30);
            g.drawString("END",40,470);
            if(x>=30 && x<=80 && y>=450 && y<=480){
                level=8;

            }  
        }
        if(level==8){
            setBackground(Color.BLACK);    
        }
    }
}

