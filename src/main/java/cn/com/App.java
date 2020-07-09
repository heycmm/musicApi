package cn.com;


import cn.com.webHook.AccessHook;
import com.blade.Blade;
public class App {

    public static void main(String[] args) {
        Blade.of()
                .enableCors(Boolean.TRUE)
                .use(new AccessHook())
                .start(App.class, args);
    }

}
