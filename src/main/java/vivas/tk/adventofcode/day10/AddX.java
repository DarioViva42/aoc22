package vivas.tk.adventofcode.day10;

record AddX(int x) implements Instruction {

    @Override
    public int runOnCpu(Cpu cpu) {
        int strength = cpu.tick() + cpu.tick();
        cpu.addToRegister(x);
        return strength;
    }
}