package pl.paweln.dp.behavioral.nullobject;

import java.lang.reflect.Proxy;

@SuppressWarnings("unchecked")
public class DynamicNullObject {
    private DynamicNullObject() {}
    public static <T> T noOp (Class<T> itf) {
        return (T) Proxy.newProxyInstance(
          itf.getClassLoader(),
          new Class<?>[] {itf},
                ((proxy, method, args) -> {
                    if (method.getReturnType().equals(Void.TYPE)) {
                        return null;
                    } else {
                        return method.getReturnType().getConstructor().newInstance();
                    }
                })
        );
    }
}
