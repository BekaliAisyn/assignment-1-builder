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

Part E: Clean Code Improvements

Example 1: Avoid Magic Strings

BEFORE:

private String gpu = "Integrated Graphics";
if (gamingMode && gpu.equals("Integrated Graphics")) { ... }

I write same text "Integrated Graphics" two times. If I make mistake in one place, code will not work correct and I don't know why.

AFTER:

private static final String DEFAULT_GPU = "Integrated Graphics";
private String gpu = DEFAULT_GPU;
if (gamingMode && gpu.equals(DEFAULT_GPU)) { ... }

Now I write this text only one time. If I want change it, I change only one place.

Example 2: Small Functions

BEFORE:

public Computer build() {
if (ram <= 0) { throw new IllegalArgumentException("..."); }
if (storage <= 0) { throw new IllegalArgumentException("..."); }
if (cpu == null || cpu.trim().isEmpty()) { throw new IllegalArgumentException("..."); }
if (gamingMode && gpu.equals("Integrated Graphics")) { throw new IllegalArgumentException("..."); }
if (gamingMode && ram < 16) { throw new IllegalArgumentException("..."); }
return new Computer(this);
}

This method too long. It check many different things in one place.

AFTER:

public Computer build() {
validateSingleFields();
validateCrossFieldRules();
return new Computer(this);
}

private void validateSingleFields() {
if (ram <= 0) throw new IllegalArgumentException("RAM must be greater than 0");
if (storage <= 0) throw new IllegalArgumentException("Storage must be greater than 0");
if (cpu == null || cpu.trim().isEmpty()) throw new IllegalArgumentException("CPU cannot be empty");
}

private void validateCrossFieldRules() {
if (gamingMode && gpu.equals(DEFAULT_GPU)) {
throw new IllegalArgumentException("Gaming mode requires a dedicated GPU");
}
if (gamingMode && ram < 16) {
throw new IllegalArgumentException("Gaming mode requires at least 16GB RAM");
}
}

Now build() is short. Easy to read what it do.

Example 3: Meaningful Names

BEFORE:

public Builder wifi(boolean wifi) {
this.wifi = wifi;
return this;
}

Name "wifi" not clear what method do.

AFTER:

public Builder enableWifi() {
this.wifi = true;
return this;
}

Now name "enableWifi" clear what method do.

Part F: Design Decision

Decision: I put validation inside build() method, not inside Computer constructor.

Alternative: I could put validation checks directly in Computer constructor
(private Computer(Builder builder)).

Why I choose build(): If validation is in Computer constructor, Builder can
still create object with bad data before calling constructor. Also, build()
method is place where user finish building object, so it is natural place
to check everything is correct before object is created. This way, Computer
object is never created in bad state - it is either valid, or exception is thrown.