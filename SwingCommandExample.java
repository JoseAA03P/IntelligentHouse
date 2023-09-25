import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

interface Command {
    void execute();
    void undo();
}

class LightOnCommand implements Command {
    private JLabel light;

    public LightOnCommand(JLabel light) {
        this.light = light;
    }

    public void execute() {
        light.setBackground(Color.YELLOW);
    }

    public void undo() {
        light.setBackground(Color.LIGHT_GRAY);
    }
}

class LightOffCommand implements Command {
    private JLabel light;

    public LightOffCommand(JLabel light) {
        this.light = light;
    }

    public void execute() {
        light.setBackground(Color.LIGHT_GRAY);
    }

    public void undo() {
        light.setBackground(Color.YELLOW);
    }
}

class GarageOpenCommand implements Command {
    private JLabel garage;

    public GarageOpenCommand(JLabel garage) {
        this.garage = garage;
    }

    public void execute() {
        garage.setBackground(Color.GREEN);
    }

    public void undo() {
        garage.setBackground(Color.LIGHT_GRAY);
    }
}

class GarageCloseCommand implements Command {
    private JLabel garage;

    public GarageCloseCommand(JLabel garage) {
        this.garage = garage;
    }

    public void execute() {
        garage.setBackground(Color.LIGHT_GRAY);
    }

    public void undo() {
        garage.setBackground(Color.GREEN);
    }
}

class FanOnCommand implements Command {
    private JLabel fan;

    public FanOnCommand(JLabel fan) {
        this.fan = fan;
    }

    public void execute() {
        fan.setBackground(Color.BLUE);
    }

    public void undo() {
        fan.setBackground(Color.LIGHT_GRAY);
    }
}

class FanOffCommand implements Command {
    private JLabel fan;

    public FanOffCommand(JLabel fan) {
        this.fan = fan;
    }

    public void execute() {
        fan.setBackground(Color.LIGHT_GRAY);
    }

    public void undo() {
        fan.setBackground(Color.BLUE);
    }
}

class TVOnCommand implements Command {
    private JLabel tv;

    public TVOnCommand(JLabel tv) {
        this.tv = tv;
    }

    public void execute() {
        tv.setBackground(Color.ORANGE);
    }

    public void undo() {
        tv.setBackground(Color.LIGHT_GRAY);
    }
}

class TVOffCommand implements Command {
    private JLabel tv;

    public TVOffCommand(JLabel tv) {
        this.tv = tv;
    }

    public void execute() {
        tv.setBackground(Color.LIGHT_GRAY);
    }

    public void undo() {
        tv.setBackground(Color.ORANGE);
    }
}

class RadioOnCommand implements Command {
    private JLabel radio;

    public RadioOnCommand(JLabel radio) {
        this.radio = radio;
    }

    public void execute() {
        radio.setBackground(Color.PINK);
    }

    public void undo() {
        radio.setBackground(Color.LIGHT_GRAY);
    }
}

class RadioOffCommand implements Command {
    private JLabel radio;

    public RadioOffCommand(JLabel radio) {
        this.radio = radio;
    }

    public void execute() {
        radio.setBackground(Color.LIGHT_GRAY);
    }

    public void undo() {
        radio.setBackground(Color.PINK);
    }
}

class WindowOpenCommand implements Command {
    private JLabel window;

    public WindowOpenCommand(JLabel window) {
        this.window = window;
    }

    public void execute() {
        window.setBackground(Color.CYAN);
    }

    public void undo() {
        window.setBackground(Color.LIGHT_GRAY);
    }
}

class WindowCloseCommand implements Command {
    private JLabel window;

    public WindowCloseCommand(JLabel window) {
        this.window = window;
    }

    public void execute() {
        window.setBackground(Color.LIGHT_GRAY);
    }

    public void undo() {
        window.setBackground(Color.CYAN);
    }
}

public class SwingCommandExample {
    JFrame frame;
    JFrame frame2;
    JPanel panel;

    JPanel panel2;
    Stack<Command> commandHistory = new Stack<>();

    // Declaración de la lista de comandos.
    List<Command> allCommands;
    private boolean buttonActive = false;


    public static void main(String[] args) {
        SwingCommandExample example = new SwingCommandExample();
        example.go();
    }

    public void go() {
        frame = new JFrame();
        frame2 =new JFrame();
        panel = new JPanel();
        panel2= new JPanel();

        // Inicializa la lista de comandos disponibles.
        allCommands = Arrays.asList(
                new LightOnCommand(new JLabel("Light")),
                new LightOffCommand(new JLabel("Light")),
                new GarageOpenCommand(new JLabel("Garage")),
                new GarageCloseCommand(new JLabel("Garage")),
                new FanOnCommand(new JLabel("Fan")),
                new FanOffCommand(new JLabel("Fan")),
                new TVOnCommand(new JLabel("TV")),
                new TVOffCommand(new JLabel("TV")),
                new RadioOnCommand(new JLabel("Radio")),
                new RadioOffCommand(new JLabel("Radio")),
                new WindowOpenCommand(new JLabel("Window")),
                new WindowCloseCommand(new JLabel("Window"))
        );

        JButton lightOnButton = new JButton("Turn Light On");
        JButton lightOffButton = new JButton("Turn Light Off");
        JLabel light = new JLabel("Light");
        light.setOpaque(true);
        light.setBackground(Color.LIGHT_GRAY);

        Command lightOnCommand = new LightOnCommand(light);
        Command lightOffCommand = new LightOffCommand(light);

        lightOnButton.addActionListener(event -> {
            lightOnCommand.execute();
            commandHistory.push(lightOnCommand);
        });

        lightOffButton.addActionListener(event -> {
            lightOffCommand.execute();
            commandHistory.push(lightOffCommand);
        });

        JButton garageOpenButton = new JButton("Open Garage");
        JButton garageCloseButton = new JButton("Close Garage");
        JLabel garage = new JLabel("Garage");
        garage.setOpaque(true);
        garage.setBackground(Color.LIGHT_GRAY);

        Command garageOpenCommand = new GarageOpenCommand(garage);
        Command garageCloseCommand = new GarageCloseCommand(garage);

        garageOpenButton.addActionListener(event -> {
            garageOpenCommand.execute();
            commandHistory.push(garageOpenCommand);
        });

        garageCloseButton.addActionListener(event -> {
            garageCloseCommand.execute();
            commandHistory.push(garageCloseCommand);
        });

        JButton fanOnButton = new JButton("Turn Fan On");
        JButton fanOffButton = new JButton("Turn Fan Off");
        JLabel fan = new JLabel("Fan");
        fan.setOpaque(true);
        fan.setBackground(Color.LIGHT_GRAY);

        Command fanOnCommand = new FanOnCommand(fan);
        Command fanOffCommand = new FanOffCommand(fan);

        fanOnButton.addActionListener(event -> {
            fanOnCommand.execute();
            commandHistory.push(fanOnCommand);
        });

        fanOffButton.addActionListener(event -> {
            fanOffCommand.execute();
            commandHistory.push(fanOffCommand);
        });

        JButton tvOnButton = new JButton("Turn TV On");
        JButton tvOffButton = new JButton("Turn TV Off");
        JLabel tv = new JLabel("TV");
        tv.setOpaque(true);
        tv.setBackground(Color.LIGHT_GRAY);

        Command tvOnCommand = new TVOnCommand(tv);
        Command tvOffCommand = new TVOffCommand(tv);

        tvOnButton.addActionListener(event -> {
            tvOnCommand.execute();
            commandHistory.push(tvOnCommand);
        });

        tvOffButton.addActionListener(event -> {
            tvOffCommand.execute();
            commandHistory.push(tvOffCommand);
        });

        JButton radioOnButton = new JButton("Turn Radio On");
        JButton radioOffButton = new JButton("Turn Radio Off");
        JLabel radio = new JLabel("Radio");
        radio.setOpaque(true);
        radio.setBackground(Color.LIGHT_GRAY);

        Command radioOnCommand = new RadioOnCommand(radio);
        Command radioOffCommand = new RadioOffCommand(radio);

        radioOnButton.addActionListener(event -> {
            radioOnCommand.execute();
            commandHistory.push(radioOnCommand);
        });

        radioOffButton.addActionListener(event -> {
            radioOffCommand.execute();
            commandHistory.push(radioOffCommand);
        });

        JButton windowOpenButton = new JButton("Open Window");
        JButton windowCloseButton = new JButton("Close Window");
        JLabel window = new JLabel("Window");
        window.setOpaque(true);
        window.setBackground(Color.LIGHT_GRAY);

        Command windowOpenCommand = new WindowOpenCommand(window);
        Command windowCloseCommand = new WindowCloseCommand(window);

        windowOpenButton.addActionListener(event -> {
            windowOpenCommand.execute();
            commandHistory.push(windowOpenCommand);
        });

        windowCloseButton.addActionListener(event -> {
            windowCloseCommand.execute();
            commandHistory.push(windowCloseCommand);
        });

        JButton undoButton = new JButton("Undo");
        undoButton.addActionListener(event -> {
            if (!commandHistory.isEmpty()) {
                Command lastCommand = commandHistory.pop();
                lastCommand.undo();
            }
        });

        JButton vacacciones = new JButton("Modo Vacaciones");
        vacacciones.addActionListener(event -> {
            while ( !commandHistory.isEmpty() ) {
                Command lastCommand = commandHistory.pop();
                lastCommand.undo();
            }
        });


        // Botón para iniciar y detener la secuencia de eventos
        JButton pressButtonsButton = new JButton("Activar Modo Fiesta");
        frame.add(pressButtonsButton);

        // Agregar un ActionListener al botón "Press Buttons"
        pressButtonsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Implementa la lógica para iniciar o detener la secuencia de eventos aquí
                if (buttonActive) {
                    // Detener la secuencia de eventos
                    buttonActive = false;
                    pressButtonsButton.setText("Activar Modo Fiesta"); // Restaurar el texto del botón
                } else {
                    // Iniciar la secuencia de eventos
                    buttonActive = true;
                    pressButtonsButton.setText("Stop"); // Cambiar el texto del botón

                    // Inicia la secuencia de eventos en un hilo separado para no bloquear la interfaz de usuario
                    Thread eventThread = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            while (buttonActive) {
                                // Implementa la lógica para simular eventos de botones aquí
                                int randomValue = (int) (Math.random() * 10); // Genera un número aleatorio entre 0 y 9

                                // Implementa la lógica para simular eventos de botones según el valor aleatorio aquí
                                switch (randomValue) {
                                    case 0:
                                        lightOnButton.doClick();
                                        break;
                                    case 1:
                                        garageOpenButton.doClick();
                                        break;
                                    case 2:
                                        fanOnButton.doClick();
                                        break;
                                    case 3:
                                        radioOnButton.doClick();
                                        break;
                                    case 4:
                                        tvOnButton.doClick();
                                        break;
                                    case 5:
                                        windowOpenButton.doClick();
                                        break;
                                    case 6:
                                        lightOffButton.doClick();
                                        break;
                                    case 7:
                                        garageCloseButton.doClick();
                                        break;
                                    case 8:
                                        fanOffButton.doClick();
                                        break;
                                    case 9:
                                        radioOffButton.doClick();
                                        break;
                                    case 10:
                                        windowCloseButton.doClick();
                                        break;
                                    case 11:
                                        undoButton.doClick();
                                        break;
                                    // Agregar casos para otros botones aquí...
                                }

                                try {
                                    Thread.sleep(1000); // Esperar 1 segundo entre eventos
                                } catch (InterruptedException ex) {
                                    ex.printStackTrace();
                                }
                            }
                        }
                    });

                    // Iniciar el hilo de eventos
                    eventThread.start();
                }
            }
        });


        JButton rutina = new JButton("Activar Modo Rutina");
        frame.add(rutina);
        rutina.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                lightOnButton.doClick();

                new Timer(1000, new ActionListener() {
                    private int count = 0;

                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        switch(count) {
                            case 0:
                                garageOpenButton.doClick();
                                break;
                            case 1:
                                fanOnButton.doClick();
                                break;
                            case 2:
                                radioOnButton.doClick();
                                break;
                            case 3:
                                tvOnButton.doClick();
                                break;
                            case 4:
                                windowOpenButton.doClick();
                                break;
                            case 5:
                                lightOffButton.doClick();
                                break;
                            case 6:
                                garageCloseButton.doClick();
                                break;
                            case 7:
                                fanOffButton.doClick();
                                break;
                            case 8:
                                radioOffButton.doClick();
                                break;
                            case 9:
                                windowCloseButton.doClick();
                                // Stop the timer after the last action
                                ((Timer)evt.getSource()).stop();
                                break;
                        }
                        count++;
                    }
                }).start();

            }
        });








        frame.setContentPane(panel);

        panel.add(lightOnButton);
        panel.add(light);
        panel.add(lightOffButton);

        panel.add(garageOpenButton);
        panel.add(garage);
        panel.add(garageCloseButton);

        panel.add(fanOnButton);
        panel.add(fan);
        panel.add(fanOffButton);

        panel.add(tvOnButton);
        panel.add(tv);
        panel.add(tvOffButton);

        panel.add(radioOnButton);
        panel.add(radio);
        panel.add(radioOffButton);

        panel.add(windowOpenButton);
        panel.add(window);
        panel.add(windowCloseButton);

        panel.add(undoButton);
        panel.add(pressButtonsButton);
        panel.add(vacacciones);
        panel.add(rutina);



        frame2.setContentPane(panel2);
        panel2.add(light);
        panel2.add(garage);
        panel2.add(fan);
        panel2.add(tv);
        panel2.add(radio);
        panel2.add(window);





        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 350);
        frame.setVisible(true);

        frame2.pack();
        frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame2.setSize(250, 100);
        frame2.setVisible(true);


}
}