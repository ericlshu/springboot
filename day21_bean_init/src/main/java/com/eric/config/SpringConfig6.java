package com.eric.config;

import com.eric.bean.MyImportSelector;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

/**
 * Description : 导入实现了ImportSelector接口的类，实现对导入源的编程式处理
 *
 * @author Eric L SHU
 * @date 2022-04-05 21:56
 * @since jdk-11.0.14
 */
// @Configuration
@ComponentScan(basePackages = "com.eric")
@Import({MyImportSelector.class})
public class SpringConfig6
{
}
