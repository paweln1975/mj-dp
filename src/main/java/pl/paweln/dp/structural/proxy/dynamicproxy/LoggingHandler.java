package pl.paweln.dp.structural.proxy.dynamicproxy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LoggingHandler implements InvocationHandler {
    private static final Logger logger = LoggerFactory.getLogger(Human.class);
    private final Object target;
    private Map<String, Integer> calls = new HashMap<>();

    public LoggingHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String name = method.getName();
        logger.info("Calling method:" + method.getName() + " with parameters:" + Arrays.toString(args));
        if (name.contains("toString")) {
            return calls.toString();
        }
        calls.merge(name, 1, Integer::sum);
        return method.invoke(target, args);
    }

    @SuppressWarnings("unchecked")
    public static <T> T withLogging(T target, Class<T> ift) {
        return (T) Proxy.newProxyInstance(
                    ift.getClassLoader(),
                    new Class<?>[] {ift},
                    new LoggingHandler(target)
        );
    }
}
