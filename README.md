Assignment 1: Builder Pattern - Computer Configuration

Domain

I choose Computer Configuration domain. Computer class has 12 properties: 4 required (cpu, ram, storage, operatingSystem) and 8 optional (gpu, screenSize, wifi, bluetooth, keyboard, mouse, gamingMode, warrantyYears). Computer also has nested object Monitor (brand, size, resolution).

Constraint

If gamingMode is true, computer must have dedicated GPU (not integrated graphics) and RAM must be at least 16GB.

Presets

Three presets are available as static methods:
Computer.budget() - basic computer with integrated graphics
Computer.gaming() - high performance gaming computer
Computer.workstation() - powerful computer for heavy tasks

Project Structure

src/ - main code (Computer.java, Monitor.java, Main.java)
test/ - JUnit tests (ComputerTest.java)
docs/ - UML diagram
report.md - detailed report about design decisions

How to Run

Open project in IntelliJ IDEA
Run Main.java to see example computers created with Builder
Run ComputerTest.java to see all validation tests pass

Example Usage

Computer myComputer = new Computer.Builder("Core i9-13900H", 16, 1024, "Windows 11 pro").gpu("Nvidia RTX 4060").enableWifi().gamingMode(true).build();