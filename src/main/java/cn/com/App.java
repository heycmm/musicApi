package cn.com;


import com.blade.Blade;

public class App {

    public static void main(String[] args) {
        Blade.of()
                .addStatics("/")
                .enableCors(Boolean.TRUE)
                .start(App.class, args);
    }

}
