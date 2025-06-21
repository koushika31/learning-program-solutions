package BuilderPatternExample;
public class TestBuilder {
    public static void main(String[] args) {
        Computer c1 = new Computer.Builder()
                .setCPU("Intel i3")
                .setRAM("4GB")
                .setStorage("256GB SSD")
                .build();

        Computer c2 = new Computer.Builder()
                .setCPU("Intel i9")
                .setRAM("32GB")
                .setStorage("1TB SSD")
                .setGraphicsCard("NVIDIA RTX 4090")
                .build();

        System.out.println("Basic Computer:");
        c1.showSpecs();
        System.out.println("\nGaming Computer:");
        c2.showSpecs();
    }
}
