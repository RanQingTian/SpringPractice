package test;

public class Alice {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void show() {
        System.out.println("Hello, Alice");
        new Inner().show();
    }

    static class Inner {
        String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void show() {
            System.out.println("Alice Inner");
        }
    }
}



