package pkuhit.xap.config;

import org.apache.shiro.util.StringUtils;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.ParserContext;
import org.w3c.dom.Element;

import xap.sv.config.AbstractBeanDefinitionParser;

public class StdBundleBeanDefinitionParser extends AbstractBeanDefinitionParser
{
    @Override
    protected AbstractBeanDefinition parseInternal(Element element,
            ParserContext parserContext)
    {
        BeanDefinitionBuilder builder = BeanDefinitionBuilder.rootBeanDefinition("pkuhit.xap.file.converter.FileObjectHttpMessageConverter");
        this.registerComponent(parserContext, "fileObjectHttpMessageConverter",
                builder.getBeanDefinition());

        String dataSource = element.getAttribute("datasource-ref");
        if (StringUtils.hasText(dataSource))
        {
            builder = BeanDefinitionBuilder.rootBeanDefinition("org.springframework.jdbc.core.JdbcTemplate");
            builder.addPropertyReference("dataSource", dataSource);
            this.registerComponent(parserContext, "jdbcTemplate",
                    builder.getBeanDefinition());

            builder = BeanDefinitionBuilder.rootBeanDefinition("pkuhit.me.SimpleDataObjectMetadataRepository");
            builder.setInitMethodName("onStart");
            builder.setDestroyMethodName("onDestory");
            this.registerComponent(parserContext,
                    "simpleDataObjectMetadataRepository",
                    builder.getBeanDefinition());

            builder = BeanDefinitionBuilder.rootBeanDefinition("pkuhit.me.DataObjectServiceImpl");
            builder.addPropertyReference("dataObjectMetadataRepository",
                    "simpleDataObjectMetadataRepository");
            builder.addPropertyReference("jdbcTemplate", "jdbcTemplate");
            this.registerComponent(parserContext, "dataObjectService",
                    builder.getBeanDefinition());

            builder = BeanDefinitionBuilder.rootBeanDefinition("pkuhit.md.SimpleDictionaryQueryService");
            builder.addPropertyReference("dataObjectMetadataRepository",
                    "simpleDataObjectMetadataRepository");
            builder.addPropertyReference("dataObjectService",
                    "dataObjectService");
            this.registerComponent(parserContext,
                    "simpleDictionaryQueryService", builder.getBeanDefinition());

            builder = BeanDefinitionBuilder.rootBeanDefinition("pkuhit.md.DictionaryServiceImpl");
            builder.addPropertyReference("simpleDictionaryQueryService",
                    "simpleDictionaryQueryService");
            builder.addPropertyReference("dataObjectMetadataRepository",
                    "simpleDataObjectMetadataRepository");
            builder.addPropertyReference("dataObjectService",
                    "dataObjectService");
            this.registerComponent(parserContext, "dictionaryService",
                    builder.getBeanDefinition());
        }
        else
        {
            // 支持缓存的字典服务，但是要求上下文中存在对真正字典服务的引用和缓存管理器
            builder = BeanDefinitionBuilder.rootBeanDefinition("pkuhit.md.DictionaryServiceProxy");
            this.registerComponent(parserContext, "dictionaryService",
                    builder.getBeanDefinition());

            // 支持缓存服务元数据,要求上下文中存在对远端元数据服务的引用
            builder = BeanDefinitionBuilder.rootBeanDefinition("pkuhit.me.ServiceMetadataRepositoryProxy");
            this.registerComponent(parserContext,
                    "serviceMetadataRepositoryProxy",
                    builder.getBeanDefinition());
        }
        return null;
    }

    private void registerComponent(ParserContext parserContext,
            String beanName, AbstractBeanDefinition definition)
    {
        xap.sv.config.StdBundleBeanDefinitionParser.registerComponent(
                parserContext, beanName, definition, false);
    }
}
