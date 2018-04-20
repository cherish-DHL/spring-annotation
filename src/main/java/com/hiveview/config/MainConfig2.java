package com.hiveview.config;

import com.hiveview.bean.Color;
import com.hiveview.bean.ColorFactoryBean;
import com.hiveview.bean.Person;
import com.hiveview.bean.Red;
import com.hiveview.condition.LinuxCondition;
import com.hiveview.condition.MyImportBeanDefinitionRegistrar;
import com.hiveview.condition.MyImportSelector;
import com.hiveview.condition.WindowsCondition;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;

//�������ͳһ���á����㵱ǰ����������������õ�����beanע�������Ч��
@Conditional({WindowsCondition.class})
@Configuration
@Import({Color.class,Red.class,MyImportSelector.class,MyImportBeanDefinitionRegistrar.class})
//@Import���������idĬ���������ȫ����
public class MainConfig2 {
	
	//Ĭ���ǵ�ʵ����
	/**
	 * ConfigurableBeanFactory#SCOPE_PROTOTYPE    
	 * @see ConfigurableBeanFactory#SCOPE_SINGLETON  
	 * @see org.springframework.web.context.WebApplicationContext#SCOPE_REQUEST  request
	 * @see org.springframework.web.context.WebApplicationContext#SCOPE_SESSION	 sesssion
	 * @return\
	 * @Scope:����������
	 * prototype����ʵ���ģ�ioc��������������ȥ���÷�������������������С�
	 * 					ÿ�λ�ȡ��ʱ��Ż���÷�����������
	 * singleton����ʵ���ģ�Ĭ��ֵ����ioc������������÷�����������ŵ�ioc�����С�
	 * 			�Ժ�ÿ�λ�ȡ����ֱ�Ӵ�������map.get()�����ã�
	 * request��ͬһ�����󴴽�һ��ʵ��
	 * session��ͬһ��session����һ��ʵ��
	 * 
	 * �����أ���Ե���bean��˵��
	 * 		��ʵ��bean��Ĭ��������������ʱ�򴴽�����
	 * 		�����أ������������������󡣵�һ��ʹ��(��ȡ)Bean�������󣬲���ʼ����
	 * 
	 */
	@Scope("prototype")
//	@Lazy
	@Bean("person")
	public Person person(){
		System.out.println("������������Person....");
		return new Person("����", 25);
	}
	
	/**
	 * @Conditional({Condition}) �� ����һ�������������жϣ�����������������ע��bean��springboot�ײ����ʹ�õļ�����
	 * 
	 * ���ϵͳ��windows����������ע��("bill")
	 * �����linuxϵͳ����������ע��("linus")
	 */
    @Conditional(WindowsCondition.class)
	@Bean("bill")
	public Person person01(){
		return new Person("Bill Gates",62);
	}

	@Conditional(LinuxCondition.class)
	@Bean("linus")
	public Person person02(){
		return new Person("linus", 48);
	}

	/**
	 * ��������ע�������
	 * 1������ɨ��+�����עע�⣨@Controller/@Service/@Repository/@Component��[�Լ�д����]
	 * 2����@Bean[����ĵ���������������]
	 * 3����@Import[���ٸ������е���һ�����]
	 * 		1����@Import(Ҫ���뵽�����е����)�������оͻ��Զ�ע����������idĬ����ȫ����
	 * 		2����ImportSelector:������Ҫ����������ȫ�������飻
	 * 		3����ImportBeanDefinitionRegistrar:�ֶ�ע��bean��������
	 * 4����ʹ��Spring�ṩ�� FactoryBean������Bean��;
	 * 		1����Ĭ�ϻ�ȡ�����ǹ���bean����getObject�����Ķ���
	 * 		2����Ҫ��ȡ����Bean������������Ҫ��idǰ���һ��&
	 * 			&colorFactoryBean
	 */
	@Bean
	public ColorFactoryBean colorFactoryBean(){
		return new ColorFactoryBean();
	}

	
	
	
	
	

}