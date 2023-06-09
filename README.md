This is a Java program that creates a simple timer application with a GUI interface using Swing components. The timer updates the current time every second and allows the user to change the color of the time label. The program consists of a single class called TimerForm, which extends JFrame and implements ActionListener interface.

The main method of the program presents the user with an option dialog box asking to either open the timer application or close the program.

In the constructor of TimerForm, the title and size of the frame are set, and the default close operation is set to exit the application when the user closes the frame. A JPanel is created to hold the time label and color selection button, and this panel is added to a JDialog. Three buttons for starting, stopping, and resetting the timer are added to another JPanel, which is added to the same JDialog. The JDialog is set to be modal, meaning it will block user input to other windows until closed. The JDialog is then made visible to the user.

The actionPerformed method is implemented to handle events generated by the timer and the color selection button. When the button is pressed, a JColorChooser dialog is displayed, allowing the user to select a new color for the time label. If a color is selected, the previous color of the label is saved, and the label's text color is set to the selected color. If the timer generates an event, the current time is obtained using a SimpleDateFormat object, and the time label is updated. The color of the time label alternates between the selected color and red every second.

The startTimer method creates a new Timer object with a delay of one second, which generates an event every second. The event updates the time label and alternates the color between the selected color and red.

The stopTimer method stops the timer if it is running.

The resetTimer method stops the timer and resets the time label to the current time with the previous color.

Overall, this program provides a basic timer application that allows the user to change the color of the time label and start, stop, and reset the timer.


<img width="263" alt="SCR-20230322-kqif" src="https://user-images.githubusercontent.com/116418444/226978782-71f5fe4a-6b84-439e-a168-c19d968ec186.png">
<img width="249" alt="SCR-20230322-kqjx" src="https://user-images.githubusercontent.com/116418444/226978853-170e09d7-7d50-4c7c-b9a7-777b6204ce65.png">
<img width="249" alt="SCR-20230322-kqoh" src="https://user-images.githubusercontent.com/116418444/226978923-4563779f-c023-4d03-97aa-960a8b43b5ef.png">
<img width="249" alt="SCR-20230322-kqrd" src="https://user-images.githubusercontent.com/116418444/226978936-1e01fd2a-9ea4-487a-85cd-f7a1bd0e9a0e.png">
