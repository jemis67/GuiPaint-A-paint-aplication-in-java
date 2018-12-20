package ml.cs24;


    import java.awt.*;
import java.lang.String;
import java.awt.event.*;
import java.applet.*;



    class GuiPaint extends Frame{
        public String shape;
        Graphics g;
        int oldX,oldY,x2,y2,x3,y3,x1,y1,f1=1,f2=0;

        int mouseX, mouseY;
        public String color;
        Color c[]={Color.black,Color.lightGray,Color.blue,Color.magenta,Color.cyan,Color.orange,Color.darkGray,Color.pink,Color.gray,Color.red,Color.green,Color.white,Color.yellow};
        public int count=0;
        public GuiPaint()
        {
            addWindowListener(new WindowAdapter()
            {
                public void windowClosing(WindowEvent e)
                {
                    System.out.println("Thank U, Window is Now Closed");
                    System.exit(0);
                }
            });

            addMouseListener(new MouseAdapter(){
                public void mousePressed(MouseEvent e){
                    oldX = e.getX();
                    oldY = e.getY();
                    f2=0;
                    //repaint();
                }
                public void mouseReleased(MouseEvent e)
                {
                    mouseX=e.getX();
                    mouseY=e.getY();

                    x1=mouseX;
                    y1=mouseY;
                    repaint();
                    f1=0;
                }

            });
            addMouseMotionListener(new MouseMotionAdapter(){
                public void mouseDragged(MouseEvent e){
                    mouseX = e.getX();
                    mouseY= e.getY();
                    x3=mouseX;
                    y3=mouseY;
                    if(shape.equals("pencil"))
                    {
                        repaint();}
                }
            });

            setLayout(new BorderLayout());


            Panel p = new Panel();

            p.setMaximumSize(new Dimension(100,50));
            Color grey = new Color(220,220,220);
            p.setBackground(grey);

            Color colorb = new Color(204, 235, 255);

            Button b[]=new Button[13];
            String s[]={"black","lgray","blue","magenta","cyan","orange","dgray","pink","gray","red","green","white","yellow"};
            String shapetype[]={"line","circle","rectangle","polygon","pencil"};

            for(int i=0;i<13;i++)
            {

                b[i]=new Button(s[i]);
                b[i].setBackground(c[i]);
                b[i].setForeground(c[i]);
                b[i].setPreferredSize(new Dimension(35,35));
                p.add(b[i]);
                b[i].addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){

                        color="black";
                        color = e.getActionCommand();
                    }});
            }

            Panel p1 = new Panel();

            p1.setMaximumSize(new Dimension(100,50));
            Color grey1 = new Color(240,240,240);
            p1.setBackground(grey1);
            Button b1[]=new Button[5];
            for(int i=0;i<5;i++)
            {

                b1[i]=new Button(shapetype[i]);

                b1[i].setPreferredSize(new Dimension(70,30));
                b1[i].setBackground(colorb);
                b1[i].setForeground(c[0]);
                p1.add(b1[i]);
                b1[i].addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){


                        shape= e.getActionCommand();
                    }});
            }

            add(p, BorderLayout.NORTH);
            add(p1,BorderLayout.SOUTH);

            Panel p3=new Panel();
            p3.setMaximumSize(new Dimension(50,100));
            Color grey2 = new Color(240,240,240);
            p3.setLayout(new BorderLayout());
            p3.setBackground(grey2);


            Button   clearbutton = new Button("clear");
            clearbutton.setPreferredSize(new Dimension(50,50));
            clearbutton.setBackground(colorb);
            clearbutton.setForeground(c[0]);
            p3.add( clearbutton, BorderLayout.NORTH);
            clearbutton.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    color = e.getActionCommand();
                    repaint();
                }});



            Button erase=new Button("Erase");
            erase.setPreferredSize(new Dimension(50,50));
            erase.setBackground(colorb);
            erase.setForeground(c[0]);

            p3.add(erase, BorderLayout.SOUTH);

            erase.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    shape= e.getActionCommand();
                    repaint();


                }});
            add(p3, BorderLayout.WEST);

            Panel p4=new Panel();
            p4.setMaximumSize(new Dimension(50,100));

            p4.setLayout(new BorderLayout());
            p4.setBackground(grey2);

            Button rb = new Button("Close");
            rb.setPreferredSize(new Dimension(50,50));
            rb.setBackground(colorb);
            rb.setForeground(c[0]);
            p4.add(rb, BorderLayout.NORTH);
            rb.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    System.exit(0);
                }});


            Button fillcolor = new Button("fill");
            fillcolor.setPreferredSize(new Dimension(50,50));
            fillcolor.setBackground(colorb);
            fillcolor.setForeground(c[0]);
            p4.add(fillcolor, BorderLayout.SOUTH);
            fillcolor.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent e){
                    shape= e.getActionCommand();
                    repaint();
                }});

            add(p4, BorderLayout.EAST);


        }

        public void update(Graphics g)

        {paint(g);

            if(color.equals("black"))
            {
                count=0;
            }
            else if(color.equals("lgray"))
            {
                count=1;
            }
            else if(color.equals("blue"))
            {
                count=2;
            }
            else if(color.equals("magenta"))
            {
                count=3;
            }
            else if(color.equals("cyan"))
            {
                count=4;
            }
            else if(color.equals("orange"))
            {
                count=5;
            }

            else if(color.equals("dgray"))
            {
                count=6;
            }
            else if(color.equals("pink"))
            {
                count=7;
            }
            else if(color.equals("gray"))
            {
                count=8;
            }
            else if(color.equals("red"))
            {
                count=9;
            }

            else if(color.equals("green"))
            {
                count=10;
            }
            else if(color.equals("white"))
            {
                count=11;
            }
            else if(color.equals("yellow"))
            {
                count=12;
            }
            else{
                g.setColor(c[0]);
            }
            g.setColor(c[count]);

            if(shape.equals("line"))
            {
                if(f1==0)
                {


                    g.drawLine(oldX,oldY,x1,y1);
                    //repaint();
                    //oldX=x1;
                    //oldY=y1;
                }
            }
            if(shape.equals("pencil"))
            {if(g!=null)
            {

                g.fillRect(mouseX,mouseY,3,3);


            }}
            if(shape.equals("Erase"))
            {
                if(g!=null)
                {
                    if(f1==0)

                    {
                        g.setColor(Color.white);
                        g.fillRect(mouseX,mouseY,20,20);
                        repaint();

                    }
                }
            }
            if(shape.equals("circle"))
            {


                if(f1==0)
                    g.drawOval(oldX,oldY,x1-oldX,y1-oldY);
                repaint();
                x1=x2=0;

            }
            if(shape.equals("rectangle"))
            {
                if(f1==0)
                {
                    g.drawRect(oldX,oldY,x1-oldX,y1-oldY);
                    repaint();
                    x1=x2=0;
                }

            }
            if(shape.equals("polygon"))
            {
                //if(f1==0)
                g.drawLine(oldX,oldY,x1,y1);
                oldX=x1;
                oldY=y1;
                repaint();

            }


            if(color.equals("clear"))
            {
                Dimension d = getSize();
                g.setColor(Color.WHITE);
                g.fillRect(0, 0, d.width, d.height);
            }
            if(shape.equals("fill"))
            {
                if(g!=null)
                {
                    if(f1==0)

                    {

                        g.fillRect(mouseX,mouseY,15,15);
                        repaint();
                        //x1=x2=0;
                    }
                }
            }
        }

        public void paint(Graphics g)
        {
            //g.drawString("msg",oldx.oldy);
        }
        public static void main(String[] args) {
            GuiPaint appwin = new GuiPaint();
            appwin.setSize(new Dimension(800, 800));
            appwin.setTitle("GuiPaint");
            appwin.setVisible(true);
        }

    }

