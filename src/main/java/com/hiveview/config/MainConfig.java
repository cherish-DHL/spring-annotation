package com.hiveview.config;

import com.hiveview.bean.Person;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Controller;

//������==�����ļ�
@Configuration  //����Spring����һ��������
@ComponentScan(value = "com.hiveview",includeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class/*, Service.class */})
},useDefaultFilters = false)
@ComponentScans(
        value = {
                @ComponentScan(value = "com.hiveview",includeFilters = {
//                        @ComponentScan.Filter(type = FilterType.ANNOTATION,classes = {Controller.class/*, Service.class */}),
//                        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,classes = {BookService.class}),
                        @ComponentScan.Filter(type = FilterType.CUSTOM,classes = {CustomTypeFilter.class})  //����er��β��
                },useDefaultFilters = false)
        }
)
//@ComponentScans(
//		value = {
//				@ComponentScan(value="com.hiveview",includeFilters = {
//							/*@ComponentScan.Filter(type= FilterType.ANNOTATION,classes={Controller.class})*/
//					@ComponentScan.Filter(type= FilterType.ASSIGNABLE_TYPE,classes={Service.class})
//						/*	@Filter(type=FilterType.CUSTOM,classes={MyTypeFilter.class})*/
//				},useDefaultFilters = false)
//		}
//		)
//@ComponentScan  value:ָ��Ҫɨ��İ�    java8���ǿ���д�����
//excludeFilters = Filter[] ��ָ��ɨ���ʱ����ʲô�����ų���Щ���
//includeFilters = Filter[] ��ָ��ɨ���ʱ��ֻ��Ҫ������Щ���  (����û��������,��Ҫ����Ĭ�ϵĹ��˹���useDefaultFilters = false)
//FilterType.ANNOTATION������ע��
//FilterType.ASSIGNABLE_TYPE�����ո��������ͣ�
//FilterType.ASPECTJ��ʹ��ASPECTJ���ʽ
//FilterType.REGEX��ʹ������ָ��
//FilterType.CUSTOM��ʹ���Զ������ ͨ������true��false�����й���
public class MainConfig {
	
	//��������ע��һ��Bean;����Ϊ����ֵ�����ͣ�idĬ�����÷�������Ϊid
	@Bean("person")
	public Person person01(){
		return new Person("lisi", 20);
	}

}
