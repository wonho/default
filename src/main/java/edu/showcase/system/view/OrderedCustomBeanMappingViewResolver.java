
package edu.showcase.system.view;

import org.springframework.core.Ordered;

public class OrderedCustomBeanMappingViewResolver extends CustomBeanMappingViewResolver implements Ordered {

	@Override
	public int getOrder() {
		return 1;
	}

}
