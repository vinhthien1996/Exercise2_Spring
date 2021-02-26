package vn.com.tma.nvthien1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext factory = new AnnotationConfigApplicationContext(AppConfig.class);
    	Menu menu = (Menu) factory.getBean("menu");
    	
    	while (true) {
			int choose = menu.getMenu();
			switch (choose) {
				// ADD STUDENT
				case 1: {
					while(true) {					
						boolean rsMenu;
						rsMenu = menu.addStudent();
						
						if (!rsMenu)
							break;
					}
					break;
				}
				
				// SHOW STUDENT
				case 2: {
					menu.showListStudent();
					break;
				}
				
				// FIND STUDENT
				case 3: {
					menu.menuFind();
					break;
				}
			}
		}
    }
}
