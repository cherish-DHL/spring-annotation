package com.hiveview.condition;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

//�Զ����߼�������Ҫ��������
public class MyImportSelector implements ImportSelector {

	//����ֵ�����ǵ����뵽�����е����ȫ����
	//AnnotationMetadata:��ǰ��ע@Importע����������ע����Ϣ
	public String[] selectImports(AnnotationMetadata importingClassMetadata) {
		//importingClassMetadata
		//������Ҫ����nullֵ,����ᱨ��ָ���쳣
		return new String[]{"com.hiveview.bean.Blue","com.hiveview.bean.Yellow"};
	}

}
