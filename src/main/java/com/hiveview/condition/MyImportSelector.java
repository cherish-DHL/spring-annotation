package com.hiveview.condition;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

//自定义逻辑返回需要导入的组件（springboot中使用的非常多）
public class MyImportSelector implements ImportSelector {

	//返回值，就是到导入到容器中的组件全类名
	//AnnotationMetadata:当前标注@Import注解的类的所有注解信息
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		//importingClassMetadata
		//方法不要返回null值,可以返回空数组，否则会报空指针异常
		return new String[]{"com.hiveview.bean.Blue","com.hiveview.bean.Yellow"};
	}

}
