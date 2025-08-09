package FactoryMethodPatternExample;
public class ExcelDocument implements Document {
    public void open() {
        System.out.println("Opening Excel Document");
    }
}
