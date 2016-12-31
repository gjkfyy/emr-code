package pkuhit.xap.ac;

public interface LoginInfo
{
    String getUserId();

    String getUserName();

    void setAttribute(String key, Object attr);

    <T> T getAttribute(String key, Class<T> valueType);
}
