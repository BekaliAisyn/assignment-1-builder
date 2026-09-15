Problems with Constructor

Problem 1: Too many parameters, easy to make mistake

Computer constructor has 13 parameters. It is very long line of code:

public Computer(String cpu, int ram, int storage, String operatingSystem, String gpu, double screenSize, boolean wifi, boolean bluetooth, boolean keyboard, boolean mouse, boolean gamingMode, int warrantyYears, Monitor monitor)

If I have many parameters same type (5 boolean fields: wifi, bluetooth, keyboard, mouse, gamingMode), it is very easy to put them in wrong order by accident. Java compiler cannot check this, because all parameters are same type (boolean). This is dangerous for big classes.

Problem 2: Hard to understand what each value means

When I create new Computer object, I write:

new Computer("Core i9-13900H", 16, 1024, "Windows 11 pro", "Nvidia RTX 4060", 27.0, true, true, true, true, true, 1, monitor);

Five true values are together. I don't know which true is for wifi, which is for bluetooth, which is for gamingMode. I need to open Computer.java and count parameters every time. This make code hard to read and easy to make mistake.

Problem 3: Cannot skip optional fields

Computer has 4 required fields and 8 optional fields. But constructor need ALL 13 parameters every time, even optional ones. If I don't care about warrantyYears or gamingMode, I still must write some value. There is no way to say use default value for fields I don't need.