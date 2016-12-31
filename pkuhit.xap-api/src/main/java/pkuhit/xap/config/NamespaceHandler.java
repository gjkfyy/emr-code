package pkuhit.xap.config;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

public class NamespaceHandler extends NamespaceHandlerSupport
{
    @Override
    public void init()
    {
        registerBeanDefinitionParser("std-bundle",
                new StdBundleBeanDefinitionParser());
    }
}
